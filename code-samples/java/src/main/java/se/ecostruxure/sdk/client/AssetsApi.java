package se.ecostruxure.sdk.client;

import se.ecostruxure.sdk.invoker.ApiClient;

import se.ecostruxure.sdk.model.Error401;
import se.ecostruxure.sdk.model.Error403;
import se.ecostruxure.sdk.model.Error404;
import se.ecostruxure.sdk.model.Error500;

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
@Component("se.ecostruxure.sdk.client.AssetsApi")
public class AssetsApi {
    private ApiClient apiClient;

    public AssetsApi() {
        this(new ApiClient());
    }

    @Autowired
    public AssetsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Asset details
     * Get details of a particular Asset within a Site, including information such as service level, maintenance &amp; health indexes.
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The Site or Asset was not found
     * <p><b>500</b> - Internal Server Error
     * @param siteId ID of the Site (required)
     * @param assetId ID of the Asset (required)
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object getAssetDetails(Object siteId, Object assetId) throws RestClientException {
        return getAssetDetailsWithHttpInfo(siteId, assetId).getBody();
    }

    /**
     * Asset details
     * Get details of a particular Asset within a Site, including information such as service level, maintenance &amp; health indexes.
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The Site or Asset was not found
     * <p><b>500</b> - Internal Server Error
     * @param siteId ID of the Site (required)
     * @param assetId ID of the Asset (required)
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> getAssetDetailsWithHttpInfo(Object siteId, Object assetId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'siteId' is set
        if (siteId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'siteId' when calling getAssetDetails");
        }
        
        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'assetId' when calling getAssetDetails");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("siteId", siteId);
        uriVariables.put("assetId", assetId);

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
        return apiClient.invokeAPI("/sites/{siteId}/assets/{assetId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Assets list
     * List all Assets for a particular Site, including basic information such as ID, name, description, type and criticality.
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The Site was not found
     * <p><b>500</b> - Internal Server Error
     * @param siteId ID of the Site (required)
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object getAssets(Object siteId) throws RestClientException {
        return getAssetsWithHttpInfo(siteId).getBody();
    }

    /**
     * Assets list
     * List all Assets for a particular Site, including basic information such as ID, name, description, type and criticality.
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The Site was not found
     * <p><b>500</b> - Internal Server Error
     * @param siteId ID of the Site (required)
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> getAssetsWithHttpInfo(Object siteId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'siteId' is set
        if (siteId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'siteId' when calling getAssets");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("siteId", siteId);

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
        return apiClient.invokeAPI("/sites/{siteId}/assets", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Assets Tree View
     * Give the Assets tree view for a particular Site, including the complete relationships between all assets.
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The Site was not found
     * <p><b>500</b> - Internal Server Error
     * @param siteId ID of the Site (required)
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object getAssetsTree(Object siteId) throws RestClientException {
        return getAssetsTreeWithHttpInfo(siteId).getBody();
    }

    /**
     * Assets Tree View
     * Give the Assets tree view for a particular Site, including the complete relationships between all assets.
     * <p><b>200</b> - Successful Response
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The Site was not found
     * <p><b>500</b> - Internal Server Error
     * @param siteId ID of the Site (required)
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> getAssetsTreeWithHttpInfo(Object siteId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'siteId' is set
        if (siteId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'siteId' when calling getAssetsTree");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("siteId", siteId);

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
        return apiClient.invokeAPI("/sites/{siteId}/assets/treeview", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
