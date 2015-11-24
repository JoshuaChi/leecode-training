package leetcode;

public class ValidNumber {
	public boolean isNumber(String s) {
//		String patterns = "^(\\s*[\\-|\\+]?[0-9]*\\.[0-9]+\\s*)|" +
//				"(\\s*[\\-|\\+]?[0-9]+\\.[0-9]*\\s*)|" +
//				"(\\s*[\\-|\\+]?[0-9]+\\s*)|" +
//				"(\\s*[\\-|\\+]?[0-9]+\\.?(e[0-9]+)\\s*)$";
//		String patterns = "^(\\s*[0-9]+\\.[0-9]*\\s*)$";
//		String patterns = "^\\s*[\\-|\\+]?[0-9]*\\.?[0-9]+(e[0-9]+)?\\s*$";
//		String patterns = "^\\s*[\\-|\\+]?([0-9]*\\.?[0-9]+(e[0-9]+)?|[0-9]+\\.?)\\s*$";

		String patterns = "^\\s*[\\-|\\+]?" +
				"(" +
				"[0-9]*\\.?[0-9]+(e[\\+|\\-]?[0-9]+)?" +
				"|" +
				"[0-9]+\\.?([0-9]+)?(e[\\+|\\-]?[0-9]+)?" +
				"|" +
				"[0-9]+\\.?" +
				")" +
				"\\s*$";
		if (s.matches(patterns)) {
			return true;
		}
		return false	;
	}

	public static void main(String[] args) {
		ValidNumber s = new ValidNumber();
		String[] a = {
			" 0.1 ",
				"0",
				"abc",
				"1 a",
				"2e10",
				"e9",
				".",
				"+.8",
				"46.e3", //true
				".2e81",
				"3.",
				" 005047e+6", // true
				"32.e-80123" // true
		};
		for(int i=0; i< a.length; i++) {
			String t = a[i];
			if(s.isNumber(t)) {
				System.out.println(t+ " - 	is number");
			};
		}

	}

}
