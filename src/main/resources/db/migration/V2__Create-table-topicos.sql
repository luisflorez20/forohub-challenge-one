CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL DEFAULT 'ABIERTO',
    autor_id BIGINT NOT NULL,
    curso VARCHAR(100) NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (autor_id) REFERENCES usuarios(id) ON DELETE CASCADE,

    INDEX idx_curso (curso),
    INDEX idx_fecha_creacion (fecha_creacion),
    INDEX idx_status (status),
    INDEX idx_autor_id (autor_id),
    INDEX idx_titulo (titulo)
);