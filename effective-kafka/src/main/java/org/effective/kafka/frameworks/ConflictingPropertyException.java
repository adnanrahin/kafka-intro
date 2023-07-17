package org.effective.kafka.frameworks;

public class ConflictingPropertyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    ConflictingPropertyException(String s) {
        super(s);
    }
}
