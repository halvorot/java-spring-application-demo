# Java spring application demo
This application shows the concept of a basic three-tier Java Spring Boot application.

The application is set up with Google Jib for dockerizing and pushing the application to Docker Hub with GitHub Actions CI.

Run the application using Docker

```cmd
docker run -p 8080:8080 halvorot/java-spring-application:latest
```
