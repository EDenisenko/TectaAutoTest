package com.tecktaautotest;

import com.tecktaautotest.requirements.Application;
import com.tecktaautotest.steps.GlobalSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 06.11.12
 * Time: 17:29
 * To change this template use File | Settings | File Templates.
 */
@Story(Application.Filtrations.FacilityPage.class)
@RunWith(ThucydidesRunner.class)

public class FilterTest {
    @Managed
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://ttstaging.tectaamerica.com")
    public Pages pages;

    @net.thucydides.core.annotations.Steps
    public GlobalSteps globalSteps;

    @Test
    public void As_Admin_Check_OU_Filter_On_Clients_Page() throws InterruptedException {
        //given
        globalSteps.is_the_home_page();
        globalSteps.login("tester","testthis");
        //when
        globalSteps.select_filter_ou("Tecta America Corp.");

        //then
        globalSteps.assert_filtration_ou_parameter("Tecta America Corp.");
    }

    @Test
    @Pending
    public void As_User_Check_Date_Filter_On_User_Page() throws InterruptedException {
        //given
        globalSteps.is_the_home_page();
        globalSteps.login("portfoliotestuser","111213");
        globalSteps.go_to_projects_page();
        //when
        globalSteps.select_filter_date("05/07/2008","22/09/2010");
        //Thread.sleep(60000);
        //then
    }

    @Test
    @Pending
    public void As_User_Check_Facility_Filter_On_User_Page(){
        //given
        globalSteps.is_the_home_page();
        globalSteps.login("portfoliotestuser","111213");
        globalSteps.go_to_projects_page();
        //when
        globalSteps.select_filter_facility("100 East Pratt Street");
        //then
    }
    @Test
    public void Add_Photo_To_Project() throws IOException, AWTException, InterruptedException {
        //given
        globalSteps.is_the_home_page();
        globalSteps.login("tester","testthis");
        globalSteps.go_to_add_photo_page("Coca-Cola");
        //Thread.sleep(150000);
        //when
        //then
    }

    @Test
    public void Creat_Client_Test() throws InterruptedException {
        globalSteps.is_the_home_page();
        globalSteps.login("tester","testthis");
        globalSteps.go_to_add_ou_page("My Tecta OPG Unit Test", "Central Plains", "600 S Riverfront Drive", "Mankato", "Minnesota", "56001");
        globalSteps.go_to_client_page();
        Thread.sleep(5000);
    }
}
