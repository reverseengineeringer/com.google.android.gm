import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public final class cpx
  extends BaseAdapter
{
  final ArrayList<coe> a = new ArrayList();
  
  public final void a(coe paramcoe)
  {
    a.add(paramcoe);
  }
  
  public final int getCount()
  {
    Iterator localIterator = a.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((coe)localIterator.next()).getCount() + i) {}
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      coe localcoe = (coe)localIterator.next();
      int i = localcoe.getCount();
      if (paramInt < i) {
        return localcoe.getItem(paramInt);
      }
      paramInt -= i;
    }
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    Iterator localIterator = a.iterator();
    int j = 0;
    int i = paramInt;
    coe localcoe;
    for (paramInt = j; localIterator.hasNext(); paramInt = localcoe.getViewTypeCount() + paramInt)
    {
      localcoe = (coe)localIterator.next();
      j = localcoe.getCount();
      if (i < j) {
        return localcoe.getItemViewType(i) + paramInt;
      }
      i -= j;
    }
    return -1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      coe localcoe = (coe)localIterator.next();
      int i = localcoe.getCount();
      if (paramInt < i) {
        return localcoe.getView(paramInt, paramView, paramViewGroup);
      }
      paramInt -= i;
    }
    return null;
  }
  
  public final int getViewTypeCount()
  {
    Iterator localIterator = a.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((Adapter)localIterator.next()).getViewTypeCount() + i) {}
    int j = i;
    if (i == 0) {
      j = 1;
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     cpx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */