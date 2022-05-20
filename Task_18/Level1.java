import java.util.*;

public class Level1
{
	public static boolean MisterRobot(int N, int [] data) {
		boolean spinned = true;
		while (spinned) {
			for (int i = 0; i < N - 2; ++i) {
				int[] arr = {data[i], data[i + 1], data[i + 2]}; 
				
				for (int j = 0; j < 3 && !check(arr); ++j) {
					if (arr[0] > arr[1] || arr[1] > arr[2]) {
						arr = spin(arr, 1);
					}
				}
				if (!check(arr)) {
					return false;
				}
				data[i] = arr[0];
				data[i + 1] = arr[1];
				data[i + 2] = arr[2];
			}
			for (int i = 0; i < N; ++i) {
				System.out.println(data[i]);	
			}
			spinned = false;
			for (int i = 0; i < N - 1; ++i) {
				if (data[i] - data[i + 1] != -1) spinned = true; 
			}
		}
		return true;
	}

	
	private static boolean check (int[] checking) {
		if (checking[0] < checking[1] && checking[1] < checking[2]) return true;
		else return false;
	}
	
	private static int[] spin (int[] spinner, int circles) {
		for (int i = 0; i < circles; ++i) {
			int buf = spinner[0];
			spinner[0] = spinner[1];
			spinner[1] = spinner[2];
			spinner[2] = buf;
		}
		return spinner;
	}
}
