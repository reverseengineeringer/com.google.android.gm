package android.support.design.widget;

import ad;
import android.view.MotionEvent;
import android.view.View;
import cc;
import cd;
import qk;
import yy;
import zb;

public class SwipeDismissBehavior<V extends View>
  extends ad<V>
{
  private boolean a;
  public yy b;
  public cd c;
  public int d = 2;
  public float e = 0.5F;
  public float f = 0.0F;
  public float g = 0.5F;
  private float h = 0.0F;
  private boolean i;
  private final zb j = new cc(this);
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(Math.max(0.0F, paramFloat2), 1.0F);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    switch (qk.a(paramMotionEvent))
    {
    case 2: 
    default: 
      if (paramCoordinatorLayout.a(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      do
      {
        if (!a) {
          break;
        }
        return false;
      } while (!a);
      a = false;
      return false;
    }
    if (b == null) {
      if (!i) {
        break label129;
      }
    }
    label129:
    for (paramCoordinatorLayout = yy.a(paramCoordinatorLayout, h, j);; paramCoordinatorLayout = yy.a(paramCoordinatorLayout, j))
    {
      b = paramCoordinatorLayout;
      return b.a(paramMotionEvent);
    }
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (b != null)
    {
      b.b(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public boolean b(View paramView)
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.SwipeDismissBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */