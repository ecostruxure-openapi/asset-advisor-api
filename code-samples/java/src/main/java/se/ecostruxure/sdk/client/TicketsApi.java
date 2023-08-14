package se.ecostruxure.sdk.client;

import se.ecostruxure.sdk.invoker.ApiClient;

import se.ecostruxure.sdk.model.Error400;
import se.ecostruxure.sdk.model.Error401;
import se.ecostruxure.sdk.model.Error403;
import se.ecostruxure.sdk.model.Error404;
import se.ecostruxure.sdk.model.Error500;
import se.ecostruxure.sdk.model.Tickets;

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
@Component("se.ecostruxure.sdk.client.TicketsApi")
public class TicketsApi {
    private ApiClient apiClient;

    public TicketsApi() {
        this(new ApiClient());
    }

    @Autowired
    public TicketsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Assets Tickets
     * List all Tickets of a particular Asset within a Site, with the abilitiy to filter by status and pagination capability. The current sort criteria used for the tickets is the creation date in descending order.
     * <p><b>200</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The Site or Asset was not found
     * <p><b>500</b> - Internal Server Error
     * @param siteId ID of the Site (required)
     * @param assetId ID of the Asset (required)
     * @param status Allow to filter on particular Status (optional)
     * @param offset The number of items to skip before starting to collect the result set. (optional, default to 0)
     * @param limit The numbers of items to return. (optional, default to 50)
     * @return Tickets
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Tickets getAssetsTickets(Object siteId, Object assetId, Object status, Object offset, Object limit) throws RestClientException {
        return getAssetsTicketsWithHttpInfo(siteId, assetId, status, offset, limit).getBody();
    }

    /**
     * Assets Tickets
     * List all Tickets of a particular Asset within a Site, with the abilitiy to filter by status and pagination capability. The current sort criteria used for the tickets is the creation date in descending order.
     * <p><b>200</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The Site or Asset was not found
     * <p><b>500</b> - Internal Server Error
     * @param siteId ID of the Site (required)
     * @param assetId ID of the Asset (required)
     * @param status Allow to filter on particular Status (optional)
     * @param offset The number of items to skip before starting to collect the result set. (optional, default to 0)
     * @param limit The numbers of items to return. (optional, default to 50)
     * @return ResponseEntity&lt;Tickets&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Tickets> getAssetsTicketsWithHttpInfo(Object siteId, Object assetId, Object status, Object offset, Object limit) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'siteId' is set
        if (siteId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'siteId' when calling getAssetsTickets");
        }
        
        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'assetId' when calling getAssetsTickets");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("siteId", siteId);
        uriVariables.put("assetId", assetId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "PersonalAccessToken" };

        ParameterizedTypeReference<Tickets> localReturnType = new ParameterizedTypeReference<Tickets>() {};
        return apiClient.invokeAPI("/sites/{siteId}/assets/{assetId}/tickets", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Ticket details
     * Get details of a particular Ticket, including the history of what happened on the ticket.
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The Ticket was not found
     * <p><b>500</b> - Internal Server Error
     * @param ticketId ID of the Ticket (required)
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object getTicketDetails(Object ticketId) throws RestClientException {
        return getTicketDetailsWithHttpInfo(ticketId).getBody();
    }

    /**
     * Ticket details
     * Get details of a particular Ticket, including the history of what happened on the ticket.
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The Ticket was not found
     * <p><b>500</b> - Internal Server Error
     * @param ticketId ID of the Ticket (required)
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> getTicketDetailsWithHttpInfo(Object ticketId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'ticketId' is set
        if (ticketId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ticketId' when calling getTicketDetails");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("ticketId", ticketId);

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
        return apiClient.invokeAPI("/tickets/{ticketId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Tickets list
     * List all Tickets for all Assets and Sites, with different query criteria (date, status, priority) and pagination capability. The current sort criteria used for the tickets is the creation date in descending order.
     * <p><b>200</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Internal Server Error
     * @param createdFrom Allow to filter on particular CreationDate range (default to last 30 days) (optional)
     * @param createdTo Allow to filter on particular CreationDate range (default to last 30 days) (optional)
     * @param status Allow to filter on particular Status (optional)
     * @param priority Allow to filter on particular Priority (optional)
     * @param offset The number of items to skip before starting to collect the result set. (optional, default to 0)
     * @param limit The numbers of items to return. (optional, default to 50)
     * @return Tickets
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Tickets getTickets(Object createdFrom, Object createdTo, Object status, Object priority, Object offset, Object limit) throws RestClientException {
        return getTicketsWithHttpInfo(createdFrom, createdTo, status, priority, offset, limit).getBody();
    }

    /**
     * Tickets list
     * List all Tickets for all Assets and Sites, with different query criteria (date, status, priority) and pagination capability. The current sort criteria used for the tickets is the creation date in descending order.
     * <p><b>200</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Internal Server Error
     * @param createdFrom Allow to filter on particular CreationDate range (default to last 30 days) (optional)
     * @param createdTo Allow to filter on particular CreationDate range (default to last 30 days) (optional)
     * @param status Allow to filter on particular Status (optional)
     * @param priority Allow to filter on particular Priority (optional)
     * @param offset The number of items to skip before starting to collect the result set. (optional, default to 0)
     * @param limit The numbers of items to return. (optional, default to 50)
     * @return ResponseEntity&lt;Tickets&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Tickets> getTicketsWithHttpInfo(Object createdFrom, Object createdTo, Object status, Object priority, Object offset, Object limit) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "createdFrom", createdFrom));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "createdTo", createdTo));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "priority", priority));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "PersonalAccessToken" };

        ParameterizedTypeReference<Tickets> localReturnType = new ParameterizedTypeReference<Tickets>() {};
        return apiClient.invokeAPI("/tickets", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
