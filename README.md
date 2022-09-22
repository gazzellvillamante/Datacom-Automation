# Selenium WebDriver Test Automation Framework
This is a repository for Datacom Automation Exercise

## Overview of Automation Framework

This framework was created using Selenium Webdriver with Java and it also used TestNG allow parallel execution.

This framework also made use of the page object pattern wherein in the pageobjects and methods are separated from the actual test scripts which makes the framework easy to maintain. For example, if a page element changes a property in its locator you only need to update that specific element on the pageobject package and that change will be applied to all of the test cases that uses the specific element. Same goes with a method, if something has changed with the on the logic side, just update that specific method and that changed will be applied to all of the scripts that is calling that method.

The framework also comes with reusable basic methods that have very straightforward names (i.e. clickElement, enterValue, waitElementVisible) which would come in handy to those testers who are not well-versed with programming using Java to be able to create a script/methods that will cater to new features/ functionality.


## Structure of the Framework

This framework is composed of 3 packages namely enums, pageobjects and  testdata.

### enums package
This package contains our constant variables such as URL of the application under test as well as the Firefox and Chrome driver path.

### pageobjects package
This package contains the classes which represents each page of the application under test. These classes is where the page objects are defined using the @FindBy annotation or driver.FindBy locator. It also holds the methods of (all) the possible actions that can be done on a certain page like clickButton, enterPayeeDetails, verifyPayeeAdded. In this way, testers can just simply call these functions when writing the actual test script and just provide the data needed for them to be executed.

### testdata package
This package contains the data that will be used by the scripts. It consists of an enum class containing constant variable which is the parameter name and a member variable which is the parameter value.
```
public enum TC2 {
    PAYEE_NAME("Test 2"),
    PAYEE_ACCOUNT_NUM("1234569876543001"),
    FOR_YOU_PARTICULAR("Test");

```
It also has a variable that will take the value of the constructor since it will automatically get the value of the member variable. In order to retrieve the data on the actual test script, we have the getName method which will return the name value.
```
    private String name;

    TC2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
```

So to use the testdata in the actual test script you just have to call the name of the enum class dot constant. It's also easy to maintain this testdata since all you have to do is just supply a data or leave the constant variable blank when you are not using a certain parameter in your script. You can also add more parameter by defining more constant variables.
```
	payees.enterPayeeDetails(TC2.PAYEE_NAME.getName(), TC2.PAYEE_ACCOUNT_NUM.getName(), 		TC2.FOR_YOU_PARTICULAR.getName(),
                TC2.FOR_YOU_CODE.getName(), TC2.FOR_YOU_REFERENCE.getName(), 		TC2.FOR_PAYEE_PARTICULAR.getName(),
                TC2.FOR_PAYEE_CODE.getName(), TC2.FOR_PAYEE_REFERENCE.getName(), TC2.IDENTIFIER.getName(),
                TC2.RELATIONSHIP.getName(), TC2.PAYER_NAME.getName());
```



## How to Create A Test
To create a test, first, you have to define a webdriver. This will be passed to the java objects that you will create later to ensure that your test will run on a single session no matter what/how many (page) classes you will use. This can be done by calling initializeBrowser from the BasePage class. Next, you will have to create an object of the class that you will be needing in your test. This will enable you to access all of the available methods in that class. Refer to example below

```
	WebDriver driver = BasePage.initializeBrowser("chrome");
        HomePage home = new HomePage(driver);
        PayeesPage payees  = new PayeesPage(driver);

        home.navigateToPage("Payees");
        payees.verifyLoadedPage("Payees");
```