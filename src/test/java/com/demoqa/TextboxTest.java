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

public class TextboxTest {
    WebDriver driver;
    String url="https://demoqa.com/text-box";
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
    public void fillInForm(){
        WebElement fullName= driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Ion Popescu");
        WebElement userEmail=driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmail.sendKeys("ion.popescu@test.com");
        WebElement crAddress= driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        crAddress.sendKeys("123 Street, X Town");
        WebElement permAddress=driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permAddress.sendKeys("987 Street, Y Town");
        WebElement submitButton=driver.findElement(By.xpath("//*[@id='submit']"));
        WebElement scrollPoint=driver.findElement(By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']/div[@class='row']/div[1]/div[1]/div[1]/div[2]/span[1]/div[1]"));
        new Actions(driver)
                .scrollToElement(scrollPoint)
                .perform();
        submitButton.click();
        WebElement name=driver.findElement(By.xpath("//*[@id='name']"));
        String nume="Ion Popescu";
        Assert.assertTrue(name.getText().contains(nume));
        WebElement email=driver.findElement(By.xpath("//*[@id='email']"));
       String mail="ion.popescu@test.com";
        Assert.assertTrue(email.getText().contains(mail));
        WebElement crAd=driver.findElement(By.cssSelector("p#currentAddress"));
        String adresaC="123 Street, X Town";
        Assert.assertTrue(crAd.getText().contains(adresaC));
        WebElement prmAd=driver.findElement(By.cssSelector("p#permanentAddress"));
        String adresaP="987 Street, Y Town";
        Assert.assertTrue(prmAd.getText().contains(adresaP));
    }


    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }
}
