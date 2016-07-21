import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import java.util.Map;

final class avu
  implements LoaderManager.LoaderCallbacks<Map<String, Object>>
{
  avu(avs paramavs) {}
  
  public final Loader<Map<String, Object>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    long l = paramBundle.getLong("MailboxId");
    return new avt(a.getActivity(), l);
  }
  
  public final void onLoaderReset(Loader<Map<String, Object>> paramLoader) {}
}

/* Location:
 * Qualified Name:     avu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */