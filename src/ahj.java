import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.view.View;

public final class ahj
  implements ahl
{
  private Drawable b;
  
  public ahj(CardView paramCardView) {}
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > a.c) {
      CardView.a(a, paramInt1);
    }
    if (paramInt2 > a.d) {
      CardView.b(a, paramInt2);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.f.set(paramInt1, paramInt2, paramInt3, paramInt4);
    CardView.a(a, a.e.left + paramInt1, a.e.top + paramInt2, a.e.right + paramInt3, a.e.bottom + paramInt4);
  }
  
  public final void a(Drawable paramDrawable)
  {
    b = paramDrawable;
    a.setBackgroundDrawable(paramDrawable);
  }
  
  public final boolean a()
  {
    return a.a;
  }
  
  public final boolean b()
  {
    return a.b;
  }
  
  public final Drawable c()
  {
    return b;
  }
  
  public final View d()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     ahj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */