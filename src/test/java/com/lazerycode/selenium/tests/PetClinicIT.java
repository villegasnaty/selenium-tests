package com.lazerycode.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.lazerycode.selenium.DriverBase;

public class PetClinicIT extends DriverBase {
	
	@Test
    public void petClinicOwners() throws Exception {
        WebDriver driver = getDriver();
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10, 100);

        driver.navigate().to("http://localhost:8081");
        

        driver.findElement(By.partialLinkText("FIND OWNERS")).click();
        driver.findElement(By.linkText("Add Owner")).click();
        driver.findElement(By.id("firstName")).sendKeys("Martin");
		driver.findElement(By.id("lastName")).sendKeys("Torres");
		driver.findElement(By.id("address")).sendKeys("san juan 9");
		driver.findElement(By.id("city")).sendKeys("Cordoba");
		driver.findElement(By.id("telephone")).sendKeys("3516789010");
		
		
		
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.partialLinkText("Find owners")).click();
		driver.findElement(By.id("lastName")).sendKeys("Torres");
		driver.findElement(By.xpath("//button")).click();
	
		wait.until(d -> d.getCurrentUrl().startsWith("http://localhost:8081/owners"));
    }
	
	@Test
    public void petClinicVeterinarians() throws Exception {
        WebDriver driver = getDriver();
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10, 100);

       driver.navigate().to("http://localhost:8081");
       
       driver.findElement(By.partialLinkText("VETERINARIANS")).click();
       
       wait.until(d -> d.getCurrentUrl().startsWith("http://localhost:8081/vets.html"));
       
	}
	
}
