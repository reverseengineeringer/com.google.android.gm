import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.view.menu.ExpandedMenuView;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

public final class ads
  implements aej, AdapterView.OnItemClickListener
{
  Context a;
  LayoutInflater b;
  adu c;
  ExpandedMenuView d;
  int e;
  int f;
  int g;
  public aek h;
  adt i;
  private int j;
  
  private ads(int paramInt)
  {
    g = paramInt;
    f = 0;
  }
  
  public ads(Context paramContext, int paramInt)
  {
    this(paramInt);
    a = paramContext;
    b = LayoutInflater.from(a);
  }
  
  public final ael a(ViewGroup paramViewGroup)
  {
    if (d == null)
    {
      d = ((ExpandedMenuView)b.inflate(ach.h, paramViewGroup, false));
      if (i == null) {
        i = new adt(this);
      }
      d.setAdapter(i);
      d.setOnItemClickListener(this);
    }
    return d;
  }
  
  public final void a(adu paramadu, boolean paramBoolean)
  {
    if (h != null) {
      h.a(paramadu, paramBoolean);
    }
  }
  
  public final void a(Context paramContext, adu paramadu)
  {
    if (f != 0)
    {
      a = new ContextThemeWrapper(paramContext, f);
      b = LayoutInflater.from(a);
    }
    for (;;)
    {
      c = paramadu;
      if (i != null) {
        i.notifyDataSetChanged();
      }
      return;
      if (a != null)
      {
        a = paramContext;
        if (b == null) {
          b = LayoutInflater.from(a);
        }
      }
    }
  }
  
  public final void a(Parcelable paramParcelable)
  {
    paramParcelable = ((Bundle)paramParcelable).getSparseParcelableArray("android:menu:list");
    if (paramParcelable != null) {
      d.restoreHierarchyState(paramParcelable);
    }
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(aep paramaep)
  {
    if (!paramaep.hasVisibleItems()) {
      return false;
    }
    adx localadx = new adx(paramaep);
    Object localObject2 = a;
    Object localObject1 = new aag(a);
    c = new ads(a.a, ach.k);
    c.h = localadx;
    a.a(c);
    Object localObject3 = c.c();
    a.t = ((ListAdapter)localObject3);
    a.u = localadx;
    localObject3 = h;
    if (localObject3 != null) {
      a.g = ((View)localObject3);
    }
    for (;;)
    {
      a.r = localadx;
      b = ((aag)localObject1).a();
      b.setOnDismissListener(localadx);
      localObject1 = b.getWindow().getAttributes();
      type = 1003;
      flags |= 0x20000;
      b.show();
      if (h != null) {
        h.a_(paramaep);
      }
      return true;
      localObject3 = g;
      a.d = ((Drawable)localObject3);
      localObject2 = f;
      a.f = ((CharSequence)localObject2);
    }
  }
  
  public final int b()
  {
    return j;
  }
  
  public final void b(boolean paramBoolean)
  {
    if (i != null) {
      i.notifyDataSetChanged();
    }
  }
  
  public final boolean b(ady paramady)
  {
    return false;
  }
  
  public final ListAdapter c()
  {
    if (i == null) {
      i = new adt(this);
    }
    return i;
  }
  
  public final boolean c(ady paramady)
  {
    return false;
  }
  
  public final Parcelable d()
  {
    if (d == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray = new SparseArray();
    if (d != null) {
      d.saveHierarchyState(localSparseArray);
    }
    localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    return localBundle;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    c.a(i.a(paramInt), this, 0);
  }
}

/* Location:
 * Qualified Name:     ads
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */