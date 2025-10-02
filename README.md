# Milton OAuth2 Implementation

### An OAuth2 implementation for the Milton fictitious application using JDK 24.0.1 and Spring Boot 3.5.4. This project demonstrates a complete OAuth2 setup with an authorization server, resource server, and client application.

### In particular this application is showing off the new RestClient support for OAuth2 in Spring Security 6.4.

## Project Overview
<ins></ins>
This project consists of 3 main components:
1. Authorization Server (Port 9000) which handles authentication and issues OAuth2 tokens
2. Resource Server (Port 8081) which includes protection to the api endpoints
3. Client Application (Port 8080) which implements the OAuth2 Client 
