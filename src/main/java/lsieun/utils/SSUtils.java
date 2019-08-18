package lsieun.utils;

import java.util.HashMap;
import java.util.Map;

public class SSUtils {
    public static Map<String, String> parse(final String ssr) {
        if (ssr == null || !ssr.startsWith("ss://")) {
            return null;
        }

        String encoded_str = ssr.trim().replace("ss://", "").replace('-','+').replace('_','/');
        String decoded_str = Base64.decode(encoded_str);
        System.out.println(decoded_str);

        String[] array = decoded_str.split("@");
        String first_part = array[0];
        String second_part = array[1];
        String[] first_part_array = first_part.split(":");
        String[] second_part_array = second_part.split(":");
        Map<String, String> map = new HashMap<>();
        map.put("method", first_part_array[0]);
        map.put("password", first_part_array[1]);
        map.put("server", second_part_array[0]);
        map.put("port", second_part_array[1]);

        return map;
    }


}
