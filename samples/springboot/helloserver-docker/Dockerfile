FROM registry.access.redhat.com/ubi8/ubi:latest AS build_base
RUN yum install -y java-11-openjdk-devel
RUN yum install -y wget
RUN wget https://www-us.apache.org/dist/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz -P /tmp
RUN tar xf /tmp/apache-maven-3.6.3-bin.tar.gz -C /opt
RUN ln -s /opt/apache-maven-3.6.3 /opt/maven
#RUN yum install -y maven
COPY . /app
WORKDIR /app
RUN /opt/maven/bin/mvn package

# # Run App
# FROM registry.access.redhat.com/jboss-eap-6/eap64-openshift:latest
# EXPOSE 8080
# COPY --from=build_base /app/target/*.war /opt/eap/standalone/deployments/

# This official image uses OpenJDK 11 and Wildfly 18
FROM jboss/wildfly:18.0.0.Final
EXPOSE 8080
# Copy the war file to the deployments folder
COPY --from=build_base  /app/target/restservice-0.0.1-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/jhello.war