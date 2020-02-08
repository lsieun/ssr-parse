package lsieun.utils;

public class DefaultUtils {
    public static String getFileLocation(String filename) {
        String user_dir = System.getProperty("user.dir");
        String filepath = String.format("%s/target/%s", user_dir, filename);
        return filepath;
    }
}
