import java.util.*;

class Solution {
    LinkedList<String> dir_path = new LinkedList<>();

    public String simplifyPath(String path) {
        String[] tokens = path.split("/");

        for (String token : tokens) {
            parseToken(token);
        }

        return buildPath();
    }

    private void parseToken(String identifier) {
        if (identifier.isEmpty() || identifier.equals(".")) {
            return;
        } else if (identifier.equals("..")) {
            if (!dir_path.isEmpty()) {
                dir_path.removeLast();
            }
        } else {
            dir_path.addLast(identifier);
        }
    }

    private String buildPath() {
        StringBuilder sb = new StringBuilder();

        while(!dir_path.isEmpty()) {
            String identifier = dir_path.removeFirst();
            sb.append("/").append(identifier);
        }

        if (sb.length() == 0) {
            sb.append("/");
        }

        return sb.toString();
    }
}