import android.view.View;
import java.util.HashSet;

public final class cex
  implements Runnable
{
  final ckv a;
  final View b;
  final gnr c;
  final HashSet<gnr> d;
  
  public cex(ckv paramckv, View paramView, HashSet<gnr> paramHashSet)
  {
    a = paramckv;
    b = paramView;
    c = gnu.a(b);
    d = paramHashSet;
  }
  
  public final void run()
  {
    cxa.g("VEL.sendImpression");
    if (b.getParent() != null) {
      a.a(b);
    }
    for (;;)
    {
      cxa.a();
      return;
      if (d != null) {
        d.remove(c);
      }
    }
  }
}

/* Location:
 * Qualified Name:     cex
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */