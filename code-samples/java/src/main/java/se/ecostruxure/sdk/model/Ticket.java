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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Ticket
 */
@JsonPropertyOrder({
  Ticket.JSON_PROPERTY_ID,
  Ticket.JSON_PROPERTY_CLIENT_TICKET_ID,
  Ticket.JSON_PROPERTY_TITLE,
  Ticket.JSON_PROPERTY_DESCRIPTION,
  Ticket.JSON_PROPERTY_ASSET_ID,
  Ticket.JSON_PROPERTY_SITE_ID,
  Ticket.JSON_PROPERTY_PRIORITY,
  Ticket.JSON_PROPERTY_STATUS,
  Ticket.JSON_PROPERTY_CREATION_DATE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-14T11:47:02.186506600+05:30[Asia/Calcutta]")
public class Ticket {
  public static final String JSON_PROPERTY_ID = "id";
  private Object id = null;

  public static final String JSON_PROPERTY_CLIENT_TICKET_ID = "clientTicketId";
  private Object clientTicketId = null;

  public static final String JSON_PROPERTY_TITLE = "title";
  private Object title = null;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private Object description = null;

  public static final String JSON_PROPERTY_ASSET_ID = "assetId";
  private Object assetId = null;

  public static final String JSON_PROPERTY_SITE_ID = "siteId";
  private Object siteId = null;

  public static final String JSON_PROPERTY_PRIORITY = "priority";
  private Object priority = null;

  public static final String JSON_PROPERTY_STATUS = "status";
  private Object status = null;

  public static final String JSON_PROPERTY_CREATION_DATE = "creationDate";
  private Object creationDate = null;

  public Ticket() {
  }

  public Ticket id(Object id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1fa38c20-0b86-495f-a470-efb1bb6f8b1e", value = "")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(Object id) {
    this.id = id;
  }


  public Ticket clientTicketId(Object clientTicketId) {
    
    this.clientTicketId = clientTicketId;
    return this;
  }

   /**
   * Ticket ID as seen in Asset Advisor application
   * @return clientTicketId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "105394", value = "Ticket ID as seen in Asset Advisor application")
  @JsonProperty(JSON_PROPERTY_CLIENT_TICKET_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getClientTicketId() {
    return clientTicketId;
  }


  @JsonProperty(JSON_PROPERTY_CLIENT_TICKET_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setClientTicketId(Object clientTicketId) {
    this.clientTicketId = clientTicketId;
  }


  public Ticket title(Object title) {
    
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Over Voltage on Asset 1B1 LV-MCC-001A", value = "")
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getTitle() {
    return title;
  }


  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTitle(Object title) {
    this.title = title;
  }


  public Ticket description(Object description) {
    
    this.description = description;
    return this;
  }

   /**
   * Detailed description of the issue
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "L3-L1 Over Voltage on Circuit Breaker 1B1 LV-MCC-001A. Threshold: 505 V, Value: 512.2 V", value = "Detailed description of the issue")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(Object description) {
    this.description = description;
  }


  public Ticket assetId(Object assetId) {
    
    this.assetId = assetId;
    return this;
  }

   /**
   * The Asset this ticket is linked to
   * @return assetId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1fa38c20-0b86-495f-a470-efb1bb6f8b1e", value = "The Asset this ticket is linked to")
  @JsonProperty(JSON_PROPERTY_ASSET_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getAssetId() {
    return assetId;
  }


  @JsonProperty(JSON_PROPERTY_ASSET_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAssetId(Object assetId) {
    this.assetId = assetId;
  }


  public Ticket siteId(Object siteId) {
    
    this.siteId = siteId;
    return this;
  }

   /**
   * The Site this ticket is linked to
   * @return siteId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1fa38c20-0b86-495f-a470-efb1bb6f8b1e", value = "The Site this ticket is linked to")
  @JsonProperty(JSON_PROPERTY_SITE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getSiteId() {
    return siteId;
  }


  @JsonProperty(JSON_PROPERTY_SITE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSiteId(Object siteId) {
    this.siteId = siteId;
  }


  public Ticket priority(Object priority) {
    
    this.priority = priority;
    return this;
  }

   /**
   * Get priority
   * @return priority
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PRIORITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getPriority() {
    return priority;
  }


  @JsonProperty(JSON_PROPERTY_PRIORITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPriority(Object priority) {
    this.priority = priority;
  }


  public Ticket status(Object status) {
    
    this.status = status;
    return this;
  }

   /**
   * Current state of the Ticket in the processing workflow
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Current state of the Ticket in the processing workflow")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(Object status) {
    this.status = status;
  }


  public Ticket creationDate(Object creationDate) {
    
    this.creationDate = creationDate;
    return this;
  }

   /**
   * This is the Creation Date into the system - Not the Issue Date
   * @return creationDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-05-19T10:00:00Z", value = "This is the Creation Date into the system - Not the Issue Date")
  @JsonProperty(JSON_PROPERTY_CREATION_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getCreationDate() {
    return creationDate;
  }


  @JsonProperty(JSON_PROPERTY_CREATION_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreationDate(Object creationDate) {
    this.creationDate = creationDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ticket ticket = (Ticket) o;
    return Objects.equals(this.id, ticket.id) &&
        Objects.equals(this.clientTicketId, ticket.clientTicketId) &&
        Objects.equals(this.title, ticket.title) &&
        Objects.equals(this.description, ticket.description) &&
        Objects.equals(this.assetId, ticket.assetId) &&
        Objects.equals(this.siteId, ticket.siteId) &&
        Objects.equals(this.priority, ticket.priority) &&
        Objects.equals(this.status, ticket.status) &&
        Objects.equals(this.creationDate, ticket.creationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, clientTicketId, title, description, assetId, siteId, priority, status, creationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ticket {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    clientTicketId: ").append(toIndentedString(clientTicketId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    assetId: ").append(toIndentedString(assetId)).append("\n");
    sb.append("    siteId: ").append(toIndentedString(siteId)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
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

