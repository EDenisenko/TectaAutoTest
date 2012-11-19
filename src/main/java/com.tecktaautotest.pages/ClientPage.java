package com.tecktaautotest.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 19.11.12
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */
public class ClientPage extends PageObject {

    @FindBy(xpath = "//span/button[@class='button new-user']")
    private WebElement NewClientButtonClick;

    @FindBy(id = "client-name")
    private WebElement ClientNameSet;

    @FindBy(id = "address-address1")
    private WebElement ClientAdressSet;

    @FindBy(id = "address-city")
    private WebElement ClientCitySet;

    @FindBy(id = "address-state_id")
    private WebElement ClientStateSet;

    @FindBy(id = "address-zip")
    private WebElement ClientZipSet;

    @FindBy(id = "client-tou_id")
    private WebElement ClientOuSet;

    @FindBy(xpath = "//span[@class='button']/span/button[@type='submit']")
    private WebElement ClientButtonClick;

    @FindBy(id = "grid-filter-input")
    private WebElement SearchFild;

    @FindBy(xpath = "//span[@class='button']/span/button[@type='submit']")
    private WebElement SearchButtonClick;

    @FindBy(xpath = "//a[contains(text(),\"My Test Client\")]")
    private WebElement ClientNameClick;

    @FindBy(xpath = "//a[contains(text(),\"Facilities\")]")
    private WebElement ClickFacility;

    @FindBy(xpath = "//button[@class='button new-user']")
    private WebElement ClickButtonNewFacility;

    @FindBy(id = "facility-name")
    private WebElement FacilityNameSet;

    @FindBy(id = "address-0-address1")
    private WebElement FacilityStreetSet;

    @FindBy(id = "address-0-city")
    private WebElement FacilityCitySet;

    @FindBy(id = "address-0-state_id")
    private WebElement FacilityStateSet;

    @FindBy(id = "address-0-zip")
    private WebElement FacilityZipSet;

    @FindBy(id = "contact-0-method-0-contact_method_type_id")
    private WebElement FacilityContactMethodSet;

    @FindBy(id = "contact-0-method-0-value")
    private WebElement FaciityContactSet;

    @FindBy(xpath = "//span[@class='button']/span/button[@type='submit']")
    private WebElement FacilityButtonSubmit;

    public ClientPage(WebDriver driver) {
        super(driver);
    }

    public void go_client_add_page(String clientTestName, String OUTestName, String clientTestAdress, String clientTestCity, String clientTestState, String clientTestZipCode) {
        element(NewClientButtonClick).click();
        element(ClientNameSet).type(clientTestName);
        element(ClientAdressSet).type(clientTestAdress);
        element(ClientCitySet).type(clientTestCity);
        element(ClientStateSet).selectByVisibleText(clientTestState);
        element(ClientZipSet).type(clientTestZipCode);
        element(ClientOuSet).selectByVisibleText(OUTestName);
        element(ClientButtonClick).click();
    }

    public void add_new_facility_to_new_client(String clientName) {
        element(SearchFild).type(clientName);
        element(SearchButtonClick).click();
        element(ClientNameClick).click();
        element(ClickFacility).click();
        for(int i=1; i<10; i++){
        element(ClickButtonNewFacility).click();
        element(FacilityNameSet).type("Facility"+i);
        element(FacilityStreetSet).type("221 North Main");
        element(FacilityCitySet).type("Aberdeen");
        element(FacilityStateSet).selectByVisibleText("South Dakota");
        element(FacilityZipSet).type("57402");
        element(FacilityContactMethodSet).selectByVisibleText("Office Phone");
        element(FaciityContactSet).type("605-225-6780");
        element(FacilityButtonSubmit).click();}
    }
}
