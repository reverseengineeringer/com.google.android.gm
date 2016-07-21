import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

public abstract class xa
  extends ol
{
  static final String a = View.class.getName();
  static final Rect c = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
  final Rect d = new Rect();
  final Rect e = new Rect();
  final int[] f = new int[2];
  final AccessibilityManager g;
  final View h;
  public int i = Integer.MIN_VALUE;
  private final Rect j = new Rect();
  private xb k;
  private int l = Integer.MIN_VALUE;
  
  public xa(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("View may not be null");
    }
    h = paramView;
    g = ((AccessibilityManager)paramView.getContext().getSystemService("accessibility"));
  }
  
  private final void b(int paramInt)
  {
    if (l == paramInt) {
      return;
    }
    int m = l;
    l = paramInt;
    a(paramInt, 128);
    a(m, 256);
  }
  
  public abstract int a(float paramFloat1, float paramFloat2);
  
  public final ux a(View paramView)
  {
    if (k == null) {
      k = new xb(this);
    }
    return k;
  }
  
  public final void a()
  {
    a(-1, 2048);
  }
  
  public abstract void a(int paramInt, AccessibilityEvent paramAccessibilityEvent);
  
  public abstract void a(int paramInt, uk paramuk);
  
  public abstract void a(List<Integer> paramList);
  
  final boolean a(int paramInt)
  {
    return i == paramInt;
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == Integer.MIN_VALUE) || (!g.isEnabled())) {}
    ViewParent localViewParent;
    do
    {
      return false;
      localViewParent = h.getParent();
    } while (localViewParent == null);
    AccessibilityEvent localAccessibilityEvent;
    Object localObject;
    switch (paramInt1)
    {
    default: 
      localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
      localAccessibilityEvent.setEnabled(true);
      localAccessibilityEvent.setClassName(a);
      a(paramInt1, localAccessibilityEvent);
      if ((localAccessibilityEvent.getText().isEmpty()) && (localAccessibilityEvent.getContentDescription() == null)) {
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
      }
      break;
    case -1: 
      localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
      localObject = h;
      rg.a.a((View)localObject, localAccessibilityEvent);
    }
    for (;;)
    {
      localObject = h;
      return sz.a.a(localViewParent, (View)localObject, localAccessibilityEvent);
      localAccessibilityEvent.setPackageName(h.getContext().getPackageName());
      localObject = ub.a(localAccessibilityEvent);
      View localView = h;
      vk.a.a(b, localView, paramInt1);
    }
  }
  
  final boolean a(Rect paramRect)
  {
    if ((paramRect == null) || (paramRect.isEmpty())) {
      return false;
    }
    if (h.getWindowVisibility() != 0) {
      return false;
    }
    for (Object localObject = h.getParent(); (localObject instanceof View); localObject = ((View)localObject).getParent())
    {
      localObject = (View)localObject;
      if ((rg.e((View)localObject) <= 0.0F) || (((View)localObject).getVisibility() != 0)) {
        return false;
      }
    }
    if (localObject == null) {
      return false;
    }
    if (!h.getLocalVisibleRect(j)) {
      return false;
    }
    return paramRect.intersect(j);
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!g.isEnabled()) || (!ug.a(g))) {
      bool = false;
    }
    int m;
    do
    {
      return bool;
      switch (paramMotionEvent.getAction())
      {
      case 8: 
      default: 
        return false;
      case 7: 
      case 9: 
        m = a(paramMotionEvent.getX(), paramMotionEvent.getY());
        b(m);
      }
    } while (m != Integer.MIN_VALUE);
    return false;
    if (i != Integer.MIN_VALUE)
    {
      b(Integer.MIN_VALUE);
      return true;
    }
    return false;
  }
  
  public abstract boolean b(int paramInt1, int paramInt2);
}

/* Location:
 * Qualified Name:     xa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */