package leetcode.easy;

public class Problem925 {
    public boolean isLongPressedName(String name, String typed) {
        char[] arr1 = name.toCharArray();
        char[] arr2 = typed.toCharArray();
        int nameLen = arr1.length;
        int typeLen = arr2.length;
        if(arr1[0]!=arr2[0]){
            return false;
        }
        for (int i = 1, j = 1; i < nameLen; ) {
            if(j==typeLen){
                return false;
            }
            char c1=arr1[i];
            char c2=arr2[j];
            if (c1 == c2) {
                i++;
                j++;
            }else if(c2==arr1[i-1]){
                j++;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String name =  "pyplrz";
        String typed = "ppyypllrzabc";
        System.out.println(new Problem925().isLongPressedName(name, typed));
    }
}
