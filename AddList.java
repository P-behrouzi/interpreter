package interpreter;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class AddList {
	public int add(LinkedHashMap<String, String> all_list, ArrayList<String> word) {
		if (Character.isDigit(word.get(1).charAt(0))) {
			return -1;
		}
		int eq=0;
		for(String same :all_list.keySet()) {
			if(same.equals(word.get(1))) {
				eq=1;
				String list = all_list.get(same);
				StringBuilder sb = new StringBuilder("");
				sb.append(list);
				for(int i=2;i<word.size();i++) {
					if(word.get(i).matches("\\d+\\.{0,1}\\d*")) {
					sb.append(","+word.get(i));}
					else {
						return -2;
					}
				}
				System.out.println("your new list: "+sb.toString());
				all_list.replace(same, sb.toString());
			}
		}
		if(eq==0) {
			return 1;
		}
		return 0;
		
	}
}
