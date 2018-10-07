public class FirstUniqChar {
    /**
     * https://www.lintcode.com/problem/first-unique-character-in-a-string/description?_from=ladder&&fromId=6
     *
     * 给出一个字符串，找出第一个只出现一次的字符。
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        // Write your code here
        if (str == null || str.length() == 0) {
            return '\0';
        }
        int length = str.length();
        /**hash表时间和空间复杂度均为O(n)*/
        final int SIZE = 256;
        char[] hash = new char[SIZE];
        for (int i = 0; i < length; i++) {
            hash[str.charAt(i)]++;
        }
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (hash[ch] == 1) {
                return ch;
            }
        }
        return '\0';
    }
}
