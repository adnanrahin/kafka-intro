package org.effective.kafka.frameworks;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractClientConfig<C extends AbstractClientConfig<?>> {

    private final Map<String, Object> customEntries = new HashMap<>();

    @SuppressWarnings("unchecked")
    public final C withCustomEntry(String propertyName, Object value) {
        Objects.requireNonNull(propertyName, "Property name cannot be null");
        customEntries.put(propertyName, value);
        return (C) this;
    }

    public final Map<String, Object> mapify() {
        final Map<String, Object> stagingConfig = new HashMap<>();

        return stagingConfig;
    }

}
