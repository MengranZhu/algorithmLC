package src.facebook;

/*leetcode 535 Encode and Decode TinyURL
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work.
You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
*  solution:
*  use two hashmap to store long to short and short to long
*  use random to generate random number
*  reference String contains 26 + 26 + 10 number
*(62)^6 is enough
*
*
* */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeDecodeURL {

    private Map<String, String> longToShort = new HashMap<>();
    private Map<String, String> shortToLong = new HashMap<>();
    static final String domain = "https://leetcode.com/problems/";
    static final String reference = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    Random random = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) return (domain + longToShort.get(longUrl));

        String sb = null;
        do {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int r = random.nextInt(reference.length());
                temp.append(reference.charAt(r));
            }
            sb = temp.toString();
        } while (shortToLong.containsKey(sb));
        shortToLong.put(sb, longUrl);
        longToShort.put(longUrl, sb);

        return domain + sb;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl.replace(domain, ""));
    }
}
