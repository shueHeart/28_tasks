import java.util.*;

public class Level1
{
	
	public static boolean SherlockValidString(String s) {
		
		char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'v', 'x', 'y', 'z'};
		
		int lastNum = 0;
		
		boolean deleteAlready = false;
		
		for (int i = 0; i < alphabet.length; ++i) {
			
			int prevLength = s.length();
			
			s = s.replaceAll(new String(new char[] {alphabet[i]}), "");
			int newNum = prevLength - s.length();
			
			if (newNum == 0) continue;
			
			if (lastNum == 0) {
				lastNum = newNum;
				continue;
			}
			
			if (Math.abs(lastNum - newNum) == 1) deleteAlready = true;
			else if (Math.abs(lastNum - newNum) > 1) return false;
			else if (deleteAlready) return false;
			
			lastNum = newNum;
		}
		
		return true;
	}	
}