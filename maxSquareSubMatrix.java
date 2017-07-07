import java.util.*;
class msssm
{
    public static void main(String s[])
    {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int ar[][] = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                ar[i][j] = in.nextInt();
            }
        }

        int dp[][] = new int[m + 1][n + 1];
        int mi = 0, mj = 0, max = Integer.MIN_VALUE;
        for (int i = 1; i < m; i++)
        {
            dp[i][0] = 0;
        }
        for (int i = 1; i < n; i++)
        {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (ar[i - 1][j - 1] == 1)
                {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    System.out.print(dp[i][j] + " ");

                    if (dp[i][j] > max)
                    {
                        max = dp[i][j];
                        mi = i;
                        mj = j;
                        //System.out.println(dp[i][j]);
                    }
                }
            }
            System.out.println();
        }
        System.out.println(max + " " + mi + " " + mj);
    }
}
