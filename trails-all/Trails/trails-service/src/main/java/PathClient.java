import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/28/14
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class PathClient {

    public static void main(String[] args) {

        String url = "E:/trails-home\\working-dir\\vam\\34b44edf-00cb-42b9-9ceb-e7f8016d7248.zip";

        File file = new File(url);
        System.out.println(file.getName());

    }
}
