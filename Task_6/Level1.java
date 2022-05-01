import java.util.*;

public class Level1
{
	public static String PatternUnlock(int N, int [] hits) { 
		int[][] pointCoordinates = {
			{2, 3},
			{2, 2},
			{2, 1},
			{1, 1},
			{1, 2},
			{1, 3},
			{3, 1},
			{3, 2},
			{3, 3}
		};
		
		
		double sumDistance = 0;
		for (int i = 0; i < N - 1; ++i) {
			double cat1 = Math.abs(pointCoordinates[hits[i] - 1][0] - pointCoordinates[hits[i + 1] - 1][0]);
			double cat2 = Math.abs(pointCoordinates[hits[i] - 1][1] - pointCoordinates[hits[i + 1] - 1][1]);
			double distance = Math.sqrt(Math.pow(cat1, 2) + Math.pow(cat2, 2));
			sumDistance += distance;
		}
		String readySentence = String.format("%.5f", sumDistance);
		readySentence = readySentence.replace(",", "");
		readySentence = readySentence.replace("0", "");
		return readySentence;
	}
}
