package interpreter;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Change {
	public int exchange(LinkedHashMap<String, String> all_list, ArrayList<String> word) {
		if (Character.isDigit(word.get(1).charAt(0))) {
			return -1;
		}
		String index = word.get(2);
		String value = word.get(3);
		if (!index.matches("\\d+")) {
			return 1;
		}
		if (!value.matches("\\d+\\.{0,1}\\d*")) {
			return -2;
		}
		int eq = 0;
		for (String same : all_list.keySet()) {
			if (same.equals(word.get(1))) {
				String list = all_list.get(same);
				System.out.println("without change: " + list);
				eq = 1;
				String str[] = list.split(",");
				LinkedList<String> all_value = new LinkedList<String>();
				all_value.addAll(Arrays.asList(str));
				if (Integer.parseInt(index) >= all_value.size()) {
					return -3;
				}
				all_value.set(Integer.parseInt(index), value);
				int count = 1;
				StringBuilder sb = new StringBuilder("");
				for (String all : all_value) {
					if (count == all_value.size()) {
						sb.append(all);
					} else {
						sb.append(all + ",");
					}
					count++;
				}
				all_list.replace(word.get(1), sb.toString());
				System.out.println("change list: " + all_list.get(same));
				break;
			}
		}
		if (eq == 0) {
			return -4;
		}
		return 0;
	}
}
