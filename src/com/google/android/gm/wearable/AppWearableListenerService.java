package com.google.android.gm.wearable;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import buo;
import but;
import bwg;
import byw;
import cbk;
import cci;
import cfm;
import cfw;
import cgr;
import chh;
import chq;
import com.android.mail.browse.ConversationMessage;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.FolderList;
import com.android.mail.providers.Message;
import com.android.mail.providers.Settings;
import com.google.android.gm.GmailIntentService;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import cus;
import cvn;
import cxa;
import dfh;
import dge;
import dri;
import dzf;
import dzg;
import dzj;
import dzl;
import dzm;
import dzn;
import dzo;
import dzq;
import dzr;
import dzs;
import dzt;
import dzu;
import dzv;
import dzw;
import dzy;
import dzz;
import eaa;
import eab;
import eac;
import eiz;
import eja;
import ejh;
import frm;
import fro;
import frp;
import gdn;
import gdo;
import gdq;
import gdr;
import gds;
import gdt;
import gdv;
import gdy;
import ged;
import geh;
import hbc;
import hlt;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import oi;

public class AppWearableListenerService
  extends geh
{
  static cvn<String, Bitmap> a;
  static ExecutorService b;
  private static final ExecutorService g = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
  
  private static com.android.mail.providers.Account a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getContentResolver().query(cgr.b(), chh.c, null, null, null);
    if (paramContext == null)
    {
      dri.d("GmailWear", "Account cursor is null", new Object[0]);
      return null;
    }
    dri.a("GmailWear", "Default email is %s", new Object[] { dri.a(paramString) });
    try
    {
      while (paramContext.moveToNext())
      {
        com.android.mail.providers.Account.b();
        com.android.mail.providers.Account localAccount = cfw.a(paramContext);
        boolean bool = paramString.equals(localAccount.h());
        if (bool) {
          return localAccount;
        }
      }
      return null;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  private static Folder a(Context paramContext, Uri paramUri)
  {
    paramContext = paramContext.getContentResolver().query(paramUri, chh.i, null, null, null);
    if (paramContext == null)
    {
      dri.d("GmailWear", "Default inbox cursor is null", new Object[0]);
      return null;
    }
    try
    {
      if (paramContext.moveToNext())
      {
        paramUri = new Folder(paramContext);
        return paramUri;
      }
      return null;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  private static Folder a(Context paramContext, com.android.mail.providers.Account paramAccount)
  {
    dri.a("GmailWear", "Getting first folder", new Object[0]);
    paramContext = paramContext.getContentResolver().query(i, chh.i, null, null, null);
    if (paramContext == null)
    {
      dri.d("GmailWear", "Folder list cursor is null", new Object[0]);
      return null;
    }
    try
    {
      while (paramContext.moveToNext())
      {
        paramAccount = new Folder(paramContext);
        boolean bool = paramAccount.d(8192);
        if (!bool) {
          return paramAccount;
        }
      }
      return null;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  private static Folder a(Context paramContext, com.android.mail.providers.Account paramAccount, String paramString)
  {
    dri.a("GmailWear", "Get folder for %s", new Object[] { dri.c(paramString) });
    paramContext = paramContext.getContentResolver().query(i, chh.i, null, null, null);
    if (paramContext == null)
    {
      dri.d("GmailWear", "Folder list cursor is null", new Object[0]);
      return null;
    }
    try
    {
      while (paramContext.moveToNext())
      {
        paramAccount = new Folder(paramContext);
        boolean bool = paramString.equals(b);
        if (bool) {
          return paramAccount;
        }
      }
      return null;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public static Asset a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return Asset.a(localByteArrayOutputStream.toByteArray());
  }
  
  private static dzm a(eiz parameiz)
  {
    parameiz = (gdv)ged.a.a(parameiz, eac.a("/accounts"), 0).a(eab.c, eab.d);
    try
    {
      if ((b.b()) && (parameiz.c() > 0))
      {
        dzm localdzm = eac.a(((gdt)parameiz.a(0)).c());
        return localdzm;
      }
      return null;
    }
    finally
    {
      parameiz.b();
    }
  }
  
  private static dzt a(eiz parameiz, com.android.mail.providers.Account paramAccount)
  {
    paramAccount = eac.a(eac.b(paramAccount.h()));
    parameiz = (gdv)ged.a.a(parameiz, paramAccount).a(eab.c, eab.d);
    try
    {
      if (b.b())
      {
        int i = parameiz.c();
        if (i == 0) {
          return null;
        }
        if (parameiz.c() > 1) {
          dri.d("GmailWear", "Expects only 1 selected folder but returns %d", new Object[] { Integer.valueOf(parameiz.c()) });
        }
        paramAccount = eac.b(((gdt)parameiz.a(0)).c());
        return paramAccount;
      }
      dri.d("GmailWear", "Failed to get selected folder data items", new Object[0]);
      return null;
    }
    finally
    {
      parameiz.b();
    }
  }
  
  private static eiz a(Context paramContext)
  {
    fro localfro = new frp().a().b();
    return new eja(paramContext).a(ged.l).a(frm.c, localfro).a();
  }
  
  private final List<com.android.mail.providers.Account> a()
  {
    Cursor localCursor = getContentResolver().query(cgr.b(), chh.c, null, null, null);
    if (localCursor == null)
    {
      dri.d("GmailWear", "Account cursor is null", new Object[0]);
      return null;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      while (localCursor.moveToNext())
      {
        com.android.mail.providers.Account.b();
        localArrayList.add(cfw.a(localCursor));
      }
    }
    finally
    {
      localCursor.close();
    }
    return localList;
  }
  
  private static List<Conversation> a(Context paramContext, Folder paramFolder, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (int i = 1;; i = 0)
    {
      paramFolder = h.buildUpon();
      if (i == 0) {
        paramFolder.appendQueryParameter("limit", "25");
      }
      paramFolder = paramFolder.appendQueryParameter("use_network", Boolean.FALSE.toString()).build();
      paramContext = paramContext.getContentResolver().query(paramFolder, chh.k, null, null, null);
      if (paramContext != null) {
        break;
      }
      dri.d("GmailWear", "Conversation cursor is null", new Object[0]);
      return null;
    }
    for (;;)
    {
      Conversation localConversation;
      try
      {
        paramFolder = new ArrayList(25);
        int k = 0;
        int j;
        if (paramContext.moveToNext())
        {
          j = k;
          if (i == 0)
          {
            k += 1;
            j = k;
            if (k > 25) {
              dri.d("GmailWear", "Cursor returns %d conversations", new Object[] { Integer.valueOf(paramContext.getCount()) });
            }
          }
        }
        else
        {
          return paramFolder;
        }
        localConversation = new Conversation(paramContext);
        if (i == 0)
        {
          paramFolder.add(localConversation);
          k = j;
          continue;
        }
        k = j;
      }
      finally
      {
        paramContext.close();
      }
      if (paramString.equals(c.toString())) {
        paramFolder.add(localConversation);
      }
    }
  }
  
  private static Set<Uri> a(eiz parameiz, String paramString)
  {
    Uri localUri = eac.a(eac.c(paramString));
    paramString = new HashSet();
    parameiz = (gdv)ged.a.a(parameiz, localUri, 1).a(eab.c, eab.d);
    try
    {
      if (b.b())
      {
        int j = parameiz.c();
        int i = 0;
        while (i < j)
        {
          paramString.add(((gdt)parameiz.a(i)).b());
          i += 1;
        }
      }
      dri.d("GmailWear", "Failed to get conversation data items", new Object[0]);
      return paramString;
    }
    finally
    {
      parameiz.b();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    dri.a("GmailWear", "Refresh gmail data item,accountId=%s", new Object[] { dri.a(paramString1) });
    com.android.mail.providers.Account localAccount = a(paramContext, paramString1);
    if (localAccount == null)
    {
      dri.d("GmailWear", "Not creating data items because user has no account, accountId=%s", new Object[] { dri.a(paramString1) });
      return;
    }
    dri.a("GmailWear", "Default account=%s", new Object[] { dri.a(localAccount.h()) });
    if (!cxa.b(z.i)) {}
    for (Folder localFolder = a(paramContext, z.i); localFolder == null; localFolder = a(paramContext, localAccount))
    {
      dri.d("GmailWear", "Not creating data items because user has no folder: accountId=%s", new Object[] { dri.a(paramString1) });
      return;
    }
    dri.a("GmailWear", "Folder=%s", new Object[] { dri.c(d) });
    Object localObject2 = a(paramContext, localFolder, paramString2);
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      dri.d("GmailWear", "Not creating data items because there is no conversations", new Object[0]);
    }
    eiz localeiz = a(paramContext);
    localeiz.a(eab.c, eab.d);
    if (!localeiz.e())
    {
      dri.d("GmailWear", "Failed to connect to Google API client", new Object[0]);
      return;
    }
    int i;
    Set localSet;
    CountDownLatch localCountDownLatch;
    Object localObject3;
    for (;;)
    {
      try
      {
        paramString1 = PutDataRequest.a("/preferences");
        localObject1 = new dzy();
        boolean bool = localAccount.a(4L);
        b = bool;
        if ("archive".equals(cfm.a(paramContext).a(bool)))
        {
          i = 1;
          a = i;
          c = cfm.a(paramContext).d();
          d = dzy.a((hlt)localObject1);
          a((gdo)ged.a.a(localeiz, paramString1).a(eab.c, eab.d));
          if (localObject2 == null) {
            break label1196;
          }
          localSet = a(localeiz, localAccount.h());
          String str1 = c;
          String str2 = paramContext.getString(dge.en);
          String str3 = cname;
          if (a != null) {
            break label534;
          }
          paramString1 = new cvn(50);
          localCountDownLatch = new CountDownLatch(((List)localObject2).size());
          localObject3 = new HashSet();
          if (b != null) {
            break label541;
          }
          localObject1 = g;
          Iterator localIterator = ((List)localObject2).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          ((ExecutorService)localObject1).execute(new dzf(paramContext, localAccount, (Conversation)localIterator.next(), str1, str2, localFolder, paramString1, str3, localeiz, (Set)localObject3, localCountDownLatch));
          continue;
        }
        i = 2;
      }
      finally
      {
        localeiz.d();
      }
      continue;
      label534:
      paramString1 = a;
      continue;
      label541:
      localObject1 = b;
    }
    try
    {
      localCountDownLatch.await(30L, TimeUnit.SECONDS);
      paramString1 = localSet.iterator();
      for (;;)
      {
        if (!paramString1.hasNext()) {
          break label1196;
        }
        localObject1 = (Uri)paramString1.next();
        try
        {
          if (!((Set)localObject3).contains(((Uri)localObject1).getPath())) {
            a((gdq)ged.a.b(localeiz, (Uri)localObject1).a(eab.c, eab.d));
          }
        }
        finally {}
      }
      paramString1 = PutDataRequest.a(eac.b(localAccount.h()));
    }
    catch (InterruptedException paramString1)
    {
      dri.d("GmailWear", "Put conversation data item interrupted", new Object[0]);
    }
    label666:
    Object localObject1 = new dzt();
    a = b;
    b = dzj.a(d);
    c = q;
    d = i;
    localObject2 = a(localeiz, localAccount);
    if (localObject2 != null)
    {
      if ((!hbc.a(a, a)) || (!hbc.a(b, b)) || (c != c)) {
        break label1218;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        dri.a("GmailWear", "Selected folder is not changed", new Object[0]);
        paramString1 = PutDataRequest.a("/timestamp");
        long l = chq.a();
        d = ByteBuffer.allocate(8).putLong(l).array();
        a((gdo)ged.a.a(localeiz, paramString1).a(eab.c, eab.d));
        localeiz.d();
        localObject1 = buo.a();
        if (!TextUtils.isEmpty(paramString2)) {
          break label1189;
        }
        paramString1 = null;
        label889:
        ((but)localObject1).a("wear", "refresh_data", paramString1, 0L);
        if (!paramBoolean) {
          break;
        }
        paramString1 = new Intent(paramContext, GmailIntentService.class);
        paramString1.setAction("com.android.mail.action.CLEAR_NEW_MAIL_NOTIFICATIONS");
        paramString1.setPackage(paramContext.getPackageName());
        paramString1.setData(cxa.a(paramContext, c.b));
        paramString1.putExtra("mail_account", localAccount);
        paramString1.putExtra("folder", localFolder);
        paramContext.startService(paramString1);
        buo.a().a("wear", "clear_notification", "folder", 0L);
        return;
      }
      label1162:
      label1189:
      label1196:
      do
      {
        i = ((List)localObject2).size();
        break;
        d = dzt.a((hlt)localObject1);
        if (q != 0)
        {
          localObject1 = paramContext.getResources().getDrawable(q);
          if (localObject1 == null) {
            break label1162;
          }
          ((Drawable)localObject1).mutate().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
          localObject2 = Bitmap.createBitmap(((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
          localObject3 = new Canvas((Bitmap)localObject2);
          ((Drawable)localObject1).setBounds(0, 0, ((Canvas)localObject3).getWidth(), ((Canvas)localObject3).getHeight());
          ((Drawable)localObject1).draw((Canvas)localObject3);
          paramString1.a(String.valueOf(q), a((Bitmap)localObject2));
        }
        for (;;)
        {
          a((gdo)ged.a.a(localeiz, paramString1).a(eab.c, eab.d));
          break;
          dri.d("GmailWear", "Failed to get icon drawable for %s", new Object[] { dri.c(d) });
        }
        paramString1 = "conversation";
        break label889;
      } while (localObject2 != null);
      i = 0;
      break label666;
      for (;;)
      {
        if (i != 0) {
          break label1224;
        }
        i = 1;
        break;
        label1218:
        i = 0;
      }
      label1224:
      i = 0;
    }
  }
  
  public static void a(PutDataRequest paramPutDataRequest, dzr paramdzr)
  {
    int j = 0;
    d = dzr.a(paramdzr);
    Object localObject = d;
    if (localObject != null) {}
    for (int i = localObject.length + 0;; i = 0)
    {
      localObject = paramPutDataRequest.a().keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        i = ((String)((Iterator)localObject).next()).length() + i;
      }
      if (b.toString().length() + i > 102400) {}
      for (i = 1; (i == 0) || (j >= j.length); i = 0) {
        return;
      }
      j[j] = null;
      j += 1;
      break;
    }
  }
  
  private final void a(dzo paramdzo)
  {
    dri.a("GmailWear", "Archive conversation=%s", new Object[] { paramdzo });
    Object localObject = dfh.c(this, a, b);
    if (localObject == null)
    {
      dri.e("GmailWear", "Can't archive conversation, folder is null: req=%s", new Object[] { paramdzo });
      return;
    }
    localObject = new bwg(this, h, false, AppWearableListenerService.class.getSimpleName());
    for (;;)
    {
      try
      {
        ((bwg)localObject).c();
        if (!((bwg)localObject).moveToNext()) {
          break label371;
        }
        Conversation localConversation = new Conversation((Cursor)localObject);
        if (b != c) {
          continue;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localConversation);
        ((bwg)localObject).a(localArrayList);
        i = 1;
      }
      catch (Exception localException)
      {
        dri.e("GmailWear", localException, "Error when archiving a conversation, req=%s,%s,%s", new Object[] { dri.a(a), dri.c(b), Long.valueOf(c) });
        ((bwg)localObject).close();
        i = 0;
        continue;
      }
      finally
      {
        ((bwg)localObject).close();
      }
      if (i != 0)
      {
        localObject = a(this);
        ((eiz)localObject).a(eab.c, eab.d);
        if (!((eiz)localObject).e())
        {
          dri.d("GmailWear", "Failed to connect to Google API client", new Object[0]);
          return;
        }
      }
      for (;;)
      {
        try
        {
          paramdzo = eac.a(a, b, c);
          a((gdq)ged.a.b((eiz)localObject, eac.a(paramdzo)).a(eab.c, eab.d));
          ((eiz)localObject).d();
          buo.a().a("wear", "archive", null, 0L);
          return;
        }
        finally
        {
          ((eiz)localObject).d();
        }
        dri.d("GmailWear", "Can't find the conversation to archive: req=%s,%s,%s", new Object[] { dri.a(a), dri.c(b), Long.valueOf(c) });
      }
      label371:
      int i = 0;
    }
  }
  
  private final void a(dzw paramdzw)
  {
    dri.a("GmailWear", "Open conversation=%s", new Object[] { paramdzw });
    Object localObject = a(this, a);
    if (localObject == null)
    {
      dri.d("GmailWear", "Can't open conversation, account is null: req=%s", new Object[] { dri.a(a) });
      return;
    }
    Folder localFolder = a(this, (com.android.mail.providers.Account)localObject, b);
    if (localFolder == null)
    {
      dri.d("GmailWear", "Can't open conversation, folder is null", new Object[0]);
      return;
    }
    localbwg = new bwg(this, h, false, AppWearableListenerService.class.getSimpleName());
    try
    {
      localbwg.c();
      while (localbwg.moveToNext())
      {
        Conversation localConversation = new Conversation(localbwg);
        if (b == c)
        {
          localObject = cxa.a(this, localConversation, c.b, (com.android.mail.providers.Account)localObject);
          dri.a("GmailWear", "Opening conversation: intent=%s", new Object[] { localObject });
          startActivity((Intent)localObject);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        dri.d("GmailWear", localException, "Error when opening a conversation, req=%s,%s,%s", new Object[] { dri.a(a), dri.c(b), Long.valueOf(c) });
        localbwg.close();
      }
    }
    finally
    {
      localbwg.close();
    }
    buo.a().a("wear", "open_on_phone", null, 0L);
  }
  
  public static void a(gdo paramgdo)
  {
    if (paramgdo.a().b())
    {
      dri.a("GmailWear", "Created data item for %s", new Object[] { paramgdo.b().b() });
      return;
    }
    Object localObject = paramgdo.b();
    if (localObject == null) {}
    for (localObject = "null";; localObject = ((gdt)localObject).b())
    {
      dri.e("GmailWear", "Failed to put data item=%s,%s", new Object[] { localObject, ah });
      return;
    }
  }
  
  private static void a(gdq paramgdq)
  {
    if (paramgdq.a().b())
    {
      dri.a("GmailWear", "Deleted %d data items", new Object[] { Integer.valueOf(paramgdq.b()) });
      return;
    }
    dri.d("GmailWear", "Failed to delete data item=%s", new Object[] { ah });
  }
  
  /* Error */
  private final dzl[] a(eiz parameiz, PutDataRequest paramPutDataRequest, List<com.android.mail.providers.Account> paramList)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokeinterface 479 1 0
    //   6: anewarray 845	dzl
    //   9: astore 7
    //   11: aload_3
    //   12: invokeinterface 479 1 0
    //   17: istore 6
    //   19: iconst_0
    //   20: istore 5
    //   22: iload 5
    //   24: iload 6
    //   26: if_icmpge +147 -> 173
    //   29: aload_3
    //   30: iload 5
    //   32: invokeinterface 848 2 0
    //   37: checkcast 85	com/android/mail/providers/Account
    //   40: astore 8
    //   42: new 845	dzl
    //   45: dup
    //   46: invokespecial 849	dzl:<init>	()V
    //   49: astore 9
    //   51: aload 9
    //   53: aload 8
    //   55: invokevirtual 97	com/android/mail/providers/Account:h	()Ljava/lang/String;
    //   58: putfield 850	dzl:a	Ljava/lang/String;
    //   61: aload 9
    //   63: aload 8
    //   65: getfield 452	com/android/mail/providers/Account:c	Ljava/lang/String;
    //   68: putfield 851	dzl:b	Ljava/lang/String;
    //   71: aload 9
    //   73: aload 8
    //   75: getfield 852	com/android/mail/providers/Account:b	Ljava/lang/String;
    //   78: invokestatic 543	dzj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   81: putfield 853	dzl:c	Ljava/lang/String;
    //   84: aload 8
    //   86: invokevirtual 854	com/android/mail/providers/Account:e	()Z
    //   89: ifeq +29 -> 118
    //   92: iconst_3
    //   93: istore 4
    //   95: aload 9
    //   97: iload 4
    //   99: putfield 855	dzl:d	I
    //   102: aload 7
    //   104: iload 5
    //   106: aload 9
    //   108: aastore
    //   109: iload 5
    //   111: iconst_1
    //   112: iadd
    //   113: istore 5
    //   115: goto -93 -> 22
    //   118: invokestatic 858	android/content/ContentResolver:getMasterSyncAutomatically	()Z
    //   121: ifne +9 -> 130
    //   124: iconst_1
    //   125: istore 4
    //   127: goto -32 -> 95
    //   130: aload 8
    //   132: invokevirtual 464	com/android/mail/providers/Account:c	()Landroid/accounts/Account;
    //   135: astore 10
    //   137: aload 8
    //   139: getfield 861	com/android/mail/providers/Account:G	Ljava/lang/String;
    //   142: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifne +22 -> 167
    //   148: aload 10
    //   150: aload 8
    //   152: getfield 861	com/android/mail/providers/Account:G	Ljava/lang/String;
    //   155: invokestatic 865	android/content/ContentResolver:getSyncAutomatically	(Landroid/accounts/Account;Ljava/lang/String;)Z
    //   158: ifne +9 -> 167
    //   161: iconst_2
    //   162: istore 4
    //   164: goto -69 -> 95
    //   167: iconst_0
    //   168: istore 4
    //   170: goto -75 -> 95
    //   173: getstatic 868	frm:e	Lfra;
    //   176: astore 8
    //   178: new 870	frb
    //   181: dup
    //   182: invokespecial 871	frb:<init>	()V
    //   185: astore 9
    //   187: aload 9
    //   189: iconst_0
    //   190: putfield 872	frb:b	Z
    //   193: aload 8
    //   195: aload_1
    //   196: aload 9
    //   198: invokeinterface 877 3 0
    //   203: getstatic 184	eab:c	I
    //   206: i2l
    //   207: getstatic 187	eab:d	Ljava/util/concurrent/TimeUnit;
    //   210: invokeinterface 192 4 0
    //   215: checkcast 879	frc
    //   218: astore 8
    //   220: aload 8
    //   222: invokeinterface 880 1 0
    //   227: invokevirtual 201	com/google/android/gms/common/api/Status:b	()Z
    //   230: ifeq +370 -> 600
    //   233: aload 8
    //   235: invokeinterface 883 1 0
    //   240: astore 9
    //   242: new 885	oi
    //   245: dup
    //   246: invokespecial 886	oi:<init>	()V
    //   249: astore 8
    //   251: iconst_0
    //   252: istore 4
    //   254: aload 9
    //   256: invokevirtual 889	fyc:c	()I
    //   259: istore 5
    //   261: iload 4
    //   263: iload 5
    //   265: if_icmpge +36 -> 301
    //   268: aload 9
    //   270: iload 4
    //   272: invokevirtual 892	fyc:b	(I)Lfyb;
    //   275: astore 10
    //   277: aload 8
    //   279: aload 10
    //   281: invokeinterface 896 1 0
    //   286: aload 10
    //   288: invokevirtual 900	oi:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   291: pop
    //   292: iload 4
    //   294: iconst_1
    //   295: iadd
    //   296: istore 4
    //   298: goto -37 -> 261
    //   301: aload_3
    //   302: invokeinterface 479 1 0
    //   307: istore 6
    //   309: iconst_0
    //   310: istore 4
    //   312: iload 4
    //   314: iload 6
    //   316: if_icmpge +307 -> 623
    //   319: aload_3
    //   320: iload 4
    //   322: invokeinterface 848 2 0
    //   327: checkcast 85	com/android/mail/providers/Account
    //   330: astore 9
    //   332: aload 8
    //   334: aload 9
    //   336: getfield 452	com/android/mail/providers/Account:c	Ljava/lang/String;
    //   339: invokevirtual 903	oi:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   342: checkcast 894	fyb
    //   345: astore 10
    //   347: aload 10
    //   349: ifnull +138 -> 487
    //   352: aload 7
    //   354: iload 4
    //   356: aaload
    //   357: aload 10
    //   359: invokeinterface 905 1 0
    //   364: putfield 853	dzl:c	Ljava/lang/String;
    //   367: aload 10
    //   369: invokeinterface 907 1 0
    //   374: astore 10
    //   376: getstatic 910	frm:g	Lfre;
    //   379: astore 11
    //   381: aload 9
    //   383: getfield 452	com/android/mail/providers/Account:c	Ljava/lang/String;
    //   386: astore 12
    //   388: aload 10
    //   390: ifnonnull +106 -> 496
    //   393: iconst_1
    //   394: istore 5
    //   396: aload 11
    //   398: aload_1
    //   399: aload 12
    //   401: aload 10
    //   403: iconst_1
    //   404: iload 5
    //   406: invokeinterface 915 6 0
    //   411: getstatic 184	eab:c	I
    //   414: i2l
    //   415: getstatic 187	eab:d	Ljava/util/concurrent/TimeUnit;
    //   418: invokeinterface 192 4 0
    //   423: checkcast 917	frh
    //   426: astore 10
    //   428: aload 10
    //   430: invokeinterface 918 1 0
    //   435: invokevirtual 201	com/google/android/gms/common/api/Status:b	()Z
    //   438: ifeq +136 -> 574
    //   441: aload 10
    //   443: invokeinterface 921 1 0
    //   448: astore 10
    //   450: aload 10
    //   452: ifnull +35 -> 487
    //   455: aload 10
    //   457: invokestatic 926	frs:a	(Landroid/os/ParcelFileDescriptor;)Landroid/graphics/Bitmap;
    //   460: astore 11
    //   462: aload 11
    //   464: ifnull +38 -> 502
    //   467: aload_2
    //   468: aload 9
    //   470: getfield 452	com/android/mail/providers/Account:c	Ljava/lang/String;
    //   473: aload 11
    //   475: invokestatic 706	com/google/android/gm/wearable/AppWearableListenerService:a	(Landroid/graphics/Bitmap;)Lcom/google/android/gms/wearable/Asset;
    //   478: invokevirtual 709	com/google/android/gms/wearable/PutDataRequest:a	(Ljava/lang/String;Lcom/google/android/gms/wearable/Asset;)Lcom/google/android/gms/wearable/PutDataRequest;
    //   481: pop
    //   482: aload 10
    //   484: invokevirtual 929	android/os/ParcelFileDescriptor:close	()V
    //   487: iload 4
    //   489: iconst_1
    //   490: iadd
    //   491: istore 4
    //   493: goto -181 -> 312
    //   496: iconst_0
    //   497: istore 5
    //   499: goto -103 -> 396
    //   502: ldc 60
    //   504: ldc_w 931
    //   507: iconst_1
    //   508: anewarray 64	java/lang/Object
    //   511: dup
    //   512: iconst_0
    //   513: ldc 60
    //   515: aload 9
    //   517: getfield 452	com/android/mail/providers/Account:c	Ljava/lang/String;
    //   520: invokestatic 934	dri:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   523: aastore
    //   524: invokestatic 70	dri:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   527: pop
    //   528: goto -46 -> 482
    //   531: astore_1
    //   532: aload 10
    //   534: invokevirtual 929	android/os/ParcelFileDescriptor:close	()V
    //   537: aload_1
    //   538: athrow
    //   539: astore 9
    //   541: ldc 60
    //   543: ldc_w 936
    //   546: iconst_0
    //   547: anewarray 64	java/lang/Object
    //   550: invokestatic 70	dri:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   553: pop
    //   554: goto -67 -> 487
    //   557: astore_2
    //   558: ldc 60
    //   560: ldc_w 936
    //   563: iconst_0
    //   564: anewarray 64	java/lang/Object
    //   567: invokestatic 70	dri:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   570: pop
    //   571: goto -34 -> 537
    //   574: ldc 60
    //   576: ldc_w 938
    //   579: iconst_1
    //   580: anewarray 64	java/lang/Object
    //   583: dup
    //   584: iconst_0
    //   585: aload 10
    //   587: invokeinterface 918 1 0
    //   592: aastore
    //   593: invokestatic 70	dri:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   596: pop
    //   597: goto -110 -> 487
    //   600: ldc 60
    //   602: ldc_w 940
    //   605: iconst_1
    //   606: anewarray 64	java/lang/Object
    //   609: dup
    //   610: iconst_0
    //   611: aload 8
    //   613: invokeinterface 880 1 0
    //   618: aastore
    //   619: invokestatic 70	dri:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   622: pop
    //   623: aload_3
    //   624: invokeinterface 486 1 0
    //   629: astore_1
    //   630: aload_1
    //   631: invokeinterface 491 1 0
    //   636: ifeq +110 -> 746
    //   639: aload_1
    //   640: invokeinterface 497 1 0
    //   645: checkcast 85	com/android/mail/providers/Account
    //   648: astore_3
    //   649: aload_2
    //   650: aload_3
    //   651: getfield 452	com/android/mail/providers/Account:c	Ljava/lang/String;
    //   654: invokevirtual 943	com/google/android/gms/wearable/PutDataRequest:b	(Ljava/lang/String;)Lcom/google/android/gms/wearable/Asset;
    //   657: ifnonnull -27 -> 630
    //   660: aload_3
    //   661: getfield 452	com/android/mail/providers/Account:c	Ljava/lang/String;
    //   664: astore 8
    //   666: aload_0
    //   667: invokevirtual 944	com/google/android/gm/wearable/AppWearableListenerService:getResources	()Landroid/content/res/Resources;
    //   670: astore 9
    //   672: aload_2
    //   673: aload 8
    //   675: aload_3
    //   676: new 946	cff
    //   679: dup
    //   680: aload 9
    //   682: new 948	buz
    //   685: dup
    //   686: aload 9
    //   688: getstatic 952	dfs:b	I
    //   691: invokespecial 955	buz:<init>	(Landroid/content/res/Resources;I)V
    //   694: invokespecial 958	cff:<init>	(Landroid/content/res/Resources;Lbuy;)V
    //   697: new 946	cff
    //   700: dup
    //   701: aload 9
    //   703: new 960	bvh
    //   706: dup
    //   707: aload 9
    //   709: invokespecial 963	bvh:<init>	(Landroid/content/res/Resources;)V
    //   712: invokespecial 958	cff:<init>	(Landroid/content/res/Resources;Lbuy;)V
    //   715: aload 9
    //   717: getstatic 966	dfw:a	I
    //   720: invokevirtual 970	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   723: aload 9
    //   725: getstatic 973	dfw:m	I
    //   728: invokevirtual 970	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   731: i2f
    //   732: iconst_0
    //   733: invokestatic 978	dww:a	(Lcom/android/mail/providers/Account;Lcff;Lcff;IFZ)Landroid/graphics/Bitmap;
    //   736: invokestatic 706	com/google/android/gm/wearable/AppWearableListenerService:a	(Landroid/graphics/Bitmap;)Lcom/google/android/gms/wearable/Asset;
    //   739: invokevirtual 709	com/google/android/gms/wearable/PutDataRequest:a	(Ljava/lang/String;Lcom/google/android/gms/wearable/Asset;)Lcom/google/android/gms/wearable/PutDataRequest;
    //   742: pop
    //   743: goto -113 -> 630
    //   746: aload 7
    //   748: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	749	0	this	AppWearableListenerService
    //   0	749	1	parameiz	eiz
    //   0	749	2	paramPutDataRequest	PutDataRequest
    //   0	749	3	paramList	List<com.android.mail.providers.Account>
    //   93	399	4	i	int
    //   20	478	5	j	int
    //   17	300	6	k	int
    //   9	738	7	arrayOfdzl	dzl[]
    //   40	634	8	localObject1	Object
    //   49	467	9	localObject2	Object
    //   539	1	9	localIOException	java.io.IOException
    //   670	54	9	localResources	Resources
    //   135	451	10	localObject3	Object
    //   379	95	11	localObject4	Object
    //   386	14	12	str	String
    // Exception table:
    //   from	to	target	type
    //   455	462	531	finally
    //   467	482	531	finally
    //   502	528	531	finally
    //   482	487	539	java/io/IOException
    //   532	537	557	java/io/IOException
  }
  
  public static dzu[] a(Context paramContext, com.android.mail.providers.Account paramAccount, Conversation paramConversation)
  {
    paramConversation = g.buildUpon().appendQueryParameter("label", n.a.get(0)).b).build();
    paramContext = paramContext.getContentResolver().query(paramConversation, chh.n, null, null, null);
    if (paramContext == null)
    {
      dri.e("GmailWear", "Cannot retrieve messages. Cursor is null", new Object[0]);
      return null;
    }
    paramContext = new byw(paramContext);
    try
    {
      paramConversation = new ArrayList(paramContext.getCount());
      if (paramContext.moveToFirst())
      {
        Object localObject1 = c;
        ConversationMessage localConversationMessage;
        Object localObject2;
        do
        {
          localConversationMessage = paramContext.a();
          if (!localConversationMessage.p())
          {
            localObject2 = dzj.a(localConversationMessage, (String)localObject1);
            if (TextUtils.isEmpty(e))
            {
              e = dzj.a(c);
              d = dzj.a(b);
              String.format("Use account email as sender:%s,%s", new Object[] { c, b });
            }
            paramConversation.add(localObject2);
          }
        } while (paramContext.moveToNext());
        if (!paramConversation.isEmpty())
        {
          localObject1 = new LinkedHashSet();
          localObject2 = new LinkedHashSet();
          cci.a((Set)localObject1, (Set)localObject2, paramAccount, localConversationMessage);
          paramAccount = (dzu)paramConversation.get(paramConversation.size() - 1);
          j = ((String[])((Set)localObject1).toArray(new String[((Set)localObject1).size()]));
          k = ((String[])((Set)localObject2).toArray(new String[((Set)localObject2).size()]));
        }
      }
      paramAccount = (dzu[])paramConversation.toArray(new dzu[paramConversation.size()]);
      return paramAccount;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public final void a(gds paramgds)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    label300:
    for (;;)
    {
      try
      {
        Iterator localIterator = paramgds.iterator();
        paramgds = (gds)localObject2;
        localObject1 = paramgds;
        if (localIterator.hasNext())
        {
          localObject1 = paramgds;
          localObject2 = (gdr)localIterator.next();
          localObject1 = paramgds;
          int i = ((gdr)localObject2).c();
          localObject1 = paramgds;
          localgdt = ((gdr)localObject2).b();
          localObject1 = paramgds;
          localObject2 = localgdt.b().getPath();
          localObject1 = paramgds;
          dri.a("GmailWear", "onDataChanged,path=%s,eventType=%d", new Object[] { localObject2, Integer.valueOf(i) });
          localObject1 = paramgds;
          if ((!((String)localObject2).startsWith("/analytics_event")) || (i != 1)) {
            break label300;
          }
          localObject2 = paramgds;
          if (paramgds == null)
          {
            localObject1 = paramgds;
            paramgds = a(this);
            localObject1 = paramgds;
            paramgds.a(eab.c, eab.d);
            localObject2 = paramgds;
            localObject1 = paramgds;
            if (!paramgds.e())
            {
              localObject1 = paramgds;
              dri.d("GmailWear", "Failed to connect to Google API client", new Object[0]);
              if (paramgds != null) {
                paramgds.d();
              }
              return;
            }
          }
        }
      }
      finally
      {
        gdt localgdt;
        if (localObject1 != null) {
          ((eiz)localObject1).d();
        }
      }
      try
      {
        paramgds = eac.j(localgdt.c());
        if (paramgds != null) {
          buo.a().a("wear", a, b, c);
        }
        a((gdq)ged.a.b((eiz)localObject2, localgdt.b()).a(eab.c, eab.d));
        paramgds = (gds)localObject2;
        continue;
      }
      finally
      {
        localObject1 = localObject2;
        continue;
      }
      if (paramgds != null)
      {
        paramgds.d();
        return;
      }
    }
  }
  
  public final void a(gdy paramgdy)
  {
    dri.a("GmailWear", "onMessageReceived=%s", new Object[] { paramgdy });
    Object localObject1 = paramgdy.a();
    if ("/refresh".equals(localObject1))
    {
      paramgdy = eac.c(paramgdy.b());
      if (paramgdy != null)
      {
        dri.a("GmailWear", "Refresh gmail data item,req=%s", new Object[] { paramgdy });
        a(this, a, b, c);
      }
      return;
    }
    if ("/get_accounts".equals(localObject1))
    {
      paramgdy = a();
      localObject1 = a(this);
      ((eiz)localObject1).a(eab.c, eab.d);
      if (!((eiz)localObject1).e())
      {
        dri.d("GmailWear", "Failed to connect to Google API client", new Object[0]);
        return;
      }
    }
    for (;;)
    {
      Object localObject5;
      Object localObject4;
      int j;
      try
      {
        localObject5 = a((eiz)localObject1);
        localObject4 = PutDataRequest.a("/accounts");
        Object localObject6 = new dzm();
        if (paramgdy == null)
        {
          paramgdy = new dzl[0];
          a = paramgdy;
          d = dzm.a((hlt)localObject6);
          a((gdo)ged.a.a((eiz)localObject1, (PutDataRequest)localObject4).a(eab.c, eab.d));
          if (localObject5 == null) {
            break label473;
          }
          localObject4 = new oi();
          paramgdy = a;
          j = paramgdy.length;
          i = 0;
          if (i < j)
          {
            ((oi)localObject4).put(a, null);
            i += 1;
            continue;
          }
        }
        else
        {
          paramgdy = a((eiz)localObject1, (PutDataRequest)localObject4, paramgdy);
          continue;
        }
        localObject5 = a;
        int k = localObject5.length;
        int i = 0;
        if (i >= k) {
          break label473;
        }
        paramgdy = localObject5[i];
        if (!((oi)localObject4).containsKey(a))
        {
          localObject6 = a;
          dri.a("GmailWear", "Clear data items, accountId=%s", new Object[] { dri.a((String)localObject6) });
          j = 0;
          if (j < 13)
          {
            gdn localgdn = ged.a;
            paramgdy = String.valueOf(localObject6);
            if (paramgdy.length() != 0)
            {
              paramgdy = "/".concat(paramgdy);
              paramgdy = (gdq)localgdn.b((eiz)localObject1, eac.a(paramgdy), 1).a(eab.c, eab.d);
              a(paramgdy);
              if (!paramgdy.a().b()) {
                break label1360;
              }
              if (paramgdy.b() != 0) {
                break label1360;
              }
            }
            else
            {
              paramgdy = new String("/");
              continue;
            }
          }
        }
        i += 1;
      }
      finally
      {
        ((eiz)localObject1).d();
      }
      continue;
      label473:
      ((eiz)localObject1).d();
      buo.a().a("wear", "refresh_accounts", null, 0L);
      return;
      if ("/archive".equals(localObject1))
      {
        paramgdy = eac.d(paramgdy.b());
        if (paramgdy == null) {
          break;
        }
        a(paramgdy);
        return;
      }
      if ("/open_on_phone".equals(localObject1))
      {
        paramgdy = eac.e(paramgdy.b());
        if (paramgdy == null) {
          break;
        }
        a(paramgdy);
        return;
      }
      if ("/reply".equals(localObject1))
      {
        localObject1 = eac.f(paramgdy.b());
        if (localObject1 == null) {
          break;
        }
        dri.a("GmailWear", "Reply message=%s", new Object[] { localObject1 });
        localObject4 = a(this, a);
        if (localObject4 == null)
        {
          dri.d("GmailWear", "Can't reply message, account is null: req=%s", new Object[] { dri.a(a) });
          return;
        }
        paramgdy = Uri.parse(e);
        startActivity(cbk.a(this, (com.android.mail.providers.Account)localObject4, paramgdy, g).setData(paramgdy).putExtra("from-wear", true).putExtra("replyText", f).addFlags(268435456));
        localObject5 = buo.a();
        if (g) {}
        for (paramgdy = "reply_all";; paramgdy = "reply")
        {
          ((but)localObject5).a("wear", paramgdy, null, 0L);
          startService(new Intent(this, dzg.class).putExtra("com.google.android.gm.wearable.extra.ACCOUNT", (Parcelable)localObject4).putExtra("com.google.android.gm.wearable.extra.MESSAGE_URI", Uri.parse(d)));
          return;
        }
      }
      if ("/delete".equals(localObject1))
      {
        localObject1 = eac.g(paramgdy.b());
        if (localObject1 == null) {
          break;
        }
        dri.a("GmailWear", "Delete conversation=%s", new Object[] { localObject1 });
        dri.a("GmailWear", "Deleted %d rows", new Object[] { Integer.valueOf(getContentResolver().delete(Uri.parse(d), null, null)) });
        paramgdy = a(this);
        paramgdy.a(eab.c, eab.d);
        if (!paramgdy.e())
        {
          dri.d("GmailWear", "Failed to connect to Google API client", new Object[0]);
          return;
        }
        try
        {
          localObject1 = eac.a(a, b, c);
          a((gdq)ged.a.b(paramgdy, eac.a((String)localObject1)).a(eab.c, eab.d));
          paramgdy.d();
          buo.a().a("wear", "delete", null, 0L);
          return;
        }
        finally
        {
          paramgdy.d();
        }
      }
      Object localObject3;
      if ("/send_new_message".equals(localObject2))
      {
        localObject3 = eac.h(paramgdy.b());
        if (localObject3 == null) {
          break;
        }
        dri.a("GmailWear", "Sending composed message = %s", new Object[] { localObject3 });
        localObject4 = a(this, a);
        if (localObject4 == null)
        {
          dri.d("GmailWear", "Can't send message, account is null: req=%s", new Object[] { dri.a(a) });
          return;
        }
        paramgdy = new Bundle();
        paramgdy.putParcelable("mail_account", (Parcelable)localObject4);
        paramgdy.putString("to", b);
        paramgdy.putString("subject", c);
        paramgdy.putString("body", d);
        localObject3 = new Intent("com.google.android.gm.action.AUTO_SEND");
        ((Intent)localObject3).setType("text/plain");
        ((Intent)localObject3).setPackage(getPackageName());
        ((Intent)localObject3).putExtras(paramgdy);
        ((Intent)localObject3).setFlags(268435456);
        startActivity((Intent)localObject3);
        buo.a().a("wear", "compose", null, 0L);
        return;
      }
      if ("/open_default_inbox".equals(localObject3))
      {
        paramgdy = eac.i(paramgdy.b());
        if (paramgdy == null) {
          break;
        }
        dri.a("GmailWear", "Open default inbox, accountId=%s", new Object[] { paramgdy });
        localObject3 = a(this, a);
        if (localObject3 == null)
        {
          dri.d("GmailWear", "Failed to find account for %s", new Object[] { dri.a(a) });
          return;
        }
        startActivity(cxa.a((com.android.mail.providers.Account)localObject3));
        buo.a().a("wear", "open_default_inbox", null, 0L);
        return;
      }
      if (!"/open_app".equals(localObject3)) {
        break;
      }
      startActivity(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").setPackage(getPackageName()).setFlags(268484608));
      buo.a().a("wear", "open_app", null, 0L);
      return;
      label1360:
      j += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.wearable.AppWearableListenerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */