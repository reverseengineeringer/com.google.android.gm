import android.support.v4.view.ViewPager;

public final class cko
{
  public final ViewPager a;
  
  public cko(ViewPager paramViewPager)
  {
    a = paramViewPager;
  }
  
  public final int a(int paramInt)
  {
    return Math.max(0, Math.min(a.b.a() - 1, paramInt));
  }
  
  public final int b(int paramInt)
  {
    int i = paramInt;
    if (cxe.a(a)) {
      i = a.b.a() - 1 - paramInt;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     cko
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */