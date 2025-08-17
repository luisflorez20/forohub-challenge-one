package com.challenge.forohub.infra.security;

// DTO para respuesta de autenticacion
public record DatosJWTToken(
        String token,
        String tipo,
        Long expiresIn
) {
    public DatosJWTToken(String token, Long expiresIn) {
        this("Bearer", token, expiresIn);
    }
}
