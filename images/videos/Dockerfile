FROM openjdk:8-jre
ENV APP_PATH = /apps
WORKDIR $APP_PATH
COPY star-videos-1.0-SNAPSHOT.jar $APP_PATH/app.jar
EXPOSE 8983
ENTRYPOINT ["java", "-jar"]
CMD ["app.jar"]