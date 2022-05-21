import java.util.*;

public class Level1
{
	public static String [] ShopOLAP(int N, String [] items) {
		int count = 0;
		for (int i = 0; i < N; ++i) {
			if (items[i].equals("")) continue;
			
			++count;
			
			String name = items[i].substring(0, items[i].indexOf(" "));
			int nums =  Integer.parseInt(items[i].replace(items[i].substring(0, items[i].indexOf(" ")) + " ", ""));
			
			for (int j = 0; j < N; ++j) {
				if (items[j].equals("")) continue; 

				String nameSorting = items[j].substring(0, items[j].indexOf(" "));
				int numsSorting =  Integer.parseInt(items[j].replace(items[j].substring(0, items[j].indexOf(" ")) + " ", ""));	
				
				if (name.equals(nameSorting) && j != i) {
					nums += numsSorting;
					items[i] = name + " " + nums;
					items[j] = "";
				}

			}
		}
		
		for (int i = 0; i < N; ++i) {
			if (items[i].equals("")) continue;
			
			int nums =  Integer.parseInt(items[i].replace(items[i].substring(0, items[i].indexOf(" ")) + " ", ""));
			
			for (int j = 0; j < N; ++j) {
				if (items[j].equals("")) continue; 

				int numsSorting =  Integer.parseInt(items[j].replace(items[j].substring(0, items[j].indexOf(" ")) + " ", ""));	
				
				if (numsSorting < nums) {
					String buf = items[i];
					items[i] = items[j];
					items[j] = buf;
				}
			}
		}
		
		for (int i = 0; i < N; ++i) {
			if (items[i].equals("")) continue;
			
			
			String name = items[i].substring(0, items[i].indexOf(" "));
			int nums =  Integer.parseInt(items[i].replace(items[i].substring(0, items[i].indexOf(" ")) + " ", ""));
			
			for (int j = 0; j < N; ++j) {
				if (items[j].equals("")) continue; 

				String nameSorting = items[j].substring(0, items[j].indexOf(" "));
				int numsSorting =  Integer.parseInt(items[j].replace(items[j].substring(0, items[j].indexOf(" ")) + " ", ""));	
				
				if (nums == numsSorting && name.compareTo(nameSorting) < 0) {
					String buf = items[i];
					items[i] = items[j];
					items[j] = buf;
				}
			}
		}
		
		String[] sorted = new String[count];
		--N;

		for (int i = count - 1; i >= 0;) {
			if (items[N] != "") {
				sorted[i] = items[N];
				--i;
			}
			--N;
		}
		return sorted;
	}
}