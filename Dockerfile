# Usa una imagen base de Java
FROM openjdk:17-jdk-slim

# Define el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado por Maven/Gradle al contenedor
COPY target/biblioteca-0.0.1-SNAPSHOT.jar biblioteca-backend.jar

# Expone el puerto en el que corre la aplicación (por defecto 8080)
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "biblioteca-backend.jar"]
