package spider;

import constant.Constant;
import entity.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import persistent.Persistent;
import queue.Queue;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by tusizi on 2016/11/27.
 */
public class ArticleSpider {
    private String url;

    public ArticleSpider(String url) {
        this.url = url;
    }

    public void run(){
        try {
            CopyOnWriteArraySet<String> ids = Queue.getIds();
            Document doc = Jsoup.connect(url).timeout(5000).get();
            if(url.startsWith(Constant.PREFIX)){
                Elements h1 = doc.getElementsByTag("h1");
                String title = h1.text();
                Elements post_text = doc.getElementsByClass("post_text");
                String content = post_text.text();
                Article article = new Article();
                article.setTitle(title);
                article.setContent(content);
                Persistent.persist(article);
            }
            Elements aList = doc.getElementsByTag("a");
            for(Element a:aList){
                String href = a.attr("href");
                if (href!=null && !ids.contains(href) && href.startsWith(Constant.PREFIX)){
                    //System.out.println(href);
                    ArticleSpider articleSpider = new ArticleSpider(href);
                    articleSpider.run();
                    ids.add(href);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
