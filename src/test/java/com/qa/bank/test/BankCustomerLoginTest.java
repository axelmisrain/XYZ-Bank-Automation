package com.qa.bank.test;

import com.qa.bank.pages.BankCustomerLoginPage;
import com.qa.bank.pages.BankLoginPage;
import com.qa.bank.pages.BankManagerPage;
import org.testng.annotations.Test;
import utils.ConfigReader;


public class BankCustomerLoginTest extends TestBase{
    @Test
    public void validateCustomerTransaction() throws InterruptedException {
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.bankManagerLoginButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomer(driver, ConfigReader.readProperty("firstName"),
                                            ConfigReader.readProperty("lastName"),
                                            ConfigReader.readProperty("postCode"),
                                            ConfigReader.readProperty("expectedMessage"));

        bankManagerPage.openAccount(driver,"Axel Gomez",
                "Dollar", "Account created successful");

        bankManagerPage.customers("Axel", "Axel",
                "Gomez", "60016", "true");


        bankLoginPage.homeClickButton();
        bankLoginPage.customerLoginButton();
        BankCustomerLoginPage bankCustomerLoginPage = new BankCustomerLoginPage(driver);
        bankCustomerLoginPage.loginAsCustomer("Axel Gomez");
        bankCustomerLoginPage.deposit("500", "Deposit Successful", "rgba(255, 0, 0, 1)");
        bankCustomerLoginPage.withDraw("300", "Transaction successful","rgba(255, 0, 0, 1)");
        bankCustomerLoginPage.transaction();


    }

}
