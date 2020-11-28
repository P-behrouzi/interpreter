package interpreter;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class List {
	public int my_list(LinkedHashMap<String, String> all_list, ArrayList<String> word,
			LinkedHashMap<String, String> variable) {
		if (Character.isDigit(word.get(1).charAt(0))) {
			return -1;
		}
		int count = 2;
		StringBuilder sb = new StringBuilder("");
		for (int i=2;i<word.size();i++) {
			if (word.get(i).matches("\\d+\\.{0,1}\\d*")) {

				if (count == word.size()-1) {
					sb.append(word.get(i));
				} else {
					sb.append(word.get(i) + ",");
				}
				count++;
			}
			
			else {
				return 1;
			}
		}
		int eq = 0;
		for (String same : variable.keySet()) {
			if (same.equals(word.get(1))) {
				variable.remove(same);
			}
		}
		for (String same : all_list.keySet()) {
			if (same.equals(word.get(1))) {
				eq = 1;
				all_list.replace(word.get(1), sb.toString());
			}
		}
		if (eq == 0) {
			all_list.put(word.get(1), sb.toString());
		}
		return 0;
	}
}
