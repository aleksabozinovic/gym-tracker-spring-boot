package com.training.trainingapp.config;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.training.trainingapp.model.UserEntity;
import com.training.trainingapp.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {

        String username = authentication.getName();
        Optional<UserEntity> user = userService.findUserByUsername(username);

        if (user.isPresent()) {
            String redirectUrl = user.get().getId() + "/user";
            response.sendRedirect(redirectUrl);
        } else {
            response.sendRedirect("/login?error=true");
        }
    }

}
