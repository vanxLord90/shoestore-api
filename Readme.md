This is a project that showcases the Rest Api service for employees at a hypothetical Shoe Store. 
Here I showcase my ability to write a microservice that can create, read, update, and delete employees.
I showcase my ability to document apis using open-api spring docs on link below
http://localhost:8080/swagger-ui/index.html
I showcase my ability to containerize the application and run it on a Docker container using Docker Desktop in my Dockerfile.
I showcase my ability to use Kubernetes to deploy the Docker container that is running my application in development.yaml.
I used PostgreSQL database in the regular applicaition as it is a relational database vs H2 which is an in memory database and will not store any data onto the disk but rather disappear once the program is shutdown.
I used H2 database while running it in the Docker container as it is only supposed to be working when the docker container is running and the non persistent nature of it will not affect anything.
I hope to finish by attaching the PostgreSQL image to my Docker container so that I can use it and the data will not disappear after the container is shutdown.
