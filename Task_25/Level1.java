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
		for (int i = 0; i < A.length; ++i) {
			for (int j = 0; j < A.length - i; ++j) {
				int max = -1;
				for (int k = j; k <= i + j; ++k) {
					if (max < A[k]) max = A[k];
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