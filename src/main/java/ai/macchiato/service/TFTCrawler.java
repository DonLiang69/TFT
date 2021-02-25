package ai.macchiato.service;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TFTCrawler {
    private static final Logger LOGGER = LoggerFactory.getLogger(TFTCrawler.class);

    public String process() {
        LOGGER.info("start processing...");
        String ovImgUrl = null;
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        try {
            HtmlPage page = webClient.getPage("https://euw.leagueoflegends.com/en-gb/news/game-updates/teamfight-tactics-patch-11-4-notes/");
            List<DomNode> overViewImg = page.getByXPath("//a[@class='skins cboxElement']/@href");
            LOGGER.info("---buff/nerf img----");
            ovImgUrl = overViewImg.get(0).getNodeValue();
            LOGGER.info(ovImgUrl);

        } catch (Exception e) {
            LOGGER.info(e.getMessage(), e);
        }
        return ovImgUrl;
    }

    public static void main(String[] args) {
        LOGGER.info("hi");
    }
}
