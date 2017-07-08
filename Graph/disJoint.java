import java.util.*;
class set
{
    int val;
    int rate;
    set p;
}

public class disJoint
{

    Map<Integer, set> map = new HashMap<>();
    public void makeSet(int z)
    {
        set x = new set();
        x.val = z;
        x.p = x;
        x.rate = 0;
        map.put(z, x);
    }

    public void union(int x, int y)
    {
        set n1 = map.get(x);
        set n2 = map.get(y);
        if (n2.p.val == n1.p.val)
            return;
            
        link(findSet(n1), findSet(n2));
    }

    public int findSet1(int a)
    {
        return findSet(map.get(a)).val;
    }
    public set findSet(set x)
    {
        if (x.p != x)
        {
            x.p = findSet(x.p);
        }
        return x.p;
    }
    public void link(set x, set y)
    {
        if (x.rate > y.rate)
        {
            y.p = x;
        }
        else
        {
            x.p = y;
            if (x.rate == y.rate)
            {
                y.rate++;
            }
        }
    }
}
