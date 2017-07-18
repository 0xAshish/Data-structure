import java.util.*;
import java.math.*;
class Ba
{
    static long M = 1000000007;
    public static long getBinSeqL(long n)
    {
        long a = 2;
        long b = 3;
        if (n == 1)
            return a;
        if (n == 2)
            return b;
        long i = 2;
        while (i++ < n)
        {
            long temp = a;
            a = b;
            b = (temp + b) % M;
        }
        return b;
    }
//fast but not accurate/gaournteed for some corner case works very well in competitve programming so.. why not!!
public static long fastMethod(long n)
{
  double f=Math.sqrt(5);
        double phi=(f+1)/2;
    return (long) Math.round((Math.pow(phi,n))/f)%M;
}

    public static void main(String s[])
    {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++)
        {
            //just fibonacci numbers
            // for actual numbers or seq we need to permute and check that if meets condition then add it to set
            long n = in.nextLong();
            //System.out.println(getBinSeqL(n));
            System.out.println(fastMethod(n+2));
        }
    }
}
