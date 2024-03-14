This is a project that showcases the Rest Api service for employees at a hypothetical Shoe Store. 

To run this project in H2, just type mvn clean package in cmd and then run the ShoestoreApiApplication.java.


To run this project in PostgreSQL go to application.properties in the resources folder and type in your postgres credentials, and then run ShoestoreApiApplication.java.

Here I showcase my ability to write a microservice that can create, read, update, and delete employees.

I showcase my ability to document apis using open-api spring docs on link below
http://localhost:8080/swagger-ui/index.html

To test it out, go to the link above and checkout employee-controller, it will give you the api calls to make and what results it will give. You can use the try it out section of the swagger to test the rest-api or use a tool like Postman.

I showcase my ability to containerize the application and run it on a Docker container using Docker Desktop in my Dockerfile.

I showcase my ability to use Kubernetes to deploy the Docker container that is running my application in development.yaml.

I used PostgreSQL database in the regular applicaition as it is a relational database vs H2 which is an in memory database and will not store any data onto the disk but rather disappear once the program is shutdown.

I used H2 database while running it in the Docker container as it is only supposed to be working when the docker container is running and the non persistent nature of it will not affect anything.

I hope to finish by attaching the PostgreSQL image to my Docker container so that I can use it and the data will not disappear after the container is shutdown.
