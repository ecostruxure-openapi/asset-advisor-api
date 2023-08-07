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
 * Site
 */
@JsonPropertyOrder({
  Site.JSON_PROPERTY_ID,
  Site.JSON_PROPERTY_NAME,
  Site.JSON_PROPERTY_COUNTRY,
  Site.JSON_PROPERTY_CITY,
  Site.JSON_PROPERTY_ADDRESS,
  Site.JSON_PROPERTY_ZIP_CODE,
  Site.JSON_PROPERTY_TIME_ZONE,
  Site.JSON_PROPERTY_LATITUDE,
  Site.JSON_PROPERTY_LONGITUDE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-02T14:43:51.240218900+05:30[Asia/Calcutta]")
public class Site {
  public static final String JSON_PROPERTY_ID = "id";
  private JsonNullable<Object> id = JsonNullable.<Object>of(null);

  public static final String JSON_PROPERTY_NAME = "name";
  private JsonNullable<Object> name = JsonNullable.<Object>of(null);

  public static final String JSON_PROPERTY_COUNTRY = "country";
  private JsonNullable<Object> country = JsonNullable.<Object>of(null);

  public static final String JSON_PROPERTY_CITY = "city";
  private JsonNullable<Object> city = JsonNullable.<Object>of(null);

  public static final String JSON_PROPERTY_ADDRESS = "address";
  private JsonNullable<Object> address = JsonNullable.<Object>of(null);

  public static final String JSON_PROPERTY_ZIP_CODE = "zipCode";
  private JsonNullable<Object> zipCode = JsonNullable.<Object>of(null);

  public static final String JSON_PROPERTY_TIME_ZONE = "timeZone";
  private JsonNullable<Object> timeZone = JsonNullable.<Object>of(null);

  public static final String JSON_PROPERTY_LATITUDE = "latitude";
  private JsonNullable<Object> latitude = JsonNullable.<Object>of(null);

  public static final String JSON_PROPERTY_LONGITUDE = "longitude";
  private JsonNullable<Object> longitude = JsonNullable.<Object>of(null);

  public Site() {
  }

  public Site id(Object id) {
    this.id = JsonNullable.<Object>of(id);
    
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1fa38c20-0b86-495f-a470-efb1bb6f8b1e", value = "")
  @JsonIgnore

  public Object getId() {
        return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getId_JsonNullable() {
    return id;
  }
  
  @JsonProperty(JSON_PROPERTY_ID)
  public void setId_JsonNullable(JsonNullable<Object> id) {
    this.id = id;
  }

  public void setId(Object id) {
    this.id = JsonNullable.<Object>of(id);
  }


  public Site name(Object name) {
    this.name = JsonNullable.<Object>of(name);
    
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Headquarters", value = "")
  @JsonIgnore

  public Object getName() {
        return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getName_JsonNullable() {
    return name;
  }
  
  @JsonProperty(JSON_PROPERTY_NAME)
  public void setName_JsonNullable(JsonNullable<Object> name) {
    this.name = name;
  }

  public void setName(Object name) {
    this.name = JsonNullable.<Object>of(name);
  }


  public Site country(Object country) {
    this.country = JsonNullable.<Object>of(country);
    
    return this;
  }

   /**
   * Get country
   * @return country
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Some Country", value = "")
  @JsonIgnore

  public Object getCountry() {
        return country.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getCountry_JsonNullable() {
    return country;
  }
  
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  public void setCountry_JsonNullable(JsonNullable<Object> country) {
    this.country = country;
  }

  public void setCountry(Object country) {
    this.country = JsonNullable.<Object>of(country);
  }


  public Site city(Object city) {
    this.city = JsonNullable.<Object>of(city);
    
    return this;
  }

   /**
   * Get city
   * @return city
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Some city", value = "")
  @JsonIgnore

  public Object getCity() {
        return city.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getCity_JsonNullable() {
    return city;
  }
  
  @JsonProperty(JSON_PROPERTY_CITY)
  public void setCity_JsonNullable(JsonNullable<Object> city) {
    this.city = city;
  }

  public void setCity(Object city) {
    this.city = JsonNullable.<Object>of(city);
  }


  public Site address(Object address) {
    this.address = JsonNullable.<Object>of(address);
    
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Full Address of site", value = "")
  @JsonIgnore

  public Object getAddress() {
        return address.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getAddress_JsonNullable() {
    return address;
  }
  
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  public void setAddress_JsonNullable(JsonNullable<Object> address) {
    this.address = address;
  }

  public void setAddress(Object address) {
    this.address = JsonNullable.<Object>of(address);
  }


  public Site zipCode(Object zipCode) {
    this.zipCode = JsonNullable.<Object>of(zipCode);
    
    return this;
  }

   /**
   * Get zipCode
   * @return zipCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "90210", value = "")
  @JsonIgnore

  public Object getZipCode() {
        return zipCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ZIP_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getZipCode_JsonNullable() {
    return zipCode;
  }
  
  @JsonProperty(JSON_PROPERTY_ZIP_CODE)
  public void setZipCode_JsonNullable(JsonNullable<Object> zipCode) {
    this.zipCode = zipCode;
  }

  public void setZipCode(Object zipCode) {
    this.zipCode = JsonNullable.<Object>of(zipCode);
  }


  public Site timeZone(Object timeZone) {
    this.timeZone = JsonNullable.<Object>of(timeZone);
    
    return this;
  }

   /**
   * Get timeZone
   * @return timeZone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "CST", value = "")
  @JsonIgnore

  public Object getTimeZone() {
        return timeZone.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TIME_ZONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getTimeZone_JsonNullable() {
    return timeZone;
  }
  
  @JsonProperty(JSON_PROPERTY_TIME_ZONE)
  public void setTimeZone_JsonNullable(JsonNullable<Object> timeZone) {
    this.timeZone = timeZone;
  }

  public void setTimeZone(Object timeZone) {
    this.timeZone = JsonNullable.<Object>of(timeZone);
  }


  public Site latitude(Object latitude) {
    this.latitude = JsonNullable.<Object>of(latitude);
    
    return this;
  }

   /**
   * Get latitude
   * @return latitude
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "45.1234", value = "")
  @JsonIgnore

  public Object getLatitude() {
        return latitude.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LATITUDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getLatitude_JsonNullable() {
    return latitude;
  }
  
  @JsonProperty(JSON_PROPERTY_LATITUDE)
  public void setLatitude_JsonNullable(JsonNullable<Object> latitude) {
    this.latitude = latitude;
  }

  public void setLatitude(Object latitude) {
    this.latitude = JsonNullable.<Object>of(latitude);
  }


  public Site longitude(Object longitude) {
    this.longitude = JsonNullable.<Object>of(longitude);
    
    return this;
  }

   /**
   * Get longitude
   * @return longitude
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "-3.1234", value = "")
  @JsonIgnore

  public Object getLongitude() {
        return longitude.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LONGITUDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getLongitude_JsonNullable() {
    return longitude;
  }
  
  @JsonProperty(JSON_PROPERTY_LONGITUDE)
  public void setLongitude_JsonNullable(JsonNullable<Object> longitude) {
    this.longitude = longitude;
  }

  public void setLongitude(Object longitude) {
    this.longitude = JsonNullable.<Object>of(longitude);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Site site = (Site) o;
    return equalsNullable(this.id, site.id) &&
        equalsNullable(this.name, site.name) &&
        equalsNullable(this.country, site.country) &&
        equalsNullable(this.city, site.city) &&
        equalsNullable(this.address, site.address) &&
        equalsNullable(this.zipCode, site.zipCode) &&
        equalsNullable(this.timeZone, site.timeZone) &&
        equalsNullable(this.latitude, site.latitude) &&
        equalsNullable(this.longitude, site.longitude);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(id), hashCodeNullable(name), hashCodeNullable(country), hashCodeNullable(city), hashCodeNullable(address), hashCodeNullable(zipCode), hashCodeNullable(timeZone), hashCodeNullable(latitude), hashCodeNullable(longitude));
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
    sb.append("class Site {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
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

