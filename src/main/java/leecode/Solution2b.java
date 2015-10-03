package leecode;

import java.util.ArrayList;

public class Solution2b {
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

	public boolean _isHappy(int n, ArrayList<Integer> store) {
		int result = cal(n);
		if (result == 1) {
			return true;
		}else if(result == 0) {
			return false;
		} else {
			System.out.println("store:"+ store);
			if (store.contains(result) == false) {
				store.add(result);
				return _isHappy(result, store);
			}else {
				return false;
			}
		}
	}
	public boolean isHappy(int n) {
		System.out.println(n);
		ArrayList<Integer> store = new ArrayList<Integer>();
		return _isHappy(n, store);

	}

	public static void main(String[] args) {
		Solution2b s = new Solution2b();
		System.out.println(s.isHappy(37));
	}

}
