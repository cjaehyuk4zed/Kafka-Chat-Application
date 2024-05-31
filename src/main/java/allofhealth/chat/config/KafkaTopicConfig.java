package allofhealth.chat.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

import static allofhealth.chat.config.Constants.testTopic;

@Configuration
public class KafkaTopicConfig {

//    When using Spring Boot, a KafkaAdmin is automatically registered
//    So you only need the NewTopic (and/or NewTopics) @Bean(s)
//    This commented out code is what you're supposed to need in order to configure a Kafka Admin
//    @Bean
//    public KafkaAdmin admin() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        return new KafkaAdmin(configs);
//    }

    //
    @Bean
    public NewTopic ChatApplicationTestTopic(){
        return TopicBuilder
                .name(testTopic)
                .build();
    }
}
