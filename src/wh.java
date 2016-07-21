import android.graphics.Rect;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public final class wh
  extends ol
{
  private final Rect c = new Rect();
  
  public wh(DrawerLayout paramDrawerLayout) {}
  
  public final void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
  }
  
  public final void a(View paramView, uk paramuk)
  {
    if (DrawerLayout.b) {
      super.a(paramView, paramuk);
    }
    for (;;)
    {
      paramuk.b(DrawerLayout.class.getName());
      paramuk.a(false);
      paramuk.b(false);
      paramuk.a(ul.a);
      paramuk.a(ul.b);
      return;
      Object localObject1 = uk.a(uk.a.a(b));
      super.a(paramView, (uk)localObject1);
      uk.a.c(b, paramView);
      Object localObject2 = rg.a.i(paramView);
      if ((localObject2 instanceof View)) {
        paramuk.a((View)localObject2);
      }
      localObject2 = c;
      ((uk)localObject1).a((Rect)localObject2);
      paramuk.b((Rect)localObject2);
      ((uk)localObject1).c((Rect)localObject2);
      paramuk.d((Rect)localObject2);
      paramuk.c(uk.a.r(b));
      paramuk.a(((uk)localObject1).h());
      paramuk.b(((uk)localObject1).i());
      paramuk.c(((uk)localObject1).k());
      paramuk.g(((uk)localObject1).g());
      paramuk.f(((uk)localObject1).e());
      paramuk.a(((uk)localObject1).b());
      paramuk.b(((uk)localObject1).c());
      paramuk.d(uk.a.s(b));
      paramuk.e(((uk)localObject1).d());
      boolean bool = ((uk)localObject1).f();
      uk.a.e(b, bool);
      paramuk.a(((uk)localObject1).a());
      uk.a.q(b);
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject1 = paramView.getChildAt(i);
        if (DrawerLayout.i((View)localObject1)) {
          uk.a.a(b, (View)localObject1);
        }
        i += 1;
      }
    }
  }
  
  public final boolean a(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if ((DrawerLayout.b) || (DrawerLayout.i(paramView))) {
      return super.a(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    return false;
  }
  
  public final boolean d(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent = paramAccessibilityEvent.getText();
      paramView = a.d();
      int i;
      if (paramView != null)
      {
        i = a.c(paramView);
        paramView = a;
        i = pg.a(i, rg.g(paramView));
        if (i != 3) {
          break label73;
        }
        paramView = k;
      }
      for (;;)
      {
        if (paramView != null) {
          paramAccessibilityEvent.add(paramView);
        }
        return true;
        label73:
        if (i == 5) {
          paramView = l;
        } else {
          paramView = null;
        }
      }
    }
    return super.d(paramView, paramAccessibilityEvent);
  }
}

/* Location:
 * Qualified Name:     wh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */