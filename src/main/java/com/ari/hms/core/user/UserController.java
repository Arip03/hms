package com.ari.hms.core.user;

import com.ari.hms.core.user.dto.request.TokenDto;
import com.ari.hms.core.user.dto.response.ProfileUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyToken(@RequestBody TokenDto token) {
        try {
            return ResponseEntity.ok(userService.verifyUser(token.getToken()));
        } catch (BadCredentialsException c){
            return ResponseEntity.status(401).body("Invalid token");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileUserDto> getUserProfileById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userService.getProfileUserById(id));
    }
}
