# Use an official Tomcat image with Java
FROM tomcat:10-jdk17-openjdk-slim

# Remove the default Tomcat webapps so your project becomes the main page
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy your built target war file into Tomcat's deployment folder as ROOT.war
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose Tomcat's default web port
EXPOSE 8080