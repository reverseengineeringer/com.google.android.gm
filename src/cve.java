import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class cve
  extends gpt
{
  private static final gor b = new gor("class");
  private static final gpc c = gow.b(gou.q, null, null, null);
  private int d = -1;
  
  public final void a(gpc paramgpc, int paramInt1, int paramInt2)
  {
    if (paramInt1 < d) {}
    for (;;)
    {
      return;
      if (paramInt1 == d)
      {
        super.a(c, paramInt1, paramInt2);
        return;
      }
      if ((paramgpc instanceof gpd))
      {
        Object localObject2 = (gpd)paramgpc;
        if (!"div".equals(a.a)) {
          break label199;
        }
        Object localObject1 = b;
        ArrayList localArrayList = new ArrayList();
        if (b != null)
        {
          localObject2 = b.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            gpe localgpe = (gpe)((Iterator)localObject2).next();
            if (a.equals(localObject1)) {
              localArrayList.add(localgpe);
            }
          }
        }
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if ("elided-text".equals(((gpe)((Iterator)localObject1).next()).a())) {
            d = paramInt2;
          }
        }
      }
      label199:
      for (int i = 1; i == 0; i = 0)
      {
        super.a(paramgpc, paramInt1, paramInt2);
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     cve
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */