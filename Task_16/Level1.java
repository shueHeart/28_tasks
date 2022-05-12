import java.util.*;

public class Level1
{
	
	public static int MaximumDiscount(int N, int [] price) {
		int maxDiscount = 0;
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (price[i] > price[j]) {
					int buf = price[i];
					price[i] = price[j];
					price[j] = buf;
				}
			}
		}
		
		for (int i = 2; i < N; i += 3) {
			maxDiscount += price[i];
		}
		return maxDiscount;
	}

	
}