import android.support.v7.widget.GridLayout;
import android.view.View;

final class ait
  extends aja
{
  private int e;
  
  ait(ais paramais) {}
  
  protected final int a(GridLayout paramGridLayout, View paramView, aiv paramaiv, int paramInt, boolean paramBoolean)
  {
    return Math.max(0, super.a(paramGridLayout, paramView, paramaiv, paramInt, paramBoolean));
  }
  
  protected final int a(boolean paramBoolean)
  {
    return Math.max(super.a(paramBoolean), e);
  }
  
  protected final void a()
  {
    super.a();
    e = Integer.MIN_VALUE;
  }
  
  protected final void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    e = Math.max(e, paramInt1 + paramInt2);
  }
}

/* Location:
 * Qualified Name:     ait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */