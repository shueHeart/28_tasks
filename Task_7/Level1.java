import java.util.*;

public class Level1
{
	public static int [] WordSearch (int len, String s, String subs) {
		List<String> extractedStrings = new ArrayList<String>();
		s = s.replace(")", ";");
		subs = subs.replace(")", ";");
		
		while (s.length() != 0) {
			s = s.trim();
			String extractedString = "";
			while (extractedString.length() < len) {
				int firstSpaceIndex = s.indexOf(" ");
				String space = "";		
				if (firstSpaceIndex != -1) {
					space = s.substring(0, firstSpaceIndex);
					if(space.length() + extractedString.length() + 1 <= len ) {
						s = s.replaceFirst(space + " ", "");

						if (extractedString.length() != 0) {
							extractedString += " " + space;
						} else {
							extractedString += space;
						}
					}else if(space.length() + extractedString.length() + 1 > len) {
						if (extractedString.length() == 0) {
							space = s.substring(0, len);
							s = s.replaceFirst(space, "");
							extractedString += space;
							break;
						}
							
						break;
					}
				} else {
					if (extractedString.length() == 0) {
						if (s.length() <= len) {
							space = s.substring(0, s.length());
							s = s.replaceFirst(space, "");
							extractedString += space;
						} else {
							space = s.substring(0, len);
							s = s.replaceFirst(space, "");
							extractedString += space;
						}
					}
					break;
				}					
			}
			
			extractedString = extractedString.trim();
			if(extractedString != " ") extractedStrings.add(extractedString);			
		}
		int[] yesOrNot = new int[extractedStrings.size()];
		for(int i = 0; i < extractedStrings.size(); ++i) {
			String extracted = extractedStrings.get(i);
			yesOrNot[i] = 0;
			while(extracted.length() != 0) {
				int index = extracted.indexOf(" ");
				if (index != -1) {
					String checking = extracted.substring(0, index);
					if (checking.equals(subs)) {
						yesOrNot[i] = 1;
					}
					extracted = extracted.replaceFirst(checking + " ", "");
				} else {
					if(extracted.equals(subs)) {
						yesOrNot[i] = 1;
					}
					extracted = extracted.replaceFirst(extracted, "");
					break;
				}
			}
		}
		return yesOrNot;
	}

}
