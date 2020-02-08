package lsieun.ssr;

import lsieun.utils.Base64;
import lsieun.utils.ConfigUtils;
import lsieun.utils.DefaultUtils;
import lsieun.utils.NetWorkUtils;
import lsieun.utils.io.FileUtils;

import java.util.List;
import java.util.function.Function;

public class D_WriteFile {
    private static final String USER_HOME = System.getProperty("user.home");
    private static final String REMOTE_URL = "https://www.example.com/get_ssr";

    public static void main(String[] args) {
        int target_index = 0;
        String local_base64_file = DefaultUtils.getFileLocation("base64.txt");
        String target_file = USER_HOME + "/Software/Proxy/shadowsocksr/user-config.json";

        Function<Integer, String> parseLocation = num -> DefaultUtils.getFileLocation(getFileName(num));

        // (1) download
        final byte[] bytes = NetWorkUtils.fetch(REMOTE_URL);
        FileUtils.writeBytes(local_base64_file, bytes);

        // (2) parse and save
        final String base64_str = FileUtils.readLines(local_base64_file).get(0);
        String decoded_str = Base64.decode(base64_str);
        String[] ssr_array = decoded_str.split("\\n");
        for (int i = 0; i < ssr_array.length; i++) {
            String filepath = parseLocation.apply(i);
            ConfigUtils.write(ssr_array[i], filepath);
            System.out.println(String.format("file://%s", filepath));
        }

        // (3) write to specific location
        List<String> lines = FileUtils.readLines(parseLocation.apply(target_index));
        FileUtils.writeLines(target_file, lines);
        System.out.println("file://" + target_file);
    }

    public static String getFileName(int index) {
        return String.format("user-config-%03d.json", index);
    }
}
