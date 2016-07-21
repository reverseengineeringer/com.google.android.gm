import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

public final class xu
{
  public Object a;
  public xv b;
  
  private xu(int paramInt, Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInt >= 14) {
      b = new xy();
    }
    for (;;)
    {
      a = b.a(paramContext, paramInterpolator);
      return;
      if (paramInt >= 9) {
        b = new xx();
      } else {
        b = new xw();
      }
    }
  }
  
  public static xu a(Context paramContext, Interpolator paramInterpolator)
  {
    return new xu(Build.VERSION.SDK_INT, paramContext, paramInterpolator);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    b.a(a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    b.a(a, 0, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public final boolean a()
  {
    return b.a(a);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return b.a(a, paramInt1, paramInt2, 0, 0, 0, paramInt3);
  }
  
  public final int b()
  {
    return b.b(a);
  }
  
  public final int c()
  {
    return b.c(a);
  }
  
  public final int d()
  {
    return b.g(a);
  }
  
  public final int e()
  {
    return b.h(a);
  }
  
  public final float f()
  {
    return b.d(a);
  }
  
  public final boolean g()
  {
    return b.e(a);
  }
  
  public final void h()
  {
    b.f(a);
  }
}

/* Location:
 * Qualified Name:     xu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */