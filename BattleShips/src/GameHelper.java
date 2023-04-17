import java.io.*;
public class GameHelper {
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
		return inputLine;
	}
}
