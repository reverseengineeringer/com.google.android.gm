import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import java.util.HashMap;

final class azr
  implements AdapterView.OnItemClickListener
{
  azr(azq paramazq) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = a.c.getItem(paramInt);
    if ((paramView instanceof cuq))
    {
      paramAdapterView = a;
      paramView = (cuq)paramView;
      if (!b) {
        paramInt = 1;
      }
      while (paramInt != 0)
      {
        c.getCount();
        paramInt = 0;
        for (;;)
        {
          if (paramInt < c.getCount())
          {
            Object localObject = c.getItem(paramInt);
            if ((localObject instanceof cuq)) {
              b = false;
            }
            paramInt += 1;
            continue;
            paramInt = 0;
            break;
          }
        }
        b.clear();
        b = true;
        c.notifyDataSetChanged();
        b.put(a, Boolean.valueOf(true));
        a.getButton(-1).setEnabled(true);
      }
    }
  }
}

/* Location:
 * Qualified Name:     azr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */