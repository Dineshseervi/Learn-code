FROM adoptopenjdk/openjdk8:jdk8u272-b10

EXPOSE 8080

ENV DEMO_ROOT=/root

ADD /target/spring-app-hz-0.0.1-SNAPSHOT.jar $DEMO_ROOT
WORKDIR ${DEMO_ROOT}

CMD  ["java", "-jar", "spring-app-hz-0.0.1-SNAPSHOT.jar"]