package org.effective.kafka.frameworks;

public class UnsupportedPropertyException extends RuntimeException {

    private static final Long SerialVersionUID = 1L;

    private UnsupportedPropertyException(String s) {
        super(s);
    }

}
