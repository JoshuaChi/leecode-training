package leetcode;

public class Solution1b {
	public int add(int num) {
		if(num < 10) {
			return num;
		}
		String numStr = String.valueOf(num);
		System.out.println("numStr:" + numStr);
		char[] cs = numStr.toCharArray();
		int result = 0;
		for (int i=0; i < cs.length; i++) {
			System.out.println("cs[i]:" + cs[i]);
			result += Integer.valueOf(String.valueOf(cs[i]));
		}
		return result;
	}

	public int addDigits(int num) {
		int result = add(num);
		if (result < 10) {
			return result;
		}else {
			return addDigits(result);
		}
	}

	public static void main(String[] args) {
		Solution1b s = new Solution1b();
		System.out.println(s.addDigits(11));
	}

}
