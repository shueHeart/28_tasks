import java.util.*;

public class Level1
{
	public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
		while (S1.length() != 0) {
			if (S1.length() < S2.length()) return false;
			
			int indStroke = S1.indexOf(" ");
			String stroke = "";

			if(indStroke != -1) stroke = S1.substring(0, indStroke);
			else stroke = S1.substring(0);
			
			
			String tanks = S2;
			
			String notCheckedArea = S1;
			
			int lastCoordinatesOnArea = -1;
			
			while (tanks.length() != 0) {
				int spaceIndex = notCheckedArea.indexOf(" ");
				String checkingPartOfArea = "";
				
				if(spaceIndex != -1) checkingPartOfArea = notCheckedArea.substring(0, spaceIndex);
				else checkingPartOfArea = notCheckedArea.substring(0);
				
				int spaceTanksIndex = tanks.indexOf(" ");
				String coords = "";
				
				if (spaceTanksIndex != -1) coords = tanks.substring(0, spaceTanksIndex);
				else coords = tanks.substring(0);
				
				List<Integer> tanksCoordinates = findAllIncludes(checkingPartOfArea, coords); 

				boolean included = false;

				
				for (Integer tanksCoordinatesOnArea : tanksCoordinates) {
					if (tanksCoordinatesOnArea == lastCoordinatesOnArea || lastCoordinatesOnArea == -1) {
						lastCoordinatesOnArea = tanksCoordinatesOnArea;
						included = true;
					}
				}

				if (!included) {
					break;
				}

				tanks = tanks.replaceFirst(coords, "");
				tanks = tanks.trim();
				
				notCheckedArea = notCheckedArea.replaceFirst(checkingPartOfArea, "");
				notCheckedArea = notCheckedArea.trim();

			}
			
			if (tanks.length() == 0) { 
				return true;
			}
			else {
				S1 = S1.replaceFirst(stroke, "");
				S1 = S1.trim();
			}
			
		}
		return false;
	}
	
	private static List<Integer> findAllIncludes (String str, String checkStr) {
		char[] charsStr = str.toCharArray();
		
		char[] charsCheckStr = checkStr.toCharArray();
		
		List<Integer> indexes= new ArrayList<Integer>();
		
		for (int i = 0; i < str.length(); ++i) {
			int strIndex = i;
			for (int j = 0; j < checkStr.length(); ++j) {
				if (strIndex + 1 != str.length() && charsStr[strIndex] == charsCheckStr[j]) {
					++strIndex;
				} 
				else {
					break;
				}
				if (j == checkStr.length() - 1) {
					indexes.add(i);
				}
			}
		}
		return indexes;
	}
	
}
