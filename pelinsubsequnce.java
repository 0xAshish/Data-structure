import java.util.*;
class abc
{

  public
    static int ss(int[] ar)
    {
        int t[][] = new int[ar.length][ar.length];
        for (int i = 0; i < ar.length; i++)
        {
            t[i][i] = 1;
        }
        for (int l = 2; l <= ar.length; l++)
        {
            for (int i = 0; i < ar.length - l + 1; i++)
            {
                int j = i + l - 1;
                if (l == 2 && ar[i] == ar[j])
                {
                    t[i][j] = 2;
                }
                else if (ar[i] == ar[j])
                {
                    t[i][j] = t[i + 1][j - 1] + 2;
                }
                else
                {
                    t[i][j] = Math.max(t[i + 1][j], t[i][j - 1]);
                }
            }
        }
        return t[0][ar.length - 1];
    }
  public
    static void main(String aar[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ar[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            ar[i] = in.nextInt();
        }
        System.out.println(ss(ar));
    }
}
