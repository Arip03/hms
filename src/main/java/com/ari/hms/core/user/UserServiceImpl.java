package com.ari.hms.core.user;

import com.ari.hms.config.security.services.database.JpaUserDetailsService;
import com.ari.hms.config.security.services.jwt.JwtService;
import com.ari.hms.core.commons.exception.BadRequestException;
import com.ari.hms.core.user.commons.UserMapper;
import com.ari.hms.core.user.dto.request.UserDataDto;
import com.ari.hms.core.user.dto.response.ProfileUserDto;
import com.ari.hms.core.user.dto.response.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final JpaUserDetailsService jpaUserDetailsService;

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserServiceImpl(UserMapper userMapper, JpaUserDetailsService jpaUserDetailsService, UserRepository userRepository, JwtService jwtService) {
        this.userMapper = userMapper;
        this.jpaUserDetailsService = jpaUserDetailsService;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public UserDataDto verifyUser(String token){
        User user = userRepository.findUserByUsername(jwtService.extractUsername(token)).orElseThrow(
                () -> new BadRequestException("User dosen't exist"));

        UserDetails userDetails = jpaUserDetailsService.loadUserByUsername(user.getUsername());
        boolean isValid = jwtService.isTokenValid(token, userDetails);

        if (isValid) {
            return new UserDataDto(user.getUsername(), user.getRole());
        } else {
            throw new BadCredentialsException("User is not Valid");
        }
    }

    public ProfileUserDto getProfileUserById(String token){
        return userRepository.getProfileUserById(jwtService.extractUsername(token)).orElseThrow(
                () -> new BadRequestException("This user dosen't exist")
        );
    }

    public List<UserDto> getAllDoctors(){
        return userRepository.findUsersByRole(Role.DOCTOR);
    }
}
