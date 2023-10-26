FROM openjdk:latest

WORKDIR /Be_Ecommerce
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

EXPOSE 8181
# CMD ["./mvnw", "spring-boot:run"]
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.profiles=mysql"]
