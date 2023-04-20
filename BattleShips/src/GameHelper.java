import java.io.*;
import java.util.*;

public class GameHelper {
	private static final String alphabet = "abcdefg";
	private int gridLength = 7;
	private int gridSize = 49;
	private int[] grid = new int[gridSize];
	private int battleShipCount = 0;
	
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + " ");
		try {
			BufferedReader ie = new BufferedReader(
					new InputStreamReader(System.in));
			inputLine = ie.readLine();
			if (inputLine.length() == 0) return null;
			} catch (IOException e) {
				System.out.println("IOException: " + e);
			}
		return inputLine.toLowerCase();
	}
	
	public ArrayList<String> placeBattleShip(int battleShipSize) {
		ArrayList<String> alphaCells = new ArrayList<String>();
		String[] alphaCoOrds = new String [battleShipSize];
		String temp = null;
		int[] coOrds = new int[battleShipSize];
		int attempts = 0;
		boolean success = false;
		int location = 0;
		
		battleShipCount++;
		int incr = 1;
		if ((battleShipCount % 2 ) == 1) {
			incr = gridLength;
		}
		
		while ( !success & attempts++ < 200) {
			location = (int) (Math.random() * gridSize);
			int x = 0;
			success = true;
			while (success && x < battleShipSize) {
				if (grid[location] == 0) {
					coOrds[x++] = location;
					location += incr;
					if (location >= gridSize) {
						success = false;
					}
					if ( x>0 && (location % gridLength == 0 )) {
						success = false;
					}
				} else {
					success = false;
				}
			}
		}
		
		int x = 0;
		int row = 0;
		int column = 0;
		while (x < battleShipSize) {
			grid[coOrds[x]] = 1;
			row = (int) (coOrds[x] / gridLength);
			column = coOrds[x] % gridLength;
			temp = String.valueOf(alphabet.charAt(column));
			
			alphaCells.add(temp.concat(Integer.toString(row+1)));
			x++;
		}
		
		return alphaCells;
	}
}
