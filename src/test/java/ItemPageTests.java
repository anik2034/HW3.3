import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ItemPage;
import pages.SearchResultsPage;

public class ItemPageTests extends BaseTest {

    @Test
    public void paperbackToHardcoverPrice(){
        SoftAssert sa = new SoftAssert();
        SearchResultsPage results = homePage.goSearchResultsPage("The Cruel Prince");
        ItemPage item=  results.goItemPage();

        String p = item.getBigPrice();
        item.clickHardcover();
        String h1 = item.getBigPrice();
        String h2 = item.getSmallPrice();
        sa.assertTrue(h1.contains(h2), AssertionMessage.correctHardcoverPrice);
        sa.assertFalse(h1.contains(p), AssertionMessage.incorrectHardcoverPrice);
        sa.assertAll();

        



    }

    @Test
    public void compareAuthors(){
        SoftAssert sa = new SoftAssert();
        SearchResultsPage results = homePage.goSearchResultsPage("Lolita");
        String author1 = results.getAuthor();
        ItemPage item=  results.goItemPage();
        String author2 = item.getAuthor();
        sa.assertEquals(author1, author2, AssertionMessage.correctAuthors);
        sa.assertAll();
    }
}
