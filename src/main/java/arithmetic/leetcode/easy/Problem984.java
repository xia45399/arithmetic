package arithmetic.leetcode.easy;

public class Problem984 {
    public static void main(String[] args) {
        System.out.println(new Problem984().strWithout3a3b(4, 1));
    }

    public String strWithout3a3b(int A, int B) {
        StringBuilder stringBuilder = new StringBuilder();
        int aMax = 0;
        int bMax = 0;
        while (A > 0 || B > 0) {
            if (bMax == 2 || (A >= B && aMax < 2)) {
                bMax = 0;
                aMax++;
                stringBuilder.append("a");
                A--;
            } else if (aMax == 2 || (A < B && bMax < 2)) {
                aMax = 0;
                bMax++;
                stringBuilder.append("b");
                B--;
            }
        }
        return stringBuilder.toString();
    }
}
