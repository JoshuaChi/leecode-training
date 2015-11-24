package leetcode;

public class Solution1a {
    public int addDigits(int num) {
        int result = add(num);
        if (result < 10) {
            return result;
        } else {
            return addDigits(result);
        }
    }

    public int add(int num) {
        String numStr = String.valueOf(num);
        int size = numStr.length();
        int base = (size - 1) > 0 ? Integer.valueOf(new java.text.DecimalFormat("0").format(Math.pow(10, size - 1))) : 1;
        int left = num % base;
        return (num - left) / base + ((left > 10) ? add(left) : left);
    }

    public static void main(String[] args) {
        Solution1a s = new Solution1a();
        System.out.println(s.addDigits(38));
    }

}
