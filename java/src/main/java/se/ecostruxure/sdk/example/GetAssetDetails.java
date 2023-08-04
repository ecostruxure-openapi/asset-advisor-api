package se.ecostruxure.sdk.example;

import java.util.logging.Level;
import java.util.logging.Logger;

import se.ecostruxure.sdk.client.AssetsApi;
import se.ecostruxure.sdk.invoker.ApiClient;

public class GetAssetDetails {
    public static void main(String[] args) {
        String token = null;
        String baseUrl = null; 
        String siteId = null;
        String assetId = null;
        for (int i=0;i<args.length;i++) {
            String[] arr = args[i].split("=");            
            switch(arr[0]) {
            case TOKEN_NAME:
                token = findArgument(arr);
                break;
            case BASEURL_NAME:
                baseUrl = findArgument(arr);
                break;
            case SITE_ID:
                siteId = findArgument(arr);
                break;
            case ASSET_ID:
                assetId = findArgument(arr);
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
       if (Boolean.TRUE.equals(checkNull(siteId))) {
           logger.log(Level.INFO,"Please Pass the siteId");
           return;
       }
       if (Boolean.TRUE.equals(checkNull(assetId))) {
           logger.log(Level.INFO,"Please Pass the assetId");
           return;
       }
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath(baseUrl);
        defaultClient.setBearerToken(token);
        AssetsApi assetapiInstance = new AssetsApi(defaultClient);
        try {
            System.out.println(assetapiInstance.getAssetsTree(siteId));
        } catch (Exception e) {
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
    private static final String TOKEN_NAME = "token";
    private static final String BASEURL_NAME = "baseUrl";
    private static final String SITE_ID = "siteId";
    private static final String ASSET_ID = "assetId";
    private static final Logger logger = Logger.getLogger("GetAssetDetails");

}
