import java.util.HashSet;
import java.util.Set;

public class Solution {

    // 771. Jewels and Stones
    // https://leetcode.com/problems/jewels-and-stones/
    public int numJewelsInStones(String J, String S) {
        int answer = 0;
        int[] table = new int[128];
        for(char c : J.toCharArray()){
            table[c] = 1;
        }
        for(char c : S.toCharArray()){
            if(table[c] == 1)
                answer++;
        }
        return answer;
    }

    // 929. Unique Email Addresses
    // https://leetcode.com/problems/unique-email-addresses/
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>();
        for(String s : emails){
            String[] names = s.split("@");
            String local = names[0], domain = names[1];
            local = local.replace(".", "");
            //用split[0]来代替indexOf
            // int firstPlusIndex = local.indexOf("+");
            // if(firstPlusIndex > -1){
            //     local = local.substring(0, firstPlusIndex);
            // }
            set.add(local.split("\\+")[0] + "@" + domain);
        }
        return set.size();
    }

    // 709. To Lower Case
    // https://leetcode.com/problems/to-lower-case/
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] >= 'A' && chars[i] <= 'Z')
                chars[i] += ('a' - 'A');
        }
        return new String(chars);
    }
    
    // 804. Unique Morse Code Words
    // https://leetcode.com/problems/unique-morse-code-words/
    public int uniqueMorseRepresentations(String[] words) {
        String[] dict = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<String>();
        for(String word : words){
            // String morse = "";
            //换用StringBuilder 6ms -> 5ms
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < word.length(); i++){
                sb.append(dict[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
    
    // 905. Sort Array By Parity
    // https://leetcode.com/problems/sort-array-by-parity/
    public int[] sortArrayByParity(int[] A) {
        int j = A.length - 1, i = 0, temp;
        while(i < j){
            if(A[i] % 2 == 0){
                i++;
            } else {
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                j--;
            }
        }
        return A;
    }
    
    // 944. Delete Columns to Make Sorted
    // https://leetcode.com/problems/delete-columns-to-make-sorted/
    public int minDeletionSize(String[] A) {
        int ans = 0, length = A[0].length();
        for(int i = 0; i < length; i++){
            for(int j = 0; j < A.length - 1; j++){
                if(A[j+1].charAt(i) < A[j].charAt(i)){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
    
    // 657. Robot Return to Origin
    // https://leetcode.com/problems/robot-return-to-origin/
    public boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        int x = 0, y = 0;
        for(char c : chars){
            switch (c){
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
            }
        }
        return x == 0 && y == 0;
    }
    
    // 832. Flipping an Image
    // https://leetcode.com/problems/flipping-an-image/
    public int[][] flipAndInvertImage(int[][] A) {
        int length = A.length, temp;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < (length + 1) / 2; j++){ // +1用于处理奇数个的情况，中间项也进入循环，且不影响偶数个
                temp = 1 - A[i][j]; //此处除了1-A，也可以用异或：A^1
                A[i][j] = 1 - A[i][length-1-j];
                A[i][length-1-j] = temp;
            }
        }
        return A;
    }
    
    // 461. Hamming Distance
    // https://leetcode.com/problems/hamming-distance/
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, ans = 0;
        //等价于求xor二进制形式中1的个数
        while(xor > 0){
            xor &= xor - 1; //[结论]要消除整数n最低位的1，可以使用 n = n & (n-1)。
            ans++;
        }
        return ans;
    }
    
    // 617. Merge Two Binary Trees
    // https://leetcode.com/problems/merge-two-binary-trees/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // if(t1 == null && t2 == null) return null; //其实这一句没有必要
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }
    
    // 942. DI String Match
    // https://leetcode.com/problems/di-string-match/
    public int[] diStringMatch(String S) {
        int length = S.length(), left = 0, right = length;
        int[] ans = new int[length + 1];
        for(int i = 0; i < length; i++){
            ans[i] = S.charAt(i) == 'I' ? left++ : right--;
        }
        ans[length] = left;
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] array = {"zyx","wvu","tsr"};
        System.out.println(
                s.minDeletionSize(array)
        );
    }

}
