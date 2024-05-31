## Kafka Chat Application
Apache Kafka를 활용한 채팅 메신저 애플리케이션이다.

### The intended data flow :
- Receive data from web (as HTTP request, not stream. This needs to be changed)
- Publish received data to producer
- Producer sends data to broker with appropriate topic, chat ID and etc info
- Broker sends data to consumer / Consumer reads data from broker
- The consumed data is sent as a flux to the client