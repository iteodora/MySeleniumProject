package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadiobuttonTest {
    WebDriver driver;
    String url="https://demoqa.com/radio-button";

    @BeforeTest
    public void setUp(){
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement consentButton= driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]/p"));
        consentButton.click();
    }

    @Test
    public void yesRadioButton(){

        WebElement yesButton= driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesButton.click();
        WebElement textMessage=driver.findElement(By.className("text-success"));
        Assert.assertTrue(textMessage.isDisplayed());
        String yesMessage="Yes";
        Assert.assertTrue(textMessage.getText().contains(yesMessage));
    }

    @Test
    public void impressiveRadioButton(){
        WebElement impressiveButton= driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveButton.click();
        WebElement textMessage=driver.findElement(By.className("text-success"));
        Assert.assertTrue(textMessage.isDisplayed());
        String impressiveMessage="Impressive";
        Assert.assertTrue(textMessage.getText().contains(impressiveMessage));
    }

    @Test
    public void noRadioButton(){
        WebElement noButton= driver.findElement(By.xpath("//label[@for='noRadio']"));
        noButton.click();
        Assert.assertFalse(noButton.isSelected());
        /*WebElement textMessage=driver.findElement(By.className("text-success"));
        Assert.assertTrue(textMessage.isDisplayed());
        String noMessage="No";
        Assert.assertTrue(textMessage.getText().contains(noMessage));*/
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }
}
