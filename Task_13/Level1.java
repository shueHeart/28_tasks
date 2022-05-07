import java.util.*;

public class Level1
{
	public static int [] UFO(int N, int [] data, boolean octal) {
		int system = 8;
		if (!octal) system = 16;
		
		for (int i = 0; i < N; ++i) {
			int notConvertedNum = data[i];
			data[i] = 0;
			for (int j = 0; notConvertedNum != 0; ++j) {
				int dischargeValue = notConvertedNum % 10; 
				data[i] += dischargeValue * Math.pow(system, j);
				notConvertedNum = (notConvertedNum - dischargeValue) / 10;
			}
		}
		
		return data;
	}
}