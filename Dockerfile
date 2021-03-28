FROM ubuntu:20.04
LABEL image=Spark-base-image
ENV SPARK_VERSION=3.0.2
ENV HADOOP_VERSION=2.7

RUN apt-get update -qq && \
    apt-get install -qq -y gnupg2 wget openjdk-8-jdk scala

# Download tar 
WORKDIR /
RUN wget --no-verbose https://www.apache.org/dyn/closer.lua/spark/spark-3.0.2/spark-3.0.2-bin-hadoop2.7.tgz

# Untar the downloaded binaries 
RUN tar -xzf /spark-3.0.2-bin-hadoop2.7.tgz && \
    mv spark-3.0.2-bin-hadoop2.7 spark && \
    echo "export PATH=$PATH:/spark/bin" >> ~/.bashrc

#Expose the UI Port 
EXPOSE 4040
