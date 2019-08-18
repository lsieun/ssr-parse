package lsieun.utils;

import java.util.HashMap;
import java.util.Map;

public class SSRUtils {
    public static Map<String, String> parse(final String ssr) {
        if (ssr == null || !ssr.startsWith("ssr://")) {
            return null;
        }

        String encoded_str = ssr.trim().replace("ssr://", "").replace('-','+').replace('_','/');
        String decoded_str = Base64.decode(encoded_str);
        String[] array = decoded_str.split("/\\?");
        if (array == null || array.length != 2) {
            throw new RuntimeException("array is wrong");
        }

        String first_part = array[0];
        String second_part = array[1];
        System.out.println(first_part);
        System.out.println(second_part);

        Map<String, String> map = new HashMap<>();

        String[] basic_part_array = first_part.split(":");
        map.put("server", basic_part_array[0]);
        map.put("server_port", basic_part_array[1]);
        map.put("protocol", basic_part_array[2]);
        map.put("method", basic_part_array[3]);
        map.put("obfs", basic_part_array[4]);
        map.put("password", Base64.decode(basic_part_array[5]));

        String[] second_part_array = second_part.split("&");
        for(String item : second_part_array) {
            map.put(getKey(item), getValue(item));
        }
        System.out.println(map);


        return map;

    }

    public static String getKey(String str) {
        int index = str.indexOf('=');
        String key = str.substring(0, index);
        return key;
    }

    public static String getValue(String str) {
        int index = str.indexOf('=');
        String value_part = str.substring(index + 1).replace('-','+').replace('_','/');
        String value = Base64.decode(value_part);
        return value;
    }


    public static void main(String[] args) {
        String ssr = "ssr://dXMxLmdnYXBpLm5ldDo1ODg6YXV0aF9hZXMxMjhfc2hhMTpjaGFjaGEyMDpwbGFpbjpRMmh5YjIxbFIwRkZNWE5DWlhOMC8_b2Jmc3BhcmFtPVpERmhPV1E1TVRBMUxtMXBZM0p2YzI5bWRDNWpiMjAmcHJvdG9wYXJhbT1PVEV3TlRwc2MybGxkVzQmcmVtYXJrcz01NzZPNVp1OTZhdVk2WUNmNklxQzU0SzVNUSZncm91cD1RMmh5YjIxbFIwRkZYMVpKVUE";
        parse(ssr);
    }
}
