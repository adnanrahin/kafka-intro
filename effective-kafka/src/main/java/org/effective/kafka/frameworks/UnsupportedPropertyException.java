package org.effective.kafka.frameworks;

public class UnsupportedPropertyException extends RuntimeException {

    private static final Long SerialVersionUID = 1L;

    UnsupportedPropertyException(String s) {
        super(s);
    }

}
