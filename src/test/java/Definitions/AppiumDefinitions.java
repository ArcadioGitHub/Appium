package Definitions;

import Utils.AppiumHook;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

import java.net.MalformedURLException;

public class AppiumDefinitions {

    @Before
    public void openApp() throws MalformedURLException {
        AppiumHook.executeCommand();
        AppiumHook.openApp();
    }

    @After
    public void closeApp(){
        AppiumHook.androidDriver.closeApp();
        AppiumHook.teardown();
    }

    @Given("^User opens the android app$")
    public void userOpensTheAndroidApp() throws MalformedURLException {
        System.out.println("WAS HERE");
    }

}
