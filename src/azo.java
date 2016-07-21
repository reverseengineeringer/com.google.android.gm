import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.android.emailcommon.provider.Account;

final class azo
  extends ContentObserver
{
  private final Context b;
  
  public azo(azn paramazn, Context paramContext, Handler paramHandler)
  {
    super(paramHandler);
    b = paramContext;
  }
  
  public final void onChange(boolean paramBoolean)
  {
    if (((ab, a.a).j & 0x2000) != 0) && (a.b != null))
    {
      b.getContentResolver().unregisterContentObserver(a.b);
      a.b = null;
      if (a.c != null)
      {
        a.c.dismiss();
        a.c = null;
      }
      a.a();
    }
  }
}

/* Location:
 * Qualified Name:     azo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */