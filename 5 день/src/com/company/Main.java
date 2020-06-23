package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args){
        //login and password for site
        String mail = "fill in your mail here";
        String password = "fill in your password here";
        String testURL = "https://test.uxcrowd.ru/";

        //open Chrome and visit site
        String exePath = "fill in your path to chromdriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",exePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(testURL);

        //find and click enter button
        WebElement enterButton = driver.findElement(By.xpath("//*[@id=\"header-lk-button\"]"));
        enterButton.click();

        //wait until login box appears
        int secondsToWait = 2;
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name=\"login\"]")));

        //fill in login
        WebElement loginField = driver.findElement(By.xpath("//input[@name=\"login\"]"));
        loginField.sendKeys(mail);

        //fill in password
        WebElement passwordField = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        passwordField.sendKeys(password);

        //find and click password button
        WebElement enterButtonFloat = driver.findElement(By.xpath("//*[contains(@class, \"lk-enter-btn\")]"));
        enterButtonFloat.click();

        //wait for log in
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'slide-header welcome-h')]")));

        //check whether appeared welcome message
        WebElement welcomElem = driver.findElement(By.xpath("//*[contains(@class, 'slide-header welcome-h')]"));
        String welcomText = welcomElem.getText();
        String realWelcomeText = "ДОБРЫЙ ДЕНЬ!";
        assert welcomText.equals(realWelcomeText): "can not log in";

        //quit
        driver.close();
        driver.quit();
    }
}

