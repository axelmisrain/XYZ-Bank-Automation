package com.qa.bank.test;
import com.qa.bank.pages.BankLoginPage;
import org.testng.annotations.Test;

public class BankLoginTest extends TestBase{

    @Test
    public void validateLoginInformation(){
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.loginPageInformation(driver, "XYZ Bank","XYZ Bank",
                "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

}
