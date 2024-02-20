package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogoutTest {
    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/login";
    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
@Parameters ({"usernameP","passwordP","messageP"})
    @Test
    public void logout(String username, String password, String message) {

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();

        //WebElement logoutButton=driver.findElement(By.xpath("//*[@id='content']/div/a/i"));
        //WebElement logoutButton=driver.findElement(By.xpath(//*[@class="icon-2x icon-signout"]));
        WebElement logoutButton = driver.findElement(By.partialLinkText("Logout"));
        //WebElement logoutButton= driver.findElement(By.LinkText("Logout"));
        //logout stiu ca e link pt ca e intr-un element de tip <a sau ancore in html
        logoutButton.click();

        WebElement logoutMessage = driver.findElement(By.id("flash"));
        String logoutMessageContent = "You logged out of the secure area!";
        Assert.assertTrue(logoutMessage.getText().contains(message));
    }
@AfterTest (alwaysRun = true)
        public void tearDown(){
        driver.close();
    }

        }

