import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class aab
  implements AdapterView.OnItemClickListener
{
  aab(zy paramzy, zs paramzs) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b.u.onClick(a.b, paramInt);
    if (!b.E) {
      a.b.dismiss();
    }
  }
}

/* Location:
 * Qualified Name:     aab
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */