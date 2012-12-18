package com.tecktaautotest.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.lang.reflect.Array;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 06.11.12
 * Time: 18:38
 * To change this template use File | Settings | File Templates.
 */
public class ClientsPage extends PageObject {

    @FindBy(name = "tou_name")
    private WebElement dropdownMenuOuFilter;

    @FindBy (xpath = "//ul[@class = 'drop-down-menu filter-drop-down-menu tou-grid-filter']")
    private WebElement dropdownMenu;

    @FindBy(id = "please-wait")
    private WebElement pleaseWait;


    public ClientsPage(WebDriver driver) {
        super(driver);
    }

    public void select_ou_filter(String filtertext) {
        Locatable hoverItem = (Locatable) dropdownMenuOuFilter;
        Mouse mouse = ((HasInputDevices) getDriver()).getMouse();
        mouse.click(hoverItem.getCoordinates());
        element(dropdownMenu).waitUntilVisible();
        getDriver().findElement(By.xpath("//a[contains(text(),\""+filtertext+"\")]")).click();
        element(pleaseWait).waitUntilNotVisible();
    }

    public void assert_filtration_ou_parameter(String ouName) {
        for (WebElement i : getDriver().findElements(By.xpath("//tr/td[7]"))) {
            assertThat(i.getText(), is(ouName));
        }
    }


}
