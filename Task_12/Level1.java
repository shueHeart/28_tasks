import java.util.*;

public class Level1
{
	public static String MassVote (int N, int[] Votes) {
		float sumVotes = 0; 
		
		int winnerState = 0;
		
		float maxVotes = 0;
		
		int winner = -1;
		
		for (int i = 0; i < N; ++i) {
			sumVotes += Votes[i];
			if (maxVotes == Votes[i]) winnerState = 0;
			if (maxVotes < Votes[i]) {
				winnerState = 1;
				maxVotes = Votes[i]; 
				winner = i;
			}
		}
		
		float percentage = 0;
		
		percentage = maxVotes / (sumVotes / 100);
		
		if (percentage > 50) {
			winnerState = 2;
		}
		++winner;
		switch (winnerState) {
		case 2 :
			return "majority winner " + winner;
		case 1 : 
			return "minority winner " + winner;
		default :
			return "no winner";
		}
		
	}
}