import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import java.util.HashMap;

public abstract class apa
  extends BaseAdapter
  implements apf
{
  public static int c = 7;
  public final aos a;
  boolean b = false;
  private final Context d;
  private apb e;
  
  public apa(Context paramContext, aos paramaos)
  {
    d = paramContext;
    a = paramaos;
    e = new apb(System.currentTimeMillis());
    a(a.a());
  }
  
  public abstract apc a(Context paramContext);
  
  public final void a(apb paramapb)
  {
    e = paramapb;
    notifyDataSetChanged();
  }
  
  public final void b(apb paramapb)
  {
    a.g();
    a.a(a, b, c);
    a(paramapb);
  }
  
  public int getCount()
  {
    return (a.d() - a.c() + 1) * 12;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    int i = -1;
    paramViewGroup = null;
    Object localObject;
    int k;
    int m;
    if (paramView != null)
    {
      paramViewGroup = (apc)paramView;
      paramView = (HashMap)paramViewGroup.getTag();
      localObject = paramView;
      if (paramView == null) {
        localObject = new HashMap();
      }
      ((HashMap)localObject).clear();
      k = paramInt % 12;
      m = paramInt / 12 + a.c();
      if ((e.a != m) || (e.b != k)) {
        break label242;
      }
    }
    label242:
    for (paramInt = j;; paramInt = 0)
    {
      if (paramInt != 0) {
        i = e.c;
      }
      K = 6;
      paramViewGroup.requestLayout();
      ((HashMap)localObject).put("selected_day", Integer.valueOf(i));
      ((HashMap)localObject).put("year", Integer.valueOf(m));
      ((HashMap)localObject).put("month", Integer.valueOf(k));
      ((HashMap)localObject).put("week_start", Integer.valueOf(a.b()));
      paramViewGroup.a((HashMap)localObject);
      paramViewGroup.invalidate();
      return paramViewGroup;
      localObject = a(d);
      ((apc)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      ((apc)localObject).setClickable(true);
      L = this;
      S = b;
      paramView = paramViewGroup;
      paramViewGroup = (ViewGroup)localObject;
      break;
    }
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     apa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */