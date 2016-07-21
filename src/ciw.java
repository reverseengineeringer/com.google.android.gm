import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.DataSetObservable;
import android.os.Bundle;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;

final class ciw
  implements LoaderManager.LoaderCallbacks<bwg>
{
  ciw(cht paramcht) {}
  
  public final Loader<bwg> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    Account localAccount = (Account)paramBundle.getParcelable("account");
    Folder localFolder = (Folder)paramBundle.getParcelable("folder");
    boolean bool = paramBundle.getBoolean("ignore-initial-conversation-limit", false);
    if ((localAccount == null) || (localFolder == null)) {
      return null;
    }
    return new ckx(a.g, localAccount, h, localFolder.b(), bool);
  }
  
  public final void onLoaderReset(Loader<bwg> paramLoader)
  {
    cvm.b(cht.I, "IN AAC.ConversationCursor.onLoaderReset, data=%s loader=%s this=%s", new Object[] { a.u, paramLoader, this });
    if (a.u != null)
    {
      a.u.a(a);
      a.W.a(null);
      a.u = null;
      a.D.b = true;
      a.v.notifyChanged();
    }
  }
}

/* Location:
 * Qualified Name:     ciw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */