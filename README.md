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

6. Make Rest call through API gateway (port: 8085)

   ![image](https://user-images.githubusercontent.com/73759012/147608105-60d404df-e747-439d-9483-62d67556b21f.png)
   

   ![image](https://user-images.githubusercontent.com/73759012/147608154-b6247d75-0fd0-4a4d-9ffc-a02e5ded3dda.png)
   

   ![image](https://user-images.githubusercontent.com/73759012/147608178-ac9de412-714d-43de-9cec-e0600f44213c.png)

7. Suppose if pricing-service is down and when we try to make a call to pricing-service through API Gateway, then it handles error and return fall back method

   ![image](https://user-images.githubusercontent.com/73759012/147608247-8d9803f0-e7bd-4157-b73f-d25880694a48.png)
