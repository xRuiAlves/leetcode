class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] targets = new boolean[arr.length];

        boolean zero_found = false;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 0) {
                zero_found = true;
                targets[i] = true;
            }
        }

        if (!zero_found) {
            return false;
        }

        boolean update_occured = true;
        while(update_occured) {
            update_occured = false;
            for (int i = 0; i < arr.length; ++i) {
                if (targets[i]) {
                    continue;
                }
                int j1 = i + arr[i];
                int j2 = i - arr[i];
                if (j1 < arr.length && targets[j1] || j2 >= 0 && targets[j2]) {
                    if (i == start) {
                        return true;
                    }
                    targets[i] = true;
                    update_occured = true;
                }
            }
        }

        return targets[start];
    }
}