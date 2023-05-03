import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.ItemPage;
import pages.SearchResultsPage;

public class CartPageTests extends BaseTest{

    @Test
    public void correctPrice(){

        SoftAssert sa = new SoftAssert();
        SearchResultsPage results = homePage.goSearchResultsPage("The Cruel Prince");
        ItemPage item=  results.goItemPage();

        String p = item.getBigPrice();

        CartPage cart = item.goCartPage();
        String cartPrice = cart.getPrice();
        sa.assertEquals(p,cartPrice, AssertionMessage.correctCartPrice);


        sa.assertAll();
    }

    @Test
    public void correctProductType(){
        SoftAssert sa = new SoftAssert();
        SearchResultsPage results = homePage.goSearchResultsPage("The Women in White");
        ItemPage item=  results.goItemPage();



        CartPage cart = item.goCartPage();
        String productType = cart.getProductType();

        sa.assertEquals(productType, "Paperback", AssertionMessage.correctProductType);
  //      sa.assertNotEquals(productType, "Hardcover", AssertionMessage.incorrectProductType);
        sa.assertAll();
    }


}
