package allofhealth.chat.controller;

import allofhealth.chat.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String msg){
        kafkaProducer.sendMessage(msg);
        return ResponseEntity.ok("Message Queued Successfully");
    }
}
