package com.challenge.forohub.domain.topico.validaciones;

import com.challenge.forohub.domain.topico.DatosRegistroTopico;
import com.challenge.forohub.domain.topico.TopicoRepository;
import com.challenge.forohub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoDuplicado {

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DatosRegistroTopico datos) {
        var topicoDuplicado = topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if (topicoDuplicado) {
            throw new ValidacionDeIntegridad("Ya existe un tópico con el mismo título y mensaje");
        }
    }
}
