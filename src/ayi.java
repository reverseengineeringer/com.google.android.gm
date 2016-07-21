import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.android.email.SecurityPolicy;
import com.android.email.provider.EmailProvider;
import com.android.email.service.EasAuthenticatorService;
import com.android.emailcommon.provider.HostAuth;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class ayi
{
  public static void a(Context paramContext)
  {
    Object localObject1;
    try
    {
      localObject1 = AccountManager.get(paramContext);
      Object localObject2 = new LinkedHashSet();
      ((LinkedHashSet)localObject2).add(paramContext.getString(arh.j));
      ((LinkedHashSet)localObject2).add(paramContext.getString(arh.k));
      ((LinkedHashSet)localObject2).add(paramContext.getString(arh.i));
      heh localheh = new heh();
      localObject2 = ((LinkedHashSet)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localheh.b(((AccountManager)localObject1).getAccountsByType((String)((Iterator)localObject2).next()));
      }
      localObject1 = localheh.a();
    }
    finally {}
    a(paramContext, b(paramContext), (List)localObject1);
  }
  
  private static boolean a(boolean paramBoolean)
  {
    cvm.b(bbw.a, "reconcileAccountsInternal", new Object[0]);
    boolean bool2;
    if (bhb.c())
    {
      cvm.b(bbw.a, "deferring reconciliation, migration in progress", new Object[0]);
      bool2 = false;
      return bool2;
    }
    Object localObject5;
    Object localObject1;
    Object localObject6;
    int k;
    boolean bool1;
    int j;
    int i;
    label118:
    com.android.emailcommon.provider.Account localAccount;
    Object localObject4;
    Object localObject7;
    if (!bam.c(paramBoolean, paramBoolean.getString(arh.ck)))
    {
      if (!cxd.b())
      {
        cvm.d("EasBundling", "WARNING: disabling EasAuthenticatorService. EAS accounts will be deleted!", new Object[0]);
        cvm.b(bam.a, "Disabling EAS authenticators", new Object[0]);
        bam.a(paramBoolean, EasAuthenticatorService.class, false);
      }
      localObject5 = paramBoolean.getString(arh.cm);
      localObject6 = ((List)localObject1).iterator();
      k = 0;
      bool1 = false;
      j = 0;
      i = 0;
      if (!((Iterator)localObject6).hasNext()) {
        break label527;
      }
      localAccount = (com.android.emailcommon.provider.Account)((Iterator)localObject6).next();
      localObject4 = d;
      localObject7 = bam.b(paramBoolean, D);
      bool2 = TextUtils.equals((CharSequence)localObject5, db);
      if (!bool2) {
        break label955;
      }
      i += 1;
    }
    label333:
    label527:
    label538:
    label794:
    label816:
    label836:
    label912:
    label917:
    label923:
    label930:
    label955:
    for (;;)
    {
      String str;
      Object localObject2;
      int m;
      if (localObject7 != null)
      {
        str = c;
        Iterator localIterator = ((List)localObject2).iterator();
        while (localIterator.hasNext())
        {
          android.accounts.Account localAccount1 = (android.accounts.Account)localIterator.next();
          if ((name.equalsIgnoreCase((String)localObject4)) && (type.equalsIgnoreCase(str))) {
            m = 1;
          }
        }
      }
      for (;;)
      {
        if (m == 0)
        {
          if ((localObject7 != null) && ((j & 0x10) != 0))
          {
            cvm.d(bbw.a, "Account reconciler noticed incomplete account; ignoring", new Object[0]);
            break label118;
            bam.d(paramBoolean);
            break;
            m = 0;
            continue;
          }
          localObject7 = bbw.a;
          localObject4 = String.valueOf(localObject4);
          if (((String)localObject4).length() != 0)
          {
            localObject4 = "Account deleted in AccountManager; deleting from provider: ".concat((String)localObject4);
            cvm.b((String)localObject7, (String)localObject4, new Object[0]);
            localObject4 = localAccount.d(paramBoolean);
            localObject7 = bbw.a;
            str = String.valueOf(localObject4);
            cvm.d((String)localObject7, String.valueOf(str).length() + 30 + "deleted account with hostAuth " + str, new Object[0]);
            m = j;
            if (localObject4 != null)
            {
              m = j;
              if (TextUtils.equals(b, paramBoolean.getString(arh.ck))) {
                m = 1;
              }
            }
            localObject4 = bbz.a(paramBoolean);
            if (localObject4 != null) {
              ((bbx)localObject4).a(paramBoolean, localAccount);
            }
            paramBoolean.getContentResolver().delete(EmailProvider.a("uiaccount", D), null, null);
            j = i;
            if (bool2) {
              j = i - 1;
            }
            i = j;
            j = m;
            k += 1;
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        break label118;
        localObject4 = new String("Account deleted in AccountManager; deleting from provider: ");
        break label333;
        localObject4 = ((List)localObject2).iterator();
        m = 0;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (android.accounts.Account)((Iterator)localObject4).next();
          localObject2 = name;
          if (!a((List)localObject1, (String)localObject2))
          {
            bool1 = true;
            localObject6 = bbw.a;
            localObject2 = String.valueOf(localObject2);
            if (((String)localObject2).length() != 0)
            {
              localObject2 = "Account deleted from provider; deleting from AccountManager: ".concat((String)localObject2);
              cvm.b((String)localObject6, (String)localObject2, new Object[0]);
              localObject2 = AccountManager.get(paramBoolean).removeAccount((android.accounts.Account)localObject5, null, null);
            }
          }
        }
        try
        {
          ((AccountManagerFuture)localObject2).getResult();
          m = 1;
          break label538;
          localObject2 = new String("Account deleted from provider; deleting from AccountManager: ");
        }
        catch (OperationCanceledException localOperationCanceledException)
        {
          for (;;)
          {
            cvm.d(bbw.a, localOperationCanceledException.toString(), new Object[0]);
          }
          Object localObject3 = bam.e(paramBoolean, bam.f(paramBoolean, type));
          if ((localObject3 == null) || (!v)) {
            ContentResolver.setIsSyncable((android.accounts.Account)localObject5, "com.android.calendar", 0);
          }
          if ((localObject3 != null) && (u)) {
            break label538;
          }
          ContentResolver.setIsSyncable((android.accounts.Account)localObject5, "com.android.contacts", 0);
          break label538;
          if (i == 0)
          {
            cvm.b(bap.a, "cancelBackgroundPurge", new Object[0]);
            bap.b.b(paramBoolean);
          }
          if (m != 0) {
            SecurityPolicy.a(paramBoolean).b();
          }
          localObject3 = paramBoolean.getString(arh.co);
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            if (((List)localObject1).size() - k <= 0) {
              break label912;
            }
            i = 1;
            localObject1 = new ComponentName(paramBoolean, (String)localObject3);
            localObject3 = paramBoolean.getPackageManager();
            if (i == 0) {
              break label917;
            }
            m = 1;
            ((PackageManager)localObject3).setComponentEnabledSetting((ComponentName)localObject1, m, 1);
            localObject3 = cvm.a;
            if (i == 0) {
              break label923;
            }
            localObject1 = "enabled";
            localObject1 = String.valueOf(localObject1);
            if (((String)localObject1).length() == 0) {
              break label930;
            }
          }
          for (localObject1 = "Setting compose activity to ".concat((String)localObject1);; localObject1 = new String("Setting compose activity to "))
          {
            cvm.b((String)localObject3, (String)localObject1, new Object[0]);
            bool2 = bool1;
            if (k <= 0) {
              break;
            }
            cvm.c(bbw.a, "Restarting because account deleted", new Object[0]);
            if (j != 0) {
              bam.a(paramBoolean, paramBoolean.getString(arh.ck));
            }
            bam.b(paramBoolean);
            return bool1;
            i = 0;
            break label794;
            m = 2;
            break label816;
            localObject1 = "disabled";
            break label836;
          }
        }
        catch (AuthenticatorException localAuthenticatorException)
        {
          for (;;) {}
        }
        catch (IOException localIOException)
        {
          for (;;) {}
        }
      }
    }
  }
  
  private static boolean a(List<com.android.emailcommon.provider.Account> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (nextd.equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private static List<com.android.emailcommon.provider.Account> b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 223	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 343	com/android/emailcommon/provider/Account:a	Landroid/net/Uri;
    //   7: getstatic 347	com/android/emailcommon/provider/Account:y	[Ljava/lang/String;
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 351	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnonnull +7 -> 25
    //   21: invokestatic 357	java/util/Collections:emptyList	()Ljava/util/List;
    //   24: areturn
    //   25: new 42	heh
    //   28: dup
    //   29: invokespecial 43	heh:<init>	()V
    //   32: astore_1
    //   33: aload_0
    //   34: invokeinterface 362 1 0
    //   39: ifeq +34 -> 73
    //   42: new 137	com/android/emailcommon/provider/Account
    //   45: dup
    //   46: invokespecial 363	com/android/emailcommon/provider/Account:<init>	()V
    //   49: astore_2
    //   50: aload_2
    //   51: aload_0
    //   52: invokevirtual 366	com/android/emailcommon/provider/Account:a	(Landroid/database/Cursor;)V
    //   55: aload_1
    //   56: aload_2
    //   57: invokevirtual 369	heh:c	(Ljava/lang/Object;)Lheh;
    //   60: pop
    //   61: goto -28 -> 33
    //   64: astore_1
    //   65: aload_0
    //   66: invokeinterface 372 1 0
    //   71: aload_1
    //   72: athrow
    //   73: aload_0
    //   74: invokeinterface 372 1 0
    //   79: aload_1
    //   80: invokevirtual 70	heh:a	()Lhef;
    //   83: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramContext	Context
    //   32	24	1	localheh	heh
    //   64	16	1	localObject	Object
    //   49	8	2	localAccount	com.android.emailcommon.provider.Account
    // Exception table:
    //   from	to	target	type
    //   33	61	64	finally
  }
}

/* Location:
 * Qualified Name:     ayi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */