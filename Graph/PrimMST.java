import java.util.*;
import java.lang.*;
class Node
{
    int key;
    int p;
    Node()
    {
        key = 99999999; //Math.MAX_VALUE;
    }
}

class prim
{
    public static void main(String s[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        PriorityQueue<Integer> Q = new PriorityQueue<>();
        Node ar[] = new Node[n];
        for (int i = 0; i < n; i++)
        {
            Q.add(i); //just for fun or future use . ik i could have used a simple loop;
            ar[i] = new Node();
        }

        int adj[][] = new int[n][n];//adjlist/matrix

        int m = in.nextInt(); //number of edges

        for (int i = 0; i < m; i++)
        {

            int v = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            adj[a][b] = v;
            adj[b][a] = v;
        }

        while (Q.size() > 0)
        {
            int x = Q.poll();
            for (int i = 0; i < n; i++)
            {
                if (adj[x][i] > 0)
                {

                    if (Q.contains(i) && adj[x][i] < ar[i].key)
                    {
                        ar[i].key = adj[x][i];
                        ar[i].p = x;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++)
            System.out.println(i + " " + ar[i].key + " " + ar[i].p);
    }
}
