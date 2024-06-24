## Kafka Chat Application
Apache Kafka를 활용한 채팅 메신저 애플리케이션이다.
참고 영상 : https://youtu.be/KQDTtvZMS9c?si=W1bVO0_G20r5u45M

### NOTE : DEPRECATED!  제작 중이었으나 이것을 주어진 기간 안에 완벽히 도입하기 어렵다고 판단되어 중단 했음 

### The intended data flow :
- Receive data from web (as HTTP request, not stream. This needs to be changed)
- Publish received data to producer
- Producer sends data to broker with appropriate topic, chat ID and etc info
- Broker sends data to consumer / Consumer reads data from broker
- The consumed data is sent as a flux to the client