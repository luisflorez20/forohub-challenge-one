🗣️ ForoHub - API REST

📝 Descripción
ForoHub es una API REST desarrollada con Spring Boot que replica las funcionalidades básicas de un foro. Permite a los usuarios crear tópicos, responder preguntas y gestionar contenido de manera segura mediante autenticación JWT.
✨ Características

🔐 Autenticación JWT - Sistema de login seguro
📝 CRUD Completo - Crear, leer, actualizar y eliminar tópicos
👥 Gestión de Usuarios - Registro y autenticación
🗄️ Base de Datos MySQL - Persistencia de datos confiable
📄 Documentación Swagger - API documentada automáticamente
🛡️ Seguridad - Endpoints protegidos y validaciones
📋 Paginación - Listados eficientes
🔍 Filtros - Búsqueda por curso

🛠️ Tecnologías Utilizadas

Backend: Java 17, Spring Boot 3.2.8
Seguridad: Spring Security, JWT
Base de Datos: MySQL, JPA/Hibernate
Migraciones: Flyway
Documentación: SpringDoc OpenAPI (Swagger)
Build: Maven

🚀 Instalación y Configuración
Prerrequisitos

Java 17 o superior
Maven 3.6+
MySQL 8.0+
IDE (IntelliJ IDEA, VS Code, Eclipse)

1. Clonar el repositorio
   bashgit clone https://github.com/luisflorez20/forohub-challenge-one
   cd forohub
2. Configurar base de datos
   sqlCREATE DATABASE forohub;
3. Configurar application.properties
   propertiesspring.datasource.url=jdbc:mysql://localhost:3306/forohub
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
4. Ejecutar la aplicación
   bashmvn spring-boot:run
   La aplicación estará disponible en: http://localhost:8080
   📚 Documentación API
   Una vez ejecutada la aplicación, accede a la documentación interactiva:
   Swagger UI: http://localhost:8080/swagger-ui.html
   🔑 Endpoints Principales
   Autenticación

POST /login - Iniciar sesión
POST /registro - Registrar nuevo usuario

Tópicos

GET /topicos - Listar tópicos (público)
POST /topicos - Crear tópico (requiere auth)
GET /topicos/{id} - Ver tópico específico
PUT /topicos/{id} - Actualizar tópico (solo autor)
DELETE /topicos/{id} - Eliminar tópico (solo autor)

👤 Usuario de Prueba
Para probar la aplicación, puedes usar:

Email: demo@forohub.com
Contraseña: 123456

🧪 Ejemplo de Uso
1. Login
   bashcurl -X POST http://localhost:8080/login \
   -H "Content-Type: application/json" \
   -d '{
   "email": "demo@forohub.com",
   "password": "123456"
   }'
2. Crear Tópico
   bashcurl -X POST http://localhost:8080/topicos \
   -H "Authorization: Bearer tu-jwt-token" \
   -H "Content-Type: application/json" \
   -d '{
   "titulo": "Mi primer tópico",
   "mensaje": "Este es el contenido de mi tópico",
   "curso": "Spring Boot"
   }'
   src/main/java/com/challenge/forohub/
   ├── controller/          # Controladores REST
   ├── domain/             # Entidades y lógica de negocio
   │   ├── topico/        # Dominio de tópicos
   │   └── usuario/       # Dominio de usuarios
   └── infra/             # Configuración e infraestructura
   ├── security/      # Configuración JWT y seguridad
   └── errores/       # Manejo global de errores

src/main/resources/
├── db/migration/      # Scripts Flyway
└── application.properties

🤝 Contribución

Fork el proyecto
Crea una rama para tu feature (git checkout -b feature/AmazingFeature)
Commit tus cambios (git commit -m 'Add some AmazingFeature')
Push a la rama (git push origin feature/AmazingFeature)
Abre un Pull Request

📝 Licencia
Este proyecto está bajo la Licencia MIT - ver el archivo LICENSE.md para más detalles.
👨‍💻 Autor
Luis Florez - luisflorez20@yahoo.com
Proyecto Link: https://github.com/luisflorez20/forohub

⭐ ¡No olvides darle una estrella al repo si te gustó el proyecto!
