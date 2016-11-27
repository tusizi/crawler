package persistent;

import com.google.gson.Gson;
import entity.Article;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by tusizi on 2016/11/27.
 */
public class Persistent {

    public static void persist(Article article){
        String dir = System.getProperty("user.dir")+File.separator+"data";
        File fileName = new File(dir + File.separator + UUID.randomUUID().toString());
        Gson gson = new Gson();
        String s = gson.toJson(article);
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(s);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
