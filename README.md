# Resume-Builder-API
A Resume Builder API is a tool that allows users to create professional resumes quickly and easily. The API uses pre-built templates and dynamically generates the resume content based on the user's input data, such as personal information, skills, experiences, and education. This reduces the manual effort required to create and format a resume. 
### Prerequisites for the API
1. pdfservices-sdk credentials
2. maven
3. jdk 17
#### Install the pre requisites before running the API
## Running the API
To run the API, Download the github repository.
The code can be run using 2 methods:
### 1. Spring Tool Suite (Recommended)
Import the project as a maven project in the STS application. Right click on the main directory(The one in which pom.xml lies) and click on "Run as" choose the Spring Boot Application option to launch the API.
### 2. Command Line
go to the main directory (where the pom.xml file is )
run the following commands 
./mvnw clean
./mvnw install
./mvnw spring-boot:run

The spring boot application will load and launch.Now you can run the curl file on the terminal or run the API through Postman.

