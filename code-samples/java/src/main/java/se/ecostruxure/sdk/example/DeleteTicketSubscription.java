package se.ecostruxure.sdk.example;

import java.util.HashMap;
import java.util.Map;

import se.ecostruxure.sdk.client.TicketWebhookSubscriptionApi;
import se.ecostruxure.sdk.invoker.ApiClient;
import se.ecostruxure.sdk.invoker.auth.HttpBearerAuth;

public class DeleteTicketSubscription {

    private static final String TOKEN_NAME = "token";
    private static final String BASEURL_NAME = "baseUrl";
    private static final String SUBSCRIPTION_ID = "subscriptionId";
    private static final String BAD_REQUEST = "Bad Request";
    private static final Integer STATUS = 400;

    public static void main(String[] args) {

        String token = null;
        String baseUrl = null;
        String subscriptionId = null;
        for (int i = 0; i < args.length; i++) {
            String[] arr = args[i].split("=");
            switch (arr[0]) {
            case TOKEN_NAME:
                token = findArgument(arr);
                break;
            case BASEURL_NAME:
                baseUrl = findArgument(arr);
                break;
            case SUBSCRIPTION_ID:
                subscriptionId = findArgument(arr);
                break;
            default:
                break;
            }
        }
        if (Boolean.TRUE.equals(checkNull(token))) {
            statusMessage(TOKEN_NAME);
            return;
        }
        if (Boolean.TRUE.equals(checkNull(baseUrl))) {
            statusMessage(BASEURL_NAME);
            return;
        }
        if (Boolean.TRUE.equals(checkNull(subscriptionId))) {
            statusMessage(SUBSCRIPTION_ID);
            return;
        }

        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath(baseUrl);
        // Configure HTTP bearer authorization: PersonalAccessToken
        HttpBearerAuth PersonalAccessToken = (HttpBearerAuth) defaultClient.getAuthentication("PersonalAccessToken");
        PersonalAccessToken.setBearerToken(token);
        TicketWebhookSubscriptionApi apiInstance = new TicketWebhookSubscriptionApi(defaultClient);
        try {
            System.out.println(apiInstance.deleteTicketSubscriptionWithHttpInfo(subscriptionId));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * statusMessage.
     * 
     * @param argument
     */
    private static void statusMessage(String argument) {
        String errorMessage = null;
        System.out.println("Status = " + STATUS);
        errorMessage = argument.concat(" cannot be empty");
        System.out.println(getDetailsErrorMessage(errorMessage));
    }

    /**
     * @param errorMessage
     * @return Map
     */
    public static Map<String, Object> getDetailsErrorMessage(String errorMessage) {
        Map<String, Object> details = new HashMap<>();
        details.put("type", "/Deleted Value/" + SUBSCRIPTION_ID);
        details.put("title", BAD_REQUEST);
        details.put("status", STATUS);
        details.put("detail", errorMessage);
        return details;
    }

    /**
     * check the value null.
     * 
     * @param arguments
     * @return
     */
    public static Boolean checkNull(String arguments) {
        if (arguments == null) {
            return true;
        }
        return false;
    }

    private static String findArgument(String[] arr) {
        String values = null;
        if (arr.length == 2) {
            values = arr[1];
        }
        return values;

    }
}
