import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import com.android.emailcommon.provider.ExchangeOofSettings;
import com.android.emailcommon.provider.Mailbox;
import com.android.emailcommon.provider.RecipientAvailability;
import com.android.emailcommon.service.HostAuthCompat;
import com.android.emailcommon.service.SearchParams;
import com.android.exchange.provider.GalResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class brw
  extends bez
{
  static List<String> a = new ArrayList();
  static boolean b = false;
  Context c;
  bst d;
  String e;
  private bpl f;
  
  public brw(Context paramContext, bst parambst)
  {
    c = paramContext;
    d = parambst;
  }
  
  static Bundle a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    Bundle localBundle = new Bundle(5);
    localBundle.putInt("autodiscover_error_code", -2);
    localBundle.putInt("autodiscover_attempt", paramInt1);
    localBundle.putInt("autodiscover_auth_attempt", paramInt2);
    localBundle.putString("autodiscover_redirect_uri", paramString);
    localBundle.putInt("autodiscover_redirect_count", paramInt3);
    return localBundle;
  }
  
  static com.android.emailcommon.provider.Account a(Context paramContext, long paramLong)
  {
    paramContext = com.android.emailcommon.provider.Account.a(paramContext, paramLong);
    if (paramContext == null) {
      cvm.e("Exchange", "Could not load account %d", new Object[] { Long.valueOf(paramLong) });
    }
    return paramContext;
  }
  
  static com.android.emailcommon.provider.Account a(Context paramContext, String paramString)
  {
    paramContext = com.android.emailcommon.provider.Account.a(paramContext, paramString);
    if (paramContext == null) {
      cvm.e("Exchange", "Could not load account %s", new Object[] { paramString });
    }
    return paramContext;
  }
  
  public static GalResult a(Context paramContext, long paramLong, String paramString, int paramInt)
  {
    Object localObject2 = null;
    com.android.emailcommon.provider.Account localAccount = a(paramContext, paramLong);
    Object localObject1 = localObject2;
    if (localAccount != null)
    {
      paramContext = new bqn(paramContext, localAccount, paramString, paramInt);
      localObject1 = localObject2;
      if (paramContext.p_() == 0) {
        localObject1 = a;
      }
    }
    return (GalResult)localObject1;
  }
  
  public static Set<String> a(android.accounts.Account paramAccount, List<String> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (ContentResolver.getSyncAutomatically(paramAccount, str)) {
        localHashSet.add(str);
      }
    }
    return localHashSet;
  }
  
  static void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = String.valueOf(Integer.toString(paramInt2));
    if (paramBoolean)
    {
      str1 = "_redirect";
      label16:
      str1 = String.valueOf(str1);
      if (str1.length() == 0) {
        break label140;
      }
    }
    label140:
    for (String str1 = ((String)localObject).concat(str1);; str1 = new String((String)localObject)) {
      switch (paramInt1)
      {
      default: 
        localObject = buo.a();
        str2 = String.valueOf("unknown_response_");
        ((but)localObject).a("autodiscover", String.valueOf(str2).length() + 11 + str2 + paramInt1, str1, 0L);
        return;
        str1 = "";
        break label16;
      }
    }
    buo.a().a("autodiscover", "success", str1, 0L);
    return;
    buo.a().a("autodiscover", "auth_failed", str1, 0L);
    return;
    buo.a().a("autodiscover", "redirect", str1, 0L);
    return;
    localObject = buo.a();
    String str2 = String.valueOf("bad_response_");
    ((but)localObject).a("autodiscover", String.valueOf(str2).length() + 11 + str2 + paramInt1, str1, 0L);
  }
  
  static void a(Context paramContext, long paramLong1, String paramString, long paramLong2)
  {
    Object localObject3 = null;
    Mailbox localMailbox = Mailbox.a(paramContext, paramLong1, paramString);
    if (localMailbox.h()) {}
    for (Object localObject1 = localMailbox.d();; localObject1 = null)
    {
      g = paramLong1;
      i = 0;
      int i = paramString.lastIndexOf(0);
      Object localObject2;
      if (i > 0) {
        localObject2 = paramString.substring(i + 1);
      }
      for (;;)
      {
        c = ((String)localObject2);
        o = 24;
        n = true;
        d = paramString;
        h = 1;
        if (localObject1 == null)
        {
          r = 8;
          w = true;
          f = paramLong2;
          if (paramLong2 != -1L) {
            paramString = (String)localObject3;
          }
        }
        try
        {
          localObject1 = paramContext.getContentResolver().query(Mailbox.a, new String[] { "flags", "serverId" }, "accountKey=? AND _id=?", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, null);
          if (localObject1 != null)
          {
            paramString = (String)localObject1;
            if (((Cursor)localObject1).moveToNext())
            {
              paramString = (String)localObject1;
              e = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("serverId"));
              paramString = (String)localObject1;
              i = ((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndex("flags"));
              if ((i & 0x3) != 3)
              {
                paramString = (String)localObject1;
                localObject2 = new ContentValues(1);
                paramString = (String)localObject1;
                ((ContentValues)localObject2).put("flags", Integer.valueOf(i | 0x3));
                paramString = (String)localObject1;
                paramContext.getContentResolver().update(Mailbox.a, (ContentValues)localObject2, "accountKey=? AND _id=?", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) });
              }
            }
          }
          for (;;)
          {
            if (localObject1 != null) {
              ((Cursor)localObject1).close();
            }
            localMailbox.h(paramContext);
            return;
            paramString = (String)localObject1;
            cvm.d(bbw.a, "Parent folder does not exist", new Object[0]);
          }
          localObject2 = paramString;
        }
        finally
        {
          if (paramString != null) {
            paramString.close();
          }
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, com.android.emailcommon.provider.Account paramAccount)
  {
    if (!ContentResolver.getMasterSyncAutomatically())
    {
      cvm.b("Exchange", "Do not ping: master sync is off, ping is useless.", new Object[0]);
      return false;
    }
    if ((paramAccount == null) || (D == -1L))
    {
      cvm.b("Exchange", "Do not ping: Account not found or not valid", new Object[0]);
      return false;
    }
    if (g != -2)
    {
      cvm.b("Exchange", "Do not ping: Account %d not configured for push", new Object[] { Long.valueOf(D) });
      return false;
    }
    if ((j & 0x20) != 0)
    {
      cvm.b("Exchange", "Do not ping: Account %d is on security hold", new Object[] { Long.valueOf(D) });
      return false;
    }
    if (bdv.c(e))
    {
      cvm.b("Exchange", "Do not ping: Account %d has not done initial sync", new Object[] { Long.valueOf(D) });
      return false;
    }
    Set localSet = a(new android.accounts.Account(d, bnq.c), a);
    if (!localSet.isEmpty())
    {
      paramContext = Mailbox.a(paramContext.getContentResolver(), D);
      if (paramContext == null) {}
    }
    try
    {
      while (paramContext.moveToNext()) {
        if (localSet.contains(Mailbox.d(paramContext.getInt(5))))
        {
          cvm.b("Exchange", "should ping for account %d", new Object[] { Long.valueOf(D) });
          return true;
        }
      }
      paramContext.close();
      cvm.b("Exchange", "Do not ping: Account %d has no folders configured for push", new Object[] { Long.valueOf(D) });
      return false;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  static int b(int paramInt)
  {
    if (paramInt >= 0) {}
    for (int i = 1; i != 0; i = 0) {
      return 0;
    }
    switch (paramInt)
    {
    default: 
      cvm.e("Exchange", "Unexpected easStatus %d", new Object[] { Integer.valueOf(paramInt) });
      return 39;
    case -2: 
    case -1: 
      cvm.e("Exchange", "Abort or Restart easStatus", new Object[0]);
      return 0;
    case -3: 
      return 39;
    case -4: 
      return 35;
    case -7: 
    case -5: 
      return 22;
    case -6: 
      return 38;
    case -8: 
      return 33;
    case -9: 
      return 36;
    case -99: 
    case -11: 
    case -10: 
      return 39;
    }
    cvm.e("Exchange", "Other non-fatal error easStatus %d", new Object[] { Integer.valueOf(paramInt) });
    return 0;
  }
  
  public final int a()
  {
    cvm.b("Exchange", "EasServiceBinder.getApiVersion", new Object[0]);
    return ((Integer)new bsh(this).b()).intValue();
  }
  
  public final int a(long paramLong, Bundle paramBundle)
  {
    cvm.b("Exchange", "EasServiceBinder.sync: %d %s", new Object[] { Long.valueOf(paramLong), paramBundle });
    return ((Integer)new bsn(this, paramLong, paramBundle).b()).intValue();
  }
  
  public final int a(bqc parambqc, String paramString)
  {
    i = 0;
    if (!cuh.a()) {
      bsr.a(c);
    }
    cvm.b("Exchange", "%s: %d", new Object[] { paramString, Long.valueOf(g.D) });
    localbst = d;
    a.lock();
    for (;;)
    {
      try
      {
        cvm.c("Exchange", "PSS syncStart for account acct:%d, force:%s", new Object[] { Long.valueOf(g.D), Boolean.valueOf(parambqc.i()) });
        bsu localbsu = localbst.a(g.D, true);
        boolean bool = parambqc.i();
        c += 1;
        g = bool;
        if (a != null)
        {
          cvm.c("Exchange", "PSS Sync is pre-empting a ping acct:%d", new Object[] { Long.valueOf(e) });
          a.a.l();
        }
        int j;
        if (a == null)
        {
          j = c;
          if (j <= 1) {
            continue;
          }
        }
        try
        {
          if (a != null)
          {
            paramString = "yes";
            cvm.c("Exchange", "PSS Sync needs to wait: Ping: %s, Pending tasks: %d acct: %d", new Object[] { paramString, Integer.valueOf(c), Long.valueOf(e) });
            d.await();
          }
        }
        catch (InterruptedException paramString)
        {
          cvm.c("Exchange", "PSS InterruptedException acct:%d", new Object[] { Long.valueOf(e) });
          continue;
        }
      }
      finally
      {
        a.unlock();
      }
      try
      {
        j = parambqc.p_();
        i = j;
        cvm.b("Exchange", "Operation result %d", new Object[] { Integer.valueOf(j) });
        return j;
      }
      finally
      {
        d.a(i, g);
      }
      paramString = "no";
    }
  }
  
  public final Bundle a(long paramLong1, SearchParams paramSearchParams, long paramLong2)
  {
    cvm.b("Exchange", "EasServiceBinder.searchMessages", new Object[0]);
    return (Bundle)new bry(this, paramLong1, paramSearchParams, paramLong2).b();
  }
  
  public final Bundle a(HostAuthCompat paramHostAuthCompat)
  {
    cvm.b("Exchange", "EasServiceBinder.validate", new Object[0]);
    return (Bundle)new bsp(this, paramHostAuthCompat).b();
  }
  
  final Bundle a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3)
  {
    Object localObject;
    int i;
    do
    {
      if (f != null)
      {
        localObject = f;
        i = ((bpl)localObject).p_();
        cvm.b("Exchange", "EasService.attemptAutodiscover: Operation result=[%s]", new Object[] { Integer.valueOf(i) });
        if ((i == -101) && (paramInt3 < 3)) {
          return a(paramInt1, paramInt2, e, paramInt3 + 1);
        }
      }
      else
      {
        Context localContext = c;
        switch (paramInt2)
        {
        default: 
          cvm.f("Exchange", "EasAutodiscover.getUsername: Invalid authAttempt=[%s]", new Object[] { Integer.valueOf(paramInt2) });
          localObject = null;
        }
        for (;;)
        {
          localObject = new bpl(localContext, paramString1, paramInt1, paramInt3, (String)localObject, paramString3, paramString2);
          break;
          cvm.d("Exchange", "EasAutodiscover.getUsername: Trying full UPN", new Object[0]);
          localObject = paramString2;
          continue;
          cvm.d("Exchange", "EasAutodiscover.getUsername: Trying stripped UPN", new Object[0]);
          localObject = bpl.a(paramString2);
          continue;
          cvm.d("Exchange", "EasAutodiscover.getUsername: Trying domain-level", new Object[0]);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(cui.b(paramString2)).append('\\').append(bpl.a(paramString2));
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      if (i != -100) {
        break;
      }
      i = paramInt2 + 1;
      paramInt2 = i;
    } while (i < 3);
    paramString1 = new Bundle(1);
    paramString1.putInt("autodiscover_error_code", -1);
    return paramString1;
    if (i == 0)
    {
      paramString1 = new Bundle(2);
      paramString1.putParcelable("autodiscover_host_auth", new HostAuthCompat(d));
      paramString1.putInt("autodiscover_error_code", 0);
      return paramString1;
    }
    paramString1 = new Bundle(1);
    paramString1.putInt("autodiscover_error_code", -102);
    return paramString1;
  }
  
  public final Bundle a(String paramString1, String paramString2)
  {
    cvm.b("Exchange", "EasServiceBinder.autoDiscover: Starting flow", new Object[0]);
    return (Bundle)new bsb(this, paramString1, paramString2).b();
  }
  
  public final Bundle a(String paramString1, String paramString2, Bundle paramBundle)
  {
    cvm.b("Exchange", "EasServiceBinder.continueAutodiscover", new Object[0]);
    return (Bundle)new bsc(this, paramBundle, paramString1, paramString2).b();
  }
  
  public final List<RecipientAvailability> a(String paramString, List<String> paramList, long paramLong1, long paramLong2)
  {
    cvm.b("Exchange", "EasServiceBinder.retrieveRecipientAvailabilities", new Object[0]);
    return (List)new bsf(this, paramString, paramList, paramLong1, paramLong2).b();
  }
  
  public final void a(int paramInt)
  {
    cvm.e("Exchange", new Throwable(), "call to deprecated setLogging", new Object[0]);
    new bsd(this).b();
  }
  
  public final void a(long paramLong)
  {
    cvm.b("Exchange", "EasServiceBinder.updateFolderList: %d", new Object[] { Long.valueOf(paramLong) });
    new bsj(this, paramLong).b();
  }
  
  public final void a(long paramLong1, int paramInt, long paramLong2, long paramLong3, String paramString)
  {
    cvm.b("Exchange", "EasServiceBinder.sendMeetingResponse", new Object[0]);
    new brz(this, paramLong1, paramInt, paramLong2, paramLong3, paramString).b();
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    cvm.b("Exchange", "EasServiceBinder.pushModifyWithBackoff: %d", new Object[] { Long.valueOf(paramLong1) });
    new bso(this, paramLong1, paramLong2).b();
  }
  
  public final void a(long paramLong, ExchangeOofSettings paramExchangeOofSettings)
  {
    cvm.b("Exchange", "EasServiceBinder.syncEasOofSettings", new Object[0]);
    new bsa(this, paramLong, paramExchangeOofSettings).b();
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2)
  {
    cvm.b("Exchange", "EasServiceBinder.createFolder: %s", new Object[] { paramString });
    new bsk(this, paramLong1, paramString, paramLong2).b();
  }
  
  public final void a(bfb parambfb, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    cvm.b("Exchange", "EasServiceBinder.loadAttachment: %d", new Object[] { Long.valueOf(paramLong2) });
    new brx(this, paramLong1, paramLong2, parambfb).b();
  }
  
  public final void a(String paramString)
  {
    cvm.b("Exchange", "EasServiceBinder.deleteExternalAccountPIMData", new Object[0]);
    new bse(this, paramString).b();
  }
  
  public final String b(String paramString)
  {
    cvm.b("Exchange", "EasServiceBinder.getProtocolVersion", new Object[0]);
    return (String)new bsg(this, paramString).b();
  }
  
  public final void b()
  {
    try
    {
      if (!b)
      {
        ArrayList localArrayList = new ArrayList(5);
        localArrayList.clear();
        localArrayList.add(bdv.F);
        localArrayList.add("com.android.calendar");
        localArrayList.add("com.android.contacts");
        a = localArrayList;
        b = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void b(long paramLong)
  {
    a(paramLong, 0L);
  }
  
  public final void b(long paramLong1, long paramLong2)
  {
    cvm.b("Exchange", "EasServiceBinder.markFolderForDeletion: %d", new Object[] { Long.valueOf(paramLong2) });
    new bsl(this).b();
  }
  
  public final void c(long paramLong)
  {
    cvm.f("Exchange", "unexpected call to EasService.sendMail", new Object[0]);
    new bsm(this).b();
  }
  
  public final void c(long paramLong1, long paramLong2)
  {
    cvm.b("Exchange", "EasServiceBinder.loadMeetingResponse: %d", new Object[] { Long.valueOf(paramLong2) });
    new bsi(this, paramLong1, paramLong2).b();
  }
  
  final void setAutodiscoverOperationForTest(bpl parambpl)
  {
    f = parambpl;
  }
  
  final void setSrvHostnameForTest(String paramString)
  {
    e = paramString;
  }
}

/* Location:
 * Qualified Name:     brw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */