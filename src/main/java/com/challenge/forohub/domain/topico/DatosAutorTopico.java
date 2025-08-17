package com.challenge.forohub.domain.topico;

import com.challenge.forohub.domain.usuario.Usuario;

public record DatosAutorTopico(
        Long id,
        String nombre,
        String email
) {
    public DatosAutorTopico(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail());
    }
}
