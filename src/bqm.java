import android.content.ContentValues;
import android.content.Context;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Mailbox;
import com.android.emailcommon.service.SearchParams;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import org.apache.http.HttpEntity;

public final class bqm
  extends bqc
{
  final SearchParams a;
  final long b;
  public int c;
  Mailbox d;
  
  public bqm(Context paramContext, Account paramAccount, SearchParams paramSearchParams, long paramLong)
  {
    super(paramContext, paramAccount);
    a = paramSearchParams;
    b = paramLong;
  }
  
  protected final int a(bns parambns)
  {
    if (parambns.e()) {
      return 100;
    }
    parambns = parambns.d();
    try
    {
      Object localObject1 = Mailbox.a(f, b);
      localObject1 = new bpg(f, f.getContentResolver(), parambns, (Mailbox)localObject1, g, a.c);
      ((bpg)localObject1).d();
      c = a;
      return 0;
    }
    finally
    {
      parambns.close();
    }
  }
  
  protected final String b()
  {
    return "Search";
  }
  
  protected final HttpEntity c()
  {
    int i = a.g;
    int j = a.f;
    String str = a.c;
    if ((j < 0) || (j > 100) || (i < 0)) {
      return null;
    }
    if ((str == null) || (str.length() < 3))
    {
      cvm.d("Exchange", "filter too short", new Object[0]);
      return null;
    }
    d = Mailbox.a(f, b);
    if (d == null)
    {
      cvm.c("Exchange", "search mailbox ceased to exist", new Object[0]);
      return null;
    }
    Object localObject;
    Mailbox localMailbox;
    try
    {
      localObject = new ContentValues(1);
      ((ContentValues)localObject).put("uiSyncStatus", Integer.valueOf(2));
      d.a(f, (ContentValues)localObject);
      localObject = new bpi();
      ((bpi)localObject).a(965).a(967);
      ((bpi)localObject).b(968, "Mailbox");
      ((bpi)localObject).a(969).a(979);
      ((bpi)localObject).b(16, "Email");
      localMailbox = Mailbox.b(f, g.D, 0);
      if (localMailbox == null)
      {
        cvm.c("Exchange", "Inbox ceased to exist", new Object[0]);
        return null;
      }
    }
    catch (IOException localIOException)
    {
      cvm.b("Exchange", localIOException, "Search exception", new Object[0]);
      cvm.c("Exchange", "end returning null", new Object[0]);
      return null;
    }
    if (a.a != D) {
      ((bpi)localObject).b(18, d);
    }
    ((bpi)localObject).b(981, localIOException);
    if (a.d != null)
    {
      ((bpi)localObject).a(987);
      ((bpi)localObject).b(143);
      ((bpi)localObject).b(978, bnq.g.format(a.d));
      ((bpi)localObject).b();
    }
    if (a.e != null)
    {
      ((bpi)localObject).a(986);
      ((bpi)localObject).b(143);
      ((bpi)localObject).b(978, bnq.g.format(a.e));
      ((bpi)localObject).b();
    }
    ((bpi)localObject).b().b();
    ((bpi)localObject).a(970);
    if (i == 0) {
      ((bpi)localObject).b(985);
    }
    if (a.b) {
      ((bpi)localObject).b(983);
    }
    ((bpi)localObject).b(971, 23 + i + "-" + (j + i - 1));
    ((bpi)localObject).a(1093);
    ((bpi)localObject).b(1094, "2");
    ((bpi)localObject).b(1095, "20000");
    ((bpi)localObject).b();
    ((bpi)localObject).b().b().b().a();
    HttpEntity localHttpEntity = a((bpi)localObject);
    return localHttpEntity;
  }
  
  protected final void n()
  {
    if (d != null)
    {
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("uiSyncStatus", Integer.valueOf(0));
      localContentValues.put("syncTime", Long.valueOf(System.currentTimeMillis()));
      d.a(f, localContentValues);
    }
  }
}

/* Location:
 * Qualified Name:     bqm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */