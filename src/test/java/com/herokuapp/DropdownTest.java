package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DropdownTest {
    WebDriver driver;
    String url="https://the-internet.herokuapp.com/dropdown";

   // @Parameters({"browserP"})
    @BeforeTest
    public void setUp(){
    /*    switch(browser){
            case "chrome":driver=new ChromeDriver();break;
            case "edge":driver=new EdgeDriver();break;
            case "firefox":driver=new FirefoxDriver();break;
            default:driver=new ChromeDriver();break;}*/
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();}

    @Test
    public void selectFromDropDown(){
        WebElement dropdown= driver.findElement(By.id("dropdown"));
        Select dropdownElement= new Select(dropdown); //am facut elementul de tip select

        dropdownElement.selectByValue("1");
        WebElement option1=driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]"));
        Assert.assertTrue(option1.isSelected());

        dropdownElement.selectByVisibleText("Option 2");
        WebElement option2=driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]"));
        Assert.assertTrue(option2.isSelected());
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.close();}

}
