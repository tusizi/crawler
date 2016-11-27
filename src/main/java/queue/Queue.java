package queue;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by tusizi on 2016/11/27.
 */
public class Queue {
    //²¢·¢Ð´ids
    private static CopyOnWriteArraySet<String> ids =new CopyOnWriteArraySet<String>();
    public static CopyOnWriteArraySet<String> getIds() {
        return ids;
    }
}
