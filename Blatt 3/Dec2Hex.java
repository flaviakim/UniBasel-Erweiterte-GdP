public class Dec2Hex {
	
	public static void main (String[] args) {
		
		// If the user forgot to enter an argument we print an error message.
		if (args.length < 1) {
			// ERROR: The user didn't enter an argument
			System.out.println("Please enter an argument!");
			return;
		}
		
		// We get our decimal number to be converted
		int dec = Integer.parseInt(args[0]);
		
		// We check if it is positive, otherwise we end the program with an error message.
		if (dec < 0) {
			// ERROR: negative number entered
			System.out.println("Please enter a positive number!");
			return;
		}
		
		// If it is 0 we just print it out directly and end the program.
		if (dec == 0) {
			System.out.println("0x0");
			return;
		}
		
		// Now we now the user entered a valid number which is bigger than 0. Now the actual calculations begin.
		
		// This is the string where we add digits and which we print out at the end.
		String hex = "0x";
		
		// First we find out how many digits there are in our hex number.
		// i tells us how many iterations we already did.
		int i = 0;
		// x is just a helper variable for the while statement to know when to end the loop.
		int x;
		
		do {
			// We start with i == 1 and go up by 1 every cycle.
			i++;
			// We divide the dec first by 16^1, then by 16^2 and so on until the result is 0 (16^i fits 0 times into dec).
			// The first i that generated a result == 0 is the number of digits in our hex number.
			x = dec / get16ToThePowerOf(i);
			
		} while (x > 0);
		
		// We know 16^i doesn't fit into our dec at all (because dec / 16^i resulted in 0). Therefore we can already go down one.
		i--;
		
		
		// Go downwards for every 16^i we calculated
		for (; i >= 0; i--) {
			// See how many times 16^i fits inside our dec
			int  digit = dec / get16ToThePowerOf(i);
			// Add the appropriate digit to our hex
			switch (digit) {
				case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
					hex += digit;
					break;
				case 10:
					hex += "A";
					break;
				case 11:
					hex += "B";
					break;
				case 12:
					hex += "C";
					break;
				case 13:
					hex += "D";
					break;
				case 14:
					hex += "E";
					break;
				case 15:
					hex += "F";
					break;
				default:
					System.out.println("ERROR: Our digit: " + digit + " is not between 0 and 15");
			}
			// Now we only need the remaining rest of our dec for the next smaller 16^i
			dec = dec % get16ToThePowerOf(i);
		}
		
		// Now our hex String should be correct. Print it out
		System.out.println(hex);
		
	}
	
	
	
	/**
	 * This calculates 16^x (16 "hoch" x)
	 **/
	public static int get16ToThePowerOf(int x) {
		if (x < 0) {
			// ERROR: We don't use negative x's
			return 0;
		}
		if (x == 0) {
			// This always results in 1
			return 1;
		}
		
		int res = 16;
		
		for (int i = 1; i < x; i++) {
			 res *= 16;
		}
		return res;
	}
	
}