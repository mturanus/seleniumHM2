package Utils;

import org.openqa.selenium.WebElement;

public class BrowserUtils {

    public static String getText(WebElement element){
        return element.getText().trim();
    }
}
