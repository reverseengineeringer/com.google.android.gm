import android.graphics.Rect;

final class rx
{
  private static ThreadLocal<Rect> a;
  
  static Rect a()
  {
    if (a == null) {
      a = new ThreadLocal();
    }
    Rect localRect2 = (Rect)a.get();
    Rect localRect1 = localRect2;
    if (localRect2 == null)
    {
      localRect1 = new Rect();
      a.set(localRect1);
    }
    localRect1.setEmpty();
    return localRect1;
  }
}

/* Location:
 * Qualified Name:     rx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */