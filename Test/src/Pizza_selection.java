import java.util.Scanner;
import java.util.HashSet;


public class Pizza_selection {
	
	public static void main(String[] args) {
		HashSet<String>pizzaSize = new HashSet<>();
		pizzaSize.add("Small");
		pizzaSize.add("Medium");
		pizzaSize.add("Large");
		pizzaSize.add("Monster");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("PIZZA MENU");
		for(String size:pizzaSize) {
			System.out.println("-"+size);
		}
		
		System.out.println("enter your choice");
		String input = scanner.nextLine();
		if(pizzaSize.contains(input)) {
			System.out.println("your choice is "+input);
		}
			else {
				System.out.println("INVALID SIZE");
			}
		scanner.close();
			
		}
	}
