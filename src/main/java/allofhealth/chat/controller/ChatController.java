package allofhealth.chat.controller;

import allofhealth.chat.consumer.WebStreamConsumer;
import allofhealth.chat.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat")
@RequiredArgsConstructor
@Slf4j
public class ChatController {

    private final KafkaProducer kafkaProducer;
    private final WebStreamConsumer webStreamConsumer;

    @PostMapping("/messages")
    public ResponseEntity<String> sendMessage(@RequestBody String msg){
        kafkaProducer.sendMessage(msg);
        return ResponseEntity.ok("Message Queued Successfully");
    }

    // Consume messages coming from the specified API
    @GetMapping("/messages")
    public void startPublishing() {
        webStreamConsumer.consumeAndPublish();
    }

}
