import android.os.Build.VERSION;
import android.view.View;

final class tk
  implements tw
{
  tg a;
  boolean b;
  
  tk(tg paramtg)
  {
    a = paramtg;
  }
  
  public final void a(View paramView)
  {
    b = false;
    if (a.d >= 0) {
      rg.a(paramView, 2, null);
    }
    if (a.b != null)
    {
      localObject = a.b;
      a.b = null;
      ((Runnable)localObject).run();
    }
    Object localObject = paramView.getTag(2113929216);
    if ((localObject instanceof tw)) {}
    for (localObject = (tw)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((tw)localObject).a(paramView);
      }
      return;
    }
  }
  
  public final void b(View paramView)
  {
    if (a.d >= 0)
    {
      rg.a(paramView, a.d, null);
      a.d = -1;
    }
    if ((Build.VERSION.SDK_INT >= 16) || (!b))
    {
      if (a.c != null)
      {
        localObject = a.c;
        a.c = null;
        ((Runnable)localObject).run();
      }
      localObject = paramView.getTag(2113929216);
      if (!(localObject instanceof tw)) {
        break label113;
      }
    }
    label113:
    for (Object localObject = (tw)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((tw)localObject).b(paramView);
      }
      b = true;
      return;
    }
  }
  
  public final void c(View paramView)
  {
    Object localObject = paramView.getTag(2113929216);
    if ((localObject instanceof tw)) {}
    for (localObject = (tw)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((tw)localObject).c(paramView);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     tk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */