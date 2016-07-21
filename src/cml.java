import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.android.mail.ui.ConversationViewFragment;

public final class cml
  extends AsyncTask<Void, Void, Void>
{
  private final Context b;
  private final String c;
  private final Uri d;
  private final ContentResolver e;
  private Long f;
  
  public cml(ConversationViewFragment paramConversationViewFragment, Context paramContext, String paramString, Uri paramUri)
  {
    b = paramContext;
    c = paramString;
    d = paramUri;
    e = paramContext.getContentResolver();
    f = Long.valueOf(chq.b());
  }
  
  private final Void a()
  {
    Cursor localCursor = e.query(d, chh.f, null, null, null);
    if (localCursor == null) {
      return null;
    }
    try
    {
      if (localCursor.moveToFirst())
      {
        String str = localCursor.getString(localCursor.getColumnIndex("cookie"));
        if (str != null)
        {
          CookieSyncManager localCookieSyncManager = CookieSyncManager.createInstance(b);
          CookieManager localCookieManager = CookieManager.getInstance();
          localCookieManager.removeAllCookie();
          localCookieManager.setCookie(c, str);
          localCookieSyncManager.sync();
          a.W = true;
        }
      }
      localCursor.close();
      long l = cwh.a(f.longValue());
      buo.a().a("gmail_auth", l, "load_cookie", null);
      return null;
    }
    finally
    {
      localCursor.close();
    }
  }
}

/* Location:
 * Qualified Name:     cml
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */