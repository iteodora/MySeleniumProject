package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxesTest {
    WebDriver driver;
    String url="https://the-internet.herokuapp.com/checkboxes";

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
    public void checkAll() {
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        if(!checkbox1.isSelected())  {
        checkbox1.click();}
        Assert.assertTrue(checkbox1.isSelected());

        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        if(!checkbox2.isSelected()){
        checkbox2.click();}
        Assert.assertTrue(checkbox2.isSelected());
    }

    @Test
    public void uncheckAll(){
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        if(checkbox1.isSelected())  {
            checkbox1.click();}
        Assert.assertFalse(checkbox1.isSelected());

        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        if(checkbox2.isSelected()){
            checkbox2.click();}
        Assert.assertFalse(checkbox2.isSelected());
    }

    @AfterTest (alwaysRun = true)
    public void tearDown(){
        driver.close();
    }

       /* metoda data de blackbox AI
       @Test
       public void checkboxes(){
        // Find the first checkbox element
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));

        // Check the initial state of the checkbox
        if (!checkbox1.isSelected()) {
            // Click on the checkbox to select it
            checkbox1.click();
        }

        // Verify that the checkbox is now selected
        assert checkbox1.isSelected();

        // Find the second checkbox element
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        // Check the initial state of the checkbox
        if (checkbox2.isSelected()) {
            // Click on the checkbox to deselect it
            checkbox2.click();
        }

        // Verify that the checkbox is now deselected
        assert !checkbox2.isSelected();
    } */



}
