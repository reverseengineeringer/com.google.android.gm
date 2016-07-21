import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Mailbox;
import com.android.exchange.adapter.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public final class bpg
  extends Parser
{
  private static final String b = bbw.a;
  public int a;
  private final Context c;
  private final ContentResolver d;
  private final Mailbox e;
  private final Account f;
  private final String g;
  
  public bpg(Context paramContext, ContentResolver paramContentResolver, InputStream paramInputStream, Mailbox paramMailbox, Account paramAccount, String paramString)
  {
    super(paramInputStream);
    c = paramContext;
    d = paramContentResolver;
    e = paramMailbox;
    f = paramAccount;
    g = paramString;
  }
  
  private final boolean a()
  {
    while (b(973) != 3) {
      if (l == 967) {
        b();
      } else {
        i();
      }
    }
    return false;
  }
  
  private final boolean a(bom parambom, ArrayList<ContentProviderOperation> paramArrayList)
  {
    beb localbeb = new beb();
    while (b(974) != 3) {
      if (l == 16)
      {
        g();
      }
      else if (l == 984)
      {
        ag = g();
      }
      else if (l == 975)
      {
        V = f.D;
        int i = l;
        k = (i >>> 6);
        parambom.c(i);
        j();
        parambom.a(localbeb, l);
        if (ay != null) {
          ay = bhl.a(ay, g);
        }
        U = e.D;
        r = 1;
        localbeb.a(paramArrayList);
      }
      else
      {
        i();
      }
    }
    return false;
  }
  
  private final boolean b()
  {
    bom localbom = new bom(this, c, d, e, f);
    ArrayList localArrayList = new ArrayList();
    String str = null;
    while (b(967) != 3) {
      if (l == 972) {
        str = g();
      } else if (l == 976) {
        a = h();
      } else if (l == 974) {
        a(localbom, localArrayList);
      } else {
        i();
      }
    }
    try
    {
      d.applyBatch(bdv.F, localArrayList);
      cvm.b(b, "Saved %s search results, status: %s, expected size: %d", new Object[] { Integer.valueOf(localArrayList.size()), str, Integer.valueOf(a) });
      if (!"1".equals(str)) {
        cvm.d(b, "Non-successful status returned from Exchange search: %s", new Object[] { str });
      }
      return false;
    }
    catch (RemoteException localRemoteException)
    {
      cvm.b(b, "RemoteException while saving search results.", new Object[0]);
      return false;
    }
    catch (OperationApplicationException localOperationApplicationException) {}
    return false;
  }
  
  public final boolean d()
  {
    String str1;
    label29:
    String str2;
    if (b(0) != 965)
    {
      throw new IOException();
      str1 = new String("Search status: ");
      cvm.b(str2, str1, new Object[0]);
    }
    for (;;)
    {
      if (b(0) == 1) {
        break label120;
      }
      if (l == 972)
      {
        str1 = g();
        if (!bnq.b) {
          continue;
        }
        str2 = b;
        str1 = String.valueOf(str1);
        if (str1.length() == 0) {
          break;
        }
        str1 = "Search status: ".concat(str1);
        break label29;
      }
      if (l == 973) {
        a();
      } else {
        i();
      }
    }
    label120:
    return false;
  }
}

/* Location:
 * Qualified Name:     bpg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */