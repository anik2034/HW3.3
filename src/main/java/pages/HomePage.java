package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static locators.HomePageLocators.searchBarCSS;
import static locators.HomePageLocators.searchButtonCSS;

public class HomePage extends BasePage{

    private By searchBar = By.cssSelector(searchBarCSS);
    private By searchButton = By.cssSelector(searchButtonCSS);
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void setSearchString(String search){
        type(searchBar, search);
    }
    public void clickSearchButton(){
        click(searchButton);
    }


    public SearchResultsPage goSearchResultsPage(String search){
        setSearchString(search);
        clickSearchButton();
        return new SearchResultsPage(driver);

    }


}
