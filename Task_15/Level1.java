import java.util.*;

public class Level1
{
	public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
		while (S1.length() != 0) {

			
			int indStroke = S1.indexOf(" ");
			String stroke = "";

			if(indStroke != -1) stroke = S1.substring(0, indStroke);
			else stroke = S1.substring(0);
			
			String tanks = S2;
			
			while (tanks.length() != 0) {
				int index = tanks.indexOf(" ");
				
				String tank = "";
				
				if (index != -1) tank = tanks.substring(0, index);
				else tank = tanks.substring(0);
				
				if (stroke.contains(tank)) {
					S2 = S2.replaceFirst(tank, "");
					S2 = S2.trim();
				}
				tanks = tanks.replaceFirst(tank, "");
				tanks = tanks.trim();
				
			}
			
			S1 = S1.replaceFirst(stroke, "");
			S1 = S1.trim();
			if (S2.length() == 0) return true;
		}
		if (S2.length() == 0) return true;
		else return false;
	}
}
