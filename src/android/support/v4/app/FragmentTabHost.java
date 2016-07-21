package android.support.v4.app;

import android.content.Context;
import android.os.Parcelable;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import fq;
import gc;
import gd;
import java.util.ArrayList;

public final class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private final ArrayList<gc> a;
  private Context b;
  private fq c;
  private int d;
  private TabHost.OnTabChangeListener e;
  private gc f;
  private boolean g;
  
  private final gd a(String paramString, gd paramgd)
  {
    Object localObject = null;
    int i = 0;
    if (i < a.size())
    {
      gc localgc = (gc)a.get(i);
      if (!a.equals(paramString)) {
        break label213;
      }
      localObject = localgc;
    }
    label200:
    label213:
    for (;;)
    {
      i += 1;
      break;
      if (localObject == null) {
        throw new IllegalStateException("No tab known for tag " + paramString);
      }
      paramString = paramgd;
      if (f != localObject)
      {
        paramString = paramgd;
        if (paramgd == null) {
          paramString = c.a();
        }
        if ((f != null) && (f.d != null)) {
          paramString.b(f.d);
        }
        if (localObject != null)
        {
          if (d != null) {
            break label200;
          }
          d = Fragment.a(b, b.getName(), c);
          paramString.a(d, d, a);
        }
      }
      for (;;)
      {
        f = ((gc)localObject);
        return paramString;
        paramString.c(d);
      }
    }
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    Object localObject1 = null;
    int i = 0;
    if (i < a.size())
    {
      gc localgc = (gc)a.get(i);
      d = c.a(a);
      Object localObject2 = localObject1;
      if (d != null)
      {
        localObject2 = localObject1;
        if (!d.J)
        {
          if (!a.equals(str)) {
            break label108;
          }
          f = localgc;
          localObject2 = localObject1;
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        label108:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = c.a();
        }
        ((gd)localObject2).b(d);
      }
    }
    g = true;
    localObject1 = a(str, (gd)localObject1);
    if (localObject1 != null)
    {
      ((gd)localObject1).b();
      c.b();
    }
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    g = false;
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof FragmentTabHost.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (FragmentTabHost.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(a);
  }
  
  protected final Parcelable onSaveInstanceState()
  {
    FragmentTabHost.SavedState localSavedState = new FragmentTabHost.SavedState(super.onSaveInstanceState());
    a = getCurrentTabTag();
    return localSavedState;
  }
  
  public final void onTabChanged(String paramString)
  {
    if (g)
    {
      gd localgd = a(paramString, null);
      if (localgd != null) {
        localgd.b();
      }
    }
    if (e != null) {
      e.onTabChanged(paramString);
    }
  }
  
  public final void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    e = paramOnTabChangeListener;
  }
  
  @Deprecated
  public final void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentTabHost
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */