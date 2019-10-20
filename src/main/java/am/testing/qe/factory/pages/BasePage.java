package am.testing.qe.factory.pages;

import am.testing.qe.ui.drivers.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage<Main extends BasePage<Main>> implements IBasePage<Main> {

    protected WebDriver driver;

    protected BasePage(){
        driver = DriverProvider.get();
    }

    protected final String BASE_URL = "http://igorakintev.ru/";


    protected Main open(String path){
        driver.get(BASE_URL + path);
        PageFactory.initElements(driver, getPage());
        return getPage();
    }

    public Main closeBrowser(){
        driver.close();
        driver.quit();
        return getPage();
    }

    public Main closeCurrentTab(){
        driver.close();
        return getPage();
    }


    @SuppressWarnings("unchecked")
    @Override
    public Main getPage(){
        return ((Main) this);
    }

    public Main init() {
        PageFactory.initElements(driver, this);
        return getPage();
    }

    public Main doNothingDuringThe(int timeout){
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getPage();
    }

    public String getPageTitle(){return driver.getTitle();}
    public String getPageURL(){return driver.getCurrentUrl();}

}
