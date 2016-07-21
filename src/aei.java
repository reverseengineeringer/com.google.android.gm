import android.support.v7.view.menu.ListMenuItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

final class aei
  extends BaseAdapter
{
  adu a;
  private int c = -1;
  
  public aei(aeh paramaeh, adu paramadu)
  {
    a = paramadu;
    a();
  }
  
  private final void a()
  {
    ady localady = b.c.k;
    if (localady != null)
    {
      ArrayList localArrayList = b.c.j();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((ady)localArrayList.get(i) == localady)
        {
          c = i;
          return;
        }
        i += 1;
      }
    }
    c = -1;
  }
  
  public final ady a(int paramInt)
  {
    if (b.d) {}
    for (ArrayList localArrayList = a.j();; localArrayList = a.h())
    {
      int i = paramInt;
      if (c >= 0)
      {
        i = paramInt;
        if (paramInt >= c) {
          i = paramInt + 1;
        }
      }
      return (ady)localArrayList.get(i);
    }
  }
  
  public final int getCount()
  {
    if (b.d) {}
    for (ArrayList localArrayList = a.j(); c < 0; localArrayList = a.h()) {
      return localArrayList.size();
    }
    return localArrayList.size() - 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = b.b.inflate(aeh.a, paramViewGroup, false);
    }
    for (;;)
    {
      paramViewGroup = (aem)paramView;
      if (b.h)
      {
        ListMenuItemView localListMenuItemView = (ListMenuItemView)paramView;
        b = true;
        a = true;
      }
      paramViewGroup.a(a(paramInt));
      return paramView;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}

/* Location:
 * Qualified Name:     aei
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */