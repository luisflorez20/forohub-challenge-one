package com.challenge.forohub.domain.topico;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAll(Pageable paginacion);

    @Query("SELECT t FROM Topico t WHERE t.curso = :curso ORDER BY t.fechaCreacion DESC")
    Page<Topico> findByCurso(@Param("curso") String curso, Pageable paginacion);

    @Query("SELECT t FROM Topico t WHERE t.autor.id = :autorId ORDER BY t.fechaCreacion DESC")
    Page<Topico> findByAutorId(@Param("autorId") Long autorId, Pageable paginacion);

    // Validación para evitar tópicos duplicados
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}
