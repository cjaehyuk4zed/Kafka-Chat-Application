package allofhealth.chat.producer;

import allofhealth.chat.config.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatProducer {
    // Key - Value Kafka Template
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg){
        log.info("Sending message to test-application-topic : {}", msg);
        kafkaTemplate.send(Constants.testTopic, msg);
    }

}
