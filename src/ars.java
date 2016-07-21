import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public final class ars
  extends Fragment
{
  int a = 0;
  Context b;
  final Handler c = new Handler();
  
  final void a()
  {
    LoaderManager localLoaderManager = getLoaderManager();
    localLoaderManager.destroyLoader(0);
    localLoaderManager.destroyLoader(3);
    localLoaderManager.initLoader(1, getArguments(), new asc(this));
  }
  
  final void b()
  {
    LoaderManager localLoaderManager = getLoaderManager();
    localLoaderManager.destroyLoader(0);
    localLoaderManager.destroyLoader(1);
    localLoaderManager.initLoader(3, getArguments(), new art(this));
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    b = getActivity().getApplicationContext();
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a = 3;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRetainInstance(true);
    if (paramBundle != null) {
      a = paramBundle.getInt("AccountCreationFragment.stage");
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    switch (a)
    {
    case 2: 
    default: 
      return;
    case 0: 
      LoaderManager localLoaderManager = getLoaderManager();
      localLoaderManager.destroyLoader(1);
      localLoaderManager.destroyLoader(3);
      localLoaderManager.initLoader(0, getArguments(), new ary(this));
      return;
    case 1: 
      a();
      return;
    }
    b();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("AccountCreationFragment.stage", a);
  }
}

/* Location:
 * Qualified Name:     ars
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */