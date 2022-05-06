import java.util.*;

public class Level1
{
		public static String BigMinus (String s1, String s2) {
		if (s2.length() > s1.length()) {
			String buf = s1;
			s1 = s2;
			s2 = buf;
		}else if (s2.length()  == s1.length()) {
			for (int i = 0; i < s1.length(); ++i) {
				if (Integer.parseInt(s2.charAt(i) + "") > Integer.parseInt(s1.charAt(i) + "")) {
					String buf = s1;
					s1 = s2;
					s2 = buf;
					break;
				}
			}
		}
		
		String result = "";
		
		int lengthDif = s1.length() - s2.length();
		for (int i = 0; i < lengthDif; ++i) {
			s2 = "0" + s2;
		}
		for (int i = s1.length() - 1; i >= 0; --i) {

			int numFromS1 = Integer.parseInt(s1.charAt(i) + "");
			int numFromS2 = Integer.parseInt(s2.charAt(i) + "");
			
			int localResult = numFromS1 - numFromS2;

			if (localResult >= 0) {
				result = localResult + "" + result;
			}
			else {
				for (int j = i - 1; j >= 0; --j) {
					int nextNum = Integer.parseInt(s1.charAt(j) + "");
					 
					if (nextNum > 0) {
						char[] stringChars = s1.toCharArray();
						--nextNum;
						String nnChar = "";
						nnChar = nextNum + "";
						stringChars[j] = nnChar.toCharArray()[0];
						s1 = new String(stringChars);
						break;
					}
					else { 
						char[] stringChars = s1.toCharArray();
						stringChars[j] = '9'; 
						s1 = new String(stringChars);
					}
				}
				
				localResult += 10;
				result = localResult + "" + result;
			}
		}
		while (result.length() > 1 && result.indexOf("0") == 0  ) {
			result = result.replaceFirst("0", "");
		}
		return result;	
	}


}
