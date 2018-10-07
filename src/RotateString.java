public class RotateString {
    /**
     * https://www.lintcode.com/problem/rotate-string/description?_from=ladder&&fromId=6
     *
     * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
     *
     * 样例
     * 对于字符串 "abcdefg".
     *
     * offset=0 => "abcdefg"
     * offset=1 => "gabcdef"
     * offset=2 => "fgabcde"
     * offset=3 => "efgabcd"
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if(str == null || str.length == 0 || offset <= 0){
            return;
        }
        int low = 0;
        int high = str.length - 1;
        reverse(str, low, high);
        low = 0;
        offset %= str.length;
        high = low + offset -1;
        reverse(str, low, high);
        low = low + offset;
        high = str.length - 1;
        reverse(str, low, high);
    }
    public void reverse(char[] str, int low, int high){
        while(low < high){
            char temp = str[low];
            str[low] = str[high];
            str[high] = temp;
            low++;
            high--;
        }
    }
}
