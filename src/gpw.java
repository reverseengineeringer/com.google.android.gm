import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

public class gpw
  implements gph
{
  private static final Logger c = Logger.getLogger(gpw.class.getName());
  public gpo a;
  public boolean b = false;
  private final List<gos> d = new ArrayList();
  private final gpx e = new gpx(this);
  
  private final void c()
  {
    gpa localgpa = gow.a(d(), null);
    e.a(localgpa);
    a.a(localgpa);
  }
  
  private final gos d()
  {
    return (gos)d.remove(d.size() - 1);
  }
  
  public final void a()
  {
    a = new gpo();
    gpo localgpo = a;
    e = new Stack();
    f = -1;
  }
  
  final void a(gos paramgos)
  {
    d.add(paramgos);
  }
  
  public final void a(goy paramgoy) {}
  
  public final void a(gpa paramgpa)
  {
    gos localgos = a;
    int i = d.size() - 1;
    if (i >= 0) {
      if ((gos)d.get(i) != localgos) {}
    }
    for (;;)
    {
      label40:
      if (i >= 0)
      {
        for (;;)
        {
          if (i < d.size() - 1)
          {
            c();
            continue;
            i -= 1;
            break;
            i = -1;
            break label40;
          }
        }
        d();
        e.a(paramgpa);
        a.a(paramgpa);
        return;
      }
    }
    Logger localLogger = c;
    paramgpa = String.valueOf(a);
    if (paramgpa.length() != 0) {}
    for (paramgpa = "Ignoring end tag: ".concat(paramgpa);; paramgpa = new String("Ignoring end tag: "))
    {
      localLogger.finest(paramgpa);
      return;
    }
  }
  
  public final void a(gpd paramgpd)
  {
    Object localObject = e;
    gos localgos = a;
    if (b == 1) {
      if (gou.aD.equals(localgos))
      {
        if (a > 0) {
          ((gpx)localObject).a();
        }
        a += 1;
        b = 0;
      }
    }
    for (;;)
    {
      localObject = a;
      if (!c) {
        break;
      }
      localObject = a;
      int i = a.size();
      ((gpo)localObject).a(paramgpd, i, i);
      return;
      if (a == 0)
      {
        c.a(gou.aD);
        gpd localgpd = gow.a(gou.aD, null, null, null);
        c.a.a(localgpd);
        a += 1;
      }
      if ((gou.aF.equals(localgos)) || (gou.aI.equals(localgos)))
      {
        b = 1;
      }
      else if (gou.s.equals(localgos))
      {
        b = 2;
        continue;
        if ((a > 0) && (!gou.I.equals(localgos))) {
          ((gpx)localObject).a();
        }
      }
    }
    if (c)
    {
      a.a(gow.a((gos)localObject, b, d, e));
      paramgpd = gow.a((gos)localObject, null);
      e.a(paramgpd);
      a.a(paramgpd);
      return;
    }
    a.a(paramgpd);
    a((gos)localObject);
  }
  
  public final void a(gpf paramgpf)
  {
    int j = 0;
    Object localObject = e;
    if ((a > 0) && (b == 0))
    {
      String str = paramgpf.a();
      int k = str.length();
      i = 0;
      if (i >= k) {
        break label101;
      }
      if (Character.isWhitespace(str.charAt(i))) {
        break label94;
      }
    }
    label94:
    label101:
    for (int i = j;; i = 1)
    {
      if (i == 0) {
        ((gpx)localObject).a();
      }
      localObject = a;
      i = a.size();
      ((gpo)localObject).a(paramgpf, i, i);
      return;
      i += 1;
      break;
    }
  }
  
  public final void b()
  {
    boolean bool2 = false;
    while (d.size() > 0) {
      c();
    }
    Object localObject = e;
    if (a == 0)
    {
      bool1 = true;
      hby.a(bool1);
      if (b != 0) {
        break label100;
      }
      bool1 = true;
      label48:
      hby.a(bool1);
      localObject = a;
      if (e.size() != 0) {
        break label105;
      }
    }
    label100:
    label105:
    for (boolean bool1 = true;; bool1 = false)
    {
      hby.a(bool1);
      bool1 = bool2;
      if (f == -1) {
        bool1 = true;
      }
      hby.a(bool1);
      b = true;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label48;
    }
  }
}

/* Location:
 * Qualified Name:     gpw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */