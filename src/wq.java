import android.os.SystemClock;
import android.support.v4.widget.DrawerLayout;
import android.view.MotionEvent;
import android.view.View;

final class wq
  implements Runnable
{
  wq(wp paramwp) {}
  
  public final void run()
  {
    int k = 0;
    Object localObject2 = a;
    int m = b.h;
    int i;
    Object localObject1;
    int j;
    if (a == 3)
    {
      i = 1;
      if (i == 0) {
        break label226;
      }
      localObject1 = c.c(3);
      if (localObject1 == null) {
        break label221;
      }
      j = -((View)localObject1).getWidth();
      label56:
      j += m;
    }
    for (;;)
    {
      label61:
      if ((localObject1 != null) && (((i != 0) && (((View)localObject1).getLeft() < j)) || ((i == 0) && (((View)localObject1).getLeft() > j) && (c.a((View)localObject1) == 0))))
      {
        wn localwn = (wn)((View)localObject1).getLayoutParams();
        b.a((View)localObject1, j, ((View)localObject1).getTop());
        c = true;
        c.invalidate();
        ((wp)localObject2).c();
        localObject1 = c;
        if (!g)
        {
          long l = SystemClock.uptimeMillis();
          localObject2 = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          j = ((DrawerLayout)localObject1).getChildCount();
          i = k;
          for (;;)
          {
            if (i < j)
            {
              ((DrawerLayout)localObject1).getChildAt(i).dispatchTouchEvent((MotionEvent)localObject2);
              i += 1;
              continue;
              i = 0;
              break;
              label221:
              j = 0;
              break label56;
              label226:
              localObject1 = c.c(5);
              j = c.getWidth();
              j -= m;
              break label61;
            }
          }
          ((MotionEvent)localObject2).recycle();
          g = true;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     wq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */