package com.pflb.learning.config.pages;

import com.pflb.learning.config.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {
    @FindBy(xpath = "//*[@id=\"header-lk-button\"]")
    WebElement enterButton;

    public StartPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickEnterButton(){
        enterButton.click();
        int secondsToWait = 2;
        WebDriverWait wait = new WebDriverWait( DriverManager.getDriver(), secondsToWait);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name=\"login\"]")));

    }
}
