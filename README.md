# movietitles

This is a spring-boot application created to query movie titles.

Pre-requirements:
- Maven 3.3 or above
- Java 8 or above

To install it:
- Download the repository
- Point to the repository folder from comand line terminal and run the command: mvn spring-boot:run

To run it:
- Service URL: http://localhost:8080/?substr={substr}
- Replace localhost with the address of the server the application is running on
- Replace {substr} with a substring of the movie title. eg. spiderman
- Expected results will be a list of string with the movie titles sorted in ascending order

![Example of application running in a local environment](example.png)
