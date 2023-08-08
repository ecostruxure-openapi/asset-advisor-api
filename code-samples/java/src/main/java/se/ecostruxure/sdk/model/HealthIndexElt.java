/*
 * EcoStruxure™ Asset Advisor API
 * # Overview Asset Advisor API allows customers to collect and manage status and health of critical assets in electrical distribution networks.  ## Trial version  This API is a trial version available free of charge for selected customers and limited period.  For more information please contact the [Schneider Electric Exchange support team](mailto:exchange.support@se.com).  ## API overview and usage These API enables the following operations:  **Sites and Assets** - Browse and discover sites and assets information. - Provide sites and assets specific details (e.g. risk level, health indexes).  **Tickets** - Access all tickets generated on all assets from all sites. - Access all tickets for a given asset of a site. - Provide tickets specific details.  ## How it works This API works for any Schneider Electric customer who has an identity in the Schneider Electric cIAM system. Nevertheless, customers must subscribe to this API to use it. The current version of the API is including the operations that are described below.  ### Explore Sites This set of APIs allows the customer to browse all their Sites registered in Asset Advisor.  It is possible to access basic information of each site, such as ID, name, address, and location, which allows customers to do a mapping of Asset Advisor sites with their own representation and IDs, and also to locate all Sites in a map.  With the detailed view of a Site, customers are able to access information such as the Service Level subscribed for the Site, the Global Risk Level of the Site and the Health Matrix of the Site (including criticality and health index).  ### Explore Assets This set of APIs allows the customer to browse all Assets for a specific Site registered in Asset Advisor.  It is possible to have two different views of the Assets within a given Site. The first one is the List View, providing a standard list of assets for a given Site, including asset information such as ID, name, description, type, and criticality. The second view is a Tree View, providing the entire hierarchy of assets for a given Site, allowing customers to build a complete Site topology.  Finally, it is possible to get specific details of each Asset, including the health index, maintenance information, and many other technical details.   ### Access Tickets This set of APIs allows the customer to retrieve all tickets in Asset Advisor, including both alarms and recommendations. These tickets are either triggered by the Asset Advisor Analytics modules or manually created by Schneider Electric experts. This information allows customers to create their own customized dashboards with all tickets of their electrical distribution networks.  It is possible to query tickets using some filters such as:  - By date range (ticket creation date)  - By status (e.g. only \"Opened\" tickets)  - By priority (e.g. Only \"High\" priority tickets)  Besides the above filters, it's also possible to limit the number of tickets in the response or retrieving specific range of tickets by setting the offset & limit filters for pagination capability. These queries return a list of \"light\" tickets, providing basic information such as title, description, asset, site, priority, status and creation date.   It is also possible to retrieve all tickets for a particular Asset of a Site, with similar filtering and pagination capabilities. This allows customers to create a consolidated view of tickets for a particular Asset of a Site.  Finally, it is possible to get specific details of each Ticket, including information such as priority, status, creation date, history of changes, comments and attachments. This allows customers to create a detailed view of each ticket.  ### Webhook Subscription This set of APIs allows the customer to register, update, remove and get webhook subscription to be notified on update on some topics. Currently the topics concerning are:  **Ticket** - Notified on any ticket modification.  - Currenlty, notification are sent when the ticket *\"priority\" or \"activity\"* changed. - Set *\"All\"* for both priority and activity filter during subscription to get notified for all ticket events.  **Asset Health** - Notified when the asset health changed. - *\"healthIndexThreshold\"* is a mandatory filter to create a subscription and get notified only when the asset health value changed with a value equals or above this threshold. - *\"sitesScope\"* is an optional filter to restrict the notification to a site id list.  **Site Risk Level** - Notified when the site global risk level changed. - *\"riskLevelThreshold\"* is a mandatory filter to create a subscription and get notified only when the site risk level value changed with a value equals or above this threshold. - *\"sitesScope\"* is an optional filter to restrict the notification to a site id list.  In each subscription you can add filters to get notifed on only some conditions. You must provide a callback URL where you will receive the notifications. When any event matching your subscription is available, callback URL you provided us will be notified.  For all topics, the message format sent to the callback URL is the following: ```json {     \"topic\": \"{topicName}\", // enum {Ticket, AssetHealth, SiteRiskLevel}     \"id\": \"{topic id string}\", // \"guid\" of the Ticket, of the asset or the site     \"siteId\": \"string\", // \"guid\" of the Site     \"assetId\": \"string\", // \"guid\" of the Asset     \"timestamp\" : \"string\", // ISO 8601 format, \"2023-02-08T17:09:44+00:00\"             \"events\": [   {    \"key\": \"{event property name}\",     \"oldValue\": \"{Previous value if possible}\",    \"newValue\": \"{New Value}\"   }       ]     } ```  # Documentation  ## How to sign up The current version of the API does not allow subscriptions on demand.  Selected customers will be signed up manually, based on specific agreements with Schneider Electric, and will be able to access the API with the following information:  **Step 1:** Receive the Exchange URL access for the API product.  **Step 2:** [Register or login](https://exchange.se.com) with an Exchange account.  **Step 3:** Generate a Personal Access Token (PAT) in the developer portal (API credentials and usage details are also available).  ## Code Sample  You can leverage the following code samples to integrate the API faster in your application:  <div id=\"gitsample\"></div>  ## Support  Contact the SE Exchange support team at exchange.support@se.com and include,      - Endpoint URL     - Request/Response of the URL     - Any additional information like Screenshots, Postman collections  ---  
 *
 * The version of the OpenAPI document: 1.2.0
 * Contact: exchange.support@se.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package se.ecostruxure.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * HealthIndexElt
 */
