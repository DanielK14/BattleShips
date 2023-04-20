import java.util.*;

public class BattleShipBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<BattleShip> battleShipsList = new ArrayList<BattleShip>();
	private int numOfGuesses = 0;
	
	private void setUpGame() {
		BattleShip one = new BattleShip();
		one.setName("Normandy");
		BattleShip two = new BattleShip();
		two.setName("Pillar of Autumn");
		BattleShip three = new BattleShip();
		three.setName("Leviathan");
		battleShipsList.add(one);
		battleShipsList.add(two);
		battleShipsList.add(three);
		
		System.out.println("Your goal is to sink three battle ships.");
		System.out.println("The Normandy, the Pillar of Autumn and the Leviathan.");
		System.out.println("Try to sink them all in the fewest number of guesses, note the coordinates range from a1 to g7");
		
		for (BattleShip battleShipToSet : battleShipsList ) {
			ArrayList<String> newLocation = helper.placeBattleShip(3);
			battleShipToSet.setLocationCells(newLocation);
		}
	}
	
	private void startPlaying() {
		while (!battleShipsList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "miss";
		
		for (BattleShip battleShipToTest : battleShipsList) {
			result = battleShipToTest.checkYourSelf(userGuess);
			if (result.equals("hit")) {
				break;
			}
			if (result.equals("kill")) {
				battleShipsList.remove(battleShipToTest);
				break;
			}
		}
		System.out.println(result);
	}
	
	private void finishGame() {
		System.out.println("All battle ships have been destroyed. You are victorious.");
		if (numOfGuesses <= 18) {
			System.out.println("it only took you " + numOfGuesses + " guesses.");
			System.out.println(" You got out before any of you ships where destroyed.");
		} else {
			System.out.println("You took too long.");
			System.out.println("With " + numOfGuesses + " guesses you suffered heavy losses.");
		}
	}
	
	public static void main (String[] args) {
		BattleShipBust game = new BattleShipBust();
		game.setUpGame();
		game.startPlaying();
	}
}
