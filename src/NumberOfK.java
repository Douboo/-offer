public class NumberOfK {
    /**
     * https://www.lintcode.com/problem/digit-counts/description?_from=ladder&&fromId=6
     *
     * 计算数字k在0到n中的出现的次数，k可能是0~9的一个值
     *
     * 样例
     * 例如n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]，我们发现1出现了5次 (1, 10, 11, 12)
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        int temp = n;
        char[] strN;
        if(temp > 0){
            while(temp != 0){
                count++;
                temp /= 10;
            }
            strN = new char[count];
            for(int i=strN.length-1; i>=0; i--){
                strN[i] = (char)(n % 10);
                n /= 10;
            }

        }else{
            strN = new char[1];
            strN[0] = 0;
        }
        return numberOfK(strN, 0, k);
    }
    public int numberOfK(char[] strN, int start, int k){
        if(strN == null || strN.length == 0){
            return 0;
        }
        int first = strN[start];
        if(start == strN.length-1){
            if(first >= k){
                return 1;
            }else{
                return 0;
            }
        }
        int numFirstDigit = 0;
        if(k > 0){
            if(first > k){
                numFirstDigit = (int)Math.pow(10, strN.length-1-start);
            }else if(first == k){
                int sum = 0;
                int next = start + 1;
                while(next < strN.length){
                    sum = sum*10 + strN[next];
                    next++;
                }
                numFirstDigit = sum + 1;
            }
        }
        int numOtherDigit = first * (strN.length-1-start) * (int)Math.pow(10, strN.length-2-start);
        int numRecursive = numberOfK(strN, start+1, k);
        return numFirstDigit + numOtherDigit + numRecursive;

    }
}
