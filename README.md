# sabre-converter-demo-api

Technical Test instructions/ Specification:

    1. Create a Spring Boot application using rest API’s to do conversions.

    2. Convert Metric to imperial and vice versa. The API must cater for at least 5 conversions (include temperature conversion please).

    3. Ensure that you have proper Unit and Integration testing that accompany the project.

    4. Postman/Jmeter project with your RestAPI's.

    5. Upload your project into your own GIT repository and share the project with us.

    6. The project must be able to run in its own Docker environment

    7. Build system must use Maven.


Solution Structure:

A Spring Boot application has been built with the following details:


The application is built using Maven for dependency management and a built tool as has been requested.

Unit and Integration tests have been included that test the endpoints, services and unit of measurements provided with enums. Have used JUnit 5 and Mockito libraries for the tests. The integration tests, test the endpoints and service layer. The unit test, tests the service and business layer.

A Dockerfile is included in the application so as to build container images and run the application on docker. To build the image can use docker commands on the app root folder:
$ docker build -t <app-image-tag-name> .
Then to run the container using:
$ docker run -dp 9090:8080 <app-image-tag-name>

A postman collection (MetricConverterAPI.postman_collection.json) and environment (metric-converter-env.postman_environment.json) is included in the project structure on a folder called Postman. These files can be imported to postman if one wants to run tests against the endpoints. All the endpoints have been tested on postman.

Solution Description:

The Spring Boot application has a controller to expose the rest endpoints for different metric-imperial unit conversions as per the project instructions.

The application makes use of enums to handle different measurements and units conversion factors. The enums are used both in the controller and in the service layer.

The endpoint take this structure:  http://localhost:8080/converter-api/<measurement>/{unit-to-convert-from}/{unit-value}/{unit-to-onvert-to}

For example,
http://localhost:8080/converter-api/temperature/celsius/10/fahreinheit

The endpoints trigger the conversion of units by calling the service method that utilises the conversion factors in each enum to compute the conversion value. The factors were included on the enums to support scalability of the application. Furthermore, to generalise the solution a single conversion technique is adopted with exception of the temperature measurement as the computation is slightly different from the rest.

The selected measures are:
Temperature - converting between celsius and fahrenheit
Distance - converting between meter and yard (feet and inch included to check scalability)
Weight - converting between kilogram and pound (ounce and tonne included for scalability check)
Volume - converting between litre and pint (gallon included)
Area - converting between hectare and acre

These are all validated on the controller and an appropriate message is displayed if an attempt to use an incorrect measurement unit is made. The response to the call is a json that gives the name and value of the returned unit.
For example:
http://localhost:8080/converter-api/temperature/celsius/10/fahreinheit returns {"fahreinheit":50.0}


Future Improvements:

More services would need to be created to accommodate additional units for the same measurements when scaling up. A validation utility has to be done designed to check between measurements to make the api more secure. 

