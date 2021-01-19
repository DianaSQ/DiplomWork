package com.localpackege;

import com.local.pages.HomePage;
import com.local.pages.RegisterNewHotelPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;



public class MainClassWithTests extends BasicClass{
    private HomePage homePage;
    private RegisterNewHotelPage registerNewHotelPage;

    @BeforeClass
    public static void beforeRegistrationPageTest() {
        chrome.navigate().to("http://localhost:8080/article");
    }

    @Before
    public void setUpMethods(){
        homePage = new HomePage(chrome);
        registerNewHotelPage = new RegisterNewHotelPage(chrome);

    }
    @Test
    public void  verifyOpenNewHomePage(){
        homePage.hoverArticleMenuButton();
        homePage.hoverNewMenuButton();
        homePage.clickHomeMenuButton();
        boolean isDataSectionISDisplayed = chrome.findElement(By.xpath("//span[text()='Data:']")).isDisplayed();
        boolean isSAveButtonIsDisplayed = chrome.findElement(By.xpath("//span[text()='Save']")).isDisplayed();
        Assert.assertTrue("Data section should be displayed", isDataSectionISDisplayed);
        Assert.assertTrue("Save button should be displayed", isSAveButtonIsDisplayed);

    }

         @Test
    public void verifyThatNameFieldIsEditable(){
             homePage.hoverArticleMenuButton();
             homePage.hoverNewMenuButton();
             homePage.clickHomeMenuButton();
            boolean isNameFieldISDisplayed = chrome.findElement(By.xpath("//label[text()='Name:']")).isDisplayed();
             boolean isAsteriskNameFieldIsDisplayed= chrome.findElement(By.xpath("//label[@id='add_hotel:j_idt42']/child::span")).isDisplayed();
             Assert.assertTrue("Name field is displayed", isNameFieldISDisplayed);
             Assert.assertTrue("Name field has asterisk", isAsteriskNameFieldIsDisplayed);
         }

         @Test
    public void  verifyNAmeFieldCantBeEmpty(){
             homePage.hoverArticleMenuButton();
             homePage.hoverNewMenuButton();
             homePage.clickHomeMenuButton();
             registerNewHotelPage.clickSaveButton();
             Assert.assertTrue("Error that 'Name field is required should be displayed'", chrome.findElement(By.xpath("//span[text()='Name: Validation Error: Value is required.']")).isDisplayed());
         }

         @Test
    public void testEnterAndSaveNameFieldWithValidData(){
             homePage.hoverArticleMenuButton();
             homePage.hoverNewMenuButton();
             homePage.clickHomeMenuButton();
             registerNewHotelPage.enterAlphaNumericToNAmeField();
             registerNewHotelPage.clickSaveButton();
         }

         @Test
    public void testClickingGlobalRating(){
             homePage.hoverArticleMenuButton();
             homePage.hoverNewMenuButton();
             homePage.clickHomeMenuButton();
             registerNewHotelPage.clickFirstRatingStar();
             registerNewHotelPage.clickSecondRatingStar();
             registerNewHotelPage.clickThirdRatingStar();
             registerNewHotelPage.clickFourRatingStar();
             registerNewHotelPage.clickFiveRatingStar();
             Assert.assertTrue("'Global Rating' area is displayed", chrome.findElement(By.xpath("//label[@for='add_hotel:rate']")).isDisplayed());
         }

         @Test
    public void verifyDAteOfConstructionFieldIsDisplayed(){
             homePage.hoverArticleMenuButton();
             homePage.hoverNewMenuButton();
             homePage.clickHomeMenuButton();
             Assert.assertTrue("'Date of Construction:' is displayed", chrome.findElement(By.xpath("//label[@id='add_hotel:j_idt46']")).isDisplayed());
             Assert.assertTrue("'*' should be displayed near with 'Date of Construction:'", chrome.findElement(By.xpath("//label[@id='add_hotel:j_idt46']/child::span")).isDisplayed());
         }

