package allofhealth.chat.consumer;

import allofhealth.chat.config.Constants;
import allofhealth.chat.producer.ChatProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatConsumer {
    @KafkaListener(topics = "wikimedia-stream", groupId = "myGroup")
    public void consumeMsg(String msg) {
        log.info("Consuming messages from {} : {}", Constants.testTopic, msg);
        // Please feel free to do anything you want with the data
    }
}
