public class ReplaceSpaces {
    /**
     * https://www.lintcode.com/problem/space-replacement/description?_from=ladder&&fromId=6
     *
     * 设计一种方法，将一个字符串中的所有空格替换成 %20 。
     * 你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // write your code here
        if(string == null || length <= 0){
            return 0;
        }
        int count = 0;
        for(int i=0; i<length; i++){
            if(string[i] == ' '){
                count++;
            }
        }
        int len = length + count * 2;
        int i = length - 1;
        int j = len - 1;
        while(i < j){
            if(string[i] != ' '){
                string[j] = string[i];
            }else{
                string[j--] = '0';
                string[j--] = '2';
                string[j] = '%';
            }
            i--;
            j--;
        }
        return len;
    }
}
