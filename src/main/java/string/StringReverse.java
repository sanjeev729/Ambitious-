package string;

public class StringReverse {

	public static String reverseRecursively(String str) {

		// base case to handle one char string and empty string
		if (str.length() < 2) {

			return str;
		}

		return reverseRecursively(str.substring(1)) + str.charAt(0);

	}

	public static String reverseutil(String str) {

		String str1[] = reverseRecursively(str).split(" ");
		String temp = new String();
		for (String s : str1)
			temp = temp + reverseRecursively(s) + " ";

		return temp;

	}

	public static void main(String[] args) {
		String str = "ABDD sanjeev kumar pal";
		System.out.println(reverseutil(str));
	}

}
