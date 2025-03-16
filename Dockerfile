FROM tomcat:8.5-jdk8
COPY ./web /usr/local/tomcat/webapps/ROOT
EXPOSE 8080
CMD ["catalina.sh", "run"]