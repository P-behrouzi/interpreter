package interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Reverse {
	public int rev(LinkedHashMap<String, String> all_list, ArrayList<String> word,
			LinkedHashMap<String, String> variable) {
		if (Character.isDigit(word.get(1).charAt(0)) && Character.isDigit(word.get(2).charAt(0))) {
			return -1;
		}
		int exist = 0;
		for (String same : all_list.keySet()) {
			if (same.equals(word.get(2))) {
				exist = 1;
				String list = all_list.get(same);
				String str[] = list.split(",");
				ArrayList<String> all_value = new ArrayList<String>();
				all_value.addAll(Arrays.asList(str));
				int count = 1;
				StringBuilder sb = new StringBuilder("");
				for (int i = all_value.size() - 1; i >= 0; i--) {
					if (count == all_value.size()) {
						sb.append(all_value.get(i));
					} else {
						sb.append(all_value.get(i) + ",");
					}
					count++;
				}
				System.out.println("reverse list: " + sb.toString());
				int eq = 0;
				for (String samee : variable.keySet()) {
					if (samee.equals(word.get(1))) {
						variable.remove(samee);
					}
				}
				for (String equ : all_list.keySet()) {
					if (equ.equals(word.get(1))) {
						all_list.replace(word.get(1), sb.toString());
						eq = 1;
						break;
					}
				}
				if (eq == 0) {
					all_list.put(word.get(1), sb.toString());
				}
				break;
			}
		}
		if (exist == 0) {
			return 1;
		}
		return 0;
	}
}
