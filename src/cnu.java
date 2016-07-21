import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.android.mail.providers.Account;
import java.util.ArrayList;
import java.util.List;

final class cnu
  extends BaseAdapter
{
  private final List<cdi> b = new ArrayList();
  
  cnu(cnk paramcnk)
  {
    a();
  }
  
  private final cdi a(int paramInt)
  {
    return (cdi)b.get(paramInt);
  }
  
  final void a()
  {
    if (a.e) {
      return;
    }
    b.clear();
    if (a.p != null) {
      b.add(new cdo(a.b, a.p, a.u));
    }
    if ((a.p != null) && (!cxa.b(a.p.r))) {
      b.add(new cdm(a.b, a.p, a.u));
    }
    if (!b.isEmpty())
    {
      b.add(0, cdi.a(a.b));
      b.add(new cdd(a.b));
    }
    notifyDataSetChanged();
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final int getCount()
  {
    return b.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return a(paramInt).b();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = a(paramInt).a(paramView, paramViewGroup);
    paramView.setAlpha(1.0F);
    paramView.setTranslationY(0.0F);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 10;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    cdi localcdi = a(paramInt);
    return (localcdi != null) && (localcdi.a());
  }
}

/* Location:
 * Qualified Name:     cnu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */