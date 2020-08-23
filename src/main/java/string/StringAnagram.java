package string;

public class StringAnagram {
	public static boolean isAnagram(String word, String anagram) {
		if (word.length() != anagram.length()) {
			return false;
		}
		char[] chars = word.toCharArray();
		for (char c : chars) {
			int index = anagram.indexOf(c);
			if (index != -1) {
				anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());
			} else {
				return false;
			}
		}
		return anagram.isEmpty();
	}

	public static boolean areAnagram(String str1, String str2) {

		// If both strings are of different length. Removing this condition
		// will make the program fail for strings like "aaca" and "aca"
		if (str1.length() != str2.length())
			return false;
		// Create a count array and initialize all values as 0
		int count[] = new int[str1.length()];
		int i;

		// For each character in input strings, increment count in
		// the corresponding count array
		for (i = 0; i < str1.length(); i++) {
			count[(str1.charAt(i) % str1.length())]++;
			count[(str2.charAt(i) % str1.length())]--;
		}

		// See if there is any non-zero value in count array
		for (i = 0; i < count.length; i++)
			if (count[i] > 0)
				return false;
		return true;
	}

	public static void main(String[] args) {

		System.out.println(isAnagram("sanjeev", "eesanjv"));
		System.out.println(areAnagram("sanjeev", "eesanjv"));
	}

}
