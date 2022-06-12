import java.util.*;

public class Level1
{
	public static boolean WhiteWalkers (String village) {
		
		boolean firstWalkersFounded = false;
		
		int lastVillager = 0;
		
		int whiteWalkersCount = 0;
		
		
		for (int i = 0; i < village.length(); ++i) {
			int obj = village.charAt(i);
		
			if (obj >= 48 && obj <= 57 && lastVillager == 0) {
				
				lastVillager = Integer.parseInt(village.substring(i, i + 1));
				continue;
				
			}
			
			if ((obj >= 48 && obj <= 57) && lastVillager + Integer.parseInt(village.substring(i, i + 1)) == 10 && whiteWalkersCount == 3) {
				
				lastVillager = Integer.parseInt(village.substring(i, i + 1));
				
				whiteWalkersCount = 0;
				
				firstWalkersFounded = true;
				
				continue;
				
			}
					
			if (obj >= 48 && obj <= 57 && lastVillager + Integer.parseInt(village.substring(i, i + 1)) == 10 && whiteWalkersCount != 3) return false;
			
			if (obj >= 48 && obj <= 57 && lastVillager + Integer.parseInt(village.substring(i, i + 1)) != 10) {
				
				whiteWalkersCount = 0;
				continue; 
			}
			
			if (obj == 61) ++whiteWalkersCount;
			
		}
		
		return firstWalkersFounded;
	}
}