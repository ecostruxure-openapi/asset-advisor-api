package se.ecostruxure.sdk.example;

import java.time.LocalDate;
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
public class GetTicketsList {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String token = null;
        String baseUrl = null;
        Object offset = 0;
        Object limit = 50;
        LocalDate now = LocalDate.now();
        List<String> statusVal = new ArrayList<>();
        List<String> priority = new ArrayList<>();
        String createdFrom = now.minusDays(30).toString();
        String createdTo = now.minusDays(30).toString();
        for (int i = 0; i < args.length; i++) {
            String[] arr = args[i].split("=");
            switch (arr[0]) {
            case TOKEN_NAME:
                token = findArgument(arr);
                break;
            case BASEURL_NAME:
                baseUrl = findArgument(arr);
                break;
            case STATUS_VAL:
                    statusVal.add(findArgument(arr));
                break;
            case PRIORITY:
                    priority.add(findArgument(arr));
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
            case CREATED_FROM:
                Boolean createdFromBool = Objects.nonNull(findArgument(arr));
                if (Boolean.TRUE.equals(createdFromBool)) {
                    createdFrom = findArgument(arr);
                }
                break;
            case CREATED_TO:
                Boolean createdToBool = Objects.nonNull(findArgument(arr));
                if (Boolean.TRUE.equals(createdToBool)) {
                    createdTo = findArgument(arr);
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
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath(baseUrl);
        defaultClient.setBearerToken(token);
        TicketsApi apiInstances = new TicketsApi(defaultClient);
        try {
            System.out.println(apiInstances.getTickets(createdFrom, createdTo,
                    statusVal, priority, offset, limit));
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
        details.put("type", "/tickets");
        details.put("title", BAD_REQUEST);
        details.put(STATUS_VAL, STATUS);
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
    private static final String STATUS_VAL = "status";
    private static final String OFFSET = "offset";
    private static final String LIMIT = "limit";
    private static final String PRIORITY = "priority";
    private static final String CREATED_FROM = "createdFrom";
    private static final String CREATED_TO = "createdTo";
    private static final Integer STATUS = 400;
}
