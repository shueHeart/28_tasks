import java.util.*;

public class Level1
{
	
	public static String Keymaker(int k) {
		
		boolean[] doors = new boolean[k];
		
		for (int i = 0; i < k; ++i) {
			doors[i] = false;
		}
		
		for (int i = 1; i < k + 1; ++i) {
			for (int j = -1 + i; j < k; j += i) {
				doors[j] = !doors[j];
			}
		}
		
		String finalDoors = "";
		
		for (int i = 0; i < k; ++i) {
			if (doors[i]) {
				finalDoors += "1";
				continue;
			}
			
			finalDoors += "0";
		}
		
		return finalDoors;
		
	}
	
}