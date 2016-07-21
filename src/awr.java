import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.HostAuth;
import java.util.HashMap;
import java.util.Map;

public abstract class awr
{
  static final Map<HostAuth, awr> a = new HashMap(2);
  private static String g;
  private static String h;
  public Context b;
  public Account c;
  public ayd d;
  public String e;
  public String f;
  
  public static awr a(Account paramAccount, Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(g)) {
          g = paramContext.getString(arh.cn);
        }
        if (TextUtils.isEmpty(h)) {
          h = paramContext.getString(arh.cm);
        }
        Object localObject = paramAccount.d(paramContext);
        if (localObject == null)
        {
          paramAccount = null;
          return paramAccount;
        }
        if (!x)
        {
          localObject = (awr)a.get(localObject);
          if (localObject == null)
          {
            paramAccount = a(paramAccount, paramContext, true);
          }
          else
          {
            c = paramAccount;
            paramAccount = (Account)localObject;
          }
        }
        else
        {
          paramAccount = a(paramAccount, paramContext, false);
        }
      }
      finally {}
    }
  }
  
  private static awr a(Account paramAccount, Context paramContext, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        HostAuth localHostAuth = paramAccount.d(paramContext);
        String str = b;
        if (str.equals(g))
        {
          paramAccount = new axg(paramContext, paramAccount);
          if ((D != -1L) && (paramBoolean)) {
            a.put(localHostAuth, paramAccount);
          }
          return paramAccount;
        }
        if (str.equals(h)) {
          paramAccount = new axd(paramContext, paramAccount);
        } else {
          paramAccount = new axn(paramAccount, paramContext);
        }
      }
      finally {}
    }
  }
  
  public static boolean a()
  {
    return true;
  }
  
  public Bundle a(String paramString1, String paramString2)
  {
    return null;
  }
  
  public Bundle a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return null;
  }
  
  public bdb a(String paramString)
  {
    return null;
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(long paramLong1, String paramString, long paramLong2) {}
  
  public boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  public bdb[] b()
  {
    return null;
  }
  
  public abstract Bundle c();
  
  public int d()
  {
    return 0;
  }
  
  public void e() {}
}

/* Location:
 * Qualified Name:     awr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */