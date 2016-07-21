import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

final class adt
  extends BaseAdapter
{
  private int b = -1;
  
  public adt(ads paramads)
  {
    a();
  }
  
  private final void a()
  {
    ady localady = a.c.k;
    if (localady != null)
    {
      ArrayList localArrayList = a.c.j();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((ady)localArrayList.get(i) == localady)
        {
          b = i;
          return;
        }
        i += 1;
      }
    }
    b = -1;
  }
  
  public final ady a(int paramInt)
  {
    ArrayList localArrayList = a.c.j();
    int i = a.e + paramInt;
    paramInt = i;
    if (b >= 0)
    {
      paramInt = i;
      if (i >= b) {
        paramInt = i + 1;
      }
    }
    return (ady)localArrayList.get(paramInt);
  }
  
  public final int getCount()
  {
    int i = a.c.j().size() - a.e;
    if (b < 0) {
      return i;
    }
    return i - 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = a.b.inflate(a.g, paramViewGroup, false);
    }
    for (;;)
    {
      ((aem)paramView).a(a(paramInt));
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
 * Qualified Name:     adt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */