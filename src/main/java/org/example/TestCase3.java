package org.example;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestCase3 {
    @Test
    public void sushiTestCase3() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");

        List<WebElement> addCartButton = driver.findElements(By.xpath("//button[@class='add-to-cart']"));

        addCartButton.get(3).click();

        WebElement cartInfo = driver.findElement(By.xpath("//a[@id='cart-info']"));

        String actualText = BrowserUtils.getText(cartInfo);

        String expectedText = "SHOPPING CART1 ITEMS";

        Assert.assertEquals(actualText, expectedText);

       WebElement priceEdamame=driver.findElement(By.xpath("//strong[text()='Edamame']/following-sibling::span[@class='price']"));

       priceEdamame.getText();

        WebElement emptyCart = driver.findElement(By.cssSelector("#empty-cart"));

        emptyCart.click();

        WebElement cartInfoAfter = driver.findElement(By.cssSelector("#cart-info"));

        String actualInfoAfter = BrowserUtils.getText(cartInfoAfter);

        String expectedInfoAfter = "SHOPPING CART0 ITEMS";

        Assert.assertEquals(actualInfoAfter, expectedInfoAfter, "Cart item failed");

    }


}
