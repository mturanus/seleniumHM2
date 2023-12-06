package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");

        WebElement addCartButton = driver.findElement(By.xpath("//button[@class = 'add-to-cart']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(addCartButton).perform();

        Thread.sleep(2000);

        String actualColor = addCartButton.getCssValue("background-color");

        String expectedColor = "rgba(214, 0, 65, 1)";

        Assert.assertEquals(actualColor, expectedColor);


    }
}