# Utilisez une image officielle de Java 17 JDK comme image de base
FROM openjdk:17-jdk-slim

# Ajoutez un label de mainteneur (facultatif)
LABEL maintainer="your-email@example.com"

# Créez un répertoire pour l'application
WORKDIR /app

# Copiez le fichier JAR de l'application dans le conteneur
COPY target/web-service.jar app.jar

# Exposez le port sur lequel votre application écoute
EXPOSE 8080

# Définissez la commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
