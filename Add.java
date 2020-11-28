package interpreter;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Add {
	public double sum(LinkedHashMap<String, String> variable, ArrayList<String> word,LinkedHashMap<String, String> all_list) {
		double temp = 0;
		for (int i = 2; i < word.size(); i++) {
			String see = word.get(i);
			if (see.matches("\\d+\\.{0,1}\\d*")) {
				temp += Double.parseDouble(see);
			} else if (Character.isDigit(see.charAt(0))) {
				return -1;
			} else {
				int pos = 0;
				for (String same : variable.keySet()) {
					if (same.equals(see)) {
						pos = 1;
						if (variable.get(same).matches("\\d+\\.{0,1}\\d*")) {
							temp += Double.parseDouble(variable.get(same));
						} else {
							return -2;
						}
						break;
					}
				}
				if (pos == 1) {
					continue;
				}
				return 1;
			}
		}
		String save = word.get(1);
		int eq = 0;
		if (Character.isDigit(save.charAt(0))) {
			return -1;
		}
		for(String equ:all_list.keySet()) {
			if(equ.equals(save)) {
				all_list.remove(equ);
			}
		}
		for (String same : variable.keySet()) {
			if (same.equals(save)) {
				variable.replace(save, String.valueOf(temp));
				eq = 1;
			}
		}

		if (eq == 0) {
			variable.put(save, String.valueOf(temp));
		}
		return temp;

	}
}
