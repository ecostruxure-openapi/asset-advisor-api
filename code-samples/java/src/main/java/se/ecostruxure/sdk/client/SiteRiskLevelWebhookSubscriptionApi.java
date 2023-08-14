package se.ecostruxure.sdk.client;

import se.ecostruxure.sdk.invoker.ApiClient;

import se.ecostruxure.sdk.model.Error400;
import se.ecostruxure.sdk.model.Error401;
import se.ecostruxure.sdk.model.Error403;
import se.ecostruxure.sdk.model.Error404;
import se.ecostruxure.sdk.model.Error500;
import se.ecostruxure.sdk.model.SiteRiskLevelSubscriptionConfig;
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
@Component("se.ecostruxure.sdk.client.SiteRiskLevelWebhookSubscriptionApi")
public class SiteRiskLevelWebhookSubscriptionApi {
    private ApiClient apiClient;

    public SiteRiskLevelWebhookSubscriptionApi() {
        this(new ApiClient());
    }

    @Autowired
    public SiteRiskLevelWebhookSubscriptionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete site risk level subscription
     * Delete a site risk level subscription
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The subscription was not found
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the site risk level subscription (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteSiteRiskLevelSubscription(Object subscriptionId) throws RestClientException {
        deleteSiteRiskLevelSubscriptionWithHttpInfo(subscriptionId);
    }

    /**
     * Delete site risk level subscription
     * Delete a site risk level subscription
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The subscription was not found
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the site risk level subscription (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteSiteRiskLevelSubscriptionWithHttpInfo(Object subscriptionId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subscriptionId' when calling deleteSiteRiskLevelSubscription");
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
        return apiClient.invokeAPI("/webhooks/subscriptions/siterisklevel/{subscriptionId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get site risk level subscription
     * Retrieve a site risk level subscription
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the site risk level subscription (required)
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object getSiteRiskLevelSubscription(Object subscriptionId) throws RestClientException {
        return getSiteRiskLevelSubscriptionWithHttpInfo(subscriptionId).getBody();
    }

    /**
     * Get site risk level subscription
     * Retrieve a site risk level subscription
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the site risk level subscription (required)
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> getSiteRiskLevelSubscriptionWithHttpInfo(Object subscriptionId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subscriptionId' when calling getSiteRiskLevelSubscription");
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
        return apiClient.invokeAPI("/webhooks/subscriptions/siterisklevel/{subscriptionId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get site risk level subscriptions
     * Retrieve all site risk level subscriptions currently set
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object getSiteRiskLevelSubscriptionList() throws RestClientException {
        return getSiteRiskLevelSubscriptionListWithHttpInfo().getBody();
    }

    /**
     * Get site risk level subscriptions
     * Retrieve all site risk level subscriptions currently set
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> getSiteRiskLevelSubscriptionListWithHttpInfo() throws RestClientException {
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
        return apiClient.invokeAPI("/webhooks/subscriptions/siterisklevel", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Create site risk level subscription
     * Register a new site risk level subscription
     * <p><b>201</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param siteRiskLevelSubscriptionConfig Site risk level  subscription (required)
     * @return Supscription
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Supscription postSiteRiskLevelSubscription(SiteRiskLevelSubscriptionConfig siteRiskLevelSubscriptionConfig) throws RestClientException {
        return postSiteRiskLevelSubscriptionWithHttpInfo(siteRiskLevelSubscriptionConfig).getBody();
    }

    /**
     * Create site risk level subscription
     * Register a new site risk level subscription
     * <p><b>201</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param siteRiskLevelSubscriptionConfig Site risk level  subscription (required)
     * @return ResponseEntity&lt;Supscription&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Supscription> postSiteRiskLevelSubscriptionWithHttpInfo(SiteRiskLevelSubscriptionConfig siteRiskLevelSubscriptionConfig) throws RestClientException {
        Object localVarPostBody = siteRiskLevelSubscriptionConfig;
        
        // verify the required parameter 'siteRiskLevelSubscriptionConfig' is set
        if (siteRiskLevelSubscriptionConfig == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'siteRiskLevelSubscriptionConfig' when calling postSiteRiskLevelSubscription");
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
        return apiClient.invokeAPI("/webhooks/subscriptions/siterisklevel", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update site risk level subscription
     * Update a site risk level subscription
     * <p><b>200</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The subscription was not found
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the site risk level subscription (required)
     * @param siteRiskLevelSubscriptionConfig site risk level subscription (required)
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object putSiteRiskLevelSubscription(Object subscriptionId, SiteRiskLevelSubscriptionConfig siteRiskLevelSubscriptionConfig) throws RestClientException {
        return putSiteRiskLevelSubscriptionWithHttpInfo(subscriptionId, siteRiskLevelSubscriptionConfig).getBody();
    }

    /**
     * Update site risk level subscription
     * Update a site risk level subscription
     * <p><b>200</b> - Successful Response
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The subscription was not found
     * <p><b>500</b> - Server Error
     * @param subscriptionId Id of the site risk level subscription (required)
     * @param siteRiskLevelSubscriptionConfig site risk level subscription (required)
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> putSiteRiskLevelSubscriptionWithHttpInfo(Object subscriptionId, SiteRiskLevelSubscriptionConfig siteRiskLevelSubscriptionConfig) throws RestClientException {
        Object localVarPostBody = siteRiskLevelSubscriptionConfig;
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subscriptionId' when calling putSiteRiskLevelSubscription");
        }
        
        // verify the required parameter 'siteRiskLevelSubscriptionConfig' is set
        if (siteRiskLevelSubscriptionConfig == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'siteRiskLevelSubscriptionConfig' when calling putSiteRiskLevelSubscription");
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
        return apiClient.invokeAPI("/webhooks/subscriptions/siterisklevel/{subscriptionId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
