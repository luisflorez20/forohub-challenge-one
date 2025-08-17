package com.challenge.forohub.domain.topico;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record DatosRegistroTopico(


        @NotBlank(message = "El título es obligatorio")
        @Size(min = 5, max = 255, message = "El título debe tener entre 5 y 255 caracteres")
                String titulo,

        @NotBlank(message = "El mensaje es obligatorio")
        @Size(min = 10, message = "El mensaje debe tener al menos 10 caracteres")
        String mensaje,

        @NotBlank(message = "El curso es obligatorio")
        @Size(max = 100, message = "El curso no puede tener más de 100 caracteres")
        String curso
) {
}
