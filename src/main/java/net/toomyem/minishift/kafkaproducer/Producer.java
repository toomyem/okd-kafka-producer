package net.toomyem.minishift.kafkaproducer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.scheduling.annotation.Scheduled;

@Singleton
public class Producer {

    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);

    @Inject
    private NameSender nameSender;

    private int counter = 0;

    @Scheduled(fixedRate = "10s")
    void sendName() {
        counter++;
        String name = "name-" + counter;
        LOG.info("Sending name: {}", name);
        nameSender.sendName("key", name);
    }
}
