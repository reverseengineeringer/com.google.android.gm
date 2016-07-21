import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

final class aac
  implements AdapterView.OnItemClickListener
{
  aac(zy paramzy, ListView paramListView, zs paramzs) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (c.C != null) {
      c.C[paramInt] = a.isItemChecked(paramInt);
    }
    c.G.onClick(b.b, paramInt, a.isItemChecked(paramInt));
  }
}

/* Location:
 * Qualified Name:     aac
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */