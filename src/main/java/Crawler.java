import constant.Constant;
import spider.ArticleSpider;

/**
 * Created by tusizi on 2016/11/27.
 */
public class Crawler {
    public static void main(String[] args) {

        ArticleSpider articleSpider = new ArticleSpider(Constant.WEBURL);
        articleSpider.run();
    }
}
