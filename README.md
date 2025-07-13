🚀 MicroService Project
This repository hosts a comprehensive MicroService Project built entirely with Java. It demonstrates the implementation of a microservices architecture, featuring several interconnected services designed for scalability, resilience, and independent deployment.

✨ Features
Service Discovery: Dynamic registration and lookup of services.

Centralized Configuration: Manage application configurations from a single location.

API Gateway: A single entry point for all client requests, handling routing, security, and load balancing.

Modular Design: Each service is independently developed, deployed, and scaled.

Scalability: Easily scale individual services based on demand.

Fault Isolation: Failures in one service do not impact others.

💻 Technologies Used
Java: The core programming language for all services.

Spring Boot: Framework for building production-ready, stand-alone Spring applications.

Spring Cloud: Provides tools for common patterns in distributed systems (e.g., service discovery, circuit breakers, API gateway).

Eureka Server: For service registration and discovery (ServiceRegistery).

Spring Cloud Config: For externalized configuration (ConfigServer).

Spring Cloud Gateway: For API routing and filtering (ApiGateway).

Maven: For build automation and dependency management.

📂 Project Structure
The project is organized into several modules, each representing a distinct microservice:

ApiGateway/: Handles all incoming requests and routes them to the appropriate microservice.

ConfigServer/: Provides centralized configuration for all microservices.

HotelService/: Manages hotel-related data and operations.

RatingService/: Manages ratings and reviews for hotels or other entities.

ServiceRegistery/: The Eureka Server, responsible for service registration and discovery.

UserService/: Manages user-related data and authentication.

⚙️ Setup and Run
To set up and run this project locally, follow these steps:

Clone the Repository:

Bash

git clone https://github.com/Anubhav2912/MicroServiceProject.git
cd MicroServiceProject
Build Each Service:
Navigate into each service directory (ApiGateway, ConfigServer, HotelService, RatingService, ServiceRegistery, UserService) and build them using Maven:

Bash

cd <service-directory> # e.g., cd ServiceRegistery
mvn clean install
cd ..
Repeat for all service directories.

Run Services:
Start the services in the following order:

ServiceRegistery: (Eureka Server)

ConfigServer:

HotelService:

RatingService:

UserService:

ApiGateway:

You can run each service from its respective directory using:

Bash

java -jar target/<service-name>-<version>.jar
Alternatively, import the project into your IDE (e.g., IntelliJ IDEA, Eclipse) and run each service as a Spring Boot application.

For the common yml configurations files, visit and clone the following repository and make the respective changes in your ConfigServer application.yml file where the url of the configuration file is attached:

https://github.com/Anubhav2912/MicroServiceConfig

🤝 Contributing
Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue or submit a pull request.
