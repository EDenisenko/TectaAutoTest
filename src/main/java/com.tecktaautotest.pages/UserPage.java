package com.tecktaautotest.pages;

import flexjson.transformer.StringTransformer;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Set;

import static java.lang.Math.getExponent;
import static java.lang.Math.random;
import static java.nio.file.Files.setAttribute;
import static org.cyberneko.html.HTMLElements.getElement;
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

    @FindBy(xpath = "//li[@id='h-facilities']/a")
    private WebElement FacilityLink;

    @FindBy(xpath = "//th[@class='relative region-code region-square ']/ul/li[@class='drop-down-menu-container']")
    private WebElement dropdownMenuRegionFilter;

    @FindBy(xpath = "//th[@class='relative region-code']/ul/li/a').setAttribute('true','10')")
    private WebElement DropDownMenu;

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public void go_to_project_page(String nameFacility) {
        element(InputNameFacility).type(nameFacility);
        element(ClickSearchButton).click();
        element(pleaseWait).waitUntilNotVisible();
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
        element(SelectedFacility).selectByIndex((int)(Math.random()*(count-2)+2));
        element(pleaseWait).waitUntilNotVisible();
    }

    public void check_facility_filter() throws InterruptedException {
        int count = getDriver().findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
        for (int i=2; i<count; i++){
            if (element("//table[@class='data-table']/tbody/tr[2]/td").getText()=="No Project Data to Display"){
                i=count;
            }
            else{
                String str= element("//select[@id='facility-id']").getSelectedVisibleTextValue();
                element("//table[@class='data-table']/tbody/tr["+i+"]/td[1]/a[contains(text(),\""+str+"\")]").isEnabled();
            }
        }
    }

    public void go_to_user_report_page_lite_step(String facility) {
        element(InputNameFacility).type(facility);
        element(ClickSearchButton).click();
        element(pleaseWait).waitUntilNotVisible();
        element(ClickLinkFacility).click();
        element(ClickLinkReports).click();
    }

    public void check_lite_reports() throws InterruptedException, IOException {
        int count = getDriver().findElements(By.xpath("html/body/div[2]/div[2]/div[4]/table/tbody/tr")).size();
        for( int i=2; i<count; i++ ){
            element("//table[@class='data-table']/tbody/tr["+i+"]/td/a").click();
            Thread.sleep(1000);
            Runtime.getRuntime().exec("C:\\TectaHelpFiles\\Esc.exe");
            }
    }

    public void go_to_report_page(String facility) {
        element(InputNameFacility).type(facility);
        element(ClickSearchButton).click();
        element(pleaseWait).waitUntilNotVisible();
        element(ClickLinkFacility).click();
        element(projectLink).click();
    }

    public void report_check() throws InterruptedException, IOException {
        int count = getDriver().findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
        element("//table[@class='data-table']/tbody/tr["+((int)(Math.random()*(count-2))+2)+"]/td/a[2]").click();
        int coutnrep = getDriver().findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
        element("//li[@id='h-reports']/a").click();
        for ( int i=2; i<6; i++){
                element("//table[@class='data-table']/tbody/tr["+i+"]/td/a").click();
                Thread.sleep(1000);
                Runtime.getRuntime().exec("C:\\TectaHelpFiles\\Esc.exe");
        }
        element("//select[@id='report-master_project']").selectByIndex((int)(Math.random()*(coutnrep)));
        element("//form/a[1]/span").click();
        Runtime.getRuntime().exec("C:\\TectaHelpFiles\\Esc.exe");
    }

    public void select_project_type_value() {
        int count = getDriver().findElements(By.xpath("//select[@id='projecttype-id']/option")).size();
        element("//select[@id='projecttype-id']").selectByIndex((int)(Math.random()*(count-2)+2));
        element(pleaseWait).waitUntilNotVisible();

    }

    public void assert_project_type_value() {
        int count = getDriver().findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
        for (int i=2; i<count; i++){
            if (element("//table[@class='data-table']/tbody/tr[2]/td").getText()=="No Project Data to Display"){
                i=count;
            }
            else{
                String str= element("//select[@id='projecttype-id']").getSelectedVisibleTextValue();
                element("//table[@class='data-table']/tbody/tr["+i+"]/td[1]/a[contains(text(),\""+str+"\")]").isEnabled();
            }
        }
    }

    public void select_project_type_and_value_filter() {
        int count = getDriver().findElements(By.xpath(FacilityCount)).size();
        element(SelectedFacility).selectByIndex((int)(Math.random()*(count-2)+2));
        element(pleaseWait).waitUntilNotVisible();
        int cou = getDriver().findElements(By.xpath("//select[@id='projecttype-id']/option")).size();
        element("//select[@id='projecttype-id']").selectByIndex((int)(Math.random()*(cou-2)+2));
        element(pleaseWait).waitUntilNotVisible();
    }

    public void assert_project_type_and_facility_filter() {
        int count = getDriver().findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
        for (int i=2; i<count; i++){
            if (element("//table[@class='data-table']/tbody/tr[2]/td").getText()=="No Project Data to Display"){
                i=count;
            }
            else{
                String str= element("//select[@id='projecttype-id']").getSelectedVisibleTextValue();
                String st= element("//select[@id='facility-id']").getSelectedVisibleTextValue();
                element("//table[@class='data-table']/tbody/tr["+i+"]/td[1]/a[contains(text(),\""+str+"\")]").isEnabled();
                element("//table[@class='data-table']/tbody/tr["+i+"]/td[1]/a[contains(text(),\""+st+"\")]").isEnabled();
            }
        }
    }

    public void go_to_facility_select(String facility) {
        element(InputNameFacility).type(facility);
        element(ClickSearchButton).click();
        element(pleaseWait).waitUntilNotVisible();
        element(ClickLinkFacility).click();
        element(FacilityLink).click();
        }

    public void select_region_filter() throws InterruptedException, IOException {
        int count = getDriver().findElements(By.xpath("//ul[@class='drop-down-menu filter-drop-down-menu drop-down-menu-region']/li")).size();
        WebElement element = getDriver().findElement(By.xpath("//th[@class='relative region-code']/ul/li/ul"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "display: block;");
        int i =  (int)(Math.random()*(count-4)+4);
        element(By.xpath("//ul[@class='drop-down-menu filter-drop-down-menu drop-down-menu-region']/li["+i+"]/a")).waitUntilVisible();
        String Str = getDriver().findElement(By.xpath("//ul[@class='drop-down-menu filter-drop-down-menu drop-down-menu-region']/li["+i+"]/a")).getText();
        getDriver().findElement(By.xpath("//ul[@class='drop-down-menu filter-drop-down-menu drop-down-menu-region']/li["+i+"]/a")).click();
        element(pleaseWait).waitUntilVisible();
        element(pleaseWait).waitUntilNotVisible();
        String Str1 = getDriver().findElement(By.xpath("//table[@class='data-table']/tbody/tr[3]/td[2]")).getText();

        if (element("//table[@class='data-table']/tbody/tr[3]/td").getText()=="No records found"){
            assertThat("12",is ("12"));}
            else
            if (Str.equals(Str1)){
                assertThat("12", is ("12")); }
                else {
                assertThat("12", is("11"));
            }
        //Thread.sleep(9000);
    }


    public void select_filter_city() throws InterruptedException {
        WebElement element = getDriver().findElement(By.xpath("//th[@class='city-code']/ul/li/ul"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "display: block;");
        //int count = getDriver().findElements(By.xpath("//ul[@class='drop-down-menu-city filter-drop-down-menu drop-down-menu']/li/div/ul/li")).size();
        //int i = (int)(Math.random()*(count-4)+4);
        String Str = getDriver().findElement(By.xpath("//ul[@class='drop-down-menu-city filter-drop-down-menu drop-down-menu']/li/div/ul/li[5]/a")).getText();
        getDriver().findElement(By.xpath("//ul[@class='drop-down-menu-city filter-drop-down-menu drop-down-menu']/li/div/ul/li[5]/a")).click();
        element(pleaseWait).waitUntilVisible();
        element(pleaseWait).waitUntilNotVisible();
        String Str1 = getDriver().findElement(By.xpath("//table[@class='data-table']/tbody/tr[3]/td[2]")).getText();

        Thread.sleep(9000);
    }
}
