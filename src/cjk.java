import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.android.mail.browse.ConversationMessage;
import com.android.mail.providers.Conversation;

public final class cjk
  implements LoaderManager.LoaderCallbacks<ccy<ConversationMessage>>
{
  cjk(cjf paramcjf) {}
  
  public final Loader<ccy<ConversationMessage>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new cjj(a.b.g(), a.d.g);
  }
  
  public final void onLoaderReset(Loader<ccy<ConversationMessage>> paramLoader)
  {
    a.i = null;
  }
}

/* Location:
 * Qualified Name:     cjk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */