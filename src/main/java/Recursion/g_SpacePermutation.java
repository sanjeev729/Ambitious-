package Recursion;

import java.util.HashSet;
import java.util.Set;

public class g_SpacePermutation {

	private static void printSpacePermutation(String input, String output) {
		if (input.isEmpty()) {
			System.out.print(output + " ");
			return;
		}

		String outputWithoutSpace = new String(output);
		String outputWithSpace = new String(output);
		outputWithoutSpace = outputWithoutSpace + input.charAt(0);
		outputWithSpace = outputWithSpace + "_" + input.charAt(0);

		input = input.substring(1);

		printSpacePermutation(input, outputWithoutSpace);
		printSpacePermutation(input, outputWithSpace);

	}

	public static void main(String[] args) {

		String ip = "ABCD"; // A_B_C
		String out = "";     // in this case except first char all other chars are two choices (1.come without space(B) 2.come with space(_B))
		out = out + "A";    
		ip = ip.substring(1);   
		printSpacePermutation(ip, out);

	}

}
