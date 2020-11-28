package interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Sort {
	public int sorted(LinkedHashMap<String, String> all_list, ArrayList<String> word,
			LinkedHashMap<String, String> variable) {
		if (Character.isDigit(word.get(1).charAt(0)) && Character.isDigit(word.get(2).charAt(0))) {
			return -1;
		}
		int eq = 0;
		int exist = 0;
		double end = 0;
		StringBuilder sb = new StringBuilder("");
		for (String find : all_list.keySet()) {
			if (find.equals(word.get(1))) {
				String value = all_list.get(find);
				String str[] = value.split(",");
				ArrayList<String> all_value = new ArrayList<String>();
				all_value.addAll(Arrays.asList(str));
				for (int i = 0; i < all_value.size(); i++) {
					double min = Double.parseDouble(all_value.get(i));
					int count = 0;
					int index = i;
					for (int j = i; j < all_value.size(); j++) {
						double temp = Double.parseDouble(all_value.get(j));
						count++;
						if (temp < min) {
							min = temp;
							index = count;
						}
					}
					String change = all_value.get(i);
					all_value.set(i, String.valueOf(min));
					all_value.set(index - 1, change);

					if (i == all_value.size() - 1) {
						sb.append(String.valueOf(min));
					} else {
						sb.append(String.valueOf(min) + ",");
					}

				}

				exist = 1;

			}
		}
		System.out.println("your new list : " + sb.toString());
		int ex = 0;
		for (String same : variable.keySet()) {
			if (same.equals(word.get(1))) {
				variable.remove(same);
			}
		}
		for (String same : all_list.keySet()) {
			if (same.equals(word.get(1))) {
				ex = 1;
				all_list.replace(word.get(1), sb.toString());
			}
		}
		if (ex == 0) {
			all_list.put(word.get(1), sb.toString());
		}
		return 0;
	}

}
