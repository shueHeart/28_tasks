import java.util.*;

public class Level1
{
	
	public static String BiggerGreater(String input) {
		char[] inputed = input.toCharArray();

		int minIndex = -1;
		
		int localMaxIndex = -1;
		
		for (int i = 0; i < input.length(); ++i) {
			
			String check = new String(new char[] {inputed[i]});

			boolean newMin = false;
					
			char localMaxSymbol = '1';
			
			for (int j = i; j < input.length(); ++j) {
				
				String checking = new String(new char[] {inputed[j]});
				
				if (check.compareTo(checking) < 0 && (localMaxSymbol == '1' || checking.compareTo(new String (new char[] {localMaxSymbol})) < 0) ) {
					
					localMaxIndex = j;
					localMaxSymbol = inputed[j];
									
					newMin = true;
					
				}
			
			}

			if (newMin) {
				minIndex = i;
			}
			
		}
			
		if (localMaxIndex == -1 || minIndex == -1) return "";
		
		char buffer = inputed[minIndex];
		inputed[minIndex] = inputed[localMaxIndex];
		inputed[localMaxIndex] = buffer;
		
		for (int i = minIndex + 1; i < input.length(); ++i) {
			
			String check = new String(new char[] {inputed[i]});
			
			for (int j = minIndex + 1; j < input.length(); ++j) {
				
				String checking = new String(new char[] {inputed[j]});
				
				if (check.compareTo(checking) < 0) {
					char buf = inputed[i];
					inputed[i] = inputed[j];
					inputed[j] = buf;
				}
			}
		}
		
		String ready = new String(inputed);
		
		if (ready.compareTo(input) != 0) return ready;
		else return "";
	}

}
