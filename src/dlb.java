import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;

abstract class dlb<R extends hlt, C extends dld>
  implements LoaderManager.LoaderCallbacks<dle<R>>
{
  static final String a = cvl.a;
  public final Context b;
  public final dkq c;
  public final C d;
  
  dlb(Context paramContext, dkq paramdkq, C paramC)
  {
    b = paramContext.getApplicationContext();
    c = paramdkq;
    d = paramC;
  }
  
  public abstract dlc<R> a(Bundle paramBundle);
  
  protected abstract void a(R paramR);
  
  public void onLoaderReset(Loader<dle<R>> paramLoader) {}
}

/* Location:
 * Qualified Name:     dlb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */