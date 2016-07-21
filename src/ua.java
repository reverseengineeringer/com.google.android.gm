import android.view.WindowInsets;

final class ua
  extends tz
{
  final WindowInsets a;
  
  ua(WindowInsets paramWindowInsets)
  {
    a = paramWindowInsets;
  }
  
  public final int a()
  {
    return a.getSystemWindowInsetLeft();
  }
  
  public final tz a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new ua(a.replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public final int b()
  {
    return a.getSystemWindowInsetTop();
  }
  
  public final int c()
  {
    return a.getSystemWindowInsetRight();
  }
  
  public final int d()
  {
    return a.getSystemWindowInsetBottom();
  }
  
  public final boolean e()
  {
    return a.isConsumed();
  }
}

/* Location:
 * Qualified Name:     ua
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */