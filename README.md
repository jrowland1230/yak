# Yak Implementation

### A Yak social networking implementation application using JDK 24.0.1, Spring Boot 3.5.4 Kafak, Mongodb and Splunk. This project demonstrates the use of Kafka publisher and consumer with retry logic and idempotency and Mongodb to store documents. Splunk is used to store logs and used for reporting.

## Project Overview
<ins></ins>
This project consists of 3 main components:
1. Producer-Service (Port 8092) implements the Kafka producer
2. Consumer-Service (Port 8099) implements the Kafka consumer
3. Common-Service implements common models used in the Producer and Consumer services
