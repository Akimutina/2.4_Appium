package ru.netology.qa;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.qa.screens.MainScreen;

import java.net.MalformedURLException;
import java.net.URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UIAutomatorTest {
    private AppiumDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Some name");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", ".MainActivity");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");

        URL remoteUrl = new URL("http://127.0.0.1:4723/");

        driver = new AppiumDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void newActivityTest() {
        MainScreen mainScreen = new MainScreen(driver);

        String newText = "New Test";
        mainScreen.userInput.sendKeys(newText);
        mainScreen.buttonActivity.click();
        mainScreen.activityText.isDisplayed();
        Assertions.assertEquals(newText, mainScreen.activityText.getText()) ;
    }

    @Test
    public void textBeforeAndAfterTest() {
        MainScreen mainScreen = new MainScreen(driver);

        String textBefore = mainScreen.textToBeChanged.getText();
        mainScreen.userInput.sendKeys(" ");
        mainScreen.buttonChange.click();
        String textAfter = mainScreen.textToBeChanged.getText();
        Assertions.assertEquals(textBefore, textAfter);
    }
    @AfterAll
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
