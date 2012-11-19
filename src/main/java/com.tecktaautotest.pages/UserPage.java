package com.tecktaautotest.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Math.random;

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

    @FindBy(id = "please-wait")
    private WebElement pleaseWait;

    @FindBy(id = "facility-id")
    private WebElement selectFacility;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    private WebElement inputFirstDateMonth;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    private WebElement inpuFirstDateYear;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//a[contains(text(),\"15\")]")
    private WebElement inputFirstDateDay;

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public void go_to_project_page() {
        element(projectLink).click();
    }

    public void select_first_last_date(String firstdate, String lastdate) {
        element(inputFirstDate).click();
        element(inputFirstDateMonth).selectByIndex((int)(Math.random()*12)+1);
        element(inpuFirstDateYear).selectByIndex((int)(Math.random()*6)+1);
        element(inputFirstDateDay).click();
        element(inputLastDate).click();
        element(inputFirstDateMonth).selectByIndex((int)(Math.random()*12)+1);
        element(inpuFirstDateYear).selectByIndex((int)(Math.random()*12)+6);
        element(inputFirstDateDay).click();
        element(searchButton).click();
    }

    public void select_facility_filter(String facilityname) {
        element(selectFacility).click();
        element(selectFacility).selectByValue(facilityname);
    }
}
