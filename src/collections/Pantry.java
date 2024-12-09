package collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pantry {
	private Ingredient head;
	private Ingredient tail;
	private int maxNameLength;
	private int maxGroupLength;
	private final int maxNumberLength = 9;
	
	public int length() {
		int size = 0;
		Ingredient ingredient = head;
		while (ingredient != null) {
			size += 1;
			ingredient = ingredient.getNext();
		}
		return size;
	}
	
	public void fromFile(String filePath) {
		File file = new File(filePath);
		Scanner input;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Pantry file not found!");
			return;
		}
		head = null;
		while (input.hasNextLine()) {
			addFromLine(input.nextLine());
			if (tail.getName().length() > maxNameLength) {
				maxNameLength = tail.getName().length();
			}
			System.out.println(maxNameLength);
			if (tail.getGroup().length() > maxGroupLength) {
				maxGroupLength = tail.getGroup().length();
			}
		}
		input.close();
	}
	
	private void addFromLine(String line) {
		String[] components = line.split(" ");
		System.out.println(line);
		if (components.length < 4) {
			return;
		}
		
		Ingredient newIngredient = new Ingredient();
		newIngredient.setName(components[0]);
		newIngredient.setGroup(components[1]);
		try {
			newIngredient.setCalories(Integer.parseInt(components[2]));
		} catch (NumberFormatException e) {
			return;
		}
		try {
			newIngredient.setPercentage(Float.parseFloat(components[3]));
		} catch (NumberFormatException e) {
			return;
		} 
		
		if (head == null) {
			head = newIngredient;
			tail = newIngredient;
			return;
		}
		
		tail.setNext(newIngredient);
		tail = newIngredient;
	}
	
	public Ingredient getFromIndex(int idx) {
		if (idx < 0) {
			return null;
		}
		
		Ingredient ingredient = head;
		while (idx > 0) {
			if (ingredient.getNext() == null) {
				return null;
			}
			ingredient = ingredient.getNext();
			idx -= 1;
		}
		return ingredient;
	}
	
	public String toString() {
		String returnStr = "";
		Ingredient ingredient = head;
		
		returnStr += getTableBar() + "\n";
		returnStr += getTableSpacer() + "\n";
		returnStr += getTableLabel() + "\n";
		returnStr += getTableSpacer() + "\n";
		returnStr += getTableBar();
		
		while (ingredient != null) {
			returnStr += "\n";
			returnStr += addPadding(ingredient.getName(), maxNameLength);
			returnStr += "|";
			returnStr += addPadding(ingredient.getGroup(), maxGroupLength);
			returnStr += "|";
			returnStr += addPadding(Integer.toString(ingredient.getCalories()), maxNumberLength);
			returnStr += "|";
			returnStr += addPadding(Float.toString(ingredient.getPercentage()), maxNumberLength);
			ingredient = ingredient.getNext();
		}
		return returnStr;
	}

	private String addPadding(String str, int targetLength) {
		String returnStr = str;
		for (int i = str.length(); i <= targetLength; i++) {
			returnStr += " ";
		}
		return returnStr;
	}
	
	private String getTableBar() {
		String returnStr = "";
		for (int i = 0; i <= maxNameLength; i++) {
			returnStr += "-";
		}
		returnStr += "+";
		for (int i = 0; i <= maxGroupLength; i++) {
			returnStr += "-";
		}
		returnStr += "+";
		for (int i = 0; i <= maxNumberLength; i++) {
			returnStr += "-";
		}
		returnStr += "+";
		for (int i = 0; i <= maxNumberLength; i++) {
			returnStr += "-";
		}
		return returnStr;
		
	}
	
	private String getTableSpacer() {
		String returnStr = "";
		for (int i = 0; i <= maxNameLength; i++) {
			returnStr += " ";
		}
		returnStr += "|";
		for (int i = 0; i <= maxGroupLength; i++) {
			returnStr += " ";
		}
		returnStr += "|";
		for (int i = 0; i <= maxNumberLength; i++) {
			returnStr += " ";
		}
		returnStr += "|";
		for (int i = 0; i <= maxNumberLength; i++) {
			returnStr += " ";
		}
		return returnStr;
		
	}
	
	private String getTableLabel() {
		String returnStr = "";
		
		for (int i = 0; i < (maxNameLength - 4) / 2; i++) {
			returnStr += " ";
		}
		returnStr += "Name";
		for (int i = 0; i <= (maxNameLength - 4) / 2; i++) {
			returnStr += " ";
		}
		if (maxNameLength % 2 == 1) {
			returnStr += " ";
		}
		returnStr += "|";
		
		for (int i = 0; i < (maxGroupLength - 5) / 2; i++) {
			returnStr += " ";
		}
		returnStr += "Group";
		for (int i = 0; i <= (maxGroupLength - 5) / 2; i++) {
			returnStr += " ";
		}
		if (maxNameLength % 2 == 1) {
			returnStr += " ";
		}
		returnStr += "|";
		returnStr += " Calories |Percentage";
		return returnStr;
	}
}

