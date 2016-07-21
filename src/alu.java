import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;

final class alu
  extends BaseAdapter
{
  alu(als paramals) {}
  
  public final int getCount()
  {
    return a.b.getChildCount();
  }
  
  public final Object getItem(int paramInt)
  {
    return a.b.getChildAt(paramInt)).a;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = a;
      paramViewGroup = (zg)getItem(paramInt);
      paramViewGroup = new alv(paramView, paramView.getContext(), paramViewGroup, true);
      paramViewGroup.setBackgroundDrawable(null);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, f));
      return paramViewGroup;
    }
    paramViewGroup = (alv)paramView;
    a = ((zg)getItem(paramInt));
    paramViewGroup.a();
    return paramView;
  }
}

/* Location:
 * Qualified Name:     alu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */