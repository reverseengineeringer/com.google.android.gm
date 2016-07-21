import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

public final class cbc
  extends TouchDelegate
{
  private final View[] a;
  private final Rect[] b;
  private final Rect[] c;
  private final boolean[] d;
  private final int e;
  
  public cbc(View paramView1, View paramView2, View paramView3)
  {
    super(new Rect(), paramView1);
    Object localObject1 = paramView1.getContext();
    e = ViewConfiguration.get((Context)localObject1).getScaledTouchSlop();
    a = new View[3];
    b = new Rect[3];
    c = new Rect[3];
    d = new boolean[3];
    int i = 0;
    while (i < 3)
    {
      b[i] = new Rect();
      i += 1;
    }
    paramView1.getHitRect(b[0]);
    paramView2.getHitRect(b[1]);
    paramView3.getHitRect(b[2]);
    int j = ((Context)localObject1).getResources().getDimensionPixelSize(bua.R);
    localObject1 = b;
    int k = localObject1.length;
    i = 0;
    while (i < k)
    {
      Object localObject2 = localObject1[i];
      top -= j;
      bottom += j;
      i += 1;
    }
    i = 0;
    while (i < 3)
    {
      c[i] = new Rect(b[i]);
      i += 1;
    }
    localObject1 = c;
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject1[i].inset(-e, -e);
      i += 1;
    }
    a[0] = paramView1;
    a[1] = paramView2;
    a[2] = paramView3;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    boolean[] arrayOfBoolean = new boolean[3];
    int i = 0;
    while (i < 3)
    {
      arrayOfBoolean[i] = true;
      i += 1;
    }
    label78:
    boolean bool2;
    View localView;
    switch (paramMotionEvent.getAction())
    {
    default: 
      i = 0;
      if (i >= 3) {
        break label279;
      }
      bool2 = bool1;
      if (d[i] != 0)
      {
        localView = a[i];
        if (arrayOfBoolean[i] == 0) {
          break label256;
        }
        paramMotionEvent.setLocation(localView.getWidth() / 2, localView.getHeight() / 2);
      }
      break;
    }
    for (;;)
    {
      bool2 = bool1 | localView.dispatchTouchEvent(paramMotionEvent);
      i += 1;
      bool1 = bool2;
      break label78;
      i = 0;
      while (i < 3)
      {
        if (b[i].contains(j, k))
        {
          d[i] = true;
          break;
        }
        i += 1;
      }
      i = 0;
      while (i < 3)
      {
        if ((d[i] != 0) && (!c[i].contains(j, k))) {
          arrayOfBoolean[i] = false;
        }
        i += 1;
      }
      i = 0;
      while (i < 3)
      {
        d[i] = false;
        i += 1;
      }
      break;
      label256:
      paramMotionEvent.setLocation(-(e * 2), -(e * 2));
    }
    label279:
    return bool1;
  }
}

/* Location:
 * Qualified Name:     cbc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */