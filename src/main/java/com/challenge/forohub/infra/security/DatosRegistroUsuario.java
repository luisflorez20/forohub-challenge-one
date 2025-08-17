package com.challenge.forohub.infra.security;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// DTO para registro de usuario
public record DatosRegistroUsuario(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotBlank(message = "El email es obligatorio")
        @Email(message = "Formato de email inválido")
        String email,

        @NotBlank(message = "La contraseña es obligatoria")
        String password
) {
}
