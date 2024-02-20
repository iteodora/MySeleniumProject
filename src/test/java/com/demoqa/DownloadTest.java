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

import java.io.IOException;

public class DownloadTest {
    WebDriver driver;
    String url="https://demoqa.com/upload-download";
    @BeforeTest
    public void setUP(){
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement consentButton= driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]/p"));
        consentButton.click();}
/*
    @Test
    public void uploadTest(){
        // Locate the download link and get its "href" attribute value
        WebElement downloadLink = driver.findElement(By.id("downloadButton"));
        downloadUrl = downloadLink.getAttribute("href");
    }

    @Test
    public void testDownload() throws IOException, InterruptedException {
        // Use wget to download the file and save it in the "downloads" directory
        String wgetCommand = "wget -P ./downloads/ " + downloadUrl;
        Process process = Runtime.getRuntime().exec(wgetCommand);
        process.waitFor();

        // Check that the file has been downloaded successfully
        String downloadedFileName = "sampleFile.jpeg";
        String downloadedFilePath = "./downloads/" + downloadedFileName;
        softAssert.assertTrue(checkFileExists(downloadedFilePath),
                "The downloaded file " + downloadedFilePath + " does not exist.");

        softAssert.assertAll();
    }
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }*/
}
