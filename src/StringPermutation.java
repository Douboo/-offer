import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StringPermutation {
    /**
     * https://www.lintcode.com/problem/string-permutation/description?_from=ladder&&fromId=6
     *
     * 给定两个字符串，请设计一个方法来判定其中一个字符串是否为另一个字符串的置换。
     * "abc" 为 "cba" 的置换。
     * "aabc" 不是 "abcc" 的置换。
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // write your code here
        // 本来想使用数组实现哈希表，但字符串的字符种类有点多。。
        if(A == null || B == null || A.length() != B.length()){
            return false;
        }
        int length = A.length();
        if(length == 0){
            return true;
        }
        char[] ch1 = new char[length];
        char[] ch2 = new char[length];
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<length; i++){
            ch1[i] = A.charAt(i);
            ch2[i] = B.charAt(i);
            map1.put(ch1[i], map1.getOrDefault(ch1[i], 0)+1);
            map2.put(ch2[i], map2.getOrDefault(ch2[i], 0)+1);
        }
        Iterator<Character> iter = map1.keySet().iterator();
        Character t = null;
        while(iter.hasNext()){
            t = iter.next();
            if(map1.get(t) != map2.getOrDefault(t, 0)){
                return false;
            }
        }
        return true;
    }
}
