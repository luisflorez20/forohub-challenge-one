package com.challenge.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(

        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico status,
        DatosAutorTopico autor,
        String curso
) {
    public DatosRespuestaTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                new DatosAutorTopico(topico.getAutor()),
                topico.getCurso()
        );
    }
}
