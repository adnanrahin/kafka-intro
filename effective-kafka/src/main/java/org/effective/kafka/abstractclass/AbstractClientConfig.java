package org.effective.kafka.abstractclass;

public abstract class AbstractClientConfig<C extends AbstractClientConfig<?>> {
    private final String apiUrl;
    private final int connectionTimeout;
    private final int readTimeout;

    public AbstractClientConfig(String apiUrl, int connectionTimeout, int readTimeout) {
        this.apiUrl = apiUrl;
        this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public abstract C withApiUrl(String apiUrl);

    @Override
    public String toString() {
        return "AbstractClientConfig{" +
                "apiUrl='" + apiUrl + '\'' +
                ", connectionTimeout=" + connectionTimeout +
                ", readTimeout=" + readTimeout +
                '}';
    }

}
