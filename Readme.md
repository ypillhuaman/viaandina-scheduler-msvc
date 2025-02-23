# Sobre el microservicio
Microservicio de Rutas y Horarios.
Responsabilidad: Gestionar las rutas disponibles, horarios y paradas.

Funcionalidades:
- Consulta de rutas y horarios.
- Actualización de rutas (por ejemplo, por mantenimiento o cierres).
- Gestión de paradas y puntos de interés.

# Base de datos
Los scripts de creación de la bd se encuentra en la carpeta "resources/sql/0.1.0".

Nombre bd: `viaandina_scheduler_db`

### Tablas
- `route`: Guarda información sobre rutas 
- `stops`: Guarda la información de paradas de cada ruta.
- `schedules`: Guarda la información de programación de las rutas.