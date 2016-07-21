import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public final class cch
  extends ArrayAdapter<String>
  implements amk
{
  private final LayoutInflater a;
  private final aml b;
  
  public cch(Context paramContext)
  {
    super(paramContext, bue.g, paramContext.getResources().getStringArray(btw.c));
    a = LayoutInflater.from(paramContext);
    b = new aml(paramContext);
  }
  
  private final View a(LayoutInflater paramLayoutInflater, int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = paramLayoutInflater.inflate(paramInt2, paramViewGroup, false);
    }
    ((TextView)localView.findViewById(buc.cQ)).setText((CharSequence)getItem(paramInt1));
    return localView;
  }
  
  public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = b;
    if (c != null) {}
    for (localObject = c;; localObject = b) {
      return a((LayoutInflater)localObject, paramInt, paramView, paramViewGroup, bue.h);
    }
  }
  
  public final Resources.Theme getDropDownViewTheme()
  {
    aml localaml = b;
    if (c == null) {
      return null;
    }
    return c.getContext().getTheme();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(a, paramInt, paramView, paramViewGroup, bue.g);
  }
  
  public final void setDropDownViewTheme(Resources.Theme paramTheme)
  {
    aml localaml = b;
    if (paramTheme == null)
    {
      c = null;
      return;
    }
    if (paramTheme == a.getTheme())
    {
      c = b;
      return;
    }
    c = LayoutInflater.from(new adc(a, paramTheme));
  }
}

/* Location:
 * Qualified Name:     cch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */