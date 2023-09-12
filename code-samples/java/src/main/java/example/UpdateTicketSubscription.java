/**
 * 
 */
package example;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import se.ecostruxure.sdk.client.TicketWebhookSubscriptionApi;
import se.ecostruxure.sdk.invoker.ApiClient;
import se.ecostruxure.sdk.model.TicketSubscriptionConfig;

/**
 * @author koustub_mangasuli
 *
 */
public class UpdateTicketSubscription {
    
    public static void main(String[] args) {
        String token = null;
        String baseUrl = null;
        String subscriptionId = null;
        String filePath = null;
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
            case FILEPATH_NAME:
                filePath = findArgument(arr);
                break;
            default:
                break;
            }
        }
        // To check the null conditions
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
        if (Boolean.TRUE.equals(checkNull(filePath))) {
            statusMessage(FILEPATH_NAME);
             return;
         }
        File fileUrl = new File(filePath);
        if (!fileUrl.exists()) {
            System.out.println("The given file path does not Exists");
            return;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readTree(fileUrl);         
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath(baseUrl);
        defaultClient.setBearerToken(token);

        TicketWebhookSubscriptionApi apiInstances = new TicketWebhookSubscriptionApi(defaultClient);
        TicketSubscriptionConfig ticketSubscriptionConfig = new TicketSubscriptionConfig();
        ticketSubscriptionConfig.setCallback(rootNode.get("callback"));
        ticketSubscriptionConfig.setPriority(rootNode.get("priority"));
        ticketSubscriptionConfig.setActivity(rootNode.get("activity"));
        try {
            System.out.println(apiInstances.putTicketSubscription(subscriptionId, ticketSubscriptionConfig));
        } catch (Exception e) {
            if(e.getLocalizedMessage().contains("401")) {
                System.out.println(getDetailsError401Message());
            }
            else {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
    /**
     * @return Map<String,Object>
     */
    private static Map<String,Object> getDetailsError401Message() {
        Map<String,Object> details = new HashMap<>();
        details.put("type","/webhooks/subscriptions/ticket");
        details.put("title","Unauthorized");
        details.put("status",401);
        details.put("detail","Access Token Expired");
        return details;
    }

    /**
     * statusMessage.
     * @param argument
     */
    private static void statusMessage(String argument) {
        String errorMessage = null;
        errorMessage = argument.concat(" cannot be empty");
        System.out.println(getDetailsErrorMessage(errorMessage));
    }

    /**
     * @param errorMessage
     * @return Map
     */
    public static Map<String,Object> getDetailsErrorMessage(String errorMessage) {
        Map<String,Object> details = new HashMap<>();
        details.put("type","/webhooks/subscriptions/ticket");
        details.put("title",BAD_REQUEST);
        details.put("status",STATUS);
        details.put("detail",errorMessage);
        return details;
    }
    
    /**
     * check the value null.
     * @param arguments
     * @return
     */
    public static Boolean checkNull(String arguments) {
        if (arguments == null) {
            return true;
        }
        return false;
    }

    /**
     * findArgument.
     * @param arr String Array
     * @return
     */
    private static String findArgument(String[] arr) {
        String values = null;
        if (arr.length == 2) {
            values = arr[1];
        }
        return values;
    }
    
    private static final String TOKEN_NAME = "token";
    private static final String BASEURL_NAME = "baseUrl";
    private static final String SUBSCRIPTION_ID = "subscriptionId";
    private static final String FILEPATH_NAME = "filePath";
    private static final String BAD_REQUEST = "Bad Request";
    private static final Integer STATUS = 400;

}
