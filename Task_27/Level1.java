import java.util.*;

public class Level1
{
	public static boolean Football (int F[], int N) {
		
		int[] sorted = new int[F.length];
		
		for (int i = 0; i < N; ++i) {
			sorted[i] = F[i];
		}
		
		for (int i = 0; i < N; ++i) {
			for (int j = i + 1; j < N; ++j) { 
				if (sorted[i] > sorted[j]) {
					int buf = sorted[j];
					sorted[j] = sorted[i];
					sorted[i] = buf;
				}
			}
		}
		
		int[] indexes = new int[0];
		
		for (int i = 0; i < N; ++i) {
			if (sorted[i] != F[i]) {
				int[] buf = new int[indexes.length + 1];
				for (int j = 0; j < indexes.length; ++j) buf[j] = indexes[j];
				buf[buf.length - 1] = i;
				indexes = buf;
			}
		}
		if (indexes.length == 0) return false;
		
		if (indexes.length == 2) return true;
	
		for (int i = 0; i < indexes.length - 1; ++i) {
			if (indexes[i] - indexes[i + 1] != -1) return false; 
		}
		
		int absoluteDiff = F[indexes[0]] - F[indexes[1]];
		
		for (int i = indexes[1]; i < indexes[indexes.length - 1]; ++i) {
			if (absoluteDiff != F[i] - F[i + 1]) return false; 
		}
		
		return true;

	}
}
