package com.ari.hms.config.security;


import com.ari.hms.config.security.user.SecurityUser;
import com.ari.hms.core.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SecurityContext {

    public static Long getCurrentUserId() {
        return Objects.requireNonNull(getCurrentContext()).getId();
    }

    public static String getUsername() {
        return Objects.requireNonNull(getCurrentContext()).getUsername();
    }

    public static User getCurrentUser() {
        return getCurrentContext();
    }

    private static User getCurrentContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof SecurityUser)
                return ((SecurityUser) principal).getUser();
        }
        return null;
    }
}