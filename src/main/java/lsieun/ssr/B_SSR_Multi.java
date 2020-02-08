package lsieun.ssr;

import lsieun.utils.ConfigUtils;
import lsieun.utils.DefaultUtils;

public class B_SSR_Multi {
    public static void main(String[] args) {
        String multi_ssr = "";
        String[] ssr_array = multi_ssr.split("\\|");
        for (int i=0; i<ssr_array.length; i++) {
            String filename = String.format("user-config-%03d.json", i);
            String filepath = DefaultUtils.getFileLocation(filename);
            ConfigUtils.write(ssr_array[i], filepath);
        }
    }
}
