# assetadvisor-se-api

Asset Advisor API

- API version: 1.2.0

- Build date: 2023-08-02T14:43:51.240218900+05:30[Asia/Calcutta]

# Overview
EcoStruxure Openness makes developer experience easier to use our products. EcoStruxure Openness provide code sample Software Development Kits (SDKs) that will prevent developers to write their code from scratch.

SDK is a set of tools for third-party developers to use in producing applications using a particular framework or platform.

SDKs provide the necessary development plugins to import into the developer's code so that reduces the development efforts drastically and enables the user to integrate faster.
Asset Advisor API allows customers to collect and manage status and health of critical assets in electrical distribution networks.

## Versions
Latest Version - 1.2.0

Whats new in 1.0.0, API's that are supported
- Sites and Assets
- Tickets
- Asset Health
- Site Risk Level



This API is a trial version available free of charge for selected customers and limited period.


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


# Documentation

## How to sign up
The current version of the API does not allow subscriptions on demand.

Selected customers will be signed up manually, based on specific agreements with Schneider Electric, and will be able to access the API with the following information:

**Step 1:** Receive the Exchange URL access for the API product.

**Step 2:** [Register or login](https://exchange.se.com) with an Exchange account.

**Step 3:** Generate a Personal Access Token (PAT) in the developer portal (API credentials and usage details are also available).

## Code Sample

You can leverage the following code samples to integrate the API faster in your application:


## Support

Contact the SE Exchange support team at exchange.support@se.com and include,

    - Endpoint URL
    - Request/Response of the URL
    - Any additional information like Screenshots, Postman collections

---


## Requirements

Building the API client library requires:

1. Java 1.8+
2. Maven(>3.0)/Gradle
3. Shell support(to execute run.sh)
## Compile it yourself, here's how:
build your own .jar, execute the following from within the cloned directory:

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
  <groupId>se.ecostruxure.sdk</groupId>
  <artifactId>assetadvisor-se-api</artifactId>
  <version>1.0.0</version>
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
     implementation "se.ecostruxure.sdk:assetadvisor-se-api:1.0.0"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

- `target/assetadvisor-se-api-1.0.0.jar`
- `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import se.ecostruxure.sdk.invoker.*;
import se.ecostruxure.sdk.invoker.auth.*;
import se.ecostruxure.sdk.model.*;
import se.ecostruxure.sdk.client.AssetHealthWebhookSubscriptionApi;

public class GetSiteDetails {
    public static void main(String[] args) {
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath(baseUrl);
        defaultClient.setBearerToken(token);
        SitesApi apiInstance = new SitesApi(defaultClient);
        try {            
            System.out.println(apiInstance.getSites());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
