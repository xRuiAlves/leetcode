import java.util.HashMap;
import java.util.Map;

public class Day15 {
    private static final Map<String, String> encodings = new HashMap<>();
    private static final String TINYURL_PREFIX = "http://tinyurl.com/";
    private static int ENCODE_COUNT = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = TINYURL_PREFIX + ENCODE_COUNT++;
        encodings.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return encodings.get(shortUrl);
    }
}
