package collections;

public class Ingredient {
	private String name;
	private String group;
	private int calories;
	private float percentage;
	private Ingredient nextIngredient;
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getGroup() {
		return group;
	}
	
	public void setGroup(String newGroup) {
		group = newGroup;
	}
	
	public int getCalories() {
		return calories;
	}
	
	public void setCalories(int newCalories) {
		if (newCalories >= 0) {
			calories = newCalories;
		}
	}
	
	public float getPercentage() {
		return percentage;
	}
	
	public void setPercentage(float newPercentage) {
		if (newPercentage >= 0) {
			percentage = newPercentage;
		}
	}
	
	public Ingredient getNext() {
		return nextIngredient;
	}
	
	public void setNext(Ingredient newIngredient) {
		nextIngredient = newIngredient;
	}
}
