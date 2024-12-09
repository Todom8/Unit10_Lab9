package collections;

public class Menu {
	private Meal head;
	private Meal tail;
	
	public void addMeal(Meal newMeal) {
		if (head == null) {
			head = newMeal;
			tail = newMeal;
			return;
		}
		
		tail.setNext(newMeal);
		tail = newMeal;
	}
	
	public void limitCalories(int maxCalories) {
		while (head != null && head.getCalories() > maxCalories) {
			head = head.getNext();
		}
		Meal lastMeal = head;
		Meal currentMeal = head.getNext();
		while (currentMeal != null) {
			if (currentMeal.getCalories() > maxCalories) {
				lastMeal.setNext(currentMeal.getNext());
				currentMeal = lastMeal.getNext();
			} else {
				lastMeal = currentMeal;
				currentMeal = lastMeal.getNext();
			}
		}
	}
	
	public String toString() {
		int dishIdx = 1;
		String returnStr = "";
		Meal meal = head;
		while (meal != null) {
			returnStr += "\n\nDish #" + dishIdx + ":\n" + meal;
			meal = meal.getNext();
			dishIdx += 1;
		}
		return returnStr;
	}
}
