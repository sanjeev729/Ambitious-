package Recursion;

import java.util.HashSet;
import java.util.Set;

public class f_PrintPowerSet {

	private static void printPowerSet(String input, String output) {
		if (input.isEmpty()) {
			System.out.print(output+" ");
			return;
		}

		String outputWithoutChar = new String(output);
		String outputWithChar = new String(output);
		outputWithChar = outputWithChar + input.charAt(0);

		input = input.substring(1);

		printPowerSet(input, outputWithoutChar);
		printPowerSet(input, outputWithChar);

	}

	private static void printPowerSetUnique(String input, String output, Set<String> unique) {
		if (input.isEmpty()) {
			unique.add(output);
			return;
		}

		String outputWithoutChar = new String(output);
		String outputWithChar = new String(output);
		outputWithChar = outputWithChar + input.charAt(0);

		input = input.substring(1);

		printPowerSetUnique(input, outputWithoutChar, unique);
		printPowerSetUnique(input, outputWithChar, unique);

	}

	public static void main(String[] args) {

		String ip = "abbcd";
		String out = "";
		Set<String> unique = new HashSet<>();
		printPowerSet(ip, out);
		System.out.println();
		printPowerSetUnique(ip, out, unique);
		System.out.println(unique);

	}

}
