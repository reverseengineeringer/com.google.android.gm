import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.android.mail.providers.Account;

public class asv
  extends Fragment
{
  Account a;
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getActivity();
    int i = arf.C;
    int j = are.aK;
    paramBundle = new SimpleCursorAdapter(paramBundle, i, null, new String[] { "quickResponse" }, new int[] { j }, 0);
    ((ListView)getView().findViewById(are.r)).setAdapter(paramBundle);
    getLoaderManager().initLoader(0, null, new asw(this, paramBundle));
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a = ((Account)getArguments().getParcelable("account"));
    setHasOptionsMenu(true);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    paramMenuInflater.inflate(arg.a, paramMenu);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(arf.d, paramViewGroup, false);
    paramViewGroup = (ListView)paramLayoutInflater.findViewById(are.r);
    paramViewGroup.setEmptyView((TextView)((ViewGroup)paramViewGroup.getParent()).findViewById(are.ak));
    paramViewGroup.setOnItemClickListener(new asx(this, paramViewGroup));
    return paramLayoutInflater;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == are.P)
    {
      avo.a(null, a.H, true).show(getFragmentManager(), null);
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:
 * Qualified Name:     asv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */