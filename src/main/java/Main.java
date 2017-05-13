import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karol on 12.05.2017.
 */

public class Main {
    public static void main(String[] args){
        getArticlesHeadLines();
    }

    private static void getArticlesHeadLines() {
        try {
            Document document = Jsoup.connect("http://sayard.c0.pl/").get();
            Elements elements = document.getElementsByClass("post-title");
            List<String> titles = new ArrayList<String>();
            for(Element element : elements){
                titles.add(element.text());
            }

            Document linkDocument = Jsoup.parse(elements.html());
            Elements linkElements = linkDocument.getElementsByTag("a");
            List<String> links = new ArrayList<String>();
            for(Element linkElement : linkElements){
                links.add(linkElement.attr("href"));
            }

            DataSaver.writeToFile("E:\\", titles, links);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
