package com.lazerycode.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.lazerycode.selenium.DriverBase;

public class PetClinicIT extends DriverBase {
	
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
