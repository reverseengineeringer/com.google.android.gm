import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.ui.MailActivity;

final class ciy
  implements LoaderManager.LoaderCallbacks<ccy<Folder>>
{
  ciy(cht paramcht) {}
  
  public final Loader<ccy<Folder>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    String[] arrayOfString = chh.i;
    Uri localUri;
    switch (paramInt)
    {
    default: 
      cvm.f(cht.I, "FolderLoads.onCreateLoader(%d) for invalid id", new Object[] { Integer.valueOf(paramInt) });
      return null;
    case 30: 
      cvm.b(cht.I, "LOADER_FOLDER_CURSOR created", new Object[0]);
      buq.b.a("open_threadlist");
      paramBundle = new ccz(a.h, a.d.c.b, arrayOfString, Folder.y);
      paramBundle.setUpdateThrottle(a.C);
      return paramBundle;
    case 31: 
      cvm.b(cht.I, "LOADER_RECENT_FOLDERS created", new Object[0]);
      if ((a.c != null) && (a.c.x != null) && (!a.c.x.equals(Uri.EMPTY))) {
        return new ccz(a.h, a.c.x, arrayOfString, Folder.y);
      }
      break;
    case 32: 
      cvm.b(cht.I, "LOADER_ACCOUNT_INBOX created", new Object[0]);
      localUri = Settings.a(a.c.z);
      paramBundle = localUri;
      if (localUri.equals(Uri.EMPTY)) {
        paramBundle = a.c.i;
      }
      cvm.b(cht.I, "Loading the default inbox: %s", new Object[] { paramBundle });
      if (paramBundle != null)
      {
        buq.b.a("open_threadlist");
        return new ccz(a.h, paramBundle, arrayOfString, Folder.y);
      }
      break;
    case 33: 
      cvm.b(cht.I, "LOADER_SEARCH created", new Object[0]);
      return Folder.a(a.c, a.g.getIntent().getBooleanExtra("multipleAccounts", false), paramBundle.getString("query"), Long.toString(SystemClock.uptimeMillis()), a.g);
    case 34: 
      cvm.b(cht.I, "LOADER_FIRST_FOLDER created", new Object[0]);
      localUri = (Uri)paramBundle.getParcelable("folderUri");
      a.Q = ((Conversation)paramBundle.getParcelable("conversationUri"));
      if ((a.Q != null) && (a.Q.C < 0)) {
        a.Q.C = 0;
      }
      return new ccz(a.h, localUri, arrayOfString, Folder.y);
    }
    return null;
  }
  
  public final void onLoaderReset(Loader<ccy<Folder>> paramLoader) {}
}

/* Location:
 * Qualified Name:     ciy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */