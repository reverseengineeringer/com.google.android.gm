import android.app.LoaderManager;
import android.net.Uri;
import android.os.Bundle;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class cgn
{
  private static final String f = cvm.a;
  final Map<Uri, Folder> a = new HashMap();
  final cpw b;
  final cgo c;
  private final List<Uri> d = new ArrayList();
  private final cgp e = new cgp(this);
  
  public cgn(cpw paramcpw, cgo paramcgo)
  {
    b = paramcpw;
    c = paramcgo;
  }
  
  private final int a(Uri paramUri)
  {
    int j = d.size();
    int i = 0;
    if (i < j) {
      if ((Uri)d.get(i) != null) {}
    }
    for (;;)
    {
      if (i < 0)
      {
        i = d.size();
        d.add(i, paramUri);
        return i;
        i += 1;
        break;
      }
      d.set(i, paramUri);
      return i;
      i = -1;
    }
  }
  
  public final Folder a(Account paramAccount)
  {
    paramAccount = z.i;
    if (a.containsKey(paramAccount))
    {
      paramAccount = (Folder)a.get(paramAccount);
      if (paramAccount != null) {
        return paramAccount;
      }
    }
    return null;
  }
  
  public final void a(Account[] paramArrayOfAccount)
  {
    if (paramArrayOfAccount == null) {}
    for (;;)
    {
      return;
      Object localObject1 = new ArrayList(paramArrayOfAccount.length);
      int j = paramArrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        ((List)localObject1).add(z.i);
        i += 1;
      }
      paramArrayOfAccount = Collections.unmodifiableList(new ArrayList(d)).iterator();
      Object localObject2;
      while (paramArrayOfAccount.hasNext())
      {
        localObject2 = (Uri)paramArrayOfAccount.next();
        if ((!((List)localObject1).contains(localObject2)) && (localObject2 != null))
        {
          i = d.indexOf(localObject2);
          if (i >= 0)
          {
            b.getLoaderManager().destroyLoader(i + 35);
            a.remove(localObject2);
            d.set(i, null);
          }
        }
      }
      paramArrayOfAccount = ((List)localObject1).iterator();
      while (paramArrayOfAccount.hasNext())
      {
        localObject1 = (Uri)paramArrayOfAccount.next();
        if (!d.contains(localObject1))
        {
          i = a((Uri)localObject1);
          cvm.b(f, "Watching %s, at position %d.", new Object[] { localObject1, Integer.valueOf(i) });
          a.put(localObject1, null);
          localObject2 = b.getLoaderManager();
          Bundle localBundle = new Bundle();
          localBundle.putString("FOLDER-URI", ((Uri)localObject1).toString());
          ((LoaderManager)localObject2).initLoader(i + 35, localBundle, e);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     cgn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */