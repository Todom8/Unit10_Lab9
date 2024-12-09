package collections;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Pantry pantry = new Pantry();
		pantry.fromFile("foods.txt");
		Menu menu = new Menu();
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("\n\n\nEnter any of the following:\n"
					+ "\n"
					+ "       1) What's in the Pantry\n"
					+ "\n"
					+ "       2) What's on the Menu\n"
					+ "\n"
					+ "       3) Design a Meal\n"
					+ "\n"
					+ "       4) Generate a Meal\n"
					+ "\n"
					+ "       5) Calorie Cull\n"
					+ "\n"
					+ "       6) Quit"
					+ "\n\n");
			String selection = input.next();
			
			switch (selection) {
			case "1":
				System.out.println(pantry);
				break;
			case "2":
				System.out.print(menu);
				break;
			case "3":
				Meal newInputMeal = new Meal();
				newInputMeal.setPantry(pantry);
				newInputMeal.fromInput();
				menu.addMeal(newInputMeal);
				break;
			case "4":
				Meal newRandMeal = new Meal();
				newRandMeal.setPantry(pantry);
				newRandMeal.fromRandom();
				menu.addMeal(newRandMeal);
				break;
			case "5":
				System.out.print("Set your limit: ");
				menu.limitCalories(input.nextInt());
				break;
			case "6":
				return;
			default:
				break;
			}
		}
	}
}
