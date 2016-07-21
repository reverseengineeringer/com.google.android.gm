import android.content.Context;
import android.net.TrafficStats;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Mailbox;
import java.util.List;
import org.apache.http.HttpEntity;

public final class bqt
  extends bqc
{
  private boolean a;
  private final Mailbox b;
  private bqv c;
  private final btd d;
  private int e;
  private int k;
  
  public bqt(Context paramContext, Account paramAccount, Mailbox paramMailbox, btd parambtd)
  {
    super(paramContext, paramAccount);
    b = paramMailbox;
    d = parambtd;
    k = 0;
  }
  
  private final String j()
  {
    if (b == null) {
      return null;
    }
    if (b.j == null) {
      b.j = "0";
    }
    return b.j;
  }
  
  protected final int a(bns parambns)
  {
    k = a;
    try
    {
      boolean bool = c.a(f, g, b, parambns.d()).d();
      if (bool) {
        return 1;
      }
    }
    catch (boz parambns) {}
    return 0;
  }
  
  protected final String b()
  {
    return "Sync";
  }
  
  protected final HttpEntity c()
  {
    String str1 = bnq.a(b.h);
    String str2 = j();
    cvm.b("Exchange", "Syncing account %d mailbox %d (class %s) with syncKey %s", new Object[] { Long.valueOf(g.D), Long.valueOf(b.D), str1, str2 });
    a = bdv.c(str2);
    bpi localbpi = new bpi();
    localbpi.a(5);
    localbpi.a(28);
    localbpi.a(15);
    if (h.e < 12.1D) {
      localbpi.b(16, str1);
    }
    localbpi.b(11, str2);
    localbpi.b(18, b.d);
    c.a(f, localbpi, h.e, g, b, a, e);
    localbpi.b().b().b().a();
    return a(localbpi);
  }
  
  public final boolean k()
  {
    int i = b.h;
    Object localObject;
    switch (i)
    {
    default: 
      cvm.e("Exchange", "unexpected collectiontype %d", new Object[] { Integer.valueOf(i) });
      localObject = null;
    }
    for (;;)
    {
      c = ((bqv)localObject);
      if (c != null) {
        break;
      }
      return false;
      localObject = new bqy();
      continue;
      localObject = new bqu(f, g, b);
      continue;
      localObject = new bqw(g.d);
    }
    TrafficStats.setThreadStatsTag(bcf.a(g) | c.a());
    return true;
  }
  
  protected final long p()
  {
    if (a) {
      return 120000L;
    }
    return super.p();
  }
  
  public final int p_()
  {
    e = 1;
    String str1 = j();
    int i = 1;
    while (i == 1)
    {
      i = super.p_();
      if ((i == 1) || (i == 0)) {
        c.a(f, g);
      }
      localObject = j();
      if ((i == 1) && (str1.equals(localObject)))
      {
        cvm.e("Exchange", "Server has more data but we have the same key: %s numWindows: %d", new Object[] { str1, Integer.valueOf(e) });
        e += 1;
      }
      else
      {
        e = 1;
      }
    }
    Object localObject = d;
    long l = b.D;
    String str2 = b.d;
    String str3 = j();
    int j = k;
    h.add(new bte(l, str2, str1, str3));
    i += j;
    return i;
  }
}

/* Location:
 * Qualified Name:     bqt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */