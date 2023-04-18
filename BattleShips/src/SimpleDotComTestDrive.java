import java.util.ArrayList;

public class SimpleDotComTestDrive {
	
	public static void main (String[] args) {
		DotCom dot = new DotCom();
		ArrayList<String> locations = new ArrayList<String>();
		locations.add("2");
		locations.add("3");
		locations.add("4");
		dot.setLocationCells(locations);
		
		String userGuess = "2";
		String result = dot.checkYourSelf(userGuess);
		String testResult = "failed";
		
		if (result.equals("hit")) {
			testResult = "passed";
		}
		
		System.out.println(testResult);
	}
}
