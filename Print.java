package interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Print {
	public int show(ArrayList<String> word, LinkedHashMap<String, String> variable,
			LinkedHashMap<String, String> all_list) {
		for (int i = 1; i < word.size(); i++) {
			String see = word.get(i);
			if (see.matches("\\d+\\.{0,1}\\d*")) {
				System.out.println(see);
				continue;
			} else if (Character.isDigit(see.charAt(0))) {

				return -1;
			} else {
				int pos = 0;
				int eq = 0;
				for (String same : variable.keySet()) {
					if (same.equals(see)) {
						pos = 1;
						System.out.println(variable.get(same));
						break;
					}
				}
				for (String equ : all_list.keySet()) {
					if (equ.equals(see)) {
						eq = 1;
						System.out.println(all_list.get(equ));
						break;
					}
				}
				if (pos == 1 || eq == 1) {
					continue;
				}
				return 1;
			}
		}

		return 0;
	}
}
