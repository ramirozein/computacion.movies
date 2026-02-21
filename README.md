# Movie Application

¡Bienvenido a **Movie Application**! Una plataforma robusta y moderna para la gestión de contenido cinematográfico, construida con el poder de Java y el ecosistema de Spring.

## Características Principales

* **Gestión de Películas**: Permite administrar un catálogo completo incluyendo títulos, géneros, trailers y descripciones detalladas.
* **Sistema de Usuarios**: Control de acceso con roles definidos y almacenamiento seguro de credenciales.
* **Seguridad Avanzada**: Implementación de Spring Security para proteger los recursos y gestionar la autenticación mediante BCrypt.
* **API REST**: Endpoints optimizados para la recuperación de datos de películas en formato JSON.
* **Interfaz Web**: Plantillas dinámicas integradas para una experiencia de usuario fluida.

## Tecnologías Utilizadas

* **Backend**: Java con **Spring Boot**.
* **Seguridad**: **Spring Security** para autenticación y autorización.
* **Persistencia**: **Spring Data JPA** con soporte para entidades relacionales.
* **Base de Datos**: Configuración flexible mediante `application.properties`.
* **Frontend**: Integración con vistas y controladores web tradicionales.

## Estructura del Proyecto

```text
src/main/java/computacion/movie/
├── config/           # Configuraciones de Seguridad y Datos
├── domain/           # Lógica de negocio y servicios
├── persistence/      # Entidades (Pelicula, Usuario, Genero) y Repositorios
└── web/              # Controladores de la API y Vistas
