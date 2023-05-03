package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static locators.ItemPageLocators.*;


public class ItemPage extends BasePage{

    private By addToCartButton = By.xpath(addToCartxpath);
    private By viewCartButton = By.id(viewCartID);
    private By hardCoverButton = By.xpath(hardcoverxpath);
    private By itemBigPrice = By.cssSelector(bigPrice);
    private By itemSmallPrice = By.xpath(smallPricexpath);
    private By author = By.xpath(authorxpath);
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public String getAuthor(){
        scrollBy(driver, 0, 100);
        return getText(author);
    }

    public void clickAddToCartButton(){
        click(addToCartButton);
    }

    public String getBigPrice(){
        scrollBy(driver, 0, 300);
      return  getText(itemBigPrice);
    }
    public String getSmallPrice(){
        return  getText(itemSmallPrice);
    }

    public void clickHardcover(){

        click(hardCoverButton);
    }

    public void clickViewCartButton(){
        click(viewCartButton);
    }

    public CartPage goCartPage(){
        scrollBy(driver, 0, 700);
        clickAddToCartButton();
        clickViewCartButton();
        return new CartPage(driver);
    }
}
