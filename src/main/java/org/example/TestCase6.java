package org.example;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class TestCase6 {

    @Test

    public void sushiTestCase6() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        Thread.sleep(800);

        WebElement tekka=driver.findElement(By.xpath("//li[.//strong[text()='Tekka maki']]//button"));
        Thread.sleep(800);

        WebElement ebi=driver.findElement(By.xpath("//li[.//strong[text()='Ebi rolls']]//button"));

        tekka.click();
        ebi.click();

        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));

        checkoutButton.click();

        WebElement totalPrice = driver.findElement(By.xpath("//span[@data-bind='text: totalPrice']"));

        String actualTotal = BrowserUtils.getText(totalPrice);

        String expectedTotal = "$14.00";

        Assert.assertEquals(actualTotal,expectedTotal);

        WebElement increaseButton= driver.findElement(By.xpath("(//button[@title='Increase value'])[2]"));

        increaseButton.click();

        Thread.sleep(1000);
        WebElement totalToPay = driver.findElement(By.xpath("//span[@data-bind='text: totalPrice']"));
        totalToPay.click();
        WebElement finalPrice = driver.findElement(By.cssSelector("#total-checkout"));

        String actualFinalPrice = BrowserUtils.getText(finalPrice);

        String expectedFinalPrice = "TOTAL:$22.00";

        Assert.assertEquals(actualFinalPrice,expectedFinalPrice);

        WebElement orderNow = driver.findElement(By.xpath("//button[@class='order-now']"));

        orderNow.click();

        WebElement cartTotal = driver.findElement(By.cssSelector("#cart-info"));

        String actualTotalFinal = BrowserUtils.getText(cartTotal);

        String expectedTotalFinal = "SHOPPING CART0 ITEMS";

        Assert.assertEquals(actualTotalFinal,expectedTotalFinal);

    }

}