         @Test
    public void verifyDAteOfConstructionFieldIsEdit(){
             homePage.hoverArticleMenuButton();
             homePage.hoverNewMenuButton();
             homePage.clickHomeMenuButton();
             registerNewHotelPage.enterToDateOfConstractionValidValue();
             registerNewHotelPage.clickSaveButton();
         }

         @Test
    public void testImpossibleToEnterNotDataFormatToConstructionField(){
             homePage.hoverArticleMenuButton();
             homePage.hoverNewMenuButton();
             homePage.clickHomeMenuButton();
             registerNewHotelPage.enterToDateOfConstractionINVALIDValue();
             registerNewHotelPage.clickSaveButton();
             Assert.assertTrue("Error message about Invalid data should appear", chrome.findElement(By.xpath("//span[contains(text(),'Date of Construction:')]")).getText().contains("Date of Construction: '1222.12.2020' could not be understood as a date. Example: 10.01.21"));
         }

         @Test
    public void testImpossibleToSaveEmptyDataFormatToConstructionField(){
             homePage.hoverArticleMenuButton();
             homePage.hoverNewMenuButton();
             homePage.clickHomeMenuButton();
             registerNewHotelPage.clickSaveButton();
             Assert.assertTrue("'Date of Construction:' can't be empty", chrome.findElement(By.xpath("//span[contains(text(),'Date of Construction:')]")).getText().contains("Date of Construction: Validation Error: Value is required."));

         }

         @Test
    public void testCountryFieldIsPresentAndAsterisk(){
             homePage.hoverArticleMenuButton();
             homePage.hoverNewMenuButton();
             homePage.clickHomeMenuButton();
             Assert.assertTrue("'Country' fiels is displayed", chrome.findElement(By.xpath("//label[@id='add_hotel:j_idt48']")).isDisplayed());
             Assert.assertTrue("'*' sign should be near with 'Country' field", chrome.findElement(By.xpath("//label[@id='add_hotel:j_idt48']/child::span")).isDisplayed());
         }

    @Test
    public void testCountryFieldEmptyFieldError(){
        homePage.hoverArticleMenuButton();
        homePage.hoverNewMenuButton();
        homePage.clickHomeMenuButton();
        registerNewHotelPage.clickSaveButton();
        Assert.assertTrue("'Country: Validation Error: Value is required.' message should appear", chrome.findElement(By.xpath("//span[contains(text(),'Country:')]")).getText().contains("Country: Validation Error: Value is required."));
    }

    @Test
    public void testSelectCountry(){
        homePage.hoverArticleMenuButton();
        homePage.hoverNewMenuButton();
        homePage.clickHomeMenuButton();
       registerNewHotelPage.openCountryDropDown();
        registerNewHotelPage.selectCountry();
        Assert.assertTrue("'Ukraine' should be displayed in the 'Country'field ", chrome.findElement(By.xpath("//div[@id='add_hotel:country']")).getText().contains("Ukraine"));
    }

    @Test
    public void verifyCountryFieldAndAsteriskIsDisplayed(){
        homePage.hoverArticleMenuButton();
        homePage.hoverNewMenuButton();
        homePage.clickHomeMenuButton();
        Assert.assertTrue("'City' field is displayed", chrome.findElement(By.xpath("//label[@id='add_hotel:j_idt52']")).isDisplayed());
        Assert.assertTrue("'*' sign should be near with 'City' field", chrome.findElement(By.xpath("//label[@id='add_hotel:j_idt52']/child::span")).isDisplayed());

    }

    @Test
    public void testImpossibleSaveEmptyCityField(){
        homePage.hoverArticleMenuButton();
        homePage.hoverNewMenuButton();
        homePage.clickHomeMenuButton();
        registerNewHotelPage.clickSaveButton();
        Assert.assertTrue("'City: Validation Error: Value is required.", chrome.findElement(By.xpath("//span[contains(text(),'City:')]")).getText().contains("City: Validation Error: Value is required."));

    }
//тест постоянно падает на открытии City Дропдауна
    @Test
    public void testSelectCity(){
        homePage.hoverArticleMenuButton();
        homePage.hoverNewMenuButton();
        homePage.clickHomeMenuButton();
       registerNewHotelPage.openCountryDropDown();
       registerNewHotelPage.selectCountry();
     registerNewHotelPage.openCityDropdown();
       registerNewHotelPage.selectCity();
        Assert.assertTrue("'Kyiv' should be displayed in the 'City'field ", chrome.findElement(By.cssSelector("div[id$='city']")).getText().contains("Kyiv"));
    }

