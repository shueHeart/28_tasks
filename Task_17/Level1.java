import java.util.*;

public class Level1
{
	
	public static boolean LineAnalysis(String line) {
		
		int stars = 0;
		
		int points = 0;
		
		int lastStars = 0;
		
		int lastPoints = 0;
		
		line = line.replace("*", "a");
		line = line.replace(".", "b");
		
		while (line != "" && line.charAt(0) == 'a') {
			++lastStars;
			line = line.replaceFirst("a", "");
		}
		while (line != "" && line.charAt(0) == 'b') {
			++lastPoints;
			line = line.replaceFirst("b", "");
		}
		if (line == "") return true;
		for (int i = 0; i < line.length(); ++i) {
			if (line.charAt(i) == 'a') {
				++stars;
				if (points != 0 && points != lastPoints) {
					return false;
				}
				points = 0;
			}	
			
			else if (line.charAt(i) == 'b') {
				++points;
				if (stars != 0 && stars != lastStars) {
					return false;
				}
				stars = 0;
			}
		}
		if (stars == lastStars) return true;
		else return false;
		
		
	}

	
}