package arithmetic.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem929 {
    public static void main(String[] args) {
        String[] a = {"test.email+alex@arithmetic.leetcode.com", "test.e.mail+bob.cathy@arithmetic.leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(new Problem929().numUniqueEmails(a));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] arr = email.split("@");
            String text = arr[0];
            int index = text.indexOf('+');
            if (index > 0) {
                text = text.substring(0, index);
            }
            text = text.replace(".", "");
            set.add(text + "@" + arr[1]);
        }
        return set.size();
    }
}
