import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class byn<T extends ListAdapter>
  extends BaseAdapter
{
  private List<T> a;
  private final DataSetObserver b = new byo(this);
  
  private final byp<T> a(int paramInt)
  {
    int m = a.size();
    int j = 0;
    int i = 0;
    while (i < m)
    {
      ListAdapter localListAdapter = (ListAdapter)a.get(i);
      int k = localListAdapter.getCount() + j;
      if (paramInt < k) {
        return new byp(localListAdapter, paramInt - j);
      }
      j = k;
      i += 1;
    }
    return null;
  }
  
  public final void a(T... paramVarArgs)
  {
    if (a != null)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        ((ListAdapter)localIterator.next()).unregisterDataSetObserver(b);
      }
    }
    a = Arrays.asList(paramVarArgs);
    paramVarArgs = a.iterator();
    while (paramVarArgs.hasNext()) {
      ((ListAdapter)paramVarArgs.next()).registerDataSetObserver(b);
    }
  }
  
  public final boolean areAllItemsEnabled()
  {
    Iterator localIterator = a.iterator();
    for (boolean bool = true; localIterator.hasNext(); bool = ((ListAdapter)localIterator.next()).areAllItemsEnabled() & bool) {}
    return bool;
  }
  
  public final int getCount()
  {
    Iterator localIterator = a.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((ListAdapter)localIterator.next()).getCount() + i) {}
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    byp localbyp = a(paramInt);
    if (localbyp == null) {
      return null;
    }
    return a.getItem(b);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    byp localbyp = a(paramInt);
    Iterator localIterator = a.iterator();
    ListAdapter localListAdapter;
    for (paramInt = 0; localIterator.hasNext(); paramInt = localListAdapter.getViewTypeCount() + paramInt)
    {
      localListAdapter = (ListAdapter)localIterator.next();
      if (localListAdapter == a) {
        break;
      }
    }
    int j = a.getItemViewType(b);
    int i = j;
    if (j >= 0) {
      i = j + paramInt;
    }
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    byp localbyp = a(paramInt);
    return a.getView(b, paramView, paramViewGroup);
  }
  
  public final int getViewTypeCount()
  {
    Iterator localIterator = a.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((ListAdapter)localIterator.next()).getViewTypeCount() + i) {}
    return i;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    byp localbyp = a(paramInt);
    return a.isEnabled(b);
  }
}

/* Location:
 * Qualified Name:     byn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */