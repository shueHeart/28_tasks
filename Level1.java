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
}