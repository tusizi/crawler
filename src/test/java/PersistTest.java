import entity.Article;
import persistent.Persistent;

/**
 * Created by tusizi on 2016/11/27.
 */
public class PersistTest {
    public static void main(String[] args) {
        Persistent.persist(new Article());
    }
}
