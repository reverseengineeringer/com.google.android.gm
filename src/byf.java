import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.android.mail.browse.ConversationMessage;

final class byf
  implements LoaderManager.LoaderCallbacks<ConversationMessage>
{
  byf(byc parambyc) {}
  
  public final Loader<ConversationMessage> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new byb(a.getActivity(), a.i);
  }
  
  public final void onLoaderReset(Loader<ConversationMessage> paramLoader) {}
}

/* Location:
 * Qualified Name:     byf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */