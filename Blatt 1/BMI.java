public class BMI {
	
	// reminder: bmi is a really old measurement and doesn't say anything about your health!
	public static void main (String[] args) {
		
		// the first argument is the height (IN CENTIMETERS!)
		double heightCM = Integer.parseInt(args[0]);
		// the second is the weight in kg
		double weight = Integer.parseInt(args[1]);
		// calculate the height to meters
		double height = heightCM / 100;
		// calculate the BMI
		double bmi = weight / (height * height);
		
		// print out the first line
		System.out.println("Ihr BMI beträgt: " + bmi);
		
		String secondLine;
		
		if (bmi > 25) {
			secondLine = "Ihr BMI ist über 25.";
		} else if (bmi < 20) {
			secondLine = "Sie haben einen BMI unter 20.";
		} else {
			secondLine = "Sie haben einen BMI zwischen 20 und 25.";
		}
		
		// print out the second line
		System.out.println(secondLine);
		
	}
	
}