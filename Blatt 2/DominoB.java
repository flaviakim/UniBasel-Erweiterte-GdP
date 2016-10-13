public class DominoB {
	
	static int maxNumber = 6;
	static int piecesCount = 0;
	static int rowCount = 0;
	
	public static void main (String[] args) {		
		
		String out = "";
		
		for (int i = 0; i <= maxNumber; i++) {
			// j starts with 0, in the second i-loop, j starts with 1 because (1|0) already exists as (0|1).
			// In the second loop it starts with 2 because (2|0) and (2|1) already exists. And so on.
			for (int j = rowCount; j <= maxNumber; j++) {
				out += "(" + i + "|" + j + ")";
				piecesCount++;
				if (j < maxNumber) {
					out += ", ";
				}
			}
			rowCount++;
			out += "\n";
		}
		
		System.out.println(out);
		System.out.println("Total Domino Pieces: " + piecesCount);
		
	}
	
	
}