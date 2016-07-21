import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.android.datetimepicker.date.TextViewWithCircularIndicator;
import java.util.List;

final class apl
  extends ArrayAdapter<String>
{
  public apl(Context paramContext, int paramInt, List<String> paramList)
  {
    super(paramInt, paramList, localList);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (TextViewWithCircularIndicator)super.getView(paramInt, paramView, paramViewGroup);
    paramView.requestLayout();
    paramInt = apj.a(paramView);
    if (a.a.a().a == paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      if (bool) {
        a.b = paramView;
      }
      return paramView;
    }
  }
}

/* Location:
 * Qualified Name:     apl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */