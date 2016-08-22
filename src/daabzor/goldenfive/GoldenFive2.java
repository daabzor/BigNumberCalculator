package daabzor.goldenfive;
import java.util.Scanner;
import java.util.Arrays;
public class GoldenFive2 {
	
	public static void main(String[] args) {
		  Scanner input = new Scanner(System.in);
		  int[] firstNumber = new int[100];
		  int[] secondNumber = new int[100];
		
		  		  
		  System.out.println("Enter first number:");
		  String firstString = input.nextLine();
		  
		  int stringLength = firstString.length();	  
		  for (int i = stringLength - 1 ; i >= 0 ; i--) {
			  firstNumber[i + firstNumber.length - stringLength] = Integer.parseInt(String.valueOf(firstString.charAt(i)));
		  } 

		  System.out.println("Enter second number:");
		  String secondString = input.nextLine();
		  int string2Length = secondString.length();  
		  
		  for (int i = string2Length - 1 ; i >= 0 ; i--) {
			  secondNumber[i + secondNumber.length - string2Length] = Integer.parseInt(String.valueOf(secondString.charAt(i)));
		  }
		
			System.out.println("Enter the operation (+ , - , * , / , ^ ):");	
			String c = input.nextLine();			
							
			switch (c) {
				case "+":
					System.out.println(Calculator.add(firstNumber,secondNumber));
				break;
				
				case "-":	
					System.out.println(Calculator.sub(firstNumber,secondNumber));	
				break;
				
				case "*":		
					System.out.println(Calculator.mul(firstNumber, secondNumber, stringLength, string2Length));
				break;
				
				case "/":
					if(string2Length == 1){
					System.out.println(Calculator.div(firstNumber, secondNumber, stringLength, string2Length));			
					}else{
					System.out.println(Calculator.longDivision(firstNumber, secondNumber, stringLength, string2Length));		
					}
				break;
				
				case "^":
					if (string2Length == 1 && secondNumber[secondNumber.length - 1] == 1) {
						for (int i = 0 ; i < secondNumber.length ; i++) {
							System.out.print(firstNumber[i]);
						}
					} else {
					System.out.println(Calculator.pow(firstNumber, secondNumber, stringLength));
					}
				break; 
				
				default:
					System.out.println("Wrong operation");
			}
	}			    
}
	
