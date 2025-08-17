-- Insertar usuario de prueba
-- Password encriptado para "123456": $2a$10$Xvkj5J8n6Y2RgzPDM3n8YOSKrWQYx8JQb6PL2oN9FpR3zN6VfQ5K.
INSERT INTO usuarios (nombre, email, password, activo) VALUES
('Usuario Demo', 'demo@forohub.com', '$2a$10$Xvkj5J8n6Y2RgzPDM3n8YOSKrWQYx8JQb6PL2oN9FpR3zN6VfQ5K.', 1),
('Ana García', 'ana@example.com', '$2a$10$Xvkj5J8n6Y2RgzPDM3n8YOSKrWQYx8JQb6PL2oN9FpR3zN6VfQ5K.', 1),
('Carlos López', 'carlos@example.com', '$2a$10$Xvkj5J8n6Y2RgzPDM3n8YOSKrWQYx8JQb6PL2oN9FpR3zN6VfQ5K.', 1);

-- Insertar tópicos de prueba
INSERT INTO topicos (titulo, mensaje, fecha_creacion, status, autor_id, curso) VALUES
('¿Cómo empezar con Spring Boot?',
 'Hola, soy nuevo en Spring Boot y me gustaría saber cuáles son los primeros pasos para crear una aplicación web. ¿Podrían recomendarme algunos recursos y buenas prácticas para comenzar?',
 '2024-01-15 10:30:00',
 'ABIERTO',
 1,
 'Spring Boot'),

('Dudas sobre JPA y Hibernate',
 'Tengo problemas para entender las relaciones entre entidades en JPA. ¿Alguien puede explicarme la diferencia entre @OneToMany y @ManyToOne? También tengo dudas sobre el lazy loading.',
 '2024-01-14 15:45:00',
 'ABIERTO',
 2,
 'Java Persistence API'),

('Configuración de seguridad con JWT',
 'Estoy implementando autenticación JWT en mi proyecto Spring Boot pero me da error 403. Mi configuración parece correcta pero no puedo acceder a los endpoints protegidos. ¿Qué podría estar mal?',
 '2024-01-13 09:20:00',
 'SOLUCIONADO',
 3,
 'Spring Security'),

('Validaciones en Spring Boot',
 'Me gustaría saber cómo implementar validaciones personalizadas usando Bean Validation. Necesito validar que un campo no sea duplicado en la base de datos.',
 '2024-01-12 14:10:00',
 'ABIERTO',
 1,
 'Spring Boot'),

('Manejo de excepciones globales',
 'Estoy buscando la mejor manera de manejar excepciones de forma global en mi aplicación Spring Boot. ¿Recomiendan usar @ControllerAdvice?',
 '2024-01-11 11:55:00',
 'CERRADO',
 2,
 'Spring Boot');