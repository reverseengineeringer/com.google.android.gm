import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ctl
{
  private static final String a = cvl.a;
  
  public static com.android.mail.providers.Account a(Context paramContext, String paramString)
  {
    paramContext = b(paramContext);
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      com.android.mail.providers.Account localAccount = paramContext[i];
      if (TextUtils.equals(c, paramString)) {
        return localAccount;
      }
      i += 1;
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString, cto paramcto, int paramInt)
  {
    Object localObject = AccountManager.get(paramContext);
    String str;
    int i;
    switch (paramInt)
    {
    default: 
      cvm.c(a, "unknown account type: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    case 0: 
      str = paramContext.getString(buj.b);
      localObject = ((AccountManager)localObject).getAccountsByType(str);
      i = localObject.length;
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt >= i) {
        break label176;
      }
      str = localObject[paramInt];
      if (TextUtils.equals(paramString, name))
      {
        paramContext = AccountManager.get(paramContext);
        if (Build.VERSION.SDK_INT >= 22) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label152;
          }
          paramContext.removeAccount(str, null, new ctm(paramcto), null);
          return;
          str = paramContext.getString(buj.a);
          break;
        }
        label152:
        paramContext.removeAccount(str, new ctn(paramcto), null);
        return;
      }
      paramInt += 1;
    }
    label176:
    cvm.c(a, "Failed to find account %s for removal", new Object[] { paramString });
    paramcto.a(false);
  }
  
  public static void a(String paramString1, PrintWriter paramPrintWriter, String paramString2, String paramString3, cfg paramcfg)
  {
    paramString2 = cui.e(paramString2);
    paramPrintWriter.append(paramString1).append(paramString2).append(":\n");
    paramPrintWriter.append(paramString1).append("  settings: ").append(paramString3).append("\n");
    int i = d.getInt("account-inbox-size", -1);
    if (i != -1) {
      paramPrintWriter.append(paramString1).append("  inbox-size: ").append(Integer.toString(i)).append("\n");
    }
    paramString2 = d.getString("account-cipher", null);
    if (paramString2 != null) {
      paramPrintWriter.append(paramString1).append("  cipher: ").append(paramString2).append("\n");
    }
    paramPrintWriter.append(paramString1).append("  syncs:\n");
    paramString2 = new ArrayList();
    paramString3 = d;
    i = 0;
    while (i < 5)
    {
      String str = String.valueOf("account-sync-snapshot");
      str = paramString3.getString(String.valueOf(str).length() + 11 + str + i, null);
      if (str != null) {
        paramString2.add(str);
      }
      i += 1;
    }
    paramString2 = paramString2.iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (String)paramString2.next();
      paramPrintWriter.append(paramString1).append("    ").append(paramString3).append("\n");
    }
    paramPrintWriter.append(paramString1).append("  sync-errors:\n");
    paramString2 = paramcfg.d().iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (String)paramString2.next();
      paramPrintWriter.append(paramString1).append("    ").append(paramString3).append("\n");
    }
  }
  
  /* Error */
  public static com.android.mail.providers.Account[] a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 209	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: new 149	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 151	java/util/ArrayList:<init>	()V
    //   12: astore_1
    //   13: aload_0
    //   14: invokestatic 214	cgr:b	()Landroid/net/Uri;
    //   17: getstatic 219	chh:c	[Ljava/lang/String;
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: invokevirtual 225	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull +56 -> 84
    //   31: aload_0
    //   32: invokeinterface 230 1 0
    //   37: ifeq +47 -> 84
    //   40: invokestatic 233	com/android/mail/providers/Account:b	()Lcfw;
    //   43: pop
    //   44: aload_0
    //   45: invokestatic 238	cfw:a	(Landroid/database/Cursor;)Lcom/android/mail/providers/Account;
    //   48: astore_2
    //   49: aload_2
    //   50: invokevirtual 240	com/android/mail/providers/Account:d	()Z
    //   53: ifne -22 -> 31
    //   56: aload_1
    //   57: aload_2
    //   58: invokeinterface 182 2 0
    //   63: pop
    //   64: goto -33 -> 31
    //   67: astore_2
    //   68: aload_0
    //   69: astore_1
    //   70: aload_2
    //   71: astore_0
    //   72: aload_1
    //   73: ifnull +9 -> 82
    //   76: aload_1
    //   77: invokeinterface 243 1 0
    //   82: aload_0
    //   83: athrow
    //   84: aload_0
    //   85: ifnull +9 -> 94
    //   88: aload_0
    //   89: invokeinterface 243 1 0
    //   94: aload_1
    //   95: aload_1
    //   96: invokeinterface 246 1 0
    //   101: anewarray 21	com/android/mail/providers/Account
    //   104: invokeinterface 250 2 0
    //   109: checkcast 252	[Lcom/android/mail/providers/Account;
    //   112: areturn
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_1
    //   116: goto -44 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramContext	Context
    //   12	104	1	localObject1	Object
    //   48	10	2	localAccount	com.android.mail.providers.Account
    //   67	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	64	67	finally
    //   13	27	113	finally
  }
  
  /* Error */
  public static com.android.mail.providers.Account[] b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 209	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: new 149	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 151	java/util/ArrayList:<init>	()V
    //   12: astore_1
    //   13: aload_0
    //   14: invokestatic 214	cgr:b	()Landroid/net/Uri;
    //   17: getstatic 219	chh:c	[Ljava/lang/String;
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: invokevirtual 225	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull +47 -> 75
    //   31: aload_0
    //   32: invokeinterface 230 1 0
    //   37: ifeq +38 -> 75
    //   40: invokestatic 233	com/android/mail/providers/Account:b	()Lcfw;
    //   43: pop
    //   44: aload_1
    //   45: aload_0
    //   46: invokestatic 238	cfw:a	(Landroid/database/Cursor;)Lcom/android/mail/providers/Account;
    //   49: invokeinterface 182 2 0
    //   54: pop
    //   55: goto -24 -> 31
    //   58: astore_2
    //   59: aload_0
    //   60: astore_1
    //   61: aload_2
    //   62: astore_0
    //   63: aload_1
    //   64: ifnull +9 -> 73
    //   67: aload_1
    //   68: invokeinterface 243 1 0
    //   73: aload_0
    //   74: athrow
    //   75: aload_0
    //   76: ifnull +9 -> 85
    //   79: aload_0
    //   80: invokeinterface 243 1 0
    //   85: aload_1
    //   86: aload_1
    //   87: invokeinterface 246 1 0
    //   92: anewarray 21	com/android/mail/providers/Account
    //   95: invokeinterface 250 2 0
    //   100: checkcast 252	[Lcom/android/mail/providers/Account;
    //   103: areturn
    //   104: astore_0
    //   105: aconst_null
    //   106: astore_1
    //   107: goto -44 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramContext	Context
    //   12	95	1	localObject1	Object
    //   58	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	55	58	finally
    //   13	27	104	finally
  }
  
  public static int c(Context paramContext)
  {
    int i = 0;
    String[] arrayOfString = paramContext.getResources().getStringArray(btw.a);
    int k = arrayOfString.length;
    int j = 0;
    while (i < k)
    {
      String str = arrayOfString[i];
      j += AccountManager.get(paramContext).getAccountsByType(str).length;
      i += 1;
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     ctl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */