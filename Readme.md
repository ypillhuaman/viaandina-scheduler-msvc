# Sobre el microservicio
Microservicio de Rutas y Horarios.
Responsabilidad: Gestionar las rutas disponibles, horarios y paradas.

## Funcionalidades:
- Consulta de rutas y horarios.
- Actualización de rutas (por ejemplo, por mantenimiento o cierres).
- Gestión de paradas y puntos de interés.

# Detalle tecnico

## Compilación
### Perfiles
- `local`: Este perfil corresponde para levantar el microservicio en local.
- `dev`: Por el momento este perfil se va a utilizar para desplegar mediante `docker compose` on-premise.
- `prod`: Este perfil se usara para desplegar en cloud. Por el momento se esta usando la misma configuración que dev.

**Nota:**
- Si se depliega mediante `docker compose` entonces se puede compilar con cualquier perfil, ya que el perfil se define en el docker-compose.yml el cual se aplicará durante la ejecución del contenedor, independientemente de como se haya compilado el microservicio.
- Cada microservicio cuenta con su Dockerfile para que luego de su compilación se pueda crear la imagen correspondiente y ser publicado en DockerHub.

## Base de datos
Los scripts de creación de la bd se encuentra en la carpeta "resources/sql/0.1.0".

Nombre bd: `viaandina_scheduler_db`

## Tablas
- `route`: Guarda información sobre rutas 
- `stops`: Guarda la información de paradas de cada ruta.
- `schedules`: Guarda la información de programación de las rutas.

## Crear contenedor
`docker build -t yurigrow/viand-scheduler-msvc:latest .`

## Instruccion para ejecutar análisis en SonarQube (sustituir la URL y token de login de SonarQube):
`mvn clean verify sonar:sonar -D"sonar.host.url"="http://localhost:9000" -D"sonar.login"="sqa_8b7b94ada4a8002e35b14371abc86c7dcebed6d1" -DskipTests`

## Dependencias
- java 17.0.7
- maven 3.9.2

`sudo apt install openjdk-17-jre-headless` <!-- el paquete openjdk-17-jre-headless no incluye bibliotecas gráficas. Ligero y recomendado para servidores -->
`sudo apt install -y maven`