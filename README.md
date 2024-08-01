## Kafka Chat Application
Apache Kafka를 활용한 채팅 메신저 애플리케이션이다.
참고 영상 : https://youtu.be/KQDTtvZMS9c?si=W1bVO0_G20r5u45M

보통은 Apache Kafka를 RAM cache 용도로 많이 활용하는데, Apache Kafka의 데이터 저장 기한을 무한으로 설정하면
영구적인 데이터 보관에 활용할 수 있다. 이때, Apache Kafka의 Publisher Subscriber 구조와 영구적인 데이터 보관을 합치면,
채팅 메신저 어플리케이션으로 활용하기에 매우 적합한 DB가 되므로 본 프로젝트를 시도하게 되었다.

### NOTE : DEPRECATED!  제작 중이었으나 이것을 주어진 기간 안에 완벽히 도입하기 어렵다고 판단되어 중단 했음 
- 추후에 다시 개발할 여유가 된다면 이어서 진행할 것이다.

### The intended data flow :
- Receive data from web (as HTTP request, not stream. This needs to be changed)
- Publish received data to producer
- Producer sends data to broker with appropriate topic, chat ID and etc info
- Broker sends data to consumer / Consumer reads data from broker
- The consumed data is sent as a flux to the client
