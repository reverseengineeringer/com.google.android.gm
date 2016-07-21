import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

final class div
  extends ArrayAdapter<String>
{
  div(Context paramContext, int paramInt, List paramList)
  {
    super(paramContext, paramInt, paramList);
  }
  
  public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (TextView)super.getDropDownView(paramInt, paramView, paramViewGroup);
    paramViewGroup = (String)getItem(paramInt);
    if ("READER".equals(paramViewGroup)) {
      paramInt = dge.ck;
    }
    for (;;)
    {
      paramView.setText(paramInt);
      return paramView;
      if ("COMMENTER".equals(paramViewGroup)) {
        paramInt = dge.ci;
      } else if ("WRITER".equals(paramViewGroup)) {
        paramInt = dge.cj;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (TextView)super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = (String)getItem(paramInt);
    if ("READER".equals(paramViewGroup)) {
      paramInt = dge.ck;
    }
    for (;;)
    {
      paramView.setText(paramInt);
      return paramView;
      if ("COMMENTER".equals(paramViewGroup)) {
        paramInt = dge.ci;
      } else if ("WRITER".equals(paramViewGroup)) {
        paramInt = dge.cj;
      } else {
        paramInt = 0;
      }
    }
  }
}

/* Location:
 * Qualified Name:     div
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */