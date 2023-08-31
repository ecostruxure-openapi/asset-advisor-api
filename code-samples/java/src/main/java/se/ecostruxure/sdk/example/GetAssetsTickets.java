package se.ecostruxure.sdk.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import se.ecostruxure.sdk.client.TicketsApi;
import se.ecostruxure.sdk.invoker.ApiClient;

/**
 * @author anusha_paras
 */
public class GetAssetsTickets {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String token = null;
        String baseUrl = null;
        String siteId = null;
        String assetId = null;
        Object offset = 0;
        Object limit = 50;
        List<String> statusVal = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            String[] arr = args[i].split("=");
            switch (arr[0]) {
            case TOKEN_NAME:
                token = findArgument(arr);
                break;
            case BASEURL_NAME:
                baseUrl = findArgument(arr);
                break;
            case ASSET_ID:
                assetId = findArgument(arr);
                break;
            case SITE_ID:
                siteId = findArgument(arr);
                break;
            case STATUS_VAL:
                statusVal.add(findArgument(arr));
                break;
            case OFFSET:
                Boolean offsetBool = Objects.nonNull(findArgument(arr));
                if (Boolean.TRUE.equals(offsetBool)) {
                    offset = findArgument(arr);
                }
                break;
            case LIMIT:
                Boolean limitBool = Objects.nonNull(findArgument(arr));
                if (Boolean.TRUE.equals(limitBool)) {
                    limit = findArgument(arr);
                }
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
        if (Boolean.TRUE.equals(checkNull(siteId))) {
            statusMessage(SITE_ID);
            return;
        }
        if (Boolean.TRUE.equals(checkNull(assetId))) {
            statusMessage(ASSET_ID);
            return;
        }

        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath(baseUrl);
        defaultClient.setBearerToken(token);

        TicketsApi apiInstances = new TicketsApi(defaultClient);
        try {
            System.out.println(apiInstances.getAssetsTickets(siteId, assetId,
                    statusVal, offset, limit));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public static Map<String, Object> getDetailsErrorMessage(
            String errorMessage) {
        Map<String, Object> details = new HashMap<>();
        details.put("type", "/sites/{siteId}/assets/{assetId}/tickets");
        details.put("title", BAD_REQUEST);
        details.put(STATUS_VAL, STATUS);
        details.put("detail", errorMessage);
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
     * 
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
    private static final String BAD_REQUEST = "Bad Request";
    private static final String SITE_ID = "siteId";
    private static final String ASSET_ID = "assetId";
    private static final String STATUS_VAL = "status";
    private static final String OFFSET = "offset";
    private static final String LIMIT = "limit";
    private static final Integer STATUS = 400;
}
