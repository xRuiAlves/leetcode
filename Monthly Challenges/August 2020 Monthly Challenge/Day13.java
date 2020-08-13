public class Day13 {
    private final int length;
    private final String string;
    private final boolean[] used;
    private boolean first = true;

    public CombinationIterator(String characters, int combinationLength) {
        this.string = characters;
        this.length = combinationLength;
        this.used = new boolean[characters.length()];
    }

    public String next() {
        if (first) {
            first = false;
            for (int i = 0; i < length; ++i) {
                used[i] = true;
            }
            return string.substring(0, length);
        } else {
            int depth = 1;
            for (int i = used.length - 1; i >= 0; --i) {
                if (used[i]) {
                    used[i] = false;
                    ++depth;
                } else {
                    break;
                }
            }

            for (int i = used.length - depth; i >= 0; --i) {
                if (used[i]) {
                    used[i] = false;
                    for (int j = 0; j < depth; ++j) {
                        used[i + 1 + j] = true;
                    }
                    break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < used.length; ++i) {
                if (used[i]) {
                    sb.append(string.charAt(i));
                }
            }
            return sb.toString();
        }
    }

    public boolean hasNext() {
        for (int i = 0; i < length; ++i) {
            if (!used[used.length - 1 - i]) {
                return true;
            }
        }
        return false;
    }
}
