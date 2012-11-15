package com.tecktaautotest.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 06.11.12
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */
@DefaultUrl("http://ttstaging.tectaamerica.com")
public class HomePage extends PageObject {

    @FindBy(id = "password" )
    private WebElement inputPassword;

    @FindBy(xpath = "//span/button[@type='submit']")
    private WebElement buttonLogin;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login")
    private WebElement inputUserName;

    public void login(String username, String password) {
        element(inputUserName).type(username);
        element(inputPassword).type(password);
        element(buttonLogin).click();
    }
}
