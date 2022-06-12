import java.util.*;

public class Level1
{
	
	static int[] B = new int[0];
	
	public static boolean TransformTransform(int[] A, int N) {
		TTAlgorithm(A, N);
		TTAlgorithm(B, B.length);
		
		int keykey = 0;
		
		for (int i = 0; i < B.length; ++i) {
			keykey += B[i];
		}

		return keykey % 2 == 0;
	}	
	
	private static void TTAlgorithm (int[] A, int N) {
		B = new int[0];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N - i; ++j) {
				int max = -1;
				int k = i + j;
				for (int c = j; c <= k; ++c) {
					if (max < A[c]) max = A[c];
				}
				B = writeToEnd(B, max);
			}
		}
	}
	
	private static int[] writeToEnd(int[] arr, int forWrite) {
		int[] buf = arr;
		arr = new int[buf.length + 1];
		
		for (int i = 0; i < buf.length; ++i) {
			arr[i] = buf[i];
		}
		
		arr[arr.length - 1] = forWrite;
		
		return arr;
	}
}
