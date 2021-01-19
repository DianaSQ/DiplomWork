package com.local.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    private WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Article']")
    private WebElement articleMenuButton;

    @FindBy(xpath = "//span[text()='New']")
    private WebElement newMenuButton;

    @FindBy(xpath = "//span[text()='Hotel']")
    private WebElement newHotelMenuButton;

    public HomePage hoverArticleMenuButton (){
        Actions action= new Actions(driver);
        action.moveToElement(articleMenuButton).build().perform();
        return this;
            }

    public HomePage hoverNewMenuButton (){
        Actions action= new Actions(driver);
        action.moveToElement(newMenuButton).build().perform();
        return this;
    }

    public  HomePage clickHomeMenuButton (){
        newHotelMenuButton.click();
        return this;


    }


}
