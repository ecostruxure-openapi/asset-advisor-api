package se.ecostruxure.sdk.client;

import se.ecostruxure.sdk.invoker.ApiClient;

import se.ecostruxure.sdk.model.Error400;
import se.ecostruxure.sdk.model.Error401;
import se.ecostruxure.sdk.model.Error403;
import se.ecostruxure.sdk.model.Error404;
import se.ecostruxure.sdk.model.Error500;
import se.ecostruxure.sdk.model.Supscription;
import se.ecostruxure.sdk.model.TicketSubscriptionConfig;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-14T11:47:02.186506600+05:30[Asia/Calcutta]")
@Component("se.ecostruxure.sdk.client.TicketWebhookSubscriptionApi")
public class TicketWebhookSubscriptionApi {
    private ApiClient apiClient;

    public TicketWebhookSubscriptionApi() {
        this(new ApiClient());
    }

    @Autowired
    public TicketWebhookSubscriptionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete ticket subscription
     * Delete a ticket subscription
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The subscription was not found
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the ticket subscription (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTicketSubscription(Object subscriptionId) throws RestClientException {
        deleteTicketSubscriptionWithHttpInfo(subscriptionId);
    }

    /**
     * Delete ticket subscription
     * Delete a ticket subscription
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The subscription was not found
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the ticket subscription (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTicketSubscriptionWithHttpInfo(Object subscriptionId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subscriptionId' when calling deleteTicketSubscription");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("subscriptionId", subscriptionId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "PersonalAccessToken" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/webhooks/subscriptions/ticket/{subscriptionId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get ticket subscription
     * Retrieve a ticket subscription
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The subscription was not found
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the ticket subscription (required)
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object getTicketSubscription(Object subscriptionId) throws RestClientException {
        return getTicketSubscriptionWithHttpInfo(subscriptionId).getBody();
    }

    /**
     * Get ticket subscription
     * Retrieve a ticket subscription
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The subscription was not found
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the ticket subscription (required)
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> getTicketSubscriptionWithHttpInfo(Object subscriptionId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subscriptionId' when calling getTicketSubscription");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("subscriptionId", subscriptionId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "PersonalAccessToken" };

        ParameterizedTypeReference<Object> localReturnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI("/webhooks/subscriptions/ticket/{subscriptionId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get ticket subscriptions
     * Retrieve all ticket subscriptions currently set
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object getTicketSubscriptionList() throws RestClientException {
        return getTicketSubscriptionListWithHttpInfo().getBody();
    }

    /**
     * Get ticket subscriptions
     * Retrieve all ticket subscriptions currently set
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> getTicketSubscriptionListWithHttpInfo() throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "PersonalAccessToken" };

        ParameterizedTypeReference<Object> localReturnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI("/webhooks/subscriptions/ticket", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Create ticket subscription
     * Register a new ticket subscription
     * <p><b>201</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param ticketSubscriptionConfig Ticket subscription (required)
     * @return Supscription
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Supscription postTicketSubscription(TicketSubscriptionConfig ticketSubscriptionConfig) throws RestClientException {
        return postTicketSubscriptionWithHttpInfo(ticketSubscriptionConfig).getBody();
    }

    /**
     * Create ticket subscription
     * Register a new ticket subscription
     * <p><b>201</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param ticketSubscriptionConfig Ticket subscription (required)
     * @return ResponseEntity&lt;Supscription&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Supscription> postTicketSubscriptionWithHttpInfo(TicketSubscriptionConfig ticketSubscriptionConfig) throws RestClientException {
        Object localVarPostBody = ticketSubscriptionConfig;
        
        // verify the required parameter 'ticketSubscriptionConfig' is set
        if (ticketSubscriptionConfig == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ticketSubscriptionConfig' when calling postTicketSubscription");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "PersonalAccessToken" };

        ParameterizedTypeReference<Supscription> localReturnType = new ParameterizedTypeReference<Supscription>() {};
        return apiClient.invokeAPI("/webhooks/subscriptions/ticket", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update ticket subscription
     * Update a ticket subscription
     * <p><b>200</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The subscription was not found
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the ticket subscription (required)
     * @param ticketSubscriptionConfig Ticket subscription (required)
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object putTicketSubscription(Object subscriptionId, TicketSubscriptionConfig ticketSubscriptionConfig) throws RestClientException {
        return putTicketSubscriptionWithHttpInfo(subscriptionId, ticketSubscriptionConfig).getBody();
    }

    /**
     * Update ticket subscription
     * Update a ticket subscription
     * <p><b>200</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The subscription was not found
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the ticket subscription (required)
     * @param ticketSubscriptionConfig Ticket subscription (required)
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> putTicketSubscriptionWithHttpInfo(Object subscriptionId, TicketSubscriptionConfig ticketSubscriptionConfig) throws RestClientException {
        Object localVarPostBody = ticketSubscriptionConfig;
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subscriptionId' when calling putTicketSubscription");
        }
        
        // verify the required parameter 'ticketSubscriptionConfig' is set
        if (ticketSubscriptionConfig == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ticketSubscriptionConfig' when calling putTicketSubscription");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("subscriptionId", subscriptionId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "PersonalAccessToken" };

        ParameterizedTypeReference<Object> localReturnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI("/webhooks/subscriptions/ticket/{subscriptionId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
