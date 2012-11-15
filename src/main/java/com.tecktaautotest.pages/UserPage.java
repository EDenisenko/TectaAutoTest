package com.tecktaautotest.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 07.11.12
 * Time: 14:16
 * To change this template use File | Settings | File Templates.
 */
public class UserPage extends PageObject {

    @FindBy(xpath = "//ul/li[3]/a")
    private WebElement projectLink;

    @FindBy(id = "search-from")
    private WebElement inputFirstDate;

    @FindBy(id = "search-to")
    private WebElement inputLastDate;

    @FindBy(xpath = "//a[@id='project-date-search']")
    private WebElement searchButton;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//tr[3]/td[3]/a")
    private WebElement inputLastDateClick;

    @FindBy(id = "ui-datepicker-div")
    private WebElement calendarFirst;

    @FindBy(id = "please-wait")
    private WebElement pleaseWait;

    @FindBy(id = "facility-id")
    private WebElement selectFacility;

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public void go_to_project_page() {
        element(projectLink).click();
    }

    public void select_first_last_date(String firstdate, String lastdate) {
        element(inputFirstDate).click();
        element(calendarFirst).waitUntilVisible();
        //element(calendarFirst).waitUntilNotVisible();
        element(inputFirstDate).type(firstdate);

        element(inputLastDate).click();
        //element(calendarFirst).waitUntilNotVisible();
        element(calendarFirst).waitUntilVisible();
        element(inputLastDate).type(lastdate);
        element(calendarFirst).waitUntilNotVisible();

        //element(inputLastDateClick).click();
        getDriver().findElement(By.xpath("//a[@id='project-date-search']")).submit();
        element(pleaseWait).waitUntilNotVisible();
        /*element(searchButton).click();
        element(pleaseWait).waitUntilNotVisible();
        element(searchButton).click();*/
    }

    public void select_facility_filter(String facilityname) {
        element(selectFacility).click();
        element(selectFacility).selectByValue(facilityname);
    }
}
