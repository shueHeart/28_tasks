import java.util.*;

public class Level1
{
	
	private static String text = "";
	
	private static String[] history = new String[0];
	
	private static int historyIndex = -1;
	
	public static String BastShoe(String command) {
		
		char numOperation = command.charAt(0);
//		System.out.println("****");
//		for (int i = 0; i < history.length; ++i) {
//			System.out.println(history[i]);
//		}
//		System.out.println("****");
		
		
		switch (numOperation) {
			case '1' : {
				add(command.substring(2), false);
				return text;
			}
			
			case '2' : {
				delete(Integer.parseInt(command.substring(2)), false);
				return text;
			}
			
			case '3' : {
				return get(Integer.parseInt(command.substring(2)));
			}
			
			case '4' : {
				undo();
				return text;
			}
			
			case '5' : {
				redo();
				return text;
			}
		}
		return "here";
		
	}
	
	
	private static void add (String S, boolean onHistory) {
		text += S;
		
		if (!onHistory && historyIndex == history.length - 1) {
			addNewAction(1, S);
			return;
		}
		else if (onHistory) {
			return;
		}
		
		history = new  String[0];
		addNewAction(1, S);
		
	}
	
	private static void delete (int N, boolean onHistory) {
		if (N > text.length()) {
			text = "";
		}
		else {
 
			String reversed = new StringBuilder(text).reverse().toString();
			
			String forDelete = reversed.substring(0, N);
			
		
			
			reversed = reversed.replaceFirst(forDelete, "");
			
			text = new StringBuilder(reversed).reverse().toString();
			
			if (!onHistory && historyIndex == history.length - 1) {
				addNewAction(2, new StringBuilder(forDelete).reverse().toString());
				return;
			}
			else if (onHistory) {
				return;
			}
			
			history = new  String[0];
			addNewAction(2, new StringBuilder(forDelete).reverse().toString());
			
		}
		
	}
	
	private static String get(int i) {
		if (i >= 0 && i < text.length()) return new String(new char[] {text.charAt(i)});
		return "";
	}
	
	private static void undo() {
		if (historyIndex <= -1 || historyIndex > history.length - 1) return;
		String historyFragment = history[historyIndex];
		
		String numOperation = new String(new char[] {historyFragment.charAt(0)});
		
		String word = historyFragment.replaceFirst(numOperation + " ", "");
		
		switch (numOperation) {
			case "1" : {
				delete(word.length(), true);
				--historyIndex;
				break;
			}
			case "2" : {
				add(word, true);
				--historyIndex;
				break;
			}
		}
		
	}
	
	
	private static void redo() {
		++historyIndex;

		if (historyIndex <= -1 || historyIndex > history.length - 1) return;
		
		String historyFragment = history[historyIndex];
		
		String numOperation = new String(new char[] {historyFragment.charAt(0)});
		
		String word = historyFragment.replaceFirst(numOperation + " ", "");

		switch (numOperation) {
			case "1" : {
				add(word, true);
				break;
			}
			case "2" : {
				delete(word.length(), true);
				break;
			}	
		}

	}
	
	
	private static void addNewAction (int action, String word) {
		String[] newHistory = new String[history.length + 1];
		
		for (int i = 0; i < history.length; ++i) {
			newHistory[i] = history[i]; 
		}
		
		newHistory[history.length] = action + " " + word;
		historyIndex = history.length;
		history = newHistory;
	}
}
