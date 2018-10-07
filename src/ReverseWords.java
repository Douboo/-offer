public class ReverseWords {
    /**
     * https://www.lintcode.com/problem/reverse-words-in-a-string/description?_from=ladder&&fromId=6
     *
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     *
     * 说明
     * 单词的构成：无空格字母构成一个单词
     * 输入字符串是否包括前导或者尾随空格？可以包括，但是反转后的字符不能包括
     * 如何处理两个单词间的多个空格？在反转字符串中间空格减少到只含一个
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        if(s == null || s.length() <= 1){
            return s;
        }
        String[] str = s.split("\\s+");
        StringBuilder sbd = new StringBuilder();
        if(str.length > 0){
            sbd.append(str[str.length-1]);
            for(int i=str.length-2; i>=0; i--){
                sbd.append(" " + str[i]);
            }

        }
        return sbd.toString();
    }
}
