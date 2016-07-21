import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.google.android.gms.auth.AccountChangeEvent;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class deh
  extends deg
  implements OnAccountsUpdateListener
{
  Context b;
  private dmv c;
  private final Map<String, List<String>> d = hhk.e();
  private final Map<String, Lock> e = hhk.e();
  private Set<String> f = new HashSet();
  
  deh(Context paramContext)
  {
    b = paramContext.getApplicationContext();
    c = dmv.a();
    paramContext = new HandlerThread("AccountHistory Thread");
    paramContext.start();
    paramContext = new Handler(paramContext.getLooper());
    paramContext.post(new dei(this));
    AccountManager.get(b).addOnAccountsUpdatedListener(this, paramContext, true);
  }
  
  private final AccountChangeEvent a(String paramString, int paramInt)
  {
    paramString = g(paramString);
    if (paramString == null) {
      return null;
    }
    paramString = paramString.listIterator(paramString.size());
    while (paramString.hasPrevious())
    {
      AccountChangeEvent localAccountChangeEvent = (AccountChangeEvent)paramString.previous();
      if (d == paramInt) {
        return localAccountChangeEvent;
      }
    }
    return null;
  }
  
  private final void a(String paramString, List<String> paramList)
  {
    cvm.a(deg.a, "AccountHistory build for %s", new Object[] { cvm.a(deg.a, paramString) });
    paramList.clear();
    HashSet localHashSet = new HashSet();
    if (TextUtils.isEmpty(paramString)) {
      cvm.d(deg.a, "AccountHistory cannot build history for %s", new Object[] { cvm.a(deg.a, paramString) });
    }
    for (;;)
    {
      return;
      Object localObject = f(paramString);
      String str = paramString;
      for (;;)
      {
        AccountChangeEvent localAccountChangeEvent;
        if (localObject == null)
        {
          localAccountChangeEvent = e(str);
          if (localAccountChangeEvent != null) {
            break label160;
          }
          cvm.b(deg.a, "AccountHistory cannot find what %s was changed from", new Object[] { str });
        }
        for (;;)
        {
          if (localObject != null) {
            break label210;
          }
          cvm.c(deg.a, "AccountHistory cannot find the addedEvent of %s (went back to %s)", new Object[] { cvm.a(deg.a, paramString), cvm.a(deg.a, str) });
          paramList.add(paramString);
          return;
          label160:
          if (!localHashSet.contains(localAccountChangeEvent)) {
            break;
          }
          cvm.b(deg.a, "AccountHistory interrupted when revisiting %s", new Object[] { localAccountChangeEvent });
        }
        str = f;
        localObject = f(str);
      }
      label210:
      cvm.b(deg.a, "AccountHistory add addedEvent %s", new Object[] { c });
      paramList.add(0, c);
      for (paramString = d(c); (paramString != null) && (!localHashSet.contains(paramString)); paramString = d(f))
      {
        cvm.b(deg.a, "AccountHistory add %s", new Object[] { paramString });
        localHashSet.add(paramString);
        paramList.add(0, f);
      }
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        cvm.b(deg.a, "AccountHistory maps email %s to records %s", new Object[] { localObject, paramList });
        d.put(localObject, paramList);
      }
    }
  }
  
  private final Lock c(String paramString)
  {
    synchronized (e)
    {
      Lock localLock = (Lock)e.get(paramString);
      Object localObject = localLock;
      if (localLock == null)
      {
        localObject = new ReentrantLock();
        e.put(paramString, localObject);
      }
      return (Lock)localObject;
    }
  }
  
  private final AccountChangeEvent d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = g(paramString).iterator();
    while (paramString.hasNext())
    {
      AccountChangeEvent localAccountChangeEvent = (AccountChangeEvent)paramString.next();
      if (d == 4) {
        return localAccountChangeEvent;
      }
    }
    return null;
  }
  
  private final AccountChangeEvent e(String paramString)
  {
    return a(paramString, 3);
  }
  
  private final AccountChangeEvent f(String paramString)
  {
    return a(paramString, 1);
  }
  
  private final List<AccountChangeEvent> g(String paramString)
  {
    return ecy.b(b, paramString);
  }
  
  private final List<String> h(String paramString)
  {
    Object localObject1 = (List)d.get(paramString);
    if (localObject1 != null) {
      return (List<String>)localObject1;
    }
    if (cwv.a()) {
      return null;
    }
    synchronized (d)
    {
      localObject3 = (List)d.get(paramString);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        cvm.b(deg.a, "AccountHistory records is null for %s", new Object[] { cvm.a(deg.a, paramString) });
        localObject3 = new LinkedList();
      }
      try
      {
        a(paramString, (List)localObject3);
        localObject1 = localObject3;
      }
      catch (ecx localecx)
      {
        for (;;)
        {
          cvm.d(deg.a, localecx, "Could not trace the account change history", new Object[0]);
          Object localObject2 = localObject3;
          if (!((List)localObject3).contains(paramString))
          {
            ((List)localObject3).add(paramString);
            localObject2 = localObject3;
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      return (List<String>)localObject1;
    }
  }
  
  public final String a(String paramString)
  {
    if (!f.contains(paramString)) {}
    Object localObject1;
    do
    {
      return paramString;
      localObject1 = dmv.a().a(b, paramString);
      if (localObject1 != null) {
        return (String)localObject1;
      }
      if (!dfh.a(b, paramString))
      {
        c.a(b, paramString, paramString);
        return paramString;
      }
    } while (cwv.a());
    Lock localLock = c(paramString);
    localLock.lock();
    for (;;)
    {
      try
      {
        localObject1 = c.a(b, paramString);
        if (localObject1 != null) {
          return (String)localObject1;
        }
        Object localObject2 = h(paramString);
        if (localObject2 == null) {
          return paramString;
        }
        ListIterator localListIterator = ((List)localObject2).listIterator();
        localObject1 = null;
        if ((localListIterator.hasNext()) && (localObject1 == null))
        {
          localObject1 = c.a(b, (String)localListIterator.next());
          continue;
        }
        if (localObject1 != null)
        {
          cvm.b(deg.a, "AccountHistory found legacy data, use old email %s as alias", new Object[] { cvm.a(deg.a, (String)localObject1) });
          paramString = (String)localObject1;
          localObject1 = ((List)localObject2).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject1).next();
          cvm.b(deg.a, "AccountHistory Cache alias %s for %s", new Object[] { paramString, cvm.a(deg.a, (String)localObject2) });
          c.a(b, (String)localObject2, paramString);
          continue;
        }
      }
      finally
      {
        localLock.unlock();
      }
      tmp300_297[0] = paramString;
      cvm.b(deg.a, "AccountHistory didn't find legacy data, use %s as alias", tmp300_297);
    }
    localLock.unlock();
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.a(bool);
      cvm.b(deg.a, "AccountHistory getAccountAlias returns %s", new Object[] { paramString });
      return paramString;
    }
  }
  
  public final String b(String paramString)
  {
    if (!f.contains(paramString)) {
      return paramString;
    }
    List localList = h(paramString);
    if (localList != null) {
      return (String)localList.get(0);
    }
    cvm.f(deg.a, "AccountHistory getLatestEmail returns no records", new Object[0]);
    return paramString;
  }
  
  public final void onAccountsUpdated(Account[] paramArrayOfAccount)
  {
    f.addAll(new ddy(b).b(new String[] { "mail", "gmailrenameeligible" }));
    int j = paramArrayOfAccount.length;
    int i = 0;
    if (i < j)
    {
      Account localAccount = paramArrayOfAccount[i];
      cvm.b(deg.a, "AccountHistory onAccountsUpdated: %s", new Object[] { name });
      if (f.contains(name)) {
        a(name);
      }
      for (;;)
      {
        i += 1;
        break;
        c.a(b, name, name);
      }
    }
  }
}

/* Location:
 * Qualified Name:     deh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */