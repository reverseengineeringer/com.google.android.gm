import java.io.Reader;
import java.util.ArrayList;
import java.util.Vector;

public final class igk
  implements igl
{
  private static int[] m = { 2, 16, 2621440 };
  public String a;
  public String b;
  public ArrayList<String> c = new ArrayList();
  public ArrayList<String> d = new ArrayList();
  public igm e;
  igo f;
  public igp g;
  public igp h;
  private int j;
  private int k;
  private final int[] l = new int[3];
  private Vector<int[]> n = new Vector();
  private int[] o;
  private int p = -1;
  
  public igk(Reader paramReader)
  {
    f = new igo(paramReader);
    e = new igm(f);
    g = new igp();
    j = -1;
    k = 0;
    while (i < 3)
    {
      l[i] = -1;
      i += 1;
    }
  }
  
  private final int b()
  {
    igp localigp1 = g.g;
    h = localigp1;
    if (localigp1 == null)
    {
      localigp1 = g;
      igp localigp2 = e.a();
      g = localigp2;
      i = a;
      j = i;
      return i;
    }
    int i = h.a;
    j = i;
    return i;
  }
  
  public final igp a(int paramInt)
  {
    Object localObject = g;
    if (g != null) {}
    igp localigp2;
    for (g = g.g;; g = localigp2)
    {
      j = -1;
      if (g.a != paramInt) {
        break;
      }
      k += 1;
      return g;
      igp localigp1 = g;
      localigp2 = e.a();
      g = localigp2;
    }
    g = ((igp)localObject);
    p = paramInt;
    n.removeAllElements();
    localObject = new boolean[24];
    paramInt = 0;
    while (paramInt < 24)
    {
      localObject[paramInt] = 0;
      paramInt += 1;
    }
    if (p >= 0)
    {
      localObject[p] = 1;
      p = -1;
    }
    paramInt = 0;
    while (paramInt < 3)
    {
      if (l[paramInt] == k)
      {
        int i = 0;
        while (i < 32)
        {
          if ((m[paramInt] & 1 << i) != 0) {
            localObject[i] = 1;
          }
          i += 1;
        }
      }
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < 24)
    {
      if (localObject[paramInt] != 0)
      {
        o = new int[1];
        o[0] = paramInt;
        n.addElement(o);
      }
      paramInt += 1;
    }
    localObject = new int[n.size()][];
    paramInt = 0;
    while (paramInt < n.size())
    {
      localObject[paramInt] = ((int[])n.elementAt(paramInt));
      paramInt += 1;
    }
    throw new ign(g, (int[][])localObject, i);
  }
  
  public final void a()
  {
    Object localObject = a(21);
    a(3);
    igp localigp = a(21);
    a = f;
    b = f;
    if (j == -1) {}
    for (int i = b();; i = j) {
      switch (i)
      {
      default: 
        l[1] = k;
        return;
      }
    }
    a(4);
    localigp = a(21);
    a(5);
    if (j == -1) {}
    for (i = b();; i = j) {
      switch (i)
      {
      case 20: 
      default: 
        l[2] = k;
        a(-1);
        throw new ign();
      }
    }
    for (localObject = a(21);; localObject = a(19))
    {
      localObject = f;
      c.add(f);
      d.add(localObject);
      break;
    }
  }
}

/* Location:
 * Qualified Name:     igk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */