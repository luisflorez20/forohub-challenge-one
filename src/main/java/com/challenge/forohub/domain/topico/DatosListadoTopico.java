package com.challenge.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(

        Long id,
        String titulo,
        String mensajeResumen,
        LocalDateTime fechaCreacion,
        StatusTopico status,
        String autorNombre,
        String curso
) {
    public DatosListadoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                truncarMensaje(topico.getMensaje()),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso()
        );
    }

    private static String truncarMensaje(String mensaje) {
        return mensaje.length() > 100 ? mensaje.substring(0, 100) + "..." : mensaje;
    }
}
