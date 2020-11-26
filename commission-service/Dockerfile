FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY target/*.jar app.jar
COPY ./start.sh /
RUN chmod 755 /start.sh
ENTRYPOINT ["sh","/start.sh"]
EXPOSE 8150
