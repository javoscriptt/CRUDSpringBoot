# Sistema de Gestión de Proyectos y Tareas

Aplicación web desarrollada con Spring Boot que permite gestionar proyectos y sus tareas asociadas, implementando operaciones CRUD completas y autenticación de usuarios.

## 🚀 Características

- Gestión completa de proyectos (Crear, Leer, Actualizar, Eliminar)
- Gestión de tareas asociadas a cada proyecto
- Sistema de autenticación de usuarios
- Interfaz responsive con Bootstrap
- Persistencia de datos con MySQL

## 🛠️ Tecnologías Utilizadas

- **Spring Boot 3.x**
- **Spring Security** - Para autenticación y autorización
- **Spring Data JPA** - Para la persistencia de datos
- **Thymeleaf** - Motor de plantillas
- **MySQL** - Base de datos
- **Bootstrap 4** - Framework CSS
- **Font Awesome** - Para iconos

## 📋 Requisitos Previos

- Java 17 o superior
- MySQL 8.0
- Maven

## 🔧 Configuración

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/javoscriptt/CRUDSpringBoot.git
   ```

2. **Configurar la base de datos**
   - Crear una base de datos MySQL llamada `gestion_proyectos`
   - Actualizar `application.properties` con tus credenciales:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/gestion_proyectos
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
     ```

3. **Ejecutar la aplicación**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Acceder a la aplicación**
   - URL: http://localhost:8080
   - Crear una cuenta nueva o usar las credenciales de prueba

## 📱 Funcionalidades

### Proyectos
- Crear nuevos proyectos
- Ver lista de proyectos
- Ver detalles de cada proyecto
- Actualizar información de proyectos
- Eliminar proyectos

### Tareas
- Crear tareas asociadas a proyectos
- Ver tareas de cada proyecto
- Actualizar estado de tareas
- Eliminar tareas

### Usuarios
- Registro de nuevos usuarios
- Inicio de sesión
- Gestión de sesiones

## 🔒 Seguridad
- Autenticación basada en formularios
- Protección contra CSRF
- Encriptación de contraseñas
- Manejo de sesiones

## 🎨 Interfaz de Usuario
- Diseño responsive
- Temas de Bootstrap personalizados
- Iconos de Font Awesome
- Formularios validados
- Mensajes de feedback para el usuario

## 📝 Notas
- Proyecto desarrollado como parte de una actividad evaluativa
- Implementa relaciones 1:N entre Proyectos y Tareas
- Sigue las mejores prácticas de Spring Boot
