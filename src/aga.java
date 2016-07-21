import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import java.util.List;

public final class aga
  implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  public aga(ActivityChooserView paramActivityChooserView) {}
  
  public final void onClick(View paramView)
  {
    if (paramView == a.f)
    {
      a.b();
      paramView = a.a.a.b();
      int i = a.a.a.a(paramView);
      paramView = a.a.a.b(i);
      if (paramView != null)
      {
        paramView.addFlags(524288);
        a.getContext().startActivity(paramView);
      }
      return;
    }
    if (paramView == a.d)
    {
      a.k = false;
      a.a(a.l);
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public final void onDismiss()
  {
    if (a.j != null) {
      a.j.onDismiss();
    }
    if (a.h != null) {
      a.h.a(false);
    }
  }
  
  public final void onItemClick(AdapterView<?> arg1, View paramView, int paramInt, long paramLong)
  {
    switch (((afz)???.getAdapter()).getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      a.a(Integer.MAX_VALUE);
    }
    do
    {
      return;
      a.b();
      if (!a.k) {
        break;
      }
    } while (paramInt <= 0);
    paramView = a.a.a;
    for (;;)
    {
      synchronized (b)
      {
        paramView.d();
        afp localafp1 = (afp)c.get(paramInt);
        afp localafp2 = (afp)c.get(0);
        if (localafp2 != null)
        {
          f = b - b + 5.0F;
          paramView.a(new afs(new ComponentName(a.activityInfo.packageName, a.activityInfo.name), System.currentTimeMillis(), f));
          return;
        }
      }
      float f = 1.0F;
    }
    if (a.a.b) {}
    for (;;)
    {
      ??? = a.a.a.b(paramInt);
      if (??? == null) {
        break;
      }
      ???.addFlags(524288);
      a.getContext().startActivity(???);
      return;
      paramInt += 1;
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    if (paramView == a.f)
    {
      if (a.a.getCount() > 0)
      {
        a.k = true;
        a.a(a.l);
      }
      return true;
    }
    throw new IllegalArgumentException();
  }
}

/* Location:
 * Qualified Name:     aga
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */