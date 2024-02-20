package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/login";
    @Parameters({"browserP"})
    @BeforeTest
    public void setUp(String browser){
        //1. deschide pagina Form Authentification
        System.out.println("Deschide pagina Form Authentification");
        //driver = new ChromeDriver(); //clasa chrome driver mosteneste web driver -> putem face obiect de tip WebDriver si sa specificam ca e de tip ChromeDriver
        switch(browser){
            case "chrome":driver=new ChromeDriver();break;
            case "edge":driver=new EdgeDriver();break;
            case "firefox":driver=new FirefoxDriver();break;
            default:driver=new ChromeDriver();break;
        }

        driver.get(url); //deschide o pagina

        driver.manage().window().maximize();
        System.out.println("Asteapta 3 secunde"); //cate secunde sa stea pana la urmatoarea comanda?
        sleep(2000);
    }
    @Parameters({"usernameP", "passwordP","successMessageP"})
    @Test (testName = "LoginTest")

public void login(String username, String password, String message) {

        //2. click username & enter user: tomsmith
        System.out.println("Enter username");
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);
        sleep(2000);

        //3. click password & enter "SuperSecretPassword!"
        System.out.println("Enter password");
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
        sleep(2000);

        //4. click login button
        System.out.println("Click login button");
        WebElement loginButton = driver.findElement(By.className("radius"));
        //WebElement loginButton= driver.findElement(By.xpath(???));
        loginButton.click();
        sleep(2000);

        //Expected results: "Welcome to the Secure Area" is displayed
        System.out.println("Verificam continutul subheader-ului");
        WebElement secureAreaSubheader = driver.findElement(By.className("subheader"));
        String subheaderContent = "Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertTrue(secureAreaSubheader.isDisplayed());
        Assert.assertEquals(subheaderContent, secureAreaSubheader.getText());

        String secureUrl = "https://the-internet.herokuapp.com/secure";
        driver.getCurrentUrl(); //returneaza pagina pe care suntem
        Assert.assertEquals(driver.getCurrentUrl(), secureUrl);

        WebElement successMessage = driver.findElement(By.id("flash"));
        //String successMessageContent = "You logged into a secure area!";
        Assert.assertTrue(successMessage.getText().contains(message));
    }

    @AfterTest(alwaysRun = true)// daca punem alwaysRun=true atunci va rula indiferent daca testul trece sau pica
    public void tearDown(){
        //Inchide pagina
        System.out.println("Inchide pagina Form Authentification");
        driver.close(); //in selenium sunt 2 metode de browser close (inchide pagina curenta) si quit (inchide toate tab-urile din browser)
    }

    public static void sleep(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
