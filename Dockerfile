# Stage 1: Build the Maven application inside the cloud environment
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Deploy the compiled WAR file into Apache Tomcat
FROM tomcat:10-jdk17-openjdk-slim
RUN rm -rf /usr/local/tomcat/webapps/ROOT
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080