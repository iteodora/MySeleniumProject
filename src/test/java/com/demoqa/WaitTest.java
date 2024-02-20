package com.demoqa;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitTest {
    WebDriver driver;
    String url="https://demoqa.com/alerts";
    @BeforeTest
    public void setUp(){
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
        WebElement consentButton= driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]/p"));
        if(consentButton.isDisplayed()){
            consentButton.click();}
    }

    @Test
    public void waitTest(){
        WebElement clickMe= driver.findElement(By.id("timerAlertButton"));
        clickMe.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(6));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text=alert.getText();
        System.out.println(text);
        alert.accept();
    }

    @Test
    public void confirmBoxTest(){
        WebElement clickMe= driver.findElement(By.id("confirmButton"));
        clickMe.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        WebElement confirmMessage=driver.findElement(By.id("confirmResult"));
        String confirmText="You selected Ok";
        Assert.assertEquals(confirmMessage.getText(),confirmText);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }
}
