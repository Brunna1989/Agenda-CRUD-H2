ARG GRADLE_VERSION=7.4.2-jdk
ARG JETTY_VERSION=9.4.44-jdk17
FROM gradle:${GRADLE_VERSION} as gradle
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build
RUN ls /home/gradle/src/build/libs/

FROM jetty:${JETTY_VERSION} as jetty
COPY --from=gradle /home/gradle/src/build/libs/Agenda-0.0.1-SNAPSHOT.jar /var/lib/jetty/webapps/ROOT.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /var/lib/jetty/webapps/ROOT.jar"]