AGILE CRM WIDGETS
=================

INTRODUCTION
------------

This API allows you to develop widgets for Agile CRM.   

Widgets are small application which can be built by end users and embedded in the contact’s page in Agile CRM. It is a HTML/JavaScript segment which is executed whenever a contact page is loaded. Every contact page has some html segment allocated for the widget.

These widgets have access to contact details and/or external resources in order to return some meaningful collection of data. These widgets add extra functionality to the AgileCRM contacts page.

*Custom* tab, located at `https://<your_domain>.agilecrm.com/#add-widget/` provides option to add widget. There are two methods to upload a widget.


In this method contact details are sent to the server, mentioned in the URL field, via POST method. Contact details are sent in form of json object. The server process this contact details and returns the HTML body which is further embedded to the html segment allocated to the widget at the contact page.   
***Access:*** Global widget property, widget property wrt to contact and contact details.

Contact data will be posted in the form of JSON as 

        {
            "id": 1435,`
            "type": "PERSON",
            "created_time": 1375424495,
            "updated_time": 1380003638,
            "viewed": {
                "viewed_time": 1380003638330,
                "viewer_id": 1
            },
            "star_value": 0,
            "lead_score": 0,
            "tags": [
                "lead"
            ],
            "tagsWithTime": [
                {
                    "tag": "lead",
                    "createdTime": 1378131285793,
                    "entity_type": "tag"
                }
            ],
            "properties": [
                {
                    "type": "SYSTEM",
                    "name": "last_name",
                    "subtype": null,
                    "value": "test"
                },
                {
                    "type": "SYSTEM",
                    "name": "title",
                    "subtype": null,
                    "value": "Software Developer at Agile CRM"
                },
                {
                    "type": "SYSTEM",
                    "name": "email",
                    "subtype": "",
                    "value": "test@agilecrm.com"
                },
                {
                    "type": "CUSTOM",
                    "name": "image",
                    "subtype": null,
                    "value": "https://www.agilecrm.com/img/agile-crm.png"
                }
            ],
            "widget_properties": null,
            "owner": {
                "id": 1450,
                "email": "tejaswi@agilecrm.com",
                "is_admin": false
            }
        }


####Notes:   
1. AgileCRM support HTML5 specifications. Please write widget which is compatible with HTML5.  
 
2. jQuery library (version 1.7.2) is already loaded. Feel free to use it. And don't import any other version jquery library in widget as it can result into compatibility issue.   

3. As modern browsers are blocking [mixed content](https://blog.mozilla.org/tanvi/2013/04/10/mixed-content-blocking-enabled-in-firefox-23/), all resources must be accessed using secure (https) connection.

