package Algo_dp;

public class leetcode5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 以单个字母往外扩展
            int len1 = expandAroundCenter(s, i, i);
            // 以两个字母往外扩展
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            // 计算最大回文子串的start和end
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String [] args) {
        leetcode5 leetcode5 = new leetcode5();
        String s = "dbhajlcbyawodoway";
        System.out.println(leetcode5.longestPalindrome(s));
    }
}
