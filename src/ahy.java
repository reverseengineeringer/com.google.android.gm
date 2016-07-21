import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

final class ahy
  implements Runnable
{
  ahy(ahx paramahx, ArrayList paramArrayList) {}
  
  public final void run()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (aih)localIterator.next();
      ahx localahx = b;
      alj localalj = a;
      int k = b;
      int i = c;
      int m = d;
      int j = e;
      localObject = a;
      k = m - k;
      i = j - i;
      if (k != 0) {
        rg.q((View)localObject).b(0.0F);
      }
      if (i != 0) {
        rg.q((View)localObject).c(0.0F);
      }
      localObject = rg.q((View)localObject);
      e.add(localalj);
      ((tg)localObject).a(k).a(new aid(localahx, localalj, k, i, (tg)localObject)).b();
    }
    a.clear();
    b.b.remove(a);
  }
}

/* Location:
 * Qualified Name:     ahy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */