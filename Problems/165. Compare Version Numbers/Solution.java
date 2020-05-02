import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int compareVersion(String version1, String version2) {
        List<Integer> v1 = Arrays.stream(version1.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> v2 = Arrays.stream(version2.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());
        
        int last_common_index = Math.min(v1.size(), v2.size());

        for (int i = 0; i < last_common_index; ++i) {
            if (v1.get(i) > v2.get(i)) {
                return 1;
            }
            if (v2.get(i) > v1.get(i)) {
                return -1;
            }
        }

        if (v1.size() > v2.size()) {
            if (!hasOnlyZeros(v1, last_common_index)) {
                return 1;
            }
        }

        if (v2.size() > v1.size()) {
            if (!hasOnlyZeros(v2, last_common_index)) {
                return -1;
            }
        }
        
        return 0;
    }

    private boolean hasOnlyZeros(List<Integer> list, int idx) {
        for (int i = idx; i < list.size(); ++i) {
            if (list.get(i) != 0) {
                return false;
            }
        }
        return true;
    }
}