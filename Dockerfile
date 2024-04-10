FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/diner-pancakehouse-merge-0.0.1-SNAPSHOT.jar diner-pancakehouse-merge.jar
ENTRYPOINT ["java", "-jar", "diner-pancakehouse-merge.jar"]