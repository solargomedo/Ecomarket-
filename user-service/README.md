# User Service

Este proyecto es un microservicio de usuarios desarrollado en Java con Spring Boot. Permite gestionar usuarios para una aplicación tipo e-commerce, proporcionando endpoints REST para operaciones CRUD (Crear, Leer, Actualizar, Eliminar).

## Características
- **Listar usuarios:** Obtener todos los usuarios registrados.
- **Buscar usuario por ID:** Consultar los datos de un usuario específico mediante su identificador único.
- **Crear usuario:** Registrar un nuevo usuario en el sistema.
- **Actualizar usuario:** Modificar los datos de un usuario existente.
- **Eliminar usuario:** Borrar un usuario del sistema.

## Significado de los verbos HTTP
- **GET:** Solicita datos del servidor. Ejemplo: obtener la lista de usuarios o los datos de un usuario específico.
- **POST:** Envía datos al servidor para crear un nuevo recurso. Ejemplo: registrar un nuevo usuario.
- **PUT:** Envía datos al servidor para actualizar un recurso existente. Ejemplo: modificar los datos de un usuario.
- **DELETE:** Solicita la eliminación de un recurso. Ejemplo: borrar un usuario.

## Estructura del Proyecto
```
user-service/
├── src/
│   ├── main/java/com/ecomarket/user_service/
│   │   ├── controller/         # Controladores REST
│   │   ├── model/              # Entidades de dominio
│   │   ├── repository/         # Repositorios (DAO)
│   │   └── service/            # Lógica de negocio
│   └── resources/              # Configuración y recursos
│       ├── application.properties
│       ├── static/
│       └── templates/
├── test/                       # Pruebas unitarias y de integración
├── pom.xml                     # Dependencias Maven
└── ...
```

## Pruebas
El proyecto incluye pruebas unitarias y de integración usando JUnit y Mockito.

- **Pruebas unitarias:** Verifican el funcionamiento de componentes individuales (servicios, controladores) de forma aislada, simulando dependencias con mocks.
- **Pruebas de integración:** Validan la interacción entre varios componentes del sistema.

### Verbos principales de Mockito
- **when(...).thenReturn(...):** Simula el valor de retorno de un método cuando se llama con ciertos parámetros.
- **when(...).thenThrow(...):** Simula que un método lanza una excepción.
- **verify(...):** Verifica que un método fue invocado con ciertos parámetros.
- **any(...):** Permite aceptar cualquier valor del tipo especificado como argumento en una simulación.
- **doNothing():** Indica que un método void no debe hacer nada cuando se invoque.
- **doThrow(...):** Indica que un método void debe lanzar una excepción cuando se invoque.

Para ejecutar las pruebas:
```
./mvnw test
```
Los resultados mostrarán qué métodos han sido probados y si cumplen con el comportamiento esperado.

## Endpoints principales
- `GET    /api/v1/usuarios`           : Listar todos los usuarios. Devuelve 200 OK con la lista o 204 No Content si no hay usuarios.
- `GET    /api/v1/usuarios/{id}`      : Buscar usuario por ID. Devuelve 200 OK con el usuario o 404 Not Found si no existe.
- `POST   /api/v1/usuarios`           : Crear usuario. Devuelve 201 Created con el usuario creado.
- `PUT    /api/v1/usuarios/{id}`      : Actualizar usuario. Devuelve 200 OK con el usuario actualizado.
- `DELETE /api/v1/usuarios/{id}`      : Eliminar usuario. Devuelve 204 No Content si se elimina correctamente o 404 Not Found si no existe.

## Ejecución
1. Clona el repositorio.
2. Ejecuta `./mvnw spring-boot:run` o usa tu IDE favorito.
3. Accede a los endpoints en `http://localhost:8080/api/v1/usuarios`.

## Tecnologías
- Java 17+
- Spring Boot
- Maven
- JUnit & Mockito (pruebas)

## Autor
- Proyecto para DUOC UC
