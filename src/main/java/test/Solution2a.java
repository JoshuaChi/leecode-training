package test;

public class Solution2a {
	public int cal(int num) {
		if(num == 1) {
			return num;
		}

		String numStr = String.valueOf(num);
		System.out.println("numStr:" + numStr);
		char[] cs = numStr.toCharArray();
		int result = 0;
		for (int i=0; i < cs.length; i++) {
			System.out.println("cs[i]:" + cs[i]);
			result += Math.pow(Double.valueOf(String.valueOf(cs[i])), 2);
		}
		return result;
	}

	public boolean _isHappy(int n, String store) {
		int result = cal(n);
		if (result == 1) {
			return true;
		} else {
			String temp = String.valueOf(result);
			System.out.println("store:"+ store);
			if (store.indexOf(";"+temp) == -1) {
				return _isHappy(result, store += temp+";");
			}else {
				return false;
			}
		}

	}
	public boolean isHappy(int n) {
		System.out.println(n);
		String store = ";";
		return _isHappy(n, store);

	}

	public static void main(String[] args) {
		Solution2a s = new Solution2a();
		System.out.println(s.isHappy(37));
	}

}
