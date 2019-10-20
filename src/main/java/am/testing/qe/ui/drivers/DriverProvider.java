package am.testing.qe.ui.drivers;

import am.testing.qe.Initializer;
import am.testing.qe.util.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverProvider {

    private static Map<Browser, WebDriver> drivers = new HashMap<>();

    private DriverProvider(){}

    public static WebDriver get(){
        Browser currentBrowser = Initializer.get().getCurrentBrowser();
        WebDriver driver = drivers.get(currentBrowser);
        if(driver != null){
            return driver;
        }
        WebDriver newDriver = new ChromeDriverFactory().create();
        drivers.put(currentBrowser, newDriver);
        return newDriver;
    }

    public static WebDriver get(Browser browser){
        return drivers.getOrDefault(browser, new ChromeDriver());
    }

}
