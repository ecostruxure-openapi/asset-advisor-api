package se.ecostruxure.sdk.client;

import se.ecostruxure.sdk.invoker.ApiClient;

import se.ecostruxure.sdk.model.AssetHealthSubscriptionConfig;
import se.ecostruxure.sdk.model.Error400;
import se.ecostruxure.sdk.model.Error401;
import se.ecostruxure.sdk.model.Error403;
import se.ecostruxure.sdk.model.Error404;
import se.ecostruxure.sdk.model.Error500;
import se.ecostruxure.sdk.model.Supscription;

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
@Component("se.ecostruxure.sdk.client.AssetHealthWebhookSubscriptionApi")
public class AssetHealthWebhookSubscriptionApi {
    private ApiClient apiClient;

    public AssetHealthWebhookSubscriptionApi() {
        this(new ApiClient());
    }

    @Autowired
    public AssetHealthWebhookSubscriptionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete asset health subscription
     * Delete an asset health subscription
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The subscription was not found
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the asset health subscription (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteAssetHealthSubscription(Object subscriptionId) throws RestClientException {
        deleteAssetHealthSubscriptionWithHttpInfo(subscriptionId);
    }

    /**
     * Delete asset health subscription
     * Delete an asset health subscription
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The subscription was not found
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the asset health subscription (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteAssetHealthSubscriptionWithHttpInfo(Object subscriptionId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subscriptionId' when calling deleteAssetHealthSubscription");
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
        return apiClient.invokeAPI("/webhooks/subscriptions/assethealth/{subscriptionId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get asset health subscription
     * Retrieve an asset health subscription
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the asset health subscription (required)
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object getAssetHealthSubscription(Object subscriptionId) throws RestClientException {
        return getAssetHealthSubscriptionWithHttpInfo(subscriptionId).getBody();
    }

    /**
     * Get asset health subscription
     * Retrieve an asset health subscription
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the asset health subscription (required)
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> getAssetHealthSubscriptionWithHttpInfo(Object subscriptionId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subscriptionId' when calling getAssetHealthSubscription");
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
        return apiClient.invokeAPI("/webhooks/subscriptions/assethealth/{subscriptionId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get asset health Subscriptions
     * Retrieve all asset health subscriptions currently set
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object getAssetHealthSubscriptionList() throws RestClientException {
        return getAssetHealthSubscriptionListWithHttpInfo().getBody();
    }

    /**
     * Get asset health Subscriptions
     * Retrieve all asset health subscriptions currently set
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> getAssetHealthSubscriptionListWithHttpInfo() throws RestClientException {
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
        return apiClient.invokeAPI("/webhooks/subscriptions/assethealth", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Create asset health subscription
     * Register a new asset health subscription
     * <p><b>201</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param assetHealthSubscriptionConfig Asset health  subscription (required)
     * @return Supscription
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Supscription postAssetHealthSubscription(AssetHealthSubscriptionConfig assetHealthSubscriptionConfig) throws RestClientException {
        return postAssetHealthSubscriptionWithHttpInfo(assetHealthSubscriptionConfig).getBody();
    }

    /**
     * Create asset health subscription
     * Register a new asset health subscription
     * <p><b>201</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param assetHealthSubscriptionConfig Asset health  subscription (required)
     * @return ResponseEntity&lt;Supscription&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Supscription> postAssetHealthSubscriptionWithHttpInfo(AssetHealthSubscriptionConfig assetHealthSubscriptionConfig) throws RestClientException {
        Object localVarPostBody = assetHealthSubscriptionConfig;
        
        // verify the required parameter 'assetHealthSubscriptionConfig' is set
        if (assetHealthSubscriptionConfig == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'assetHealthSubscriptionConfig' when calling postAssetHealthSubscription");
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
        return apiClient.invokeAPI("/webhooks/subscriptions/assethealth", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update asset health subscription
     * Update an asset health subscription
     * <p><b>200</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The subscription was not found
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the asset health subscription (required)
     * @param assetHealthSubscriptionConfig asset health subscription (required)
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object putAssetHealthSubscription(Object subscriptionId, AssetHealthSubscriptionConfig assetHealthSubscriptionConfig) throws RestClientException {
        return putAssetHealthSubscriptionWithHttpInfo(subscriptionId, assetHealthSubscriptionConfig).getBody();
    }

    /**
     * Update asset health subscription
     * Update an asset health subscription
     * <p><b>200</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The subscription was not found
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the asset health subscription (required)
     * @param assetHealthSubscriptionConfig asset health subscription (required)
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> putAssetHealthSubscriptionWithHttpInfo(Object subscriptionId, AssetHealthSubscriptionConfig assetHealthSubscriptionConfig) throws RestClientException {
        Object localVarPostBody = assetHealthSubscriptionConfig;
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subscriptionId' when calling putAssetHealthSubscription");
        }
        
        // verify the required parameter 'assetHealthSubscriptionConfig' is set
        if (assetHealthSubscriptionConfig == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'assetHealthSubscriptionConfig' when calling putAssetHealthSubscription");
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
        return apiClient.invokeAPI("/webhooks/subscriptions/assethealth/{subscriptionId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
