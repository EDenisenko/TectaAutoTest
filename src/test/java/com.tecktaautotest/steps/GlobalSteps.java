package com.tecktaautotest.steps;

import com.tecktaautotest.pages.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.awt.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 06.11.12
 * Time: 17:31
 * To change this template use File | Settings | File Templates.
 */
public class GlobalSteps extends ScenarioSteps {
        public GlobalSteps(Pages pages) {
        super(pages);

    }
    public HomePage onHomePage() {
        return getPages().currentPageAt(HomePage.class);
    }
    public ClientsPage onClientsPage (){
        return getPages().currentPageAt(ClientsPage.class);
    }
    public UserPage onUserPage(){
        return getPages().currentPageAt(UserPage.class);
    }
    public ClientAddPhotoPage onClientAddPhotoPage(){
        return getPages().currentPageAt(ClientAddPhotoPage.class);
    }
    public OUPage onUOPage(){
        return getPages().currentPageAt(OUPage.class);
    }

    public ClientPage onClientPage(){
        return getPages().currentPageAt(ClientPage.class);

    }

    @Step
    public void is_the_home_page() {
           onHomePage().open();
    }

    @Step
    public void login(String username, String password) {
        onHomePage().login(username,password);

    }

    @Step
    public void select_filter_ou(String filtertext) {
        onClientsPage().select_ou_filter(filtertext);
    }

    @Step
    public void assert_filtration_ou_parameter(String ouName) {
        onClientsPage().assert_filtration_ou_parameter(ouName);
    }

    @Step
    public void go_to_projects_page() {
        onUserPage().go_to_project_page();
    }

    @Step
    public void select_filter_date(String firstdate, String lastdate) {
        onUserPage().select_first_last_date(firstdate,lastdate);
    }

    @Step
    public void select_filter_facility(String facilityname) {
        onUserPage().select_facility_filter(facilityname);
    }

    @Step
    public void go_to_add_photo_page(String clientname) throws AWTException, IOException, InterruptedException {
        onClientAddPhotoPage().go_to_photo_add_page(clientname);
    }

    @Step
    public void go_to_add_ou_page(String OuTestName, String OuNameRegion, String OuAddres, String OuCity, String OuState, String OuZipCode) {
        onUOPage().go_to_ou_add_page(OuTestName, OuNameRegion, OuAddres, OuCity, OuState, OuZipCode);
    }

    @Step
    public void go_to_client_page(String ClientTestName, String OUTestName, String ClientTestAdress, String ClientTestCity, String ClientTestState, String ClientTestZipCode) {
        onClientPage().go_client_add_page(ClientTestName, OUTestName, ClientTestAdress, ClientTestCity, ClientTestState, ClientTestZipCode);
    }

    public void add_facility_to_new_test_client(String ClientName) {
        onClientPage().add_new_facility_to_new_client(ClientName);
    }
}
