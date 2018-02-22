package pl.rafalmol.recruitment.pricecomparison;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.stereotype.Service;

@Service
public class ApressBookLookup {

    private WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);

    String getPriceByISBN(String isbn) {
        HtmlPage page = null;

        try {
            page = (HtmlPage) webClient.getPage("https://www.apress.com/us/book/"+isbn);
            HtmlElement bookPrceDiv = page.getFirstByXPath("//*[@id=\"content\"]/div[2]/div[2]/div[1]/div/dl/dt[2]/span[2]/span");
            String bookPrice = bookPrceDiv.asText();
            return bookPrice;
        } catch (Exception e) {
        }
        return "Price is unavailable";
    }
}
