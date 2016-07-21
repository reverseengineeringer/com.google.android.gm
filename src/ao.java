import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;

public final class ao
  implements bi
{
  public ao(FloatingActionButton paramFloatingActionButton) {}
  
  public final float a()
  {
    return a.a() / 2.0F;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.c.set(paramInt1, paramInt2, paramInt3, paramInt4);
    a.setPadding(a.a + paramInt1, a.a + paramInt2, a.a + paramInt3, a.a + paramInt4);
  }
  
  public final void a(Drawable paramDrawable)
  {
    FloatingActionButton.a(a, paramDrawable);
  }
  
  public final boolean b()
  {
    return a.b;
  }
}

/* Location:
 * Qualified Name:     ao
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */