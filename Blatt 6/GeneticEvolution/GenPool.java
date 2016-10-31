import java.util.Random;

/**
 * A simple GenPool.
 * 
 * The genpool holds multiple genoms. It has a method to check if
 * a specific genom exists and offers a function to mutate all genoms
 * once.
 */
public class GenPool {
    
    Genom[] genoms;
        
    /**
     * Generate n genoms with a random length in the interval 1 - len.
     * 
     * @param n Number of genoms in the genpool.
     * @param len Maximal length of a genom when initializing. (Minimal length is 1.)
     */
    GenPool( int n, int len ) {
    	if (n < 1) n = 1;
    	
    	genoms = new Genom[n];
    	randomize(len);
    }


    /**
     * Returns all the genoms from the genpool as array.
     *
     * @return Array containing all genoms currently in this pool.
     */
    public Genom[] getGenPool() {
        return genoms;
    }
    
    /**
     * Randomly fills the genpool.
     * 
     * @param len Maximal length of a genom when initializing. (Minimal length is 1.)
     */
    private void randomize(int len) {
    	if (len < 1) len = 1;
    	
    	Random r = new Random();
    	for (int i = 0; i < genoms.length; i++) {
    		genoms[i] = new Genom(r.nextInt(len) + 1); // +1 damit die Zahl im Bereich [1, len] ist, statt [0, len)
    	}
    }
    
    /**
     * Checks if a specific genom exists in the genpool.
     * @param other Genom to search for.
     * @return Returns true if the genom other is found in the genpool.
     */
    public boolean contains(Genom other) {
    	for (int i = 0; i < genoms.length; i++) {
    		if (genoms[i].isEqual(other)) {
    			return true;
    		}
    	}
        return false;
    }
    
    /**
     * Performs one mutation for every genom in the pool.
     */
    public void mutate() {
    	Random r = new Random();
        for (int i = 0; i < genoms.length; i++) {
        	switch (r.nextInt(3)) {
        		case 0:
        			genoms[i].pointMutation();
        			break;
        		case 1:
        			genoms[i].insertion();
        			break;
        		case 2:
        			genoms[i].deletion();
        			break;
        		default:
        			System.out.println("ERROR GenPool::mutate");
        			break;
        	}
        	
        }
    }
    
    /**
     * Returns all gens from the pool on a single line.
     */
    public String toString() {
    	String out = "";
    	
    	for (int i = 0; i < genoms.length; i++) {
    		out += genoms[i].toString();
    		out += "\n";
    	}
    	
        return out;
    }

}
