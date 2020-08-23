package Recursion;

public class h_PermutationCaseChnage {

	private static void permutationCaseChange(String input, String output) {
		if (input.isEmpty()) {
			System.out.print(output + " ");
			return;
		}

		String outputWithoutCaseChange = new String(output);
		String outputWithCaseChange = new String(output);
		outputWithoutCaseChange = outputWithoutCaseChange + input.toLowerCase().charAt(0);
		outputWithCaseChange = outputWithCaseChange + input.toUpperCase().charAt(0);

		input = input.substring(1);

		permutationCaseChange(input, outputWithoutCaseChange);
		permutationCaseChange(input, outputWithCaseChange);

	}

	public static void main(String[] args) {

		String ip = "AB";
		String out = "";
		permutationCaseChange(ip, out);

	}

}
