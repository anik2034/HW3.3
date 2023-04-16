import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SearchResultsPage;

public class SearchResultsPageTests extends BaseTest {
    @Test
    public void checkFirstSearched(){
        SoftAssert sa = new SoftAssert();
        SearchResultsPage results = homePage.goSearchResultsPage("Anna Karenina");

        String title = results.getSearchedName().trim();

        sa.assertEquals(title.substring(title.indexOf("for")+1),"Anna Karenina", AssertionMessage.validSearchedTerm);
        sa.assertEquals(title.substring(title.indexOf("for")+1),"Idiot", AssertionMessage.invalidSearchedTerm );
        sa.assertAll();

    }
}
