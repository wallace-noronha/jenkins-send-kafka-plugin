package io.jenkins.plugins;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.logging.Logger;

public class KafkaProducerMessage {

    private static final Logger LOGGER = Logger.getLogger(KafkaProducerMessage.class.getName());

    private String topic;
    private String broker;
    private Producer<String, String> producer;
    ProducerProperties producerProperties = new ProducerProperties();

    public KafkaProducerMessage(String broker, String topic){
        this.broker = broker;
        this.topic = topic;
    }

    public void produce(String message){

        try {
            producer =  new KafkaProducer<>(producerProperties.getProperties(broker));
            LOGGER.info("TRY TO SEND MESSAGE....");
            producer.send(new ProducerRecord<String, String>(topic, message));
            LOGGER.info("SUCCESS SEND MESSAGE!!!");
        } catch (Exception e){
            LOGGER.severe("Error to send message, try again in a feel later!");
            LOGGER.severe("STACKTRACE: " + e.getMessage());
        } finally {
            if (producer != null) {
                producer.close();
            }
        }
    }
}
