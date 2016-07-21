import android.database.DataSetObserver;
import android.support.v7.widget.ActivityChooserView;

public final class afv
  extends DataSetObserver
{
  public afv(ActivityChooserView paramActivityChooserView) {}
  
  public final void onChanged()
  {
    super.onChanged();
    a.a.notifyDataSetChanged();
  }
  
  public final void onInvalidated()
  {
    super.onInvalidated();
    a.a.notifyDataSetInvalidated();
  }
}

/* Location:
 * Qualified Name:     afv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */