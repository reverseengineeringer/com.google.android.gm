import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.Menu;
import android.view.MenuInflater;

public class cse
  extends PreferenceFragment
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    paramMenuInflater.inflate(buf.m, paramMenu);
  }
}

/* Location:
 * Qualified Name:     cse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */