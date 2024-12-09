package collections;

import java.util.Random;
import java.util.Scanner;

public class Meal {
	private Ingredient[] ingredients = new Ingredient[3];
	private Pantry pantry;
	private int calories;
	private float percentage;
	private Meal nextMeal;
	
	public Pantry getPantry() {
		return pantry;
	}
	
	public void setPantry(Pantry newPantry) {
		pantry = newPantry;
	}
	
	public int getCalories() {
		return calories;
	}
	
	public float getPercentage() {
		return percentage;
	}
	
	public void fromInput() {
		int idx = 0;
		Scanner input = new Scanner(System.in);
		while (idx < 3) {
			System.out.print("Pick an ingredient: ");
			String toCheck = input.next();
			Ingredient ingredient = null;
			for (int i = 0; i < pantry.length(); i ++) {
				if (toCheck.equals(pantry.getFromIndex(i).getName())) {
					ingredient = pantry.getFromIndex(i);
					break;
				}
			}
			if (ingredient == null) {
				System.out.println("That ingredient is not on the list!");
			} else {
				ingredients[idx] = ingredient;
				idx += 1;
			}
		}
		calculateInfo();
		System.out.println("Meal added!");
	}
	
	public void fromRandom() {
		Random roller = new Random();
		for (int i = 0; i < ingredients.length; i++) {
			ingredients[i] = pantry.getFromIndex(roller.nextInt(pantry.length()));
		}
		calculateInfo();
	}
	
	private void calculateInfo() {
		calories = 0;
		percentage = 0;
		for (int i = 0; i < ingredients.length; i++) {
			calories += ingredients[i].getCalories();
			percentage += ingredients[i].getPercentage();
		}
	}
	
	public void setNext(Meal newMeal) {
		nextMeal = newMeal;
	}
	
	public Meal getNext() {
		return nextMeal;
	}
	
	public String toString() {
		String returnStr = "";
		for (int i = 0; i < ingredients.length; i++) {
			returnStr += " - " + ingredients[i].getName() + "\n";
		}
		returnStr += "Calories: " + calories + ", ";
		returnStr += "Percentage: " + percentage;
		return returnStr;
	}
}
