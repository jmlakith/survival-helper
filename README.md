
# Read Me : survival-helper

## Introduction

The survival-helper is a service created to support the existence of human race, according to the requirements provided by a the IOCO team. The main functionalities of the service are,
1. Add a survivor
2. Get Survivors
3. Update Location of a survivor
4. Update health status of the survivor
5. Get a report of statistics of the survivors
6. Get a List of robots from an external service: Robot CPU
   Hi! Please follow the information mentioned below to **build** ,**run** and **test** the project.

## Technical Documentation

I have added a technical documentation which explains the entire solution with name the name : **Technical_Documentation_ioco_v1.pdf**  in project root directory.

## Build and Run Process

The project uses Gradle for build process and dependency management. Please follow the below steps in order.

### Prerequisites
	1. JDK version 11
	2. Gradle 7.5
	3. Postman - [optional]

### Build and Run Steps
	1.	Execute on cmd:  `gradle.bat bootRun` - in Windows
	2.	Execute on terminal: `./gradlew bootRun` - in Linux and Unix

### Docker Image Build
A  **Dockerfile** has included to build the project as an docker image.
Run:  **docker build -t demo .** to build the image, and run the image by using
**docker run -d -p 8080:8080 demo**.

## How to test ?

All the endpoints have been defined on the postman collection, and you can try each and every endpoints easily.
