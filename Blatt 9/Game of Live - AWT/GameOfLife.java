import java.util.Random;

public class GameOfLife {
	
	// PROPERTIES
	
	boolean[][] population;
	
	int size;
	public int getSize() { return size; }
	
	
	// INITIALIZER
	
	public GameOfLife (int size) {
		this.size = size;
		population = new boolean[size][size];
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (r.nextInt(100) < 30) population[i][j] = true;
			}
		}
	}
	
	public GameOfLife () {
		size = 6;
		population = new boolean[size][size];
		population[1][1] = true;
		population[1][3] = true;
		population[2][2] = true;
		population[2][3] = true;
		population[3][2] = true;
	}
	
	
	// METHODS
	
	public boolean getFieldAt(int x, int y) {
		// If the variables are out of bounds bring them back in so we don't have to worry
		// about the bounds when checking the neighbours.
		while (x < 0) 		{ x += size; }
		while (x >= size) 	{ x -= size; }
		while (y < 0) 		{ y += size; }
		while (y >= size) 	{ y -= size; }
		
		return population[x][y];
	}
	
	public int countNeighbours(int x, int y) {
		int neighbours = 0;
		
		// Count every neighbouring cell if it is alive. (the getFieldAt() Method should
		// take care of the case that the cell is at the edge of the field.
		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				if (getFieldAt(i,j)) neighbours++;
			}
		}
		
		// We also counted the cell itself, which isn't actually a neighbour.
		// To fix this we should subtract one if the cell is alive.
		if (getFieldAt(x,y)) neighbours--;
		
		// For bugfinding 
		// System.out.println("Neighbours for (" + x + ", " + y + "): " + neighbours );
		
		return neighbours;
	}
	
	/**
	 * Updates the Game according to the rules and returns true if it changed,
	 * false if the game stayed the same after the update.
	 */
	public boolean update() {
		// We have to save it first in a new array so we can check every cell and
		// set them accordingly in the newPopulation.
		boolean[][] newPopulation = new boolean[size][size];
		
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (countNeighbours(x,y) == 3 || (population[x][y] && countNeighbours(x,y) == 2)) {
					newPopulation[x][y] = true;
				} else {
					newPopulation[x][y] = false;
				}
			}
		}
		
		boolean isDifferent = GameOfLife.isDifferent(population, newPopulation);
		population = newPopulation;
		return isDifferent;
	}
	
	public String toString() {
		String out = "";
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (population[x][y]) {
					out += "@";
				} else {
					out += ".";
				}
			}
			out += "\n";
		}
		return out;
	}
	
	public static boolean isDifferent(boolean[][] populationA, boolean[][] populationB) {
		if (populationA.length != populationB.length) return true;
		for (int x = 0; x < populationA.length; x++) {
			for (int y = 0; y < populationA.length; y++) {
				if (populationA[x][y] != populationB[x][y]) return true;
			}
		}
		return false;
	}
	
}






