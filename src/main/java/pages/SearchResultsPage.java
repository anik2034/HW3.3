package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static locators.SearchResultPageLocators.*;


public class SearchResultsPage extends BasePage {

    private By firstResult = By.cssSelector(firstResultCSS);
    private By searchedName = By.className(searchedClass);
    private By pechenii = By.xpath(pecheni);
    private By author = By.cssSelector(authorCSS);


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    public String getAuthor(){
        return getText(author);
    }

    public String getSearchedName() {
        return getText(searchedName);
    }

    public void clickFirstResult() {
        click(firstResult);
    }


    public ItemPage goItemPage() {
        click(pechenii);
        clickFirstResult();
        return new ItemPage(driver);
    }
}