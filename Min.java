package interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Min {
	public double local_min(LinkedHashMap<String, String> all_list, ArrayList<String> word) {
		if (Character.isDigit(word.get(1).charAt(0))) {
			return -1;
		}
		int eq = 0;
		int exist = 0;
		double end = 0;

		for (String find : all_list.keySet()) {
			if (find.equals(word.get(1))) {
				String value = all_list.get(find);
				String str[] = value.split(",");
				ArrayList<String> all_value = new ArrayList<String>();
				all_value.addAll(Arrays.asList(str));
				double min = Double.parseDouble(all_value.get(0));
				for (String bigger : all_value) {
					double temp = Double.parseDouble(bigger);
					if (temp < min) {
						min = temp;
					}
				}
				end = min;
				exist = 1;

			}
		}
		if (exist == 1) {
			return end;
		} else {
			return 0;
		}
	}
}
