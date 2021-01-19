package com.local.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterNewHotelPage {
    private WebDriver driver;

    public RegisterNewHotelPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add_hotel:name")
    private WebElement nameField;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    @FindBy(xpath ="//div[contains(@class,'ui-rating')][2]")
    private WebElement firstRatingStar;

    @FindBy(xpath ="//div[contains(@class,'ui-rating')][3]")
    private WebElement secondRatingStar;

    @FindBy(xpath ="//div[contains(@class,'ui-rating')][4]")
    private WebElement thirdRatingStar;

    @FindBy(xpath ="//div[contains(@class,'ui-rating')][5]")
    private WebElement fourRatingStar;

    @FindBy(xpath ="//div[contains(@class,'ui-rating')][6]")
    private WebElement fiveRatingStar;

     @FindBy(xpath = "//span[@id='add_hotel:dateOfConstruction']/child::button")
     private WebElement calendarDAteOfConstruction;

     @FindBy(xpath = "//a[contains(text(), '12')]")
     private WebElement dateTwelveOfDecember;

     @FindBy(xpath = "//input[@id='add_hotel:dateOfConstruction_input']")
     private WebElement dateOfConstractioField;

     @FindBy(xpath = "//label[@id='add_hotel:country_label']")
     private WebElement countryDropdown;

     @FindBy(xpath = "//li[@data-label='Ukraine']")
     private WebElement countryUkraine;

     @FindBy(css ="div[id$='city']")
     private WebElement cityDropdown;

     @FindBy(xpath = "//li[@data-label='Kyiv']")
     private WebElement cityKyiv;

     @FindBy(xpath = "//input[@id='add_hotel:short_description']")
     private WebElement shortDescriptionField;

     @FindBy(xpath = "//textarea[@id='add_hotel:description']")
     private WebElement descriptionField;

     @FindBy(xpath = "//span[contains(text(),'Description:')]")
     private WebElement descriptionErrorMessage;

     @FindBy(xpath = "//textarea[@id='add_hotel:notes']")
     private  WebElement notesField;

    public RegisterNewHotelPage enterAlphaNumericToNAmeField(){
        nameField.sendKeys("Name12");
        return  this;
    }

    public RegisterNewHotelPage clickSaveButton(){
        saveButton.click();
        return  this;
    }

    public RegisterNewHotelPage clickFirstRatingStar (){
        firstRatingStar.click();
        return  this;
    }

    public RegisterNewHotelPage clickSecondRatingStar (){
        secondRatingStar.click();
        return  this;
    }

    public RegisterNewHotelPage clickThirdRatingStar (){
        thirdRatingStar.click();
        return  this;
    }

    public RegisterNewHotelPage clickFourRatingStar (){
        fourRatingStar.click();
        return  this;
    }

    public RegisterNewHotelPage clickFiveRatingStar (){
        fiveRatingStar.click();
        return  this;
    }

    public RegisterNewHotelPage openCalenderAndclickDate(){
         calendarDAteOfConstruction.click();;
         dateTwelveOfDecember.click();
        return  this;
    }

    public RegisterNewHotelPage enterToDateOfConstractionValidValue(){
        dateOfConstractioField.sendKeys("12.12.2020");
        return  this;
    }

    public RegisterNewHotelPage enterToDateOfConstractionINVALIDValue(){
        dateOfConstractioField.sendKeys("1222.12.2020");
        return  this;
    }

    public RegisterNewHotelPage openCountryDropDown(){
        countryDropdown.click();
        return  this;
    }

    public RegisterNewHotelPage selectCountry(){
        countryUkraine.click();
        return  this;
    }


    public RegisterNewHotelPage openCityDropdown(){
        cityDropdown.click();
        return  this;
    }

    public RegisterNewHotelPage selectCity (){
        cityKyiv.click();
        return this;
    }

    public RegisterNewHotelPage clickShortDescriptionField(){
        shortDescriptionField.click();
        return this;
    }

    public RegisterNewHotelPage enterDataToShortDescriptionField(){
        shortDescriptionField.sendKeys("123Test");
        return this;
    }

    public RegisterNewHotelPage clickDescriptionField(){
        descriptionField.click();
        return this;
    }

    public RegisterNewHotelPage enterDataToDescriptionField(){
        descriptionField.sendKeys("Test Description 1");
        return this;
    }

    public RegisterNewHotelPage clickNotesField(){
        notesField.click();
        return this;
    }
    public RegisterNewHotelPage addDataToNotesField(){
        notesField.sendKeys("Test Notes");
        return this;
    }

}
