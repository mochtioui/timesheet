FROM openjdk:8
EXPOSE 8082
ADD /target/timesheet-1.2-SNAPSHOT.jar timesheet.jar
ENTRYPOINT ["java","-jar","timesheet.jar"]