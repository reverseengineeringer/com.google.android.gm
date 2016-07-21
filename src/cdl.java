import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

final class cdl
  extends cdi
{
  private final int f;
  
  cdl(ckv paramckv, int paramInt)
  {
    super(paramckv, null, 0, null);
    f = paramInt;
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {}
    for (;;)
    {
      ((TextView)paramView.findViewById(buc.bN)).setText(f);
      return paramView;
      paramView = d.inflate(bue.G, paramViewGroup, false);
    }
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(cus paramcus, int paramInt)
  {
    return false;
  }
  
  public final int b()
  {
    return 1;
  }
  
  public final String toString()
  {
    int i = f;
    return 47 + "[DrawerItem VIEW_HEADER, mResource=" + i + "]";
  }
}

/* Location:
 * Qualified Name:     cdl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */