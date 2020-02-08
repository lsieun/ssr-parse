package lsieun.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lsieun.utils.io.FileUtils;

public class ConfigUtils {
    public static void write(String ssr, String filepath) {
        Map<String, String> map = SSRUtils.parse(ssr);
        List<String> lines = ConfigUtils.getConfigLines(map);
        FileUtils.writeLines(filepath, lines);


    }

    public static List<String> getConfigLines(Map<String, String> map) {
        List<String> lines = new ArrayList<>();
        lines.add("{");
        lines.add(String.format("    \"server\": \"%s\",", getMapValue(map, "server", "")));
        lines.add(String.format("    \"server_ipv6\": \"%s\",", getMapValue(map, "server_ipv6", "::")));
        lines.add(String.format("    \"server_port\": %s,", getMapValue(map, "server_port", "0")));
        lines.add(String.format("    \"local_address\": \"%s\",", getMapValue(map, "local_address", "127.0.0.1")));
        lines.add(String.format("    \"local_port\": %s,", getMapValue(map, "local_port", "1080")));
        lines.add("");
        lines.add(String.format("    \"password\": \"%s\",", getMapValue(map, "password", "")));
        lines.add(String.format("    \"method\": \"%s\",", getMapValue(map, "method", "")));
        lines.add(String.format("    \"protocol\": \"%s\",", getMapValue(map, "protocol", "")));
        lines.add(String.format("    \"protocol_param\": \"%s\",", getMapValue(map, "protoparam", "")));
        lines.add(String.format("    \"obfs\": \"%s\",", getMapValue(map, "obfs", "")));
        lines.add(String.format("    \"obfs_param\": \"%s\",", getMapValue(map, "obfsparam", "")));
        lines.add("    \"speed_limit_per_con\": 0,");
        lines.add("    \"speed_limit_per_user\": 0,");
        lines.add("");
        lines.add("    \"additional_ports\" : {},");
        lines.add("    \"additional_ports_only\" : false,");
        lines.add("    \"timeout\": 120,");
        lines.add("    \"udp_timeout\": 60,");
        lines.add("    \"dns_ipv6\": false,");
        lines.add("    \"connect_verbose_info\": 0,");
        lines.add("    \"redirect\": \"\",");
        lines.add("    \"fast_open\": false");
        lines.add("}");
        return lines;
    }

    public static String getMapValue(Map<String, String> map, String key, String defaultValue) {
        String value = map.get(key);
        if (value != null || "".equals(value)) {
            return value;
        }

        return defaultValue;
    }
}
