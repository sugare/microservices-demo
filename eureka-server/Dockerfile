FROM maven:latest

LABEL maintainer "sugare"

WORKDIR /project
ADD . /project

RUN mvn package
CMD ["mvn"]
