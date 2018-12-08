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
//            int firstPlusIndex = local.indexOf("+");
//            if(firstPlusIndex > -1){
//                local = local.substring(0, firstPlusIndex);
//            }
            set.add(local.split("\\+")[0] + "@" + domain);
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(
                //s.numUniqueEmails();
        );
    }

}
