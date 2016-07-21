import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import com.android.mail.providers.Account;

public final class djr
  implements Runnable
{
  private final Context a;
  
  djr(Context paramContext)
  {
    a = paramContext;
  }
  
  public final void run()
  {
    Account[] arrayOfAccount = ctl.b(a);
    int j = arrayOfAccount.length;
    int i = 0;
    while (i < j)
    {
      Account localAccount = arrayOfAccount[i];
      Cursor localCursor;
      if (dyp.a(localAccount))
      {
        localCursor = a.getContentResolver().query(cgy.a(localAccount, "/operation"), null, null, null, null);
        if (localCursor != null) {
          try
          {
            int k = localCursor.getColumnIndex("save");
            int m = localCursor.getColumnIndex("message");
            int n = localCursor.getColumnIndex("attachment");
            while (localCursor.moveToNext())
            {
              long l = localCursor.getLong(k);
              String str1 = localCursor.getString(m);
              String str2 = localCursor.getString(n);
              djx.a(a, c, str1, str2, l);
            }
          }
          finally
          {
            localCursor.close();
          }
        }
      }
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     djr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */