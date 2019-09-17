package initialization;

import java.util.Arrays;
import java.util.Random;

public class IntArrayDemo {
	public static final int NUM_ELEMENTS = 15;

	public static void main(String[] args) {
		int[] myArray = new int[NUM_ELEMENTS];
		Random rand = new Random();
		// Initialize with random numbers between 1 and 100
		for(int i = 0; i < NUM_ELEMENTS; i++) {
			myArray[i] = rand.nextInt(100) + 1;
		}
		
		//Initialize array using array literal
		int[] a2 = {23, 15, 17, 92, 110, 4, 12, 67, 54, 45};
		
		//Initialize array of objects using array literal
		String[] daysOfWeek = {"Понделник", "Вторник", "Сряда", "Четвъртък", 
				"Петък", "Събота", "Неделя"};
		
		
		// Print the array
		System.out.println(Arrays.toString(daysOfWeek));

	}

}
