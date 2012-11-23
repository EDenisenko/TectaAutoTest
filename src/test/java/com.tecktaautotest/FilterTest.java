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

import javax.security.auth.login.LoginContext;
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
    public  String Login = System.getProperty("Login");
    public  String Password = System.getProperty("Password");
    public  String Facility = System.getProperty("Facility");
    //public  String Login = "tester";
    //public  String Password = "testthis";
    //public  String Facility = "coca-cola";

    @Test
    public void As_Admin_Check_Create_Reports() throws InterruptedException, IOException {
        globalSteps.is_the_home_page();
        globalSteps.login(Login,Password);
        globalSteps.go_to_user_report_page_lite_step(Facility);
        globalSteps.check_reports_lite();
    }

    @Test
    public void As_Admin_Check_Creat_Report_Edition() throws IOException, InterruptedException {
        globalSteps.is_the_home_page();
        globalSteps.login(Login,Password);
        globalSteps.go_to_user_report_page_hard_step(Facility);
        globalSteps.check_reports();
    }

    @Test
    public void As_Admin_Check_OU_Filter_On_Clients_Page() throws InterruptedException {
        //given
        globalSteps.is_the_home_page();
        globalSteps.login(Login,Password);
        //when
        globalSteps.select_filter_ou("Tecta America Corp.");

        //then
        globalSteps.assert_filtration_ou_parameter("Tecta America Corp.");
    }

    @Test
    public void As_Adnin_Check_Date_Filter_On_User_Page() throws InterruptedException {
        //given
        globalSteps.is_the_home_page();
        globalSteps.login(Login, Password);
        globalSteps.go_to_projects_page(Facility);
        //when
        globalSteps.select_filter_date();
        //then
        globalSteps.assert_the_date_incorect();
    }

    @Test
    public void As_Admin_Check_Facility_Filter_On_User_Page() throws InterruptedException {
        //given
        globalSteps.is_the_home_page();
        globalSteps.login(Login, Password);
        globalSteps.go_to_projects_page(Facility);
        //when
        globalSteps.Select_Filtyer_Value();
        //then
        globalSteps.Assert_Facility_Filter();
    }

    @Test
    public void As_Admin_Check_Progect_Type_Filter_On_User_Page(){
        globalSteps.is_the_home_page();
        globalSteps.login(Login,Password);
        globalSteps.go_to_projects_page(Facility);
        globalSteps.select_progect_type_value();
        globalSteps.assert_select_project_type_value();
    }

    @Test
    public void As_Admin_Check_Project_Type_And_Facility_Filter_On_User_Page(){
        globalSteps.is_the_home_page();
        globalSteps.login(Login,Password);
        globalSteps.go_to_projects_page(Facility);
        globalSteps.select_project_type_and_facility_filter();
        globalSteps.assert_project_type_and_facility_filter();
    }

    @Test
    public void Add_Photo_To_Project() throws IOException, AWTException, InterruptedException {
        //given
        globalSteps.is_the_home_page();
        globalSteps.login(Login, Password);
        globalSteps.go_to_add_photo_page(Facility);
        //when
        //then
    }

    @Test
    @Pending
    public void Creat_Client_Test_OU() throws InterruptedException {
        //given
        globalSteps.is_the_home_page();
        globalSteps.login("tester","testthis");
        //when
        globalSteps.go_to_add_ou_page("My Tecta OPG Unit Test", "Central Plains", "600 S Riverfront Drive", "Mankato", "Minnesota", "56001");
    }

    @Test
    @Pending
    public void Create_New_Client_Test(){
        globalSteps.is_the_home_page();
        globalSteps.login("tester","testthis");
        globalSteps.go_to_client_page("My Test Client","My Tecta OPG Unit Test", "600 S Riverfront Drive", "Mankato", "Minnesota", "56001");
        globalSteps.add_facility_to_new_test_client("My Test Client");
    }
}
