import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.view.View;

public final class sp
  implements qu
{
  private final Rect b = new Rect();
  
  public sp(ViewPager paramViewPager) {}
  
  public final tz a(View paramView, tz paramtz)
  {
    paramView = rg.a(paramView, paramtz);
    if (paramView.e()) {
      return paramView;
    }
    paramtz = b;
    left = paramView.a();
    top = paramView.b();
    right = paramView.c();
    bottom = paramView.d();
    int i = 0;
    int j = a.getChildCount();
    while (i < j)
    {
      Object localObject = a.getChildAt(i);
      localObject = rg.a.b((View)localObject, paramView);
      left = Math.min(((tz)localObject).a(), left);
      top = Math.min(((tz)localObject).b(), top);
      right = Math.min(((tz)localObject).c(), right);
      bottom = Math.min(((tz)localObject).d(), bottom);
      i += 1;
    }
    return paramView.a(left, top, right, bottom);
  }
}

/* Location:
 * Qualified Name:     sp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */