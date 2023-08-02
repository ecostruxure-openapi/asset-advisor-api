package se.ecostruxure.sdk.example;
import se.ecostruxure.sdk.invoker.*;
import se.ecostruxure.sdk.client.SitesApi;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SitesEx {
    private static final String TOKEN_NAME = "token";
    private static final String BASEURL_NAME = "baseUrl";
    private static final Logger logger = Logger.getLogger("GetSites");
    public static void main(String[] args) {
        String token = null;
        String baseUrl = null;        
        for (int i=0;i<args.length;i++) {
            String[] arr = args[i].split("=");
            
            switch(arr[0]) {
            case TOKEN_NAME:
                token = findArgument(arr);
                break;
            case BASEURL_NAME:
                baseUrl = findArgument(arr);
                break;
            default: break;
            }
         }
        //To check the null conditions
        if (Boolean.TRUE.equals(checkNull(token))) {
            logger.log(Level.INFO,"Please Pass the token");
            return;
        }
       if (Boolean.TRUE.equals(checkNull(baseUrl))) {
           logger.log(Level.INFO,"Please Pass the baseUrl");
           return;
       }
        ApiClient defaultClient = new ApiClient();
        //defaultClient.setBasePath("https://se-exchange-uat-uat.apigee.net/ecostruxure/asset-advisor/v1");
        //defaultClient.setBearerToken("bQfZuMXQQx7uMnGqVoZU8CDztUUO");
        defaultClient.setBasePath(baseUrl);
        defaultClient.setBearerToken(token);
        SitesApi apiInstance = new SitesApi(defaultClient);
        try {
            
            System.out.println(apiInstance.getSites());
            System.out.println("xnbvcbxvcbn");
        } catch (Exception e) {
            System.out.println("exception");
            /*System.err.println("Exception when calling AssetHealthWebhookSubscriptionApi#deleteAssetHealthSubscription");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());*/
            e.printStackTrace();
        }
    }
    /**
     * check the value null.
     * @param arguments
     * @return
     */
    public static Boolean checkNull(String arguments) {
        if(arguments == null) {
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
}
