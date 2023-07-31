package se.ecostruxure.sdk.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class Sites {
      public static void main(String [] args) throws IOException, InterruptedException {
        String token = null;
        String baseUrl = null;
        String siteId = null;
        for (int i=0;i<args.length;i++) {
            String[] arr = args[i].split("=");
            switch(arr[0]) {
            case TOKEN_NAME:
                token = findArgument(arr);
                break;
            case BASEURL_NAME:
                baseUrl = findArgument(arr);
                break;
            case SITEID_NAME:
                siteId = findArgument(arr);
                break;
            default: break;
            }
        }
        //To check the null conditions
        if (Boolean.TRUE.equals(checkNull(token))) {
            statusMessage(TOKEN_NAME);
            return;
        }
       if (Boolean.TRUE.equals(checkNull(baseUrl))) {
           statusMessage(BASEURL_NAME);
           return;
       }
       String uriBuilder = null;
        if (Boolean.TRUE.equals(checkNull(siteId))) {
            uriBuilder = baseUrl.concat(END_POINTS_GETSITES);
        } else {
       //build url
            uriBuilder = generateUrl(baseUrl, END_POINTS_GET_LIST_SITES, siteId);
        }
         //build token
         String accessToken = getSitesRequestsToken(token);
         // call the api
         HttpResponse<String> getSitesRequestsResponse = getSitesRequestsHttpClient(accessToken, uriBuilder);
         logger.log(Level.INFO,getSitesRequestsResponse.body());
      }
       /**
        * statusMessage.
        * @param argument
        */
       private static void statusMessage(String argument) {
           String errorMessage = null;
           System.out.println("Status = "+STATUS);
           errorMessage = argument.concat(" cannot be empty");
           logger.log(Level.INFO,getDetailsErrorMessage(errorMessage).toString());
       }
       
        /**
         * @param errorMessage
         * @return Map
         */
        public static Map<String,Object> getDetailsErrorMessage(String errorMessage) {
            Map<String,Object> details = new HashMap<>();
            details.put("type","/sites");
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
    /**
        * generateUrl.
        * @param baseUrl
        * @param endpoints
        * @param siteId
        * @return String
        */
        public static String generateUrl(String baseUrl, String endpoints, String siteId) {
                return baseUrl.concat(endpoints.replace(SITEID_NAME, siteId));          
        }
         /**
         * createCertificationRequests access token.
         * @param token
         * @param baseUrl
         * @return String
         * @throws IOException
         * @throws InterruptedException
         */
        public static String getSitesRequestsToken(String token) {
            return BEARER.concat(token);
        }
        /**
         * getSitesRequestsHttpClient.
         * @param accessToken
         * @param baseUrl
         * @return String
         * @throws IOException
         * @throws InterruptedException
         */
        public static HttpResponse<String> getSitesRequestsHttpClient(
                String accessToken, String baseUrl) throws IOException, InterruptedException {
            URI uri = URI.create(baseUrl);
             HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                 .GET()
                .headers(AUTHORIZATION, accessToken)
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new IOException("Provided URL not Found.");
        } catch (InterruptedException ex) {
            throw new InterruptedException("Interrupted please check your request.");
        }
        return response;
        }
         // Constants
         private static final Logger logger = Logger.getLogger("Sites");
         private static final String TOKEN_NAME = "token";
         private static final String BASEURL_NAME = "baseUrl";
         private static final String SITEID_NAME = "siteId";
         private static final String END_POINTS_GETSITES = "/v1/sites";
          private static final String END_POINTS_GET_LIST_SITES = "/v1/sites/siteId";
         private static final String BEARER = "Bearer ";
         private static final String AUTHORIZATION = "Authorization";
         private static final String BAD_REQUEST = "Bad Request";
         private static final Integer STATUS = 400;
}