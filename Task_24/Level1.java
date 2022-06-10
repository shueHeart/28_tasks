import java.util.*;

public class Level1
{
	
	public static void MatrixTurn(String Matrix[], int M, int N, int T) {
		
		int strokeShift = 0;
		int columnShift = 0;
		
		for (int i = 0; i < M - 2; ++i) {
			
			String forTurn = cutShifts(Matrix[strokeShift], strokeShift);

			for (int j = strokeShift; j < (M - 2) - strokeShift; ++j) {
				forTurn += new String(new char[] {Matrix[j + 1].charAt((N - 1) - columnShift)});
			}
			
			forTurn += cutShifts(new StringBuilder(Matrix[(M - 1) - strokeShift]).reverse().toString(), strokeShift);
			
			for (int j = (M - 2) - strokeShift; j > strokeShift; --j) {
				forTurn += new String(new char[] {Matrix[j].charAt(columnShift)});
			}
		
			char[] turned = new char[forTurn.length()];
			
			for (int j = 0; j < forTurn.length(); ++j) {
				int turnedIndex = 0;
				
				if (T + j >= forTurn.length()) turnedIndex = (T + j) - forTurn.length();
				if (T + j < forTurn.length()) turnedIndex = T + j;
				
				turned[turnedIndex] = forTurn.charAt(j); 
			}
			
			String turnedConverted = new String(turned);
						
			String frontShiftedTop = Matrix[strokeShift].substring(0, columnShift);
			String centerShiftedTop = turnedConverted.substring(0, N - columnShift * 2);
			String endShiftedTop = Matrix[strokeShift].substring(N - columnShift, N);
			
			String firstTurnedStroke = frontShiftedTop + centerShiftedTop + endShiftedTop;
			
			Matrix[strokeShift] = firstTurnedStroke;

			turnedConverted = turnedConverted.replaceFirst(centerShiftedTop, "");
			
			for (int j = strokeShift; j < (M - 2) - strokeShift; ++j) {
				String stroke = Matrix[j + 1].substring(0, N - 1);
				
				stroke =  stroke + turnedConverted.charAt(0) ;
				Matrix[j + 1] = stroke;
				
				turnedConverted = turnedConverted.replaceFirst(new String(new char[] {turnedConverted.charAt(0)}), "");
			}
			
			String frontShiftedBottom = Matrix[(M - 1) - strokeShift].substring(0, columnShift);
			String centerShiftedBottom = new StringBuilder(turnedConverted.substring(0, N - columnShift * 2)).reverse().toString();
			String endShiftedBottom = Matrix[(M - 1) - strokeShift].substring(N - columnShift, N);
			
			String lastTurnedStroke = frontShiftedBottom + centerShiftedBottom + endShiftedBottom;
			
			Matrix[(M - 1) - strokeShift] = lastTurnedStroke;
			
			turnedConverted = turnedConverted.replaceFirst(new StringBuilder(centerShiftedBottom).reverse().toString(), "");
			
			
			for (int j = (M - 2) - strokeShift; j > strokeShift; --j) {
				String stroke = Matrix[j].substring(1, N);

				stroke = turnedConverted.charAt(0) + stroke;

				Matrix[j] = stroke;

				turnedConverted = turnedConverted.replaceFirst(new String(new char[] {turnedConverted.charAt(0)}), "");
			}

			++strokeShift;
			++columnShift;
		}
		
	}
	
	private static String cutShifts (String matrixStroke, int shift) {
		char [] chars = matrixStroke.toCharArray();
		
		for (int i = 0; i < shift; ++i) {
			chars[i] = 'd';
			chars[matrixStroke.length() - 1 - i] = 'd'; 
		}
		return new String(chars).replace("d", "");
		
	}
	
}
