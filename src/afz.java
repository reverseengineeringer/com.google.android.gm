import android.content.Context;
import android.content.pm.ResolveInfo;
import android.support.v7.widget.ActivityChooserView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public final class afz
  extends BaseAdapter
{
  public afo a;
  boolean b;
  private int d = 4;
  private boolean e;
  private boolean f;
  
  public afz(ActivityChooserView paramActivityChooserView) {}
  
  public final int a()
  {
    int i = 0;
    int k = d;
    d = Integer.MAX_VALUE;
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = getCount();
    View localView = null;
    int j = 0;
    while (i < i1)
    {
      localView = getView(i, localView, null);
      localView.measure(m, n);
      j = Math.max(j, localView.getMeasuredWidth());
      i += 1;
    }
    d = k;
    return j;
  }
  
  public final void a(int paramInt)
  {
    if (d != paramInt)
    {
      d = paramInt;
      notifyDataSetChanged();
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (f != paramBoolean)
    {
      f = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((b != paramBoolean1) || (e != paramBoolean2))
    {
      b = paramBoolean1;
      e = paramBoolean2;
      notifyDataSetChanged();
    }
  }
  
  public final int getCount()
  {
    int j = a.a();
    int i = j;
    if (!b)
    {
      i = j;
      if (a.b() != null) {
        i = j - 1;
      }
    }
    j = Math.min(i, d);
    i = j;
    if (f) {
      i = j + 1;
    }
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      return null;
    }
    int i = paramInt;
    if (!b)
    {
      i = paramInt;
      if (a.b() != null) {
        i = paramInt + 1;
      }
    }
    return a.a(i);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if ((f) && (paramInt == getCount() - 1)) {
      return 1;
    }
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    switch (getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getId() == 1) {}
      }
      else
      {
        localView = LayoutInflater.from(c.getContext()).inflate(ach.f, paramViewGroup, false);
        localView.setId(1);
        ((TextView)localView.findViewById(acf.D)).setText(c.getContext().getString(aci.b));
      }
      return localView;
    }
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getId() == acf.u) {}
    }
    else
    {
      localView = LayoutInflater.from(c.getContext()).inflate(ach.f, paramViewGroup, false);
    }
    paramView = c.getContext().getPackageManager();
    paramViewGroup = (ImageView)localView.findViewById(acf.s);
    ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
    paramViewGroup.setImageDrawable(localResolveInfo.loadIcon(paramView));
    ((TextView)localView.findViewById(acf.D)).setText(localResolveInfo.loadLabel(paramView));
    if ((b) && (paramInt == 0) && (e))
    {
      rg.a(localView, true);
      return localView;
    }
    rg.a(localView, false);
    return localView;
  }
  
  public final int getViewTypeCount()
  {
    return 3;
  }
}

/* Location:
 * Qualified Name:     afz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */