# assetadvisor-se-api

EcoStruxure™ Asset Advisor API

- API version: 1.2.0

- Build date: 2023-07-31T16:13:28.526077700+05:30[Asia/Calcutta]

# Overview
Asset Advisor API allows customers to collect and manage status and health of critical assets in electrical distribution networks.

## Trial version

This API is a trial version available free of charge for selected customers and limited period.

For more information please contact the [Schneider Electric Exchange support team](mailto:exchange.support@se.com).

## API overview and usage
These API enables the following operations:

**Sites and Assets**
- Browse and discover sites and assets information.
- Provide sites and assets specific details (e.g. risk level, health indexes).

**Tickets**
- Access all tickets generated on all assets from all sites.
- Access all tickets for a given asset of a site.
- Provide tickets specific details.

## How it works
This API works for any Schneider Electric customer who has an identity in the Schneider Electric cIAM system. Nevertheless, customers must subscribe to this API to use it. The current version of the API is including the operations that are described below.

### Explore Sites
This set of APIs allows the customer to browse all their Sites registered in Asset Advisor.

It is possible to access basic information of each site, such as ID, name, address, and location, which allows customers to do a mapping of Asset Advisor sites with their own representation and IDs, and also to locate all Sites in a map.

With the detailed view of a Site, customers are able to access information such as the Service Level subscribed for the Site, the Global Risk Level of the Site and the Health Matrix of the Site (including criticality and health index).

### Explore Assets
This set of APIs allows the customer to browse all Assets for a specific Site registered in Asset Advisor.

It is possible to have two different views of the Assets within a given Site. The first one is the List View, providing a standard list of assets for a given Site, including asset information such as ID, name, description, type, and criticality. The second view is a Tree View, providing the entire hierarchy of assets for a given Site, allowing customers to build a complete Site topology.

Finally, it is possible to get specific details of each Asset, including the health index, maintenance information, and many other technical details. 

### Access Tickets
This set of APIs allows the customer to retrieve all tickets in Asset Advisor, including both alarms and recommendations. These tickets are either triggered by the Asset Advisor Analytics modules or manually created by Schneider Electric experts. This information allows customers to create their own customized dashboards with all tickets of their electrical distribution networks.

It is possible to query tickets using some filters such as:

- By date range (ticket creation date)

