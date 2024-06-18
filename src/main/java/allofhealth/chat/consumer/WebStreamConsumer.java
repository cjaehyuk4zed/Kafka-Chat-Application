package allofhealth.chat.consumer;

import allofhealth.chat.producer.ChatProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class WebStreamConsumer {

    private final WebClient webClient;
    private final ChatProducer producer;

    @Autowired
    public WebStreamConsumer(WebClient.Builder webClientBuilder, ChatProducer producer) {
        this.webClient = webClientBuilder
                // the baseUrl where the data will be consumed (aka server address).
                // This data will be produced to the Kafka broker with the publishToBroker() method
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        this.producer = producer;
    }

    // Consumes the data coming from the above constructor's baseUrl, and produce it to the Kafka broker
    // The URI should be created by a separate API, with a chatroom number (partition ID)
    //
    public void consumeStreamAndPublish() {
        webClient.get()
//        Insert the API endpoint where the sender will send chat messages. This API endpoint is appended to the baseUrl address of the webClient
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(producer::sendMessage);
    }
}
