import android.content.ContentResolver;
import android.content.ContentValues;
import com.android.email.vacation.ExchangeVacationResponderActivity;
import com.android.emailcommon.provider.ExchangeOofSettings;
import com.android.mail.providers.Account;

public final class bbp
  implements Runnable
{
  public bbp(ExchangeVacationResponderActivity paramExchangeVacationResponderActivity, ExchangeOofSettings paramExchangeOofSettings) {}
  
  public final void run()
  {
    ContentValues localContentValues = a.a();
    localContentValues.put("oof_local_update", Boolean.valueOf(true));
    b.getContentResolver().update(b.r.M, localContentValues, null, null);
  }
}

/* Location:
 * Qualified Name:     bbp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */