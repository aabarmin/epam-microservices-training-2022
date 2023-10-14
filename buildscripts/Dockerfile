FROM amazoncorretto:21
LABEL maintainer="Aleksandr_Barmin@epam.com"

ARG module_path
ADD ${module_path}/target/*.jar /opt/app.jar

ENTRYPOINT ["java", "-jar", "/opt/app.jar"]