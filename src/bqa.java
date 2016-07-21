import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.ExchangeOofSettings;
import org.apache.http.HttpEntity;

public final class bqa
  extends bqb
{
  private final ExchangeOofSettings b;
  
  public bqa(Context paramContext, Account paramAccount, ExchangeOofSettings paramExchangeOofSettings)
  {
    super(paramContext, paramAccount);
    b = paramExchangeOofSettings;
  }
  
  protected final int a(bns parambns)
  {
    boolean bool = new bpj(parambns.d()).d();
    parambns = new ContentValues(1);
    parambns.put("oof_set_update", Boolean.valueOf(bool));
    f.getContentResolver().update(a, parambns, null, null);
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
    localbpi.a(1157).a(1161).a(1160);
    localbpi.b(1162, Integer.toString(b.a));
    long l = b.b;
    localbpi.b(1163, bhn.d.a(l));
    l = b.c;
    localbpi.b(1164, bhn.d.a(l));
    localbpi.a(1165);
    localbpi.b(1166);
    if (b.e)
    {
      str = "1";
      localbpi.b(1169, str);
      if (b.e)
      {
        localbpi.b(1170, b.g);
        localbpi.b(1171, ExchangeOofSettings.a(b.f));
      }
      localbpi.b();
      localbpi.a(1165);
      localbpi.b(1167);
      if (!b.h) {
        break label399;
      }
      str = "1";
      label220:
      localbpi.b(1169, str);
      if (b.h)
      {
        localbpi.b(1170, b.j);
        localbpi.b(1171, ExchangeOofSettings.a(b.i));
      }
      localbpi.b();
      localbpi.a(1165);
      localbpi.b(1168);
      if (!b.k) {
        break label405;
      }
    }
    label399:
    label405:
    for (String str = "1";; str = "0")
    {
      localbpi.b(1169, str);
      if (b.k)
      {
        localbpi.b(1170, b.m);
        localbpi.b(1171, ExchangeOofSettings.a(b.l));
      }
      localbpi.b();
      localbpi.b().b().b().a();
      return a(localbpi);
      str = "0";
      break;
      str = "0";
      break label220;
    }
  }
}

/* Location:
 * Qualified Name:     bqa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */