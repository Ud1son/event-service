FROM openjdk:11

ARG JAR_FILE=target/*.jar
ARG logs_dir

COPY ${JAR_FILE} app.jar
RUN mkdir ${logs_dir}
RUN chmod a+rwx ${logs_dir}

ENTRYPOINT ["java", "-jar", "app.jar"]
