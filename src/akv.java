import android.support.v7.widget.RecyclerView;
import android.view.View;

public final class akv
  implements akt
{
  public akv(RecyclerView paramRecyclerView) {}
  
  public final void a(alj paramalj)
  {
    boolean bool = true;
    paramalj.a(true);
    if ((g != null) && (h == null)) {
      g = null;
    }
    h = null;
    int i;
    RecyclerView localRecyclerView;
    Object localObject;
    ahr localahr;
    if ((i & 0x10) != 0)
    {
      i = 1;
      if (i == 0)
      {
        localRecyclerView = a;
        localObject = a;
        localRecyclerView.b();
        localahr = e;
        i = a.a((View)localObject);
        if (i != -1) {
          break label169;
        }
        localahr.b((View)localObject);
        i = 1;
        label99:
        if (i != 0)
        {
          localObject = RecyclerView.b((View)localObject);
          c.b((alj)localObject);
          c.a((alj)localObject);
        }
        if (i != 0) {
          break label220;
        }
      }
    }
    for (;;)
    {
      localRecyclerView.a(bool);
      if ((i == 0) && (paramalj.m())) {
        a.removeDetachedView(a, false);
      }
      return;
      i = 0;
      break;
      label169:
      if (b.c(i))
      {
        b.d(i);
        localahr.b((View)localObject);
        a.a(i);
        i = 1;
        break label99;
      }
      i = 0;
      break label99;
      label220:
      bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     akv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */