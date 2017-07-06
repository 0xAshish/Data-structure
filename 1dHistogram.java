import java.util.*;

class histogram
{
    public static void main(String s[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ar[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            ar[i] = in.nextInt();
        }
        Stack st = new Stack();
        int max = -1;
        int ans = 0;
        int i;
        for (i = 0; i < n;)
        {
            if (st.empty() || ar[(int)st.peek()] < ar[i])
            {
                st.push(i++);
                System.out.println("pushed :" + ar[i - 1]);
            }
            else
            {
                int top = (int)st.pop();
                if (st.empty())
                {
                    ans = ar[top] * i;
                }
                else
                {
                    ans = ar[top] * (i - (int)st.peek() - 1);
                }
                System.out.println("ans" + ans);
                if (ans > max)
                    max = ans;
            }
        }

        while (!st.empty())
        {
            int top = (int)st.pop();
            if (st.size() == 0)
            {
                ans = ar[top] * i;
            }
            else
            {
                ans = ar[top] * (i - (int)st.peek() - 1);
            }

            System.out.println("ans" + ans);
            if (ans > max)
                max = ans;

        } //}

        System.out.println(max);
    }
}
