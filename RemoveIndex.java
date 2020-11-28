package interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class RemoveIndex {
	public int remove(LinkedHashMap<String, String> all_list, ArrayList<String> word) {
		if (Character.isDigit(word.get(1).charAt(0))) {
			return -1;
		}
		int eq = 0;
		for (String same : all_list.keySet()) {
			if (same.equals(word.get(1))) {
				eq = 1;
				String list = all_list.get(same);
				String str[] = list.split(",");
				LinkedList<String> all_value = new LinkedList<String>();
				all_value.addAll(Arrays.asList(str));
				StringBuilder sb = new StringBuilder("");
				for (int i = 2; i < word.size(); i++) {
					if (!word.get(i).matches("\\d+")) {
						return 1;
					}
					if (Integer.parseInt(word.get(i)) >= all_value.size()) {
						return -2;
					}
					all_value.remove(Integer.parseInt(word.get(i)));

				}
				for (String num : all_value) {
					if (num == all_value.get(all_value.size() - 1)) {
						sb.append(num);
						continue;
					}
					sb.append(num + ",");
				}
				System.out.println("your new list : " + sb.toString());
				all_list.replace(same, sb.toString());
			}
		}
		if (eq == 0) {
			return -3;
		}
		return 0;
	}
}
