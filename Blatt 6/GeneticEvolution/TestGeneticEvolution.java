/**
 * Test the genetic evolution of genes in a pool.
 */
public class TestGeneticEvolution {

	/**
	* Tests how many mutations are needed until the genom of the species
	* is found in the genpool.
	* 
	* @param species Species that should be present in the pool.
	* @return Returns the needed number of mutations so that genom of the species appeares in the genpool. 
	*/
	public static int mutateTo(GenPool pool, Genom species) {
	
		int count = 0;
		
		while (pool.contains(species) == false) {
			pool.mutate();
			count++;
			if (count > 1000) {
				System.out.println("\nERROR Infinite loop! -- \nspecies: " + species.toString() + "\npool:\n" + pool.toString());
				return count;
			}
		}
		return count;
	}
	

	/**
	* Main program that does not take any argument.
	* 
	* @param args Not used.
	*/
	public static void main( String[] args ) {
		
		int len = 5;
		int poolSize = 1000;
		int years = 0;
		System.out.println("An examplar human genom in our model is:\n"+new Genom(len));
		System.out.println("An examplar small genpool in our model is:\n"+new GenPool(5,len));
		System.out.println("Starting simulation ...");
		for( int i=0; i<1000; ++i) {
			Genom species = new Genom(len);
			GenPool pool = new GenPool(poolSize, len);
			int year = mutateTo(pool, species);
			years += year;
		}
		System.out.println("Needed "+years/1000.0+" in average.");
		
	}
}
