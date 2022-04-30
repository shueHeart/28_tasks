import java.util.*;

public class Level1
{
	public static int [] MadMax (int N, int [] Tele) {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (Tele[i] < Tele[j]) {
					int buf = Tele[j];
					Tele[j] = Tele[i];
					Tele[i] = buf;
				}
					
			}
		}
		for(int i = 0; i <= (N / 2) / 2;  ++i) {
			System.out.println("*");
			int buf = Tele[((N - 1) / 2) + i];
			Tele[((N - 1) / 2) + i] = Tele[N - 1 - i];
			Tele[N - 1 - i] = buf;
		}

		return Tele;
	}

}