FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
ADD ./target/viaandina-scheduler-msvc-0.0.1-SNAPSHOT.jar viaandina-scheduler-msvc.jar

ENTRYPOINT [ "java", "-jar", "viaandina-scheduler-msvc.jar" ]