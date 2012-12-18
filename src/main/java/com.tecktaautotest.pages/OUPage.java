package com.tecktaautotest.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 15.11.12
 * Time: 18:37
 * To change this template use File | Settings | File Templates.
 */
public class OUPage extends PageObject{

    @FindBy(xpath = "//td[@class='gray-border a-center functional-buttons']/span[2]/span/button")
    private WebElement SettingsButtonClick;

    @FindBy(xpath = "//table[@class='data-table settings-table']/tbody/tr[6]/td[2]/span/span/button")
    private WebElement ClickManegeOUButton;

    @FindBy(xpath = "//button[@class='button new-user']")
    private WebElement ClickCreatNewOU;

    @FindBy(id = "tou-name")
    private WebElement InputNameText;

    @FindBy(id = "tou-tecta_region_id")
    private WebElement InputRegionText;

    @FindBy(id = "tou-addres1")
    private WebElement InputAdressText;

    @FindBy(id = "tou-city")
    private WebElement InputOuCityText;

    @FindBy(id="tou-state_code")
    private WebElement InputStateText;

    @FindBy(id="tou-postal_code")
    private WebElement InputOuZipCode;

    @FindBy(id="submit-btn")
    private WebElement ClickSubmitButton;

    @FindBy(xpath = "")
    private WebElement HomeLinkClick;

    @FindBy(id = "please-wait")
    private WebElement pleaseWait;

    public OUPage(WebDriver driver) {
        super(driver);
    }

    public void go_to_ou_add_page(String ouTestName, String ouNameRegion, String ouAddres, String ouCity, String ouState, String ouZipCode) {
       element(SettingsButtonClick).click();
       element(ClickManegeOUButton).click();
       element(ClickCreatNewOU).click();
       element(InputNameText).type(ouTestName);
       element(InputRegionText).selectByVisibleText(ouNameRegion);
       element(InputAdressText).type(ouAddres);
       element(InputOuCityText).type(ouCity);
       element(InputStateText).selectByVisibleText(ouState);
       element(InputOuZipCode).type(ouZipCode);
       element(ClickSubmitButton).click();
    }
}
