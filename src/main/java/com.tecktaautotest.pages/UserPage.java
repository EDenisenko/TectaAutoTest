package com.tecktaautotest.pages;

import flexjson.transformer.StringTransformer;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.util.Set;

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

    @FindBy(id = "grid-filter-input")
    private WebElement InputNameFacility;

    @FindBy(xpath = "//span[@class='button']/span/button[@type='submit']")
    private WebElement ClickSearchButton;

    @FindBy(xpath = "//a[contains(text(),\"Coca-Cola Refreshments USA\")]")
    private WebElement ClickLinkFacility;

    private String FacilityCount="//select[@id='facility-id']/option";

    @FindBy(xpath = "//select[@id='facility-id']")
    private WebElement SelectedFacility;

    @FindBy(xpath = "//li[@id='h-reports']/a")
    private WebElement ClickLinkReports;

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public void go_to_project_page(String nameFacility) {
        element(InputNameFacility).type(nameFacility);
        element(ClickSearchButton).click();
        element(ClickLinkFacility).click();
        element(projectLink).click();
    }

    public void select_first_last_date() {
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

    public void assert_incorect_the_date() throws InterruptedException {
        String StrFirstDate = element(inputLastDate).getTextValue();
        Thread.sleep(4000);
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

    public void select_value_filter() {
        int count = getDriver().findElements(By.xpath(FacilityCount)).size();
        element(SelectedFacility).selectByIndex((int)(Math.random()*count));
        element(pleaseWait).waitUntilVisible();
    }

    public void check_facility_filter() {
        if (element("//div[@class='pager a-right']/a[@id='pager-go']").isVisible()){

        }
        else {

        };
    }

    public void go_to_user_report_page_lite_step(String facility) {
        element(InputNameFacility).type(facility);
        element(ClickSearchButton).click();
        element(ClickLinkFacility).click();
        element(ClickLinkReports).click();
    }

    public void check_lite_reports() throws InterruptedException, IOException {
        int count = getDriver().findElements(By.xpath("html/body/div[2]/div[2]/div[4]/table/tbody/tr")).size();
        for( int i=2; i<count; i++ ){
            element("//table[@class='data-table']/tbody/tr["+2+"]/td/a").click();
            Thread.sleep(1000);
            Runtime.getRuntime().exec("C:\\TectaHelpFiles\\Esc.exe");
            }
    }
}
