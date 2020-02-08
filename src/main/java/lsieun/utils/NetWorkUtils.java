package lsieun.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class NetWorkUtils {
    public static byte[] fetch(final String url) {
        try {
            URL u = new URL(url);
            final URLConnection uc = u.openConnection();
            uc.setConnectTimeout(10000);
            uc.setReadTimeout(30000);
            uc.setRequestProperty("user-agent", "Mozilla/5.0");

            uc.connect();
            final Map<String, List<String>> headers = uc.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().toString();
                String line = String.format("%s: %s", key, value);
                System.out.println(line);
            }

            try (
                    final InputStream in = uc.getInputStream();
                    BufferedInputStream bin = new BufferedInputStream(in)
            ) {
                ByteArrayOutputStream bao = new ByteArrayOutputStream();
                byte[] buff = new byte[5 * 1024];
                int len = 0;
                while ((len = bin.read(buff)) != -1) {
                    bao.write(buff, 0, len);
                }
                return bao.toByteArray();
            }

        } catch (MalformedURLException e) {
            System.out.println("Illegal URL: " + url);
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        throw new RuntimeException("Can not fetch: " + url);
    }
}
