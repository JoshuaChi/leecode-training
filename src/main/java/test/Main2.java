package test;

public class Main2 {

	public static void main(String[] args) {
		char[] characters = {0, 1, 2};
		String tmp=new String(characters);
		System.out.println("tmp = " + tmp);
		int number = Integer.parseInt(tmp);
		System.out.println(number);
	}
}
