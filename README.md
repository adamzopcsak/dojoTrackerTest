## About the project

This repository is about testing the website called DojoTracker (https://track-that-dojo.herokuapp.com) 
in Page Object Model (POM), using AjaxElementLocatorFactory.
This site was developed by CodeCoolers as well. You can check out the repositories of the app here:

Frontend: https://github.com/adamzopcsak/dojoTrackerFE
Backend: https://github.com/adamzopcsak/dojoTrackerBE

## Project size
Solo.

## Dojo Tracker

### Goals of the site

Provide CodeCoolers with an App where they can:

- track their completed "dojos" (algorithmic exercises)
- save solutions for completed dojos
- see how they rank compared to other CodeCoolers
- see various statistics about their progress
- ask mentors & peers for their feedback on solutions

## Tests
### Running the tests

In order to run the tests, you'll need a validated DojoTracker account, and set the credential as environment variables
(DOJOTRACKER_EMAIL, DOJOTRACKER_PASSWORD).

### Different modes

You can run the tests in headless and non-headless mode as well. Change the constant value of HEADLESS_MODE in the
BaseTest class to switch between the modes.

### Browsers

Currently, these tests are written for Google Chrome. Upgrading the tests for Firefox and Microsoft Edge 
will happen in the future.

### Used technologies

- Java
- Maven
- Junit 5
- Boni Garcia (webdriver manager)
- Jira