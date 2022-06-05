import java.util.*;

public class Level1
{
	
	public static String[] TreeOfLife(int W, int H, int N, String[] tree) {
		
		for (int i = 0; i < W; ++i) {
			tree[i] = tree[i].replace(".", "0");
			tree[i] = tree[i].replace("+", "1");
		}
		
		boolean evenYear = true;
			
		for (int i = 0; i < N; ++i) {
			tree = aging(tree);
			
			if (evenYear) {
				evenYear = !evenYear;
				continue;
			}
				
			String[] death = mustDeath(tree);
							
			for (int j = 0; j < death.length; ++j) {
				int spaceIndex = death[j].indexOf(" ");
				
				int stroke = Integer.parseInt(death[j].substring(0, spaceIndex));
				int column = Integer.parseInt(death[j].substring(spaceIndex + 1));
				
				char[] afterDeath = tree[stroke].toCharArray();
				
				afterDeath[column] = '0';
				if (column - 1 > -1) afterDeath[column - 1] = '0';
				if (column + 1 < afterDeath.length) afterDeath[column + 1] = '0';

				tree[stroke] = new String(afterDeath);
			
				if (stroke - 1 > -1) {
					afterDeath = tree[stroke - 1].toCharArray();
					afterDeath[column] = '0';
					
					tree[stroke - 1] = new String(afterDeath);
				}
				
				if (stroke + 1 < tree.length) {
					afterDeath = tree[stroke + 1].toCharArray();
					afterDeath[column] = '0';
					
					tree[stroke + 1] = new String(afterDeath);
				}
			}
			
			evenYear = !evenYear;
		}
		
		for (int i = 0; i < tree.length; ++i) {
			char[] treePart= tree[i].toCharArray();
			
			for (int j = 0; j < treePart.length; ++j) {
				int ages = Integer.parseInt(new String(new char[] {treePart[j]}));
				
				if (ages == 0) treePart[j] = '.';
				if (ages > 0) treePart[j] = '+';
			}
			
			tree[i] = new String(treePart);
		}
		
		return tree;
		
	}
		
	private static String[] aging (String[] tree) {

		for (int i = 0; i < tree.length; ++i) {
			tree[i] = elevener(tree[i]);
		}
		
		return tree;
		
	}
	
	private static String elevener (String num) {
		
		int eleven = 1;
		
		for (int i = 0; i < num.length() - 1; ++i) {
			eleven *= 10;
			++eleven;
		}
				
		return String.valueOf(Integer.parseInt(num) + eleven);
		
	}
	
	private static String[] mustDeath(String[] tree) {
		
		String[] dieds = new String[0];
		
		for (int i = 0; i < tree.length; ++i) {
			for (int j = 0; j < tree[i].length(); ++j) {
				if (Integer.parseInt(new String(new char[] {tree[i].charAt(j)})) >= 3) {

					String died = i + " " + j;
					String[] buffer = dieds;
					
					dieds = new String[buffer.length + 1];

					for (int k = 0; k < dieds.length - 1; ++k) dieds[k] = buffer[k];
					
					dieds[dieds.length - 1] = died;
				}
			}
		}
		return dieds;
	}	
}