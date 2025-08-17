package com.challenge.forohub.controller;

import com.challenge.forohub.domain.topico.*;
import com.challenge.forohub.domain.usuario.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/topicos")
@CrossOrigin(origins = "*")
@Tag(name = "Tópicos", description = "CRUD de tópicos del foro")

public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    @Operation(summary = "Obtener lista de tópicos", description = "Retorna una lista paginada de todos los tópicos ordenados por fecha de creación")
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(
            @PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.DESC)
            Pageable paginacion,
            @RequestParam(required = false) String curso) {

        Page<DatosListadoTopico> topicos;

        if (curso != null && !curso.isEmpty()) {
            topicos = topicoRepository.findByCurso(curso, paginacion)
                    .map(DatosListadoTopico::new);
        } else {
            topicos = topicoRepository.findAll(paginacion)
                    .map(DatosListadoTopico::new);
        }

        return ResponseEntity.ok(topicos);
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Crear nuevo tópico", description = "Crea un nuevo tópico en el foro")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(
            @RequestBody @Valid DatosRegistroTopico datos,
            @AuthenticationPrincipal Usuario autor,
            UriComponentsBuilder uriBuilder) {

        // Verificar duplicados
        if (topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            return ResponseEntity.badRequest().build();
        }

        var topico = new Topico(datos.titulo(), datos.mensaje(), autor, datos.curso());
        topicoRepository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosRespuestaTopico(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornarDatosTopico(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(
            @PathVariable Long id,
            @RequestBody @Valid DatosActualizarTopico datos,
            @AuthenticationPrincipal Usuario usuario) {

        var topico = topicoRepository.getReferenceById(id);

        // Verificar que el usuario sea el autor del tópico
        if (!topico.esAutor(usuario)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        topico.actualizar(datos);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminarTopico(
            @PathVariable Long id,
            @AuthenticationPrincipal Usuario usuario) {

        var topico = topicoRepository.getReferenceById(id);

        // Verificar que el usuario sea el autor del tópico
        if (!topico.esAutor(usuario)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }
}
