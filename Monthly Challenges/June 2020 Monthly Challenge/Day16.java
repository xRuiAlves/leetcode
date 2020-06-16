import java.util.regex.Pattern;

public class Day16 {
    private static final String IPV4_TOKEN = "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";
    private static final String IPV6_TOKEN = "([0-9a-fA-F]{1,4})";

    private static final Pattern IPV4_PATTERN = Pattern.compile(String.format(
            "^%s(\\.%s){3}$", IPV4_TOKEN, IPV4_TOKEN
    ));
    
    private static final Pattern IPV6_PATTERN = Pattern.compile(String.format(
            "^%s(\\:%s){7}$", IPV6_TOKEN, IPV6_TOKEN
    ));

    public String validIPAddress(String IP) {
        if (IPV4_PATTERN.matcher(IP).matches()) {
            return "IPv4";
        } else if (IPV6_PATTERN.matcher(IP).matches()) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }
}
