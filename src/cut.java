import android.app.Fragment;
import android.app.Fragment.SavedState;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class cut
  extends qv
{
  private final FragmentManager a;
  private FragmentTransaction b = null;
  private final ArrayList<Fragment.SavedState> c = new ArrayList();
  private oj<Fragment> d = new oj();
  private Fragment e = null;
  private boolean f;
  
  public cut(FragmentManager paramFragmentManager)
  {
    this(paramFragmentManager, true);
  }
  
  public cut(FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    a = paramFragmentManager;
    f = paramBoolean;
  }
  
  public final Object a(ViewGroup paramViewGroup, int paramInt)
  {
    Fragment localFragment = (Fragment)d.a(paramInt);
    if (localFragment != null) {
      return localFragment;
    }
    if (b == null) {
      b = a.beginTransaction();
    }
    localFragment = b(paramInt);
    if ((f) && (c.size() > paramInt))
    {
      Fragment.SavedState localSavedState = (Fragment.SavedState)c.get(paramInt);
      if (localSavedState != null) {
        localFragment.setInitialSavedState(localSavedState);
      }
    }
    if (localFragment != e) {
      a(localFragment, false);
    }
    d.a(paramInt, localFragment);
    b.add(paramViewGroup.getId(), localFragment);
    return localFragment;
  }
  
  public void a(Fragment paramFragment, boolean paramBoolean)
  {
    eb.a.a(paramFragment, paramBoolean);
    eb.a.b(paramFragment, paramBoolean);
  }
  
  public void a(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      Bundle localBundle = (Bundle)paramParcelable;
      localBundle.setClassLoader(paramClassLoader);
      d.b();
      int i;
      if (f)
      {
        paramParcelable = localBundle.getParcelableArray("states");
        c.clear();
        if (paramParcelable != null)
        {
          i = 0;
          while (i < paramParcelable.length)
          {
            c.add((Fragment.SavedState)paramParcelable[i]);
            i += 1;
          }
        }
      }
      paramClassLoader = localBundle.keySet().iterator();
      while (paramClassLoader.hasNext())
      {
        paramParcelable = (String)paramClassLoader.next();
        if (paramParcelable.startsWith("f"))
        {
          i = Integer.parseInt(paramParcelable.substring(1));
          Fragment localFragment = a.getFragment(localBundle, paramParcelable);
          if (localFragment != null)
          {
            a(localFragment, false);
            d.a(i, localFragment);
          }
          else
          {
            paramParcelable = String.valueOf(paramParcelable);
            if (paramParcelable.length() != 0) {}
            for (paramParcelable = "Bad fragment at key ".concat(paramParcelable);; paramParcelable = new String("Bad fragment at key "))
            {
              cvm.d("FSPA", paramParcelable, new Object[0]);
              break;
            }
          }
        }
      }
    }
  }
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (b == null) {
      b = a.beginTransaction();
    }
    if (f)
    {
      while (c.size() <= paramInt) {
        c.add(null);
      }
      c.set(paramInt, a.saveFragmentInstanceState(paramViewGroup));
    }
    d.b(paramInt);
    b.remove(paramViewGroup);
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public abstract Fragment b(int paramInt);
  
  public final void b()
  {
    if (b != null)
    {
      b.commitAllowingStateLoss();
      b = null;
      a.executePendingTransactions();
    }
  }
  
  public void b(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (paramViewGroup != e)
    {
      if (e != null) {
        a(e, false);
      }
      if (paramViewGroup != null) {
        a(paramViewGroup, true);
      }
      e = paramViewGroup;
    }
  }
  
  public final Fragment c(int paramInt)
  {
    return (Fragment)d.a(paramInt);
  }
  
  public Parcelable d()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (f)
    {
      localObject1 = localObject2;
      if (c.size() > 0)
      {
        localObject1 = new Bundle();
        localObject2 = new Fragment.SavedState[c.size()];
        c.toArray((Object[])localObject2);
        ((Bundle)localObject1).putParcelableArray("states", (Parcelable[])localObject2);
      }
    }
    int i = 0;
    for (localObject2 = localObject1; i < d.a(); localObject2 = localObject1)
    {
      int j = d.e(i);
      Fragment localFragment = (Fragment)d.f(i);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      localObject2 = 12 + "f" + j;
      a.putFragment((Bundle)localObject1, (String)localObject2, localFragment);
      i += 1;
    }
    return (Parcelable)localObject2;
  }
  
  public void e()
  {
    oj localoj = new oj(d.a());
    int i = 0;
    if (i < d.a())
    {
      int j = d.e(i);
      Fragment localFragment = (Fragment)d.f(i);
      int k = b(localFragment);
      if (k != -2)
      {
        if (k < 0) {
          break label85;
        }
        j = k;
      }
      label85:
      for (;;)
      {
        localoj.a(j, localFragment);
        i += 1;
        break;
      }
    }
    d = localoj;
    super.e();
  }
}

/* Location:
 * Qualified Name:     cut
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */