public class Solution {
    public String intToRoman(int num) {
        if (num == 0) {
            return "";
        }
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] n = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder sb = new StringBuilder();
        int i = n.length;
        while (i-- > 0) {
            if (num == 0) {
                break;
            }
            int times = num / n[i];
            num -= (times * n[i]);
            for (int j = 0; j < times; j++) {
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }
}