import java.util.*;
class subMat
{
    public static int maxHist(int[] ar)
    {
        int n = ar.length;

        Stack st = new Stack();
        int max = -1;
        int ans = 0;
        int i;

        for (i = 0; i < n;)
        {
            if (st.empty() || ar[(int)st.peek()] < ar[i])     st.push(i++);
            else
            {
                int top = (int)st.pop();
      
	        if (st.empty()) ans = ar[top] * i;

                else  ans = ar[top] * (i - (int)st.peek() - 1);

	        if (ans > max) max = ans;
			
            }
        }

        while (!st.empty())
        {
            int top = (int)st.pop();
            if (st.size() == 0)
                ans = ar[top] * i;
            else
                ans = ar[top] * (i - (int)st.peek() - 1);

            if (ans > max) max = ans;

        }
	
        return max;
    }

    public static void main(String s[])
    {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int max = Integer.MIN_VALUE;
        int ar[][] = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                ar[i][j] = in.nextInt();
            }
        }
		int maxi=0;
        int a[] = new int[n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                a[j] += ar[i][j]; //=in.nextInt();
            }
            int ans = maxHist(a);
            if (ans > max){
                max = ans;
		maxi=i;

}
        }

        System.out.println(max+" "+(maxi+1)+"*"+max/(maxi+1));
    }
}
