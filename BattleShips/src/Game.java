import java.util.ArrayList;

public class Game {
	public static void main(String[] args) {
		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();
		DotCom theDotCom = new DotCom();
		int randomNum = (int) (Math.random()*5);
		
		ArrayList<String> locations = new ArrayList<String>();
		locations.add(String.valueOf(randomNum));
		locations.add(String.valueOf(randomNum + 1));
		locations.add(String.valueOf(randomNum + 2));
		
		theDotCom.setLocationCells(locations);
		boolean isAlive = true;
		
		while(isAlive) {
			String guess = helper.getUserInput("enter a number");
			String result = theDotCom.checkYourSelf(guess);
			numOfGuesses++;
			
			if (result.equals("kill")) {
				isAlive = false;
				System.out.println("you took " + numOfGuesses + " guesses");
			}
		}
	}

}
