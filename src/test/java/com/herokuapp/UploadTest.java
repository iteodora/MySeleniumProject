package com.herokuapp;

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
    String url="https://the-internet.herokuapp.com/upload";
    @BeforeTest
    public void setUP(){
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();}

    @Test
    public void uploadTest(){
        WebElement fileUpload= driver.findElement(By.id("file-upload"));
        fileUpload.click();
        Actions actions=new Actions(driver);
        //actions.sendKeys(fileUpload,"C:\\Users\\Dell\\IdeaProjects\\MySeleniumProject\\src\\test\\resources\\test.txt").perform();
        fileUpload.sendKeys("C:\\Users\\Dell\\IdeaProjects\\MySeleniumProject\\src\\test\\resources\\test.txt");
WebElement fileSubmit=driver.findElement(By.id("file-submit"));
fileSubmit.click();
WebElement message= driver.findElement(By.xpath("//h3"));
String expectedMessage="File Uploaded!";
        Assert.assertTrue(message.getText().contains(expectedMessage));
    }

    @AfterTest(alwaysRun = true)
public void tearDown(){
    driver.close();
    }
}
