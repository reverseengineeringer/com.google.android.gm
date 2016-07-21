import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gm.welcome.SetupAddressesFragment;

public final class eal
  extends DataSetObserver
{
  public eal(SetupAddressesFragment paramSetupAddressesFragment) {}
  
  public final void onChanged()
  {
    int i = 0;
    super.onChanged();
    cvm.b(SetupAddressesFragment.e, "SetupAddressesFragment: List of accounts changed.", new Object[0]);
    if (a.a == null) {}
    do
    {
      return;
      localObject = a.getActivity();
      if (localObject != null)
      {
        Intent localIntent = new Intent();
        localIntent.putParcelableArrayListExtra("pending-changes", a.a.b);
        ((Activity)localObject).setResult(0, localIntent);
      }
    } while (!a.isAdded());
    cvm.b(SetupAddressesFragment.e, "SetupAddressesFragment: Refreshing list", new Object[0]);
    a.d.removeAllViews();
    int j = a.a.getCount();
    while (i < j)
    {
      localObject = a.a.getView(i, null, a.d);
      a.d.addView((View)localObject);
      i += 1;
    }
    Object localObject = a.f;
    if (j > 0) {}
    for (i = dge.ge;; i = dge.gd)
    {
      ((TextView)localObject).setText(i);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     eal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */