import java.util.*;

public class Level1
{
    public static int squirrel(int N) {
        long factorial = 1;
        for(int i = 1; i <= N; ++i) {
            factorial *= i;
        }
        String stringMind = factorial + "";
        char[] num = new char[1];
        stringMind.getChars(0, 1, num, 0);
        String str = num[0] + "";

        int neededNum = Integer.parseInt(str);
        return neededNum;
    }
    
     public static int odometer(int [] oksana) {
        int km = 0;
        int lastTime = 0;
        for(int i = 1; i < oksana.length; i += 2) {
            km += (oksana[i] - lastTime) * oksana[i - 1];
            lastTime = oksana[i];
        }
        return km;
    }
    //old
//     public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
//         int[][] plac = new int[N][M];
//         for (int x = 0; x < N; ++x) {
//             for (int y = 0; y < M; ++y) {
//                 plac[x][y] = 0;
//             }
//         }
//         for (int i = 0; i <= L * 2; i += 2) {
//             plac[battalion[i]][battalion[i + 1]] = 1;
//         }
//         int days = 1;
//         while (notConquest(N, M, plac)){
//             List<int[]> list = new ArrayList<int[]>();
//             for (int x = 0; x < N; ++x) {
//                 for (int y = 0; y < M; ++y) {
//                     if (plac[x][y] != 0) {
//                         if(x + 1 < N) list.add(new int[]{x + 1, y});
//                         if(x - 1 > -1) list.add(new int[]{x - 1, y});
//                         if(y + 1 < M) list.add(new int[]{x, y + 1});
//                         if(y - 1 > -1) list.add(new int[]{x, y - 1});
//                     }
//                 }
//             }
//             for(int ind = 0; ind < list.size(); ++ind) {
            	
//                 int[] coords = list.get(ind);
//                 plac[coords[0]][coords[1]] = 1;
//             }
//             ++days;
//         }
//         return days;
//     }
//     private static boolean notConquest(int N, int M, int[][] plac) {
//         for (int x = 0; x < N; ++x) {
//             for (int y = 0; y < M; ++y) {
//                 if(plac[x][y] == 0){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
    //new
     public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
        int[][] plac = new int[N][M];
        for (int x = 0; x < N; ++x) {
            for (int y = 0; y < M; ++y) {
                plac[x][y] = 0;
            }
        }
        for (int i = 0; i < L; ++i) {
            plac[battalion[i] - 1][battalion[i + 1] - 1] = 1;
        }
        int days = 1;
        while (notConquest(N, M, plac)){
            List<int[]> list = new ArrayList<int[]>();
            for (int x = 0; x < N; ++x) {
                for (int y = 0; y < M; ++y) {
                    if (plac[x][y] != 0) {
                        if(x + 1 < N) list.add(new int[]{x + 1, y});
                        if(x - 1 > -1) list.add(new int[]{x - 1, y});
                        if(y + 1 < M) list.add(new int[]{x, y + 1});
                        if(y - 1 > -1) list.add(new int[]{x, y - 1});
                    }
                }
            }
            for(int ind = 0; ind < list.size(); ++ind) {
            	
                int[] coords = list.get(ind);
           
                plac[coords[0]][coords[1]] = 1;
            }
            ++days;
        }
        return days;
    }
    private static boolean notConquest(int N, int M, int[][] plac) {
        for (int x = 0; x < N; ++x) {
            for (int y = 0; y < M; ++y) {
                if(plac[x][y] == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
