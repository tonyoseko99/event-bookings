# Use the official Maven image as the base image for the build stage
FROM maven:3.9.5 as build

# Set the working directory to /app
WORKDIR /app

# copy the necessary files to the container
COPY . .

RUN mvn clean install -DskipTests -X

# Stage 2: Deploy the application to WildFly
FROM quay.io/wildfly/wildfly:26.1.3.Final-jdk17 AS deploy

# Remove the default standalone.xml file from WildFly
RUN rm /opt/jboss/wildfly/standalone/configuration/standalone.xml

COPY --from=build /app/target/bookings.war /opt/jboss/wildfly/standalone/deployments/

COPY --from=build /app/standalone.xml /opt/jboss/wildfly/standalone/configuration/

# Create the directory for the MySQL module
RUN mkdir -p /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/
COPY --from=build /app/module.xml /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main

# Download the MySQL Connector/J JAR file
RUN curl -o /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/mysql-connector-java-8.0.17.jar \
    https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.17/mysql-connector-java-8.0.17.jar

# Expose the default WildFly HTTP port
EXPOSE 8080

# Start WildFly
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
