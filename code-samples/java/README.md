# ASSET ADVISOR API

- API version: 1.0.0

- Build date: 2023-08-02T14:43:51.240218900+05:30[Asia/Calcutta]

# Overview
EcoStruxure Openness makes developer experience easier to use our products. EcoStruxure Openness provide code sample Software Development Kits (SDKs) that will prevent developers to write their code from scratch.

SDK is a set of tools for third-party developers to use in producing applications using a particular framework or platform.

SDKs provide the necessary development plugins to import into the developer's code so that reduces the development efforts drastically and enables the user to integrate faster.
Asset Advisor API allows customers to collect and manage status and health of critical assets in electrical distribution networks.

## Versions
Latest Version - 1.0.0

Whats new in 1.0.0, API's that are supported
- Sites and Assets
- Tickets
- Asset Health
- Site Risk Level

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

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import se.ecostruxure.sdk.invoker.*;
import se.ecostruxure.sdk.invoker.auth.*;
import se.ecostruxure.sdk.model.*;
import se.ecostruxure.sdk.client.SitesApi;

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
```java
import se.ecostruxure.sdk.invoker.*;
import se.ecostruxure.sdk.invoker.auth.*;
import se.ecostruxure.sdk.model.*;
import se.ecostruxure.sdk.client.AssetHealthWebhookSubscriptionApi;

public class AssetHealthWebhookSubscriptionApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath(baseUrl);
        
        // Configure HTTP bearer authorization: PersonalAccessToken
        HttpBearerAuth PersonalAccessToken = (HttpBearerAuth) defaultClient.getAuthentication("PersonalAccessToken");
        PersonalAccessToken.setBearerToken("TOKEN");

        AssetHealthWebhookSubscriptionApi apiInstance = new AssetHealthWebhookSubscriptionApi(defaultClient);
        Object subscriptionId = null; // Object | Id of the asset health subscription
        try {
            apiInstance.deleteAssetHealthSubscription(subscriptionId);
        } catch (Exception e) {
            System.err.println("Exception when calling AssetHealthWebhookSubscriptionApi#deleteAssetHealthSubscription");
            e.printStackTrace();
        }
    }
}
```
## Compile it yourself, here's how:
build your own .jar, execute the following from within the cloned directory:
```
$ git clone https://github.com/ecostruxure-openapi/asset-advisor-api.git
$ cd asset-advisor-api/code-samples/java
$ mvn clean install   # Requires maven and run the below command    
```
## Run SDK Examples

This API is a trial version available free of charge for selected customers and limited period.

## API overview and usage
These API enables the following operations:

**Sites and Assets**
- Browse and discover sites and assets information.
- Provide sites and assets specific details (e.g. risk level, health indexes).

## Run using bash terminal with arguments that has to be passed
### Sites
Browse and discover sites information.
#### Get Site List
List all your Sites registered in Asset Advisor, including basic information such as ID, name, address, and location.
## Run using bash terminal with arguments that has to be passed
 - -b to pass baseUrl
 - -c to pass className 
 - -t to pass token (Note: without Bearer)
 
 **Syntax**
 ```bash
 ./run.sh -c $className -t $token -b $baseUrl
 ```
 **Example**
 ```bash
 ./run.sh -c GetSitesList -t gfghfxgh -b https://api.exchange.se.com/ecostruxure
 ```
 ## Run as maven command with arguments that has to be passed
 - $baseUrl to pass baseUrl value
 - $className to pass className
 - $token to pass token value(Note: without Bearer)

 **Syntax**
 ```
 mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl" -Dexec.cleanupDaemonThreads=false
 ```
 **Example**
 ```
 mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetSitesList" -Dexec.args="token=fxghzfxgzx baseUrl=https://api.exchange.se.com/ecostruxure" -Dexec.cleanupDaemonThreads=false
 ```
 #### Get Site Details
 Get all details of a particular Site, including information such as service & risk levels, support contacts, and health matrix.
 ## Run using bash terminal with arguments that has to be passed
 - -b to pass baseUrl
 - -c to pass className 
 - -t to pass token (Note: without Bearer)
 - -s to pass siteId
 
 **Syntax**
 ```bash
 ./run.sh -c $className -t $token -b $baseUrl -s $siteId
 ```
 **Example**
 ```bash
 ./run.sh -c GetSiteDetails -t gfghfxgh -b https://api.exchange.se.com/ecostruxure -s "e80101c0dd-9103-44d7-af93"
 ```
 ## Run as maven command with arguments that has to be passed
 - $baseUrl to pass baseUrl value
 - $className to pass className
 - $token to pass token value(Note: without Bearer)
 - $siteId to pass siteId

 **Syntax**
 ```
 mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl siteId=$siteId" -Dexec.cleanupDaemonThreads=false
 ```
**Example**
 ```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetSiteDetails" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure siteId=0aa61277-9c07-44e5-9317" -Dexec.cleanupDaemonThreads=false
  ```
### Assets
Browse and discover assets information.
#### Get Assets List
List all Assets for a particular Site, including basic information such as ID, name, description, type and criticality.
## Run using bash terminal with arguments that has to be passed
 - -b to pass baseUrl
 - -c to pass className 
 - -t to pass token (Note: without Bearer)
 - -s to pass siteId
 ## Run using bash terminal with arguments that has to be passed
 **Syntax**
 ```bash
 ./run.sh -c $className -t $token -b $baseUrl  -s $siteId
 ```
 **Example**
 ```bash
 ./run.sh -c GetAssetsList -t gfghfxgh -b https://api.exchange.se.com/ecostruxure -s "e80101c0dd-9103-44d7-af93"
 ```
 ## Run as maven command with arguments that has to be passed
 - $baseUrl to pass baseUrl value
 - $className to pass className
 - $token to pass token value(Note: without Bearer)
 - $siteId to pass siteId
 
 **Syntax**
 ```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl siteId=$siteId" -Dexec.cleanupDaemonThreads=false
 ```
**Example**
 ```
 mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetAssetsList" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure siteId=0aa61277-9c07-44e5-9317" -Dexec.cleanupDaemonThreads=false
  ```
#### Get Assets Tree View
Give the Assets tree view for a particular Site, including the complete relationships between all assets.
## Run using bash terminal with arguments that has to be passed
 - -b to pass baseUrl
 - -c to pass className 
 - -t to pass token (Note: without Bearer)
 - -s to pass siteId
 ## Run using bash terminal with arguments that has to be passed
**Syntax**
 ```bash
 ./run.sh -c $className -t $token -b $baseUrl -s $siteId
 ```
**Example**
 ```bash
 ./run.sh -c GetAssetsTreeView -t gfghfxgh -b https://api.exchange.se.com/ecostruxure -s "e80101c0dd-9103-44d7-af93"
 ```
 ## Run as maven command with arguments that has to be passed
 - $baseUrl to pass baseUrl value
 - $className to pass className
 - $token to pass token value(Note: without Bearer)
 - $siteId to pass siteId
 
 **Syntax**
 ```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl siteId=$siteId" -Dexec.cleanupDaemonThreads=false
 ```
**Example**
 ```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetAssetsTreeView" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure siteId=0aa61277-9c07-44e5-9317" -Dexec.cleanupDaemonThreads=false
```
#### Get Asset Details
  Get details of a particular Asset within a Site, including information such as service level, maintenance & health indexes.
## Run using bash terminal with arguments that has to be passed
 - -b to pass baseUrl
 - -c to pass className 
 - -t to pass token (Note: without Bearer)
 - -s to pass siteId
 - -a to pass assetId
 
 **Syntax**
 ```bash
 ./run.sh -c $className -t $token -b $baseUrl -s $siteId -a $assetId
 ```
 **Example**
 ```bash
 ./run.sh -c GetAssetDetails -t gfghfxgh -b https://api.exchange.se.com/ecostruxure -s "e80101c0dd-9103-44d7-af93" -a "a7e159b5-c82d-408d-8d1"
 ```
 ## Run as maven command with arguments that has to be passed
 - $baseUrl to pass baseUrl value
 - $className to pass className
 - $token to pass token value(Note: without Bearer)
 - $siteId to pass siteId
 - $assetId to pass assetId
 
**Syntax**
 ```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl siteId=$siteId assetId=$assetId" -Dexec.cleanupDaemonThreads=false
 ```
**Example**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetAssetDetails" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure siteId=0aa61277-9c07-44e5-9317 assetId=a7e159b5-c82d-408d-8d1" -Dexec.cleanupDaemonThreads=false
```
**Tickets**
- Access all tickets generated on all assets from all sites.
- Access all tickets for a given asset of a site.
- Provide tickets specific details.
#### Tickets list
List all Tickets for all Assets and Sites, with different query criteria (date, status, priority) and pagination capability. The current sort criteria used for the tickets is the creation date in descending order.
## Run using bash terminal with arguments that has to be passed
- -b to pass baseUrl
- -c to pass className
- -t to pass token (Note: without Bearer)
- -o to pass offset (optional)
- -p to pass priority (optional)
- -l to pass limit (optional)
- -w to pass status(optional)
- -u to pass createdFrom (optional)
- -v to pass createdTo (optional)

**Syntax**
```
./run.sh -c $className -t $token -b $baseUrl -o $offset -p $priority -l $limit -w $status -u $createdFrom -v $createdTo
```		
**Example**
```bash
./run.sh -c GetTicketsList -t cvhdgfgdhf -b https://api.exchange.se.com/ecostruxure  -o 2 -p "Medium" -p "Low" -l 2 -w "InProgress" -u "2023-07-10T16:10:04Z" -v "2023-07-30T16:10:04Z"
```
## Run as maven command with arguments that has to be passed
- $baseUrl to pass baseUrl value
- $className to pass className
- $token to pass token value(Note: without Bearer)
- $offset to pass offset (optional)
- $priority to pass priority (optional)
- $limit to pass limit (optional)
- $status to pass status(optional)
- $createdFrom to pass createdFrom (optional)
- $createdTo to pass createdTo (optional)

**Syntax**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl  offset=$offset priority=$priority limit=$limit status=$status createdFrom=$createdFrom createdTo=$createdTo" -Dexec.cleanupDaemonThreads=false
```
**Example**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetTicketsList" -Dexec.args="token=cvhdgfgdhf baseUrl=https://api.exchange.se.com/ecostruxure offset=2 priority=Medium priority=Low limit=3 status=InProgress createdFrom=2023-07-10T16:10:04Z createdTo=2023-07-30T16:10:04Z" -Dexec.cleanupDaemonThreads=false
```
#### Assets Tickets
List all Tickets of a particular Asset within a Site, with the abilitiy to filter by status and pagination capability. The current sort criteria used for the tickets is the creation date in descending order.
## Run using bash terminal with arguments that has to be passed
- -b to pass baseUrl
- -c to pass className
- -t to pass token (Note: without Bearer)
- -s to pass siteId
- -a to pass assetId
- -o to pass offset (optional)
- -l to pass limit (optional)
- -w to pass status (optional)

**Syntax**
```
./run.sh -c $className -t $token -b $baseUrl -a $assetId -s $siteId -o $offset -l $limit -w $status
```		
**Example**
```bash
./run.sh -c GetAssetsTickets -t gfghfxgh -b https://api.exchange.se.com/ecostruxure -a jhxcghxgc-hgfg -s nvbv-564v-hgf5 -o 3 -l 5 -w InProgress
```
## Run as maven command with arguments that has to be passed
- $baseUrl to pass baseUrl value
- $className to pass className
- $token to pass token value(Note: without Bearer)
- $siteId to pass siteId
- $assetId to pass assetId
- $offset to pass offset (optional)
- $limit to pass limit (optional)
- $status to pass status (optional)

**Syntax**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl assetId=$assetId siteId=$siteId offset=$offset limit=$limit status=$status" -Dexec.cleanupDaemonThreads=false
```
**Example**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetAssetsTickets" -Dexec.args="token=fxghzfxgzx baseUrl=https://api.exchange.se.com/ecostruxure assetId=jhxcghxgc-hgfg siteId=nvbv-564v-hgf5 offset=3 limit=5 status=InProgress" -Dexec.cleanupDaemonThreads=false
```
#### Ticket details
Get details of a particular Ticket, including the history of what happened on the ticket.
## Run using bash terminal with arguments that has to be passed
- -b to pass baseUrl
- -c to pass className
- -t to pass token (Note: without Bearer)
- -d to pass ticketId

**Syntax**
```
./run.sh -c $className -t $token -b $baseUrl -d $ticketId
```		
**Example**
```bash
./run.sh -c GetTicketDetails -t gfghfxgh -b https://api.exchange.se.com/ecostruxure -d sfghsfg
```
## Run as maven command with arguments that has to be passed
- $baseUrl to pass baseUrl value
- $className to pass className
- $token to pass token value(Note: without Bearer)
- $ticketId to pass ticketId

**Syntax**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl ticketId=$ticketId" -Dexec.cleanupDaemonThreads=false
```
**Example**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetTicketDetails" -Dexec.args="token=fxghzfxgzx baseUrl=https://api.exchange.se.com/ecostruxure ticketId=$ticketId" -Dexec.cleanupDaemonThreads=false
```
### Webhook Subscription
This set of APIs allows the customer to register, update, remove and get webhook subscription to be notified on update on some topics.
Currently the topics concerning are:

**Ticket**
- Notified on any ticket modification. 
- Currenlty, notification are sent when the ticket *\"priority\" or \"activity\"* changed.
- Set *\"All\"* for both priority and activity filter during subscription to get notified for all ticket events.
#### Create Ticket Subscription
New Tickets registeration in Asset Advisor, including information such as priority, activity, createdAt, and callback.
## Run using bash terminal with arguments that has to be passed
- -b to pass baseUrl
- -c to pass className
- -t to pass token (Note: without Bearer)
- -w to pass filePath

**Syntax**
```
./run.sh -c $className -t $token -b $baseUrl -f $filePath
```		
**Example**
```bash
./run.sh -c CreateTicketSubscription -t gfghfxgh -b https://api.exchange.se.com/ecostruxure -w path/file/filename.json
```
## Run as maven command with arguments that has to be passed
- $baseUrl to pass baseUrl value
- $className to pass className
- $token to pass token value(Note: without Bearer)
- $filePath to pass filePath

**Syntax**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl filePath=$filePath" -Dexec.cleanupDaemonThreads=false
```
**Example**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.CreateTicketSubscription" -Dexec.args="token=fxghzfxgzx baseUrl=https://api.exchange.se.com/ecostruxure filePath= path/file/filename.json" -Dexec.cleanupDaemonThreads=false
```
#### Get Ticket Subscriptions
List all your Tickets registered in Asset Advisor, including information such as priority, activity, createdAt, and callback.
## Run using bash terminal with arguments that has to be passed
- -b to pass baseUrl
- -c to pass className
- -t to pass token (Note: without Bearer)
## Run using bash terminal with arguments that has to be passed

**Syntax**
```
./run.sh -c $className -t $token -b $baseUrl
```
**Example**
```
./run.sh -c GetTicketSubscriptionList -t gfghfxgh -b https://api.exchange.se.com/ecostruxure
```
## Run as maven command with arguments that has to be passed
- $baseUrl to pass baseUrl value
- $className to pass className
- $token to pass token value(Note: without Bearer)

**Syntax**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl -Dexec.cleanupDaemonThreads=false
```
**Example**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetTicketSubscriptionList" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure -Dexec.cleanupDaemonThreads=false
```
#### Get Ticket Subscription
Get a registered Ticket  in Asset Advisor, including information such as priority, activity, createdAt, and callback.
## Run using bash terminal with arguments that has to be passed
- -b to pass baseUrl
- -c to pass className
- -t to pass token (Note: without Bearer)
- -q to pass subscriptionId
## Run using bash terminal with arguments that has to be passed
**Syntax**
```
./run.sh -c $className -t $token -b $baseUrl  -q $subscriptionId
```
**Example**
```
./run.sh -c GetTicketSubscription -t gfghfxgh -b https://api.exchange.se.com/ecostruxure -q "30err"
```
## Run as maven command with arguments that has to be passed
$baseUrl to pass baseUrl value
$className to pass className
$token to pass token value(Note: without Bearer)
$subscriptionId to pass subscriptionId

**Syntax**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl subscriptionId=$subscriptionId" -Dexec.cleanupDaemonThreads=false
```
**Example**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetTicketSubscription" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure subscriptionId=444hjsdafhsd" -Dexec.cleanupDaemonThreads=false
```
#### Update Ticket Subscription
Update a registered Ticket  in Asset Advisor, including information such as priority, activity, createdAt, and callback.
- -b to pass baseUrl
- -c to pass className
- -t to pass token (Note: without Bearer)
- -q to pass subscriptionId
- -w to pass filePath
## Run using bash terminal with arguments that has to be passed
**Syntax**
```
./run.sh -c $className -t $token -b $baseUrl  -q $subscriptionId  -w $filePath
```
**Example**
```
./run.sh -c UpdateTicketSubscription -t gfghfxgh -b https://api.exchange.se.com/ecostruxure -q "30err" -w path/file/filename.json
```
## Run as maven command with arguments that has to be passed
- $baseUrl to pass baseUrl value
- $className to pass className
- $token to pass token value(Note: without Bearer)
- $subscriptionId to pass subscriptionId
- $filePath to pass filePath

**Syntax**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl subscriptionId=$subscriptionId filePath=$filePath" -Dexec.cleanupDaemonThreads=false
```
**Example**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.UpdateTicketSubscription" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure subscriptionId=444hjsdafhsd filePath=path/file/filename.json" -Dexec.cleanupDaemonThreads=false
```
#### Delete Ticket Subscription
Delete a registered Ticket  in Asset Advisor, including information such as priority, activity, createdAt, and callback.
#### Run using bash terminal with arguments that has to be passed
- -b to pass baseUrl
- -c to pass className
- -t to pass token (Note: without Bearer)
- -q to pass subscriptionId

**Syntax**
```
./run.sh -c $className -t $token -b $baseUrl  -q $subscriptionId
```
**Example**
```
./run.sh -c DeleteTicketSubscription -t gfghfxgh -b https://api.exchange.se.com/ecostruxure -q "30err"
```
## Run as maven command with arguments that has to be passed
- $baseUrl to pass baseUrl value
- $className to pass className
- $token to pass token value(Note: without Bearer)
- $subscriptionId to pass subscriptionId

**Syntax**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl subscriptionId=$subscriptionId" -Dexec.cleanupDaemonThreads=false
```
**Example**
```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.DeleteTicketSubscription" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure subscriptionId=444hjsdafhsd" -Dexec.cleanupDaemonThreads=false
```
**Asset Health**
Asset Health Webhook Subscription used to be notified on callback URL about an asset health value above or equal to a threshold
- Notified when the asset health changed.
- *\"healthIndexThreshold\"* is a mandatory filter to create a subscription and get notified only when the asset health value changed with a value equals or above this threshold.
- *\"sitesScope\"* is an optional filter to restrict the notification to a site id list.

#### List asset health subscriptions
Retrieve all asset health subscriptions currently set
## Run using bash terminal with arguments that has to be passed
 - -b to pass baseUrl
 - -c to pass className 
 - -t to pass token (Note: without Bearer)
 
 **Syntax**
 ```bash
 ./run.sh -c $className -t $token -b $baseUrl
 ```
 **Example**
 ```bash
 ./run.sh -c GetAssetHealthSubscriptionList -t gfghfxgh -b https://api.exchange.se.com/ecostruxure
 ```
 ## Run as maven command with arguments that has to be passed
 - $baseUrl to pass baseUrl value
 - $className to pass className
 - $token to pass token value(Note: without Bearer)

 **Syntax**
 ```
 mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl" -Dexec.cleanupDaemonThreads=false
 ```
 **Example**
 ```
 mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetAssetHealthSubscriptionList" -Dexec.args="token=fxghzfxgzx baseUrl=https://api.exchange.se.com/ecostruxure" -Dexec.cleanupDaemonThreads=false
 ```

**Site Risk Level**
- Notified when the site global risk level changed.
- *\"riskLevelThreshold\"* is a mandatory filter to create a subscription and get notified only when the site risk level value changed with a value equals or above this threshold.
- *\"sitesScope\"* is an optional filter to restrict the notification to a site id list.
