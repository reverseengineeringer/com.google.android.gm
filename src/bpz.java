import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.ExchangeOofSettings;
import org.apache.http.HttpEntity;

public final class bpz
  extends bqb
{
  public bpz(Context paramContext, Account paramAccount)
  {
    super(paramContext, paramAccount);
  }
  
  protected final int a(bns parambns)
  {
    parambns = new bow(parambns.d());
    boolean bool = parambns.d();
    if (bool)
    {
      parambns = a.a();
      parambns.put("oof_get_update", Boolean.valueOf(true));
      f.getContentResolver().update(a, parambns, null, null);
    }
    if (bool) {
      return 0;
    }
    return -99;
  }
  
  protected final String b()
  {
    return "Settings";
  }
  
  protected final HttpEntity c()
  {
    bpi localbpi = new bpi();
    localbpi.a(1157).a(1161).a(1159);
    localbpi.b(1171, "Text");
    localbpi.b().b().b().a();
    return a(localbpi);
  }
}

/* Location:
 * Qualified Name:     bpz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */