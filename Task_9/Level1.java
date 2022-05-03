import java.util.*;

public class Level1
{
	public static String TheRabbitsFoot (String s, boolean encode) {
		String withoutSpaces = s.replace(" ", "");
		
		char[] forMatrix= withoutSpaces.toCharArray();
		
		float sqrt = Float.parseFloat(Double.toString(Math.sqrt(forMatrix.length)));
		
		int column = Math.round(sqrt);		
		int stroke = column - 1;
		
		if (!encode) {
			char[][] uncipher;
			

			if (forMatrix.length <= stroke * column) {
				uncipher = new char[stroke][column];
			} else {
				++stroke;
				uncipher = new char[stroke][column];
			}
			
			for (int i = 0; i < stroke; ++i) {
				for (int j = 0; j < column; ++j) {
					uncipher[i][j] = ' ';
				}
			}
			
			for (int i = 0; i < stroke; ++i) {
				int spaceIndex = s.indexOf(" ");
				String word = "";
				if(spaceIndex != -1) word = s.substring(0, spaceIndex);
				else word = s;
				s = s.replace(word + " ", "");
				for (int j = 0; j < word.length(); ++j) {
					uncipher[i][j] = word.charAt(j);
				}
			}
			String unciphered = "";
			for (int i = 0; i < column; ++i) {
				for (int j = 0; j < stroke; ++j) {			
					if (uncipher[j][i] != ' ') {
						unciphered += uncipher[j][i];
					} else {
						break;
					}
				}
			}
			return unciphered;
		}
		
		char[][] cipher;
		
		if (forMatrix.length <= stroke * column) {
			cipher = new char[stroke][column];
		} else {
			++stroke;
			cipher = new char[stroke][column];
		}
		
		for (int i = 0; i < stroke; ++i) {
			for (int j = 0; j < column; ++j) {
				cipher[i][j] = ' ';
			}
		}
		
		int count = 0;
		for (int i = 0; i < stroke; ++i) {
			for (int j = 0; j < column; ++j) {
				if (count < forMatrix.length) {
					cipher[i][j] = forMatrix[count]; 
					++count;
				} else break; 
			}
		}
		
		String ciphered = ""; 
		for (int i = 0; i < column; ++i) {
			for (int j = 0; j < stroke; ++j) {			
				if (cipher[j][i] != ' ') {
					ciphered += cipher[j][i];
				} else {
					break;
				}
			}
			ciphered += " ";
		}
		ciphered.trim();
		return ciphered;	
	}
}