import android.support.design.widget.BottomSheetBehavior;
import android.view.View;

public final class x
  implements Runnable
{
  private final View b;
  private final int c;
  
  public x(BottomSheetBehavior paramBottomSheetBehavior, View paramView, int paramInt)
  {
    b = paramView;
    c = paramInt;
  }
  
  public final void run()
  {
    if ((a.e != null) && (a.e.c()))
    {
      rg.a(b, this);
      return;
    }
    a.a(c);
  }
}

/* Location:
 * Qualified Name:     x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */