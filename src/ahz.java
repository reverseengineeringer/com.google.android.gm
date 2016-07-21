import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

final class ahz
  implements Runnable
{
  ahz(ahx paramahx, ArrayList paramArrayList) {}
  
  public final void run()
  {
    Iterator localIterator = a.iterator();
    if (localIterator.hasNext())
    {
      aig localaig = (aig)localIterator.next();
      ahx localahx = b;
      Object localObject1 = a;
      if (localObject1 == null)
      {
        localObject1 = null;
        label46:
        localObject2 = b;
        if (localObject2 == null) {
          break label223;
        }
      }
      label223:
      for (Object localObject2 = a;; localObject2 = null)
      {
        if (localObject1 != null)
        {
          localObject1 = rg.q((View)localObject1).a(l);
          g.add(a);
          ((tg)localObject1).b(e - c);
          ((tg)localObject1).c(f - d);
          ((tg)localObject1).a(0.0F).a(new aie(localahx, localaig, (tg)localObject1)).b();
        }
        if (localObject2 == null) {
          break;
        }
        localObject1 = rg.q((View)localObject2);
        g.add(b);
        ((tg)localObject1).b(0.0F).c(0.0F).a(l).a(1.0F).a(new aif(localahx, localaig, (tg)localObject1, (View)localObject2)).b();
        break;
        localObject1 = a;
        break label46;
      }
    }
    a.clear();
    b.c.remove(a);
  }
}

/* Location:
 * Qualified Name:     ahz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */