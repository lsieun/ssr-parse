package lsieun.ssr;

import lsieun.utils.Base64;

public class C_Base64 {
    public static void main(String[] args) {
        String str = "base64_String";
        String result = Base64.decode(str);
        System.out.println(result);
    }
}
