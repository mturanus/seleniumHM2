package org.example;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase4 {

    @Test //test case 4
    public void validateTotalPrice() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");

        WebElement spicyTunaRoll = driver.findElement(By.xpath("//img[@title='Spicy Tuna rolls']"));

        Actions actions = new Actions(driver);

        actions.click(spicyTunaRoll).perform();

        WebElement addToCartButton = driver.findElement(By.xpath("//button[@class='buy']"));

        actions.doubleClick(addToCartButton).perform();

        Thread.sleep(1000);

        WebElement totalPrice = driver.findElement(By.xpath("//p[@class = 'total-price']"));

        String actualTotalAfter = totalPrice.getText().trim();

        String expectedTotalAfter = "$12.00";

        Assert.assertEquals(actualTotalAfter, expectedTotalAfter);

        WebElement cartInfoAfter = driver.findElement(By.cssSelector("#cart-info"));

        String actualInfoAfter = BrowserUtils.getText(cartInfoAfter);

        String expectedInfoAfter = "SHOPPING CART1 ITEMS";

        Assert.assertEquals(actualInfoAfter, expectedInfoAfter);

        WebElement navigateNext = driver.findElement(By.cssSelector("#navigate-next"));

        Thread.sleep(1000);

        navigateNext.click();

        WebElement addToCart = driver.findElement(By.xpath("//button[@data-bind='click: addToCart']"));

        Thread.sleep(1000);

        addToCart = driver.findElement(By.xpath("//button[@data-bind='click: addToCart']"));

        actions.click(addToCart).perform();

        Thread.sleep(1000);

        WebElement totalPriceFinal = driver.findElement(By.xpath("//p[@class='total-price']"));

        String actualTotalFinal = totalPriceFinal.getText().trim();

        String expectedTotalFinal = "$20.00";

        Assert.assertEquals(actualTotalFinal, expectedTotalFinal);

        WebElement cartInfoAfterFinal = driver.findElement(By.cssSelector("#cart-info"));

        String actualInfoAfterFinal = BrowserUtils.getText(cartInfoAfterFinal);

        String expectedInfoAfterFinal = "SHOPPING CART2 ITEMS";

        Assert.assertEquals(actualInfoAfterFinal, expectedInfoAfterFinal);
        driver.quit();

    }

}
