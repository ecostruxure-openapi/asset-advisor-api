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

Import ```Asset-Advisor-API.postman-collection.json``` to postman. Refer to [postman documentation to import a collection](https://learning.postman.com/docs/getting-started/importing-and-exporting-data/#importing-data-into-postman).

## Configure Variables

Edit the collection to configure the variables

* Configure Access Token

Configure the Personal Access Token created in Developer Portal after subscription

![Authorization](/media/configure-token.png)

* Configure Host 

![Host](/media/configure-host.png)

| Sandbox  | Production |
|---|---|
| se-exchange-uat-uat.apigee.net  |  api.exchange.se.com |

## Execute

### List Sites

List all the sites which the user is authorized to enquire

![List Sites](/media/list-sites.png)

### List Tickets

List all tickets related to all the sites

![List Tickets](/media/list-tickets.png)