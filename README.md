AGILE CRM BACKEND WIDGETS
=================

Widgets are small application that can be built by end users and embedded in a contact’s page in AgileCRM. They are HTML/JavaScript segmentsthat are executed whenever a contact page is loaded. Every contact page has some html segment allocated for a custom widget.

*Custom Widget* , located at `https://<your_domain>.agilecrm.com/#add-widget/` provides the option to add a custom widget. By clicking the dropdown, you can see that there are two ways to upload a widget. This document deals with `Webhook URL` option. 
For the HTML option, please refer - https://github.com/agilecrm/widget-api-html

Whenever a widget is loaded (or a contact page is loaded with the widget enabled), contact details are sent to the webhook, via POST method. Contact details are sent in the form of a JSON object. The server then processes this data and returns the HTML body that is to be embedded in the html segment allocated to the widget in the contact page.

***Access:*** Contact details.

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
                    "name": "first_name",
                    "subtype": null,
                    "value": "George"
                },
                {
                    "type": "SYSTEM",
                    "name": "last_name",
                    "subtype": null,
                    "value": "Bernardshaw"
                },
                {
                    "type": "SYSTEM",
                    "name": "title",
                    "subtype": null,
                    "value": "Author"
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
                "email": "contact@agilecrm.com",
                "is_admin": false
            }
        }


####Notes:   
1. AgileCRM support HTML5 specifications. Please make sure to write widgets that are compatible with HTML5.  
 
2. jQuery library (version 1.7.2) is already loaded for use. Do not import any other version of jquery library with the widget as it could result in compatibility issue.   

3. Since modern browsers started to block [mixed content](https://blog.mozilla.org/tanvi/2013/04/10/mixed-content-blocking-enabled-in-firefox-23/), all resources must be accessed using secure (https) connection.

