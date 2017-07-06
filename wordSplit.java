import java.util.*;
class wordSplit
{
    public static void main(String s[])
    {
        Scanner in = new Scanner(System.in);
        String str = "iamdon";
        int n = str.length();
        boolean ar[][] = new boolean[n][n];
        //use int if you want to trace back solution and store value of k if splits other wise just 0 for false use -1
        Set<String> dict = new HashSet<String>();
        dict.add("i");
        dict.add("a");
        dict.add("am");
        dict.add("don");

        for (int l = 1; l <= n; l++)
        {
            for (int i = 0; i < n - l + 1; i++)
            {
                int j = i + l - 1;
                String st = str.substring(i, j + 1);
                //System.out.println(st);
                if (dict.contains(st))
                {
                    ar[i][j] = true;
               //     System.out.println(st);
                    continue;
                }
                else
                {
                    for (int k = i + 1; k <= j; k++)
                    {
                        if (ar[i][k - 1] && ar[k][j])
                        {
                            ar[i][j] = true;
             //               System.out.println(st);
                            break;
                        }
                    }
                }
            }
        }
        if (ar[0][str.length() - 1])
        {
            System.out.println("yes");
        }
        else
            System.out.println("no");
    }
}
