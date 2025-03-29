# Asynchronous Messaging System with RabbitMQ and Spring Cloud  

## Technologies Used  
- **Spring Boot**  
- **Spring Cloud Gateway**  
- **Spring Cloud Eureka**  
- **RabbitMQ**  
- **PostgreSQL**  
- **Docker**  

## Architecture  
The application follows a **microservices-based architecture** with asynchronous communication using **RabbitMQ**. Services are registered with **Eureka Server**, and traffic is managed through **Spring Cloud Gateway**.  

### **Main Components**  
1. **API-Gateway (Spring Cloud Gateway)**  
   - Handles request routing and load balancing.  
   - Implements authentication, authorization, and custom filters.  
   - Configured via `application.properties`.  

2. **Producer Microservice**  
   - Collects and processes data via HTTP requests.  
   - Publishes messages to the **RabbitMQ exchange**.  
   - Can scale with replicated instances registered in **Eureka**.  

3. **Consumer Microservice**  
   - Consumes messages from the **RabbitMQ queue**.  
   - Processes and stores alerts in **PostgreSQL**.  
   - Designed for future integration with notification systems (email, SMS, push).  

## Execution  
### **Steps to Run the Application**  
1. **Start RabbitMQ (Docker)**  
   ```sh
   docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
   ```  
2. **Start Eureka Server and API-Gateway**  
3. **Run the Producer Microservice and test with an HTTP POST request (e.g., Insomnia/Postman)**  
4. **Run the Consumer Microservice and verify message consumption**  
5. **Test resilience by shutting down the main Producer instance and observing the replica handling requests**  
