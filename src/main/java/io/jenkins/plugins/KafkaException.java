package io.jenkins.plugins;

public class KafkaException extends Exception{

    private static final long serialVersionUID = 1L;

    KafkaException(String message, Throwable cause) {
        super(message, cause);
    }

}
