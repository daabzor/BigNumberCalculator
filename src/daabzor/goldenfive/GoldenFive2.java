package daabzor.goldenfive;
import java.util.Scanner;
import java.util.Arrays;
public class GoldenFive2 {
	
	public static void main(String[] args) {
		  Scanner input = new Scanner(System.in);
		  
		  System.out.println("Enter first number:");
		  String firstString = input.nextLine();
		  
		  System.out.println("Enter second number:");
		  String secondString = input.nextLine();
		 
			System.out.println("Enter the operation (+ , - , * , / , ^ ):");	
			String c = input.nextLine();			
							
			switch (c) {
				case "+":
					System.out.println(Calculator.add(firstString, secondString));
				break;
				
				case "-":	
					System.out.println(Calculator.sub(firstString, secondString));	
				break;
				
				case "*":		
					System.out.println(Calculator.mul(firstString, secondString));
				break;
				
				case "/":
					if(secondString.length() == 1) {
					System.out.println(Calculator.div(firstString, secondString));			
					} else {
					System.out.println(Calculator.longDivision(firstString, secondString));		
					}
				break;
				
				case "^":
					if (secondString.equals("1")) {
						System.out.println(firstString);
					} else if (secondString.equals("0")) {
						System.out.println("0");
					} else {
					System.out.println(Calculator.pow(firstString, secondString));
					}
				break; 
				
				default:
					System.out.println("Wrong operation");
			}
	}			    
}
	
