import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public final class cno
  extends BaseAdapter
{
  List<cdi> a = new ArrayList();
  
  public final int getCount()
  {
    return a.size();
  }
  
  public final Object getItem(int paramInt)
  {
    if (paramInt >= a.size()) {
      return null;
    }
    return a.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return getItem(paramInt).hashCode();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return ((cdi)getItem(paramInt)).a(paramView, paramViewGroup);
  }
}

/* Location:
 * Qualified Name:     cno
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */