package com.qa.bank.test;

import com.qa.bank.pages.BankLoginPage;
import com.qa.bank.pages.BankManagerPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class BankManagerTest extends TestBase{
    @Parameters({"firstName", "lastName", "postCode", "expectedMessage"})
    @Test
    public void validateAddCustomerFunctionalityTestParameter(String firstName, String lastName,
                                                              String postCode, String expectedMessage){
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.bankManagerLoginButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomer(driver,firstName, lastName, postCode,
                expectedMessage);

    }

    @Test
    public void validateAddCustomerFunctionalityTest(){
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.bankManagerLoginButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomer(driver,"Axel", "Gomez", "60016",
                "Customer added successfully with customer id :6");

    }

    @Test
    public void validateOpenAccountFunctionality(){
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.bankManagerLoginButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomer(driver,"Axel", "Gomez", "60016",
                "Customer added successfully with customer id :6");

        bankManagerPage.openAccount(driver,"Axel Gomez",
                "Dollar", "Account created successfully");

    }

    @Test
    public void validateCustomersFunctionality(){
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.bankManagerLoginButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomer(driver,"Axel", "Gomez", "60016",
                "Customer added successfully with customer id :6");

        bankManagerPage.openAccount(driver,"Axel Gomez",
                "Dollar", "Account created successfully");

        bankManagerPage.customers("Axel", "Axel",
                "Gomez", "60016", "true");
    }
}
