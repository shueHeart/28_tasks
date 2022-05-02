import java.util.*;

public class Level1
{
	public static int SumOfThe(int N, int [] data) {
		int sumAll = 0;
		for (int i = 0; i < N; ++i) {
			sumAll += data[i];
		}
		int sumFact = 0;
		for (int i = 0; i < N; ++i) {
			if(sumAll - data[i] == data[i]) {
				sumFact = data[i];
				break;
			}
		}
		return sumFact;
	}
		
}	