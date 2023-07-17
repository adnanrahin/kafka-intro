package org.effective.kafka.abstractclass;

public class AbstractClassTestRunner {

    public static void main(String[] args) {
        String userApiUrl = "https://api.example.com/users";
        int connectionTimeout = 5000;
        int readTimeout = 10000;
        String apiKey = "your-api-key";

        // Create a UserClient instance with initial configurations
        UserClient userClient = new UserClient(userApiUrl, connectionTimeout, readTimeout, apiKey);

        // Perform actions with the UserClient, such as getting user data, creating users, etc.
        // ...

        // Update the API URL for the UserClient
        String updatedApiUrl = "https://api.example.com/v2/users";
        UserClient updatedClient = userClient.withApiUrl(updatedApiUrl);

        System.out.println(updatedClient);

        // Now, use the updatedClient for further operations with the new API URL
        // ...
    }

}
