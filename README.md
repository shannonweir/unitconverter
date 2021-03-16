# Unit Converter Server
This is a simple unit converter server built using Spring Boot. 
It basically converts Metric to Imperial and vice versa by exposing a REST API.

The REST endpoint collection is attached in the root folder which can be imported into Postman 
for reference purposes and/or to test the endpoints.

####Name of REST API endpoint Collection:
* Ayo Unit Converter API.postman_collection.json

# Prerequisite
1. Docker
2. Maven

# Steps to run Online Registration Server
1. Pull the project 
2. Make sure you have docker installed. You can check this, using the following command: 'docker -v'
3. Open cmd
4. Navigate to the project root directory
5. To build the project and create the jar to be published, please execute the following command: 'mvn clean install'   
6. Now that we have the jar in the target directory, to build a image for the docker container, please execute the 
   following command (Note: the '.' in command is not a mistake) : 'docker build -t unitconverter .' 
6. To run the image in the container, please execute the following command: 'docker run -p 8080:8080 unitconverter'  
7. This should start up the server. This server runs on http://localhost:8080. A simple api call would be 
   'http://localhost:8080/ayo/api/metric/types', which can be used to test that the system is up and running :) 


