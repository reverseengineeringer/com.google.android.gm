package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Parcelable;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import ei;
import java.util.ArrayList;

public final class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private final ArrayList<ei> a;
  private Context b;
  private FragmentManager c;
  private int d;
  private TabHost.OnTabChangeListener e;
  private ei f;
  private boolean g;
  
  private final FragmentTransaction a(String paramString, FragmentTransaction paramFragmentTransaction)
  {
    Object localObject = null;
    int i = 0;
    if (i < a.size())
    {
      ei localei = (ei)a.get(i);
      if (!a.equals(paramString)) {
        break label213;
      }
      localObject = localei;
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
      paramString = paramFragmentTransaction;
      if (f != localObject)
      {
        paramString = paramFragmentTransaction;
        if (paramFragmentTransaction == null) {
          paramString = c.beginTransaction();
        }
        if ((f != null) && (f.d != null)) {
          paramString.detach(f.d);
        }
        if (localObject != null)
        {
          if (d != null) {
            break label200;
          }
          d = Fragment.instantiate(b, b.getName(), c);
          paramString.add(d, d, a);
        }
      }
      for (;;)
      {
        f = ((ei)localObject);
        return paramString;
        paramString.attach(d);
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
      ei localei = (ei)a.get(i);
      d = c.findFragmentByTag(a);
      Object localObject2 = localObject1;
      if (d != null)
      {
        localObject2 = localObject1;
        if (!d.isDetached())
        {
          if (!a.equals(str)) {
            break label108;
          }
          f = localei;
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
          localObject2 = c.beginTransaction();
        }
        ((FragmentTransaction)localObject2).detach(d);
      }
    }
    g = true;
    localObject1 = a(str, (FragmentTransaction)localObject1);
    if (localObject1 != null)
    {
      ((FragmentTransaction)localObject1).commit();
      c.executePendingTransactions();
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
      FragmentTransaction localFragmentTransaction = a(paramString, null);
      if (localFragmentTransaction != null) {
        localFragmentTransaction.commit();
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
 * Qualified Name:     android.support.v13.app.FragmentTabHost
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */