public class Bin2Dec {
	
	public static void main (String[] args) {
		
		// If the user forgot to enter an argument we print an error message.
		if (args.length < 1) {
			// ERROR: The user didn't enter an argument
			System.out.println("Please enter an argument!");
			return;
		}
		
		// The decimal number we want to print out.
		int dec = 0;
		
		// The number of digits in our binary number
		int i = 1;
		
		// We go through every argument with x but from last to first.
		// Beware: if args.length is 4 the first argument is 3. Therefore we have to start with args.length-1
		for (int x = args.length - 1; x >= 0; x--) {
			dec += Integer.parseInt(args[x]) * i;
			i *= 2;
		}
		System.out.println(dec);
		
	}
		
}