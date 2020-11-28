package interpreter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("enter your name file without txt: ");
		String name_file = input.nextLine();
		StringBuilder sb = new StringBuilder();
		sb.append(name_file);
		sb.append(".txt");
		String name_file_txt = sb.toString();
		try (BufferedReader br = new BufferedReader(new FileReader(name_file_txt))) {
			String temp;
			LinkedHashMap<String, String> variable = new LinkedHashMap<String, String>();
			LinkedHashMap<String, String> all_list = new LinkedHashMap<String, String>();
			while ((temp = br.readLine()) != null) {
				Pattern p = Pattern.compile("[0-9a-zA-Z.]+");
				Matcher m1 = p.matcher(temp);
				ArrayList<String> word = new ArrayList<String>();
				while (m1.find()) {
					word.add(m1.group());
				}
				if (word.get(0).toLowerCase().equals("var")) {
					Variable var = new Variable();
					int check = var.set_variable(variable, word);
					if (check == -1) {
						System.err.println("one of your variable havent value ");
						break;
					} else if (check == 1) {
						System.err.println("your variable start with number ");
						break;

					}
				} else if (word.get(0).toLowerCase().equals("print")) {
					Print print = new Print();
					int check = print.show(word, variable, all_list);
					if (check == -1) {
						System.err.println("your variable is invalid");
						break;
					} else if (check == 1) {
						System.err.println("your variable is not exist");
						break;
					}
				} else if (word.get(0).toLowerCase().equals("add")) {
					Add add = new Add();
					if (word.size() < 4) {
						System.err.println("your size for add is not enough");
						break;
					}
					double check = add.sum(variable, word, all_list);
					if (check == -1) {
						System.err.println("your variable is invaild");
						break;
					} else if (check == -2) {
						System.err.println("your value of variable is not digit");
						break;
					} else if (check == 1) {
						System.err.println("your variable is not exist");
						break;
					} else {
						System.out.println("your add: " + check);
					}
				} else if (word.get(0).toLowerCase().equals("mines")) {
					if (word.size() < 4) {
						System.err.println("your size for mines is not enough");
						break;
					}
					Mines mines = new Mines();
					double check = mines.mine(variable, word, all_list);
					if (check == -1) {
						System.err.println("your variable is invaild");
						break;
					} else if (check == -2) {
						System.err.println("your value of variable is not digit");
						break;
					} else if (check == 1) {
						System.err.println("your variable is not exist");
						break;
					} else {
						System.out.println("your mines: " + check);
					}
				} else if (word.get(0).toLowerCase().equals("mul")) {
					if (word.size() < 4) {
						System.err.println("your size for mul is not enough");
						break;
					}
					Multi mul = new Multi();
					double check = mul.mult(variable, word, all_list);
					if (check == -1) {
						System.err.println("your variable is invaild");
						break;
					} else if (check == -2) {
						System.err.println("your value of variable is not digit");
						break;
					} else if (check == 1) {
						System.err.println("your variable is not exist");
						break;
					} else {
						System.out.println("your mul: " + check);
					}
				} else if (word.get(0).toLowerCase().equals("div")) {
					if (word.size() != 4) {
						System.err.println("your size for divide is more than 4 or less than 4");
						break;
					}
					Divide divide = new Divide();
					double check = divide.div(variable, word, all_list);
					if (check == -1) {
						System.err.println("your variable is invaild");
						break;
					} else if (check == -2) {
						System.err.println("your value of variable is not digit");
						break;
					} else if (check == 1) {
						System.err.println("your variable is not exist");
						break;
					} else if (check == -3) {
						System.err.println("you divide by zero");
						break;
					} else {
						System.out.println("your div: " + check);
					}
				} else if (word.get(0).toLowerCase().equals("input")) {
					if (word.size() != 2) {
						System.err.println("your size for input is more than 3 or less than 3");
						break;
					}
					System.out.print("enter your value of variable: ");
					Scanner get = new Scanner(System.in);
					String value = get.nextLine();
					Input inputt = new Input();
					int check = inputt.in(variable, word, value, all_list);
					if (check == -1) {
						System.err.println("your variable is invalid");
						break;
					}
				} else if (word.get(0).toLowerCase().equals("write")) {
					try (BufferedWriter br1 = new BufferedWriter(new FileWriter(word.get(1), true))) {
						for (int i = 2; i < word.size(); i++) {
							br1.write(word.get(i) + " ");

						}
						br1.newLine();
					}
				} else if (word.get(0).toLowerCase().equals("list")) {
					List list = new List();
					int check = list.my_list(all_list, word, variable);
					if (check == -1) {
						System.err.println("your variable is invalid");
						break;
					} else if (check == 1) {
						System.err.println("your value is invalid");
						break;
					}
				} else if (word.get(0).toLowerCase().equals("max")) {
					Max max = new Max();
					double check = max.local_max(all_list, word);
					if (check == -1) {
						System.err.println("your variable is invalid");
						break;
					} else if (check == 0) {
						System.err.println("you dont have such list");
						break;
					} else {
						System.out.println("your max is: " + check);
					}
				} else if (word.get(0).toLowerCase().equals("min")) {
					Min min = new Min();
					double check = min.local_min(all_list, word);
					if (check == -1) {
						System.err.println("your variable is invalid");
						break;
					} else if (check == 0) {
						System.err.println("you dont have such list");
						break;
					} else {
						System.out.println("your min is: " + check);
					}
				} else if (word.get(0).toLowerCase().equals("change")) {
					if (word.size() != 4) {
						System.err.println("your size not equal 4");
						break;
					}
					Change change = new Change();
					int check = change.exchange(all_list, word);
					if (check == -1) {
						System.err.println("your input list is invalid");
						break;
					} else if (check == 1) {
						System.err.println("your index is invalid");
						break;
					} else if (check == -2) {
						System.err.println("your value is invalid");
						break;
					} else if (check == -3) {
						System.err.println("your index is out of range");
						break;
					} else if (check == -4) {
						System.err.println("your list dosent exist");
						break;
					}
				} else if (word.get(0).toLowerCase().equals("reverse")) {
					if (word.size() != 3) {
						System.err.println("your size not equal 3");
						break;
					}
					Reverse reverse = new Reverse();
					int check = reverse.rev(all_list, word, variable);
					if (check == -1) {
						System.err.println("your variable is invalid");
						break;
					} else if (check == 1) {
						System.err.println("your list to reverse not exist");
						break;
					}
				} else if (word.get(0).toLowerCase().equals("addlist")) {
					AddList addlist = new AddList();
					int check = addlist.add(all_list, word);
					if (check == -1) {
						System.err.println("your list is invalid");
						break;
					} else if (check == -2) {
						System.err.println("your value is invalid");
						break;
					} else if (check == 1) {
						System.err.println("your list dosent exist");
						break;
					}
				} else if (word.get(0).toLowerCase().equals("removeindex")) {
					RemoveIndex index = new RemoveIndex();
					int check = index.remove(all_list, word);
					if (check == -1) {
						System.err.println("your variable is invalid");
						break;
					} else if (check == 1) {
						System.err.println("your index is invalid");
						break;
					} else if (check == -2) {
						System.err.println("your index is out of range");
						break;
					} else if (check == -3) {
						System.err.println("your list is invalid");
						break;
					}
				} else if (word.get(0).toLowerCase().equals("sort")) {
					if (word.size() != 3) {
						System.err.println("your size not equal 3");
						break;
					}
					Sort sort = new Sort();
					int check = sort.sorted(all_list, word, variable);
					if (check == -1) {
						System.err.println("your variable is invalid");
						break;
					} else if (check == 1) {
						System.err.println("your list to sort not exist");
						break;
					}
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
