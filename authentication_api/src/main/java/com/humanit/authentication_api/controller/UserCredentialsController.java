package com.humanit.authentication_api.controller;

import com.humanit.authentication_api.dto.AuthRequestDTO;
import com.humanit.authentication_api.dto.AuthResponseDTO;
import com.humanit.authentication_api.dto.RefreshTokenRequestDTO;
import com.humanit.authentication_api.exception.refreshToken.RefreshTokenNotFoundException;
import com.humanit.authentication_api.exception.userCredentials.UserCredentialsNotAuthenticatedException;
import com.humanit.authentication_api.service.UserCredentialsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication API", description = "Operations for user authentication and token management.")
public class UserCredentialsController {
    private final UserCredentialsService userService;

    @Operation(
            summary = "Authenticate user and generate token",
            description = "Validates user credentials and returns a JWT token along with a refresh token.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Authentication successful, token generated."),
                    @ApiResponse(responseCode = "401", description = "Authentication failed. Invalid username or password.")
            }
    )
    @PostMapping("/signIn")
    public ResponseEntity<AuthResponseDTO> signIn(@RequestBody AuthRequestDTO authRequestDTO)
            throws UserCredentialsNotAuthenticatedException {
        return ResponseEntity.ok(userService.signIn(authRequestDTO));
    }

    @Operation(
            summary = "Refresh JWT token",
            description = "Generates a new JWT token using a valid refresh token.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Token refreshed successfully."),
                    @ApiResponse(responseCode = "404", description = "Refresh token not found or invalid.")
            }
    )
    @PostMapping("/refreshToken")
    public ResponseEntity<AuthResponseDTO> refreshToken(@RequestBody RefreshTokenRequestDTO refreshRequestDTO)
            throws RefreshTokenNotFoundException {
        return ResponseEntity.ok(userService.refreshToken(refreshRequestDTO));
    }
}