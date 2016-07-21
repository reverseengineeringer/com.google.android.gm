import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

public final class ase
  extends Fragment
{
  Context a;
  final Handler b = new Handler();
  final cog c = new asf(this, "onAccountFinalizeComplete", this);
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a = getActivity().getApplicationContext();
    setRetainInstance(true);
  }
  
  public final void onResume()
  {
    super.onResume();
    getLoaderManager().initLoader(0, getArguments(), new asg(this));
  }
}

/* Location:
 * Qualified Name:     ase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */