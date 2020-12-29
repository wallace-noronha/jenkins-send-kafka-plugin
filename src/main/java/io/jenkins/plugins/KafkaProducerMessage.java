package io.jenkins.plugins;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerMessage {

    private String topic;
    private String broker;
    ProducerProperties producerProperties = new ProducerProperties();

    public KafkaProducerMessage(String broker, String topic){
        this.broker = broker;
        this.topic = topic;
    }

    public void produce(String message){

        try {

            Producer<String, String> producer = new KafkaProducer<String, String>(producerProperties.getProperties(broker));
            System.out.println("TRY TO SEND MESSAGE....");
            producer.send(new ProducerRecord<String, String>(topic, message));
            System.out.println("SUCCESS SEND MESSAGE!!!");
        } catch (Exception e){
            System.out.println("Erro to send message, try again in a feel later!");
        }
    }
}
