import android.graphics.Rect;
import android.os.Build.VERSION;

public final class pg
{
  static final ph a = new pi();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      a = new pj();
      return;
    }
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return a.a(paramInt1, paramInt2);
  }
  
  public static void apply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, int paramInt4, int paramInt5, Rect paramRect2, int paramInt6)
  {
    a.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramInt4, paramInt5, paramRect2, paramInt6);
  }
  
  public static void apply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2, int paramInt4)
  {
    a.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, paramInt4);
  }
}

/* Location:
 * Qualified Name:     pg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */