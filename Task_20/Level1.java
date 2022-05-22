import java.util.*;

public class Level1
{
	
	private static String text = "";
	
	private static String completedCommands = "";
	
	
	public static String BastShoe(String command) {
		
		char numOperation = command.charAt(0);
		
		switch (numOperation) {
			case '1' : {
				add(command.substring(2));
				return text;
			}
			
			case '2' : {
				delete(Integer.parseInt(command.substring(2)));
				return text;
			}
			
			case '3' : {
				return get(Integer.parseInt(command.substring(2)));
			}
			
			case '4' : {
				
			}
			
			case '5' : {
				
			}
		}
		return "here";
		
	}
	
	
	private static void add (String S) {
		text += S;
		completedCommands += "1 " + S + " ";
	}
	
	private static void delete (int N) {
		if (N > text.length()) {
			text = "";
		}
		else {
 
			String reversed = new StringBuilder(text).reverse().toString();
			
			String forDelete = reversed.substring(0, N);
			
			reversed = reversed.replaceFirst(forDelete, "");
			
			text = new StringBuilder(reversed).reverse().toString();
			
			completedCommands += "2 " + new StringBuilder(forDelete).reverse().toString() + " ";
		}
		
	}
	
	private static String get(int i) {
		if (i >= 0 && i < text.length()) return new String(new char[] {text.charAt(i)});
		return "";
	}
	
	private static void undo() {
		
	}
}