import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class xb
  extends ux
{
  xb(xa paramxa) {}
  
  public final uk a(int paramInt)
  {
    xa localxa = b;
    Object localObject1;
    switch (paramInt)
    {
    default: 
      localObject1 = uk.a(uk.a.a());
      ((uk)localObject1).g(true);
      ((uk)localObject1).b(xa.a);
      ((uk)localObject1).b(xa.c);
      localxa.a(paramInt, (uk)localObject1);
      if ((((uk)localObject1).j() == null) && (((uk)localObject1).k() == null)) {
        throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
      }
      break;
    case -1: 
      localObject1 = h;
      localObject1 = uk.a(uk.a.a((View)localObject1));
      localObject2 = h;
      rg.a.a((View)localObject2, (uk)localObject1);
      localObject2 = new LinkedList();
      localxa.a((List)localObject2);
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject2).next();
        View localView = h;
        paramInt = localInteger.intValue();
        uk.a.b(b, localView, paramInt);
      }
      return (uk)localObject1;
    }
    ((uk)localObject1).a(e);
    if (e.equals(xa.c)) {
      throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }
    int i = ((uk)localObject1).a();
    if ((i & 0x40) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    if ((i & 0x80) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    ((uk)localObject1).a(h.getContext().getPackageName());
    Object localObject2 = h;
    uk.a.a(b, (View)localObject2, paramInt);
    ((uk)localObject1).a(h);
    if (i == paramInt)
    {
      ((uk)localObject1).d(true);
      ((uk)localObject1).a(128);
    }
    for (;;)
    {
      if (localxa.a(e))
      {
        ((uk)localObject1).c(true);
        ((uk)localObject1).b(e);
      }
      h.getLocationOnScreen(f);
      paramInt = f[0];
      i = f[1];
      d.set(e);
      d.offset(paramInt, i);
      ((uk)localObject1).d(d);
      return (uk)localObject1;
      ((uk)localObject1).d(false);
      ((uk)localObject1).a(64);
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Object localObject = b;
    switch (paramInt1)
    {
    default: 
      switch (paramInt2)
      {
      default: 
        return ((xa)localObject).b(paramInt1, paramInt2);
      }
      break;
    }
    localObject = h;
    return rg.a.a((View)localObject, paramInt2, paramBundle);
    switch (paramInt2)
    {
    default: 
      return false;
    case 64: 
      if ((!g.isEnabled()) || (!ug.a(g))) {
        return false;
      }
      if (!((xa)localObject).a(paramInt1))
      {
        if (i != Integer.MIN_VALUE) {
          ((xa)localObject).a(i, 65536);
        }
        i = paramInt1;
        h.invalidate();
        ((xa)localObject).a(paramInt1, 32768);
        return true;
      }
      return false;
    }
    if (((xa)localObject).a(paramInt1))
    {
      i = Integer.MIN_VALUE;
      h.invalidate();
      ((xa)localObject).a(paramInt1, 65536);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     xb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */