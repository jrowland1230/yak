# Yak Implementation

### Yak is a social networking application using JDK 24.0.1, Spring Boot 3.5.4 Kafka for event streaming, Mongodb for data storage and Splunk for searching, monitoring, and analyzing machine generated data. This project demonstrates the use of Kafka publisher and consumer with retry logic and Mongodb focusing on idempotency.

## Project Overview
<ins></ins>
This project consists of 3 main components:
1. Producer-Service (Port 8092) implements the Kafka producer
2. Consumer-Service (Port 8099) implements the Kafka consumer
3. Common-Service implements commonly used models within the Producer and Consumer services
