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
public class TestCase5 {

    @Test
    public void sushiTestCase5() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");

        List<WebElement> allItems = driver.findElements(By.xpath("//span[@class ='price']"));

        double price = 25;

        for(WebElement allItem: allItems){
            if(allItem.getText().startsWith("$")){
                double actualPrice=Double.parseDouble(BrowserUtils.getText(allItem).replace("$",""));
                Assert.assertTrue(actualPrice<price);
            }else{
                Assert.fail("The price is not starting with $ sign");
            }
        }

    }

}
