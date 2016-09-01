Feature: visiting to Salesforce
in order to work
as a sales person
i want to login

@login
Scenario Outline:  loging to salesforce
Given  Runmode is "<Runmode>"
Given i go to "loginurl" on "<Browser>"
And i click in "signinlink" button
And i enter "loginusername" as "<User_Name>"
And i enter "loginpassword" as "<Password>" 
And i click on "loginsubmit"
Then login should be "<Expected_Result>"

Examples:

| Runmode | Browser | User_Name              | Password | Expected_Result |

| N       | Chrome  |  xxx                   | xxxx     | failure         |

| Y       |Chrome   |mchowdhury521@gmail.com |33401515  | Success         |