- By status (e.g. only \"Opened\" tickets)

- By priority (e.g. Only \"High\" priority tickets)

Besides the above filters, it's also possible to limit the number of tickets in the response or retrieving specific range of tickets by setting the offset & limit filters for pagination capability. These queries return a list of \"light\" tickets, providing basic information such as title, description, asset, site, priority, status and creation date. 

It is also possible to retrieve all tickets for a particular Asset of a Site, with similar filtering and pagination capabilities. This allows customers to create a consolidated view of tickets for a particular Asset of a Site.

Finally, it is possible to get specific details of each Ticket, including information such as priority, status, creation date, history of changes, comments and attachments. This allows customers to create a detailed view of each ticket.

### Webhook Subscription
This set of APIs allows the customer to register, update, remove and get webhook subscription to be notified on update on some topics.
Currently the topics concerning are:

**Ticket**
- Notified on any ticket modification. 
- Currenlty, notification are sent when the ticket *\"priority\" or \"activity\"* changed.
- Set *\"All\"* for both priority and activity filter during subscription to get notified for all ticket events.

**Asset Health**
- Notified when the asset health changed.
- *\"healthIndexThreshold\"* is a mandatory filter to create a subscription and get notified only when the asset health value changed with a value equals or above this threshold.
- *\"sitesScope\"* is an optional filter to restrict the notification to a site id list.

**Site Risk Level**
- Notified when the site global risk level changed.
- *\"riskLevelThreshold\"* is a mandatory filter to create a subscription and get notified only when the site risk level value changed with a value equals or above this threshold.
- *\"sitesScope\"* is an optional filter to restrict the notification to a site id list.

In each subscription you can add filters to get notifed on only some conditions.
You must provide a callback URL where you will receive the notifications. When any event matching your subscription is available, callback URL you provided us will be notified.

For all topics, the message format sent to the callback URL is the following:
```json
{
    \"topic\": \"{topicName}\", // enum {Ticket, AssetHealth, SiteRiskLevel}
    \"id\": \"{topic id string}\", // \"guid\" of the Ticket, of the asset or the site
    \"siteId\": \"string\", // \"guid\" of the Site
    \"assetId\": \"string\", // \"guid\" of the Asset
    \"timestamp\" : \"string\", // ISO 8601 format, \"2023-02-08T17:09:44+00:00\"        
    \"events\": [
  {
   \"key\": \"{event property name}\", 
   \"oldValue\": \"{Previous value if possible}\",
   \"newValue\": \"{New Value}\"
  }
      ]    
}
```

# Documentation

## How to sign up
The current version of the API does not allow subscriptions on demand.

Selected customers will be signed up manually, based on specific agreements with Schneider Electric, and will be able to access the API with the following information:

**Step 1:** Receive the Exchange URL access for the API product.

**Step 2:** [Register or login](https://exchange.se.com) with an Exchange account.

**Step 3:** Generate a Personal Access Token (PAT) in the developer portal (API credentials and usage details are also available).

## Code Sample

You can leverage the following code samples to integrate the API faster in your application:

<div id=\"gitsample\"></div>

## Support

Contact the SE Exchange support team at exchange.support@se.com and include,

    - Endpoint URL
    - Request/Response of the URL
    - Any additional information like Screenshots, Postman collections

---



  For more information, please visit [exchange.se.com](exchange.se.com)

*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*

## Requirements

Building the API client library requires:

1. Java 1.8+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>se.ecostruxure.sdk.example</groupId>
  <artifactId>assetadvisor-se-api</artifactId>
  <version>0.0.1</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'assetadvisor-se-api' jar has been published to maven central.
    mavenLocal()       // Needed if the 'assetadvisor-se-api' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "se.ecostruxure.sdk.example:assetadvisor-se-api:0.0.1"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

- `target/assetadvisor-se-api-0.0.1.jar`
- `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import se.ecostruxure.sdk.invoker.*;
import se.ecostruxure.sdk.invoker.auth.*;
import se.ecostruxure.sdk.model.*;
import se.ecostruxure.sdk.client.AssetHealthWebhookSubscriptionApi;

public class AssetHealthWebhookSubscriptionApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://se-exchange-uat-uat.apigee.net/ecostruxure/asset-advisor/v1");
        
        // Configure HTTP bearer authorization: PersonalAccessToken
        HttpBearerAuth PersonalAccessToken = (HttpBearerAuth) defaultClient.getAuthentication("PersonalAccessToken");
        PersonalAccessToken.setBearerToken("BEARER TOKEN");

        AssetHealthWebhookSubscriptionApi apiInstance = new AssetHealthWebhookSubscriptionApi(defaultClient);
        UUID subscriptionId = UUID.randomUUID(); // UUID | Id of the asset health subscription
        try {
            apiInstance.deleteAssetHealthSubscription(subscriptionId);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetHealthWebhookSubscriptionApi#deleteAssetHealthSubscription");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://se-exchange-uat-uat.apigee.net/ecostruxure/asset-advisor/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AssetHealthWebhookSubscriptionApi* | [**deleteAssetHealthSubscription**](docs/AssetHealthWebhookSubscriptionApi.md#deleteAssetHealthSubscription) | **DELETE** /webhooks/subscriptions/assethealth/{subscriptionId} | Delete asset health subscription
*AssetHealthWebhookSubscriptionApi* | [**getAssetHealthSubscription**](docs/AssetHealthWebhookSubscriptionApi.md#getAssetHealthSubscription) | **GET** /webhooks/subscriptions/assethealth/{subscriptionId} | Get asset health subscription
*AssetHealthWebhookSubscriptionApi* | [**getAssetHealthSubscriptionList**](docs/AssetHealthWebhookSubscriptionApi.md#getAssetHealthSubscriptionList) | **GET** /webhooks/subscriptions/assethealth | Get asset health Subscriptions
*AssetHealthWebhookSubscriptionApi* | [**postAssetHealthSubscription**](docs/AssetHealthWebhookSubscriptionApi.md#postAssetHealthSubscription) | **POST** /webhooks/subscriptions/assethealth | Create asset health subscription
*AssetHealthWebhookSubscriptionApi* | [**putAssetHealthSubscription**](docs/AssetHealthWebhookSubscriptionApi.md#putAssetHealthSubscription) | **PUT** /webhooks/subscriptions/assethealth/{subscriptionId} | Update asset health subscription
*AssetsApi* | [**getAssetDetails**](docs/AssetsApi.md#getAssetDetails) | **GET** /sites/{siteId}/assets/{assetId} | Asset details
*AssetsApi* | [**getAssets**](docs/AssetsApi.md#getAssets) | **GET** /sites/{siteId}/assets | Assets list
*AssetsApi* | [**getAssetsTree**](docs/AssetsApi.md#getAssetsTree) | **GET** /sites/{siteId}/assets/treeview | Assets Tree View
*SiteRiskLevelWebhookSubscriptionApi* | [**deleteSiteRiskLevelSubscription**](docs/SiteRiskLevelWebhookSubscriptionApi.md#deleteSiteRiskLevelSubscription) | **DELETE** /webhooks/subscriptions/siterisklevel/{subscriptionId} | Delete site risk level subscription
*SiteRiskLevelWebhookSubscriptionApi* | [**getSiteRiskLevelSubscription**](docs/SiteRiskLevelWebhookSubscriptionApi.md#getSiteRiskLevelSubscription) | **GET** /webhooks/subscriptions/siterisklevel/{subscriptionId} | Get site risk level subscription
*SiteRiskLevelWebhookSubscriptionApi* | [**getSiteRiskLevelSubscriptionList**](docs/SiteRiskLevelWebhookSubscriptionApi.md#getSiteRiskLevelSubscriptionList) | **GET** /webhooks/subscriptions/siterisklevel | Get site risk level subscriptions
*SiteRiskLevelWebhookSubscriptionApi* | [**postSiteRiskLevelSubscription**](docs/SiteRiskLevelWebhookSubscriptionApi.md#postSiteRiskLevelSubscription) | **POST** /webhooks/subscriptions/siterisklevel | Create site risk level subscription
*SiteRiskLevelWebhookSubscriptionApi* | [**putSiteRiskLevelSubscription**](docs/SiteRiskLevelWebhookSubscriptionApi.md#putSiteRiskLevelSubscription) | **PUT** /webhooks/subscriptions/siterisklevel/{subscriptionId} | Update site risk level subscription
*SitesApi* | [**getSiteDetails**](docs/SitesApi.md#getSiteDetails) | **GET** /sites/{siteId} | Site details
*SitesApi* | [**getSites**](docs/SitesApi.md#getSites) | **GET** /sites | Sites list
*TicketWebhookSubscriptionApi* | [**deleteTicketSubscription**](docs/TicketWebhookSubscriptionApi.md#deleteTicketSubscription) | **DELETE** /webhooks/subscriptions/ticket/{subscriptionId} | Delete ticket subscription
*TicketWebhookSubscriptionApi* | [**getTicketSubscription**](docs/TicketWebhookSubscriptionApi.md#getTicketSubscription) | **GET** /webhooks/subscriptions/ticket/{subscriptionId} | Get ticket subscription
*TicketWebhookSubscriptionApi* | [**getTicketSubscriptionList**](docs/TicketWebhookSubscriptionApi.md#getTicketSubscriptionList) | **GET** /webhooks/subscriptions/ticket | Get ticket subscriptions
*TicketWebhookSubscriptionApi* | [**postTicketSubscription**](docs/TicketWebhookSubscriptionApi.md#postTicketSubscription) | **POST** /webhooks/subscriptions/ticket | Create ticket subscription
*TicketWebhookSubscriptionApi* | [**putTicketSubscription**](docs/TicketWebhookSubscriptionApi.md#putTicketSubscription) | **PUT** /webhooks/subscriptions/ticket/{subscriptionId} | Update ticket subscription
*TicketsApi* | [**getAssetsTickets**](docs/TicketsApi.md#getAssetsTickets) | **GET** /sites/{siteId}/assets/{assetId}/tickets | Assets Tickets
*TicketsApi* | [**getTicketDetails**](docs/TicketsApi.md#getTicketDetails) | **GET** /tickets/{ticketId} | Ticket details
*TicketsApi* | [**getTickets**](docs/TicketsApi.md#getTickets) | **GET** /tickets | Tickets list


## Documentation for Models

 - [Asset](docs/Asset.md)
 - [AssetFull](docs/AssetFull.md)
 - [AssetFullAllOf](docs/AssetFullAllOf.md)
 - [AssetHealthSubscriptionConfig](docs/AssetHealthSubscriptionConfig.md)
 - [AssetHealthWebhook](docs/AssetHealthWebhook.md)
 - [AssetTypesEnum](docs/AssetTypesEnum.md)
 - [AssetsTreeElt](docs/AssetsTreeElt.md)
 - [AssetsTreeEltAllOf](docs/AssetsTreeEltAllOf.md)
 - [Error400](docs/Error400.md)
 - [Error400InvalidParamsInner](docs/Error400InvalidParamsInner.md)
 - [Error401](docs/Error401.md)
 - [Error403](docs/Error403.md)
 - [Error404](docs/Error404.md)
 - [Error500](docs/Error500.md)
 - [EventsInner](docs/EventsInner.md)
 - [EventsInner1](docs/EventsInner1.md)
 - [EventsInner2](docs/EventsInner2.md)
 - [EventsInnerOldValue](docs/EventsInnerOldValue.md)
 - [HealthIndexElt](docs/HealthIndexElt.md)
 - [ListOfAssetHealthSupscriptionInner](docs/ListOfAssetHealthSupscriptionInner.md)
 - [ListOfTicketSupscriptionInner](docs/ListOfTicketSupscriptionInner.md)
 - [ListOfTicketSupscriptionInner1](docs/ListOfTicketSupscriptionInner1.md)
 - [PriorityValue](docs/PriorityValue.md)
 - [ServiceLevelsEnum](docs/ServiceLevelsEnum.md)
 - [Site](docs/Site.md)
 - [SiteFull](docs/SiteFull.md)
 - [SiteFullAllOf](docs/SiteFullAllOf.md)
 - [SiteFullAllOfCommunicationStatus](docs/SiteFullAllOfCommunicationStatus.md)
 - [SiteFullAllOfSupportContacts](docs/SiteFullAllOfSupportContacts.md)
 - [SiteRiskLevelSubscriptionConfig](docs/SiteRiskLevelSubscriptionConfig.md)
 - [SiteRiskWebhook](docs/SiteRiskWebhook.md)
 - [StatusValue](docs/StatusValue.md)
 - [SubscriptionConfig](docs/SubscriptionConfig.md)
 - [Supscription](docs/Supscription.md)
 - [Ticket](docs/Ticket.md)
 - [TicketActivityEnum](docs/TicketActivityEnum.md)
 - [TicketFull](docs/TicketFull.md)
 - [TicketFullAllOf](docs/TicketFullAllOf.md)
 - [TicketHistory](docs/TicketHistory.md)
 - [TicketPriorityEnum](docs/TicketPriorityEnum.md)
 - [TicketStatusEnum](docs/TicketStatusEnum.md)
 - [TicketSubscriptionConfig](docs/TicketSubscriptionConfig.md)
 - [TicketWebhook](docs/TicketWebhook.md)
 - [Tickets](docs/Tickets.md)
 - [UsageEnvironmentalLevelEnum](docs/UsageEnvironmentalLevelEnum.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### PersonalAccessToken


- **Type**: HTTP basic authentication


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

exchange.support@se.com

