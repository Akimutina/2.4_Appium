package ru.netology.qa.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainScreen {

    @AndroidFindBy(id = "userInput")
    public WebElement userInput;

    @AndroidFindBy(id = "buttonChange")
    public WebElement buttonChange;

    @AndroidFindBy(id = "textToBeChanged")
    public WebElement textToBeChanged;

    @AndroidFindBy(id = "buttonActivity")
    public WebElement buttonActivity;

    @AndroidFindBy(id = "text")
    public  WebElement activityText;

    private AppiumDriver driver;

    public MainScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }
}


