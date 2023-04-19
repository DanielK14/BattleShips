import java.util.ArrayList;

public class BattleShip {
	
	private ArrayList<String> locationCells;
	private String shipName;
	int numOfHits = 0;
	
	public void setLocationCells(ArrayList<String> locs) {
		locationCells = locs;
	}
	
	public void setName(String name) {
		shipName = name;
	}
	
	public String checkYourSelf(String userInput) {
		String result = "miss";
		int index = locationCells.indexOf(userInput);
		
		if (index >= 0) {
			locationCells.remove(index);
			
			if (locationCells.isEmpty()) {
				result = "kill";
				System.out.println("Killing blow! You destroyed " + shipName);
			} else {
				result = "hit";
			}
		}
		return result;
	}
}
