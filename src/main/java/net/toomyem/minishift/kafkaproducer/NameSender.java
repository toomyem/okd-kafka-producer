package net.toomyem.minishift.kafkaproducer;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface NameSender {

    @Topic("names")
    void sendName(@KafkaKey String key, String name);
}
