import java.util.*;
class Edge
{
    int w, u, v;
    public Edge(int w, int u, int v)
    {
        this.w = w;
        this.u = u;
        this.v = v;
    }
}
class comp implements Comparator<Edge>
{

    @Override
    public int compare(Edge a, Edge b)
    {
        if (a.w > b.w)
            return 1;
        else if (a.w == b.w)
            return 0;
        else
            return -1;
    }
}

public class MST
{
    public static void main(String ss[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        PriorityQueue<Edge> Q = new PriorityQueue<>(m, new comp());

        Set<Edge> A = new HashSet<>();
        for (int i = 0; i < m; i++)
        {
            Edge temp = new Edge(in.nextInt(), in.nextInt(), in.nextInt());
            Q.add(temp);
        }
        //set s[]=new set[n];
        disJoint dj = new disJoint();

        for (int i = 0; i < n; i++)
        {
            dj.makeSet(i);
        }

        while (Q.size() > 0)
        {

            Edge e = Q.poll();

            if (dj.findSet1(e.u) != dj.findSet1(e.v))
            {

                A.add(e);
                dj.union(e.u, e.v);
            }
        }
        System.out.println("Final MST");
        for (Edge e1 : A)
            System.out.println(e1.w + " " + e1.u + " " + e1.v);
    }
}

/*
input from corman example use disjoint class too
9
14
4 0 1
8 0 7
8 1 2
11 1 7
7 7 8
2 8 2
6 8 6
7 2 3
4 2 5
2 6 5
14 3 5
9 3 4
10 4 5
1 7 6
*/
