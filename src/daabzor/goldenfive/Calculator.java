package daabzor.goldenfive;

import java.util.Arrays;

public class Calculator {
	
	private static String arrayToString(int[] array) {
		String result = Arrays.toString(array).replace("[", "").replace("]", "").replace(", ", "").replaceFirst("^0+(?!$)", "");
		return result;
	}
	
	private static int[] changeToArray(String numberString) {
		int[] number = new int[100];
		int stringLength = numberString.length();	  
		  for (int i = stringLength - 1 ; i >= 0 ; i--) {
			  number[i + number.length - stringLength] = Integer.parseInt(String.valueOf(numberString.charAt(i)));
		  } 
		  return number;
	}
	
	public static String add(String firstNumberString, String secondNumberString) {
		int[] firstNumber = changeToArray(firstNumberString);
		int[] secondNumber = changeToArray(secondNumberString);
		int[] results =  new int[100];
		int arrayLength = 100;
		
		for (int j = arrayLength - 1; j >= 0; j--) {
			results[j] = firstNumber[j] + secondNumber[j];	
		}
		for (int i = arrayLength -1; i > 0; i--) {
			if (results[i] > 9) {
				results[i - 1] = results[i - 1] + (results[i] / 10);				
				results[i] = results[i] % 10;	
			}
		}
	return arrayToString(results);
	}
	
	
	public static String sub(String firstNumberString, String secondNumberString) {
		int[] firstNumber = changeToArray(firstNumberString);
		int[] secondNumber = changeToArray(secondNumberString);
		int[] results =  new int[100];
		int arrayLength = 100;
		
		for (int i = arrayLength - 1; i >= 0; i--) {
			if (firstNumber[i] < secondNumber[i]) {
				firstNumber[i - 1] = firstNumber[i - 1] - 1;				
				firstNumber[i] = firstNumber[i] + 10;	
			}
		}
		for (int j = arrayLength - 1; j >= 0; j--) {
			results[j] = firstNumber[j] - secondNumber[j];
		}	
		return arrayToString(results);
	}
	
	
	public static String mul(String firstNumberString, String secondNumberString) {
		int[] firstNumber = changeToArray(firstNumberString);
		int[] secondNumber = changeToArray(secondNumberString);
		int strLength = firstNumberString.length();
		int strLength2 = secondNumberString.length();
		int[] results =  new int[100];
		int arrayLength = 100;
		
		for (int i = arrayLength - 1; i >= arrayLength - strLength; i--) {
			for (int j = arrayLength - 1; j >= arrayLength - strLength2; j--) {
				results[(i + j) - arrayLength + 1] += firstNumber[i] * secondNumber[j];
			}	
		}
		for (int t = arrayLength - 1; t > 0; t--) {
			if (results[t] > 9) {
				results[t - 1] = results[t - 1] + (results[t] / 10);				
				results[t] = results[t] % 10;	
			}
		}
	return arrayToString(results);
	}
	
	
	public static String div(String firstNumberString, String secondNumberString){
		int[] firstNumber = changeToArray(firstNumberString);
		int[] secondNumber = changeToArray(secondNumberString);
		int strLength = firstNumberString.length();
		int strLength2 = secondNumberString.length();
		
		int[] results =  new int[100];
		int arrayLength = 100;
		
		for (int i = arrayLength - strLength2; i <= arrayLength - 1; i++) {
			for (int j = arrayLength - strLength; j <= arrayLength - 1; j++) {
				firstNumber[j] = firstNumber[j] + (firstNumber[j - 1] % secondNumber[i]) * 10;
				results[(i + j) - arrayLength + 1] = firstNumber[j] / secondNumber[i];
			}
		}
		return arrayToString(results);
	}
	
	public static String longDivision(String firstNumberString, String secondNumberString) {
		int[] firstNumber = changeToArray(firstNumberString);
		int[] secondNumber = changeToArray(secondNumberString);
		int strLength = firstNumberString.length();
		int strLength2 = secondNumberString.length();
		
		int[] checkArray =  new int[100];
		int[] results = new int[100];
		int n = strLength - strLength2;
		int arrayLength = 100;
		int check;
		int count;
		
		for (int ii = 0; ii <= n; ii++) {
			
			for (int i = 9; i >= 0; i--) {
				for (int j = arrayLength - 1; j >= arrayLength - strLength2; j--) {
					checkArray[j] = secondNumber[j] * i;
				}
				for (int t = arrayLength - 1 ; t >= arrayLength - strLength2 ; t--) {
					if (checkArray[t] > 9) {
						checkArray[t - 1] = checkArray[t - 1] + (checkArray[t] / 10);				
						checkArray[t] = checkArray[t] % 10;	
					}	
			}
		
				count = 0;
				check = 0;
				do {						
					if (checkArray[arrayLength - strLength2 + count - 1] < firstNumber[arrayLength - strLength + count + ii - 1]) {
						check = 1;
					} else if (checkArray[arrayLength - strLength2 + count - 1] > firstNumber[arrayLength - strLength + count + ii - 1]) {
						check = -1;
					} else if (checkArray[arrayLength - strLength2 + count - 1] == firstNumber[arrayLength - strLength + count + ii - 1]) {
					check = 2;
					}
					count++;
					
				} while (check != 1 && check != -1 && count != strLength2 + 1);	
					if (check == 2 || check == 1) {
						if (i != 0) {
						results[arrayLength - n + ii - 1] = i;
						}
						for (int p = 0; p <= strLength2; p++) {
							if (checkArray[arrayLength - p - 1] > firstNumber[arrayLength - n - p + ii - 1]) {
								firstNumber[arrayLength - n - p + ii - 2] = firstNumber[arrayLength - n - p + ii - 2] - 1;				
								firstNumber[arrayLength - n - p + ii - 1] = firstNumber[arrayLength - n - p + ii - 1] + 10;	
							}
							firstNumber[arrayLength - n - p + ii - 1] = firstNumber[arrayLength - n - p + ii - 1] - checkArray[arrayLength - p - 1];
						}
					}
					for (int s = 0; s < arrayLength - 1; s++) {
						checkArray[s] = 0;
					}
			}
		}
		return arrayToString(results);
	}
	
	public static String pow(String firstNumberString, String secondNumberString) {
		int[] firstNumber = changeToArray(firstNumberString);
		int[] secondNumber = changeToArray(secondNumberString);
		int strLength = firstNumberString.length();
		int strLength2 = secondNumberString.length();
		int[] intArray3 = new int[100];
		int[] intResults = new int[100];
		int[] intCompare = new int[100];
		intCompare[intCompare.length - 1] = 1;
		int len;
		int com;
			
			for (int c = 0; c < firstNumber.length; c++) {
				intArray3[c] = firstNumber[c];
			}
			do {
				com = 0;
				len = 0;
				for(int c = 0 ; c < firstNumber.length ; c++) {
					if (intArray3[c] == 0){
						len++;
					} else {
					 break;
					}  
				}
				int dif = firstNumber.length - len;
				for (int c = 0; c < firstNumber.length; c++) {
					intResults[c] = 0;
				}
				for (int i = intArray3.length - 1; i >= intArray3.length - dif; i--) {
					for (int j = firstNumber.length - 1; j >= firstNumber.length - strLength; j--) {
						intResults[(i+j) - firstNumber.length + 1] += intArray3[i] * firstNumber[j];
					}	
				}
				for (int t = intResults.length - 1 ; t > 0 ; t--) {
					if (intResults[t] > 9) {
						intResults[t - 1] = intResults[t - 1] + (intResults[t] / 10);				
						intResults[t] = intResults[t] % 10;	
					}
				}
				for (int c = 0 ; c < firstNumber.length ; c++) {
					intArray3[c] = intResults[c];
				}
				
				intCompare[intCompare.length - 1] = intCompare[intCompare.length - 1] + 1;
				for (int i = intCompare.length -1 ; i > 0 ; i--) {
					if (intCompare[i] > 9) {
						intCompare[i - 1] = intCompare[i - 1] + (intCompare[i] / 10);				
						intCompare[i] = intCompare[i] % 10;	
					}
				}
				
				for (int j = secondNumber.length - 1; j >= 0; j--) {
					if (secondNumber[j] == intCompare[j]) {
					com++;	
					}
				}
			} while(com != 100);	
		
			return arrayToString(intResults);
		}
	}
