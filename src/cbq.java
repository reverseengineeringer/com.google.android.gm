import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import com.android.mail.compose.EmptyService;
import com.android.mail.providers.Message;

final class cbq
  extends AsyncTask<Void, Void, Message>
{
  private final Intent f = new Intent(a, EmptyService.class);
  
  cbq(cbk paramcbk1, cbk paramcbk2, Uri paramUri, int paramInt, String paramString) {}
  
  private final Message a()
  {
    Message localMessage = null;
    Cursor localCursor = a.getContentResolver().query(b, chh.n, null, null, null, null);
    if (localCursor != null) {}
    try
    {
      localCursor.moveToFirst();
      localMessage = new Message(localCursor);
      return localMessage;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  protected final void onPreExecute()
  {
    a.startService(f);
  }
}

/* Location:
 * Qualified Name:     cbq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */