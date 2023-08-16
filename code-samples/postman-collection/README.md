# Postman Collection

# About

This collection allows developers to test APIs through [Postman](https://www.postman.com/) application.

# Prerequisites

* Postman desktop or web application
* Valid subscription to Asset Advisor API product

## Usage
 
* [Import collection](#import-collection)
* [Configure variables](#configure-variables)
* [Execute](#execute)

## Import Collection

Import ```asset-advisor-api.postman-collection.json``` to postman. Refer to [postman documentation to import a collection](https://learning.postman.com/docs/getting-started/importing-and-exporting-data/#importing-data-into-postman).

## Configure Variables

Edit the collection to configure the variables

* Configure Access Token

Configure the Personal Access Token created in Developer Portal after subscription

![Authorization](../media/configure-token.png)

* Configure Host 

![Host](../media/configure-host.png)

| Sandbox  | Production |
|---|---|
| se-exchange-uat-uat.apigee.net  |  api.exchange.se.com |

## Execute

### List Sites

List all the sites which the user is authorized to enquire

![List Sites](../media/list-sites.png)

### Site Details

Get the site details based on Site ID

![Site Details](../media/site-details.PNG)

### List Assets

List all assets for the given Site ID

![List Assets](../media/list-assets.PNG)

### Asset Treeview

List the asset heirarchy for the given Site ID

![Asset Tree](../media/asset-tree.PNG)

### Asset Details

Get the asset details based on Site ID

![Asset Details](../media/asset-detail.PNG)

### Asset Tickets

List all tickets for the given Site ID and Asset ID

![Asset Tickets](../media/asset-tickets.PNG)

### List Tickets

List all tickets related to all the sites

![List Tickets](../media/list-tickets.png)

### Ticket Details

Get the asset details based on Ticket ID

![Ticket Details](../media/ticket-detail.PNG)

### Create Ticket Subscription

Register a new ticket subscription

![Ticket Subscription](../media/create-ticket-subscription.PNG)

### Get Ticket Subscription

Retrieve all ticket subscriptions currently set

![List Ticket Subscription](../media/list-ticket-subscription.PNG)

### Get Ticket Subscription Details

Retrieve a ticket subscription

![Ticket Subscription Details](../media/ticket-subscription-details.PNG)

### Update Ticket Subscription details

Update a ticket subscription

![Update Ticket Subscription Details](../media/update-ticket-subscription-details.PNG)

### Delete Ticket Subscription details

Delete a ticket subscription

![Delete Ticket Subscription Details](../media/delete-ticket-subscription-details.PNG)

### Create AssetHealth Subscription

Register a new asset health subscription

![Create Asset Health](../media/create-asset-health-subscription.PNG)

### Get AssetHealth Subscription

Retrieve all asset health subscriptions currently set

![List Asset Health](../media/list-asset-health-subscription.PNG)

### Get AssetHealth Subscription Details

Retrieve an asset health subscription

![Get Asset Health Details](../media/asset-health-subscription-detail.PNG)

### Update AssetHealth Subscription Details

Update an asset health subscription

![Update Asset Health Details](../media/update-asset-health-subscription-detail.PNG)

### Delete AssetHealth Subscription Details

Delete an asset health subscription

![Delete Asset Health Details](../media/delete-asset-health-subscription-detail.PNG)

### Create Site Risk Level Subscription

Register a new site risk level subscription

![Create Site Risk Level ](../media/create-site-risk-level-subscription.PNG)

### Get Site Risk Level Subscription

Retrieve all site risk level subscriptions currently set

![List Site Risk Level ](../media/list-site-risk-level-subscription.PNG)

### Get Site Risk Level Subscription Details

Retrieve a site risk level subscription

![Site Risk Level Details ](../media/site-risk-level-subscription-details.PNG)

### Update Site Risk Level Subscription Details

Update a site risk level subscription

![Update Site Risk Level Details ](../media/update-site-risk-level-subscription.PNG)

### Delete Site Risk Level Subscription Details

Delete a site risk level subscription

![Delete Site Risk Level Details ](../media/delete-site-risk-level-subscription.PNG)
