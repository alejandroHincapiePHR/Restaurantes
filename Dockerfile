# Usa una imagen base de Gradle con JDK
FROM gradle:7.6.0-jdk17 AS build

# Configura el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia los archivos de tu proyecto a la carpeta del contenedor
COPY . /app

# Construir el proyecto utilizando Gradle
RUN gradle clean build --no-daemon

# Usa una imagen base de OpenJDK para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Directorio donde se ejecutará la aplicación
WORKDIR /app

# Copia el archivo JAR generado desde el paso anterior
COPY --from=build /app/build/libs/*.jar Restaurantes.jar

# Expone el puerto configurado para la aplicación
EXPOSE ${SERVER_PORT}

# Configura variables de entorno
ENV SPRING_DATASOURCE_URL=${SPRING_DATASOURCE_URL}
ENV SPRING_DATASOURCE_USERNAME=${SPRING_DATASOURCE_USERNAME}
ENV SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD}
ENV SERVER_PORT=${SERVER_PORT}

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "Restaurantes.jar"]



