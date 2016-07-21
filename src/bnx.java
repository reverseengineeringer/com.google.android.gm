import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.emailcommon.provider.Mailbox;
import com.android.exchange.adapter.Parser;
import java.io.IOException;
import java.io.InputStream;

public abstract class bnx
  extends Parser
{
  public Mailbox a;
  public com.android.emailcommon.provider.Account b;
  public Context c;
  public ContentResolver d;
  public int e;
  private boolean f;
  
  public bnx(Context paramContext, ContentResolver paramContentResolver, InputStream paramInputStream, Mailbox paramMailbox, com.android.emailcommon.provider.Account paramAccount)
  {
    super(paramInputStream);
    a(paramContext, paramContentResolver, paramMailbox, paramAccount);
  }
  
  public bnx(Parser paramParser, Context paramContext, ContentResolver paramContentResolver, Mailbox paramMailbox, com.android.emailcommon.provider.Account paramAccount)
  {
    super(paramParser);
    a(paramContext, paramContentResolver, paramMailbox, paramAccount);
  }
  
  private final void a(Context paramContext, ContentResolver paramContentResolver, Mailbox paramMailbox, com.android.emailcommon.provider.Account paramAccount)
  {
    c = paramContext;
    d = paramContentResolver;
    a = paramMailbox;
    b = paramAccount;
  }
  
  public abstract void a();
  
  public final void a(int paramInt)
  {
    while (b(paramInt) != 3) {
      i();
    }
  }
  
  public abstract void b();
  
  public abstract void c();
  
  public boolean d()
  {
    f = false;
    if (b(0) != 5) {
      throw new boy(this);
    }
    Object localObject = new ContentValues();
    int j = 0;
    int i = 0;
    boolean bool1 = false;
    while (b(0) != 1) {
      if ((l != 15) && (l != 28)) {
        if (l == 14)
        {
          e = h();
          if (e != 1)
          {
            cvm.c("Exchange", "abstractSyncParser got status %d", new Object[] { Integer.valueOf(e) });
            if (bnp.b(e))
            {
              cvm.d("Exchange", "invalid sync key, wiping all data", new Object[0]);
              a.j = "0";
              e();
              i = 1;
              bool1 = true;
            }
            else
            {
              if (bnp.e(e)) {
                throw new IOException();
              }
              if ((e == 8) || (e == 12))
              {
                localObject = new Bundle(1);
                ((Bundle)localObject).putBoolean("__account_only__", true);
                ContentResolver.requestSync(new android.accounts.Account(b.d, bnq.c), bdv.F, (Bundle)localObject);
                throw new IOException();
              }
              if (e == 7)
              {
                bool1 = true;
              }
              else if (e == 9)
              {
                cvm.d("Exchange", "Sync cannot be completed", new Object[0]);
              }
              else
              {
                i = e;
                cvm.e("Exchange", 35 + "Unexpected sync status: " + i, new Object[0]);
                throw new bno(e);
              }
            }
          }
        }
        else if (l == 22)
        {
          a();
        }
        else if (l == 6)
        {
          b();
        }
        else if (l == 20)
        {
          bool1 = true;
        }
        else if (l == 11)
        {
          boolean bool2 = bool1;
          if (a.j.equals("0")) {
            bool2 = true;
          }
          String str = g();
          cvm.b("Exchange", "Parsed key for %s %s", new Object[] { a.c, str });
          bool1 = bool2;
          if (!str.equals(a.j))
          {
            a.j = str;
            ((ContentValues)localObject).put("syncKey", str);
            j = 1;
            i = 1;
            bool1 = bool2;
          }
        }
        else
        {
          i();
        }
      }
    }
    if ((bool1) && (i == 0))
    {
      cvm.e("Exchange", "Looping detected", new Object[0]);
      f = true;
    }
    try
    {
      c();
      if (j != 0) {
        a.a(c, (ContentValues)localObject);
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        cvm.e("Exchange", localRemoteException, "Failed to commit changes", new Object[0]);
      }
    }
    catch (OperationApplicationException localOperationApplicationException)
    {
      for (;;) {}
    }
    if (bool1) {}
    return bool1;
  }
  
  protected abstract void e();
}

/* Location:
 * Qualified Name:     bnx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */