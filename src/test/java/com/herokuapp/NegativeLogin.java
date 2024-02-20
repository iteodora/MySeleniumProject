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

public class NegativeLogin {
    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/login";
@BeforeTest
public void setUp(){
    driver=new ChromeDriver();
    //WebDriver driver=new EdgeDriver();
    driver.get(url);
    driver.manage().window().maximize();
}
    @Parameters({"usernameP","passwordP","errorP"})
    @Test (priority = 1, groups = {"smoke"})
    //cu priority alegem ce test sa ruleze primul, al doilea etc (altfel le execut in ordine alfabetica)
    // grup daca vrem sa ruleze doar anumite teste, un test poate face parte din mai multe grupuri - se poate configura din xml suita de test sa ruleze doar un anumit grup
    public void loginWithInvalidUser(String username,String password, String error){

        WebElement usernameInput= driver.findElement(By.xpath("//input[@type='text']"));
        // locatorii se pun intre " " -> nu se pot pune "" in alte ""-> " ...'...'..."
        // click dr copy-xpath : //*[@id="username"] (inseamna cauta orice element cu id username) (*=orice element)
        // click dr- copy- full xpath: /html/body/div[2]/div/div/form/div[1]/div/input
        // //input[@id='username'] inseamna gaseste un element de tip input care are id-ul username
        // identif elem dupa CSS ex dupaclasa: .numeClasa, dupa id: #id
        usernameInput.sendKeys(username);
        System.out.println("Enter password");
        WebElement passwordInput= driver.findElement(By.cssSelector("#password"));
        passwordInput.sendKeys(password);
        WebElement loginButton= driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();
        WebElement errorMessage=driver.findElement(By.id("flash"));
        String invalidUserMessageContent=error;
        Assert.assertTrue(errorMessage.getText().contains(invalidUserMessageContent));
//        daca am parametrizat metoda nu mai am nevoie de al doilea test pt ca o sa reulez pe primul cu alti parametrii
//        ctrl+slash pt a comenta mai multe randuri de cod?
//        am scris metoda de test intr un mod mai flexibil
    }

    @Test (priority = 2, enabled = false) // enabled=false daca nu vrem sa ruleze testul respectiv
    public void loginWithInvalidPassword(){
        WebElement usernameInput= driver.findElement(By.xpath("//input[@type='text']"));
        usernameInput.sendKeys("tomsmith");
        System.out.println("Enter password");
        WebElement passwordInput= driver.findElement(By.cssSelector("#password"));
        passwordInput.sendKeys("NotSecretPassword!");
        WebElement loginButton= driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();
        WebElement errorMessage=driver.findElement(By.id("flash"));
        String invalidPasswordMessageContent="Your password is invalid!";
        Assert.assertTrue(errorMessage.getText().contains(invalidPasswordMessageContent));
    }
    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }

}
