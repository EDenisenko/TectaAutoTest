package com.tecktaautotest.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 07.11.12
 * Time: 19:59
 * To change this template use File | Settings | File Templates.
 */
public class ClientAddPhotoPage extends PageObject {

    @FindBy(id = "grid-filter-input")
    private WebElement serchtext;

    @FindBy(xpath = "//form/div/span[1]/span/button")
    private WebElement searchbutton;

    @FindBy(xpath = "//a[contains(text(),\"Coca-Cola Refreshments USA\")]")
    private WebElement clientlink;

    @FindBy(xpath = "//a[contains(text(),\"Projects\")]")
    private WebElement facilitylink;

    @FindBy(xpath = "//tbody/tr[2]/td[1]/a[3]")
    private WebElement photopagelink;

    @FindBy(xpath = "//tbody/tr[3]/td[1]/a")
    private WebElement linksection;

    @FindBy(xpath = "//li[@class='proj-3']/a")
    private WebElement tabphoto;

    @FindBy(xpath = "//div[@class='uploader-container']/object")
    private WebElement openclick;

    @FindBy(xpath = "//div[@class='save-photo-orig']/a")
    private WebElement saveclick;

    @FindBy(id = "please-wait")
    private WebElement pleaseWait;

    public ClientAddPhotoPage(WebDriver driver) {
        super(driver);
    }

        public void go_to_photo_add_page(String clientname) throws IOException, InterruptedException {
        element(serchtext).type(clientname);
        element(searchbutton).click();
        element(pleaseWait).waitUntilNotVisible();
        element(clientlink).click();
        element(facilitylink).click();
        element(photopagelink).click();
        element(linksection).click();
        Thread.sleep(6000);
        element(tabphoto).click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\TectaHelpFiles\\OpenFile.exe");
        Thread.sleep(150000);
        element(saveclick).click();
        element(saveclick).waitUntilVisible();

        }
}
