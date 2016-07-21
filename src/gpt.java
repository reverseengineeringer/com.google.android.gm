import java.util.Set;

public class gpt
  implements gpr<String>
{
  private static final Set<gos> b = hfd.a(gou.ao, gou.o, gou.aq);
  public final gpu a = new gpu();
  private int c = 0;
  private int d = 0;
  
  public final int a()
  {
    return a.a.length();
  }
  
  public void a(gpc paramgpc, int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramgpc instanceof gpf))
    {
      localObject = ((gpf)paramgpc).a();
      if (c > 0)
      {
        paramgpc = a;
        localObject = ((String)localObject).split("[\\r\\n]", -1);
        paramgpc.b(localObject[0]);
        paramInt1 = 1;
        while (paramInt1 < localObject.length)
        {
          paramgpc.b();
          paramgpc.b(localObject[paramInt1]);
          paramInt1 += 1;
        }
      }
      if (d <= 0) {
        a.a((String)localObject);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!(paramgpc instanceof gpd)) {
            break;
          }
          paramgpc = a;
          if (b.contains(paramgpc)) {
            a.a(gpv.d);
          }
          while (gou.o.equals(paramgpc))
          {
            paramgpc = a;
            b += 1;
            return;
            if (gou.q.equals(paramgpc))
            {
              localObject = a;
              ((gpu)localObject).a();
              ((gpu)localObject).b();
            }
            else if (d)
            {
              a.a(gpv.c);
              if (gou.S.equals(paramgpc))
              {
                a.a("________________________________");
                a.a(gpv.c);
              }
            }
          }
          if (gou.aq.equals(paramgpc))
          {
            c += 1;
            return;
          }
        } while (!gou.aA.equals(paramgpc));
        d += 1;
        return;
      } while (!(paramgpc instanceof gpa));
      paramgpc = a;
      if (b.contains(paramgpc)) {
        a.a(gpv.d);
      }
      while (gou.o.equals(paramgpc))
      {
        paramgpc = a;
        b = Math.max(0, b - 1);
        return;
        if (d) {
          a.a(gpv.c);
        }
      }
      if (gou.aq.equals(paramgpc))
      {
        c -= 1;
        return;
      }
    } while (!gou.aA.equals(paramgpc));
    d -= 1;
  }
}

/* Location:
 * Qualified Name:     gpt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */