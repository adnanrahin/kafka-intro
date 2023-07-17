package org.effective.kafka.abstractclass;

public class ApplicationClient extends AbstractClientConfig<ApplicationClient> {
    private final String apiKey;
    private final String applicationName;

    public ApplicationClient(String apiUrl, int connectionTimeout, int readTimeout, String apiKey, String applicationName) {
        super(apiUrl, connectionTimeout, readTimeout);
        this.apiKey = apiKey;
        this.applicationName = applicationName;
    }

    @Override
    public ApplicationClient withApiUrl(String apiUrl) {
        return new ApplicationClient(apiUrl, getConnectionTimeout(), getReadTimeout(), apiKey, applicationName);
    }

    @Override
    public String toString() {
        return "ApplicationClient{" +
                "apiKey='" + apiKey + '\'' +
                ", applicationName='" + applicationName + '\'' +
                '}';
    }
}
