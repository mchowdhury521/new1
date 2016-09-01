
Feature: visiting menu tab
inorder to visit menutab 
i have to click the link and
 verify the text

Scenario Outline: Clicking on menu tab

Given i am loged in "<Browsertype>"
 And  i click in "<menutab>"
Then "<verificationobject>" should be present

Examples:

| Browsertype | menutab       | verificationobject |

| Chrome      |findresume     | Fastsameresume     |

| Chrome      |employerpostjob| indeedforemployer  |
