# From: https://github.com/spotify/dockerfile-maven

FROM openjdk:8-jdk-alpine
MAINTAINER Alessandro Biondi <alessandro@biondi.me>

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/app.jar"]

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
ADD target/lib           /usr/share/myservice/lib
# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/myservice/app.jar
