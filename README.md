# Biblioteca UNTEC

Aplicación web para la gestión de préstamos de libros desarrollada con **Java Servlets, JSP y Bootstrap**.
El sistema permite la creación de dos tipos de usuarios:
* Estudiantes: Pueden consultar el catálogo de libros, agregarlos a un carrito de préstamo y gestionar su historial de préstamos.
* Trabajadores: Además de todas las funcionalidades ya mencionadas, pueden agregar y editar libros.

Este proyecto fue desarrollado como parte de la práctica de desarrollo de aplicaciones web utilizando **arquitectura MVC básica con Servlets y JSP**.

---

# Funcionalidades

### Autenticación de usuarios

* Registro de nuevos usuarios.
* Inicio y cierre de sesión.
* Manejo de sesiones para mantener la autenticación.

### Gestión de libros

* Visualización del catálogo de libros.
* Agregar libros al carrito de préstamo.
* Visualización solo de libros disponibles.

### Carrito de préstamos

* Agregar libros al carrito antes de confirmar el préstamo.
* Evitar duplicar libros en el carrito.
* Eliminar libros del carrito.

### Gestión de préstamos

* Confirmar préstamo de varios libros a la vez.
* Visualizar historial de préstamos.
* Mostrar los títulos asociados a cada préstamo.

### Funcionalidades para trabajadores

* Agregar nuevos libros al sistema.
* Editar información de libros.
* Eliminar libros con confirmación mediante modal.

### Interfaz de usuario

* Interfaz desarrollada con **Bootstrap**.
* Barra de navegación.
* Tarjetas para mostrar historial de préstamos.
* Modal de confirmación para eliminación.

---

# Tecnologías utilizadas

* **Java**
* **Servlets (Jakarta)**
* **JSP**
* **MySQL**
* **Bootstrap**
* **Apache Tomcat**

El sistema se ejecuta sobre **Apache Tomcat** y utiliza **MySQL** como base de datos.

---

# Arquitectura del proyecto

El proyecto sigue una estructura inspirada en **MVC**:

```
controlador/
    Servlets (Login, Libros, Préstamos)

dao/
    Interfaces de acceso a datos

daoimpl/
    Implementaciones de acceso a datos

modelo/
    Clases de dominio (Libro, Usuario, Prestamo)

webapp/
    JSPs y recursos de la interfaz
```

---

# Instalación y ejecución

## Requisitos

* Java 17 o superior
* Apache Tomcat 10+
* MySQL 8+

## Configuración

1. Crear la base de datos:

```sql
CREATE DATABASE biblioteca;
```

2. Ejecutar el script incluido en (creación de tablas):

```
sql/DDL.sql
```
* Opcional: ejecutar el script incluido en (creación de libros y usuarios de prueba):

```
sql/DML.sql
```

3. Configurar las credenciales de base de datos en:

```
ConexionDB.java
```

4. Desplegar el archivo `.war` en Tomcat o ejecutar el proyecto desde el IDE.

---

# Usuarios de prueba

Trabajador

```
email: profesor@untec.com
password: 1234
```

Estudiante

```
email: estudiante@untec.cl
password: 1234
```

---

# Muestra de pantallas:

## Pantalla de registro de usuario
<img width="1088" height="588" alt="Pantalla_registro" src="https://github.com/user-attachments/assets/752ef0c8-613d-4fa1-8a06-505f7b47db01" />

## Tipos de usuarios disponibles
<img width="510" height="164" alt="Tipo_usuario" src="https://github.com/user-attachments/assets/021f3d34-3154-4a5d-9a0d-6662649a0a29" />


## Ejemplo de credenciales incorrectas en login
<img width="1098" height="562" alt="Credenciales_incorrectas" src="https://github.com/user-attachments/assets/936beac4-0c5d-4e93-9248-1a868b801531" />

## Panel de estudiante
<img width="1099" height="501" alt="Panel_estudiante" src="https://github.com/user-attachments/assets/a6f4171a-a407-4ba8-bf5b-a48aa4800c65" />

## Inclusión de libros en préstamo
<img width="1097" height="703" alt="Prestamo_inicial" src="https://github.com/user-attachments/assets/29d27817-d8b0-4682-910d-8be8a1363995" />

## Carrito
<img width="1095" height="418" alt="Carrito" src="https://github.com/user-attachments/assets/1d3ab346-b1e1-4c85-a302-22d99e35e79c" />

## Préstamo activo
<img width="1096" height="451" alt="Prestamo_activo" src="https://github.com/user-attachments/assets/169168a1-acc5-4f29-8ecb-25409975fc6c" />

## Préstamo devuelto
<img width="1095" height="432" alt="Prestamo_devuelto" src="https://github.com/user-attachments/assets/9c401283-faf5-4df2-9155-050eb40ee5c2" />

## Panel de trabajador
<img width="1090" height="466" alt="Panel_trabajador" src="https://github.com/user-attachments/assets/0d81b378-3463-4e35-9153-e81db56847f9" />

## Agregar libro
<img width="1093" height="451" alt="Agregar_libro" src="https://github.com/user-attachments/assets/b4350ea5-1e0c-4143-aabb-8f3ed98cbf06" />

## Ejemplo de campo incompleto
<img width="1089" height="450" alt="AL_campo_incompleto" src="https://github.com/user-attachments/assets/b57fa5bd-b74c-485e-bbd3-103c6022bdd2" />

## Editar libro
<img width="1090" height="414" alt="Editar_libro" src="https://github.com/user-attachments/assets/13be6923-0e61-4de4-a1ab-f22e220aa83c" />

## Modal de eliminación
<img width="1427" height="501" alt="Modal_eliminacion" src="https://github.com/user-attachments/assets/2a9d451c-5f94-4336-9b92-767feedd4d5a" />

---

# Posibles mejoras futuras

* Implementar validación avanzada de formularios.
* Añadir paginación al catálogo de libros.
* Implementar roles y permisos más detallados.
* Migrar la aplicación a **Spring Boot**.
* Implementar API REST para integración con frontend moderno.

---

# Licencia

Este proyecto fue desarrollado con fines educativos y de aprendizaje.
