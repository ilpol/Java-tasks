package com.pflb.learning;

import com.pflb.learning.config.DriverManager;
import com.pflb.learning.config.pages.LoggedinPage;
import com.pflb.learning.config.pages.LoginPage;
import com.pflb.learning.config.pages.StartPage;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UxCrowdTest {

    @Test
    public void firstTest() {
        DriverManager.getDriver().get("http://test.uxcrowd.ru");
        StartPage startPage = new StartPage();
    }

    @Test
    public void loginTest() {
        InputStream inputStream = DriverManager.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try { properties.load(inputStream); }
        catch (IOException e) { throw new RuntimeException(e);}
        String url = properties.getProperty("url");
        DriverManager.getDriver().get(url);
        DriverManager.getDriver().manage().window().maximize();
        StartPage startPage = new StartPage();
        startPage.clickEnterButton();
        LoginPage loginPage = new LoginPage();
        String login = properties.getProperty("login");
        loginPage.fillLogin(login);
        String password = properties.getProperty("password");
        loginPage.fillPassword(password);
        LoggedinPage loggedinPage = new LoggedinPage();
        String welcomText = loggedinPage.getWelcomeText();
        String realWelcomeText = properties.getProperty("realWelcomeText");
        realWelcomeText = "ДОБРЫЙ ДЕНЬ!";
        assert welcomText.equals(realWelcomeText): "can not log in";
    }


}
