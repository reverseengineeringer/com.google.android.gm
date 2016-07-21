import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

final class ahb
  implements ListAdapter, SpinnerAdapter
{
  private SpinnerAdapter a;
  private ListAdapter b;
  
  public ahb(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
  {
    a = paramSpinnerAdapter;
    if ((paramSpinnerAdapter instanceof ListAdapter)) {
      b = ((ListAdapter)paramSpinnerAdapter);
    }
    if (paramTheme != null)
    {
      if ((!agz.a) || (!(paramSpinnerAdapter instanceof ThemedSpinnerAdapter))) {
        break label64;
      }
      paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
      if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
        paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
      }
    }
    label64:
    do
    {
      do
      {
        return;
      } while (!(paramSpinnerAdapter instanceof amk));
      paramSpinnerAdapter = (amk)paramSpinnerAdapter;
    } while (paramSpinnerAdapter.getDropDownViewTheme() != null);
    paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
  }
  
  public final boolean areAllItemsEnabled()
  {
    ListAdapter localListAdapter = b;
    if (localListAdapter != null) {
      return localListAdapter.areAllItemsEnabled();
    }
    return true;
  }
  
  public final int getCount()
  {
    if (a == null) {
      return 0;
    }
    return a.getCount();
  }
  
  public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (a == null) {
      return null;
    }
    return a.getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public final Object getItem(int paramInt)
  {
    if (a == null) {
      return null;
    }
    return a.getItem(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    if (a == null) {
      return -1L;
    }
    return a.getItemId(paramInt);
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final boolean hasStableIds()
  {
    return (a != null) && (a.hasStableIds());
  }
  
  public final boolean isEmpty()
  {
    return getCount() == 0;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    ListAdapter localListAdapter = b;
    if (localListAdapter != null) {
      return localListAdapter.isEnabled(paramInt);
    }
    return true;
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (a != null) {
      a.registerDataSetObserver(paramDataSetObserver);
    }
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (a != null) {
      a.unregisterDataSetObserver(paramDataSetObserver);
    }
  }
}

/* Location:
 * Qualified Name:     ahb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */