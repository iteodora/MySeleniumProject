package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadTest {
    WebDriver driver;
    String url="https://demoqa.com/upload-download";
    @BeforeTest
    public void setUP(){
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    WebElement consentButton= driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]/p"));
    consentButton.click();}

    @Test
    public void uploadTest(){
        WebElement fileUpload= driver.findElement(By.id("uploadFile"));
        Actions actions=new Actions(driver);
        fileUpload.sendKeys("C:\\Users\\Dell\\IdeaProjects\\MySeleniumProject\\src\\test\\resources\\test.txt");
        WebElement message= driver.findElement(By.cssSelector("p#uploadedFilePath"));
        String expectedMessage="C:\\fakepath\\test.txt";
        Assert.assertTrue(message.getText().contains(expectedMessage));
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }
}
