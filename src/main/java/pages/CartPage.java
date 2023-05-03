package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static locators.CartPageLocators.*;

public class CartPage extends BasePage {
    private By firstResult = By.xpath(firstInCartxpath);
    private By firstResultName = By.xpath(firstInCartNamexpath);
    private By price = By.xpath(pricexpath);
    private By productType = By.xpath(productTypexpath);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductType(){
        scrollBy(driver, 0, 300);
        return getText(productType);
    }

    public String getPrice(){
        return getText(price);
    }
    public boolean hasAdded(String name){
        scrollBy(driver, 0, 300);

       if( isElementDisplayed(firstResult)){
           return getText(firstResultName).contains(name);
       }
       else return false;
    }


}
