import android.content.ContentResolver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Handler;
import com.android.mail.ui.MailboxSelectionActivity;

public final class cou
  extends AsyncTask<Void, Void, Void>
{
  public cou(MailboxSelectionActivity paramMailboxSelectionActivity, ContentResolver paramContentResolver) {}
  
  private final Void a()
  {
    Cursor localCursor;
    try
    {
      localCursor = a.query(cgr.b(), chh.c, null, null, null);
      MailboxSelectionActivity localMailboxSelectionActivity;
      if (localCursor == null) {
        break label64;
      }
    }
    finally
    {
      try
      {
        localMailboxSelectionActivity = b;
        m.post(new cov(localMailboxSelectionActivity, localCursor));
        if (localCursor != null) {
          localCursor.close();
        }
        return null;
      }
      finally {}
      localObject1 = finally;
      localCursor = null;
    }
    localCursor.close();
    label64:
    throw ((Throwable)localObject1);
  }
}

/* Location:
 * Qualified Name:     cou
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */