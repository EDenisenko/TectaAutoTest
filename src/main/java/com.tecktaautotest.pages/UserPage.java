package com.tecktaautotest.pages;

import flexjson.transformer.StringTransformer;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Math.random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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

    @FindBy(xpath = "//table[@class='data-table']/tbody/tr[2]/td[2]")
    private WebElement DateResult;

    @FindBy(xpath = "//th/a[contains(text(),\"Date\")]")
    private WebElement SortDateClick;

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public void go_to_project_page() {
        element(projectLink).click();
    }

    public void select_first_last_date(String firstdate, String lastdate) {
        element(inputFirstDate).click();
        element(inputFirstDateMonth).selectByIndex((int)(Math.random()*12));
        element(inpuFirstDateYear).selectByIndex((int)(Math.random()*6));
        element(inputFirstDateDay).click();
        element(inputLastDate).click();
        element(inputFirstDateMonth).selectByIndex((int)(Math.random()*12));
        element(inpuFirstDateYear).selectByIndex((int)(Math.random()*6)+6);
        element(inputFirstDateDay).click();
        element(searchButton).click();
    }

    public void select_facility_filter(String facilityname) {
        element(selectFacility).click();
        element(selectFacility).selectByValue(facilityname);
    }

    public void assert_incorect_the_date() throws InterruptedException {
        String StrFirstDate = element(inputLastDate).getTextValue();
        String StrFirstDateRes = element(DateResult).getText();
        Thread.sleep(4000);
        element(SortDateClick).click();
        Thread.sleep(4000);
        String StrLastDateRes = element(DateResult).getText();
        String StrLastDate = element(inputFirstDate).getTextValue();
        int FD,FDR,LD,LDR;
        FD = Integer.parseInt(StrFirstDate.substring(6,10)+StrFirstDate.substring(0,2)+"15");
        FDR = Integer.parseInt(StrFirstDateRes.substring(6,10)+StrFirstDateRes.substring(0,2)+StrFirstDateRes.substring(3,5));
        LD = Integer.parseInt(StrLastDate.substring(6,10)+StrLastDate.substring(0,2)+"15");
        LDR = Integer.parseInt(StrLastDateRes.substring(6,10)+StrLastDateRes.substring(0,2)+StrLastDateRes.substring(3,5));
        if ((FD>=FDR)&&(LD<=LDR)){}
        else assertThat("12", is("11"));
    }
}
