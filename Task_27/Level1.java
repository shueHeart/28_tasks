import java.util.*;

public class Level1
{
	public static boolean Football (int F[], int N) {
		
		int lengthSeries = 0;
		int lastLengthSeries = 0;
		
		int countSeries = 0;
		
		for (int i = 0; i < N - 1; ++i) {
			
			if (F[i] < F[i + 1] && lengthSeries != 0) {
				lastLengthSeries = lengthSeries;
				++countSeries; 
				lengthSeries = 0;
				continue;
			}
			
			if (F[i] < F[i + 1]) continue;
			
			++lengthSeries;
			
			if (countSeries > 0 && lengthSeries > 1) return false;
			if (countSeries > 0 && lastLengthSeries > 1) return false;
		}
		
		return countSeries != 0;
	}
}
