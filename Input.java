package interpreter;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Input {
	public int in(LinkedHashMap<String, String> variable, ArrayList<String> word, String value,LinkedHashMap<String, String> all_list) {
		if (Character.isDigit(word.get(1).charAt(0))) {
			return -1;
		}
		int eq = 0;
		for(String equ:all_list.keySet()) {
			if(equ.equals(word.get(1))) {
				all_list.remove(equ);
			}
		}
		for (String same : variable.keySet()) {
			if (same.equals(word.get(1))) {
				eq = 1;
				variable.replace(word.get(1), value);
			}
		}
		if (eq == 0) {
			variable.put(word.get(1), value);
		}
		return 0;
	}
}
