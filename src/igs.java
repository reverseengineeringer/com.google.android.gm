import java.io.Reader;
import java.util.Vector;

public final class igs
  implements igv
{
  private static int[] i = { 2, 2032, 2032, 8386560, 8388608, -16777216, -33554432 };
  private static int[] j = { 0, 0, 0, 0, 0, 15, 15 };
  public igw a;
  igy b;
  public igz c;
  public igz d;
  public int e;
  public int f;
  public final int[] g = new int[7];
  private Vector<int[]> k = new Vector();
  private int[] l;
  private int m = -1;
  
  public igs(Reader paramReader)
  {
    b = new igy(paramReader);
    a = new igw(b);
    c = new igz();
    e = -1;
    f = 0;
    while (n < 7)
    {
      g[n] = -1;
      n += 1;
    }
  }
  
  public static int a(igz paramigz)
  {
    return Integer.parseInt(f, 10);
  }
  
  public final int a()
  {
    igz localigz1 = c.g;
    d = localigz1;
    if (localigz1 == null)
    {
      localigz1 = c;
      igz localigz2 = a.a();
      g = localigz2;
      n = a;
      e = n;
      return n;
    }
    int n = d.a;
    e = n;
    return n;
  }
  
  public final igz a(int paramInt)
  {
    Object localObject = c;
    if (g != null) {}
    igz localigz2;
    for (c = c.g;; c = localigz2)
    {
      e = -1;
      if (c.a != paramInt) {
        break;
      }
      f += 1;
      return c;
      igz localigz1 = c;
      localigz2 = a.a();
      g = localigz2;
    }
    c = ((igz)localObject);
    m = paramInt;
    k.removeAllElements();
    localObject = new boolean[49];
    paramInt = 0;
    while (paramInt < 49)
    {
      localObject[paramInt] = 0;
      paramInt += 1;
    }
    if (m >= 0)
    {
      localObject[m] = 1;
      m = -1;
    }
    paramInt = 0;
    while (paramInt < 7)
    {
      if (g[paramInt] == f)
      {
        int n = 0;
        while (n < 32)
        {
          if ((i[paramInt] & 1 << n) != 0) {
            localObject[n] = 1;
          }
          if ((j[paramInt] & 1 << n) != 0) {
            localObject[(n + 32)] = 1;
          }
          n += 1;
        }
      }
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < 49)
    {
      if (localObject[paramInt] != 0)
      {
        l = new int[1];
        l[0] = paramInt;
        k.addElement(l);
      }
      paramInt += 1;
    }
    localObject = new int[k.size()][];
    paramInt = 0;
    while (paramInt < k.size())
    {
      localObject[paramInt] = ((int[])k.elementAt(paramInt));
      paramInt += 1;
    }
    throw new igx(c, (int[][])localObject, h);
  }
}

/* Location:
 * Qualified Name:     igs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */