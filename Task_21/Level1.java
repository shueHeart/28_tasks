import java.util.*;

public class Level1
{
	public static String BiggerGreater(String input) {
	
		char[] inputed = input.toCharArray();
		
		char minForReplace = input.charAt(0);
		int minIndexReplace = -1;
		
		char maxForReplace = input.charAt(0);
		int maxIndexReplace = -1;
		
		int different = 10000;
		
		for (int i = 0; i < input.length(); ++i) {
			String check = new String (new char[] {minForReplace});
			String checking = new String (new char[] {input.charAt(i)});
			
			if (check.compareTo(checking) >= 0) { 
				minForReplace = checking.charAt(0);
				minIndexReplace = i;
			}
		}
		
		for (int i = minIndexReplace; i < input.length(); ++i) {
			String check = new String(new char[] {maxForReplace});
			String checking = new String(new char[] {input.charAt(i)});
			String min = new String(new char[] {minForReplace});

			if (check.compareTo(checking) <= 0 && min.compareTo(checking) < different) {
				different = min.compareTo(check);
				maxForReplace = checking.charAt(0);
				maxIndexReplace = i;
			}
		}
		
		if (maxIndexReplace != -1 && minIndexReplace != -1) {
			char buffer = inputed[minIndexReplace];
			inputed[minIndexReplace] = inputed[maxIndexReplace];
			inputed[maxIndexReplace] = buffer;
			
			for (int i = minIndexReplace + 1; i < input.length(); ++i) {
				String check = new String(new char[] {inputed[i]});
				
				for (int j = minIndexReplace + 1; j < input.length(); ++j) {
					String checking = new String(new char[] {inputed[j]});
					if (check.compareTo(checking) < 0) {
						char buf = inputed[i];
						inputed[i] = inputed[j];
						inputed[j] = buf;
					}
				}
			}
		}
		
		String ready = new String(inputed);
		
		if (ready.compareTo(input) != 0) return ready;
		else return "";
		
	}
}