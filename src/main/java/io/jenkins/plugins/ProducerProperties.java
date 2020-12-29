package io.jenkins.plugins;

import java.util.Properties;

public class ProducerProperties {

    public Properties getProperties(String broker){
        // create instance for properties to access producer configs
        Properties props = new Properties();

        //Assign localhost id
        props.put("bootstrap.servers", broker);
        //Set acknowledgements for producer requests.
        props.put("acks", "all");
        //Set timeout from send
        props.put("timeout.ms",300);
        //If the request fails, the producer can automatically retry,
        props.put("retries", 5);
        //Specify buffer size in config
        props.put("batch.size", 16384);
        //Reduce the no of requests less than 0
        props.put("linger.ms", 1);
        //The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return props;
    }

}