@JsonPropertyOrder({
  HealthIndexElt.JSON_PROPERTY_CRITICALITY,
  HealthIndexElt.JSON_PROPERTY_HEALTH_INDEX,
  HealthIndexElt.JSON_PROPERTY_NB_ASSET
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-02T14:43:51.240218900+05:30[Asia/Calcutta]")
public class HealthIndexElt {
  public static final String JSON_PROPERTY_CRITICALITY = "criticality";
  private JsonNullable<Object> criticality = JsonNullable.<Object>of(null);

  public static final String JSON_PROPERTY_HEALTH_INDEX = "healthIndex";
  private JsonNullable<Object> healthIndex = JsonNullable.<Object>of(null);

  public static final String JSON_PROPERTY_NB_ASSET = "nbAsset";
  private JsonNullable<Object> nbAsset = JsonNullable.<Object>of(null);

  public HealthIndexElt() {
  }

  public HealthIndexElt criticality(Object criticality) {
    this.criticality = JsonNullable.<Object>of(criticality);
    
    return this;
  }

   /**
   * Criticality of the Cell
   * minimum: 0
   * maximum: 3
   * @return criticality
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "Criticality of the Cell")
  @JsonIgnore

  public Object getCriticality() {
        return criticality.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CRITICALITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getCriticality_JsonNullable() {
    return criticality;
  }
  
  @JsonProperty(JSON_PROPERTY_CRITICALITY)
  public void setCriticality_JsonNullable(JsonNullable<Object> criticality) {
    this.criticality = criticality;
  }

  public void setCriticality(Object criticality) {
    this.criticality = JsonNullable.<Object>of(criticality);
  }


  public HealthIndexElt healthIndex(Object healthIndex) {
    this.healthIndex = JsonNullable.<Object>of(healthIndex);
    
    return this;
  }

   /**
   * Health Index of the Cell
   * minimum: 1
   * maximum: 5
   * @return healthIndex
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "Health Index of the Cell")
  @JsonIgnore

  public Object getHealthIndex() {
        return healthIndex.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_HEALTH_INDEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getHealthIndex_JsonNullable() {
    return healthIndex;
  }
  
  @JsonProperty(JSON_PROPERTY_HEALTH_INDEX)
  public void setHealthIndex_JsonNullable(JsonNullable<Object> healthIndex) {
    this.healthIndex = healthIndex;
  }

  public void setHealthIndex(Object healthIndex) {
    this.healthIndex = JsonNullable.<Object>of(healthIndex);
  }


  public HealthIndexElt nbAsset(Object nbAsset) {
    this.nbAsset = JsonNullable.<Object>of(nbAsset);
    
    return this;
  }

   /**
   * Number of Assets in current Cell
   * @return nbAsset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "8", value = "Number of Assets in current Cell")
  @JsonIgnore

  public Object getNbAsset() {
        return nbAsset.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NB_ASSET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getNbAsset_JsonNullable() {
    return nbAsset;
  }
  
  @JsonProperty(JSON_PROPERTY_NB_ASSET)
  public void setNbAsset_JsonNullable(JsonNullable<Object> nbAsset) {
    this.nbAsset = nbAsset;
  }

  public void setNbAsset(Object nbAsset) {
    this.nbAsset = JsonNullable.<Object>of(nbAsset);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HealthIndexElt healthIndexElt = (HealthIndexElt) o;
    return equalsNullable(this.criticality, healthIndexElt.criticality) &&
        equalsNullable(this.healthIndex, healthIndexElt.healthIndex) &&
        equalsNullable(this.nbAsset, healthIndexElt.nbAsset);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(criticality), hashCodeNullable(healthIndex), hashCodeNullable(nbAsset));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealthIndexElt {\n");
    sb.append("    criticality: ").append(toIndentedString(criticality)).append("\n");
    sb.append("    healthIndex: ").append(toIndentedString(healthIndex)).append("\n");
    sb.append("    nbAsset: ").append(toIndentedString(nbAsset)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
