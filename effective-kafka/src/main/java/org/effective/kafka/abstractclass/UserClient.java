package org.effective.kafka.abstractclass;

public class UserClient extends AbstractClientConfig<UserClient> {
    private final String apiKey;

    public UserClient(String apiUrl, int connectionTimeout, int readTimeout, String apiKey) {
        super(apiUrl, connectionTimeout, readTimeout);
        this.apiKey = apiKey;
    }

    @Override
    public UserClient withApiUrl(String apiUrl) {
        // Create a new UserClient with updated apiUrl and other configurations
        return new UserClient(apiUrl, getConnectionTimeout(), getReadTimeout(), apiKey);
    }

    @Override
    public String toString() {
        return "UserClient{" +
                "apiKey='" + apiKey + '\'' +
                '}';
    }


    // Additional methods and functionalities specific to the UserClient...
}
