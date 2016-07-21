import android.util.Log;
import android.view.View;

public final class aoz
  implements Runnable
{
  int a;
  
  protected aoz(aox paramaox) {}
  
  public final void run()
  {
    int j = 1;
    b.n = a;
    int i;
    int k;
    if (Log.isLoggable("MonthFragment", 3))
    {
      i = a;
      k = b.m;
      new StringBuilder(52).append("new scroll state: ").append(i).append(" old state: ").append(k);
    }
    if ((a == 0) && (b.m != 0) && (b.m != 1))
    {
      b.m = a;
      Object localObject = b.getChildAt(0);
      i = 0;
      while ((localObject != null) && (((View)localObject).getBottom() <= 0))
      {
        localObject = b;
        i += 1;
        localObject = ((aox)localObject).getChildAt(i);
      }
      if (localObject == null) {
        return;
      }
      i = b.getFirstVisiblePosition();
      k = b.getLastVisiblePosition();
      if ((i != 0) && (k != b.getCount() - 1)) {}
      for (i = j;; i = 0)
      {
        j = ((View)localObject).getTop();
        k = ((View)localObject).getBottom();
        int m = b.getHeight() / 2;
        if ((i == 0) || (j >= aox.a)) {
          break;
        }
        if (k <= m) {
          break label246;
        }
        b.smoothScrollBy(j, 250);
        return;
      }
      label246:
      b.smoothScrollBy(k, 250);
      return;
    }
    b.m = a;
  }
}

/* Location:
 * Qualified Name:     aoz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */