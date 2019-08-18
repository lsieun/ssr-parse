package lsieun.ssr;

import lsieun.utils.ConfigUtils;

public class A_SSR_Single {
    public static void main(String[] args) {
        String ssr = "ssr://MTcyLjEwNC44Ni42MDo4MDk5Om9yaWdpbjphZXMtMjU2LWNmYjpwbGFpbjpaVWxYTUVSdWF6WTVORFUwWlRadVUzZDFjM0IyT1VSdFV6SXdNWFJSTUVRLz9yZW1hcmtzPTVwZWw1cHlzTFZSdmEzbHYmZ3JvdXA9VjFkWExsbFBWVTVGUlVRdVYwbE8=";
        ConfigUtils.write(ssr, "user-config.json");
    }
}
