/**
 * 
 */
package se.ecostruxure.sdk.example;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.client.ResourceAccessException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import se.ecostruxure.sdk.client.TicketWebhookSubscriptionApi;
import se.ecostruxure.sdk.invoker.ApiClient;
import se.ecostruxure.sdk.model.TicketSubscriptionConfig;

public class CreateTicketSubscription {
    private static final String TOKEN_NAME = "token";
    private static final String BASEURL_NAME = "baseUrl";
    private static final String FILEPATH_NAME = "filePath";
    private static final Logger logger = Logger
            .getLogger("CreateTicketSubscription");
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
            logger.log(Level.INFO, "Please Pass the token");
            return;
        }
        if (Boolean.TRUE.equals(checkNull(baseUrl))) {
            logger.log(Level.INFO, "Please Pass the baseUrl");
            return;
        }
        if (Boolean.TRUE.equals(checkNull(filePath))) {
            logger.log(Level.INFO, " file path cannot be empty");
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
        } catch (ResourceAccessException e) {
            e.printStackTrace();
        }
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
}
