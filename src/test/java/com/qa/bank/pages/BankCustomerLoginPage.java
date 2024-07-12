package com.qa.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;


public class BankCustomerLoginPage {

    public BankCustomerLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#userSelect")
    WebElement customerSelect;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement depositButton;
    @FindBy(xpath = "//input[@type='number']")
    WebElement amount;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositClickButton;
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement withdrawButton;
    @FindBy(xpath = "//input[@type='number']")
    WebElement amountToBeWithdraw;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement message;
    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement welcomeHeader;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement withDrawClickButton;
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement transactionButton;
    @FindBy(xpath = "//strong[@class='ng-binding'][2]")
    WebElement balance;
    @FindBy(xpath = "//tr[@id='anchor0']//td[@class='ng-binding'][2]")
    WebElement depositTransaction;
    @FindBy(xpath = "//tr[@id='anchor1']//td[@class='ng-binding'][2]")
    WebElement withDrawAmount;


    public void loginAsCustomer(String customerName){
        BrowserUtils.selectBy(customerSelect, customerName, "text" );
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(welcomeHeader), "Welcome " + customerName + " !!");
    }

    public void deposit(String depositAmount, String expectedMessage, String expectedColor){
        depositButton.click();
        amount.sendKeys(depositAmount);
        depositClickButton.click();
        Assert.assertEquals(BrowserUtils.getText(message), expectedMessage);
        Assert.assertEquals(message.getCssValue("color"), expectedColor);
    }

    public void withDraw(String withDrawAmount, String expectedMessage, String expectedColor) throws InterruptedException {
        withdrawButton.click();
        Thread.sleep(2000);
        amount.sendKeys(withDrawAmount);
        withDrawClickButton.click();
        Assert.assertEquals(BrowserUtils.getText(message), expectedMessage );
        Assert.assertEquals(message.getCssValue("color"), expectedColor);

    }

    public void transaction() throws InterruptedException {
        int actualBalance = Integer.parseInt(BrowserUtils.getText(balance));
        Thread.sleep(2000);
        transactionButton.click();
        int transactionBalance = Integer.parseInt(BrowserUtils.getText(depositTransaction))
                - Integer.parseInt(BrowserUtils.getText(withDrawAmount));
        Assert.assertEquals(actualBalance, transactionBalance);
    }
}
