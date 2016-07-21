import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import com.android.email.provider.EmailProvider;
import com.android.emailcommon.provider.Mailbox;

public final class aze
  implements azx
{
  public aze(EmailProvider paramEmailProvider) {}
  
  public final void a(long paramLong, int paramInt)
  {
    paramInt = chh.a(1, paramInt);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("uiSyncStatus", Integer.valueOf(0));
    localContentValues.put("uiLastSyncResult", Integer.valueOf(paramInt));
    new ctw().a(a.getContext().getContentResolver(), ContentUris.withAppendedId(Mailbox.a, paramLong), localContentValues, null, null);
  }
}

/* Location:
 * Qualified Name:     aze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */