package Recursion;

public class i_LetterCasePermutationOnly {

	private static void latterCasePermutationOnly(String input, String output) {
		if (input.isEmpty()) {
			System.out.print(output + " ");
			return;
		}

		if (!Character.isDigit(input.charAt(0))) {
			String outputWithoutCaseChange = new String(output);
			String outputWithCaseChange = new String(output);
			outputWithoutCaseChange = outputWithoutCaseChange + input.toLowerCase().charAt(0);
			outputWithCaseChange = outputWithCaseChange + input.toUpperCase().charAt(0);
			
			input = input.substring(1);
			
			latterCasePermutationOnly(input, outputWithoutCaseChange);
			latterCasePermutationOnly(input, outputWithCaseChange);
		} else {
			String outputWithDigit = new String(output);
			outputWithDigit = outputWithDigit + input.charAt(0);
			
			input = input.substring(1);
			
			latterCasePermutationOnly(input, outputWithDigit);
		}
		

		

	}

	public static void main(String[] args) {

		String ip = "A1B2C";  //if digit just add it to the output only one decision if char two decision add with lowercase or add with uppercase
		String out = "";
		latterCasePermutationOnly(ip, out);

	}

}
