import java.util.*;

public class Level1
{
	public static int Unmanned(int L, int N, int [][] track) {
		
		int allRoadTime = 0;
		
		int prevDistance = 0;
		
		for (int i = 0; i < N; ++i) {
			allRoadTime += track[i][0] - prevDistance;
			int lightOnLightOst = allRoadTime % (track[i][1] + track[i][2]);
			
			boolean redLight = false;

			if (lightOnLightOst < track[i][1]) {
				redLight = true;
			}

			if (redLight) {
				allRoadTime += track[i][1] - (allRoadTime % (track[i][1] + track[i][2]));
			}
			
			prevDistance = track[i][0];
			
		}
		
		allRoadTime += L - track[N - 1][0];
		
		return allRoadTime;
		
	}

}