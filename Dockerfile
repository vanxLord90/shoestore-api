FROM debian:bullseye-slim
RUN apt-get update && apt-get install -y wget gnupg2

# Install Java 17
RUN apt-get update && apt-get install -y wget gnupg2 && \
    wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz && \
    tar -xvf jdk-17_linux-x64_bin.tar.gz && \
    rm jdk-17_linux-x64_bin.tar.gz && \
    mkdir -p /usr/lib/jvm/java-17-openjdk-amd64 && \
    mv jdk-17*/* /usr/lib/jvm/java-17-openjdk-amd64 && \
    rm -rf jdk-17*


# Set environment variables for Java
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH


WORKDIR /app

COPY target/shoestore-api-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
