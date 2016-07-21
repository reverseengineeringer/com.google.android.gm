import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import java.lang.reflect.Field;

final class ajq
  extends ajz
{
  boolean a;
  private boolean i;
  private boolean j;
  private tg k;
  private xc l;
  
  public ajq(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, aca.B);
    i = paramBoolean;
    setCacheColorHint(0);
  }
  
  protected final boolean a()
  {
    return (j) || (super.a());
  }
  
  public final boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    boolean bool = true;
    int m = qk.a(paramMotionEvent);
    label41:
    View localView;
    switch (m)
    {
    default: 
      bool = true;
      paramInt = 0;
      if ((!bool) || (paramInt != 0))
      {
        j = false;
        setPressed(false);
        drawableStateChanged();
        localView = getChildAt(g - getFirstVisiblePosition());
        if (localView != null) {
          localView.setPressed(false);
        }
        if (k != null)
        {
          k.a();
          k = null;
        }
      }
      if (bool)
      {
        if (l == null) {
          l = new xc(this);
        }
        l.a(true);
        l.onTouch(this, paramMotionEvent);
      }
      break;
    }
    label406:
    while (l == null)
    {
      return bool;
      bool = false;
      paramInt = 0;
      break label41;
      bool = false;
      int n = paramMotionEvent.findPointerIndex(paramInt);
      if (n < 0)
      {
        bool = false;
        paramInt = 0;
        break label41;
      }
      paramInt = (int)paramMotionEvent.getX(n);
      int i1 = (int)paramMotionEvent.getY(n);
      n = pointToPosition(paramInt, i1);
      if (n == -1)
      {
        paramInt = 1;
        break label41;
      }
      localView = getChildAt(n - getFirstVisiblePosition());
      float f1 = paramInt;
      float f2 = i1;
      j = true;
      if (Build.VERSION.SDK_INT >= 21) {
        drawableHotspotChanged(f1, f2);
      }
      if (!isPressed()) {
        setPressed(true);
      }
      layoutChildren();
      if (g != -1)
      {
        localObject1 = getChildAt(g - getFirstVisiblePosition());
        if ((localObject1 != null) && (localObject1 != localView) && (((View)localObject1).isPressed())) {
          ((View)localObject1).setPressed(false);
        }
      }
      g = n;
      float f3 = localView.getLeft();
      float f4 = localView.getTop();
      if (Build.VERSION.SDK_INT >= 21) {
        localView.drawableHotspotChanged(f1 - f3, f2 - f4);
      }
      if (!localView.isPressed()) {
        localView.setPressed(true);
      }
      Object localObject1 = getSelector();
      Object localObject2;
      if ((localObject1 != null) && (n != -1))
      {
        paramInt = 1;
        if (paramInt != 0) {
          ((Drawable)localObject1).setVisible(false, false);
        }
        localObject2 = b;
        ((Rect)localObject2).set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        left -= c;
        top -= d;
        right += e;
        bottom += f;
      }
      for (;;)
      {
        try
        {
          bool = h.getBoolean(this);
          if (localView.isEnabled() != bool)
          {
            localObject2 = h;
            if (bool) {
              continue;
            }
            bool = true;
            ((Field)localObject2).set(this, Boolean.valueOf(bool));
            if (n != -1) {
              refreshDrawableState();
            }
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
          continue;
          bool = false;
          continue;
        }
        if (paramInt != 0)
        {
          localObject2 = b;
          f3 = ((Rect)localObject2).exactCenterX();
          f4 = ((Rect)localObject2).exactCenterY();
          if (getVisibility() != 0) {
            continue;
          }
          bool = true;
          ((Drawable)localObject1).setVisible(bool, false);
          kn.a((Drawable)localObject1, f3, f4);
        }
        localObject1 = getSelector();
        if ((localObject1 != null) && (n != -1)) {
          kn.a((Drawable)localObject1, f1, f2);
        }
        a(false);
        refreshDrawableState();
        if (m != 1) {
          break;
        }
        performItemClick(localView, n, getItemIdAtPosition(n));
        break;
        paramInt = 0;
        break label406;
        bool = false;
      }
    }
    l.a(false);
    return bool;
  }
  
  public final boolean hasFocus()
  {
    return (i) || (super.hasFocus());
  }
  
  public final boolean hasWindowFocus()
  {
    return (i) || (super.hasWindowFocus());
  }
  
  public final boolean isFocused()
  {
    return (i) || (super.isFocused());
  }
  
  public final boolean isInTouchMode()
  {
    return ((i) && (a)) || (super.isInTouchMode());
  }
}

/* Location:
 * Qualified Name:     ajq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */