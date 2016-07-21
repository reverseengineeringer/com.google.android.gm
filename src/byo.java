import android.database.DataSetObserver;

final class byo
  extends DataSetObserver
{
  byo(byn parambyn) {}
  
  public final void onChanged()
  {
    a.notifyDataSetChanged();
  }
}

/* Location:
 * Qualified Name:     byo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */