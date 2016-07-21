import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

final class asx
  implements AdapterView.OnItemClickListener
{
  asx(asv paramasv, ListView paramListView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Cursor)a.getItemAtPosition(paramInt);
    avo.a(paramAdapterView.getString(paramAdapterView.getColumnIndex("quickResponse")), cxa.f(paramAdapterView.getString(paramAdapterView.getColumnIndex("uri"))), false).show(b.getFragmentManager(), null);
  }
}

/* Location:
 * Qualified Name:     asx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */