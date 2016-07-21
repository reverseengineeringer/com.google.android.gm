package com.google.android.gm;

import android.accounts.AccountManager;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.SQLException;
import android.net.http.AndroidHttpClient;
import android.os.Bundle;
import bts;
import cfb;
import cfg;
import cfk;
import cfr;
import chq;
import com.android.mail.providers.Folder;
import com.google.android.gm.persistence.GmailBackupAgent;
import com.google.android.gm.provider.GmailProvider;
import cui;
import cvm;
import cvz;
import cxf;
import ddy;
import dev;
import dfg;
import dfh;
import dge;
import dkm;
import dkn;
import dkp;
import dkq;
import dkr;
import dmo;
import dmr;
import dmv;
import dnb;
import dnm;
import dnn;
import dpa;
import dpy;
import dri;
import drp;
import dsj;
import dtn;
import ghz;
import gnr;
import hjy;
import hkm;
import hkn;
import hkr;
import hkw;
import hkx;
import hli;
import hlt;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class GmailIntentService
  extends bts
{
  public GmailIntentService()
  {
    super("GmailIntentService");
  }
  
  private final void a(Intent paramIntent, int paramInt)
  {
    String str1 = paramIntent.getStringExtra("account");
    String str2 = paramIntent.getStringExtra("extraMessageSubject");
    long l = paramIntent.getLongExtra("extraConversationId", -1L);
    dfh.a(getBaseContext(), str1, str2, l, getBaseContext().getString(paramInt));
  }
  
  /* Error */
  private final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iload_1
    //   3: ifeq +6 -> 9
    //   6: invokestatic 58	dmt:a	()V
    //   9: aload_0
    //   10: invokestatic 64	android/accounts/AccountManager:get	(Landroid/content/Context;)Landroid/accounts/AccountManager;
    //   13: ldc 66
    //   15: getstatic 72	ddy:b	[Ljava/lang/String;
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 76	android/accounts/AccountManager:getAccountsByTypeAndFeatures	(Ljava/lang/String;[Ljava/lang/String;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;
    //   23: astore 5
    //   25: aload 5
    //   27: invokeinterface 82 1 0
    //   32: checkcast 84	[Landroid/accounts/Account;
    //   35: astore 7
    //   37: iload_2
    //   38: ifeq +252 -> 290
    //   41: aload_0
    //   42: invokevirtual 36	com/google/android/gm/GmailIntentService:getBaseContext	()Landroid/content/Context;
    //   45: astore 5
    //   47: getstatic 89	drp:b	Ljava/lang/String;
    //   50: ldc 91
    //   52: iconst_0
    //   53: anewarray 93	java/lang/Object
    //   56: invokestatic 98	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   59: pop
    //   60: invokestatic 102	cwv:b	()V
    //   63: new 104	java/util/HashSet
    //   66: dup
    //   67: invokespecial 106	java/util/HashSet:<init>	()V
    //   70: astore 6
    //   72: aload 7
    //   74: arraylength
    //   75: istore 4
    //   77: iload_3
    //   78: iload 4
    //   80: if_icmpge +38 -> 118
    //   83: aload 7
    //   85: iload_3
    //   86: aaload
    //   87: astore 8
    //   89: aload 8
    //   91: getfield 111	android/accounts/Account:type	Ljava/lang/String;
    //   94: ldc 66
    //   96: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifeq +225 -> 324
    //   102: aload 6
    //   104: aload 8
    //   106: getfield 120	android/accounts/Account:name	Ljava/lang/String;
    //   109: invokeinterface 125 2 0
    //   114: pop
    //   115: goto +209 -> 324
    //   118: aload 5
    //   120: aload 5
    //   122: invokestatic 64	android/accounts/AccountManager:get	(Landroid/content/Context;)Landroid/accounts/AccountManager;
    //   125: ldc 66
    //   127: getstatic 72	ddy:b	[Ljava/lang/String;
    //   130: aconst_null
    //   131: aconst_null
    //   132: invokevirtual 76	android/accounts/AccountManager:getAccountsByTypeAndFeatures	(Ljava/lang/String;[Ljava/lang/String;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;
    //   135: invokeinterface 82 1 0
    //   140: checkcast 84	[Landroid/accounts/Account;
    //   143: invokestatic 128	drp:a	(Landroid/content/Context;[Landroid/accounts/Account;)Ljava/util/List;
    //   146: invokeinterface 134 1 0
    //   151: astore 7
    //   153: aload 7
    //   155: invokeinterface 140 1 0
    //   160: ifeq +58 -> 218
    //   163: aload 6
    //   165: aload 7
    //   167: invokeinterface 143 1 0
    //   172: checkcast 86	drp
    //   175: getfield 147	drp:l	Landroid/accounts/Account;
    //   178: getfield 120	android/accounts/Account:name	Ljava/lang/String;
    //   181: invokeinterface 150 2 0
    //   186: pop
    //   187: goto -34 -> 153
    //   190: astore 5
    //   192: ldc -104
    //   194: aload 5
    //   196: ldc -102
    //   198: iconst_0
    //   199: anewarray 93	java/lang/Object
    //   202: invokestatic 158	dri:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   205: pop
    //   206: iload_1
    //   207: ifeq +6 -> 213
    //   210: invokestatic 159	dmt:b	()V
    //   213: aload_0
    //   214: invokestatic 164	com/google/android/gm/provider/GmailProvider:a	(Landroid/content/Context;)V
    //   217: return
    //   218: aload 6
    //   220: invokeinterface 165 1 0
    //   225: astore 6
    //   227: aload 6
    //   229: invokeinterface 140 1 0
    //   234: ifeq +63 -> 297
    //   237: aload 6
    //   239: invokeinterface 143 1 0
    //   244: checkcast 113	java/lang/String
    //   247: astore 7
    //   249: aload 5
    //   251: aload 7
    //   253: invokestatic 168	drp:a	(Landroid/content/Context;Ljava/lang/String;)Ldrp;
    //   256: astore 8
    //   258: aload 7
    //   260: aload 8
    //   262: getfield 147	drp:l	Landroid/accounts/Account;
    //   265: getfield 120	android/accounts/Account:name	Ljava/lang/String;
    //   268: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   271: ifne +10 -> 281
    //   274: aload 8
    //   276: aload 7
    //   278: invokevirtual 170	drp:b	(Ljava/lang/String;)V
    //   281: aload 8
    //   283: iconst_1
    //   284: invokevirtual 173	drp:a	(Z)V
    //   287: goto -60 -> 227
    //   290: aload_0
    //   291: aload 7
    //   293: iload_1
    //   294: invokespecial 176	com/google/android/gm/GmailIntentService:a	([Landroid/accounts/Account;Z)V
    //   297: iload_1
    //   298: ifeq -85 -> 213
    //   301: invokestatic 159	dmt:b	()V
    //   304: goto -91 -> 213
    //   307: astore 5
    //   309: iload_1
    //   310: ifeq +6 -> 316
    //   313: invokestatic 159	dmt:b	()V
    //   316: aload 5
    //   318: athrow
    //   319: astore 5
    //   321: goto -129 -> 192
    //   324: iload_3
    //   325: iconst_1
    //   326: iadd
    //   327: istore_3
    //   328: goto -251 -> 77
    //   331: astore 5
    //   333: goto -141 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	GmailIntentService
    //   0	336	1	paramBoolean1	boolean
    //   0	336	2	paramBoolean2	boolean
    //   1	327	3	i	int
    //   75	6	4	j	int
    //   23	98	5	localObject1	Object
    //   190	60	5	localOperationCanceledException	android.accounts.OperationCanceledException
    //   307	10	5	localObject2	Object
    //   319	1	5	localAuthenticatorException	android.accounts.AuthenticatorException
    //   331	1	5	localIOException	IOException
    //   70	168	6	localObject3	Object
    //   35	257	7	localObject4	Object
    //   87	195	8	localdrp	drp
    // Exception table:
    //   from	to	target	type
    //   25	37	190	android/accounts/OperationCanceledException
    //   41	77	190	android/accounts/OperationCanceledException
    //   89	115	190	android/accounts/OperationCanceledException
    //   118	153	190	android/accounts/OperationCanceledException
    //   153	187	190	android/accounts/OperationCanceledException
    //   218	227	190	android/accounts/OperationCanceledException
    //   227	281	190	android/accounts/OperationCanceledException
    //   281	287	190	android/accounts/OperationCanceledException
    //   290	297	190	android/accounts/OperationCanceledException
    //   25	37	307	finally
    //   41	77	307	finally
    //   89	115	307	finally
    //   118	153	307	finally
    //   153	187	307	finally
    //   192	206	307	finally
    //   218	227	307	finally
    //   227	281	307	finally
    //   281	287	307	finally
    //   290	297	307	finally
    //   25	37	319	android/accounts/AuthenticatorException
    //   41	77	319	android/accounts/AuthenticatorException
    //   89	115	319	android/accounts/AuthenticatorException
    //   118	153	319	android/accounts/AuthenticatorException
    //   153	187	319	android/accounts/AuthenticatorException
    //   218	227	319	android/accounts/AuthenticatorException
    //   227	281	319	android/accounts/AuthenticatorException
    //   281	287	319	android/accounts/AuthenticatorException
    //   290	297	319	android/accounts/AuthenticatorException
    //   25	37	331	java/io/IOException
    //   41	77	331	java/io/IOException
    //   89	115	331	java/io/IOException
    //   118	153	331	java/io/IOException
    //   153	187	331	java/io/IOException
    //   218	227	331	java/io/IOException
    //   227	281	331	java/io/IOException
    //   281	287	331	java/io/IOException
    //   290	297	331	java/io/IOException
  }
  
  private final void a(android.accounts.Account[] paramArrayOfAccount, boolean paramBoolean)
  {
    dfh.a(this, paramArrayOfAccount);
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      int j = paramArrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        drp.b(this, name).a(true);
        i += 1;
      }
    }
  }
  
  private final void b()
  {
    Intent localIntent = new Intent("com.android.mail.ACTION_NOTIFY_DATASET_CHANGED");
    localIntent.putExtra("update-all-widgets", true);
    localIntent.setType("application/gmail-ls");
    sendBroadcast(localIntent);
  }
  
  private final void c()
  {
    if (!dkn.a()) {
      return;
    }
    AccountManager localAccountManager = AccountManager.get(this);
    android.accounts.Account[] arrayOfAccount2 = localAccountManager.getAccountsByType(getString(dge.b));
    int j = arrayOfAccount2.length;
    int i = 0;
    for (;;)
    {
      String str1;
      dkm localdkm;
      long l1;
      long l2;
      long l3;
      if (i < j)
      {
        str1 = name;
        dri.b("GmailIS", "Gmailify: Maybe check availability of %s", new Object[] { dri.a(str1) });
        localdkm = new dkm(this, str1);
        l1 = chq.a();
        l2 = d.getLong(b.getString(dge.cx), 0L);
        l3 = ghz.a(getContentResolver(), "gmail_g6y_availability_status_cache_duration", 86400000L);
        if ((l2 != 0L) && (l1 <= l2 + l3)) {}
      }
      try
      {
        dri.a("GmailIS", "Gmailify: Starting CheckAvailability of %s", new Object[] { str1 });
        dkp.a();
        Object localObject = dkq.a(this);
        cvm.b(dkp.a, "Gmailify: Performing checkAvailability request for %s", new Object[] { cvm.a(str1) });
        String str2 = ghz.a(b, "gmail_g6y_check_availability", "mail/gmailify/availability");
        hkw localhkw = new hkw();
        b = cui.b(str1);
        c = str1.hashCode();
        a |= 0x1;
        android.accounts.Account[] arrayOfAccount3 = c.a(new String[0]);
        if ((arrayOfAccount3 != null) && (arrayOfAccount3.length > 0))
        {
          localObject = hjy.a(AndroidHttpClient.getUngzippedContent(((dkp)localObject).a(str2, localhkw, arrayOfAccount3[0])));
          localObject = (hkx)hlt.a(new hkx(), (byte[])localObject, localObject.length);
          dri.b("GmailIS", "Gmailify CheckAvailability. ThirdParty email: %s", new Object[] { dri.a(str1) });
          dri.a("Gmailify response:\n%s", ((hkx)localObject).toString(), new Object[0]);
          localdkm.a(a, b);
          e.putLong(b.getString(dge.cx), l1).apply();
        }
        else
        {
          throw new dsj("Some Google account is required to authenticate");
        }
      }
      catch (IOException localIOException)
      {
        dri.d("GmailIS", localIOException, "Error while checking Gmailify availability", new Object[0]);
        break label522;
        dri.b("GmailIS", "Gmailify availability is still valid. Last check: %1$tF %1$tT, cache duration=%2$dms", new Object[] { new Date(l2), Long.valueOf(l3) });
        break label522;
        android.accounts.Account[] arrayOfAccount1 = localAccountManager.getAccountsByType(getString(dge.c));
        j = arrayOfAccount1.length;
        i = 0;
        while (i < j)
        {
          new dkm(this, name).a(false, false);
          i += 1;
        }
      }
      catch (dsj localdsj)
      {
        for (;;) {}
      }
      catch (dkr localdkr)
      {
        for (;;) {}
        label522:
        i += 1;
      }
    }
  }
  
  public final cfb a()
  {
    return new dnb();
  }
  
  public final void a(com.android.mail.providers.Account paramAccount)
  {
    dev localdev = (dev)getApplication();
    dmr localdmr = f;
    if (cxf.a(localdev, paramAccount)) {
      localdmr.a(new gnr(hli.c), 21, c);
    }
  }
  
  public final void a(com.android.mail.providers.Account paramAccount, long paramLong, String paramString)
  {
    Object localObject = (dev)getApplication();
    dmo localdmo = e;
    if ((cxf.a((Context)localObject, paramAccount)) && (!localdmo.a()))
    {
      paramAccount = new hkn();
      localObject = new hkm();
      hkr localhkr = new hkr();
      String str = String.valueOf(paramLong);
      if (str == null) {
        throw new NullPointerException();
      }
      b = str;
      a |= 0x1;
      if (paramString == null) {
        throw new NullPointerException();
      }
      c = paramString;
      a |= 0x2;
      a = localhkr;
      a = ((hkm)localObject);
      b = c;
      localdmo.a(paramAccount, null);
      dri.b(dmo.a, "ClearcutApiHelper: Successfully sent notification event", new Object[0]);
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    long l;
    do
    {
      Object localObject2;
      Object localObject3;
      String str2;
      do
      {
        do
        {
          return;
          super.onHandleIntent(paramIntent);
          try
          {
            String str1 = paramIntent.getAction();
            dri.a("GmailIS", "Handling %s // %s", new Object[] { str1, paramIntent });
            i = -1;
            switch (str1.hashCode())
            {
            case 798292259: 
              a(true, false);
              dfh.f(this);
              return;
            }
          }
          catch (SQLException localSQLException)
          {
            dri.e("GmailIS", localSQLException, "Error handling intent %s", new Object[] { paramIntent });
            return;
          }
          if (!localSQLException.equals("android.intent.action.BOOT_COMPLETED")) {
            break;
          }
          i = 0;
          break;
          if (!localSQLException.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            break;
          }
          i = 1;
          break;
          if (!localSQLException.equals("android.intent.action.MY_PACKAGE_REPLACED")) {
            break;
          }
          i = 2;
          break;
          if (!localSQLException.equals("android.intent.action.DOWNLOAD_COMPLETE")) {
            break;
          }
          i = 3;
          break;
          if (!localSQLException.equals("com.google.android.gm.intent.CLEAR_ALL_NEW_MAIL_NOTIFICATIONS")) {
            break;
          }
          i = 4;
          break;
          if (!localSQLException.equals("com.android.mail.action.update_notification")) {
            break;
          }
          i = 5;
          break;
          if (!localSQLException.equals("android.accounts.LOGIN_ACCOUNTS_CHANGED")) {
            break;
          }
          i = 6;
          break;
          if (!localSQLException.equals("com.google.android.gm.intent.VALIDATE_ACCOUNT_NOTIFICATIONS")) {
            break;
          }
          i = 7;
          break;
          if (!localSQLException.equals("com.google.android.gm.intent.ACTION_POST_SEND_ERROR")) {
            break;
          }
          i = 8;
          break;
          if (!localSQLException.equals("com.google.android.gm.intent.ACTION_POST_SAVE_ERROR")) {
            break;
          }
          i = 9;
          break;
          if (!localSQLException.equals("com.google.android.gm.intent.ACTION_PROVIDER_CREATED")) {
            break;
          }
          i = 10;
          break;
          if (!localSQLException.equals("com.google.android.gm.intent.ACTION_UPGRADE_SYNC_WINDOW")) {
            break;
          }
          i = 11;
          break;
          if (!localSQLException.equals("com.android.mail.action.BACKUP_DATA_CHANGED")) {
            break;
          }
          i = 12;
          break;
          if (!localSQLException.equals("com.google.android.gm.gmailify.intent.UPDATE_AVAILABILITY")) {
            break;
          }
          i = 13;
          break;
          localObject1 = Long.valueOf(paramIntent.getLongExtra("extra_download_id", -1L));
          l = ((Long)localObject1).longValue();
          localObject2 = (String)dpa.g.remove(Long.valueOf(l));
          if (localObject2 == null)
          {
            dri.b("GmailIS", "DownloadManager account = null for download %d ", new Object[] { localObject1 });
            ((DownloadManager)getSystemService("download")).remove(new long[] { ((Long)localObject1).longValue() });
            return;
          }
          localObject1 = drp.b(this, (String)localObject2);
          ((drp)localObject1).a(new dfg(this, (drp)localObject1, paramIntent));
          return;
          cvz.a(this);
          return;
          localObject1 = paramIntent.getExtras().getString("account");
          localObject3 = drp.b(this, (String)localObject1);
          localObject2 = GmailProvider.a(this, (String)localObject1);
        } while (!dnm.a(this, (String)localObject1).b());
        str2 = paramIntent.getExtras().getString("notificationLabel");
        if (!((drp)localObject3).e(str2))
        {
          dri.e("GmailIS", "Tried to notify for a hidden label", new Object[0]);
          dri.b("GmailIS", "    %s / %s", new Object[] { localObject1, str2 });
          dmv.a();
          dmv.c(this, (String)localObject1, str2);
          return;
        }
        localObject3 = dfh.c(this, (String)localObject1, str2);
      } while (!new dnn(this, (String)localObject1, (Folder)localObject3, dmv.f(this, (String)localObject1).equals(str2)).a());
      cvz.a(this, paramIntent.getIntExtra("count", 0), paramIntent.getIntExtra("unseenCount", 0), (com.android.mail.providers.Account)localObject2, (Folder)localObject3, paramIntent.getBooleanExtra("getAttention", false), new dnb(), this);
      return;
      dri.c("GmailIS", "Receive LOGIN_ACCOUNTS_CHANGED intent: %s", new Object[] { paramIntent });
      dfh.d(this);
      a(false, true);
      dkn.a(getApplicationContext(), true);
      b();
      return;
      cvz.a(this, GmailProvider.a(this, paramIntent.getStringExtra("account")));
      return;
      a(paramIntent, dge.ez);
      return;
      a(paramIntent, dge.ey);
      return;
      b();
      return;
      localObject1 = bgetStringExtra"account"m;
      l = dpy.a(this);
    } while (((dtn)localObject1).a("conversationAgeDays") >= l);
    Object localObject1 = dmv.a();
    if (!((dmv)localObject1).b(this, null, "show-sync-window-upgrade")) {
      ((dmv)localObject1).a(this, null, "show-sync-window-upgrade", Boolean.valueOf(true));
    }
    sendBroadcast(new Intent("com.google.android.gm.intent.ACTION_DISPLAY_SYNC_WINDOW_UPGRADE"));
    return;
    GmailBackupAgent.a("Broadcast - preferences");
    return;
    c();
    return;
    switch (i)
    {
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.GmailIntentService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */