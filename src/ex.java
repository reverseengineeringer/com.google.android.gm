import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;

final class ex
  implements ViewTreeObserver.OnPreDrawListener
{
  ex(ev paramev, View paramView, Object paramObject, ArrayList paramArrayList, fa paramfa, boolean paramBoolean, Fragment paramFragment1, Fragment paramFragment2) {}
  
  public final boolean onPreDraw()
  {
    a.getViewTreeObserver().removeOnPreDrawListener(this);
    Object localObject1;
    fa localfa;
    Object localObject2;
    ns localns;
    if (b != null)
    {
      ge.a(b, c);
      c.clear();
      localObject1 = h;
      localfa = d;
      boolean bool = e;
      localObject2 = f;
      localns = new ns();
      View localView = R;
      if ((localView == null) || (u == null)) {
        break label243;
      }
      ge.a(localns, localView);
      if (!bool) {
        break label233;
      }
      localns = ev.a(u, v, localns);
      if (!bool) {
        break label246;
      }
      if (ah != null) {
        localObject2 = ah;
      }
      ((ev)localObject1).a(localfa, localns, true);
    }
    for (;;)
    {
      ge.a(b, d.d, localns, c);
      localObject1 = h;
      localfa = d;
      if ((v != null) && (!localns.isEmpty()))
      {
        localObject1 = (View)localns.get(v.get(0));
        if (localObject1 != null) {
          c.a = ((View)localObject1);
        }
      }
      ev.a(f, g, e, localns);
      return true;
      label233:
      nz.a(localns, v);
      label243:
      break;
      label246:
      if (ag != null) {
        localObject1 = ag;
      }
      ev.b(localfa, localns, true);
    }
  }
}

/* Location:
 * Qualified Name:     ex
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */