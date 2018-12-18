package com.lazerycode.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lazerycode.selenium.DriverBase;

public class SeleniumSimpleIT extends DriverBase {
	
    @Test
    public void googleTitleTest() throws Exception {
    	WebDriver driver = getDriver();

        driver.navigate().to("http://www.google.com");
    
        Assert.assertTrue(driver.getTitle().contains("Google"));
    }
    
    //@Test
    public void googleSearchMilk() throws Exception {
    	WebDriver driver = getDriver();
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10, 100);

        driver.navigate().to("http://www.google.com");
        
        WebElement searchButton = driver.findElement(By.name("btnK"));
    	WebElement textToSearch = driver.findElement(By.name("q"));
    	
    	textToSearch.sendKeys("Milk");
        action.moveToElement(searchButton);
        searchButton.click();
        wait.until(d -> driver.getTitle().toLowerCase().startsWith("Milk".toLowerCase()));
    }

    @Test
    public void petClinic() throws Exception {
        WebDriver driver = getDriver();
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10, 100);

        driver.navigate().to("http://localhost:8081");

        driver.findElement(By.partialLinkText("FIND OWNERS")).click();
        wait.until(d -> d.getCurrentUrl().startsWith("http://localhost:8081/owners/find"));
    }

}
