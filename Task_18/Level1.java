import java.util.*;

public class Level1
{
	public static boolean MisterRobot(int N, int [] data) {
		
		for (int i = N - 1; i > 2; --i) {
			int[] arr = {data[i - 2], data[i - 1], data[i]}; 
			spin(arr, minValueIndexFounder(arr));
		}
		
		for (int i = 0; i < N - 2; ++i) {
			int[] arr = {data[i], data[i + 1], data[i + 2]}; 
			spin(arr, maxValueIndexFounder(arr));
		}
		
		for (int i = 0; i < N - 1; ++i) {
			if (data[i] - data[i + 1] != 1) return false; 
		}
		return true;
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
	
	private static int minValueIndexFounder (int[] spinner) {
		int index = 0;
		for (int i = 0; i < 3; ++i) {
			if (spinner[index] < spinner[i]) index = i; 
		}
		return index;
	}
	
	private static int maxValueIndexFounder (int[] spinner) {
		int index = 0;
		for (int i = 0; i < 3; ++i) {
			if (spinner[index] > spinner[i]) index = i; 
		}
		return index;
	}
}