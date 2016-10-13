public class Welcome {
	
	/* This is the main Method which get's called when we run the class with the command 
	java Welcome <Name>
	We get the class file from compiling this Welcome.java file with
	javac Welcome.java */
	public static void main (String[] args) {
		
		// This prints the Message and takes the first argument args[0] as the name
		System.out.println ("Hallo " + args[0] + "!");
		
	}
	
}