package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxTest {
    WebDriver driver;
    String url="https://demoqa.com/checkbox";

    @BeforeTest()
        public void setUp(){
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    WebElement consentButton= driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]/p"));
    consentButton.click();}

    @Test
    public void check() {
        WebElement checkboxButton = driver.findElement(By.xpath("//span[@class='rct-checkbox']"));
        checkboxButton.click();
        WebElement successMessage = driver.findElement(By.id("result"));
        Assert.assertTrue(successMessage.isDisplayed());}

    @Test
    public void uncheck(){
        WebElement checkboxButton=driver.findElement(By.cssSelector(".body-height"));
        if(checkboxButton.isSelected()){
            checkboxButton.click();}
        else
        Assert.assertFalse(checkboxButton.isSelected());}

    @AfterTest(alwaysRun = true)
            public void tearDown(){
    driver.close();}}




