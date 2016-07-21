import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

final class zz
  extends ArrayAdapter<CharSequence>
{
  zz(zy paramzy, Context paramContext, int paramInt, CharSequence[] paramArrayOfCharSequence, ListView paramListView)
  {
    super(paramContext, paramInt, 16908308, paramArrayOfCharSequence);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    if ((b.C != null) && (b.C[paramInt] != 0)) {
      a.setItemChecked(paramInt, true);
    }
    return paramView;
  }
}

/* Location:
 * Qualified Name:     zz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */