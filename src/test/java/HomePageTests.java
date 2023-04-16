import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.ItemPage;
import pages.SearchResultsPage;

public class HomePageTests extends  BaseTest{


    //all pages are used here
    @Test
    public void SearchAndAddToCart(){
        SoftAssert sa = new SoftAssert();
        SearchResultsPage results = homePage.goSearchResultsPage("It Ends with Us");
       ItemPage item=  results.goItemPage();
       CartPage cart = item.goCartPage();
        sa.assertTrue(cart.hasAdded("It Ends with Us"), AssertionMessage.added);
        sa.assertAll();
    }









}
