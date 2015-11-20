public class Solution {
    public int compareVersion(String version1, String version2) {
        //Time: O(n), Space: O(n)
        if (version1 == null || version2 == null) {
            return 0;
        }
        String[] num1 = version1.split("\\.");
        String[] num2 = version2.split("\\.");
        int len = Math.max(version1.length(), version2.length());
        for (int i = 0; i < len; i++) {
            Integer n1 = i < num1.length ? Integer.parseInt(num1[i]) : 0;
            Integer n2 = i < num2.length ? Integer.parseInt(num2[i]) : 0;
            int rst = n1.compareTo(n2);
            if (rst != 0) {
                return rst;
            }
        }
        return 0;
    }
}