import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public final class wu
{
  private static final wx b = new wv();
  private Object a;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      b = new wy();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      b = new ww();
      return;
    }
  }
  
  public wu(Context paramContext)
  {
    a = b.a(paramContext);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    b.a(a, paramInt1, paramInt2);
  }
  
  public final boolean a()
  {
    return b.a(a);
  }
  
  public final boolean a(float paramFloat)
  {
    return b.a(a, paramFloat);
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    return b.a(a, paramFloat1, paramFloat2);
  }
  
  public final boolean a(int paramInt)
  {
    return b.a(a, paramInt);
  }
  
  public final boolean a(Canvas paramCanvas)
  {
    return b.a(a, paramCanvas);
  }
  
  public final void b()
  {
    b.b(a);
  }
  
  public final boolean c()
  {
    return b.c(a);
  }
}

/* Location:
 * Qualified Name:     wu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */