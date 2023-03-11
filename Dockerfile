# Note: use a different one based upon platform; this is the one that works on my M1 mac
FROM --platform=linux/x86_64/v8 eclipse-temurin:17-jdk-alpine
VOLUME /tmp

COPY build/libs/*.jar app.jar

ENV spring_profiles_active=test

ENTRYPOINT ["java","-jar","/app.jar"]