package app;
import java.util.*;

public class Level1
{
	public static int [] SynchronizingTables(int N, int [] ids, int [] salary) { 
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if(salary[i] < salary[j]) {
					int buf = salary[j];
					salary[j] = salary[i];
					salary[i] = buf;
				}
			}
		}
		
		int[] notSortedIds = new int[N];
		for (int i = 0; i < N; ++i) notSortedIds[i] = ids[i];
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if(ids[i] < ids[j]) {
					int buf = ids[j];
					ids[j] = ids[i];
					ids[i] = buf;
				}
			}
		}
		int[] readySalary = new int[N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if(ids[i] == notSortedIds[j]) readySalary[j] = salary[i]; 
			}
		}
		return readySalary;
	}
}