package com.ari.hms.core.auth;

import com.ari.hms.config.security.services.jwt.JwtService;
import com.ari.hms.config.security.user.SecurityUser;
import com.ari.hms.core.auth.dto.request.LoginRequestDto;
import com.ari.hms.core.auth.dto.response.AuthenticationResponse;
import com.ari.hms.core.user.User;
import com.ari.hms.core.user.UserRepository;
import com.ari.hms.core.user.commons.UserMapper;
import com.ari.hms.core.user.dto.request.CreateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthServiceImpl(UserMapper userMapper, UserRepository userRepository, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationResponse authenticate(LoginRequestDto request) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(), request.getPassword()));
        } catch (Exception e) {
            System.out.println("Authentication failed for user: {}" + request.getUsername() + e);
            throw e;
        }

        User user = userRepository.findUserByUsername(request.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException(request.getUsername() + " not found"));

        UserDetails userDetails = new SecurityUser(user);
        String jwtToken = jwtService.generateToken(userDetails);

        return AuthenticationResponse.builder().token(jwtToken).role(user.getRole()).build();
    }

    @Override
    public AuthenticationResponse create(CreateUserDto createUser) {

        User user = userMapper.map(createUser);
        user.setPassword(passwordEncoder.encode(createUser.getPassword()));

        userRepository.save(user);

        UserDetails userDetails = new SecurityUser(user);
        String jwtToken = jwtService.generateToken(userDetails);

        return new AuthenticationResponse(jwtToken, user.getRole());
    }
}
