package interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Variable {

	public int set_variable(LinkedHashMap<String, String> variable, ArrayList<String> word) {
		if (word.size() % 2 != 1) {
			return -1;
		} else {
			for (int i = 1; i < word.size() - 1; i += 2) {
				if (Character.isDigit(word.get(i).charAt(0))) {
					return 1;
				}
				int same = 0;
				for (String eq : variable.keySet()) {
					if (word.get(i) == eq) {
						variable.replace(eq, word.get(i + 1));
						same = 1;
						break;
					}
				}
				if (same == 1) {
					continue;
				} else {
					variable.put(word.get(i), word.get(i + 1));
				}
			}

		}
		return 0;
	}

}