    @Test
    public void testShortDescriptionFieldIsDisplayedWithAsterisk(){
        homePage.hoverArticleMenuButton();
        homePage.hoverNewMenuButton();
        homePage.clickHomeMenuButton();
        Assert.assertTrue("'Short Description' fields is displayed", chrome.findElement(By.xpath("//label[@id='add_hotel:j_idt56']")).isDisplayed());
        Assert.assertTrue("'*' sign should be near with 'Short Description' field", chrome.findElement(By.xpath("//label[@id='add_hotel:j_idt56']/child::span")).isDisplayed());
    }

    @Test
    public void testImpossibleToSaveEmptyShortDescriptionField(){
        homePage.hoverArticleMenuButton();
        homePage.hoverNewMenuButton();
        homePage.clickHomeMenuButton();
        registerNewHotelPage.clickSaveButton();
        Assert.assertTrue("'Short Description: Validation Error: Value is required.' message is displayed", chrome.findElement(By.xpath("//span[contains(text(),'Short')]")).getText().contains("Short Description: Validation Error: Value is required."));
    }

    @Test
    public void testSavingShortDescriptionFieldWithValidData(){
        homePage.hoverArticleMenuButton();
        homePage.hoverNewMenuButton();
        homePage.clickHomeMenuButton();
        registerNewHotelPage.clickShortDescriptionField();
        registerNewHotelPage.enterDataToShortDescriptionField();
        registerNewHotelPage.clickSaveButton();
    }

    @Test
    public void testDescriptionFieldIsDisplayedWithAsterisk() {
        homePage.hoverArticleMenuButton();
        homePage.hoverNewMenuButton();
        homePage.clickHomeMenuButton();
        Assert.assertTrue("'Description' fields is displayed", chrome.findElement(By.xpath("//label[@id='add_hotel:j_idt58']")).isDisplayed());
        Assert.assertTrue("'*' sign should be near with 'Description' field", chrome.findElement(By.xpath("//label[@id='add_hotel:j_idt58']/child::span")).isDisplayed());

    }
    @Test
    public void testImpossibleToSaveEmptyDescriptionField(){
        homePage.hoverArticleMenuButton();
        homePage.hoverNewMenuButton();
        homePage.clickHomeMenuButton();
        registerNewHotelPage.clickSaveButton();
        Assert.assertTrue("'Description: Validation Error: Value is required.' message is displayed", chrome.findElement(By.xpath("//span[contains(text(),'Description:')]")).getText().contains("Description: Validation Error: Value is required."));
    }
    @Test
    public void testSavingDescriptionFieldWithValidData(){
        homePage.hoverArticleMenuButton();
        homePage.hoverNewMenuButton();
        homePage.clickHomeMenuButton();
        registerNewHotelPage.clickDescriptionField();
        registerNewHotelPage. enterDataToDescriptionField();
        registerNewHotelPage.clickSaveButton();

    }


    @Test
    public void testNotesFieldIsDisplayed() {
        homePage.hoverArticleMenuButton();
        homePage.hoverNewMenuButton();
        homePage.clickHomeMenuButton();
        Assert.assertTrue("'Notes' fields is displayed", chrome.findElement(By.xpath("//label[@id='add_hotel:j_idt60']")).isDisplayed());
    }

    @Test
    public void testAddAndSAveNotes(){
        homePage.hoverArticleMenuButton();
        homePage.hoverNewMenuButton();
        homePage.clickHomeMenuButton();
        registerNewHotelPage.clickNotesField();
        registerNewHotelPage.addDataToNotesField();
        registerNewHotelPage.clickSaveButton();

    }

}
