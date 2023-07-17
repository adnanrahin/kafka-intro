package org.effective.kafka.abstractclass;

public class AbstractClassTestRunner {

    public static void main(String[] args) {
        String userApiUrl = "https://api.example.com/users";
        int connectionTimeout = 5000;
        int readTimeout = 10000;
        String apiKey = "your-api-key";

        UserClient userClient = new UserClient(userApiUrl, connectionTimeout, readTimeout, apiKey);
        String updatedApiUrl = "https://api.example.com/v2/users";
        UserClient updatedClient = userClient.withApiUrl(updatedApiUrl);

        System.out.println(updatedClient);

    }

}
