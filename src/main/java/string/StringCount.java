package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StringCount {

	public static void main(String[] args) {

		String s = "Sanjeev";

		char sc[] = s.toCharArray();

		Map<Character, Integer> smap = new HashMap<Character, Integer>();
		for (Character c : sc) {
			if (smap.containsKey(c)) {
				smap.put(c, (smap.get(c) + 1));
			} else
				smap.put(c, 1);
		}

		Set<Entry<Character, Integer>> entrySet = smap.entrySet();
		System.out.println(smap.values());
		System.out.println(smap.keySet());

		for (Entry<Character, Integer> e : entrySet) {
			if (e.getValue() > 1) {
				System.out.println(e.getKey() + " " + e.getValue());
			}
		}
	}
}
