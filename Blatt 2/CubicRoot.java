public class CubicRoot {
	
	public static void main(String[] args) {
		
		double a = Double.parseDouble(args[0]);
		double xn = 1.0;
		double xn1 = 1.0;
		
				
		do {
			xn = xn1;
			xn1 = 1.0/3.0 * (2*xn + a/(xn*xn));
			System.out.println(xn1);
		}
		while (Math.abs(xn - xn1) > 0.00000001);
		
		
		
		/*
		//alternative version
		while(true) {
			xn1 = 1.0/3.0 * (2*xn + a/(xn*xn));
			System.out.println(xn1);
			if (Math.abs(xn - xn1) <= 0.00000001) return;
			xn = xn1;
		}
		*/	
	}
	
}