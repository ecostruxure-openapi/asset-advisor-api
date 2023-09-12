/**
 * 
 */
package example;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import se.ecostruxure.sdk.client.TicketWebhookSubscriptionApi;
import se.ecostruxure.sdk.invoker.ApiClient;
import se.ecostruxure.sdk.model.TicketSubscriptionConfig;

/**
 * @author anusha_paras
 */
public class CreateTicketSubscription {
    
    /**
     * @param args
     * @throws JsonMappingException
     * @throws JsonParseException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void main(String[] args)
            throws IOException {
        String token = null;
        String baseUrl = null;
        String filePath = null;
        ObjectMapper mapperFileReader = new ObjectMapper();
        TicketSubscriptionConfig ticketSubscriptionConfig = new TicketSubscriptionConfig();
        for (int i = 0; i < args.length; i++) {
            String[] arr = args[i].split("=");
            switch (arr[0]) {
            case TOKEN_NAME:
                token = findArgument(arr);
                break;
            case BASEURL_NAME:
                baseUrl = findArgument(arr);
                break;
            case FILEPATH_NAME:
                filePath = findArgument(arr);
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
        if (Boolean.TRUE.equals(checkNull(filePath))) {
            statusMessage(FILEPATH_NAME);
            return;
        }
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath(baseUrl);
        defaultClient.setBearerToken(token);
        TicketSubscriptionConfig readObject = mapperFileReader
                .readValue(new File(filePath), TicketSubscriptionConfig.class);
        ticketSubscriptionConfig.setCallback(readObject.getCallback());
        ticketSubscriptionConfig.setPriority(readObject.getPriority());
        ticketSubscriptionConfig.setActivity(readObject.getActivity());
        TicketWebhookSubscriptionApi apiInstance = new TicketWebhookSubscriptionApi(
                defaultClient);
        try {
            System.out.println(apiInstance
                    .postTicketSubscription(ticketSubscriptionConfig));
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
        details.put("type", "/webhooks/subscriptions/ticket");
        details.put("title", BAD_REQUEST);
        details.put("status", STATUS);
        details.put("detail", errorMessage);
        return details;
    }


    /**
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
     * @param arr
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
    private static final String FILEPATH_NAME = "filePath";
    private static final String BAD_REQUEST = "Bad Request";
    private static final Integer STATUS = 400;
}
