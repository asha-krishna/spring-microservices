# spring-microservices

1. Create 3 Microservice applications which runs on different port numbers
    * product-service (port : 8081)
    * pricing-service (port : 8082)
    * inventory-service (port : 8083)

2. Create eureka-discovery-server (port : 8761)

3. Create api-gateway (port : 8085)

4. Start local servers in this order
    a. eureka-discovery-server
    b. api-gateway
    c. product-service
    d. pricing-service
    e. inventory-service
    
5. We can see status of all the servers through Eureka server discovery

   ![image](https://user-images.githubusercontent.com/73759012/147607894-559e64ad-1830-4ee9-9695-8224338546bc.png)

