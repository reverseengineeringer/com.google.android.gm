import android.content.Context;
import android.text.TextUtils;
import com.android.mail.providers.Account;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public final class dmo
{
  public static final String a = cvl.a;
  static dmp b;
  private static final boolean e = bhk.a();
  public hkk c;
  public final Context d;
  private boolean f;
  private ehi g;
  
  public dmo(Context paramContext)
  {
    d = paramContext.getApplicationContext();
    g = new ehi(d, "ANDROID_GMAIL");
    c = new hkk();
    hkk localhkk = c;
    String str = cxd.a(d);
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = "unknown";
    }
    if (paramContext == null) {
      throw new NullPointerException();
    }
    b = paramContext;
    a |= 0x1;
    paramContext = c;
    if (cxa.a(d.getResources())) {}
    for (int i = 3;; i = 2)
    {
      c = i;
      a |= 0x2;
      paramContext = c;
      d = 2;
      a |= 0x4;
      return;
    }
  }
  
  private static hkn a(int paramInt1, int paramInt2, String paramString)
  {
    String str = dyp.a(paramString, cui.b(paramString));
    Object localObject;
    long l;
    try
    {
      localObject = MessageDigest.getInstance("SHA-512");
      ((MessageDigest)localObject).update(paramString.getBytes());
      l = hku.a(((MessageDigest)localObject).digest());
      paramString = new hkn();
      localObject = new hkj();
      b = paramInt1;
      a |= 0x1;
      c = paramInt2;
      a |= 0x2;
      if (str == null) {
        throw new NullPointerException();
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      dri.e(a, "ClearcutApiHelper: Missing hashing algorithm, ignoring active event", new Object[0]);
      buo.a().a("clearcut", "dropped_active_event", "sha512_not_found", 0L);
      return null;
    }
    d = str;
    a |= 0x4;
    e = l;
    a |= 0x8;
    c = ((hkj)localObject);
    return paramString;
  }
  
  public static hkf[] a(List<cwz> paramList)
  {
    int m = Math.min(5, paramList.size());
    hkf[] arrayOfhkf = new hkf[m];
    int j = 0;
    while (j < m)
    {
      hkf localhkf = new hkf();
      Object localObject = (cwz)paramList.get(j);
      ArrayList localArrayList = a;
      localObject = b;
      int k = 1;
      if (k < localArrayList.size())
      {
        int n = (int)(((Long)localArrayList.get(k)).longValue() - ((Long)localArrayList.get(k - 1)).longValue());
        String str = (String)((ArrayList)localObject).get(k);
        label216:
        int i;
        switch (str.hashCode())
        {
        default: 
          i = -1;
          switch (i)
          {
          default: 
            label218:
            dri.b(a, "ClearcutApiHelper: Invalid split label.", new Object[0]);
          }
          break;
        }
        for (;;)
        {
          k += 1;
          break;
          if (!str.equals("openedFolder")) {
            break label216;
          }
          i = 0;
          break label218;
          if (!str.equals("msgCount")) {
            break label216;
          }
          i = 1;
          break label218;
          if (!str.equals("gotMsgIds")) {
            break label216;
          }
          i = 2;
          break label218;
          if (!str.equals("foundUnsynced")) {
            break label216;
          }
          i = 3;
          break label218;
          if (!str.equals("downloadedUnsyncedFlags")) {
            break label216;
          }
          i = 4;
          break label218;
          if (!str.equals("downloadedSyncedFlags")) {
            break label216;
          }
          i = 5;
          break label218;
          if (!str.equals("updatedFlags")) {
            break label216;
          }
          i = 6;
          break label218;
          if (!str.equals("processedRemoteDeletes")) {
            break label216;
          }
          i = 7;
          break label218;
          if (!str.equals("loadedMsgs")) {
            break label216;
          }
          i = 8;
          break label218;
          if (!str.equals("addedSyncInfo")) {
            break label216;
          }
          i = 9;
          break label218;
          if (!str.equals("closedFolder")) {
            break label216;
          }
          i = 10;
          break label218;
          b = n;
          a |= 0x1;
          continue;
          c = n;
          a |= 0x2;
          continue;
          d = n;
          a |= 0x4;
          continue;
          e = n;
          a |= 0x8;
          continue;
          f = n;
          a |= 0x10;
          continue;
          g = n;
          a |= 0x20;
          continue;
          h = n;
          a |= 0x40;
          continue;
          i = n;
          a |= 0x80;
          continue;
          j = n;
          a |= 0x100;
          continue;
          k = n;
          a |= 0x200;
          continue;
          l = n;
          a |= 0x400;
        }
      }
      arrayOfhkf[j] = localhkf;
      j += 1;
    }
    return arrayOfhkf;
  }
  
  public final void a(int paramInt, Account paramAccount)
  {
    int j = 1;
    if (a()) {}
    label48:
    do
    {
      do
      {
        return;
      } while (!ghz.a(d.getContentResolver(), "gmail_active_event_logging", true));
      if (paramAccount != null) {
        break;
      }
      dri.d(a, "ClearcutApiHelper: Null account, skipping active event", new Object[0]);
      paramAccount = null;
    } while (paramAccount == null);
    b = c;
    a(paramAccount, null);
    dri.b(a, "ClearcutApiHelper: Successfully sent active event", new Object[0]);
    return;
    String str = bur.a(d, e);
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramAccount = null;
        break label48;
        if (str.equals("IMAP"))
        {
          i = 0;
          continue;
          if (str.equals("POP3"))
          {
            i = 1;
            continue;
            if (str.equals("EXCHANGE")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    for (j = 2;; j = 3)
    {
      paramAccount = a(paramInt, j, c);
      break;
    }
  }
  
  public final void a(dmq paramdmq, String paramString)
  {
    cxa.g("VEL.buildProto");
    if (a())
    {
      cxa.a();
      return;
    }
    hkn localhkn = new hkn();
    hkp localhkp = new hkp();
    if (!a.isEmpty())
    {
      Object localObject = (Integer)a.remove(0);
      hkd localhkd = b;
      b = ((Integer)localObject).intValue();
      a |= 0x1;
      if (d != -1)
      {
        localObject = b;
        e = d;
        a |= 0x4;
      }
      int j = a.size();
      localObject = new int[j];
      int i = 0;
      while (i < j)
      {
        localObject[i] = ((Integer)a.get(i)).intValue();
        i += 1;
      }
      if (localObject.length > 0) {
        b.d = ((int[])localObject);
      }
    }
    a = b;
    paramdmq = c;
    if (paramdmq != null) {
      b = paramdmq;
    }
    f = localhkp;
    b = c;
    a(localhkn, paramString);
    dri.b(a, "ClearcutApiHelper: Successfully sent Visual Element event", new Object[0]);
    cxa.a();
  }
  
  public final void a(hkn paramhkn, String paramString)
  {
    cxa.g("CAH.logEvent");
    dmp localdmp;
    if (b != null)
    {
      localdmp = b;
      a = paramhkn;
    }
    for (paramhkn = localdmp;; paramhkn = new dmp(paramhkn))
    {
      paramhkn = new ehk(g, paramhkn);
      if (!ehi.h(b)) {
        break;
      }
      throw new IllegalArgumentException("setUploadAccountName forbidden on anonymous logger");
    }
    a = paramString;
    paramhkn.a();
    cxa.a();
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    if (a()) {}
    do
    {
      return;
      paramString = a(14, 3, paramString);
    } while (paramString == null);
    hkl localhkl = new hkl();
    b = paramBoolean;
    a |= 0x1;
    c = true;
    a |= 0x2;
    d = localhkl;
    a(paramString, null);
    dri.b(a, "ClearcutApiHelper: Successfully sent add account event", new Object[0]);
  }
  
  public final boolean a()
  {
    return (!f) && (e);
  }
}

/* Location:
 * Qualified Name:     dmo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */