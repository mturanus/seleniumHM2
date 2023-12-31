package org.example;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class TestCase2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");

        WebElement shiromiPicture = driver.findElement(By.xpath("//a[@class='view-details']//img[@title='Shiromi']"));

        Thread.sleep(1000);

        Actions actions = new Actions(driver);

        actions.click(shiromiPicture).perform();

        Thread.sleep(1000);

        WebElement navigateNext = driver.findElement(By.cssSelector("#navigate-next"));

        Thread.sleep(1000);

        navigateNext.click();

        Thread.sleep(1000);

        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Tekka maki')]"));

        String actualHeader = BrowserUtils.getText(header);

        String expectedHeader = "Tekka maki";

        Assert.assertEquals( expectedHeader, actualHeader,"Header text not as expected");

        WebElement navigatePrevious = driver.findElement(By.cssSelector("#navigate-prev"));

        Thread.sleep(1000);

        navigatePrevious.click();

        Thread.sleep(1000);

        WebElement headerShiromi = driver.findElement(By.xpath("//h1[contains(text(),'Shiromi')]"));

        String actualHeaderShiromi = BrowserUtils.getText(headerShiromi);

        String  expectedHeaderShiromi= "Shiromi";

        Assert.assertEquals( expectedHeaderShiromi, actualHeaderShiromi,"Header text not as expected for Shiromi");

        WebElement cartInfo = driver.findElement(By.cssSelector("#cart-info"));

        String actualNumber = BrowserUtils.getText(cartInfo);

        String expectedNumber = "SHOPPING CART0 ITEMS";

        Assert.assertEquals( expectedNumber, actualNumber,"Cart info text not as expected");

        driver.quit();
    }
}
