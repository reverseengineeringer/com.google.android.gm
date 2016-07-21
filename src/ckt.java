import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Loader;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Bundle;
import java.util.Set;

public class ckt
  implements LoaderManager.LoaderCallbacks<hel<String, btn>>, bto
{
  public Set<String> a;
  public final Context b;
  private hel<String, btn> c;
  private final DataSetObservable d = new DataSetObservable();
  
  public ckt(Context paramContext)
  {
    b = paramContext;
  }
  
  public final btn a(String paramString)
  {
    if (c == null) {
      return null;
    }
    return (btn)c.get(paramString);
  }
  
  public final void a(DataSetObserver paramDataSetObserver)
  {
    d.registerObserver(paramDataSetObserver);
  }
  
  public final void b(DataSetObserver paramDataSetObserver)
  {
    d.unregisterObserver(paramDataSetObserver);
  }
  
  public Loader<hel<String, btn>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new bun(b, a);
  }
  
  public void onLoaderReset(Loader<hel<String, btn>> paramLoader) {}
}

/* Location:
 * Qualified Name:     ckt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */