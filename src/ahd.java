import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

final class ahd
  implements AdapterView.OnItemClickListener
{
  ahd(ahc paramahc, agz paramagz) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b.d.setSelection(paramInt);
    if (b.d.getOnItemClickListener() != null) {
      b.d.performItemClick(paramView, paramInt, b.b.getItemId(paramInt));
    }
    b.d();
  }
}

/* Location:
 * Qualified Name:     ahd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */