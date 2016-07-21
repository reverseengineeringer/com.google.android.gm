import android.graphics.Paint;
import android.view.View;

class ro
  extends rn
{
  public final boolean B(View paramView)
  {
    return paramView.isPaddingRelative();
  }
  
  public final void a(View paramView, Paint paramPaint)
  {
    paramView.setLayerPaint(paramPaint);
  }
  
  public final void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void d(View paramView, int paramInt)
  {
    paramView.setLayoutDirection(paramInt);
  }
  
  public final int h(View paramView)
  {
    return paramView.getLayoutDirection();
  }
  
  public final int m(View paramView)
  {
    return paramView.getPaddingStart();
  }
  
  public final int n(View paramView)
  {
    return paramView.getPaddingEnd();
  }
  
  public final int v(View paramView)
  {
    return paramView.getWindowSystemUiVisibility();
  }
}

/* Location:
 * Qualified Name:     ro
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */