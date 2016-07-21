import android.text.Spanned;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

public class gpo
{
  private static final gzx g = gzx.a(" \t\f​\r\n");
  private static final gps h = new gpp();
  private static final Logger l = Logger.getLogger(gpo.class.getName());
  public final List<gpc> a = new ArrayList();
  public final Stack<Integer> b = new Stack();
  public Spanned c;
  public gps d = h;
  Stack<Integer> e;
  int f;
  private final Stack<Integer> i = new Stack();
  private String j;
  private int[] k;
  
  public final String a()
  {
    if (j == null)
    {
      if ((j == null) && (k == null)) {}
      int n;
      gpr localgpr;
      for (boolean bool = true;; bool = false)
      {
        hby.a(bool);
        n = a.size();
        k = new int[n + 1];
        localgpr = d.a();
        int m = 0;
        while (m < n)
        {
          k[m] = localgpr.a();
          localgpr.a((gpc)a.get(m), m, ((Integer)b.get(m)).intValue());
          m += 1;
        }
      }
      k[n] = localgpr.a();
      j = ((String)localgpr.b());
    }
    return j;
  }
  
  final void a(gpa paramgpa)
  {
    int m = a.size();
    a(paramgpa, f, m);
    if (f != -1) {
      b.set(f, Integer.valueOf(m));
    }
    f = ((Integer)e.pop()).intValue();
  }
  
  final void a(gpc paramgpc, int paramInt1, int paramInt2)
  {
    a.add(paramgpc);
    i.add(Integer.valueOf(paramInt1));
    b.add(Integer.valueOf(paramInt2));
  }
  
  final void a(gpd paramgpd)
  {
    int m = a.size();
    a(paramgpd, m, -1);
    e.add(Integer.valueOf(f));
    f = m;
  }
  
  public final void a(gps paramgps)
  {
    if (paramgps == null) {
      throw new NullPointerException("factory must not be null");
    }
    d = paramgps;
  }
}

/* Location:
 * Qualified Name:     gpo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */