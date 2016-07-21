import android.content.ContentResolver;
import android.content.Context;
import com.android.emailcommon.provider.Account;

final class aqm
  implements Runnable
{
  aqm(aql paramaql) {}
  
  public final void run()
  {
    ContentResolver localContentResolver = a.d.getContentResolver();
    a.a(1152921504606846976L);
    if (a.g == null)
    {
      cvm.c(aql.a, "Observing account changes for notifications", new Object[0]);
      a.g = new aqp(aql.b, a.d);
      localContentResolver.registerContentObserver(Account.b, true, a.g);
    }
  }
}

/* Location:
 * Qualified Name:     aqm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */