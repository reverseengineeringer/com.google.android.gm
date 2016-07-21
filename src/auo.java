import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class auo
  extends BaseAdapter
{
  private List<aup> b;
  private final LayoutInflater c;
  
  public auo(Context paramContext, Map<String, atp> paramMap)
  {
    c = LayoutInflater.from(paramMap);
    Map localMap;
    a(localMap);
  }
  
  private final aup a(int paramInt)
  {
    return (aup)b.get(paramInt);
  }
  
  public final void a(Map<String, atp> paramMap)
  {
    b = new ArrayList();
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      if (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        List localList = b;
        String str = (String)paramMap.getKey();
        paramMap = getValueb;
        if (paramMap.equals(a.getString(arh.j))) {
          paramMap = a.getString(arh.bp);
        }
        for (;;)
        {
          localList.add(new aup(this, str, paramMap));
          break;
          if (paramMap.equals(a.getString(arh.k))) {
            paramMap = a.getString(arh.ci);
          } else if (paramMap.equals(a.getString(arh.i))) {
            paramMap = a.getString(arh.bj);
          } else {
            paramMap = a.getString(arh.bn);
          }
        }
      }
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
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aup localaup = a(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = c.inflate(arf.F, paramViewGroup, false);
      paramView = new auq(this);
      a = ((TextView)localView.findViewById(are.aj));
      b = ((TextView)localView.findViewById(are.I));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a.setText(a);
      b.setText(b);
      return localView;
      paramViewGroup = (auq)paramView.getTag();
      localView = paramView;
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     auo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */