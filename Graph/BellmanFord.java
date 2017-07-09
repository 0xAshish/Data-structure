import java.util.*;
class edge
{
    int w; // weight
int u;    
int v; //name
}
class Node
{
    int dis;
    int p;
}
public class BellmanFord
{
    public static void main(String ss[])
    {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	Set<edge> list = new HashSet<>();
	Node ar[] = new Node[n];
	for (int i = 0; i < n; i++)
	{

	    ar[i] = new Node();
	    ar[i].dis = 99999999; //inf
	}
	ar[0].dis = 0;
	int m = in.nextInt();
	for (int i = 0; i < m; i++)
	{
	    edge e = new edge();
	    e.w = in.nextInt();
	    e.u= in.nextInt();
	    e.v = in.nextInt();
	    			
	    list.add(e);
	}
	for (int i = 0; i < n - 1; i++)
	{
	    for (edge e : list)
	    {
		if (ar[e.v].dis > ar[e.u].dis + e.w)
		{
		    ar[e.v].dis = ar[e.u].dis + e.w;
		    ar[e.v].p = e.u;
		}
	    }
	}
boolean b=false;
	loop: for (edge e : list)
	    {
		if (ar[e.v].dis > ar[e.u].dis + e.w)
		{
		   System.out.println("locha");
			b=true;
	break loop;
		}
	    }
System.out.println("------------------------");

for(int i=0;i<n;i++){
System.out.println(i+" "+ar[i].dis+" "+ar[i].p);
}

    }
}








/*
input from corman
5
10
7 0 4
6 0 1
5 1 2
-2 2 1
-4 1 3
8 1 4 
-3 4 2
2 3 0
7 3 2
9 4 3


*/
