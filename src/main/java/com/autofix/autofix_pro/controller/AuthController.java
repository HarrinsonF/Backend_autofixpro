package com.autofix.autofix_pro.controller;

import com.autofix.autofix_pro.security.JwtUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final JwtUtils jwtUtils;

    public AuthController(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
        String email = credenciales.get("email");
        String password = credenciales.get("password");

        if ("admin@autofixpro.com".equals(email) && "admin123".equals(password)) {
            String token = jwtUtils.generarToken(email, "ADMIN");
            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "tipo", "Bearer",
                    "rol", "ADMIN",
                    "usuario", email
            ));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "Credenciales inválidas"));
    }
}
