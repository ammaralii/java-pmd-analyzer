# Use the official OpenJDK 11 image as the base image
FROM openjdk:11

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file and any other necessary files into the container at /app
COPY pmd-analyzer.jar /app

# Specify the command to run your application
CMD ["java", "-jar", "/app/pmd-analyzer-1.0-SNAPSHOT.jar", "https://github.com/ammaralii/interview-preparation-kit.git"]