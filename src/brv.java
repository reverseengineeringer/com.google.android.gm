import android.content.ContentResolver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import com.android.emailcommon.provider.Account;
import com.android.exchange.service.EasService;

public final class brv
  extends AsyncTask<Void, Void, Void>
{
  private boolean b = false;
  
  public brv(EasService paramEasService) {}
  
  private final Void a()
  {
    cvm.c("Exchange", "RestartPingTask", new Object[0]);
    Cursor localCursor = a.getContentResolver().query(Account.a, Account.y, EasService.a, null, null);
    if (localCursor != null) {
      try
      {
        while (localCursor.moveToNext())
        {
          Account localAccount = new Account();
          localAccount.a(localCursor);
          cvm.c("Exchange", "RestartPingsTask starting ping for %d", new Object[] { Long.valueOf(D) });
          if ((!bdv.c(e)) && (new bra(a, D).b())) {
            a.c.a(D, new Bundle());
          }
          if (brw.a(a, localAccount))
          {
            b = true;
            a.b.a(localAccount, 0L);
          }
        }
      }
      finally
      {
        localCursor.close();
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     brv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */