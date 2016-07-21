import android.content.Context;
import android.os.Bundle;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.provider.Mailbox;
import java.util.HashMap;

public final class axg
  extends awr
{
  static boolean g = false;
  static boolean h = false;
  public static final bda[] i = { bda.a };
  public final bdg[] j = new bdg[1];
  private final HashMap<String, bdb> k = new HashMap();
  
  public axg(Context paramContext, Account paramAccount)
  {
    b = paramContext;
    c = paramAccount;
    paramAccount = paramAccount.d(paramContext);
    d = new ayd(paramContext, "POP3", paramAccount);
    paramContext = paramAccount.j();
    e = paramContext[0];
    f = paramContext[1];
  }
  
  public final bdb a(String paramString)
  {
    bdb localbdb = (bdb)k.get(paramString);
    Object localObject = localbdb;
    if (localbdb == null)
    {
      localObject = new axi(this, paramString);
      k.put(((bdb)localObject).c(), localObject);
    }
    return (bdb)localObject;
  }
  
  public final bdb[] b()
  {
    Mailbox localMailbox2 = Mailbox.b(b, c.D, 0);
    Mailbox localMailbox1 = localMailbox2;
    if (localMailbox2 == null) {
      localMailbox1 = Mailbox.a(c.D, 0);
    }
    if (localMailbox1.h()) {
      localMailbox1.a(b, localMailbox1.e());
    }
    for (;;)
    {
      return new bdb[] { a(d) };
      localMailbox1.h(b);
    }
  }
  
  public final Bundle c()
  {
    axi localaxi = new axi(this, "INBOX");
    if (d.e()) {
      localaxi.b();
    }
    try
    {
      localaxi.a(bdf.a);
      Bundle localBundle = localaxi.i();
      return localBundle;
    }
    finally
    {
      localaxi.b();
    }
  }
}

/* Location:
 * Qualified Name:     axg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */