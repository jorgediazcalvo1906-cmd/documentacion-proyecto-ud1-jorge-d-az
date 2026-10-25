# Gestor de Incidencias del Centro Educativo

Aplicación de consola desarrollada en Java para consultar, buscar y gestionar de forma rápida las incidencias de soporte técnico reportadas en un centro educativo.

## Requisitos del Sistema

- **Java Development Kit (JDK):** Versión 25.
- **Apache Maven:** Herramienta de gestión y construcción de proyectos.

## Funcionalidades Principales

La aplicación permite operar tanto en modo interactivo por consola como mediante argumentos de línea de comandos:

1. **Mostrar todas las incidencias:** Consulta el listado completo de avisos registrados en el sistema.
2. **Mostrar incidencias abiertas:** Filtra y muestra únicamente los reportes pendientes de resolución.
3. **Buscar incidencias:** Permite buscar coincidencias de texto dentro del identificador o del título de las incidencias.
4. **Consultar por ID:** Muestra la información detallada de una incidencia específica dado su identificador único (lanzando una excepción controlada si no se encuentra).

## Estructura de Archivos del Proyecto

```text
proyecto-base-maven-gestor-incidencias/
├── .mvn/                       # Configuración de Maven Wrapper
├── src/
│   └── main/
│       └── java/
│           └── es/
│               └── centro/
│                   └── incidencias/
│                       ├── App.java
│                       ├── GestorIncidencias.java
│                       ├── Incidencia.java
│                       └── IncidenciaNoEncontradaException.java
├── docs/                       # Documentación Javadoc generada en HTML
├── pom.xml                     # Configuración y dependencias del proyecto Maven
├── README.md                   # Documentación técnica del proyecto
├── mvnw                        # Script ejecutable de Maven Wrapper para Unix/Linux/macOS
└── mvnw.cmd                    # Script ejecutable de Maven Wrapper para Windows

````

## Clases principales y responsabilidades

| Clase | Responsabilidad |
|---|---|
| `es.centro.incidencias.App` | Punto de entrada a la aplicación. Gestiona la interfaz por consola, la lectura de comandos y los menús interactivos. |
| `es.centro.incidencias.GestorIncidencias` | Administra la colección de incidencias en memoria y contiene la lógica para listar, buscar y consultar datos. |
| `es.centro.incidencias.Incidencia` | Modelo de datos que representa una incidencia individual mediante su ID, título, prioridad y estado. |
| `es.centro.incidencias.IncidenciaNoEncontradaException` | Excepción personalizada lanzada cuando no se encuentra una incidencia con el ID indicado. |

