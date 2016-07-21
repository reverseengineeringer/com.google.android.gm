package com.android.email.provider;

import android.accounts.AccountManager;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.PeriodicSync;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.database.MergeCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import any;
import anz;
import aqv;
import ara;
import ard;
import arh;
import atg;
import ayg;
import ayh;
import ayn;
import ayo;
import ayp;
import ayt;
import ayv;
import ayw;
import ayx;
import ayy;
import ayz;
import aza;
import azb;
import azc;
import azd;
import aze;
import azf;
import azg;
import azh;
import azi;
import azk;
import azn;
import azt;
import azv;
import azy;
import azz;
import baa;
import bam;
import ban;
import bap;
import baq;
import bbx;
import bbz;
import bdm;
import bds;
import bdv;
import beb;
import bed;
import bek;
import bem;
import ber;
import bgt;
import bgz;
import bhn;
import buo;
import but;
import cfg;
import cfm;
import cfr;
import cfw;
import cge;
import cgf;
import cgr;
import cgy;
import chh;
import com.android.email.SecurityPolicy;
import com.android.email.service.AttachmentService;
import com.android.emailcommon.mail.Address;
import com.android.emailcommon.provider.ExchangeOofSettings;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.provider.Mailbox;
import com.android.emailcommon.provider.Policy;
import com.android.emailcommon.service.SearchParams;
import com.android.mail.providers.Folder;
import com.android.mail.providers.FolderList;
import ctl;
import ctr;
import cui;
import cus;
import cvl;
import cvm;
import cvp;
import cvq;
import gqa;
import hef;
import hen;
import hfd;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import nx;
import org.json.JSONObject;

public class EmailProvider
  extends ContentProvider
  implements SharedPreferences.OnSharedPreferenceChangeListener, cgf
{
  private static Uri B;
  private static Uri C;
  private static Uri D;
  private static Uri E;
  private static Uri F;
  private static Uri G;
  private static Uri H;
  private static Uri I;
  private static final String J;
  private static final String K;
  private static final String L;
  private static any P;
  private static any Q;
  private static final String R;
  private static final String S;
  private static any T;
  private static any U;
  private static any V;
  private static any W;
  private static final Uri X = Uri.parse("content://ui.email.android.com");
  private static final Uri Y = Uri.parse("content://ui.email2.android.com");
  private static final String Z = Long.toString(268435456L);
  public static final String a = cvl.a;
  private static final String[] aa = { "mailboxKey", "accountKey" };
  private static final String[] ad = { "emailAddress" };
  public static String b;
  public static Uri c;
  public static Uri d;
  public static Uri e;
  static ber h;
  public static Uri i;
  private static final String[] j = { "_id", "mailboxKey" };
  private static final SparseArray<String> k;
  private static final UriMatcher l;
  private static final Object m;
  private static final ContentValues n;
  private static final String[] q;
  private static final String[] r;
  private static Uri s;
  private static HandlerThread t;
  private static Handler u;
  private Handler A;
  private final ThreadLocal<Set<Uri>> M = new ThreadLocal();
  private final azh N = new azc(this);
  private azh O = N;
  @Deprecated
  private Handler ab;
  private nx<SearchParams> ac = new nx();
  private int[] ae = new int[0];
  private final ArrayList<Long> af = new ArrayList();
  private AppWidgetManager ag;
  private ComponentName ah;
  public boolean f;
  public final Set<azi> g = new HashSet();
  private int o = -1;
  private final ArrayList<ContentProviderOperation> p = new ArrayList();
  private SQLiteDatabase v;
  private SQLiteDatabase w;
  private azt x;
  private ayp y;
  private boolean z;
  
  static
  {
    Object localObject = new SparseArray(15);
    ((SparseArray)localObject).put(0, "Account");
    ((SparseArray)localObject).put(1, "Mailbox");
    ((SparseArray)localObject).put(2, "Message");
    ((SparseArray)localObject).put(3, "Attachment");
    ((SparseArray)localObject).put(4, "HostAuth");
    ((SparseArray)localObject).put(5, "Message_Deletes");
    ((SparseArray)localObject).put(6, "Policy");
    ((SparseArray)localObject).put(7, "QuickResponse");
    ((SparseArray)localObject).put(8, null);
    ((SparseArray)localObject).put(9, "Body");
    ((SparseArray)localObject).put(10, "Credential");
    ((SparseArray)localObject).put(11, "AttachmentDelete");
    ((SparseArray)localObject).put(12, "AccountDirtyFlags");
    ((SparseArray)localObject).put(13, "Search");
    k = (SparseArray)localObject;
    l = new UriMatcher(-1);
    m = new Object();
    n = new ContentValues();
    q = new String[] { "mimeType" };
    r = new String[] { "_id", "fileName", "size", "contentUri" };
    localObject = String.valueOf(") values (?, (SELECT syncServerId FROM Message WHERE _id=?),(SELECT accountKey FROM Message WHERE _id=?),");
    String str1 = String.valueOf(bed.a);
    J = String.valueOf(localObject).length() + 1 + String.valueOf(str1).length() + (String)localObject + str1 + ",";
    localObject = String.valueOf(a("MessageMove"));
    str1 = String.valueOf("srcFolderKey");
    String str2 = String.valueOf("dstFolderKey");
    String str3 = String.valueOf("srcFolderServerId");
    String str4 = String.valueOf("dstFolderServerId");
    String str5 = J;
    String str6 = String.valueOf("mailboxKey");
    String str7 = String.valueOf("Message");
    String str8 = String.valueOf("serverId");
    String str9 = String.valueOf("Mailbox");
    String str10 = String.valueOf("mailboxKey");
    String str11 = String.valueOf("Message");
    String str12 = String.valueOf("serverId");
    String str13 = String.valueOf("Mailbox");
    K = String.valueOf(localObject).length() + 116 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(str9).length() + String.valueOf(str10).length() + String.valueOf(str11).length() + String.valueOf(str12).length() + String.valueOf(str13).length() + (String)localObject + str1 + "," + str2 + "," + str3 + "," + str4 + str5 + "(SELECT " + str6 + " FROM " + str7 + " WHERE _id=?), ?,(SELECT " + str8 + " FROM " + str9 + " WHERE _id=(SELECT " + str10 + " FROM " + str11 + " WHERE _id=?)),(SELECT " + str12 + " FROM " + str13 + " WHERE _id=?))";
    localObject = String.valueOf(a("MessageStateChange"));
    str1 = String.valueOf("oldFlagRead");
    str2 = String.valueOf("newFlagRead");
    str3 = String.valueOf("oldFlagFavorite");
    str4 = String.valueOf("newFlagFavorite");
    str5 = String.valueOf("oldFlagAnswered");
    str6 = String.valueOf("newFlagAnswered");
    str7 = String.valueOf("oldFlagForwarded");
    str8 = String.valueOf("newFlagForwarded");
    str9 = J;
    str10 = String.valueOf("flagRead");
    str11 = String.valueOf("Message");
    str12 = String.valueOf("flagFavorite");
    str13 = String.valueOf("Message");
    String str14 = String.valueOf("flags");
    String str15 = String.valueOf("Message");
    String str16 = String.valueOf("flags");
    String str17 = String.valueOf("Message");
    L = String.valueOf(localObject).length() + 221 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(str9).length() + String.valueOf(str10).length() + String.valueOf(str11).length() + String.valueOf(str12).length() + String.valueOf(str13).length() + String.valueOf(str14).length() + String.valueOf(str15).length() + String.valueOf(str16).length() + String.valueOf(str17).length() + (String)localObject + str1 + "," + str2 + "," + str3 + "," + str4 + "," + str5 + "," + str6 + "," + str7 + "," + str8 + str9 + "(SELECT " + str10 + " FROM " + str11 + " WHERE _id=?),?,(SELECT " + str12 + " FROM " + str13 + " WHERE _id=?),?,(CASE WHEN (SELECT " + str14 + " FROM " + str15 + " WHERE _id=?)&262144 != 0 THEN 1 ELSE 0 END),?,(CASE WHEN (SELECT " + str16 + " FROM " + str17 + " WHERE _id=?)&524288 != 0 THEN 1 ELSE 0 END),?)";
    localObject = String.valueOf("CASE type WHEN 0 THEN 2 WHEN 3 THEN 4 WHEN 4 THEN 8 WHEN 5 THEN 16 WHEN 6 THEN 32 WHEN 7 THEN 64 WHEN 9 THEN 128 WHEN 10 THEN 2048 WHEN 11 THEN 16384 WHEN 8 THEN ");
    int i1 = b(8);
    R = String.valueOf(localObject).length() + 66 + (String)localObject + i1 + " WHEN 67 THEN 32768" + " ELSE 1 END";
    localObject = String.valueOf("CASE type WHEN 0 THEN ");
    i1 = ard.f;
    int i2 = ard.d;
    int i3 = ard.h;
    int i4 = ard.i;
    int i5 = ard.k;
    int i6 = ard.j;
    int i7 = ard.g;
    int i8 = ard.o;
    int i9 = ard.n;
    int i10 = ard.e;
    S = String.valueOf(localObject).length() + 304 + (String)localObject + i1 + " WHEN 3 THEN " + i2 + " WHEN 4 THEN " + i3 + " WHEN 5 THEN " + i4 + " WHEN 6 THEN " + i5 + " WHEN 9 THEN " + i6 + " WHEN 7 THEN " + i7 + " WHEN 11 THEN " + i8 + " WHEN 67 THEN " + i9 + " ELSE " + i10 + " END";
  }
  
  private static int a(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    AccountManager localAccountManager = AccountManager.get(paramContext);
    Cursor localCursor = paramSQLiteDatabase.query("Account", com.android.emailcommon.provider.Account.y, null, null, null, null, null);
    int i1 = 0;
    com.android.emailcommon.provider.Account localAccount;
    ban localban;
    try
    {
      for (;;)
      {
        if (!localCursor.moveToNext()) {
          break label213;
        }
        localAccount = new com.android.emailcommon.provider.Account();
        localAccount.a(localCursor);
        localban = bam.e(paramContext, localAccount.f(paramContext));
        if (localban != null) {
          break;
        }
        cvm.b(cvm.a, "Could not find service info for account", new Object[0]);
      }
      if (h != 0L) {
        break label122;
      }
    }
    finally
    {
      localCursor.close();
    }
    if (t == null) {
      throw new IllegalStateException("Trying to load incomplete Account object");
    }
    label122:
    localAccount.d(paramContext).a(paramContext);
    if (i != 0L)
    {
      localAccount.c(paramContext);
      if (u != null) {
        u.a(paramContext);
      }
    }
    paramSQLiteDatabase = localAccount.f();
    if (paramSQLiteDatabase != null) {}
    for (paramSQLiteDatabase = paramSQLiteDatabase.toString();; paramSQLiteDatabase = null)
    {
      localAccountManager.setUserData(localAccount.a(c), "accountJson", paramSQLiteDatabase);
      i1 += 1;
      break;
    }
    label213:
    localCursor.close();
    return i1;
  }
  
  private final int a(Context paramContext, String paramString, Uri[] paramArrayOfUri)
  {
    int i2 = 0;
    long l1 = System.currentTimeMillis();
    paramContext = paramContext.getContentResolver();
    ContentValues localContentValues = new ContentValues(1);
    int i3 = paramArrayOfUri.length;
    int i1 = 0;
    while (i1 < i3)
    {
      Uri localUri = paramArrayOfUri[i1];
      localContentValues.put("lastTouchedTime", Long.valueOf(l1));
      cvm.b(a, "updateStamp: %s updated", new Object[] { localUri });
      i2 += paramContext.update(localUri, localContentValues, null, null);
      i1 += 1;
    }
    paramContext = I.buildUpon().appendPath(paramString).build();
    cvm.b(a, "updateTimestamp: Notifying on %s", new Object[] { paramContext });
    a(paramContext, null);
    return i2;
  }
  
  private final int a(Uri paramUri, int paramInt1, int paramInt2)
  {
    Context localContext = getContext();
    paramUri = query(a("uiaccount", Long.valueOf(Long.parseLong(paramUri.getLastPathSegment())).longValue()), chh.c, null, null, null);
    try
    {
      if (paramUri.moveToFirst())
      {
        com.android.mail.providers.Account.b();
        com.android.mail.providers.Account localAccount = cfw.a(paramUri);
        Intent localIntent = new Intent(localContext, azn.class);
        localIntent.putExtra("picker_ui_account", localAccount);
        localIntent.putExtra("picker_mailbox_type", paramInt1);
        localIntent.putExtra("picker_header_id", paramInt2);
        localIntent.addFlags(268435456);
        localContext.startActivity(localIntent);
        return 1;
      }
      return 0;
    }
    finally
    {
      paramUri.close();
    }
  }
  
  private final int a(Uri paramUri, ContentValues paramContentValues)
  {
    int i1 = paramContentValues.size();
    paramUri = (String)paramUri.getPathSegments().get(1);
    Uri[] arrayOfUri = new Uri[i1];
    Context localContext = getContext();
    paramContentValues = paramContentValues.keySet().iterator();
    while (paramContentValues.hasNext()) {
      arrayOfUri[0] = Uri.parse((String)paramContentValues.next());
    }
    return a(localContext, paramUri, arrayOfUri);
  }
  
  private final int a(Uri paramUri, ContentValues paramContentValues, boolean paramBoolean)
  {
    int i2 = 0;
    int i1 = 0;
    if (paramUri.getBooleanQueryParameter("threadOp", false))
    {
      Cursor localCursor = c(getContext()).rawQuery("SELECT _id FROM Message WHERE threadId=?", new String[] { paramUri.getLastPathSegment() });
      if (localCursor != null) {}
      for (;;)
      {
        i2 = i1;
        try
        {
          if (localCursor.moveToNext())
          {
            i2 = localCursor.getColumnIndex("_id");
            Uri.Builder localBuilder = ContentUris.withAppendedId(beb.a, localCursor.getLong(i2)).buildUpon();
            String str = paramUri.getQueryParameter("seq");
            if (str != null) {
              localBuilder.appendQueryParameter("seq", str);
            }
            i2 = b(localBuilder.build(), paramContentValues, paramBoolean);
            i1 += i2;
          }
          else
          {
            return i2;
          }
        }
        finally
        {
          if (localCursor != null) {
            localCursor.close();
          }
        }
      }
    }
    return b(paramUri, paramContentValues, paramBoolean);
  }
  
  private static int a(ban paramban, int paramInt, long paramLong)
  {
    int i1;
    if (paramInt == 8) {
      i1 = 4;
    }
    int i2;
    do
    {
      return i1;
      i2 = 0;
      if (paramInt != 3) {
        i2 = 4;
      }
      i1 = i2;
      if (paramban != null)
      {
        i1 = i2;
        if (r) {
          i1 = i2 | 0x40;
        }
      }
      if ((paramInt != 1) && (paramInt != 6) && (paramInt != 7))
      {
        i2 = i1;
        if (paramInt != 0) {}
      }
      else
      {
        i2 = i1 | 0x1 | 0x400;
      }
      if (paramInt == 6) {
        i2 = 132357;
      }
      i1 = i2;
      if (f(paramLong)) {
        i1 = i2 | 0x200;
      }
      if (paramban != null)
      {
        i2 = i1;
        if (C) {}
      }
      else
      {
        i2 = i1 & 0xEBFE;
      }
      if (paramInt == 4) {
        break;
      }
      i1 = i2;
    } while (paramInt != 5);
    return i2 | 0x2000;
  }
  
  private static int a(cfm paramcfm)
  {
    if (paramcfm.e()) {
      return 1;
    }
    return 2;
  }
  
  private static long a(Context paramContext, com.android.emailcommon.provider.Account paramAccount)
  {
    if (paramAccount == null) {
      return 0L;
    }
    String str = paramAccount.f(paramContext);
    long l1 = r;
    if ((TextUtils.equals(paramContext.getString(arh.cl), str)) || (TextUtils.equals(paramContext.getString(arh.cm), str))) {}
    long l2;
    for (l1 = 0x100069 | l1 | 0x20000000;; l1 = 0x100000 | l1 | 0x20000000)
    {
      cvm.b(a, "getCapabilities() for %d (protocol %s): 0x%x %s", new Object[] { Long.valueOf(D), str, Long.valueOf(l1), Long.toBinaryString(l1) });
      l2 = l1;
      if (paramContext.getResources().getBoolean(ara.b)) {
        l2 = l1 | 0x10000;
      }
      l1 = l2;
      if (!TextUtils.isEmpty(paramContext.getResources().getString(arh.bo))) {
        l1 = l2 | 0x8000;
      }
      return l1 | 0x200000;
      if (!TextUtils.equals(paramContext.getString(arh.cn), str)) {
        break;
      }
    }
    if (TextUtils.equals(paramContext.getString(arh.ck), str))
    {
      Object localObject = l;
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          d1 = Double.parseDouble((String)localObject);
          l2 = 0x84100809 | l1 | 0x100000000;
          l1 = l2;
          if (d1 >= 14.0D) {
            l1 = l2 | 0x200000000;
          }
          l2 = l1;
          if (d1 >= 12.0D) {
            l2 = l1 | 0x400060;
          }
          l1 = l2;
          if (a(d1)) {
            l1 = l2 | 0x200;
          }
          if (h == null) {
            break label421;
          }
          localObject = h;
          l2 = l1;
          if (((ber)localObject).a() >= 3) {
            l2 = l1 | 0x10000000;
          }
          if (h == null) {
            break label434;
          }
          localObject = h;
          l1 = l2;
          if (((ber)localObject).a() >= 4) {
            l1 = l2 | 0x20000000;
          }
          if (h == null) {
            break label447;
          }
          localObject = h;
          l2 = l1;
          if (((ber)localObject).a() >= 5) {
            l2 = l1 | 0x40000000;
          }
          l1 = l2 | 0x800000000;
        }
        catch (NumberFormatException localNumberFormatException) {}
        double d1 = 2.5D;
        continue;
        label421:
        ber localber = bam.a(paramContext, D);
        continue;
        label434:
        localber = bam.a(paramContext, D);
        continue;
        label447:
        localber = bam.a(paramContext, D);
      }
    }
    cvm.d(a, "Unknown protocol for account %d", new Object[] { Long.valueOf(D) });
    return 0L;
  }
  
  private static android.accounts.Account a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = bam.e(paramContext, paramString2);
    if (paramContext == null) {
      return null;
    }
    return new android.accounts.Account(paramString1, c);
  }
  
  private final ContentValues a(beb parambeb, ContentValues paramContentValues)
  {
    ContentValues localContentValues = new ContentValues();
    Iterator localIterator = paramContentValues.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramContentValues.get((String)localObject1);
      int i1 = -1;
      switch (((String)localObject1).hashCode())
      {
      }
      for (;;)
      {
        switch (i1)
        {
        case 4: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          throw new IllegalArgumentException(String.valueOf(localObject1).length() + 24 + "Can't update " + (String)localObject1 + " in message");
          if (((String)localObject1).equals("starred"))
          {
            i1 = 0;
            continue;
            if (((String)localObject1).equals("read"))
            {
              i1 = 1;
              continue;
              if (((String)localObject1).equals("seen"))
              {
                i1 = 2;
                continue;
                if (((String)localObject1).equals("mailboxKey"))
                {
                  i1 = 3;
                  continue;
                  if (((String)localObject1).equals("folders_updated"))
                  {
                    i1 = 4;
                    continue;
                    if (((String)localObject1).equals("rawFolders"))
                    {
                      i1 = 5;
                      continue;
                      if (((String)localObject1).equals("alwaysShowImages"))
                      {
                        i1 = 6;
                        continue;
                        if (((String)localObject1).equals("viewed"))
                        {
                          i1 = 7;
                          continue;
                          if (((String)localObject1).equals("suppress_undo"))
                          {
                            i1 = 8;
                            continue;
                            if (((String)localObject1).equals("conversationInfo"))
                            {
                              i1 = 9;
                              continue;
                              if (((String)localObject1).equals("clipped")) {
                                i1 = 10;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      a(localContentValues, "flagFavorite", localObject2);
      continue;
      a(localContentValues, "flagRead", localObject2);
      continue;
      a(localContentValues, "flagSeen", localObject2);
      continue;
      a(localContentValues, "mailboxKey", localObject2);
      continue;
      localObject1 = FolderList.a(paramContentValues.getAsByteArray((String)localObject1));
      if (a.size() != 1)
      {
        cvm.e(a, "Incorrect number of folders for this message: Message is %s", new Object[] { Long.valueOf(D) });
      }
      else
      {
        a(localContentValues, "mailboxKey", Long.valueOf(Long.parseLong(a.get(0)).c.b.getLastPathSegment())));
        continue;
        localObject1 = Address.h(X);
        localObject2 = cfm.a(getContext());
        int i2 = localObject1.length;
        i1 = 0;
        while (i1 < i2)
        {
          ((cfm)localObject2).a(a, null);
          i1 += 1;
        }
        switch (((Integer)localObject2).intValue())
        {
        default: 
          parambeb = String.valueOf(localObject2);
          throw new IllegalArgumentException(String.valueOf(parambeb).length() + 41 + "Invalid value written to clipped column: " + parambeb);
        case 3: 
          localContentValues.put("flagLoaded", Integer.valueOf(5));
          break;
        case 2: 
          localContentValues.put("flagLoaded", Integer.valueOf(2));
        }
      }
    }
    return localContentValues;
  }
  
  private final Cursor a(int paramInt, Uri paramUri, String[] paramArrayOfString, boolean paramBoolean)
  {
    Context localContext = getContext();
    ContentResolver localContentResolver = localContext.getContentResolver();
    SQLiteDatabase localSQLiteDatabase = c(localContext);
    Object localObject2 = (String)paramUri.getPathSegments().get(1);
    Object localObject1;
    long l1;
    switch (paramInt)
    {
    case 32772: 
    case 32773: 
    case 32776: 
    case 32780: 
    case 32781: 
    case 32782: 
    case 32785: 
    case 32788: 
    default: 
      paramArrayOfString = null;
      paramUri = null;
    case 32787: 
    case 32786: 
    case 32784: 
    case 32769: 
      for (;;)
      {
        if ((paramArrayOfString != null) && (paramUri != null)) {
          paramUri.setNotificationUri(localContentResolver, paramArrayOfString);
        }
        return paramUri;
        paramUri = C.buildUpon().appendEncodedPath((String)localObject2).build();
        localObject1 = a((String)localObject2, paramArrayOfString);
        if (((String)localObject2).equals(Z))
        {
          paramArrayOfString = paramUri;
          paramUri = (Uri)localObject1;
        }
        else
        {
          localObject2 = localSQLiteDatabase.rawQuery(b(paramArrayOfString), new String[] { localObject2 });
          ((Cursor)localObject2).setNotificationUri(localContext.getContentResolver(), paramUri);
          ((Cursor)localObject1).setNotificationUri(localContext.getContentResolver(), paramUri);
          if (((Cursor)localObject2).getCount() > 0)
          {
            localObject1 = new MergeCursor(new Cursor[] { localObject2, localObject1 });
            paramArrayOfString = paramUri;
            paramUri = (Uri)localObject1;
          }
          else
          {
            paramArrayOfString = paramUri;
            paramUri = (Uri)localObject2;
            continue;
            paramUri = a(localSQLiteDatabase.rawQuery(b(e(paramArrayOfString)), new String[] { localObject2 }), Long.valueOf((String)localObject2).longValue(), paramArrayOfString);
            paramArrayOfString = C.buildUpon().appendEncodedPath((String)localObject2).build();
            continue;
            paramUri = localSQLiteDatabase.rawQuery(c(paramArrayOfString), new String[] { localObject2 });
            paramArrayOfString = I.buildUpon().appendPath((String)localObject2).build();
            continue;
            paramUri = a(localSQLiteDatabase.rawQuery(d(e(paramArrayOfString)), new String[] { localObject2 }), Mailbox.a(localContext, (String)localObject2), paramArrayOfString);
            l1 = Mailbox.a(localContext, (String)localObject2);
            paramArrayOfString = ContentUris.withAppendedId(C, l1);
          }
        }
      }
    case 32770: 
      l1 = Long.parseLong((String)localObject2);
      localObject1 = c(localContext, l1);
      if (localObject1 == null) {
        return new MatrixCursor(paramArrayOfString);
      }
      boolean bool = paramUri.getBooleanQueryParameter("enforceUnifiedInboxThreading", false);
      if (f(l1))
      {
        paramUri = new ContentValues();
        int i1;
        if ((bool) || (f))
        {
          paramInt = 1;
          if (paramInt != 0) {
            a(paramUri);
          }
          i1 = (int)(0xF & l1);
          paramArrayOfString = a(l(), paramArrayOfString, paramUri);
          a(paramArrayOfString);
          if (paramInt != 0) {
            b(paramArrayOfString);
          }
          paramArrayOfString.append(" FROM Message");
          paramArrayOfString.append(" WHERE flagLoaded IN (2,1,5, 6) AND ");
          if (!g(l1)) {
            break label696;
          }
          if (paramBoolean)
          {
            paramArrayOfString.append("flagSeen").append("=0 AND ");
            paramArrayOfString.append("flagRead").append("=0 AND ");
          }
          paramUri = null;
        }
        for (;;)
        {
          switch (i1)
          {
          default: 
            throw new IllegalArgumentException(44 + "No virtual mailbox for: " + l1);
            paramInt = 0;
            break label512;
            if (i1 == 0) {
              throw new IllegalArgumentException(44 + "No virtual mailbox for: " + l1);
            }
            paramArrayOfString.append("accountKey").append("=? AND ");
            paramUri = new String[1];
            paramUri[0] = Long.toString(l1 >> 32);
          }
        }
        if (paramInt != 0) {
          paramArrayOfString.append("threadId").append(" IN (SELECT DISTINCT ").append("threadId").append(" FROM ").append("Message").append(" WHERE ");
        }
        paramArrayOfString.append("mailboxKey IN (SELECT _id FROM Mailbox WHERE type=0)");
        if (paramInt != 0) {
          paramArrayOfString.append(") AND ").append("mailboxKey NOT IN (SELECT _id FROM Mailbox WHERE type=6 OR type=8)");
        }
        for (;;)
        {
          if (paramInt != 0) {
            paramArrayOfString.append(" GROUP BY ").append("threadId").append(' ');
          }
          paramArrayOfString.append(" ORDER BY dateReceivedMs DESC");
          paramUri = localSQLiteDatabase.rawQuery(paramArrayOfString.toString(), paramUri);
          paramArrayOfString = i.buildUpon().appendPath((String)localObject2).build();
          paramUri = new ayt(localContext, paramUri, (Folder)localObject1, l1);
          break;
          paramArrayOfString.append("flagFavorite=1 AND mailboxKey NOT IN (SELECT _id FROM Mailbox WHERE type = 6) AND flagLoaded IN (2,1,5, 6)");
          continue;
          paramArrayOfString.append("flagRead=0 AND mailboxKey NOT IN (SELECT _id FROM Mailbox WHERE type=6)");
          continue;
          paramArrayOfString.append("Message.mailboxKey NOT IN (SELECT _id FROM Mailbox WHERE type=6)");
        }
      }
      paramUri = new ContentValues();
      if ((f) && (p != 8) && (p != 4) && (p != 32))
      {
        paramInt = 1;
        if (paramInt != 0) {
          a(paramUri);
        }
        paramUri = a(l(), paramArrayOfString, paramUri);
        a(paramUri);
        if (paramInt != 0) {
          b(paramUri);
        }
        paramUri.append(" FROM Message");
        paramUri.append(" WHERE ").append("flagLoaded IN (2,1,5, 6)").append(" AND ");
        if (paramInt == 0) {
          break label1231;
        }
        paramUri.append("threadId").append(" IN (SELECT DISTINCT ").append("threadId").append(" FROM ").append("Message").append(" WHERE ").append("mailboxKey").append("=?").append(") AND ").append("mailboxKey NOT IN (SELECT _id FROM Mailbox WHERE type=6 OR type=8)");
      }
      for (;;)
      {
        if (paramBoolean)
        {
          paramUri.append(" AND ").append("flagSeen").append(" = 0");
          paramUri.append(" AND ").append("flagRead").append(" = 0");
        }
        if (paramInt != 0) {
          paramUri.append(" GROUP BY ").append("threadId");
        }
        paramUri.append(" ORDER BY dateReceivedMs DESC ");
        paramUri.append(" LIMIT 1500");
        cvm.c(a, "genMailboxQuery=%s", new Object[] { paramUri.toString() });
        paramUri = localSQLiteDatabase.rawQuery(paramUri.toString(), new String[] { localObject2 });
        break;
        paramInt = 0;
        break label985;
        paramUri.append("mailboxKey").append("=?");
      }
    case 32771: 
      label512:
      label696:
      label985:
      label1231:
      paramUri = localSQLiteDatabase.rawQuery(a(paramArrayOfString, (String)localObject2, paramUri.getBooleanQueryParameter("threadOp", false)), null);
      if (paramUri != null) {
        paramUri = new ayv(getContext(), paramUri);
      }
      break;
    }
    for (;;)
    {
      paramArrayOfString = H.buildUpon().appendPath((String)localObject2).build();
      break;
      paramUri = new azg(localContext, localSQLiteDatabase.rawQuery(a(paramArrayOfString, paramUri.getQueryParameters("contentType")), new String[] { localObject2 }));
      paramArrayOfString = F.buildUpon().appendPath((String)localObject2).build();
      break;
      paramUri = new ContentValues(2);
      paramUri.put("contentUri", q());
      paramUri.put("supportsDownloadAgain", Integer.valueOf(1));
      paramUri = localSQLiteDatabase.rawQuery(" FROM " + "Attachment" + " WHERE " + "_id" + " =? ", new String[] { localObject2 });
      paramArrayOfString = E.buildUpon().appendPath((String)localObject2).build();
      break;
      paramUri = (String)paramUri.getPathSegments().get(2);
      localObject1 = new ContentValues(2);
      ((ContentValues)localObject1).put("contentUri", q());
      ((ContentValues)localObject1).put("supportsDownloadAgain", Integer.valueOf(1));
      paramUri = localSQLiteDatabase.rawQuery(" FROM " + "Attachment" + " WHERE " + "messageKey" + " =? " + " AND " + "contentId" + " =? ", new String[] { localObject2, paramUri });
      paramArrayOfString = F.buildUpon().appendPath((String)localObject2).build();
      break;
      if (paramInt == 32789)
      {
        l1 = Mailbox.a(localContext, Long.parseLong((String)localObject2), 0);
        if (l1 == -1L)
        {
          cvm.d(cvm.a, "No inbox found for account %s", new Object[] { localObject2 });
          return null;
        }
        cvm.b(cvm.a, "Found inbox id %d", new Object[] { Long.valueOf(l1) });
      }
      for (;;)
      {
        localObject2 = Long.toString(l1);
        if (!f(l1)) {
          break label1721;
        }
        paramUri = a(l1, paramArrayOfString);
        paramArrayOfString = B.buildUpon().appendPath((String)localObject2).build();
        break;
        l1 = Long.parseLong((String)localObject2);
      }
      label1721:
      paramUri = localSQLiteDatabase.rawQuery(a(paramArrayOfString, (String)localObject2), new String[] { localObject2 });
      if (paramUri.moveToFirst()) {}
      for (;;)
      {
        try
        {
          localObject1 = new cvp(paramArrayOfString);
          a(paramUri, (MatrixCursor)localObject1, paramArrayOfString);
          paramUri.close();
          paramUri = (Uri)localObject1;
          paramArrayOfString = B.buildUpon().appendPath((String)localObject2).build();
        }
        finally
        {
          paramUri.close();
        }
        paramUri = new cvp(paramArrayOfString, 1);
        a(paramUri);
        for (;;)
        {
          paramArrayOfString = D.buildUpon().appendPath((String)localObject2).build();
          break;
          paramUri = localSQLiteDatabase.rawQuery(b(paramArrayOfString, (String)localObject2), new String[] { localObject2 });
        }
        paramUri = localSQLiteDatabase.rawQuery(a(paramArrayOfString), new String[] { localObject2 });
        paramArrayOfString = null;
        break;
      }
    }
  }
  
  private final Cursor a(long paramLong, String[] paramArrayOfString)
  {
    cvp localcvp = new cvp(paramArrayOfString, 1);
    localcvp.addRow(a(paramLong >> 32, (int)(0xF & paramLong), paramArrayOfString));
    return localcvp;
  }
  
  private final Cursor a(Cursor paramCursor, long paramLong, String[] paramArrayOfString)
  {
    cvp localcvp = new cvp(paramArrayOfString);
    if ((paramCursor == null) || (paramCursor != null)) {}
    int i1;
    int i3;
    int i6;
    int i7;
    int i8;
    Object localObject;
    MatrixCursor.RowBuilder localRowBuilder;
    int i9;
    int i2;
    String str;
    try
    {
      i1 = paramCursor.getCount();
      if (i1 == 0) {}
      int i5;
      int i10;
      do
      {
        int i4;
        while (!paramCursor.moveToNext())
        {
          return localcvp;
          i3 = paramCursor.getColumnIndex("_id");
          i4 = paramCursor.getColumnIndex("type");
          i5 = paramCursor.getColumnIndex("name");
          i6 = paramCursor.getColumnIndex("capabilities");
          i7 = paramCursor.getColumnIndex("persistentId");
          i8 = paramCursor.getColumnIndex("loadMoreUri");
          localObject = getContext();
          localObject = bam.e((Context)localObject, com.android.emailcommon.provider.Account.c((Context)localObject, paramLong));
        }
        localRowBuilder = localcvp.newRow();
        i9 = paramCursor.getInt(i4);
        i10 = paramArrayOfString.length;
        i2 = 0;
      } while (i2 >= i10);
      i1 = paramCursor.getColumnIndex(paramArrayOfString[i2]);
      if (i1 == -1)
      {
        localRowBuilder.add(null);
      }
      else
      {
        str = paramCursor.getString(i1);
        if (i5 == i1)
        {
          localRowBuilder.add(a(i9, str));
          i1 = 1;
          label229:
          if (i1 != 0) {
            break label509;
          }
          localRowBuilder.add(str);
        }
      }
    }
    finally
    {
      paramCursor.close();
    }
    if (i6 == i1)
    {
      paramLong = paramCursor.getLong(i3);
      switch (i9)
      {
      default: 
        label380:
        throw new IllegalArgumentException(38 + "Unable to map folder type: " + i9);
      }
    }
    for (;;)
    {
      localRowBuilder.add(Integer.valueOf(a((ban)localObject, i1, paramLong)));
      i1 = 1;
      break label229;
      if (i7 == i1)
      {
        localRowBuilder.add(Base64.encodeToString(str.getBytes(), 11));
        i1 = 1;
        break label229;
      }
      if ((i8 == i1) && (i9 != 8) && ((localObject == null) || (!B)))
      {
        localRowBuilder.add(null);
        i1 = 1;
        break label229;
      }
      i1 = 0;
      break label229;
      label509:
      i2 += 1;
      break;
      break label380;
      i1 = 1;
      continue;
      i1 = 0;
      continue;
      i1 = 4;
      continue;
      i1 = 3;
      continue;
      i1 = 6;
      continue;
      i1 = 5;
      continue;
      i1 = 7;
      continue;
      i1 = 9;
      continue;
      i1 = 11;
      continue;
      i1 = 10;
      continue;
      i1 = 8;
      continue;
      i1 = 67;
    }
  }
  
  private final Cursor a(String paramString, String[] paramArrayOfString)
  {
    cvp localcvp = null;
    Object localObject = localcvp;
    if (ba.size() > 1)
    {
      localObject = localcvp;
      if (cfm.a(getContext()).d("enableAllInboxes"))
      {
        String str = getContext().getString(arh.aT);
        localObject = localcvp;
        if (!TextUtils.isEmpty(str)) {
          localObject = getContext().getContentResolver().query(Uri.parse(str), paramArrayOfString, null, null, null);
        }
      }
    }
    localcvp = new cvp(paramArrayOfString);
    if (paramString.equals(Z))
    {
      localcvp.addRow(a(268435456L, 0, paramArrayOfString));
      localcvp.addRow(a(268435456L, 9, paramArrayOfString));
      localcvp.addRow(a(268435456L, 10, paramArrayOfString));
      if (localObject != null) {
        return new MergeCursor(new Cursor[] { localObject, localcvp });
      }
    }
    else
    {
      long l1 = Long.parseLong(paramString);
      paramString = i(l1);
      int i1;
      if ((paramString != null) && (type.equals(getContext().getString(arh.i))))
      {
        i1 = 1;
        label215:
        if (i1 == 0) {
          break label255;
        }
        localcvp.addRow(a(l1, 11, paramArrayOfString));
      }
      for (;;)
      {
        localcvp.addRow(a(l1, 10, paramArrayOfString));
        break;
        i1 = 0;
        break label215;
        label255:
        localcvp.addRow(a(l1, 9, paramArrayOfString));
      }
    }
    return localcvp;
  }
  
  private final Cursor a(String[] paramArrayOfString, boolean paramBoolean)
  {
    Context localContext = getContext();
    SQLiteDatabase localSQLiteDatabase = c(localContext);
    Cursor localCursor = localSQLiteDatabase.rawQuery("SELECT _id from Account", new String[0]);
    if (!paramBoolean) {}
    for (;;)
    {
      Object localObject1;
      try
      {
        if (localCursor.getCount() <= 1) {
          break label245;
        }
        i1 = 1;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("accounts_loaded", 1);
        localObject1 = new cvq(paramArrayOfString, localCursor.getCount(), (Bundle)localObject1);
        arrayOfObject = new Object[paramArrayOfString.length];
      }
      finally
      {
        try
        {
          Object[] arrayOfObject;
          if (((Cursor)localObject2).moveToNext())
          {
            int i2 = 0;
            if (i2 < paramArrayOfString.length)
            {
              arrayOfObject[i2] = ((Cursor)localObject2).getString(i2);
              i2 += 1;
              continue;
            }
            ((MatrixCursor)localObject1).addRow(arrayOfObject);
          }
          ((Cursor)localObject2).close();
          continue;
        }
        finally
        {
          Object localObject2;
          ((Cursor)localObject2).close();
        }
        paramArrayOfString = finally;
        localCursor.close();
      }
      if (localCursor.moveToNext())
      {
        localObject2 = localCursor.getString(0);
        localObject2 = localSQLiteDatabase.rawQuery(b(paramArrayOfString, (String)localObject2), new String[] { localObject2 });
      }
      if (i1 != 0) {
        a((MatrixCursor)localObject1);
      }
      localCursor.close();
      ((MatrixCursor)localObject1).setNotificationUri(localContext.getContentResolver(), G);
      return (Cursor)localObject1;
      label245:
      int i1 = 0;
    }
  }
  
  private static Uri a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 8192: 
    case 8193: 
    case 8194: 
      return beb.f;
    }
    return com.android.emailcommon.provider.Account.b;
  }
  
  public static Uri a(long paramLong, String paramString)
  {
    paramString = new Uri.Builder().scheme("auth").authority(String.valueOf(bdv.E).concat(".ACCOUNT_SETTINGS")).appendPath(paramString);
    bgz.a(paramString, paramLong);
    return paramString.build();
  }
  
  private static Uri a(Uri paramUri1, Uri paramUri2, boolean paramBoolean)
  {
    Object localObject = paramUri1.getLastPathSegment();
    try
    {
      localObject = ContentUris.withAppendedId(paramUri2, Long.parseLong((String)localObject));
      paramUri2 = (Uri)localObject;
      if (paramBoolean) {
        paramUri2 = ((Uri)localObject).buildUpon().appendQueryParameter("is_uiprovider", "true").build();
      }
      localObject = paramUri2;
      if (paramUri1.getBooleanQueryParameter("threadOp", false)) {
        localObject = paramUri2.buildUpon().appendQueryParameter("threadOp", "true").build();
      }
      return (Uri)localObject;
    }
    catch (NumberFormatException paramUri1) {}
    return null;
  }
  
  private final Uri a(beb parambeb, Mailbox paramMailbox, Bundle paramBundle)
  {
    Context localContext = getContext();
    Object localObject2 = com.android.emailcommon.provider.Account.a(localContext, g);
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = paramBundle.getString("customFrom");
    Object localObject3;
    Object localObject4;
    label247:
    int i1;
    int i2;
    label388:
    int i3;
    Object localObject5;
    Bundle localBundle;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      X = ((String)localObject1);
      n = System.currentTimeMillis();
      Y = paramBundle.getString("toAddresses");
      Z = paramBundle.getString("ccAddresses");
      aa = paramBundle.getString("bccAddresses");
      o = paramBundle.getString("subject");
      ax = paramBundle.getString("bodyText");
      ay = paramBundle.getString("bodyHtml");
      U = D;
      V = g;
      m = Y;
      r = 1;
      p = true;
      q = true;
      aB = paramBundle.getInt("quotedTextStartPos", 0);
      w = paramBundle.getInt("priority", 1);
      if (paramBundle.getBoolean("eventForward", false))
      {
        localObject3 = paramBundle.getString("collectionId");
        localObject4 = paramBundle.getString("itemId");
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
        {
          if (!TextUtils.isEmpty(ac)) {
            break label744;
          }
          localObject1 = new bdm();
          ((bdm)localObject1).a("COLLECTION_ID", (String)localObject3);
          ((bdm)localObject1).a("ITEM_ID", (String)localObject4);
          ((bdm)localObject1).a("EVENT_FORWARD", "true");
          ac = ((bdm)localObject1).toString();
        }
      }
      as = paramBundle.getString("proposeTimeFromMailRefMessageUri");
      at = paramBundle.getInt("proposeTimeFromMailRsvp");
      au = paramBundle.getLong("proposeTimeFromMailProposedStartTime");
      av = paramBundle.getLong("proposeTimeFromMailProposedEndTime");
      i1 = 0;
      i2 = 0;
      switch (paramBundle.getInt("draftType"))
      {
      default: 
        i1 = i2;
        i2 = i1;
        if (h == 4) {
          i2 = i1 | 0x400000;
        }
        i1 = 0;
        if (paramBundle.containsKey("quotedTextStartPos"))
        {
          i3 = paramBundle.getInt("quotedTextStartPos");
          i1 = i3;
          if (paramBundle.getInt("appendRefMessageContent") != 0) {
            i1 = i3 | 0x1000000;
          }
        }
        i3 = i2;
        if (!paramBundle.containsKey("appendRefMessageContent")) {
          i3 = i2 | 0x20000;
        }
        z = i1;
        u = i3;
        localObject1 = a(parambeb, paramBundle);
        i3 = h;
        localObject3 = getContext();
        localObject5 = com.android.mail.providers.Attachment.c(paramBundle.getString("attachments"));
        localObject4 = new ArrayList();
        localBundle = (Bundle)paramBundle.getParcelable("opened_fds");
        localObject5 = ((List)localObject5).iterator();
        i1 = 0;
      }
    }
    label744:
    long l1;
    for (;;)
    {
      if (!((Iterator)localObject5).hasNext()) {
        break label978;
      }
      Object localObject6 = (com.android.mail.providers.Attachment)((Iterator)localObject5).next();
      Object localObject7 = e;
      if ((localObject7 != null) && (((Uri)localObject7).getAuthority().equals(bdv.F)))
      {
        localObject6 = com.android.emailcommon.provider.Attachment.a((Context)localObject3, Long.parseLong(((Uri)localObject7).getLastPathSegment()));
        i2 = i1;
        if (localObject6 != null)
        {
          localObject7 = Parcel.obtain();
          ((com.android.emailcommon.provider.Attachment)localObject6).writeToParcel((Parcel)localObject7, 0);
          ((Parcel)localObject7).setDataPosition(0);
          localAttachment = new com.android.emailcommon.provider.Attachment((Parcel)localObject7);
          ((Parcel)localObject7).recycle();
          o = 0L;
          i2 = i1;
          if (i3 == 4)
          {
            i2 = i1;
            if (((com.android.emailcommon.provider.Attachment)localObject6).d() == null)
            {
              i2 = i1;
              if ((j & 0x80) == 0)
              {
                s |= 0x4;
                i2 = 1;
              }
            }
          }
          ((ArrayList)localObject4).add(localAttachment);
        }
        i1 = i2;
        continue;
        X = d;
        break;
        localObject1 = new bdm(ac);
        break label247;
        i1 = 2;
        break label388;
        i1 = 2097152;
        i1 |= 0x1;
        break label388;
        i1 = 8388608;
        break label388;
        i1 = 16777216;
        break label388;
        i1 = 1048576;
        break label388;
      }
      localObject7 = ctr.a((Context)localObject3, (com.android.mail.providers.Attachment)localObject6, localBundle);
      l1 = V;
      com.android.emailcommon.provider.Attachment localAttachment = new com.android.emailcommon.provider.Attachment();
      m = i.toString();
      if (!TextUtils.isEmpty((CharSequence)localObject7))
      {
        Object localObject8 = String.valueOf(bdv.F);
        localObject8 = Uri.parse(String.valueOf(localObject8).length() + 32 + "content://" + (String)localObject8 + "/attachment/cachedFile").buildUpon();
        ((Uri.Builder)localObject8).appendQueryParameter("filePath", (String)localObject7);
        n = ((Uri.Builder)localObject8).build().toString();
      }
      u = l1;
      i = c;
      j = ((com.android.mail.providers.Attachment)localObject6).l();
      k = d;
      ((ArrayList)localObject4).add(localAttachment);
    }
    label978:
    if (((ArrayList)localObject4).isEmpty())
    {
      aA = null;
      t = false;
      if (parambeb.h()) {
        break label1255;
      }
      parambeb.h(localContext);
      label1010:
      if (!f) {
        break label1358;
      }
      l1 = T;
      label1023:
      a(l1);
      a(i, null);
      a(U, V);
      if (h == 4)
      {
        a(paramMailbox, 0);
        l1 = az;
        if ((l1 != 0L) && (localObject1 != null))
        {
          localObject2 = new ContentValues();
          i1 = u;
          switch (paramBundle.getInt("draftType"))
          {
          default: 
            label1132:
            ((ContentValues)localObject2).put("flags", Integer.valueOf(i1));
            paramBundle = getContext();
            if (!a(paramBundle, Mailbox.a(paramBundle, U))) {
              break;
            }
          }
        }
      }
    }
    for (paramBundle = beb.c;; paramBundle = beb.a)
    {
      getContext().getContentResolver().update(ContentUris.withAppendedId(paramBundle, l1), (ContentValues)localObject2, null, null);
      if ((h == 3) && (b(localContext, V))) {
        a(paramMailbox, 0);
      }
      return a("uimessage", D);
      aA = ((ArrayList)localObject4);
      t = true;
      if (i1 == 0) {
        break;
      }
      bhn.a((Context)localObject3, arh.bN);
      break;
      label1255:
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(com.android.emailcommon.provider.Attachment.c, D)).build());
      ((ArrayList)localObject2).add(ContentProviderOperation.newDelete(bds.a).withSelection("messageKey=?", new String[] { Long.toString(D) }).build());
      parambeb.a((ArrayList)localObject2);
      try
      {
        applyBatch((ArrayList)localObject2);
      }
      catch (OperationApplicationException localOperationApplicationException)
      {
        cvm.b(a, localOperationApplicationException, "applyBatch exception", new Object[0]);
      }
      break label1010;
      label1358:
      l1 = D;
      break label1023;
      i1 |= 0x80000;
      break label1132;
      i1 |= 0x40000;
      break label1132;
    }
  }
  
  public static Uri a(String paramString, long paramLong)
  {
    return Uri.parse(b(paramString, paramLong));
  }
  
  private final beb a(beb parambeb, Bundle paramBundle)
  {
    String str2 = paramBundle.getString("refMessageId");
    beb localbeb = null;
    String str1 = null;
    paramBundle = str1;
    if (str2 != null)
    {
      paramBundle = str1;
      if (aB >= 0)
      {
        str1 = Uri.parse(str2).getLastPathSegment();
        paramBundle = localbeb;
      }
    }
    label246:
    for (;;)
    {
      try
      {
        if (P == null)
        {
          paramBundle = localbeb;
          str2 = String.valueOf(UUID.randomUUID());
          paramBundle = localbeb;
          P = (String.valueOf(str2).length() + 20 + "<" + str2 + "@email.android.com>");
        }
        paramBundle = localbeb;
        az = Long.parseLong(str1);
        paramBundle = localbeb;
        localbeb = beb.a(getContext(), az);
        paramBundle = localbeb;
        if (localbeb != null)
        {
          paramBundle = localbeb;
          if (!TextUtils.isEmpty(P)) {
            break label246;
          }
          paramBundle = localbeb;
          if (!TextUtils.isEmpty(R)) {
            break label246;
          }
          paramBundle = localbeb;
          if (TextUtils.isEmpty(aw)) {
            continue;
          }
          break label246;
          paramBundle = localbeb;
          if (i1 != 0)
          {
            paramBundle = localbeb;
            R = P;
            paramBundle = localbeb;
            T = T;
            paramBundle = localbeb;
            S = S;
            paramBundle = localbeb;
          }
        }
        return paramBundle;
        int i1 = 0;
        continue;
        i1 = 1;
      }
      catch (NumberFormatException parambeb)
      {
        return paramBundle;
      }
    }
  }
  
  private final Mailbox a(long paramLong, int paramInt)
  {
    Object localObject2 = Mailbox.b(getContext(), paramLong, paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = getContext();
      localObject1 = Mailbox.a(paramLong, paramInt);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      ((Mailbox)localObject1).h((Context)localObject2);
      return (Mailbox)localObject1;
      q = 2L;
      continue;
      q = 1L;
    }
  }
  
  public static File a(Context paramContext, long paramLong, String paramString)
  {
    if ((!TextUtils.equals(paramString, "html")) && (!TextUtils.equals(paramString, "txt"))) {
      throw new IllegalArgumentException("ext must be one of 'html' or 'txt'");
    }
    long l1 = paramLong / 100L;
    paramContext = paramContext.getFilesDir();
    String str1 = String.valueOf(Long.toString(l1 % 100L));
    String str2 = String.valueOf(Long.toString(paramLong % 100L));
    paramContext = new File(paramContext, String.valueOf(str1).length() + 7 + String.valueOf(str2).length() + "body/" + str1 + "/" + str2 + "/");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdirs())) {
      throw new FileNotFoundException("Could not create directory for body file");
    }
    str1 = String.valueOf(Long.toString(paramLong));
    return new File(paramContext, String.valueOf(str1).length() + 1 + String.valueOf(paramString).length() + str1 + "." + paramString);
  }
  
  private final String a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return paramString;
    case 2: 
      paramInt = arh.bC;
    }
    for (;;)
    {
      return getContext().getString(paramInt);
      paramInt = arh.bE;
      continue;
      paramInt = arh.bA;
      continue;
      paramInt = arh.bI;
      continue;
      paramInt = arh.bF;
      continue;
      paramInt = arh.bD;
      continue;
      paramInt = arh.bG;
      continue;
      paramInt = arh.bJ;
      continue;
      paramInt = arh.bB;
      continue;
      paramInt = arh.bH;
    }
  }
  
  private static String a(String paramString)
  {
    return String.format(Locale.US, "INSERT INTO %s (messageKey,messageServerId,accountKey,status,", new Object[] { paramString });
  }
  
  private static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("threadId=(SELECT threadId").append(" FROM Message WHERE _id").append('=').append(paramString1).append(')');
    if (paramString2 != null)
    {
      localStringBuilder.append(" AND (");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(')');
    }
    return localStringBuilder.toString();
  }
  
  private static String a(String[] paramArrayOfString)
  {
    paramArrayOfString = a(l(), paramArrayOfString);
    paramArrayOfString.append(" FROM Message WHERE ");
    paramArrayOfString.append("_id=?");
    return paramArrayOfString.toString();
  }
  
  private final String a(String[] paramArrayOfString, String paramString)
  {
    int i3 = 1;
    long l1 = Long.parseLong(paramString);
    paramString = new ContentValues(3);
    if (ac.a(l1, null) != null)
    {
      paramString.put("loadMoreUri", b("uiloadmore", l1));
      paramString.put("capabilities", Integer.valueOf(4));
    }
    label247:
    label250:
    for (;;)
    {
      paramArrayOfString = a(n(), paramArrayOfString, paramString);
      paramArrayOfString.append(" FROM Mailbox WHERE ");
      paramArrayOfString.append("_id=?");
      return paramArrayOfString.toString();
      Object localObject = getContext();
      Mailbox localMailbox = Mailbox.a((Context)localObject, l1);
      if (localMailbox != null)
      {
        localObject = bam.e((Context)localObject, com.android.emailcommon.provider.Account.c((Context)localObject, g));
        if ((localObject != null) && (B)) {
          paramString.put("loadMoreUri", b("uiloadmore", l1));
        }
        paramString.put("capabilities", Integer.valueOf(a((ban)localObject, h, l1)));
        int i1;
        if (paramArrayOfString == null) {
          i1 = i3;
        }
        for (;;)
        {
          if (i1 == 0) {
            break label250;
          }
          paramString.put("persistentId", Base64.encodeToString(d.getBytes(), 11));
          break;
          int i4 = paramArrayOfString.length;
          int i2 = 0;
          for (;;)
          {
            if (i2 >= i4) {
              break label247;
            }
            i1 = i3;
            if (TextUtils.equals(paramArrayOfString[i2], "persistentId")) {
              break;
            }
            i2 += 1;
          }
          i1 = 0;
        }
      }
    }
  }
  
  private final String a(String[] paramArrayOfString, String paramString, boolean paramBoolean)
  {
    long l1 = Long.parseLong(paramString);
    paramArrayOfString = a(m(), paramArrayOfString);
    paramArrayOfString.append(" FROM Message LEFT JOIN Body ON messageKey=Message._id WHERE Message.");
    beb localbeb = beb.a(getContext(), l1);
    if ((paramBoolean) && (localbeb != null) && (T > 0L))
    {
      paramArrayOfString.append("threadId=").append(T);
      paramArrayOfString.append(" AND ");
      paramArrayOfString.append("Message.accountKey=").append(V).append(" AND mailboxKey NOT IN (SELECT _id FROM Mailbox WHERE type=6 OR type=8)");
    }
    for (;;)
    {
      paramArrayOfString.append(" ORDER BY message.timestamp ASC");
      return paramArrayOfString.toString();
      paramArrayOfString.append("_id");
      paramArrayOfString.append('=').append(paramString);
    }
  }
  
  private static String a(String[] paramArrayOfString, List<String> paramList)
  {
    Object localObject = new ContentValues(1);
    ((ContentValues)localObject).put("supportsDownloadAgain", Integer.valueOf(1));
    paramArrayOfString = a(p(), paramArrayOfString, (ContentValues)localObject);
    paramArrayOfString.append(" FROM Attachment WHERE messageKey").append(" =? ");
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i2 = paramList.size();
      paramArrayOfString.append("AND (");
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = (String)paramList.get(i1);
        paramArrayOfString.append("mimeType LIKE '").append((String)localObject).append("%'");
        if (i1 != i2 - 1) {
          paramArrayOfString.append(" OR ");
        }
        i1 += 1;
      }
      paramArrayOfString.append(')');
    }
    return paramArrayOfString.toString();
  }
  
  private static StringBuilder a(any paramany, String[] paramArrayOfString)
  {
    return a(paramany, paramArrayOfString, n);
  }
  
  private static StringBuilder a(any paramany, String[] paramArrayOfString, ContentValues paramContentValues)
  {
    StringBuilder localStringBuilder = new StringBuilder("SELECT ");
    int i3 = paramArrayOfString.length;
    int i2 = 0;
    int i1 = 1;
    if (i2 < i3)
    {
      String str2 = paramArrayOfString[i2];
      label40:
      Object localObject;
      if (i1 != 0)
      {
        i1 = 0;
        if (!paramContentValues.containsKey(str2)) {
          break label262;
        }
        localObject = paramContentValues.getAsString(str2);
        if (localObject != null) {
          break label130;
        }
        localObject = String.valueOf(str2);
        if (((String)localObject).length() == 0) {
          break label115;
        }
        localObject = "NULL AS ".concat((String)localObject);
      }
      for (;;)
      {
        localStringBuilder.append((String)localObject);
        i2 += 1;
        break;
        localStringBuilder.append(',');
        break label40;
        label115:
        localObject = new String("NULL AS ");
        continue;
        label130:
        if (((String)localObject).startsWith("@"))
        {
          localObject = String.valueOf(((String)localObject).substring(1));
          localObject = String.valueOf(localObject).length() + 4 + String.valueOf(str2).length() + (String)localObject + " AS " + str2;
        }
        else
        {
          localObject = String.valueOf(DatabaseUtils.sqlEscapeString((String)localObject));
          localObject = String.valueOf(localObject).length() + 4 + String.valueOf(str2).length() + (String)localObject + " AS " + str2;
          continue;
          label262:
          String str1 = (String)paramany.get(str2);
          localObject = str1;
          if (str1 == null)
          {
            localObject = String.valueOf(str2);
            if (((String)localObject).length() != 0) {
              localObject = "NULL AS ".concat((String)localObject);
            } else {
              localObject = new String("NULL AS ");
            }
          }
        }
      }
    }
    return localStringBuilder;
  }
  
  private final void a(long paramLong1, long paramLong2)
  {
    c(Long.toString(paramLong1), paramLong2);
  }
  
  private final void a(long paramLong, ContentValues paramContentValues)
  {
    paramContentValues = paramContentValues.getAsInteger("syncInterval");
    if (paramContentValues == null) {}
    android.accounts.Account localAccount;
    do
    {
      do
      {
        return;
        localAccount = i(paramLong);
      } while (localAccount == null);
      cvm.b(a, "Setting sync interval for account %s to %d minutes", new Object[] { Long.valueOf(paramLong), paramContentValues });
      Iterator localIterator = ContentResolver.getPeriodicSyncs(localAccount, bdv.F).iterator();
      while (localIterator.hasNext())
      {
        PeriodicSync localPeriodicSync = (PeriodicSync)localIterator.next();
        ContentResolver.removePeriodicSync(localAccount, bdv.F, extras);
      }
    } while (paramContentValues.intValue() <= 0);
    ContentResolver.addPeriodicSync(localAccount, bdv.F, Bundle.EMPTY, paramContentValues.intValue() * 60000L / 1000L);
  }
  
  private static void a(android.accounts.Account paramAccount)
  {
    Bundle localBundle = new Bundle(3);
    localBundle.putBoolean("force", true);
    localBundle.putBoolean("do_not_retry", true);
    localBundle.putBoolean("expedited", true);
    ContentResolver.requestSync(paramAccount, bdv.F, localBundle);
  }
  
  private static void a(ContentValues paramContentValues)
  {
    String str1 = String.valueOf("@");
    String str2 = String.valueOf(bdv.F);
    String str3 = String.valueOf("_id");
    String str4 = String.valueOf("threadOp");
    str2 = String.valueOf(String.valueOf(str2).length() + 39 + String.valueOf(str3).length() + String.valueOf(str4).length() + "'content://" + str2 + "/uimessage/' || " + str3 + " || '?" + str4 + "=true'");
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      paramContentValues.put("_id", "@threadId");
      paramContentValues.put("read", "@CASE WHEN SUM(flagRead) < COUNT(flagRead) THEN 0 ELSE 1 END ");
      paramContentValues.put("numMessages", "@COUNT(threadId)");
      paramContentValues.put("numDrafts", "@SUM(CASE WHEN flags & 32505859 THEN CASE WHEN flags& 4194304 THEN 0 ELSE 1 END ELSE 0 END)");
      paramContentValues.put("hasAttachments", "@CASE WHEN SUM(flagAttachment) THEN 1 ELSE 0 END");
      paramContentValues.put("conversationUri", str1);
      paramContentValues.put("messageListUri", str1);
      paramContentValues.put("dateReceivedMs", "@MAX(timeStamp)");
      paramContentValues.put("starred", "@MAX(flagFavorite)");
      paramContentValues.put("priority", "@MAX(priority)");
      return;
    }
  }
  
  private static void a(ContentValues paramContentValues, String paramString, Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      paramContentValues.put(paramString, (Integer)paramObject);
    }
    do
    {
      return;
      if ((paramObject instanceof Boolean))
      {
        if (((Boolean)paramObject).booleanValue()) {}
        for (int i1 = 1;; i1 = 0)
        {
          paramContentValues.put(paramString, Integer.valueOf(i1));
          return;
        }
      }
    } while (!(paramObject instanceof Long));
    paramContentValues.put(paramString, (Long)paramObject);
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext.getResources().getBoolean(ara.a)) {
      h().post(new ayy(paramContext));
    }
  }
  
  private static void a(Context paramContext, long paramLong)
  {
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.putNull("htmlContent");
    localContentValues.putNull("textContent");
    a(paramContext, paramLong, localContentValues);
  }
  
  private static void a(Context paramContext, long paramLong, ContentValues paramContentValues)
  {
    String str;
    if (paramContentValues.containsKey("htmlContent")) {
      str = paramContentValues.getAsString("htmlContent");
    }
    try
    {
      a(paramContext, paramLong, "html", str);
      if (paramContentValues.containsKey("textContent")) {
        paramContentValues = paramContentValues.getAsString("textContent");
      }
      paramContext = "IOException while writing text body for message id ".concat(paramContext);
    }
    catch (IOException paramContentValues)
    {
      try
      {
        a(paramContext, paramLong, "txt", paramContentValues);
        return;
      }
      catch (IOException paramContentValues)
      {
        paramContext = String.valueOf(Long.toString(paramLong));
        if (paramContext.length() == 0) {
          break label139;
        }
      }
      paramContentValues = paramContentValues;
      paramContext = String.valueOf(Long.toString(paramLong));
      if (paramContext.length() != 0) {}
      for (paramContext = "IOException while writing html body for message id ".concat(paramContext);; paramContext = new String("IOException while writing html body for message id ")) {
        throw new IllegalStateException(paramContext, paramContentValues);
      }
    }
    for (;;)
    {
      throw new IllegalStateException(paramContext, paramContentValues);
      label139:
      paramContext = new String("IOException while writing text body for message id ");
    }
  }
  
  public static void a(Context paramContext, long paramLong, beb parambeb)
  {
    if (bam.a(paramContext, paramLong).a() >= 6) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        parambeb.d(8);
        parambeb.h(paramContext);
        bam.a(paramContext, paramLong).c(paramLong, parambeb.c());
      }
      return;
    }
  }
  
  private final void a(Context paramContext, long paramLong, SearchParams paramSearchParams)
  {
    long l1 = h;
    cvm.b(a, "runSearchQuery. account: %d mailbox id: %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1) });
    new azf(this, paramContext, paramLong, paramSearchParams, l1).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
  
  private static void a(Context paramContext, long paramLong, String paramString1, String paramString2)
  {
    paramContext = a(paramContext, paramLong, paramString1);
    if (TextUtils.isEmpty(paramString2))
    {
      if (!paramContext.delete()) {
        cvm.a(cvm.a, "did not delete text body for %d", new Object[] { Long.valueOf(paramLong) });
      }
      return;
    }
    paramContext = new FileWriter(paramContext);
    try
    {
      paramContext.write(paramString2);
      return;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  private final void a(Cursor paramCursor, MatrixCursor paramMatrixCursor, String[] paramArrayOfString)
  {
    paramMatrixCursor = paramMatrixCursor.newRow();
    int i3 = paramCursor.getInt(paramCursor.getColumnIndexOrThrow("type"));
    int i2 = 0;
    if (i2 < paramArrayOfString.length)
    {
      String str = paramArrayOfString[i2];
      int i1 = -1;
      switch (str.hashCode())
      {
      default: 
        switch (i1)
        {
        default: 
          label72:
          paramMatrixCursor.add(paramCursor.getString(i2));
        }
        break;
      }
      for (;;)
      {
        i2 += 1;
        break;
        if (!str.equals("name")) {
          break label72;
        }
        i1 = 0;
        break label72;
        if (!str.equals("capabilities")) {
          break label72;
        }
        i1 = 1;
        break label72;
        paramMatrixCursor.add(a(i3, paramCursor.getString(i2)));
        continue;
        paramMatrixCursor.add(Integer.valueOf(paramCursor.getInt(i2)));
      }
    }
  }
  
  private final void a(MatrixCursor paramMatrixCursor)
  {
    long l1 = agetContexta.getLong("lastAccountUsed", -1L);
    l1 = com.android.emailcommon.provider.Account.b(getContext(), l1);
    if (l1 == -1L) {
      return;
    }
    Object localObject1 = new hen();
    Object localObject2 = paramMatrixCursor.getColumnNames();
    int i1 = 0;
    while (i1 < localObject2.length)
    {
      ((hen)localObject1).b(localObject2[i1], Integer.valueOf(i1));
      i1 += 1;
    }
    localObject1 = ((hen)localObject1).b();
    cfm localcfm = cfm.a(getContext());
    localObject2 = new Object[localObject2.length];
    if (((Map)localObject1).containsKey("_id")) {
      localObject2[((Integer)localObject1.get("_id")).intValue()] = Integer.valueOf(0);
    }
    if (((Map)localObject1).containsKey("capabilities")) {
      localObject2[((Integer)localObject1.get("capabilities")).intValue()] = Long.valueOf(524288L);
    }
    if (((Map)localObject1).containsKey("folderListUri")) {
      localObject2[((Integer)localObject1.get("folderListUri")).intValue()] = h("uifolders", Z);
    }
    if (((Map)localObject1).containsKey("name")) {
      localObject2[((Integer)localObject1.get("name")).intValue()] = getContext().getString(arh.bz);
    }
    if (((Map)localObject1).containsKey("accountManagerName")) {
      localObject2[((Integer)localObject1.get("accountManagerName")).intValue()] = getContext().getString(arh.bz);
    }
    if (((Map)localObject1).containsKey("accountId")) {
      localObject2[((Integer)localObject1.get("accountId")).intValue()] = "Account Id";
    }
    if (((Map)localObject1).containsKey("type")) {
      localObject2[((Integer)localObject1.get("type")).intValue()] = "unknown";
    }
    if (((Map)localObject1).containsKey("undoUri"))
    {
      i1 = ((Integer)((Map)localObject1).get("undoUri")).intValue();
      String str = String.valueOf(bdv.F);
      localObject2[i1] = (String.valueOf(str).length() + 19 + "'content://" + str + "/uiundo'");
    }
    if (((Map)localObject1).containsKey("accountUri")) {
      localObject2[((Integer)localObject1.get("accountUri")).intValue()] = h("uiaccount", Z);
    }
    if (((Map)localObject1).containsKey("mimeType")) {
      localObject2[((Integer)localObject1.get("mimeType")).intValue()] = b;
    }
    if (((Map)localObject1).containsKey("securityHold")) {
      localObject2[((Integer)localObject1.get("securityHold")).intValue()] = Integer.valueOf(0);
    }
    if (((Map)localObject1).containsKey("accountSecurityUri")) {
      localObject2[((Integer)localObject1.get("accountSecurityUri")).intValue()] = "";
    }
    if (((Map)localObject1).containsKey("accountSettingsIntentUri")) {
      localObject2[((Integer)localObject1.get("accountSettingsIntentUri")).intValue()] = f("settings", Z);
    }
    if (((Map)localObject1).containsKey("composeUri")) {
      localObject2[((Integer)localObject1.get("composeUri")).intValue()] = g("compose", Long.toString(l1));
    }
    if (((Map)localObject1).containsKey("updateSettingsUri")) {
      localObject2[((Integer)localObject1.get("updateSettingsUri")).intValue()] = b("uiacctsettings", -1L);
    }
    if (((Map)localObject1).containsKey("auto_advance")) {
      localObject2[((Integer)localObject1.get("auto_advance")).intValue()] = Integer.toString(localcfm.i());
    }
    int i2;
    if (((Map)localObject1).containsKey("reply_behavior"))
    {
      i2 = ((Integer)((Map)localObject1).get("reply_behavior")).intValue();
      if (localcfm.c())
      {
        i1 = 1;
        localObject2[i2] = Integer.toString(i1);
      }
    }
    else
    {
      if (((Map)localObject1).containsKey("conversation_list_icon")) {
        localObject2[((Integer)localObject1.get("conversation_list_icon")).intValue()] = Integer.valueOf(a(localcfm));
      }
      if (((Map)localObject1).containsKey("confirm_delete"))
      {
        i2 = ((Integer)((Map)localObject1).get("confirm_delete")).intValue();
        if (!localcfm.f()) {
          break label1126;
        }
        i1 = 1;
        label898:
        localObject2[i2] = Integer.valueOf(i1);
      }
      if (((Map)localObject1).containsKey("confirm_archive")) {
        localObject2[((Integer)localObject1.get("confirm_archive")).intValue()] = Integer.valueOf(0);
      }
      if (((Map)localObject1).containsKey("confirm_send"))
      {
        i2 = ((Integer)((Map)localObject1).get("confirm_send")).intValue();
        if (!localcfm.g()) {
          break label1131;
        }
      }
    }
    label1126:
    label1131:
    for (i1 = 1;; i1 = 0)
    {
      localObject2[i2] = Integer.valueOf(i1);
      if (((Map)localObject1).containsKey("default_inbox")) {
        localObject2[((Integer)localObject1.get("default_inbox")).intValue()] = h("uifolder", Long.toString(1152921504606846976L));
      }
      if (((Map)localObject1).containsKey("move_to_inbox")) {
        localObject2[((Integer)localObject1.get("move_to_inbox")).intValue()] = h("uifolder", Long.toString(1152921504606846976L));
      }
      if (((Map)localObject1).containsKey("show_images")) {
        localObject2[((Integer)localObject1.get("show_images")).intValue()] = Integer.valueOf(1);
      }
      paramMatrixCursor.addRow((Object[])localObject2);
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label898;
    }
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    cvm.b(a, "Fixing parent keys", new Object[0]);
    paramSQLiteDatabase.execSQL("UPDATE Mailbox SET parentKey=(SELECT _id FROM Mailbox AS b WHERE Mailbox.parentServerId=b.serverId AND Mailbox.parentServerId NOT null  AND Mailbox.accountKey=b.accountKey)");
    paramSQLiteDatabase.execSQL("UPDATE Mailbox SET parentKey=-1 WHERE parentKey=0 OR parentKey IS null");
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Cursor localCursor;
    if (paramSQLiteDatabase != null) {
      localCursor = paramSQLiteDatabase.query(paramString, j, null, null, null, null, null);
    }
    ArrayList localArrayList3;
    String[] arrayOfString;
    Object localObject;
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      long l1;
      try
      {
        int i1 = localCursor.getCount();
        if (i1 == 0) {
          return;
        }
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localArrayList3 = new ArrayList();
        arrayOfString = new String[1];
        if (!localCursor.moveToNext()) {
          break;
        }
        l1 = localCursor.getLong(1);
        if (localArrayList2.contains(Long.valueOf(l1)))
        {
          localArrayList3.add(Long.valueOf(localCursor.getLong(0)));
          continue;
        }
        if (localArrayList1.contains(Long.valueOf(l1))) {
          continue;
        }
      }
      finally
      {
        localCursor.close();
      }
      arrayOfString[0] = Long.toString(l1);
      localObject = paramSQLiteDatabase.query("Mailbox", Mailbox.B, "_id=?", arrayOfString, null, null, null);
      try
      {
        if (((Cursor)localObject).moveToFirst()) {
          localArrayList1.add(Long.valueOf(l1));
        }
        for (;;)
        {
          ((Cursor)localObject).close();
          break;
          localArrayList2.add(Long.valueOf(l1));
          localArrayList3.add(Long.valueOf(localCursor.getLong(0)));
        }
        localObject = localArrayList3.iterator();
      }
      finally
      {
        ((Cursor)localObject).close();
      }
    }
    while (((Iterator)localObject).hasNext())
    {
      arrayOfString[0] = Long.toString(((Long)((Iterator)localObject).next()).longValue());
      paramSQLiteDatabase.delete(paramString, "_id=?", arrayOfString);
    }
    localCursor.close();
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i1 = paramSQLiteDatabase.delete(paramString1, String.valueOf(paramString2).length() + 23 + String.valueOf(paramString3).length() + String.valueOf(paramString4).length() + paramString2 + " NOT IN (SELECT " + paramString3 + " FROM " + paramString4 + ")", null);
    if (i1 > 0) {
      cvm.d(a, "Found %d orphaned row(s) in %s", new Object[] { Integer.valueOf(i1), paramString1 });
    }
  }
  
  private final void a(Uri paramUri, long paramLong)
  {
    a(paramUri, Long.toString(paramLong));
  }
  
  private final void a(Uri paramUri, String paramString1, String paramString2)
  {
    if (paramUri == null) {}
    for (;;)
    {
      return;
      paramUri = paramUri.buildUpon().appendEncodedPath(paramString1).build();
      try
      {
        l1 = Long.valueOf(paramString2).longValue();
        if (l1 > 0L)
        {
          a(paramUri, paramString2);
          if (!paramUri.equals(beb.f)) {
            continue;
          }
          getContext().sendBroadcast(new Intent("com.android.email.MESSAGE_LIST_DATASET_CHANGED"));
          return;
        }
      }
      catch (NumberFormatException paramString1)
      {
        for (;;)
        {
          long l1 = 0L;
          continue;
          a(paramUri, null);
        }
      }
    }
  }
  
  private final void a(Mailbox paramMailbox, int paramInt)
  {
    android.accounts.Account localAccount = i(g);
    if (localAccount != null)
    {
      paramMailbox = Mailbox.a(D);
      paramMailbox.putBoolean("force", true);
      paramMailbox.putBoolean("do_not_retry", true);
      paramMailbox.putBoolean("expedited", true);
      if (paramInt != 0) {
        paramMailbox.putInt("__deltaMessageCount__", paramInt);
      }
      ContentResolver.requestSync(localAccount, bdv.F, paramMailbox);
      cvm.c(a, "requestSync EmailProvider startSync %s, %s", new Object[] { cvm.a(localAccount.toString()), paramMailbox.toString() });
    }
  }
  
  private static void a(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(',').append("displayName,fromList,").append("toList");
  }
  
  private final void a(Set<Uri> paramSet)
  {
    M.set(paramSet);
  }
  
  private static boolean a(double paramDouble)
  {
    return paramDouble >= 16.0D;
  }
  
  private static boolean a(Context paramContext, SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT h.protocol, a.emailAddress, a.syncKey FROM Account AS a INNER JOIN HostAuth AS h ON a.hostAuthKeyRecv=h._id WHERE a._id=?", new String[] { paramString });
    if (paramSQLiteDatabase != null) {}
    try
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        paramString = paramSQLiteDatabase.getString(0);
        if ((paramContext.getString(arh.ck).equals(paramString)) && (!bdv.c(paramSQLiteDatabase.getString(2))))
        {
          paramContext = a(paramContext, paramSQLiteDatabase.getString(1), paramString);
          if (paramContext != null)
          {
            paramString = new Bundle();
            paramString.putBoolean("force", true);
            paramString.putBoolean("do_not_retry", true);
            paramString.putBoolean("expedited", true);
            paramString.putBoolean("__push_only__", true);
            ContentResolver.requestSync(paramContext, bdv.F, paramString);
            cvm.c(a, "requestSync EmailProvider restartPush %s, %s", new Object[] { cvm.a(paramContext.toString()), paramString.toString() });
            return true;
          }
        }
      }
      return false;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  private static boolean a(Context paramContext, Mailbox paramMailbox)
  {
    if ((h == 3) || (h == 4) || (h == 8)) {}
    do
    {
      return false;
      paramContext = bam.e(paramContext, com.android.emailcommon.provider.Account.c(paramContext, g));
    } while ((paramContext == null) || (!t));
    return true;
  }
  
  private final Object[] a(long paramLong, int paramInt, String[] paramArrayOfString)
  {
    long l1 = (paramLong << 32) + paramInt;
    String str2 = Long.toString(l1);
    Object[] arrayOfObject = new Object[paramArrayOfString.length];
    int i1 = 0;
    if (i1 < paramArrayOfString.length)
    {
      Object localObject = paramArrayOfString[i1];
      if (((String)localObject).equals("_id")) {
        arrayOfObject[i1] = Long.valueOf(l1);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (((String)localObject).equals("folderUri")) {
          arrayOfObject[i1] = h("uifolder", str2);
        } else if (((String)localObject).equals("name")) {
          arrayOfObject[i1] = a(b(paramInt), "");
        } else if (((String)localObject).equals("hasChildren")) {
          arrayOfObject[i1] = Integer.valueOf(0);
        } else if (((String)localObject).equals("capabilities")) {
          arrayOfObject[i1] = Integer.valueOf(516);
        } else if (((String)localObject).equals("conversationListUri")) {
          arrayOfObject[i1] = h("uimessages", str2);
        } else if (((String)localObject).equals("unreadCount"))
        {
          if ((paramInt == 0) && (paramLong == 268435456L))
          {
            arrayOfObject[i1] = Integer.valueOf(bdv.a(getContext(), beb.a, "mailboxKey IN (SELECT _id FROM Mailbox WHERE type=0) AND flagRead=0", null));
          }
          else
          {
            if (paramInt == 10)
            {
              String str1;
              if (paramLong == 268435456L)
              {
                str1 = "";
                localObject = null;
              }
              for (;;)
              {
                Context localContext = getContext();
                Uri localUri = beb.a;
                String str3 = String.valueOf("flagRead");
                String str4 = String.valueOf("mailboxKey");
                String str5 = String.valueOf("_id");
                String str6 = String.valueOf("Mailbox");
                String str7 = String.valueOf("type");
                arrayOfObject[i1] = Integer.valueOf(bdv.a(localContext, localUri, String.valueOf(str1).length() + 49 + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + str1 + str3 + "=0 AND " + str4 + " NOT IN (SELECT " + str5 + " FROM " + str6 + " WHERE " + str7 + "=6)", (String[])localObject));
                break;
                str1 = "accountKey=? AND ";
                localObject = new String[1];
                localObject[0] = Long.toString(paramLong);
              }
            }
            if ((paramInt == 9) || (paramInt == 11))
            {
              if (paramLong == 268435456L) {
                localObject = null;
              }
              for (;;)
              {
                arrayOfObject[i1] = Integer.valueOf(bdv.a(getContext(), beb.a, "accountKey=? AND flagFavorite=1 AND mailboxKey NOT IN (SELECT _id FROM Mailbox WHERE type = 6) AND flagLoaded IN (2,1,5, 6)", (String[])localObject));
                break;
                localObject = new String[1];
                localObject[0] = Long.toString(paramLong);
              }
            }
            if (paramInt == 8) {
              arrayOfObject[i1] = Integer.valueOf(bdv.a(getContext(), bem.b, null, null));
            }
          }
        }
        else if (((String)localObject).equals("iconResId"))
        {
          if (paramInt == 0) {
            arrayOfObject[i1] = Integer.valueOf(ard.f);
          } else if (paramInt == 10) {
            arrayOfObject[i1] = Integer.valueOf(ard.l);
          } else if (paramInt == 9) {
            arrayOfObject[i1] = Integer.valueOf(ard.j);
          } else if (paramInt == 11) {
            arrayOfObject[i1] = Integer.valueOf(ard.o);
          }
        }
        else if (((String)localObject).equals("type"))
        {
          if (paramInt == 8) {
            arrayOfObject[i1] = Integer.valueOf(4096);
          }
        }
        else if ((((String)localObject).equals("loadMoreUri")) && (paramInt == 8)) {
          arrayOfObject[i1] = b("uiloadmore", l1);
        }
      }
    }
    return arrayOfObject;
  }
  
  private static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 0: 
      return 2;
    case 4: 
      return 8;
    case 3: 
      return 4;
    case 6: 
      return 32;
    case 5: 
      return 16;
    case 7: 
      return 64;
    case 9: 
      return 128;
    case 11: 
      return 16384;
    case 10: 
      return 2048;
    case 8: 
      return 4097;
    }
    return 32768;
  }
  
  private final int b(Uri paramUri, ContentValues paramContentValues, boolean paramBoolean)
  {
    Object localObject2 = getContext();
    beb localbeb = b(paramUri);
    int i1;
    if (localbeb == null) {
      i1 = 0;
    }
    Mailbox localMailbox;
    label445:
    int i3;
    int i2;
    label481:
    label568:
    do
    {
      return i1;
      localMailbox = Mailbox.a((Context)localObject2, U);
      if (localMailbox == null) {
        return 0;
      }
      if ((paramBoolean) || (a((Context)localObject2, localMailbox))) {}
      Uri localUri;
      for (Object localObject1 = beb.c;; localObject1 = beb.a)
      {
        localUri = a(paramUri, (Uri)localObject1, true);
        if (localUri != null) {
          break;
        }
        return 0;
      }
      if (paramContentValues.containsKey("respond"))
      {
        localObject1 = bam.a((Context)localObject2, g);
        long l1 = -1L;
        long l2 = -1L;
        paramUri = null;
        if (paramContentValues.containsKey("proposedStartTime"))
        {
          l1 = paramContentValues.getAsLong("proposedStartTime").longValue();
          l2 = paramContentValues.getAsLong("proposedEndTime").longValue();
        }
        if (paramContentValues.containsKey("meetingRequestComment")) {
          paramUri = paramContentValues.getAsString("meetingRequestComment");
        }
        try
        {
          ((ber)localObject1).a(D, paramContentValues.getAsInteger("respond").intValue(), l1, l2, paramUri);
          h(D);
          return 1;
        }
        catch (RemoteException paramUri)
        {
          for (;;)
          {
            cvm.b(a, paramUri, "Remote exception while sending meeting response", new Object[0]);
          }
        }
      }
      if ((paramContentValues.containsKey("retryFetchProposedTime")) && (paramContentValues.getAsBoolean("retryFetchProposedTime").booleanValue()))
      {
        a((Context)localObject2, g, localbeb);
        return 1;
      }
      localObject2 = paramContentValues.getAsString("operation");
      if (localObject2 != null)
      {
        i1 = -1;
        switch (((String)localObject2).hashCode())
        {
        }
      }
      for (;;)
      {
        switch (i1)
        {
        default: 
          if (paramContentValues.size() != 0) {
            break label445;
          }
          return 0;
          if (((String)localObject2).equals("discard_outbox"))
          {
            i1 = 0;
            continue;
            if (((String)localObject2).equals("discard_drafts"))
            {
              i1 = 1;
              continue;
              if (((String)localObject2).equals("archive"))
              {
                i1 = 2;
                continue;
                if (((String)localObject2).equals("report_spam")) {
                  i1 = 3;
                }
              }
            }
          }
          break;
        }
      }
      return c(paramUri);
      return 0;
      ContentValues localContentValues = new ContentValues();
      localObject2 = a(localbeb, paramContentValues);
      Iterator localIterator = ((ContentValues)localObject2).keySet().iterator();
      i3 = 0;
      i2 = 0;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        switch (str.hashCode())
        {
        default: 
          i1 = -1;
        }
        for (;;)
        {
          i4 = i2;
          switch (i1)
          {
          default: 
            i1 = i2;
            i2 = i3;
            i3 = i2;
            i2 = i1;
            break label481;
            if (!str.equals("mailboxKey")) {
              break label568;
            }
            i1 = 0;
            continue;
            if (!str.equals("flagRead")) {
              break label568;
            }
            i1 = 1;
            continue;
            if (!str.equals("flagSeen")) {
              break label568;
            }
            i1 = 2;
            continue;
            if (!str.equals("flagFavorite")) {
              break label568;
            }
            i1 = 3;
            continue;
            if (!str.equals("flagLoaded")) {
              break label568;
            }
            i1 = 4;
            continue;
            if (!str.equals("flags")) {
              break label568;
            }
            i1 = 5;
          }
        }
        localContentValues.put("mailboxKey", Long.valueOf(U));
        int i4 = i2;
        for (;;)
        {
          i1 = i4;
          i2 = 1;
          break;
          localContentValues.put("flagRead", Boolean.valueOf(p));
          i4 = i2;
          continue;
          localContentValues.put("flagSeen", Boolean.valueOf(q));
          i4 = i2;
          continue;
          localContentValues.put("flagFavorite", Boolean.valueOf(s));
          i4 = i2;
          continue;
          i4 = 1;
        }
      }
      if (i3 == 0) {
        return -1;
      }
      paramContentValues = paramContentValues.getAsBoolean("suppress_undo");
      if (((paramContentValues == null) || (!paramContentValues.booleanValue())) && (localContentValues.size() != 0))
      {
        paramContentValues = ContentProviderOperation.newUpdate(a(paramUri, (Uri)localObject1, false)).withValues(localContentValues).build();
        paramUri = paramUri.getQueryParameter("seq");
        if (paramUri != null)
        {
          i1 = Integer.parseInt(paramUri);
          if (i1 > o)
          {
            p.clear();
            o = i1;
          }
          p.add(paramContentValues);
        }
      }
      i3 = update(localUri, (ContentValues)localObject2, null, null);
      i1 = i3;
    } while (i2 == 0);
    a(localMailbox, 0);
    return i3;
  }
  
  private final int b(Uri paramUri, String paramString)
  {
    i();
    int i1 = l.match(paramUri);
    if (i1 < 0)
    {
      paramUri = String.valueOf(paramUri);
      throw new IllegalArgumentException(String.valueOf(paramUri).length() + 13 + "Unknown uri: " + paramUri);
    }
    cvm.a(a, "%s: uri=%s, match is %s", new Object[] { paramString, paramUri, Integer.valueOf(i1) });
    return i1;
  }
  
  private final Cursor b(Mailbox paramMailbox, int paramInt)
  {
    azv localazv;
    long l1;
    aze localaze;
    if (paramMailbox != null)
    {
      localazv = azv.a(getContext());
      l1 = D;
      localaze = new aze(this);
    }
    synchronized (d)
    {
      if (!d.containsKey(Long.valueOf(l1))) {
        d.put(Long.valueOf(l1), Boolean.valueOf(false));
      }
      b.postDelayed(new azy(localazv, l1, localaze), 250L);
      a(paramMailbox, paramInt);
      return null;
    }
  }
  
  private final beb b(Uri paramUri)
  {
    long l1 = Long.parseLong(paramUri.getLastPathSegment());
    return beb.a(getContext(), l1);
  }
  
  private static String b(Context paramContext, com.android.emailcommon.provider.Account paramAccount)
  {
    boolean bool2 = true;
    if (paramAccount == null) {
      return null;
    }
    HostAuth localHostAuth = paramAccount.d(paramContext);
    paramContext = paramAccount.c(paramContext);
    int i2 = j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("domain: ").append(cui.d(d));
    if ((localHostAuth != null) && (b != null)) {
      localStringBuilder.append(", [hostAuthRecv protocol: ").append(b).append(", port: ").append(d).append(", security: ").append(HostAuth.a(e)).append(']');
    }
    if ((paramContext != null) && (b != null)) {
      localStringBuilder.append(", [hostAuthSend protocol: ").append(b).append(", port: ").append(d).append(", security: ").append(HostAuth.a(e)).append(']');
    }
    localStringBuilder.append(", protocol-version: ").append(l);
    paramContext = localStringBuilder.append(", sync disabled: ");
    int i1;
    if ((i2 & 0x400) > 0)
    {
      bool1 = true;
      paramContext.append(bool1);
      i1 = g;
      if (i1 != -1) {
        break label380;
      }
      paramContext = "never";
      label239:
      localStringBuilder.append(", sync freq (min): ").append(paramContext);
      paramContext = localStringBuilder.append(", sync window (days): ");
      switch (f)
      {
      default: 
        i1 = 14;
        label307:
        paramContext.append(i1);
        paramContext = localStringBuilder.append(", attachments: ");
        if ((i2 & 0x100) > 0)
        {
          bool1 = true;
          label333:
          paramContext.append(bool1);
          paramContext = localStringBuilder.append(", show-images: ");
          if ((i2 & 0x4000) <= 0) {
            break label442;
          }
        }
        break;
      }
    }
    label380:
    label442:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramContext.append(bool1);
      return localStringBuilder.toString();
      bool1 = false;
      break;
      if (i1 == -2)
      {
        paramContext = "push";
        break label239;
      }
      paramContext = Integer.toString(i1);
      break label239;
      i1 = 1;
      break label307;
      i1 = 3;
      break label307;
      i1 = 7;
      break label307;
      i1 = 14;
      break label307;
      i1 = 30;
      break label307;
      i1 = 3650;
      break label307;
      bool1 = false;
      break label333;
    }
  }
  
  private static String b(String paramString, long paramLong)
  {
    String str2 = String.valueOf(bdv.F);
    if (paramLong == -1L) {}
    for (String str1 = "";; str1 = 21 + "/" + paramLong) {
      return String.valueOf(str2).length() + 11 + String.valueOf(paramString).length() + String.valueOf(str1).length() + "content://" + str2 + "/" + paramString + str1;
    }
  }
  
  private static String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("_id=").append(paramString1);
    if (paramString2 != null)
    {
      localStringBuilder.append(" AND (");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(')');
    }
    return localStringBuilder.toString();
  }
  
  private static String b(String[] paramArrayOfString)
  {
    paramArrayOfString = a(n(), paramArrayOfString);
    paramArrayOfString.append(", case when hierarchicalName is null then displayName else hierarchicalName end as h_name");
    paramArrayOfString.append(" FROM Mailbox WHERE ");
    paramArrayOfString.append("accountKey=?");
    paramArrayOfString.append(" AND type<64 AND type!=8 AND isDeleted=0 ORDER BY h_name");
    return paramArrayOfString.toString();
  }
  
  private final String b(String[] paramArrayOfString, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    long l2 = Long.parseLong(paramString);
    Context localContext = getContext();
    hfd localhfd = hfd.a(paramArrayOfString);
    com.android.emailcommon.provider.Account localAccount = com.android.emailcommon.provider.Account.a(localContext, l2);
    if (localAccount == null) {
      cvm.b(a, "Account %d not found during genQueryAccount", new Object[] { Long.valueOf(l2) });
    }
    long l1;
    cfm localcfm;
    label242:
    label278:
    label424:
    label506:
    int i1;
    label592:
    label627:
    Object localObject2;
    if (localhfd.contains("capabilities"))
    {
      if (localAccount == null)
      {
        l1 = 0L;
        localContentValues.put("capabilities", Long.valueOf(l1));
      }
    }
    else
    {
      if (localhfd.contains("accountSettingsIntentUri")) {
        localContentValues.put("accountSettingsIntentUri", f("settings", paramString));
      }
      if (localhfd.contains("composeUri")) {
        localContentValues.put("composeUri", g("compose", paramString));
      }
      if (localhfd.contains("reauthenticationUri")) {
        localContentValues.put("reauthenticationUri", a(l2, "incoming").toString());
      }
      if (localhfd.contains("mimeType")) {
        localContentValues.put("mimeType", b);
      }
      localcfm = cfm.a(getContext());
      if (localhfd.contains("confirm_delete"))
      {
        if (!localcfm.f()) {
          break label1703;
        }
        localObject1 = "1";
        localContentValues.put("confirm_delete", (String)localObject1);
      }
      if (localhfd.contains("confirm_send"))
      {
        if (!localcfm.g()) {
          break label1711;
        }
        localObject1 = "1";
        localContentValues.put("confirm_send", (String)localObject1);
      }
      if (localhfd.contains("swipe")) {
        localContentValues.put("swipe", Integer.valueOf(localcfm.b(false)));
      }
      if (localhfd.contains("conversation_list_icon")) {
        localContentValues.put("conversation_list_icon", Integer.valueOf(a(localcfm)));
      }
      if (localhfd.contains("auto_advance")) {
        localContentValues.put("auto_advance", Integer.toString(localcfm.i()));
      }
      l1 = Mailbox.a(localContext, l2, 0);
      if ((!localhfd.contains("default_inbox")) || (l1 == -1L)) {
        break label1719;
      }
      localContentValues.put("default_inbox", b("uifolder", l1));
      if ((localhfd.contains("default_inbox_name")) && (l1 != -1L)) {
        localContentValues.put("default_inbox_name", bhn.b(localContext, ContentUris.withAppendedId(Mailbox.a, l1), Mailbox.Q, null, null));
      }
      if (localhfd.contains("syncStatus"))
      {
        if (l1 == -1L) {
          break label1738;
        }
        localContentValues.put("syncStatus", Integer.valueOf(0));
      }
      if (localhfd.contains("updateSettingsUri")) {
        localContentValues.put("updateSettingsUri", b("uiacctsettings", -1L));
      }
      if (localhfd.contains("enableMessageTransforms")) {
        localContentValues.put("enableMessageTransforms", Integer.valueOf(1));
      }
      if (localhfd.contains("securityHold"))
      {
        if ((localAccount == null) || ((j & 0x20) != 0)) {
          break label1754;
        }
        i1 = 0;
        localContentValues.put("securityHold", Integer.valueOf(i1));
      }
      if (localhfd.contains("accountSecurityUri"))
      {
        if (localAccount != null) {
          break label1759;
        }
        localObject1 = "";
        localContentValues.put("accountSecurityUri", (String)localObject1);
      }
      if (localhfd.contains("importance_markers_enabled")) {
        localContentValues.put("importance_markers_enabled", "0");
      }
      if (localhfd.contains("show_chevrons_enabled")) {
        localContentValues.put("show_chevrons_enabled", "0");
      }
      if ((!localhfd.contains("setup_intent_uri")) || (Mailbox.a(localContext, l2, 6) != -1L)) {
        break label1876;
      }
      localObject2 = bam.b(localContext, l2);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (D) {
          localContentValues.put("setup_intent_uri", f("setup", paramString));
        }
      }
    }
    label806:
    label1078:
    label1122:
    label1703:
    label1711:
    label1719:
    label1738:
    label1754:
    label1759:
    label1861:
    label1866:
    label1871:
    label1876:
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      if (localhfd.contains("type"))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = bam.b(localContext, l2);
        }
        if (localObject2 != null)
        {
          localObject1 = c;
          localContentValues.put("type", (String)localObject1);
        }
      }
      else
      {
        if ((localhfd.contains("move_to_inbox")) && (l1 != -1L)) {
          localContentValues.put("move_to_inbox", b("uifolder", l1));
        }
        if (localhfd.contains("syncAuthority")) {
          localContentValues.put("syncAuthority", bdv.F);
        }
        if (localhfd.contains("quickResponseUri")) {
          localContentValues.put("quickResponseUri", h("quickresponse/account", paramString));
        }
        if (localhfd.contains("settingsSnapshotUri")) {
          localContentValues.put("settingsSnapshotUri", h("settingsSnapshot", paramString));
        }
        if (localhfd.contains("vacationResponderSettingsUri")) {
          localContentValues.put("vacationResponderSettingsUri", h("vacationResponderSettings", paramString));
        }
        if (localhfd.contains("driveUri")) {
          localContentValues.put("driveUri", h("drive", paramString));
        }
        if (localhfd.contains("drawerAddress")) {
          localContentValues.put("drawerAddress", "");
        }
        if (localhfd.contains("settingsFragmentClass")) {
          localContentValues.put("settingsFragmentClass", getContext().getString(arh.bh, new Object[] { "com.android.email.activity.setup.AccountSettingsFragment" }));
        }
        if (localhfd.contains("reply_behavior"))
        {
          if (!localcfm.c()) {
            break label1861;
          }
          i1 = 1;
          localContentValues.put("reply_behavior", Integer.valueOf(i1));
        }
        if (localhfd.contains("show_images"))
        {
          if ((localAccount == null) || ((j & 0x4000) == 0)) {
            break label1866;
          }
          i1 = 1;
          if (i1 == 0) {
            break label1871;
          }
        }
      }
      for (i1 = 0;; i1 = 1)
      {
        localContentValues.put("show_images", Integer.valueOf(i1));
        if (localhfd.contains("conversation_view_mode")) {
          localContentValues.put("conversation_view_mode", Integer.valueOf(localcfm.j()));
        }
        if (localhfd.contains("accountOAuthTokenUri")) {
          localContentValues.put("accountOAuthTokenUri", "");
        }
        if (localhfd.contains("providerHostname")) {
          localContentValues.put("providerHostname", "");
        }
        if (localhfd.contains("providerPathname")) {
          localContentValues.put("providerPathname", "");
        }
        paramString = getContext();
        if (U == null)
        {
          localObject1 = new anz().a("_id", "_id").a("folderListUri", d("uifolders", "_id")).a("fullFolderListUri", d("uifullfolders", "_id")).a("allFolderListUri", d("uiallfolders", "_id")).a("name", "displayName").a("accountManagerName", "emailAddress").a("accountId", "emailAddress").a("senderName", "senderName");
          localObject2 = String.valueOf(bdv.F);
          localObject1 = ((anz)localObject1).a("undoUri", String.valueOf(localObject2).length() + 19 + "'content://" + (String)localObject2 + "/uiundo'").a("accountUri", d("uiaccount", "_id")).a("searchUri", d("uisearch", "_id")).a("providerVersion", "1").a("syncStatus", "0").a("recentFolderListUri", d("uirecentfolders", "_id")).a("defaultRecentFolderListUri", d("uidefaultrecentfolders", "_id")).a("signature", "signature").a("confirm_archive", "0").a("conversation_view_mode", Integer.toString(-1)).a("max_attachment_size", "maxAttachmentSize");
          ((anz)localObject1).a("searchMessageGenericUri", d("uisearchmessagegeneric", "_id"));
          localObject2 = paramString.getString(arh.bi);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((anz)localObject1).a("sendFeedbackIntentUri", String.valueOf(localObject2).length() + 2 + "'" + (String)localObject2 + "'");
          }
          paramString = paramString.getString(arh.bo);
          if (!TextUtils.isEmpty(paramString)) {
            ((anz)localObject1).a("helpIntentUri", String.valueOf(paramString).length() + 2 + "'" + paramString + "'");
          }
          U = ((anz)localObject1).a();
        }
        paramArrayOfString = a(U, paramArrayOfString, localContentValues);
        paramArrayOfString.append(" FROM Account WHERE ");
        paramArrayOfString.append("_id=?");
        return paramArrayOfString.toString();
        l1 = a(localContext, localAccount);
        break;
        localObject1 = "0";
        break label242;
        localObject1 = "0";
        break label278;
        localContentValues.put("default_inbox", b("uiinbox", l2));
        break label424;
        localContentValues.put("syncStatus", Integer.valueOf(8));
        break label506;
        i1 = 1;
        break label592;
        long l3 = D;
        localObject1 = String.valueOf(bdv.E);
        localObject1 = Uri.parse(String.valueOf(localObject1).length() + 25 + "auth://" + (String)localObject1 + ".ACCOUNT_SECURITY/").buildUpon();
        bgz.a((Uri.Builder)localObject1, l3);
        ((Uri.Builder)localObject1).appendQueryParameter("SHOW_DIALOG", Boolean.toString(true));
        localObject1 = ((Uri.Builder)localObject1).build().toString();
        break label627;
        localObject1 = "unknown";
        break label806;
        i1 = 0;
        break label1078;
        i1 = 0;
        break label1122;
      }
    }
  }
  
  private static void b(ContentValues paramContentValues)
  {
    if (paramContentValues.containsKey("toList")) {
      paramContentValues.put("toList", Address.e(paramContentValues.getAsString("toList")));
    }
    if (paramContentValues.containsKey("fromList")) {
      paramContentValues.put("fromList", Address.e(paramContentValues.getAsString("fromList")));
    }
    if (paramContentValues.containsKey("ccList")) {
      paramContentValues.put("ccList", Address.e(paramContentValues.getAsString("ccList")));
    }
    if (paramContentValues.containsKey("bccList")) {
      paramContentValues.put("bccList", Address.e(paramContentValues.getAsString("bccList")));
    }
    if (paramContentValues.containsKey("replyToList")) {
      paramContentValues.put("replyToList", Address.e(paramContentValues.getAsString("replyToList")));
    }
  }
  
  private static void b(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(", group_concat(CASE WHEN LENGTH(fromList)>0 THEN REPLACE(REPLACE(fromList, ',', ''), ';', '') ELSE '' END) AS threadFromList");
    paramStringBuilder.append(", group_concat(flagRead) AS threadReadFlag");
    paramStringBuilder.append(", group_concat(CASE WHEN (SELECT Mailbox.type FROM Mailbox WHERE Mailbox._id=Message.mailboxKey)=4 THEN (CASE WHEN Message.nextRetryTime=9223372036854775807 THEN -1 ELSE (CASE WHEN (SELECT Mailbox.uiSyncStatus FROM Mailbox WHERE Mailbox._id=Message.mailboxKey)=0 THEN 1 ELSE 2 END) END) ELSE 0 END) AS threadSendingState");
    paramStringBuilder.append(", group_concat(CASE WHEN LENGTH(snippet)>0 THEN snippet ELSE '' END) AS threadSnippets");
    paramStringBuilder.append(", group_concat(LENGTH(CASE WHEN LENGTH(snippet)>0 THEN snippet ELSE '' END)) AS threadSnippetsLength");
    paramStringBuilder.append(", group_concat(timeStamp) AS threadTimeStamp");
    paramStringBuilder.append(", MIN(timeStamp)");
  }
  
  public static boolean b(Context paramContext)
  {
    bdv.i(paramContext);
    try
    {
      localCursor = paramContext.getContentResolver().query(com.android.emailcommon.provider.Account.a, com.android.emailcommon.provider.Account.B, null, null, null);
      if (localCursor != null) {}
      try
      {
        boolean bool;
        Object localObject;
        int i1;
        if (localCursor.getCount() > 0)
        {
          bool = true;
          localObject = paramContext.getPackageManager();
          ComponentName localComponentName = new ComponentName(paramContext, AttachmentService.class);
          if (!bool) {
            break label126;
          }
          i1 = 1;
          label61:
          ((PackageManager)localObject).setComponentEnabledSetting(localComponentName, i1, 1);
          localObject = new Intent(paramContext, AttachmentService.class);
          if (!bool) {
            break label131;
          }
          paramContext.startService((Intent)localObject);
        }
        for (;;)
        {
          paramContext = bbz.a(paramContext);
          if (paramContext != null) {
            paramContext.a();
          }
          if (localCursor != null) {
            localCursor.close();
          }
          return bool;
          bool = false;
          break;
          label126:
          i1 = 2;
          break label61;
          label131:
          paramContext.stopService((Intent)localObject);
        }
        if (localCursor == null) {
          break label152;
        }
      }
      finally {}
    }
    finally
    {
      label152:
      Cursor localCursor = null;
    }
    localCursor.close();
    throw paramContext;
  }
  
  private static boolean b(Context paramContext, long paramLong)
  {
    boolean bool2 = false;
    com.android.emailcommon.provider.Account localAccount = com.android.emailcommon.provider.Account.a(paramContext, paramLong);
    boolean bool1 = bool2;
    if (localAccount != null)
    {
      String str = localAccount.f(paramContext);
      bool1 = bool2;
      if (TextUtils.equals(paramContext.getString(arh.ck), str))
      {
        bool1 = bool2;
        if (b(l)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    try
    {
      double d1 = Double.parseDouble(paramString);
      paramString = Double.valueOf(d1);
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString = (String)localObject;
      }
    }
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (a(paramString.doubleValue())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final int c(Uri paramUri)
  {
    Object localObject = getContext();
    beb localbeb = b(paramUri);
    if (localbeb == null) {}
    Mailbox localMailbox;
    label110:
    label179:
    label189:
    label197:
    do
    {
      do
      {
        return 0;
        localMailbox = Mailbox.a((Context)localObject, U);
      } while (localMailbox == null);
      if ((h == 3) && (!b((Context)localObject, V)))
      {
        i1 = 1;
        if ((h != 6) && (i1 == 0)) {
          break label197;
        }
        bgt.b((Context)localObject, V, D);
        bool = paramUri.getBooleanQueryParameter("threadOp", false);
        if (!bool) {
          break label179;
        }
        l1 = T;
        paramUri = ContentUris.withAppendedId(beb.c, l1).buildUpon();
        if (!bool) {
          break label189;
        }
      }
      for (paramUri = paramUri.appendQueryParameter("threadOp", "true").build();; paramUri = paramUri.build())
      {
        i1 = ((Context)localObject).getContentResolver().delete(paramUri, null, null);
        a(D, g);
        a(l1);
        return i1;
        i1 = 0;
        break;
        l1 = D;
        break label110;
      }
      localObject = Mailbox.b((Context)localObject, V, 6);
    } while (localObject == null);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("mailboxKey", Long.valueOf(D));
    int i1 = a(paramUri, localContentValues, true);
    boolean bool = paramUri.getBooleanQueryParameter("threadOp", false);
    a(D, g);
    if (bool) {}
    for (long l1 = T;; l1 = D)
    {
      a(l1);
      return i1;
    }
  }
  
  private final SQLiteDatabase c(Context paramContext)
  {
    for (;;)
    {
      Object localObject2;
      synchronized (m)
      {
        if (v != null)
        {
          paramContext = v;
          return paramContext;
        }
        j();
        v = new ayo(paramContext, "EmailProvider.db").getWritableDatabase();
        w = new ayn(paramContext, "EmailProviderBody.db").getWritableDatabase();
        if (w != null)
        {
          localObject2 = w.getPath();
          v.execSQL(String.valueOf(localObject2).length() + 25 + "attach \"" + (String)localObject2 + "\" as BodyDatabase");
        }
        f = cfm.a(paramContext).h();
        localObject2 = v;
        cvm.b(a, "restoreIfNeeded...", new Object[0]);
        if (!TextUtils.isEmpty(aa.getString("accountUuids", null)))
        {
          a(paramContext, (SQLiteDatabase)localObject2);
          aa.edit().remove("accountUuids").apply();
          cvm.d(a, "Created new EmailProvider backup database", new Object[0]);
          a(v, "Message_Deletes");
          a(v, "Mailbox", "accountKey", "_id", "Account");
          a(v, "Message", "accountKey", "_id", "Account");
          a(v, "Policy", "_id", "policyKey", "Account");
          a(v);
          v.execSQL("UPDATE Mailbox SET uiSyncStatus=0");
          g();
          paramContext = v;
          return paramContext;
        }
      }
      if (paramContext.getDatabasePath("EmailProviderBackup.db").exists())
      {
        a(paramContext, (SQLiteDatabase)localObject2);
        paramContext.deleteDatabase("EmailProviderBackup.db");
        cvm.d(a, "Migrated from backup database to account manager", new Object[0]);
      }
      else if (DatabaseUtils.longForQuery((SQLiteDatabase)localObject2, "SELECT EXISTS (SELECT ? FROM Account)", bdv.B) > 0L)
      {
        cvm.d(a, "restoreIfNeeded: Account exists.", new Object[0]);
      }
      else
      {
        d(paramContext);
      }
    }
  }
  
  public static Uri c(long paramLong)
  {
    return a(paramLong, "incoming");
  }
  
  private static Folder c(Context paramContext, long paramLong)
  {
    Object localObject = null;
    Cursor localCursor = paramContext.getContentResolver().query(a("uifolder", paramLong), chh.i, null, null, null);
    if (localCursor == null)
    {
      cvm.e(a, "Null folder cursor for mailboxId %d", new Object[] { Long.valueOf(paramLong) });
      return null;
    }
    paramContext = (Context)localObject;
    try
    {
      if (localCursor.moveToFirst()) {
        paramContext = new Folder(localCursor);
      }
      return paramContext;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  private static String c(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return paramString1;
    }
    return String.valueOf(paramString1).length() + 7 + String.valueOf(paramString2).length() + paramString1 + " AND (" + paramString2 + ")";
  }
  
  private static String c(String[] paramArrayOfString)
  {
    paramArrayOfString = a(n(), paramArrayOfString);
    paramArrayOfString.append(" FROM Mailbox WHERE ");
    paramArrayOfString.append("accountKey=?");
    paramArrayOfString.append(" AND type<64 AND type!=8 AND isDeleted=0 AND parentKey<0 AND lastTouchedTime>0 ORDER BY lastTouchedTime DESC");
    return paramArrayOfString.toString();
  }
  
  private final void c(String paramString, long paramLong)
  {
    a(i, paramString);
    a(B, paramString);
    if (paramLong != -1L) {
      a(C, paramLong);
    }
    a(B, 1152921504606846976L);
    a(C, 268435456L);
    try
    {
      if (ab == null) {
        ab = new Handler(Looper.getMainLooper(), new azd(this));
      }
      ab.removeMessages(0);
      Message localMessage = Message.obtain(ab, 0);
      obj = paramString;
      ab.sendMessageDelayed(localMessage, 2000L);
      return;
    }
    finally {}
  }
  
  private final Uri[] c(String paramString)
  {
    int i1 = 0;
    Uri[] arrayOfUri = new Uri[0];
    Object localObject = c(getContext());
    if (paramString.equals(Z)) {
      paramString = arrayOfUri;
    }
    for (;;)
    {
      return paramString;
      StringBuilder localStringBuilder = a(n(), new String[] { "_id", "type" });
      localStringBuilder.append(" FROM Mailbox WHERE accountKey").append('=').append(paramString).append(" AND type IN (5").append(", 3, 9").append(", 11)");
      cvm.b(a, "defaultRecentFolders: Query is %s", new Object[] { localStringBuilder });
      localObject = ((SQLiteDatabase)localObject).rawQuery(localStringBuilder.toString(), null);
      if (localObject != null) {}
      try
      {
        boolean bool;
        if (((Cursor)localObject).getCount() > 0)
        {
          bool = ((Cursor)localObject).moveToFirst();
          if (bool) {}
        }
        else
        {
          paramString = arrayOfUri;
          return arrayOfUri;
        }
        arrayOfUri = new Uri[((Cursor)localObject).getCount()];
        do
        {
          long l1 = ((Cursor)localObject).getLong(0);
          arrayOfUri[i1] = a("uifolder", l1);
          cvm.b(a, "Default recent folder: %d, with uri %s", new Object[] { Long.valueOf(l1), arrayOfUri[i1] });
          i1 += 1;
          bool = ((Cursor)localObject).moveToNext();
        } while (bool);
        paramString = arrayOfUri;
        return arrayOfUri;
      }
      finally
      {
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
  }
  
  private static int d(Context paramContext)
  {
    Object localObject1 = bam.c(paramContext);
    Object localObject2 = new HashSet(3);
    localObject1 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (ban)((Iterator)localObject1).next();
      if (!TextUtils.isEmpty(c)) {
        ((Set)localObject2).add(c);
      }
    }
    Object localObject3 = new ArrayList();
    localObject1 = AccountManager.get(paramContext);
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject3).addAll(Arrays.asList(((AccountManager)localObject1).getAccountsByType((String)((Iterator)localObject2).next())));
    }
    localObject2 = ((List)localObject3).iterator();
    int i1 = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (android.accounts.Account)((Iterator)localObject2).next();
      Object localObject4 = ((AccountManager)localObject1).getUserData((android.accounts.Account)localObject3, "accountJson");
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        localObject4 = com.android.emailcommon.provider.Account.b((String)localObject4);
        if (localObject4 == null) {
          break label247;
        }
        atg.a(paramContext, (com.android.emailcommon.provider.Account)localObject4);
        localObject4 = new Bundle(3);
        ((Bundle)localObject4).putBoolean("force", true);
        ((Bundle)localObject4).putBoolean("do_not_retry", true);
        ((Bundle)localObject4).putBoolean("expedited", true);
        ContentResolver.requestSync((android.accounts.Account)localObject3, bdv.F, (Bundle)localObject4);
        i1 += 1;
      }
    }
    label247:
    for (;;)
    {
      break;
      return i1;
    }
  }
  
  /* Error */
  private final int d(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   4: astore 9
    //   6: aload_1
    //   7: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   10: invokestatic 552	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   13: lstore_3
    //   14: aload_0
    //   15: aload 9
    //   17: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   20: astore_1
    //   21: ldc_w 2307
    //   24: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   27: astore 10
    //   29: new 189	java/lang/StringBuilder
    //   32: dup
    //   33: aload 10
    //   35: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   38: invokevirtual 193	java/lang/String:length	()I
    //   41: bipush 20
    //   43: iadd
    //   44: invokespecial 194	java/lang/StringBuilder:<init>	(I)V
    //   47: aload 10
    //   49: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: lload_3
    //   53: invokevirtual 1002	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   56: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore 10
    //   61: aload_1
    //   62: ldc 126
    //   64: iconst_1
    //   65: anewarray 106	java/lang/String
    //   68: dup
    //   69: iconst_0
    //   70: ldc_w 354
    //   73: aastore
    //   74: aload 10
    //   76: aconst_null
    //   77: aconst_null
    //   78: aconst_null
    //   79: aconst_null
    //   80: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 10
    //   85: aload 10
    //   87: ifnull +13 -> 100
    //   90: aload 10
    //   92: invokeinterface 568 1 0
    //   97: ifne +38 -> 135
    //   100: getstatic 434	cvm:a	Ljava/lang/String;
    //   103: ldc_w 2736
    //   106: iconst_1
    //   107: anewarray 157	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: lload_3
    //   113: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   116: aastore
    //   117: invokestatic 2738	cvm:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   120: pop
    //   121: aload 10
    //   123: ifnull +10 -> 133
    //   126: aload 10
    //   128: invokeinterface 442 1 0
    //   133: iconst_0
    //   134: ireturn
    //   135: aload 10
    //   137: aload 10
    //   139: ldc_w 354
    //   142: invokeinterface 660 2 0
    //   147: invokeinterface 668 2 0
    //   152: lstore 5
    //   154: aload 10
    //   156: ifnull +10 -> 166
    //   159: aload 10
    //   161: invokeinterface 442 1 0
    //   166: ldc_w 2740
    //   169: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   172: astore 10
    //   174: new 189	java/lang/StringBuilder
    //   177: dup
    //   178: aload 10
    //   180: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   183: invokevirtual 193	java/lang/String:length	()I
    //   186: bipush 20
    //   188: iadd
    //   189: invokespecial 194	java/lang/StringBuilder:<init>	(I)V
    //   192: aload 10
    //   194: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: lload_3
    //   198: invokevirtual 1002	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   201: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: astore 10
    //   206: aload_1
    //   207: ldc -128
    //   209: iconst_1
    //   210: anewarray 106	java/lang/String
    //   213: dup
    //   214: iconst_0
    //   215: ldc 108
    //   217: aastore
    //   218: aload 10
    //   220: aconst_null
    //   221: aconst_null
    //   222: aconst_null
    //   223: aconst_null
    //   224: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   227: astore_1
    //   228: iconst_0
    //   229: istore_2
    //   230: aload_1
    //   231: ifnull +97 -> 328
    //   234: aload_1
    //   235: invokeinterface 419 1 0
    //   240: ifeq +88 -> 328
    //   243: aload_1
    //   244: aload_1
    //   245: ldc 108
    //   247: invokeinterface 660 2 0
    //   252: invokeinterface 668 2 0
    //   257: lstore 7
    //   259: aload 9
    //   261: lload 5
    //   263: lload 7
    //   265: invokestatic 2548	bgt:b	(Landroid/content/Context;JJ)V
    //   268: iload_2
    //   269: aload 9
    //   271: invokevirtual 500	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   274: getstatic 1513	beb:c	Landroid/net/Uri;
    //   277: lload 7
    //   279: invokestatic 674	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   282: aconst_null
    //   283: aconst_null
    //   284: invokevirtual 2551	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   287: iadd
    //   288: istore_2
    //   289: aload_0
    //   290: lload 7
    //   292: invokevirtual 1496	com/android/email/provider/EmailProvider:a	(J)V
    //   295: goto -65 -> 230
    //   298: astore 9
    //   300: aload_1
    //   301: ifnull +9 -> 310
    //   304: aload_1
    //   305: invokeinterface 442 1 0
    //   310: aload 9
    //   312: athrow
    //   313: astore_1
    //   314: aload 10
    //   316: ifnull +10 -> 326
    //   319: aload 10
    //   321: invokeinterface 442 1 0
    //   326: aload_1
    //   327: athrow
    //   328: aload_1
    //   329: ifnull +9 -> 338
    //   332: aload_1
    //   333: invokeinterface 442 1 0
    //   338: aload_0
    //   339: lload_3
    //   340: lload 5
    //   342: invokespecial 1499	com/android/email/provider/EmailProvider:a	(JJ)V
    //   345: iload_2
    //   346: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	EmailProvider
    //   0	347	1	paramUri	Uri
    //   229	117	2	i1	int
    //   13	327	3	l1	long
    //   152	189	5	l2	long
    //   257	34	7	l3	long
    //   4	266	9	localContext	Context
    //   298	13	9	localObject1	Object
    //   27	293	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   234	295	298	finally
    //   90	100	313	finally
    //   100	121	313	finally
    //   135	154	313	finally
  }
  
  private static String d(String paramString1, String paramString2)
  {
    String str = String.valueOf(bdv.F);
    return String.valueOf(str).length() + 18 + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + "'content://" + str + "/" + paramString1 + "/' || " + paramString2;
  }
  
  private static String d(String[] paramArrayOfString)
  {
    paramArrayOfString = a(n(), paramArrayOfString);
    paramArrayOfString.append(" FROM Mailbox WHERE parentKey=? ORDER BY ");
    paramArrayOfString.append("CASE type WHEN 0 THEN 0 WHEN 3 THEN 1 WHEN 4 THEN 2 WHEN 5 THEN 3 WHEN 6 THEN 4 WHEN 7 THEN 5 ELSE 10 END ,displayName COLLATE LOCALIZED ASC");
    return paramArrayOfString.toString();
  }
  
  private static void d(Context paramContext, long paramLong)
  {
    String str = bhn.b(paramContext, com.android.emailcommon.provider.Account.a, ad, "_id=?", new String[] { Long.toString(paramLong) });
    if (str == null) {
      cvm.e(a, "Could not find email address for account %d", new Object[] { Long.valueOf(paramLong) });
    }
    bgt.c(paramContext, paramLong);
    ContentResolver localContentResolver = paramContext.getContentResolver();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(paramLong);
    localContentResolver.delete(Mailbox.a, "accountKey=?", arrayOfString);
    ContentValues localContentValues = new ContentValues();
    localContentValues.putNull("syncKey");
    localContentResolver.update(com.android.emailcommon.provider.Account.a, localContentValues, "_id=?", arrayOfString);
    if (str != null)
    {
      paramContext = bam.a(paramContext, paramLong);
      if (paramContext == null) {}
    }
    try
    {
      paramContext.a(str);
      return;
    }
    catch (RemoteException paramContext) {}
  }
  
  private static String e(String paramString1, String paramString2)
  {
    String str = String.valueOf(bdv.F);
    return String.valueOf(str).length() + 22 + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + "'content://" + str + "/" + paramString1 + "/' || " + paramString2 + "._id";
  }
  
  private final void e(Uri paramUri)
  {
    paramUri = paramUri.getLastPathSegment();
    paramUri = beb.a(getContext(), Long.parseLong(paramUri));
    if (paramUri != null) {
      h(U);
    }
  }
  
  private static String[] e(String[] paramArrayOfString)
  {
    if (hfd.a(paramArrayOfString).contains("unreadSenders")) {
      return chh.j;
    }
    return chh.i;
  }
  
  private final Cursor f(Uri paramUri)
  {
    long l1 = Long.parseLong(paramUri.getLastPathSegment());
    if (g(l1))
    {
      int i1 = (int)(l1 & 0xF);
      paramUri = Mailbox.b(getContext(), i1);
      int i2 = paramUri.length;
      i1 = 0;
      while (i1 < i2)
      {
        b(paramUri[i1], 0);
        i1 += 1;
      }
      return null;
    }
    return b(Mailbox.a(getContext(), l1), 0);
  }
  
  private final Cursor f(String[] paramArrayOfString)
  {
    if (!p.isEmpty()) {
      try
      {
        int i1 = p.size();
        cvp localcvp = new cvp(new String[] { "conversationUri" }, i1);
        Iterator localIterator = p.iterator();
        while (localIterator.hasNext())
        {
          localcvp.addRow(new String[] { ((ContentProviderOperation)localIterator.next()).getUri().toString() });
          continue;
          return new cvp(paramArrayOfString, 0);
        }
      }
      catch (OperationApplicationException localOperationApplicationException)
      {
        cvm.b(a, localOperationApplicationException, "applyBatch exception", new Object[0]);
      }
    }
    applyBatch(p);
    p.clear();
    return localOperationApplicationException;
  }
  
  private static String f(String paramString1, String paramString2)
  {
    return X.buildUpon().appendPath(paramString1).appendQueryParameter("account", paramString2).build().toString();
  }
  
  private static boolean f(long paramLong)
  {
    return paramLong >= 4294967296L;
  }
  
  private final int g(Uri paramUri)
  {
    Context localContext = getContext();
    long l1 = Long.parseLong(paramUri.getLastPathSegment());
    try
    {
      if (com.android.emailcommon.provider.Account.a(localContext, l1) == null) {
        return 0;
      }
      d(localContext, l1);
      paramUri = ContentUris.withAppendedId(com.android.emailcommon.provider.Account.a, l1);
      localContext.getContentResolver().delete(paramUri, null, null);
      ayh.a(localContext);
      paramUri = SecurityPolicy.a(localContext);
      cvm.b("Email", "reducePolicies", new Object[0]);
      paramUri.b();
      b(localContext);
      return 1;
    }
    catch (Exception paramUri)
    {
      cvm.d(a, paramUri, "Exception while deleting account", new Object[0]);
    }
    return 0;
  }
  
  private static String g(String paramString1, String paramString2)
  {
    return Y.buildUpon().appendPath(paramString1).appendQueryParameter("account", paramString2).build().toString();
  }
  
  private final void g()
  {
    Context localContext = getContext();
    String str = localContext.getString(arh.cm);
    Cursor localCursor = v.query("Account", new String[] { "hostAuthKeyRecv" }, null, null, null, null, null);
    if (localCursor != null) {}
    try
    {
      int i1 = localCursor.getColumnIndex("hostAuthKeyRecv");
      while (localCursor.moveToNext())
      {
        HostAuth localHostAuth = HostAuth.a(localContext, localCursor.getInt(i1));
        if ((localHostAuth != null) && (TextUtils.equals(str, b)))
        {
          localContext = getContext();
          cvm.b(bap.a, "setupBackgroundPurge", new Object[0]);
          bap.b.a(localContext);
        }
      }
      return;
    }
    catch (SQLException localSQLException)
    {
      cvm.d(a, localSQLException, "exception starting IMAP purge", new Object[0]);
      return;
    }
    finally
    {
      if (localCursor != null) {
        localCursor.close();
      }
    }
  }
  
  private static boolean g(long paramLong)
  {
    return paramLong >> 32 == 268435456L;
  }
  
  private static Handler h()
  {
    try
    {
      if (u == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("EmailProvider thread");
        t = localHandlerThread;
        localHandlerThread.start();
        u = new Handler(t.getLooper());
      }
      return u;
    }
    finally {}
  }
  
  private static String h(String paramString1, String paramString2)
  {
    String str = String.valueOf(bdv.F);
    return String.valueOf(str).length() + 12 + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + "content://" + str + "/" + paramString1 + "/" + paramString2;
  }
  
  /* Error */
  private final void h(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 1025	com/android/email/provider/EmailProvider:i	Landroid/net/Uri;
    //   4: lload_1
    //   5: invokestatic 350	java/lang/Long:toString	(J)Ljava/lang/String;
    //   8: invokevirtual 538	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   15: lload_1
    //   16: invokestatic 1508	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Mailbox;
    //   19: astore 7
    //   21: aload 7
    //   23: ifnonnull +25 -> 48
    //   26: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   29: ldc_w 2838
    //   32: iconst_1
    //   33: anewarray 157	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: lload_1
    //   39: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   42: aastore
    //   43: invokestatic 813	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   46: pop
    //   47: return
    //   48: aload 7
    //   50: getfield 1375	com/android/emailcommon/provider/Mailbox:h	I
    //   53: ifne +16 -> 69
    //   56: aload_0
    //   57: getstatic 1025	com/android/email/provider/EmailProvider:i	Landroid/net/Uri;
    //   60: ldc2_w 2051
    //   63: invokestatic 350	java/lang/Long:toString	(J)Ljava/lang/String;
    //   66: invokevirtual 538	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Ljava/lang/String;)V
    //   69: aload_0
    //   70: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   73: astore 7
    //   75: aload_0
    //   76: getfield 2840	com/android/email/provider/EmailProvider:ag	Landroid/appwidget/AppWidgetManager;
    //   79: ifnonnull +33 -> 112
    //   82: aload_0
    //   83: aload 7
    //   85: invokestatic 2846	android/appwidget/AppWidgetManager:getInstance	(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;
    //   88: putfield 2840	com/android/email/provider/EmailProvider:ag	Landroid/appwidget/AppWidgetManager;
    //   91: aload_0
    //   92: new 2508	android/content/ComponentName
    //   95: dup
    //   96: aload 7
    //   98: aload 7
    //   100: getstatic 2851	buj:fH	I
    //   103: invokevirtual 713	android/content/Context:getString	(I)Ljava/lang/String;
    //   106: invokespecial 2852	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   109: putfield 2854	com/android/email/provider/EmailProvider:ah	Landroid/content/ComponentName;
    //   112: aload_0
    //   113: getfield 2840	com/android/email/provider/EmailProvider:ag	Landroid/appwidget/AppWidgetManager;
    //   116: aload_0
    //   117: getfield 2854	com/android/email/provider/EmailProvider:ah	Landroid/content/ComponentName;
    //   120: invokevirtual 2858	android/appwidget/AppWidgetManager:getAppWidgetIds	(Landroid/content/ComponentName;)[I
    //   123: astore 8
    //   125: aload 8
    //   127: aload_0
    //   128: getfield 394	com/android/email/provider/EmailProvider:ae	[I
    //   131: invokestatic 2861	java/util/Arrays:equals	([I[I)Z
    //   134: ifne +197 -> 331
    //   137: aload_0
    //   138: aload 8
    //   140: putfield 394	com/android/email/provider/EmailProvider:ae	[I
    //   143: aload 7
    //   145: aload 8
    //   147: invokestatic 2866	cxi:a	(Landroid/content/Context;[I)[[Ljava/lang/String;
    //   150: astore 8
    //   152: aload_0
    //   153: getfield 396	com/android/email/provider/EmailProvider:af	Ljava/util/ArrayList;
    //   156: invokevirtual 2224	java/util/ArrayList:clear	()V
    //   159: aload 8
    //   161: arraylength
    //   162: istore 4
    //   164: iconst_0
    //   165: istore_3
    //   166: iload_3
    //   167: iload 4
    //   169: if_icmpge +162 -> 331
    //   172: aload 8
    //   174: iload_3
    //   175: aaload
    //   176: astore 9
    //   178: aload 9
    //   180: ifnull +210 -> 390
    //   183: aload 9
    //   185: iconst_1
    //   186: aaload
    //   187: invokestatic 757	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   190: ifeq +6 -> 196
    //   193: goto +197 -> 390
    //   196: aload 9
    //   198: iconst_1
    //   199: aaload
    //   200: invokestatic 337	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   203: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   206: invokestatic 552	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   209: lstore 5
    //   211: lload 5
    //   213: invokestatic 995	com/android/email/provider/EmailProvider:g	(J)Z
    //   216: ifne +186 -> 402
    //   219: aload_0
    //   220: getfield 396	com/android/email/provider/EmailProvider:af	Ljava/util/ArrayList;
    //   223: lload 5
    //   225: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   228: invokevirtual 2070	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   231: ifne +159 -> 390
    //   234: aload_0
    //   235: getfield 396	com/android/email/provider/EmailProvider:af	Ljava/util/ArrayList;
    //   238: lload 5
    //   240: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   243: invokevirtual 1444	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   246: pop
    //   247: goto +143 -> 390
    //   250: aload_0
    //   251: getstatic 2337	com/android/emailcommon/provider/Mailbox:a	Landroid/net/Uri;
    //   254: getstatic 2072	com/android/emailcommon/provider/Mailbox:B	[Ljava/lang/String;
    //   257: ldc_w 2868
    //   260: iconst_1
    //   261: anewarray 106	java/lang/String
    //   264: dup
    //   265: iconst_0
    //   266: iconst_0
    //   267: invokestatic 2028	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   270: aastore
    //   271: aconst_null
    //   272: invokevirtual 565	com/android/email/provider/EmailProvider:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   275: astore 9
    //   277: aload 9
    //   279: invokeinterface 419 1 0
    //   284: ifeq +37 -> 321
    //   287: aload_0
    //   288: getfield 396	com/android/email/provider/EmailProvider:af	Ljava/util/ArrayList;
    //   291: aload 9
    //   293: iconst_0
    //   294: invokeinterface 668 2 0
    //   299: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   302: invokevirtual 1444	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   305: pop
    //   306: goto -29 -> 277
    //   309: astore 10
    //   311: aload 9
    //   313: invokeinterface 442 1 0
    //   318: aload 10
    //   320: athrow
    //   321: aload 9
    //   323: invokeinterface 442 1 0
    //   328: goto +62 -> 390
    //   331: aload_0
    //   332: getfield 396	com/android/email/provider/EmailProvider:af	Ljava/util/ArrayList;
    //   335: lload_1
    //   336: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   339: invokevirtual 2070	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   342: ifeq -295 -> 47
    //   345: new 580	android/content/Intent
    //   348: dup
    //   349: ldc_w 2870
    //   352: invokespecial 2089	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   355: astore 8
    //   357: aload 8
    //   359: ldc_w 2128
    //   362: ldc_w 2050
    //   365: lload_1
    //   366: invokestatic 558	com/android/email/provider/EmailProvider:a	(Ljava/lang/String;J)Landroid/net/Uri;
    //   369: invokevirtual 591	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   372: pop
    //   373: aload 8
    //   375: getstatic 2000	com/android/email/provider/EmailProvider:b	Ljava/lang/String;
    //   378: invokevirtual 2874	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
    //   381: pop
    //   382: aload 7
    //   384: aload 8
    //   386: invokevirtual 2092	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   389: return
    //   390: iload_3
    //   391: iconst_1
    //   392: iadd
    //   393: istore_3
    //   394: goto -228 -> 166
    //   397: astore 9
    //   399: goto -9 -> 390
    //   402: lload 5
    //   404: ldc2_w 977
    //   407: land
    //   408: l2i
    //   409: tableswitch	default:+19->428, 0:+-159->250
    //   428: goto -38 -> 390
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	EmailProvider
    //   0	431	1	paramLong	long
    //   165	229	3	i1	int
    //   162	8	4	i2	int
    //   209	194	5	l1	long
    //   19	364	7	localObject1	Object
    //   123	262	8	localObject2	Object
    //   176	146	9	localCursor	Cursor
    //   397	1	9	localNumberFormatException	NumberFormatException
    //   309	10	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   277	306	309	finally
    //   183	193	397	java/lang/NumberFormatException
    //   196	247	397	java/lang/NumberFormatException
    //   250	277	397	java/lang/NumberFormatException
    //   311	321	397	java/lang/NumberFormatException
    //   321	328	397	java/lang/NumberFormatException
  }
  
  private final android.accounts.Account i(long paramLong)
  {
    Context localContext = getContext();
    com.android.emailcommon.provider.Account localAccount = com.android.emailcommon.provider.Account.a(localContext, paramLong);
    if (localAccount == null) {
      return null;
    }
    return a(localContext, d, localAccount.f(localContext));
  }
  
  private final void i()
  {
    try
    {
      if (!z)
      {
        Context localContext = getContext();
        a(localContext);
        if (localContext.getResources().getBoolean(ara.d)) {
          h().post(new ayw(localContext));
        }
        x.a(h(), localContext, c(getContext()));
        cfm.a(localContext, this);
        z = true;
      }
      return;
    }
    finally {}
  }
  
  private final void j()
  {
    synchronized (m)
    {
      if (v != null) {
        v = null;
      }
      if (w != null) {
        w = null;
      }
      File localFile1 = getContext().getDatabasePath("EmailProvider.db");
      File localFile2 = getContext().getDatabasePath("EmailProviderBody.db");
      if ((localFile1.exists()) && (!localFile2.exists()))
      {
        cvm.d(a, "Deleting orphaned EmailProvider database...", new Object[0]);
        getContext().deleteDatabase("EmailProvider.db");
      }
      while ((!localFile2.exists()) || (localFile1.exists())) {
        return;
      }
      cvm.d(a, "Deleting orphaned EmailProviderBody database...", new Object[0]);
      getContext().deleteDatabase("EmailProviderBody.db");
    }
  }
  
  private final Set<Uri> k()
  {
    return (Set)M.get();
  }
  
  private static any l()
  {
    if (P == null) {
      P = new anz().a("_id", "_id").a("conversationUri", d("uimessage", "_id")).a("messageListUri", d("uimessage", "_id")).a("subject", "subject").a("snippet", "snippet").a("conversationInfo", null).a("dateReceivedMs", "timeStamp").a("hasAttachments", "flagAttachment").a("numMessages", "1").a("numDrafts", "0").a("sendingState", "CASE WHEN (SELECT Mailbox.type FROM Mailbox WHERE Mailbox._id=Message.mailboxKey)=4 THEN (CASE WHEN Message.nextRetryTime=9223372036854775807 THEN -1 ELSE (CASE WHEN (SELECT Mailbox.uiSyncStatus FROM Mailbox WHERE Mailbox._id=Message.mailboxKey)=0 THEN 1 ELSE 2 END) END) ELSE 0 END").a("importance", Integer.toString(0)).a("read", "flagRead").a("seen", "flagSeen").a("starred", "flagFavorite").a("conversationFlags", "CASE WHEN (flags&4) !=0 THEN 16 ELSE 0 END + CASE WHEN (flags&524288) !=0 THEN 8 ELSE 0 END + CASE WHEN (flags&262144) !=0 THEN 4 ELSE 0 END").a("accountUri", d("uiaccount", "accountKey")).a("senderInfo", "fromList").a("orderKey", "timeStamp").a("promoteCalendar", null).a("unsubscribeState", "0").a("unsubscribeSenderName", null).a("unsubscribeSenderIdentifier", null).a("priority", "priority").a("reportSpamSuggestion", "0").a("canReportNotSuspicious", "0").a();
    }
    return P;
  }
  
  private static any m()
  {
    if (Q == null) {
      Q = new anz().a("_id", "Message._id").a("serverMessageId", "syncServerId").a("messageUri", e("uimessage", "Message")).a("conversationId", e("uimessage", "Message")).a("subject", "subject").a("snippet", "snippet").a("fromAddress", "fromList").a("toAddresses", "toList").a("ccAddresses", "ccList").a("bccAddresses", "bccList").a("replyToAddress", "replyToList").a("dateReceivedMs", "timeStamp").a("bodyHtml", null).a("bodyText", null).a("refMessageId", "0").a("appendRefMessageContent", "0").a("hasAttachments", "flagAttachment").a("attachmentListUri", e("uiattachments", "Message")).a("attachmentByCidUri", e("uiattachmentbycid", "Message")).a("messageFlags", "CASE WHEN (flags&4) !=0 THEN 16 ELSE 0 END").a("draftType", "CASE WHEN (flags&4194304) !=0 THEN 0 WHEN (flags&1048576) !=0 THEN 1 WHEN (flags&2097152) !=0 THEN 3 WHEN (flags&1) !=0 THEN 2 WHEN (flags&2) !=0 THEN 4 WHEN (flags&8388608) != 0 THEN 5 WHEN (flags&16777216) != 0 THEN 6 ELSE 0 END").a("messageAccountUri", d("uiaccount", "accountKey")).a("starred", "flagFavorite").a("read", "flagRead").a("seen", "flagSeen").a("spamWarningString", null).a("spamWarningLevel", Integer.toString(0)).a("spamWarningLinkType", Integer.toString(0)).a("clipped", "CASE flagLoaded WHEN 2 THEN 2 WHEN 5 THEN 3 ELSE 0 END").a("permalink", null).a("senderBlocked", "0").a("unsubscribeSenderIdentifier", null).a("encryptionStatus", "0").a("signingStatus", "0").a("tlsStatus", "0").a("clientDomain", null).a("priority", "priority").a("eventUid", "eventUid").a("eventTitle", "eventSubject").a("startTime", "eventStartTime").a("endTime", "eventEndTime").a("allDay", "0").a("location", null).a("organizer", null).a("attendees", null).a("recurrenceRule", "eventRecurrenceRule").a("icalMethod", "8").a("responder", null).a("responderStatus", "0").a("syncId", null).a("meetingResponseComment", "meetingResponseComment").a("proposedStartTime", "proposedStartTime").a("proposedEndTime", "proposedEndTime").a("showUnauthWarning", "0").a("proposedTimeFetchStatus", "CASE WHEN (flagsEas&64) != 0 THEN 4 WHEN (flagsEas&32) != 0 THEN 3 WHEN (flagsEas&16) != 0 THEN 2 WHEN (flagsEas&8) != 0 THEN 1 ELSE 0 END").a("meetingInfo", "meetingInfo").a("spamReason", null).a("proposeTimeFromMailRefMessageUri", "proposeTimeFromMailRefMessageUri").a("proposeTimeFromMailRsvp", "proposeTimeFromMailRsvp").a("proposeTimeFromMailProposedStartTime", "proposeTimeFromMailProposedStartTime").a("proposeTimeFromMailProposedEndTime", "proposeTimeFromMailProposedEndTime").a();
    }
    return Q;
  }
  
  private static any n()
  {
    if (T == null)
    {
      anz localanz = new anz().a("_id", "_id").a("persistentId", "serverId").a("folderUri", d("uifolder", "_id")).a("name", "displayName").a("hasChildren", "flags&1").a("capabilities", "CASE WHEN (flags&16) !=0 THEN 1 ELSE 0 END").a("syncWindow", "3").a("conversationListUri", d("uimessages", "_id")).a("childFoldersListUri", d("uisubfolders", "_id")).a("unreadCount", "unreadCount").a("totalCount", "CASE WHEN totalCount<0 OR type=3 OR type=4 OR type=6 THEN messageCount ELSE totalCount END").a("refreshUri", d("uirefresh", "_id")).a("syncStatus", "uiSyncStatus").a("lastSyncResult", "uiLastSyncResult").a("type", R).a("iconResId", S).a("loadMoreUri", d("uiloadmore", "_id")).a("hierarchicalDesc", "hierarchicalName");
      String str1 = String.valueOf("case when parentKey=-1 then NULL else ");
      String str2 = String.valueOf(d("uifolder", "parentKey"));
      T = localanz.a("parentUri", String.valueOf(str1).length() + 4 + String.valueOf(str2).length() + str1 + str2 + " end").a("unreadSenders", "(SELECT group_concat(fromList) FROM (SELECT fromList FROM Message WHERE mailboxKey=Mailbox._id AND flagRead=0 GROUP BY fromList ORDER BY timeStamp DESC))").a();
    }
    return T;
  }
  
  private static any o()
  {
    if (V == null)
    {
      anz localanz = new anz().a("quickResponse", "quickResponse");
      String str1 = String.valueOf(h("quickresponse", ""));
      String str2 = String.valueOf("_id");
      V = localanz.a("uri", String.valueOf(str1).length() + 4 + String.valueOf(str2).length() + "'" + str1 + "'||" + str2).a();
    }
    return V;
  }
  
  private static any p()
  {
    if (W == null) {
      W = new anz().a("_display_name", "fileName").a("_size", "size").a("uri", d("uiattachment", "_id")).a("contentType", "mimeType").a("state", "uiState").a("destination", "uiDestination").a("downloadedSize", "uiDownloadedSize").a("contentUri", "contentUri").a("flags", "flags").a("type", Integer.toString(0)).a("hasPreview", "0").a();
    }
    return W;
  }
  
  private static String q()
  {
    String str = String.format("%s/' || %s || '/' || %s || '/%s", new Object[] { com.android.emailcommon.provider.Attachment.d, "accountKey", "_id", "RAW" });
    return String.valueOf(str).length() + 85 + "@CASE WHEN contentUri IS NULL THEN '" + str + "' WHEN contentUri IS NOT NULL THEN contentUri END";
  }
  
  private final Handler r()
  {
    try
    {
      if (A == null) {
        A = new Handler(getContext().getMainLooper(), new ayx(this));
      }
      Handler localHandler = A;
      return localHandler;
    }
    finally {}
  }
  
  public final com.android.mail.providers.Account a(Uri paramUri)
  {
    long l1 = Long.parseLong((String)paramUri.getPathSegments().get(1));
    paramUri = com.android.emailcommon.provider.Account.a(getContext(), l1);
    return ctl.a(getContext(), d);
  }
  
  public final void a()
  {
    e().beginTransactionNonExclusive();
  }
  
  public final void a(long paramLong)
  {
    a(H, paramLong);
  }
  
  public final void a(Uri paramUri, String paramString)
  {
    Uri localUri = paramUri;
    if (paramString != null) {
      localUri = paramUri.buildUpon().appendPath(paramString).build();
    }
    paramUri = k();
    if (paramUri != null)
    {
      paramUri.add(localUri);
      return;
    }
    getContext().getContentResolver().notifyChange(localUri, null, false);
  }
  
  public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> paramArrayList)
  {
    a(new HashSet());
    Context localContext = getContext();
    Object localObject = c(localContext);
    ((SQLiteDatabase)localObject).beginTransaction();
    try
    {
      paramArrayList = super.applyBatch(paramArrayList);
      ((SQLiteDatabase)localObject).setTransactionSuccessful();
      Uri localUri;
      return paramArrayList;
    }
    finally
    {
      ((SQLiteDatabase)localObject).endTransaction();
      localObject = k();
      a(null);
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localUri = (Uri)((Iterator)localObject).next();
          localContext.getContentResolver().notifyChange(localUri, null);
        }
      }
    }
  }
  
  public final int b(long paramLong, String paramString)
  {
    Object localObject = beb.a(getContext(), paramLong);
    if (localObject == null) {
      return 0;
    }
    Context localContext = getContext();
    long l1 = U;
    switch (bhn.a(localContext, ContentUris.withAppendedId(Mailbox.a, l1), Mailbox.P, 0, Integer.valueOf(-1)).intValue())
    {
    default: 
      return 0;
    }
    localObject = new ContentValues(2);
    ((ContentValues)localObject).put("messageKey", Long.valueOf(paramLong));
    ((ContentValues)localObject).put("htmlContent", paramString);
    bds.a(getContext(), paramLong, (ContentValues)localObject);
    return 1;
  }
  
  public final void b()
  {
    e().setTransactionSuccessful();
  }
  
  public final void b(long paramLong)
  {
    a(D, Long.toString(paramLong));
    a(G, null);
  }
  
  public final void c()
  {
    e().endTransaction();
  }
  
  public Bundle call(String arg1, String paramString2, Bundle paramBundle)
  {
    i();
    cvm.b(a, "EmailProvider#call(%s, %s)", new Object[] { ???, paramString2 });
    if (??? == null) {
      return null;
    }
    int i1 = -1;
    switch (???.hashCode())
    {
    }
    for (;;)
    {
      switch (i1)
      {
      default: 
        cvm.f(a, "Unexpected Content provider method: %s", new Object[] { ??? });
        return null;
        if (???.equals("deviceFriendlyName"))
        {
          i1 = 0;
          continue;
          if (???.equals("eas_successful_sync_callback"))
          {
            i1 = 1;
            continue;
            if (???.equals("sync_snapshot"))
            {
              i1 = 2;
              continue;
              if (???.equals("sync_status"))
              {
                i1 = 3;
                continue;
                if (???.equals("fix_parent_keys"))
                {
                  i1 = 4;
                  continue;
                  if (???.equals("send_message"))
                  {
                    i1 = 5;
                    continue;
                    if (???.equals("save_message"))
                    {
                      i1 = 6;
                      continue;
                      if (???.equals("sync_message"))
                      {
                        i1 = 7;
                        continue;
                        if (???.equals("set_current_account")) {
                          i1 = 8;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    ??? = new Bundle(1);
    ???.putString("deviceFriendlyName", Build.MODEL);
    return (Bundle)???;
    Object localObject = getContext();
    String str = paramBundle.getString("eas_account_email");
    ayg localayg = ayg.a((Context)localObject, str);
    Cursor localCursor = azk.a(c((Context)localObject), str);
    ??? = null;
    paramString2 = null;
    if (localCursor != null) {
      ??? = paramString2;
    }
    for (;;)
    {
      try
      {
        if (localCursor.moveToFirst()) {
          ??? = new ExchangeOofSettings(localCursor);
        }
        localCursor.close();
        l1 = d.getLong("eas-oof-settings-next-sync-time", 0L);
        if (System.currentTimeMillis() >= l1)
        {
          i1 = 1;
          if ((i1 != 0) || ((??? != null) && (d)))
          {
            l1 = paramBundle.getLong("eas_account_id");
            bam.a((Context)localObject, l1).a(l1, ???);
          }
          if (y != null)
          {
            ??? = a((Context)localObject, str, ((Context)localObject).getString(arh.ck));
            y.b(c((Context)localObject), ???);
          }
          return null;
        }
      }
      finally
      {
        localCursor.close();
      }
      i1 = 0;
    }
    ??? = paramBundle.getString("snapshot_email_address");
    paramString2 = paramBundle.getString("snapshot_content");
    cfg.b(getContext(), ???).c(paramString2);
    return null;
    long l1 = paramBundle.getLong("id");
    i1 = paramBundle.getInt("status_code");
    ??? = ContentUris.withAppendedId(s, l1);
    cvm.b(a, "updateSyncStatus: %s", new Object[] { paramBundle });
    a(???, null);
    if (i1 == 1) {}
    for (i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        paramString2 = azv.a(getContext());
        synchronized (d)
        {
          if (d.containsKey(Long.valueOf(l1)))
          {
            cvm.b(azv.a, "RefreshStatusMonitor: setSyncStarted: mailboxId=%d", new Object[] { Long.valueOf(l1) });
            d.put(Long.valueOf(l1), Boolean.valueOf(true));
          }
        }
      }
      i1 = paramBundle.getInt("result");
      paramString2 = new ContentValues();
      paramString2.put("uiLastSyncResult", Integer.valueOf(i1));
      int i2 = chh.b(i1);
      ??? = Mailbox.a(getContext(), l1);
      if (??? != null)
      {
        ??? = String.format(Locale.US, "%s_%d", new Object[] { c, Integer.valueOf(h) });
        if (i2 != 6) {
          break label915;
        }
        buo.a().a("internal_error", String.valueOf(i1), ???, 0L);
        cvm.d(a, new Error(), "updateSyncStatus, lastSyncResult=%d, mailbox=%s", new Object[] { Integer.valueOf(i2), ??? });
      }
      for (;;)
      {
        c(getContext()).update("Mailbox", paramString2, "_id=?", new String[] { String.valueOf(l1) });
        break label1512;
        ??? = "empty_mailbox";
        break;
        label915:
        cvm.b(a, "updateSyncStatus, lastSyncResult=%d, mailbox=%s", new Object[] { Integer.valueOf(i2), ??? });
      }
      a(c(getContext()));
      return null;
      l1 = Long.parseLong((String)Uri.parse(paramString2).getPathSegments().get(1));
      i1 = -1;
      switch (???.hashCode())
      {
      default: 
        label1036:
        switch (i1)
        {
        }
        break;
      }
      for (;;)
      {
        ??? = null;
        if (??? == null) {
          break;
        }
        paramString2 = new Bundle(1);
        paramString2.putParcelable("messageUri", ???);
        return paramString2;
        if (!???.equals("send_message")) {
          break label1036;
        }
        i1 = 0;
        break label1036;
        if (!???.equals("save_message")) {
          break label1036;
        }
        i1 = 1;
        break label1036;
        if (!???.equals("sync_message")) {
          break label1036;
        }
        i1 = 2;
        break label1036;
        if (!???.equals("cancel_message_save")) {
          break label1036;
        }
        i1 = 3;
        break label1036;
        if (!???.equals("set_current_account")) {
          break label1036;
        }
        i1 = 4;
        break label1036;
        long l2;
        if (paramBundle.containsKey("_id"))
        {
          l2 = paramBundle.getLong("_id");
          ??? = beb.a(getContext(), l2);
          label1204:
          paramString2 = com.android.emailcommon.provider.Account.a(getContext(), l1);
          l2 = a(getContext(), paramString2);
          if (??? != null) {
            break label1274;
          }
          ??? = null;
        }
        for (;;)
        {
          agetContexta.edit().putLong("lastAccountUsed", l1).apply();
          break;
          ??? = new beb();
          break label1204;
          label1274:
          if ((l2 & 0x200) != 0L)
          {
            v |= 0x80;
            paramString2 = a(l1, 3);
            if (paramString2 == null)
            {
              ??? = null;
            }
            else
            {
              ??? = a(???, paramString2, paramBundle);
              a(Mailbox.a, null);
            }
          }
          else
          {
            paramString2 = a(l1, 4);
            if (paramString2 == null)
            {
              ??? = null;
            }
            else if (a(l1, 5) == null)
            {
              ??? = null;
            }
            else
            {
              paramString2 = a(???, paramString2, paramBundle);
              a(Mailbox.a, null);
              l2 = Mailbox.a(getContext(), l1, 3);
              ??? = paramString2;
              if (l2 != -1L)
              {
                a(l2, l1);
                ??? = paramString2;
              }
            }
          }
        }
        localObject = a(l1, 3);
        if (localObject == null) {}
        for (??? = null;; ??? = a(paramString2, (Mailbox)localObject, paramBundle))
        {
          break;
          ??? = null;
          if (paramBundle.containsKey("_id"))
          {
            l1 = paramBundle.getLong("_id");
            ??? = beb.a(getContext(), l1);
          }
          paramString2 = ???;
          if (??? == null) {
            paramString2 = new beb();
          }
        }
        cvm.b(a, "Unhandled (but expected) Content provider method: %s", new Object[] { ??? });
      }
      label1512:
      return null;
    }
  }
  
  public final ContentResolver d()
  {
    return getContext().getContentResolver();
  }
  
  public final String d(long paramLong)
  {
    return bds.d(getContext(), paramLong);
  }
  
  /* Error */
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4: astore 10
    //   6: new 189	java/lang/StringBuilder
    //   9: dup
    //   10: aload 10
    //   12: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   15: invokevirtual 193	java/lang/String:length	()I
    //   18: bipush 8
    //   20: iadd
    //   21: invokespecial 194	java/lang/StringBuilder:<init>	(I)V
    //   24: ldc_w 3311
    //   27: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload 10
    //   32: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_0
    //   37: aload_1
    //   38: ldc_w 3312
    //   41: invokespecial 3314	com/android/email/provider/EmailProvider:b	(Landroid/net/Uri;Ljava/lang/String;)I
    //   44: istore 6
    //   46: aload_0
    //   47: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   50: astore 12
    //   52: aload_0
    //   53: aload 12
    //   55: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   58: astore 11
    //   60: getstatic 150	com/android/email/provider/EmailProvider:k	Landroid/util/SparseArray;
    //   63: iload 6
    //   65: bipush 12
    //   67: ishr
    //   68: invokevirtual 3317	android/util/SparseArray:valueAt	(I)Ljava/lang/Object;
    //   71: checkcast 106	java/lang/String
    //   74: astore 13
    //   76: aload_1
    //   77: ldc_w 643
    //   80: iconst_0
    //   81: invokevirtual 647	android/net/Uri:getBooleanQueryParameter	(Ljava/lang/String;Z)Z
    //   84: istore 7
    //   86: iload 6
    //   88: sipush 8193
    //   91: if_icmpeq +11 -> 102
    //   94: iload 6
    //   96: sipush 8194
    //   99: if_icmpne +19 -> 118
    //   102: aload_1
    //   103: ldc_w 1260
    //   106: iconst_0
    //   107: invokevirtual 647	android/net/Uri:getBooleanQueryParameter	(Ljava/lang/String;Z)Z
    //   110: ifne +8 -> 118
    //   113: aload_0
    //   114: aload_1
    //   115: invokespecial 3319	com/android/email/provider/EmailProvider:e	(Landroid/net/Uri;)V
    //   118: iload 6
    //   120: lookupswitch	default:+124->244, 0:+573->693, 1:+573->693, 4096:+573->693, 4097:+573->693, 8192:+573->693, 8193:+573->693, 8194:+573->693, 8195:+494->614, 32771:+431->551, 32775:+470->590, 32781:+437->557, 32788:+476->596, 32797:+482->602, 32800:+488->608
    //   244: iconst_0
    //   245: istore 5
    //   247: iload 6
    //   249: lookupswitch	default:+227->476, 0:+805->1054, 1:+461->710, 4096:+805->1054, 4097:+461->710, 8192:+805->1054, 8193:+461->710, 8194:+461->710, 8196:+823->1072, 8197:+843->1092, 12288:+805->1054, 12289:+461->710, 12290:+728->977, 16384:+805->1054, 16385:+461->710, 20480:+805->1054, 20481:+461->710, 24576:+805->1054, 24577:+461->710, 28673:+461->710, 36864:+805->1054, 36865:+461->710, 40961:+461->710, 45056:+805->1054, 49152:+805->1054, 49153:+461->710, 57344:+863->1112, 57345:+863->1112
    //   476: aload_1
    //   477: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   480: astore_1
    //   481: new 828	java/lang/IllegalArgumentException
    //   484: dup
    //   485: new 189	java/lang/StringBuilder
    //   488: dup
    //   489: aload_1
    //   490: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   493: invokevirtual 193	java/lang/String:length	()I
    //   496: bipush 12
    //   498: iadd
    //   499: invokespecial 194	java/lang/StringBuilder:<init>	(I)V
    //   502: ldc_w 3321
    //   505: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload_1
    //   509: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokespecial 833	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   518: athrow
    //   519: astore_1
    //   520: iload 5
    //   522: istore 4
    //   524: iload 4
    //   526: istore 5
    //   528: aload_0
    //   529: invokespecial 2557	com/android/email/provider/EmailProvider:j	()V
    //   532: iload 4
    //   534: istore 5
    //   536: aload_1
    //   537: athrow
    //   538: astore_1
    //   539: iload 5
    //   541: ifeq +8 -> 549
    //   544: aload 11
    //   546: invokevirtual 3155	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   549: aload_1
    //   550: athrow
    //   551: aload_0
    //   552: aload_1
    //   553: invokespecial 2201	com/android/email/provider/EmailProvider:c	(Landroid/net/Uri;)I
    //   556: ireturn
    //   557: aload_0
    //   558: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   561: astore_2
    //   562: aload_1
    //   563: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   566: invokestatic 552	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   569: lstore 8
    //   571: aload_2
    //   572: lload 8
    //   574: invokestatic 1270	com/android/emailcommon/provider/Account:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Account;
    //   577: ifnonnull +5 -> 582
    //   580: iconst_0
    //   581: ireturn
    //   582: aload_2
    //   583: lload 8
    //   585: invokestatic 2777	com/android/email/provider/EmailProvider:d	(Landroid/content/Context;J)V
    //   588: iconst_1
    //   589: ireturn
    //   590: aload_0
    //   591: aload_1
    //   592: invokespecial 3323	com/android/email/provider/EmailProvider:g	(Landroid/net/Uri;)I
    //   595: ireturn
    //   596: aload_0
    //   597: aload_1
    //   598: invokespecial 3325	com/android/email/provider/EmailProvider:d	(Landroid/net/Uri;)I
    //   601: ireturn
    //   602: aload_0
    //   603: aload_1
    //   604: invokestatic 3330	cge:b	(Lcgf;Landroid/net/Uri;)I
    //   607: ireturn
    //   608: aload_0
    //   609: aload_1
    //   610: invokestatic 3332	cge:c	(Lcgf;Landroid/net/Uri;)I
    //   613: ireturn
    //   614: aload 11
    //   616: aload 13
    //   618: getstatic 3334	beb:k	[Ljava/lang/String;
    //   621: aload_2
    //   622: aload_3
    //   623: aconst_null
    //   624: aconst_null
    //   625: aconst_null
    //   626: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   629: astore_1
    //   630: aload_1
    //   631: invokeinterface 568 1 0
    //   636: ifeq +33 -> 669
    //   639: aload_0
    //   640: getstatic 664	beb:a	Landroid/net/Uri;
    //   643: aload_1
    //   644: iconst_0
    //   645: invokeinterface 668 2 0
    //   650: invokestatic 674	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   653: aconst_null
    //   654: aconst_null
    //   655: invokevirtual 3335	com/android/email/provider/EmailProvider:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   658: istore 4
    //   660: aload_1
    //   661: invokeinterface 442 1 0
    //   666: iload 4
    //   668: ireturn
    //   669: aload_1
    //   670: invokeinterface 442 1 0
    //   675: iconst_0
    //   676: ireturn
    //   677: astore_2
    //   678: aload_1
    //   679: invokeinterface 442 1 0
    //   684: aload_2
    //   685: athrow
    //   686: astore_1
    //   687: iconst_0
    //   688: istore 4
    //   690: goto -166 -> 524
    //   693: iconst_1
    //   694: istore 5
    //   696: iconst_1
    //   697: istore 4
    //   699: aload 11
    //   701: invokevirtual 3148	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   704: iconst_1
    //   705: istore 5
    //   707: goto -460 -> 247
    //   710: aload_1
    //   711: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   714: iconst_1
    //   715: invokeinterface 619 2 0
    //   720: checkcast 106	java/lang/String
    //   723: astore_1
    //   724: iload 6
    //   726: sipush 8194
    //   729: if_icmpne +24 -> 753
    //   732: iload 7
    //   734: ifeq +178 -> 912
    //   737: aload 11
    //   739: ldc_w 3337
    //   742: iconst_1
    //   743: anewarray 106	java/lang/String
    //   746: dup
    //   747: iconst_0
    //   748: aload_1
    //   749: aastore
    //   750: invokevirtual 3340	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   753: iload 6
    //   755: sipush 4097
    //   758: if_icmpne +563 -> 1321
    //   761: aload 12
    //   763: aload_1
    //   764: invokestatic 961	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;Ljava/lang/String;)J
    //   767: lstore 8
    //   769: iload 7
    //   771: ifeq +160 -> 931
    //   774: aload_1
    //   775: aload_2
    //   776: invokestatic 3342	com/android/email/provider/EmailProvider:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   779: astore_2
    //   780: aload 11
    //   782: aload 13
    //   784: aload_2
    //   785: aload_3
    //   786: invokevirtual 2076	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   789: istore 4
    //   791: iload 6
    //   793: iconst_1
    //   794: if_icmpne +146 -> 940
    //   797: aload_0
    //   798: getstatic 1126	com/android/email/provider/EmailProvider:D	Landroid/net/Uri;
    //   801: aload_1
    //   802: invokevirtual 538	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Ljava/lang/String;)V
    //   805: aload_0
    //   806: getstatic 1228	com/android/email/provider/EmailProvider:G	Landroid/net/Uri;
    //   809: aconst_null
    //   810: invokevirtual 538	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Ljava/lang/String;)V
    //   813: iload 5
    //   815: ifeq +63 -> 878
    //   818: iload 6
    //   820: sipush 8193
    //   823: if_icmpne +397 -> 1220
    //   826: aload_1
    //   827: invokestatic 949	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   830: invokevirtual 555	java/lang/Long:longValue	()J
    //   833: lstore 8
    //   835: aload 12
    //   837: lload 8
    //   839: invokestatic 3344	com/android/email/provider/EmailProvider:a	(Landroid/content/Context;J)V
    //   842: ldc_w 3346
    //   845: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   848: astore_2
    //   849: aload_1
    //   850: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   853: astore_3
    //   854: aload_3
    //   855: invokevirtual 193	java/lang/String:length	()I
    //   858: ifeq +350 -> 1208
    //   861: aload_2
    //   862: aload_3
    //   863: invokevirtual 1249	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   866: astore_2
    //   867: aload 11
    //   869: aload_2
    //   870: invokevirtual 2064	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   873: aload 11
    //   875: invokevirtual 3152	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   878: iload 5
    //   880: ifeq +8 -> 888
    //   883: aload 11
    //   885: invokevirtual 3155	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   888: aload_0
    //   889: iload 6
    //   891: invokestatic 3348	com/android/email/provider/EmailProvider:a	(I)Landroid/net/Uri;
    //   894: ldc_w 3312
    //   897: aload_1
    //   898: invokespecial 3350	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V
    //   901: aload_0
    //   902: getstatic 3351	bdv:H	Landroid/net/Uri;
    //   905: aconst_null
    //   906: invokevirtual 538	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Ljava/lang/String;)V
    //   909: iload 4
    //   911: ireturn
    //   912: aload 11
    //   914: ldc_w 3353
    //   917: iconst_1
    //   918: anewarray 106	java/lang/String
    //   921: dup
    //   922: iconst_0
    //   923: aload_1
    //   924: aastore
    //   925: invokevirtual 3340	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   928: goto -175 -> 753
    //   931: aload_1
    //   932: aload_2
    //   933: invokestatic 3355	com/android/email/provider/EmailProvider:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   936: astore_2
    //   937: goto -157 -> 780
    //   940: iload 6
    //   942: sipush 4097
    //   945: if_icmpne +13 -> 958
    //   948: aload_0
    //   949: aload_1
    //   950: lload 8
    //   952: invokespecial 1757	com/android/email/provider/EmailProvider:c	(Ljava/lang/String;J)V
    //   955: goto -142 -> 813
    //   958: iload 6
    //   960: sipush 12289
    //   963: if_icmpne +351 -> 1314
    //   966: aload_0
    //   967: getstatic 1090	com/android/email/provider/EmailProvider:E	Landroid/net/Uri;
    //   970: aload_1
    //   971: invokevirtual 538	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Ljava/lang/String;)V
    //   974: goto -161 -> 813
    //   977: aload_1
    //   978: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   981: iconst_2
    //   982: invokeinterface 619 2 0
    //   987: checkcast 106	java/lang/String
    //   990: astore 10
    //   992: ldc_w 3357
    //   995: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   998: astore_1
    //   999: aload 10
    //   1001: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1004: astore 14
    //   1006: aload 14
    //   1008: invokevirtual 193	java/lang/String:length	()I
    //   1011: ifeq +31 -> 1042
    //   1014: aload_1
    //   1015: aload 14
    //   1017: invokevirtual 1249	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1020: astore_1
    //   1021: aload 11
    //   1023: aload 13
    //   1025: aload_1
    //   1026: aload_2
    //   1027: invokestatic 3359	com/android/email/provider/EmailProvider:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1030: aload_3
    //   1031: invokevirtual 2076	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1034: istore 4
    //   1036: aload 10
    //   1038: astore_1
    //   1039: goto -226 -> 813
    //   1042: new 106	java/lang/String
    //   1045: dup
    //   1046: aload_1
    //   1047: invokespecial 1734	java/lang/String:<init>	(Ljava/lang/String;)V
    //   1050: astore_1
    //   1051: goto -30 -> 1021
    //   1054: aload 11
    //   1056: aload 13
    //   1058: aload_2
    //   1059: aload_3
    //   1060: invokevirtual 2076	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1063: istore 4
    //   1065: ldc_w 2350
    //   1068: astore_1
    //   1069: goto -256 -> 813
    //   1072: aload 11
    //   1074: ldc -48
    //   1076: aload_2
    //   1077: aload_3
    //   1078: invokevirtual 2076	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1081: pop
    //   1082: iconst_m1
    //   1083: istore 4
    //   1085: ldc_w 2350
    //   1088: astore_1
    //   1089: goto -276 -> 813
    //   1092: aload 11
    //   1094: ldc -19
    //   1096: aload_2
    //   1097: aload_3
    //   1098: invokevirtual 2076	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1101: pop
    //   1102: iconst_m1
    //   1103: istore 4
    //   1105: ldc_w 2350
    //   1108: astore_1
    //   1109: goto -296 -> 813
    //   1112: aload_2
    //   1113: astore 10
    //   1115: iload 6
    //   1117: ldc_w 3360
    //   1120: if_icmpne +22 -> 1142
    //   1123: aload_1
    //   1124: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   1127: iconst_1
    //   1128: invokeinterface 619 2 0
    //   1133: checkcast 106	java/lang/String
    //   1136: aload_2
    //   1137: invokestatic 3355	com/android/email/provider/EmailProvider:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1140: astore 10
    //   1142: aload 11
    //   1144: ldc_w 3362
    //   1147: aload_1
    //   1148: aload 10
    //   1150: invokestatic 3367	azz:a	(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;
    //   1153: aload_1
    //   1154: aload_3
    //   1155: invokestatic 3370	azz:a	(Landroid/net/Uri;[Ljava/lang/String;)[Ljava/lang/String;
    //   1158: invokevirtual 2076	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1161: istore 4
    //   1163: iload 4
    //   1165: ifle +11 -> 1176
    //   1168: aload_0
    //   1169: getstatic 3373	gqa:a	Landroid/net/Uri;
    //   1172: aconst_null
    //   1173: invokevirtual 538	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Ljava/lang/String;)V
    //   1176: iload 5
    //   1178: ifeq +8 -> 1186
    //   1181: aload 11
    //   1183: invokevirtual 3155	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1186: iload 4
    //   1188: ireturn
    //   1189: astore_2
    //   1190: getstatic 434	cvm:a	Ljava/lang/String;
    //   1193: aload_2
    //   1194: ldc_w 3375
    //   1197: iconst_0
    //   1198: anewarray 157	java/lang/Object
    //   1201: invokestatic 3377	cvm:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1204: pop
    //   1205: goto -363 -> 842
    //   1208: new 106	java/lang/String
    //   1211: dup
    //   1212: aload_2
    //   1213: invokespecial 1734	java/lang/String:<init>	(Ljava/lang/String;)V
    //   1216: astore_2
    //   1217: goto -350 -> 867
    //   1220: aload 11
    //   1222: ldc_w 3379
    //   1225: aconst_null
    //   1226: invokevirtual 656	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   1229: astore_2
    //   1230: aload_2
    //   1231: invokeinterface 419 1 0
    //   1236: ifeq +50 -> 1286
    //   1239: aload_2
    //   1240: iconst_0
    //   1241: invokeinterface 668 2 0
    //   1246: lstore 8
    //   1248: aload 12
    //   1250: lload 8
    //   1252: invokestatic 3344	com/android/email/provider/EmailProvider:a	(Landroid/content/Context;J)V
    //   1255: goto -25 -> 1230
    //   1258: astore_3
    //   1259: getstatic 434	cvm:a	Ljava/lang/String;
    //   1262: aload_3
    //   1263: ldc_w 3375
    //   1266: iconst_0
    //   1267: anewarray 157	java/lang/Object
    //   1270: invokestatic 3377	cvm:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1273: pop
    //   1274: goto -44 -> 1230
    //   1277: astore_1
    //   1278: aload_2
    //   1279: invokeinterface 442 1 0
    //   1284: aload_1
    //   1285: athrow
    //   1286: aload_2
    //   1287: invokeinterface 442 1 0
    //   1292: aload 11
    //   1294: ldc_w 3381
    //   1297: invokevirtual 2064	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   1300: goto -427 -> 873
    //   1303: astore_1
    //   1304: iconst_0
    //   1305: istore 5
    //   1307: goto -768 -> 539
    //   1310: astore_1
    //   1311: goto -787 -> 524
    //   1314: goto -501 -> 813
    //   1317: astore_1
    //   1318: goto -779 -> 539
    //   1321: ldc2_w 1099
    //   1324: lstore 8
    //   1326: goto -557 -> 769
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1329	0	this	EmailProvider
    //   0	1329	1	paramUri	Uri
    //   0	1329	2	paramString	String
    //   0	1329	3	paramArrayOfString	String[]
    //   522	665	4	i1	int
    //   245	1061	5	i2	int
    //   44	1077	6	i3	int
    //   84	686	7	bool	boolean
    //   569	756	8	l1	long
    //   4	1145	10	str1	String
    //   58	1235	11	localSQLiteDatabase	SQLiteDatabase
    //   50	1199	12	localContext	Context
    //   74	983	13	str2	String
    //   1004	12	14	str3	String
    // Exception table:
    //   from	to	target	type
    //   476	519	519	android/database/sqlite/SQLiteException
    //   710	724	519	android/database/sqlite/SQLiteException
    //   737	753	519	android/database/sqlite/SQLiteException
    //   761	769	519	android/database/sqlite/SQLiteException
    //   774	780	519	android/database/sqlite/SQLiteException
    //   780	791	519	android/database/sqlite/SQLiteException
    //   797	813	519	android/database/sqlite/SQLiteException
    //   826	835	519	android/database/sqlite/SQLiteException
    //   835	842	519	android/database/sqlite/SQLiteException
    //   842	867	519	android/database/sqlite/SQLiteException
    //   867	873	519	android/database/sqlite/SQLiteException
    //   873	878	519	android/database/sqlite/SQLiteException
    //   912	928	519	android/database/sqlite/SQLiteException
    //   931	937	519	android/database/sqlite/SQLiteException
    //   948	955	519	android/database/sqlite/SQLiteException
    //   966	974	519	android/database/sqlite/SQLiteException
    //   977	1021	519	android/database/sqlite/SQLiteException
    //   1021	1036	519	android/database/sqlite/SQLiteException
    //   1042	1051	519	android/database/sqlite/SQLiteException
    //   1054	1065	519	android/database/sqlite/SQLiteException
    //   1072	1082	519	android/database/sqlite/SQLiteException
    //   1092	1102	519	android/database/sqlite/SQLiteException
    //   1123	1142	519	android/database/sqlite/SQLiteException
    //   1142	1163	519	android/database/sqlite/SQLiteException
    //   1168	1176	519	android/database/sqlite/SQLiteException
    //   1190	1205	519	android/database/sqlite/SQLiteException
    //   1208	1217	519	android/database/sqlite/SQLiteException
    //   1220	1230	519	android/database/sqlite/SQLiteException
    //   1278	1286	519	android/database/sqlite/SQLiteException
    //   1286	1300	519	android/database/sqlite/SQLiteException
    //   528	532	538	finally
    //   536	538	538	finally
    //   699	704	538	finally
    //   630	660	677	finally
    //   102	118	686	android/database/sqlite/SQLiteException
    //   551	557	686	android/database/sqlite/SQLiteException
    //   557	580	686	android/database/sqlite/SQLiteException
    //   582	588	686	android/database/sqlite/SQLiteException
    //   590	596	686	android/database/sqlite/SQLiteException
    //   596	602	686	android/database/sqlite/SQLiteException
    //   602	608	686	android/database/sqlite/SQLiteException
    //   608	614	686	android/database/sqlite/SQLiteException
    //   614	630	686	android/database/sqlite/SQLiteException
    //   660	666	686	android/database/sqlite/SQLiteException
    //   669	675	686	android/database/sqlite/SQLiteException
    //   678	686	686	android/database/sqlite/SQLiteException
    //   835	842	1189	java/lang/IllegalStateException
    //   1248	1255	1258	java/lang/IllegalStateException
    //   1230	1248	1277	finally
    //   1248	1255	1277	finally
    //   1259	1274	1277	finally
    //   102	118	1303	finally
    //   551	557	1303	finally
    //   557	580	1303	finally
    //   582	588	1303	finally
    //   590	596	1303	finally
    //   596	602	1303	finally
    //   602	608	1303	finally
    //   608	614	1303	finally
    //   614	630	1303	finally
    //   660	666	1303	finally
    //   669	675	1303	finally
    //   678	686	1303	finally
    //   699	704	1310	android/database/sqlite/SQLiteException
    //   476	519	1317	finally
    //   710	724	1317	finally
    //   737	753	1317	finally
    //   761	769	1317	finally
    //   774	780	1317	finally
    //   780	791	1317	finally
    //   797	813	1317	finally
    //   826	835	1317	finally
    //   835	842	1317	finally
    //   842	867	1317	finally
    //   867	873	1317	finally
    //   873	878	1317	finally
    //   912	928	1317	finally
    //   931	937	1317	finally
    //   948	955	1317	finally
    //   966	974	1317	finally
    //   977	1021	1317	finally
    //   1021	1036	1317	finally
    //   1042	1051	1317	finally
    //   1054	1065	1317	finally
    //   1072	1082	1317	finally
    //   1092	1102	1317	finally
    //   1123	1142	1317	finally
    //   1142	1163	1317	finally
    //   1168	1176	1317	finally
    //   1190	1205	1317	finally
    //   1208	1217	1317	finally
    //   1220	1230	1317	finally
    //   1278	1286	1317	finally
    //   1286	1300	1317	finally
  }
  
  public void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramArrayOfString = getContext();
    paramPrintWriter.println("Installed services:");
    paramFileDescriptor = bam.c(paramArrayOfString).iterator();
    while (paramFileDescriptor.hasNext())
    {
      localObject1 = String.valueOf((ban)paramFileDescriptor.next());
      paramPrintWriter.println(String.valueOf(localObject1).length() + 2 + "  " + (String)localObject1);
    }
    paramPrintWriter.println();
    paramPrintWriter.println("Accounts: ");
    Object localObject1 = query(com.android.emailcommon.provider.Account.a, com.android.emailcommon.provider.Account.y, null, null, null);
    if (((Cursor)localObject1).getCount() == 0) {
      paramPrintWriter.println("  None");
    }
    Object localObject2 = new ArrayList();
    Object localObject3;
    for (;;)
    {
      try
      {
        if (!((Cursor)localObject1).moveToNext()) {
          break;
        }
        localObject3 = new com.android.emailcommon.provider.Account();
        ((com.android.emailcommon.provider.Account)localObject3).a((Cursor)localObject1);
        ((List)localObject2).add(localObject3);
        paramFileDescriptor = String.valueOf("  Account ");
        Object localObject4 = String.valueOf(c);
        if (((String)localObject4).length() != 0)
        {
          paramFileDescriptor = paramFileDescriptor.concat((String)localObject4);
          paramPrintWriter.println(paramFileDescriptor);
          paramFileDescriptor = HostAuth.a(paramArrayOfString, h);
          if (paramFileDescriptor != null)
          {
            localObject4 = String.valueOf("    Protocol = ");
            String str = String.valueOf(b);
            if (!TextUtils.isEmpty(l)) {
              break label805;
            }
            paramFileDescriptor = "";
            paramPrintWriter.println(String.valueOf(localObject4).length() + 0 + String.valueOf(str).length() + String.valueOf(paramFileDescriptor).length() + (String)localObject4 + str + paramFileDescriptor);
          }
          if (o <= 0L) {
            continue;
          }
          localObject4 = Policy.a(paramArrayOfString, o);
          paramFileDescriptor = String.valueOf("    Policy passwordMode ");
          int i1 = b;
          int i2 = c;
          int i3 = d;
          int i4 = e;
          int i5 = f;
          int i6 = g;
          int i7 = h;
          boolean bool1 = i;
          boolean bool2 = j;
          boolean bool3 = k;
          boolean bool4 = l;
          boolean bool5 = m;
          boolean bool6 = n;
          boolean bool7 = o;
          int i8 = p;
          int i9 = q;
          int i10 = r;
          int i11 = s;
          int i12 = t;
          boolean bool8 = u;
          localObject3 = String.valueOf(v);
          localObject4 = String.valueOf(w);
          paramPrintWriter.println(String.valueOf(paramFileDescriptor).length() + 605 + String.valueOf(localObject3).length() + String.valueOf(localObject4).length() + paramFileDescriptor + i1 + " passwordMinLength " + i2 + " passwordMaxFails " + i3 + " passwordExpiration " + i4 + " passwordHistory " + i5 + " passwordComplexChars " + i6 + " maxScreenLockTime " + i7 + " requireRemoteWipe " + bool1 + " requireEncryption " + bool2 + " requireEncryptionExternal " + bool3 + " requireManualSyncRoaming " + bool4 + " dontAllowCamera " + bool5 + " dontAllowAttachments " + bool6 + " dontAllowHtml " + bool7 + " maxOutgoingMessageSize " + i8 + " maxTextTruncationSize " + i9 + " maxHtmlTruncationSize " + i10 + " maxEmailLookback " + i11 + " maxCalendarLookback " + i12 + " passwordRecoveryEnabled " + bool8 + " policiesEnforced " + (String)localObject3 + " policiesUnsupported " + (String)localObject4);
          continue;
        }
        paramFileDescriptor = new String(paramFileDescriptor);
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
      continue;
      label805:
      paramFileDescriptor = String.valueOf(l);
      if (paramFileDescriptor.length() != 0) {
        paramFileDescriptor = " version ".concat(paramFileDescriptor);
      } else {
        paramFileDescriptor = new String(" version ");
      }
    }
    ((Cursor)localObject1).close();
    paramPrintWriter.append("Email account states:");
    paramFileDescriptor = ((List)localObject2).iterator();
    while (paramFileDescriptor.hasNext())
    {
      localObject1 = (com.android.emailcommon.provider.Account)paramFileDescriptor.next();
      localObject2 = d;
      localObject3 = cfg.b(paramArrayOfString, (String)localObject2);
      paramPrintWriter.println();
      ctl.a("  ", paramPrintWriter, (String)localObject2, b(paramArrayOfString, (com.android.emailcommon.provider.Account)localObject1), (cfg)localObject3);
    }
  }
  
  public final int e(long paramLong)
  {
    return 1;
  }
  
  public final SQLiteDatabase e()
  {
    return c(getContext());
  }
  
  public final String f()
  {
    return a;
  }
  
  public String getType(Uri paramUri)
  {
    String str = null;
    Object localObject = str;
    switch (b(paramUri, "getType"))
    {
    default: 
      localObject = str;
    case 57344: 
    case 57345: 
    case 36865: 
    case 36864: 
    case 8193: 
    case 8192: 
    case 4096: 
    case 4097: 
    case 0: 
    case 1: 
    case 12288: 
    case 12290: 
    case 12289: 
    case 16384: 
    case 16385: 
    case 12291: 
      for (;;)
      {
        return (String)localObject;
        return "vnd.android.cursor.item/email-body";
        return "vnd.android.cursor.dir/email-body";
        localObject = "vnd.android.cursor.item/email-message";
        str = paramUri.getQueryParameter("mailboxId");
        paramUri = (Uri)localObject;
        if (str != null)
        {
          paramUri = String.valueOf("vnd.android.cursor.item/email-message");
          paramUri = String.valueOf(paramUri).length() + 1 + String.valueOf(str).length() + paramUri + "-" + str;
        }
        return paramUri;
        return "vnd.android.cursor.dir/email-message";
        return "vnd.android.cursor.dir/email-mailbox";
        return "vnd.android.cursor.item/email-mailbox";
        return "vnd.android.cursor.dir/email-account";
        return "vnd.android.cursor.item/email-account";
        return "vnd.android.cursor.dir/email-attachment";
        return "vnd.android.cursor.item/email-attachment";
        return "vnd.android.cursor.dir/email-hostauth";
        return "vnd.android.cursor.item/email-hostauth";
        Cursor localCursor = c(getContext()).query("Attachment", q, "cachedFile=?", new String[] { paramUri.toString() }, null, null, null, null);
        if (localCursor != null) {}
        try
        {
          if (localCursor.moveToFirst())
          {
            paramUri = localCursor.getString(0);
            localObject = paramUri;
            return paramUri;
          }
          localObject = str;
          return null;
        }
        finally
        {
          if (localCursor != null) {
            localCursor.close();
          }
        }
      }
    case 49152: 
      return "vnd.android.cursor.dir/email-account-dirty-flags";
    }
    return "vnd.android.cursor.item/email-account-dirty-flags";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    Object localObject1 = String.valueOf(paramUri);
    new StringBuilder(String.valueOf(localObject1).length() + 8).append("Insert: ").append((String)localObject1);
    int i2 = b(paramUri, "insert");
    Object localObject2 = getContext();
    SQLiteDatabase localSQLiteDatabase = c((Context)localObject2);
    int i1 = i2 >> 12;
    if ((i2 == 4097) || (i2 == 4096))
    {
      paramContentValues.put("unreadCount", Integer.valueOf(0));
      paramContentValues.put("messageCount", Integer.valueOf(0));
    }
    long l1;
    switch (i2)
    {
    default: 
      try
      {
        paramUri = String.valueOf(paramUri);
        throw new IllegalArgumentException(String.valueOf(paramUri).length() + 12 + "Unknown URL " + paramUri);
      }
      catch (SQLiteException paramUri)
      {
        j();
        throw paramUri;
      }
    case 36864: 
      localObject1 = new ContentValues(paramContentValues);
      ((ContentValues)localObject1).remove("htmlContent");
      ((ContentValues)localObject1).remove("textContent");
      localObject1 = ContentUris.withAppendedId(paramUri, localSQLiteDatabase.insert("Body", "foo", (ContentValues)localObject1));
      if (!paramContentValues.containsKey("messageKey")) {
        throw new IllegalArgumentException("Cannot insert body without MESSAGE_KEY");
      }
      l1 = paramContentValues.getAsLong("messageKey").longValue();
      a((Context)localObject2, l1);
      a(getContext(), l1, paramContentValues);
      paramUri = "0";
      paramContentValues = (ContentValues)localObject1;
    }
    for (;;)
    {
      a(a(i2), "insert", paramUri);
      a(bdv.H, null);
      return paramContentValues;
      b(paramContentValues);
      l1 = localSQLiteDatabase.insert((String)k.valueAt(i1), "foo", paramContentValues);
      localObject1 = ContentUris.withAppendedId(paramUri, l1);
      long l2;
      switch (i2)
      {
      case 8192: 
        x.a(getContext(), paramContentValues, l1, localSQLiteDatabase);
        l2 = paramContentValues.getAsLong("mailboxKey").longValue();
        if (!paramUri.getBooleanQueryParameter("is_uiprovider", false)) {
          h(l2);
        }
        a(l2, paramContentValues.getAsLong("accountKey").longValue());
        if (!paramContentValues.containsKey("flagsEas")) {
          break;
        }
      }
      for (i1 = paramContentValues.getAsInteger("flagsEas").intValue();; i1 = 0)
      {
        if (((i1 & 0x20) == 0) && ((i1 & 0x7) != 0))
        {
          AsyncTask.execute(new ayz(this, (Context)localObject2, l1, paramContentValues.getAsLong("accountKey").longValue()));
          paramUri = "0";
          paramContentValues = (ContentValues)localObject1;
          break;
          if ((paramContentValues.containsKey("type")) && (paramContentValues.getAsInteger("type").intValue() < 64))
          {
            paramUri = paramContentValues.getAsLong("accountKey");
            if ((paramUri == null) || (paramUri.longValue() <= 0L)) {
              break label1327;
            }
            a(D, paramUri.longValue());
            a(C, paramUri.longValue());
            break label1327;
            a(l1, paramContentValues);
            if (!paramUri.getBooleanQueryParameter("is_uiprovider", false)) {
              b(l1);
            }
            a(G, null);
            paramUri = "0";
            paramContentValues = (ContentValues)localObject1;
            break;
            paramUri = String.valueOf(paramUri);
            throw new IllegalArgumentException(String.valueOf(paramUri).length() + 12 + "Unknown URL " + paramUri);
            i1 = 0;
            if (paramContentValues.containsKey("flags")) {
              i1 = paramContentValues.getAsInteger("flags").intValue();
            }
            if (TextUtils.isEmpty(paramContentValues.getAsString("location"))) {
              cvm.d(a, new Throwable(), "attachment with blank location", new Object[0]);
            }
            if (paramContentValues.containsKey("messageKey"))
            {
              l2 = paramContentValues.getAsLong("messageKey").longValue();
              a(F, l2);
              a(H, l2);
            }
            O.a(getContext(), l1, i1);
            break label1312;
            paramUri = (String)paramUri.getPathSegments().get(1);
            l1 = Long.parseLong(paramUri);
            localObject1 = bam.a((Context)localObject2, l1);
            localObject2 = paramContentValues.getAsString("name");
            ((ber)localObject1).a(l1, (String)localObject2, paramContentValues.getAsLong("_id").longValue());
            a(i(l1));
            c((String)localObject2, l1);
            paramContentValues = null;
            break;
            paramContentValues.put("accountKey", Long.valueOf(Long.parseLong((String)paramUri.getPathSegments().get(2))));
            return insert(bek.a, paramContentValues);
            paramContentValues.put("mailboxKey", Long.valueOf(Long.parseLong((String)paramUri.getPathSegments().get(1))));
            return insert(beb.a, paramContentValues);
            paramContentValues.put("messageKey", Long.valueOf(Long.parseLong((String)paramUri.getPathSegments().get(1))));
            return insert(com.android.emailcommon.provider.Attachment.a, paramContentValues);
            paramContentValues.put("accountKey", Long.valueOf(Long.parseLong((String)paramUri.getPathSegments().get(1))));
            return insert(Mailbox.a, paramContentValues);
            l1 = localSQLiteDatabase.insert((String)k.valueAt(i1), "foo", paramContentValues);
            paramContentValues = ContentUris.withAppendedId(com.android.emailcommon.provider.Attachment.a, l1);
            paramUri = "0";
            break;
            return cge.a(this, paramUri, paramContentValues);
            return cge.b(this, paramUri, paramContentValues);
            azz.a(paramUri.getBooleanQueryParameter("caller_is_syncadapter", false), paramContentValues);
            localObject1 = paramUri.getQueryParameter("account_name");
            localObject2 = paramUri.getQueryParameter("account_type");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              paramContentValues.put("account_name", (String)localObject1);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              paramContentValues.put("account_type", (String)localObject2);
            }
            l1 = localSQLiteDatabase.insert("tasks", null, paramContentValues);
            if (l1 == -1L) {
              return null;
            }
            a(gqa.a, null);
            paramUri = ContentUris.withAppendedId(paramUri, l1);
            return paramUri;
          }
        }
        label1312:
        paramUri = "0";
        paramContentValues = (ContentValues)localObject1;
        break;
      }
      label1327:
      paramUri = "0";
      paramContentValues = (ContentValues)localObject1;
    }
  }
  
  public boolean onCreate()
  {
    Context localContext = getContext();
    bdv.i(localContext);
    synchronized (l)
    {
      if (c != null)
      {
        bhn.a(cfm.a(localContext).d("enableStrictMode"));
        y = ayp.a(localContext);
        ??? = new Intent("com.android.mail.ACTION_NOTIFY_DATASET_CHANGED");
        ((Intent)???).putExtra("update-all-widgets", true);
        ((Intent)???).setType(localContext.getString(arh.aW));
        localContext.sendBroadcast((Intent)???);
        localContext.registerComponentCallbacks(new aza(this, new Configuration(localContext.getResources().getConfiguration())));
        x = new azt(new azb(this));
        return true;
      }
      String str1 = String.valueOf(bdv.F);
      c = Uri.parse(String.valueOf(str1).length() + 25 + "content://" + str1 + "/integrityCheck");
      str1 = String.valueOf(bdv.F);
      d = Uri.parse(String.valueOf(str1).length() + 24 + "content://" + str1 + "/accountBackup");
      str1 = String.valueOf(bdv.F);
      s = Uri.parse(String.valueOf(str1).length() + 17 + "content://" + str1 + "/status");
      str1 = String.valueOf(bdv.F);
      e = Uri.parse(String.valueOf(str1).length() + 19 + "content://" + str1 + "/uifolder");
      b = localContext.getString(arh.aW);
      str1 = String.valueOf(bdv.E).concat(".uinotifications");
      i = Uri.parse(String.valueOf(str1).length() + 21 + "content://" + str1 + "/uimessages");
      B = Uri.parse(String.valueOf(str1).length() + 19 + "content://" + str1 + "/uifolder");
      C = Uri.parse(String.valueOf(str1).length() + 20 + "content://" + str1 + "/uifolders");
      D = Uri.parse(String.valueOf(str1).length() + 20 + "content://" + str1 + "/uiaccount");
      E = Uri.parse(String.valueOf(str1).length() + 23 + "content://" + str1 + "/uiattachment");
      String str2 = String.valueOf("uiattachments");
      F = Uri.parse(String.valueOf(str1).length() + 11 + String.valueOf(str2).length() + "content://" + str1 + "/" + str2);
      G = Uri.parse(String.valueOf(str1).length() + 18 + "content://" + str1 + "/uiaccts");
      H = Uri.parse(String.valueOf(str1).length() + 20 + "content://" + str1 + "/uimessage");
      I = Uri.parse(String.valueOf(str1).length() + 26 + "content://" + str1 + "/uirecentfolders");
      l.addURI(bdv.F, "account", 0);
      l.addURI(bdv.F, "account/#", 1);
      l.addURI(bdv.F, "accountCheck/#", 2);
      l.addURI(bdv.F, "accountDirtyFlags", 49152);
      l.addURI(bdv.F, "accountDirtyFlags/#", 49153);
      l.addURI(bdv.F, "mailbox", 4096);
      l.addURI(bdv.F, "mailbox/*", 4097);
      l.addURI(bdv.F, "mailboxNotification/#", 4098);
      l.addURI(bdv.F, "mailboxMostRecentMessage/#", 4099);
      l.addURI(bdv.F, "mailboxCount/#", 4100);
      l.addURI(bdv.F, "message", 8192);
      l.addURI(bdv.F, "message/#", 8193);
      l.addURI(bdv.F, "attachment", 12288);
      l.addURI(bdv.F, "attachment/#", 12289);
      l.addURI(bdv.F, "attachment/message/#", 12290);
      l.addURI(bdv.F, "attachment/cachedFile", 12291);
      l.addURI(bdv.F, com.android.emailcommon.provider.Attachment.g, 45056);
      l.addURI(bdv.F, "body", 36864);
      l.addURI(bdv.F, "body/#", 36865);
      l.addURI(bdv.F, "bodyHtml/#", 36866);
      l.addURI(bdv.F, "bodyText/#", 36867);
      l.addURI(bdv.F, "hostauth", 16384);
      l.addURI(bdv.F, "hostauth/*", 16385);
      l.addURI(bdv.F, "credential", 40960);
      l.addURI(bdv.F, "credential/*", 40961);
      l.addURI(bdv.F, "syncedMessage/#", 8194);
      l.addURI(bdv.F, "messageBySelection", 8195);
      l.addURI(bdv.F, "messageMove", 8196);
      l.addURI(bdv.F, "messageChange", 8197);
      l.addURI(bdv.F, "deletedMessage", 20480);
      l.addURI(bdv.F, "deletedMessage/#", 20481);
      l.addURI(bdv.F, "policy", 24576);
      l.addURI(bdv.F, "policy/#", 24577);
      l.addURI(bdv.F, "quickresponse", 28672);
      l.addURI(bdv.F, "quickresponse/#", 28673);
      l.addURI(bdv.F, "quickresponse/account/#", 28674);
      l.addURI(bdv.F, "uifolders/#", 32768);
      l.addURI(bdv.F, "uifullfolders/#", 32786);
      l.addURI(bdv.F, "uiallfolders/#", 32787);
      l.addURI(bdv.F, "uisubfolders/#", 32769);
      l.addURI(bdv.F, "uimessages/#", 32770);
      l.addURI(bdv.F, "uimessage/#", 32771);
      l.addURI(bdv.F, "uiundo", 32772);
      l.addURI(bdv.F, "uirefresh/#", 32773);
      l.addURI(bdv.F, "uifolder/*", 32774);
      l.addURI(bdv.F, "uiinbox/#", 32789);
      l.addURI(bdv.F, "uiaccount/#", 32775);
      l.addURI(bdv.F, "uiaccts", 32776);
      l.addURI(bdv.F, "uiacctsettings", 32790);
      l.addURI(bdv.F, "uiattachments/#", 32777);
      l.addURI(bdv.F, "uiattachment/#", 32778);
      l.addURI(bdv.F, "uiattachmentbycid/#/*", 32779);
      l.addURI(bdv.F, "uisearch/#", 32780);
      l.addURI(bdv.F, "uisearchmessagegeneric/#", 32793);
      l.addURI(bdv.F, "uiaccountdata/#", 32781);
      l.addURI(bdv.F, "uiloadmore/#", 32782);
      l.addURI(bdv.F, "uiconversation/#", 32783);
      l.addURI(bdv.F, "uirecentfolders/#", 32784);
      l.addURI(bdv.F, "uidefaultrecentfolders/#", 32785);
      l.addURI(bdv.F, "pickTrashFolder/#", 3);
      l.addURI(bdv.F, "pickSentFolder/#", 4);
      l.addURI(bdv.F, "uipurgefolder/#", 32788);
      l.addURI(bdv.F, "settingsSnapshot/#", 32791);
      l.addURI(bdv.F, "vacationResponderSettings/#", 32792);
      l.addURI(bdv.F, "search", 53248);
      l.addURI(bdv.F, "search/#", 53249);
      l.addURI(bdv.F, "linkSearch/#/*", 53249);
      l.addURI(bdv.F, "appdataindex/*", 32794);
      l.addURI(bdv.F, "appdatarequest/*", 32795);
      cgy.a(l, bdv.F, "drive/#", 32796, 32797, 32798, 32799, 32800);
    }
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (("removal-action".equals(paramString)) || ("conversation-list-swipe".equals(paramString)) || ("conversation-list-sender-image".equals(paramString)) || ("default-reply-all".equals(paramString)) || ("conversation-overview-mode".equals(paramString)) || ("auto-advance-mode".equals(paramString)) || ("snap-header-mode".equals(paramString)) || ("confirm-delete".equals(paramString)) || ("confirm-archive".equals(paramString)) || ("confirm-send".equals(paramString))) {
      a(G, null);
    }
    do
    {
      do
      {
        return;
      } while (!"mail-enable-threading".equals(paramString));
      f = cfm.a(getContext()).h();
      a(i, null);
    } while (!f);
    paramSharedPreferences = getContext();
    x.a(h(), paramSharedPreferences, c(paramSharedPreferences));
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    if (cvm.a(a, 3)) {
      cvm.b(a, "EmailProvider.openFile: %s", new Object[] { cvm.a(a, paramUri) });
    }
    switch (b(paramUri, "openFile"))
    {
    default: 
    case 12291: 
      do
      {
        throw new FileNotFoundException("unable to open file");
        paramUri = paramUri.getQueryParameter("filePath");
      } while (paramUri == null);
      l1 = Binder.clearCallingIdentity();
      try
      {
        cvm.b(a, "Opening attachment %s", new Object[] { paramUri });
        paramUri = ParcelFileDescriptor.open(new File(paramUri), 268435456);
        return paramUri;
      }
      finally
      {
        Binder.restoreCallingIdentity(l1);
      }
    case 36866: 
      l1 = Long.valueOf(paramUri.getLastPathSegment()).longValue();
      return ParcelFileDescriptor.open(a(getContext(), l1, "html"), baa.a(paramString));
    }
    long l1 = Long.valueOf(paramUri.getLastPathSegment()).longValue();
    return ParcelFileDescriptor.open(a(getContext(), l1, "txt"), baa.a(paramString));
  }
  
  /* Error */
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 3934	android/os/Binder:getCallingPid	()I
    //   3: invokestatic 3939	android/os/Process:myPid	()I
    //   6: if_icmpeq +27 -> 33
    //   9: invokestatic 3943	cuh:a	()Z
    //   12: ifeq +21 -> 33
    //   15: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   18: ldc_w 3945
    //   21: iconst_0
    //   22: anewarray 157	java/lang/Object
    //   25: invokestatic 813	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   28: pop
    //   29: aconst_null
    //   30: astore_2
    //   31: aload_2
    //   32: areturn
    //   33: aconst_null
    //   34: astore 16
    //   36: aconst_null
    //   37: astore 15
    //   39: aload_0
    //   40: aload_1
    //   41: ldc_w 3946
    //   44: invokespecial 3314	com/android/email/provider/EmailProvider:b	(Landroid/net/Uri;Ljava/lang/String;)I
    //   47: istore 6
    //   49: aload_0
    //   50: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   53: astore 14
    //   55: aload_0
    //   56: aload 14
    //   58: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   61: astore 17
    //   63: aload_1
    //   64: ldc_w 3948
    //   67: invokevirtual 679	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 18
    //   72: getstatic 150	com/android/email/provider/EmailProvider:k	Landroid/util/SparseArray;
    //   75: iload 6
    //   77: bipush 12
    //   79: ishr
    //   80: invokevirtual 3317	android/util/SparseArray:valueAt	(I)Ljava/lang/Object;
    //   83: checkcast 106	java/lang/String
    //   86: astore 19
    //   88: iload 6
    //   90: lookupswitch	default:+506->596, 0:+3349->3439, 1:+3929->4019, 4096:+3349->3439, 4097:+3929->4019, 4098:+2974->3064, 4099:+3038->3128, 4100:+3102->3192, 8192:+3349->3439, 8193:+3929->4019, 8196:+3166->3256, 8197:+3212->3302, 12288:+3349->3439, 12289:+3929->4019, 12290:+4067->4157, 12291:+4279->4369, 16384:+3349->3439, 16385:+3929->4019, 20480:+3349->3439, 20481:+3929->4019, 24576:+3349->3439, 24577:+3929->4019, 28672:+3435->3525, 28673:+3971->4061, 28674:+4183->4273, 32768:+2498->2588, 32769:+2380->2470, 32770:+2380->2470, 32771:+2380->2470, 32772:+2346->2436, 32773:+2930->3020, 32774:+2380->2470, 32775:+2380->2470, 32776:+2301->2391, 32777:+2380->2470, 32778:+2380->2470, 32779:+2380->2470, 32780:+1517->1607, 32782:+2791->2881, 32783:+2380->2470, 32784:+2380->2470, 32786:+2380->2470, 32787:+2380->2470, 32789:+2380->2470, 32791:+4735->4825, 32792:+4831->4921, 32793:+2105->2195, 32794:+758->848, 32795:+1351->1441, 32797:+5031->5121, 32798:+4997->5087, 32799:+5065->5155, 32800:+5098->5188, 36864:+3495->3585, 36865:+3495->3585, 40960:+3349->3439, 40961:+3929->4019, 45056:+3349->3439, 49152:+3349->3439, 49153:+3929->4019, 53248:+1461->1551, 57344:+5132->5222, 57345:+5132->5222
    //   596: aload 16
    //   598: astore 13
    //   600: aload_1
    //   601: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   604: astore_2
    //   605: aload 16
    //   607: astore 13
    //   609: new 828	java/lang/IllegalArgumentException
    //   612: dup
    //   613: new 189	java/lang/StringBuilder
    //   616: dup
    //   617: aload_2
    //   618: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   621: invokevirtual 193	java/lang/String:length	()I
    //   624: bipush 12
    //   626: iadd
    //   627: invokespecial 194	java/lang/StringBuilder:<init>	(I)V
    //   630: ldc_w 3321
    //   633: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload_2
    //   637: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokespecial 833	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   646: athrow
    //   647: astore 5
    //   649: aconst_null
    //   650: astore 4
    //   652: aload 4
    //   654: astore_2
    //   655: aload_0
    //   656: invokespecial 2557	com/android/email/provider/EmailProvider:j	()V
    //   659: aload 4
    //   661: astore_2
    //   662: aload 5
    //   664: athrow
    //   665: astore 4
    //   667: aload_2
    //   668: astore 13
    //   670: aload 4
    //   672: astore_2
    //   673: aload 13
    //   675: ifnonnull +25 -> 700
    //   678: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   681: ldc_w 3950
    //   684: iconst_2
    //   685: anewarray 157	java/lang/Object
    //   688: dup
    //   689: iconst_0
    //   690: aload_1
    //   691: aastore
    //   692: dup
    //   693: iconst_1
    //   694: aload_3
    //   695: aastore
    //   696: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   699: pop
    //   700: aload_2
    //   701: athrow
    //   702: astore_3
    //   703: aload_1
    //   704: invokevirtual 1458	android/net/Uri:toString	()Ljava/lang/String;
    //   707: astore_1
    //   708: aload_1
    //   709: ifnull +127 -> 836
    //   712: aload_1
    //   713: ldc_w 3952
    //   716: invokevirtual 3955	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   719: ifeq +117 -> 836
    //   722: aload_0
    //   723: aload_1
    //   724: iconst_0
    //   725: aload_1
    //   726: invokevirtual 193	java/lang/String:length	()I
    //   729: iconst_2
    //   730: isub
    //   731: invokevirtual 3958	java/lang/String:substring	(II)Ljava/lang/String;
    //   734: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   737: ldc_w 2350
    //   740: invokevirtual 1249	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   743: invokestatic 337	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   746: ldc_w 3946
    //   749: invokespecial 3314	com/android/email/provider/EmailProvider:b	(Landroid/net/Uri;Ljava/lang/String;)I
    //   752: lookupswitch	default:+84->836, 1:+86->838, 4097:+86->838, 8193:+86->838, 12289:+86->838, 16385:+86->838, 20481:+86->838, 24577:+86->838, 36865:+86->838, 40961:+86->838
    //   836: aload_3
    //   837: athrow
    //   838: new 1114	cvp
    //   841: dup
    //   842: aload_2
    //   843: iconst_0
    //   844: invokespecial 1121	cvp:<init>	([Ljava/lang/String;I)V
    //   847: areturn
    //   848: aload 16
    //   850: astore 13
    //   852: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   855: ldc_w 3960
    //   858: iconst_1
    //   859: anewarray 157	java/lang/Object
    //   862: dup
    //   863: iconst_0
    //   864: aload_1
    //   865: aastore
    //   866: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   869: pop
    //   870: aload 16
    //   872: astore 13
    //   874: aload_1
    //   875: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   878: astore_2
    //   879: aload 16
    //   881: astore 13
    //   883: aload_0
    //   884: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   887: aload_2
    //   888: invokestatic 3963	com/android/emailcommon/provider/Account:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/android/emailcommon/provider/Account;
    //   891: astore_2
    //   892: aload_2
    //   893: ifnonnull +39 -> 932
    //   896: aconst_null
    //   897: astore 4
    //   899: aload 4
    //   901: astore_2
    //   902: aload 4
    //   904: ifnonnull -873 -> 31
    //   907: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   910: ldc_w 3950
    //   913: iconst_2
    //   914: anewarray 157	java/lang/Object
    //   917: dup
    //   918: iconst_0
    //   919: aload_1
    //   920: aastore
    //   921: dup
    //   922: iconst_1
    //   923: aload_3
    //   924: aastore
    //   925: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   928: pop
    //   929: aload 4
    //   931: areturn
    //   932: aload 16
    //   934: astore 13
    //   936: new 3965	ayr
    //   939: dup
    //   940: aload_0
    //   941: aload_0
    //   942: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   945: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   948: aload_2
    //   949: getfield 730	com/android/emailcommon/provider/Account:D	J
    //   952: invokespecial 3968	ayr:<init>	(Landroid/database/sqlite/SQLiteDatabase;J)V
    //   955: astore 5
    //   957: aload 16
    //   959: astore 13
    //   961: new 3970	ayq
    //   964: dup
    //   965: aload_2
    //   966: getfield 730	com/android/emailcommon/provider/Account:D	J
    //   969: aload 4
    //   971: invokespecial 3973	ayq:<init>	(J[Ljava/lang/String;)V
    //   974: astore_2
    //   975: aload 16
    //   977: astore 13
    //   979: aload_2
    //   980: getfield 3975	ayq:b	J
    //   983: lconst_0
    //   984: lcmp
    //   985: ifgt +284 -> 1269
    //   988: iconst_1
    //   989: istore 6
    //   991: iload 6
    //   993: ifeq +48 -> 1041
    //   996: aload 16
    //   998: astore 13
    //   1000: aload 5
    //   1002: getfield 3977	ayr:d	Landroid/database/sqlite/SQLiteDatabase;
    //   1005: ldc_w 3979
    //   1008: invokevirtual 2064	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   1011: aload 16
    //   1013: astore 13
    //   1015: aload 5
    //   1017: getfield 3977	ayr:d	Landroid/database/sqlite/SQLiteDatabase;
    //   1020: ldc_w 3981
    //   1023: invokevirtual 2064	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   1026: aload 16
    //   1028: astore 13
    //   1030: aload 5
    //   1032: getfield 3977	ayr:d	Landroid/database/sqlite/SQLiteDatabase;
    //   1035: ldc_w 3983
    //   1038: invokevirtual 2064	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   1041: aload 16
    //   1043: astore 13
    //   1045: aload_0
    //   1046: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   1049: astore 4
    //   1051: aload 16
    //   1053: astore 13
    //   1055: aload_2
    //   1056: getfield 3984	ayq:a	I
    //   1059: ifne +222 -> 1281
    //   1062: aload 16
    //   1064: astore 13
    //   1066: aload 5
    //   1068: getfield 3977	ayr:d	Landroid/database/sqlite/SQLiteDatabase;
    //   1071: getstatic 3985	ayr:b	Ljava/lang/String;
    //   1074: iconst_3
    //   1075: anewarray 106	java/lang/String
    //   1078: dup
    //   1079: iconst_0
    //   1080: aload_2
    //   1081: getfield 3987	ayq:d	J
    //   1084: invokestatic 3282	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1087: aastore
    //   1088: dup
    //   1089: iconst_1
    //   1090: aload_2
    //   1091: getfield 3975	ayq:b	J
    //   1094: invokestatic 3282	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1097: aastore
    //   1098: dup
    //   1099: iconst_2
    //   1100: aload_2
    //   1101: getfield 3988	ayq:c	I
    //   1104: invokestatic 3270	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1107: aastore
    //   1108: invokevirtual 656	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   1111: astore 5
    //   1113: aload 16
    //   1115: astore 13
    //   1117: getstatic 3989	ayr:a	Ljava/lang/String;
    //   1120: astore 14
    //   1122: aload 16
    //   1124: astore 13
    //   1126: aload_2
    //   1127: getfield 3987	ayq:d	J
    //   1130: lstore 8
    //   1132: aload 16
    //   1134: astore 13
    //   1136: aload_2
    //   1137: getfield 3975	ayq:b	J
    //   1140: lstore 10
    //   1142: aload 16
    //   1144: astore 13
    //   1146: aload_2
    //   1147: getfield 3988	ayq:c	I
    //   1150: istore 7
    //   1152: aload 5
    //   1154: ifnull +121 -> 1275
    //   1157: aload 16
    //   1159: astore 13
    //   1161: aload 5
    //   1163: invokeinterface 938 1 0
    //   1168: istore 6
    //   1170: aload 16
    //   1172: astore 13
    //   1174: aload 14
    //   1176: ldc_w 3991
    //   1179: iconst_4
    //   1180: anewarray 157	java/lang/Object
    //   1183: dup
    //   1184: iconst_0
    //   1185: lload 8
    //   1187: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1190: aastore
    //   1191: dup
    //   1192: iconst_1
    //   1193: lload 10
    //   1195: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1198: aastore
    //   1199: dup
    //   1200: iconst_2
    //   1201: iload 7
    //   1203: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1206: aastore
    //   1207: dup
    //   1208: iconst_3
    //   1209: iload 6
    //   1211: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1214: aastore
    //   1215: invokestatic 439	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1218: pop
    //   1219: aload 16
    //   1221: astore 13
    //   1223: new 3993	ays
    //   1226: dup
    //   1227: aload 4
    //   1229: aload 5
    //   1231: invokespecial 3994	ays:<init>	(Landroid/content/Context;Landroid/database/Cursor;)V
    //   1234: astore 4
    //   1236: goto -337 -> 899
    //   1239: astore 4
    //   1241: aload 15
    //   1243: astore_2
    //   1244: aload_2
    //   1245: astore 13
    //   1247: aload_0
    //   1248: invokespecial 2557	com/android/email/provider/EmailProvider:j	()V
    //   1251: aload_2
    //   1252: astore 13
    //   1254: aload 4
    //   1256: invokevirtual 3997	java/lang/RuntimeException:printStackTrace	()V
    //   1259: aload_2
    //   1260: astore 13
    //   1262: aload 4
    //   1264: athrow
    //   1265: astore_2
    //   1266: goto -593 -> 673
    //   1269: iconst_0
    //   1270: istore 6
    //   1272: goto -281 -> 991
    //   1275: iconst_0
    //   1276: istore 6
    //   1278: goto -108 -> 1170
    //   1281: aload 16
    //   1283: astore 13
    //   1285: aload 5
    //   1287: getfield 3977	ayr:d	Landroid/database/sqlite/SQLiteDatabase;
    //   1290: getstatic 3998	ayr:c	Ljava/lang/String;
    //   1293: iconst_3
    //   1294: anewarray 106	java/lang/String
    //   1297: dup
    //   1298: iconst_0
    //   1299: aload_2
    //   1300: getfield 3987	ayq:d	J
    //   1303: invokestatic 3282	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1306: aastore
    //   1307: dup
    //   1308: iconst_1
    //   1309: aload_2
    //   1310: getfield 3975	ayq:b	J
    //   1313: invokestatic 3282	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1316: aastore
    //   1317: dup
    //   1318: iconst_2
    //   1319: aload_2
    //   1320: getfield 3988	ayq:c	I
    //   1323: invokestatic 3270	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1326: aastore
    //   1327: invokevirtual 656	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   1330: astore 4
    //   1332: aload 16
    //   1334: astore 13
    //   1336: getstatic 3989	ayr:a	Ljava/lang/String;
    //   1339: astore 5
    //   1341: aload 16
    //   1343: astore 13
    //   1345: aload_2
    //   1346: getfield 3987	ayq:d	J
    //   1349: lstore 8
    //   1351: aload 16
    //   1353: astore 13
    //   1355: aload_2
    //   1356: getfield 3975	ayq:b	J
    //   1359: lstore 10
    //   1361: aload 16
    //   1363: astore 13
    //   1365: aload_2
    //   1366: getfield 3988	ayq:c	I
    //   1369: istore 7
    //   1371: aload 4
    //   1373: ifnull +3941 -> 5314
    //   1376: aload 16
    //   1378: astore 13
    //   1380: aload 4
    //   1382: invokeinterface 938 1 0
    //   1387: istore 6
    //   1389: aload 16
    //   1391: astore 13
    //   1393: aload 5
    //   1395: ldc_w 4000
    //   1398: iconst_4
    //   1399: anewarray 157	java/lang/Object
    //   1402: dup
    //   1403: iconst_0
    //   1404: lload 8
    //   1406: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1409: aastore
    //   1410: dup
    //   1411: iconst_1
    //   1412: lload 10
    //   1414: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1417: aastore
    //   1418: dup
    //   1419: iconst_2
    //   1420: iload 7
    //   1422: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1425: aastore
    //   1426: dup
    //   1427: iconst_3
    //   1428: iload 6
    //   1430: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1433: aastore
    //   1434: invokestatic 439	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1437: pop
    //   1438: goto -539 -> 899
    //   1441: aload 16
    //   1443: astore 13
    //   1445: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   1448: ldc_w 4002
    //   1451: iconst_1
    //   1452: anewarray 157	java/lang/Object
    //   1455: dup
    //   1456: iconst_0
    //   1457: aload_1
    //   1458: aastore
    //   1459: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1462: pop
    //   1463: aload 16
    //   1465: astore 13
    //   1467: aload_0
    //   1468: getfield 3228	com/android/email/provider/EmailProvider:y	Layp;
    //   1471: ifnull +56 -> 1527
    //   1474: aload 16
    //   1476: astore 13
    //   1478: aload_1
    //   1479: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1482: astore_2
    //   1483: aload 16
    //   1485: astore 13
    //   1487: aload_0
    //   1488: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   1491: aload_2
    //   1492: invokestatic 3963	com/android/emailcommon/provider/Account:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/android/emailcommon/provider/Account;
    //   1495: astore_2
    //   1496: aload_2
    //   1497: ifnull +30 -> 1527
    //   1500: aload 16
    //   1502: astore 13
    //   1504: aload_0
    //   1505: getfield 3228	com/android/email/provider/EmailProvider:y	Layp;
    //   1508: aload_0
    //   1509: aload_0
    //   1510: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   1513: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   1516: aload_0
    //   1517: aload_2
    //   1518: getfield 730	com/android/emailcommon/provider/Account:D	J
    //   1521: invokespecial 1206	com/android/email/provider/EmailProvider:i	(J)Landroid/accounts/Account;
    //   1524: invokevirtual 3233	ayp:b	(Landroid/database/sqlite/SQLiteDatabase;Landroid/accounts/Account;)V
    //   1527: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   1530: ldc_w 3950
    //   1533: iconst_2
    //   1534: anewarray 157	java/lang/Object
    //   1537: dup
    //   1538: iconst_0
    //   1539: aload_1
    //   1540: aastore
    //   1541: dup
    //   1542: iconst_1
    //   1543: aload_3
    //   1544: aastore
    //   1545: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1548: pop
    //   1549: aconst_null
    //   1550: areturn
    //   1551: aload 16
    //   1553: astore 13
    //   1555: aload 17
    //   1557: ldc -108
    //   1559: aload_2
    //   1560: aload_3
    //   1561: aload 4
    //   1563: aconst_null
    //   1564: aconst_null
    //   1565: aload 5
    //   1567: aload 18
    //   1569: invokevirtual 3538	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1572: astore 4
    //   1574: aload 4
    //   1576: astore_2
    //   1577: aload 4
    //   1579: ifnonnull -1548 -> 31
    //   1582: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   1585: ldc_w 3950
    //   1588: iconst_2
    //   1589: anewarray 157	java/lang/Object
    //   1592: dup
    //   1593: iconst_0
    //   1594: aload_1
    //   1595: aastore
    //   1596: dup
    //   1597: iconst_1
    //   1598: aload_3
    //   1599: aastore
    //   1600: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1603: pop
    //   1604: aload 4
    //   1606: areturn
    //   1607: aload 16
    //   1609: astore 13
    //   1611: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   1614: ldc_w 4004
    //   1617: iconst_1
    //   1618: anewarray 157	java/lang/Object
    //   1621: dup
    //   1622: iconst_0
    //   1623: aload_1
    //   1624: aastore
    //   1625: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1628: pop
    //   1629: aload 16
    //   1631: astore 13
    //   1633: aload_1
    //   1634: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1637: invokestatic 552	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1640: lstore 8
    //   1642: aload 16
    //   1644: astore 13
    //   1646: aload_0
    //   1647: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   1650: lload 8
    //   1652: iconst_0
    //   1653: invokestatic 1590	com/android/emailcommon/provider/Mailbox:b	(Landroid/content/Context;JI)Lcom/android/emailcommon/provider/Mailbox;
    //   1656: astore 14
    //   1658: aload 14
    //   1660: ifnonnull +65 -> 1725
    //   1663: aload 16
    //   1665: astore 13
    //   1667: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   1670: ldc_w 4006
    //   1673: iconst_1
    //   1674: anewarray 157	java/lang/Object
    //   1677: dup
    //   1678: iconst_0
    //   1679: lload 8
    //   1681: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1684: aastore
    //   1685: invokestatic 813	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1688: pop
    //   1689: aconst_null
    //   1690: astore 4
    //   1692: aload 4
    //   1694: astore_2
    //   1695: aload 4
    //   1697: ifnonnull -1666 -> 31
    //   1700: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   1703: ldc_w 3950
    //   1706: iconst_2
    //   1707: anewarray 157	java/lang/Object
    //   1710: dup
    //   1711: iconst_0
    //   1712: aload_1
    //   1713: aastore
    //   1714: dup
    //   1715: iconst_1
    //   1716: aload_3
    //   1717: aastore
    //   1718: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1721: pop
    //   1722: aload 4
    //   1724: areturn
    //   1725: aload 16
    //   1727: astore 13
    //   1729: aload_1
    //   1730: ldc_w 3946
    //   1733: invokevirtual 679	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   1736: astore 5
    //   1738: aload 5
    //   1740: ifnonnull +18 -> 1758
    //   1743: aload 16
    //   1745: astore 13
    //   1747: new 828	java/lang/IllegalArgumentException
    //   1750: dup
    //   1751: ldc_w 4008
    //   1754: invokespecial 833	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1757: athrow
    //   1758: aload 16
    //   1760: astore 13
    //   1762: aload_0
    //   1763: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   1766: astore 17
    //   1768: aload 16
    //   1770: astore 13
    //   1772: aload 17
    //   1774: lload 8
    //   1776: bipush 8
    //   1778: invokestatic 1590	com/android/emailcommon/provider/Mailbox:b	(Landroid/content/Context;JI)Lcom/android/emailcommon/provider/Mailbox;
    //   1781: astore 4
    //   1783: aload 4
    //   1785: ifnonnull +3526 -> 5311
    //   1788: aload 16
    //   1790: astore 13
    //   1792: new 958	com/android/emailcommon/provider/Mailbox
    //   1795: dup
    //   1796: invokespecial 4009	com/android/emailcommon/provider/Mailbox:<init>	()V
    //   1799: astore 4
    //   1801: aload 16
    //   1803: astore 13
    //   1805: aload 4
    //   1807: lload 8
    //   1809: putfield 1267	com/android/emailcommon/provider/Mailbox:g	J
    //   1812: aload 16
    //   1814: astore 13
    //   1816: aload 4
    //   1818: ldc_w 4011
    //   1821: putfield 1698	com/android/emailcommon/provider/Mailbox:d	Ljava/lang/String;
    //   1824: aload 16
    //   1826: astore 13
    //   1828: aload 4
    //   1830: iconst_0
    //   1831: putfield 4012	com/android/emailcommon/provider/Mailbox:n	Z
    //   1834: aload 16
    //   1836: astore 13
    //   1838: aload 4
    //   1840: ldc_w 4011
    //   1843: putfield 3261	com/android/emailcommon/provider/Mailbox:c	Ljava/lang/String;
    //   1846: aload 16
    //   1848: astore 13
    //   1850: aload 4
    //   1852: iconst_0
    //   1853: putfield 4013	com/android/emailcommon/provider/Mailbox:l	I
    //   1856: aload 16
    //   1858: astore 13
    //   1860: aload 4
    //   1862: bipush 8
    //   1864: putfield 1375	com/android/emailcommon/provider/Mailbox:h	I
    //   1867: aload 16
    //   1869: astore 13
    //   1871: aload 4
    //   1873: bipush 8
    //   1875: putfield 4014	com/android/emailcommon/provider/Mailbox:o	I
    //   1878: aload 16
    //   1880: astore 13
    //   1882: aload 4
    //   1884: ldc2_w 1099
    //   1887: putfield 4016	com/android/emailcommon/provider/Mailbox:f	J
    //   1890: aload 16
    //   1892: astore 13
    //   1894: aload 4
    //   1896: aload 17
    //   1898: invokevirtual 1593	com/android/emailcommon/provider/Mailbox:h	(Landroid/content/Context;)Landroid/net/Uri;
    //   1901: pop
    //   1902: aload 16
    //   1904: astore 13
    //   1906: aload 4
    //   1908: getfield 1302	com/android/emailcommon/provider/Mailbox:D	J
    //   1911: lstore 10
    //   1913: aload 16
    //   1915: astore 13
    //   1917: new 1896	com/android/emailcommon/service/SearchParams
    //   1920: dup
    //   1921: aload 14
    //   1923: getfield 1302	com/android/emailcommon/provider/Mailbox:D	J
    //   1926: aload 5
    //   1928: lload 10
    //   1930: invokespecial 4018	com/android/emailcommon/service/SearchParams:<init>	(JLjava/lang/String;J)V
    //   1933: astore 14
    //   1935: aload 16
    //   1937: astore 13
    //   1939: aload_0
    //   1940: getfield 392	com/android/email/provider/EmailProvider:ac	Lnx;
    //   1943: lload 10
    //   1945: aload 14
    //   1947: invokevirtual 4021	nx:b	(JLjava/lang/Object;)V
    //   1950: aload 16
    //   1952: astore 13
    //   1954: aload_0
    //   1955: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   1958: astore 17
    //   1960: aload 16
    //   1962: astore 13
    //   1964: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   1967: ldc_w 4023
    //   1970: iconst_0
    //   1971: anewarray 157	java/lang/Object
    //   1974: invokestatic 439	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1977: pop
    //   1978: aload 16
    //   1980: astore 13
    //   1982: aload 17
    //   1984: invokevirtual 500	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   1987: astore 18
    //   1989: aload 16
    //   1991: astore 13
    //   1993: new 163	android/content/ContentValues
    //   1996: dup
    //   1997: iconst_4
    //   1998: invokespecial 501	android/content/ContentValues:<init>	(I)V
    //   2001: astore 19
    //   2003: aload 16
    //   2005: astore 13
    //   2007: aload 19
    //   2009: ldc_w 2421
    //   2012: aload 5
    //   2014: invokevirtual 1082	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2017: aload 16
    //   2019: astore 13
    //   2021: aload 19
    //   2023: ldc_w 3058
    //   2026: iconst_2
    //   2027: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2030: invokevirtual 920	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2033: aload 16
    //   2035: astore 13
    //   2037: aload 19
    //   2039: ldc_w 3050
    //   2042: iconst_0
    //   2043: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2046: invokevirtual 920	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2049: aload 16
    //   2051: astore 13
    //   2053: aload 19
    //   2055: ldc_w 3062
    //   2058: iconst_0
    //   2059: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2062: invokevirtual 920	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2065: aload 16
    //   2067: astore 13
    //   2069: aload 18
    //   2071: getstatic 2337	com/android/emailcommon/provider/Mailbox:a	Landroid/net/Uri;
    //   2074: lload 10
    //   2076: invokestatic 674	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   2079: aload 19
    //   2081: aconst_null
    //   2082: aconst_null
    //   2083: invokevirtual 517	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2086: pop
    //   2087: aload 16
    //   2089: astore 13
    //   2091: getstatic 664	beb:a	Landroid/net/Uri;
    //   2094: astore 5
    //   2096: aload 16
    //   2098: astore 13
    //   2100: ldc_w 2740
    //   2103: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2106: astore 19
    //   2108: aload 16
    //   2110: astore 13
    //   2112: aload 18
    //   2114: aload 5
    //   2116: new 189	java/lang/StringBuilder
    //   2119: dup
    //   2120: aload 19
    //   2122: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2125: invokevirtual 193	java/lang/String:length	()I
    //   2128: bipush 20
    //   2130: iadd
    //   2131: invokespecial 194	java/lang/StringBuilder:<init>	(I)V
    //   2134: aload 19
    //   2136: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2139: lload 10
    //   2141: invokevirtual 1002	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2144: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2147: aconst_null
    //   2148: invokevirtual 2551	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   2151: pop
    //   2152: aload 16
    //   2154: astore 13
    //   2156: aload_0
    //   2157: aload 17
    //   2159: lload 8
    //   2161: aload 14
    //   2163: invokespecial 4025	com/android/email/provider/EmailProvider:a	(Landroid/content/Context;JLcom/android/emailcommon/service/SearchParams;)V
    //   2166: aload 16
    //   2168: astore 13
    //   2170: aload_0
    //   2171: ldc_w 3793
    //   2174: getstatic 2337	com/android/emailcommon/provider/Mailbox:a	Landroid/net/Uri;
    //   2177: aload 4
    //   2179: getfield 1302	com/android/emailcommon/provider/Mailbox:D	J
    //   2182: invokestatic 674	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   2185: aload_2
    //   2186: iconst_0
    //   2187: invokespecial 4027	com/android/email/provider/EmailProvider:a	(ILandroid/net/Uri;[Ljava/lang/String;Z)Landroid/database/Cursor;
    //   2190: astore 4
    //   2192: goto -500 -> 1692
    //   2195: aconst_null
    //   2196: astore 4
    //   2198: aload 16
    //   2200: astore 13
    //   2202: aload_0
    //   2203: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   2206: astore 5
    //   2208: iload 6
    //   2210: tableswitch	default:+18->2228, 32793:+51->2261
    //   2228: aload 4
    //   2230: astore_2
    //   2231: aload 4
    //   2233: ifnonnull -2202 -> 31
    //   2236: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   2239: ldc_w 3950
    //   2242: iconst_2
    //   2243: anewarray 157	java/lang/Object
    //   2246: dup
    //   2247: iconst_0
    //   2248: aload_1
    //   2249: aastore
    //   2250: dup
    //   2251: iconst_1
    //   2252: aload_3
    //   2253: aastore
    //   2254: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2257: pop
    //   2258: aload 4
    //   2260: areturn
    //   2261: aconst_null
    //   2262: astore 4
    //   2264: aload 16
    //   2266: astore 13
    //   2268: aload_1
    //   2269: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   2272: astore 14
    //   2274: aload 16
    //   2276: astore 13
    //   2278: aload_0
    //   2279: aload_0
    //   2280: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   2283: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   2286: astore 17
    //   2288: aload 16
    //   2290: astore 13
    //   2292: aload_1
    //   2293: ldc_w 2988
    //   2296: invokevirtual 679	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   2299: astore 18
    //   2301: aload 16
    //   2303: astore 13
    //   2305: aload 18
    //   2307: invokestatic 757	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2310: ifne +56 -> 2366
    //   2313: aload 16
    //   2315: astore 13
    //   2317: invokestatic 1700	com/android/email/provider/EmailProvider:m	()Lany;
    //   2320: aload_2
    //   2321: invokestatic 1684	com/android/email/provider/EmailProvider:a	(Lany;[Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2324: astore_2
    //   2325: aload 16
    //   2327: astore 13
    //   2329: aload_2
    //   2330: ldc_w 4029
    //   2333: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2336: pop
    //   2337: aload 16
    //   2339: astore 13
    //   2341: aload 17
    //   2343: aload_2
    //   2344: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2347: iconst_2
    //   2348: anewarray 106	java/lang/String
    //   2351: dup
    //   2352: iconst_0
    //   2353: aload 18
    //   2355: aastore
    //   2356: dup
    //   2357: iconst_1
    //   2358: aload 14
    //   2360: aastore
    //   2361: invokevirtual 656	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   2364: astore 4
    //   2366: aload 4
    //   2368: ifnull +2940 -> 5308
    //   2371: aload 16
    //   2373: astore 13
    //   2375: new 1059	ayv
    //   2378: dup
    //   2379: aload 5
    //   2381: aload 4
    //   2383: invokespecial 1062	ayv:<init>	(Landroid/content/Context;Landroid/database/Cursor;)V
    //   2386: astore 4
    //   2388: goto -160 -> 2228
    //   2391: aload 16
    //   2393: astore 13
    //   2395: aload_1
    //   2396: ldc_w 4031
    //   2399: invokevirtual 679	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   2402: astore 4
    //   2404: aload 4
    //   2406: ifnull +2914 -> 5320
    //   2409: aload 16
    //   2411: astore 13
    //   2413: aload 4
    //   2415: invokestatic 4034	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   2418: ifeq +2902 -> 5320
    //   2421: iconst_1
    //   2422: istore 12
    //   2424: aload 16
    //   2426: astore 13
    //   2428: aload_0
    //   2429: aload_2
    //   2430: iload 12
    //   2432: invokespecial 4036	com/android/email/provider/EmailProvider:a	([Ljava/lang/String;Z)Landroid/database/Cursor;
    //   2435: areturn
    //   2436: aload 16
    //   2438: astore 13
    //   2440: aload_0
    //   2441: aload_2
    //   2442: invokespecial 4038	com/android/email/provider/EmailProvider:f	([Ljava/lang/String;)Landroid/database/Cursor;
    //   2445: astore_2
    //   2446: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   2449: ldc_w 3950
    //   2452: iconst_2
    //   2453: anewarray 157	java/lang/Object
    //   2456: dup
    //   2457: iconst_0
    //   2458: aload_1
    //   2459: aastore
    //   2460: dup
    //   2461: iconst_1
    //   2462: aload_3
    //   2463: aastore
    //   2464: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2467: pop
    //   2468: aload_2
    //   2469: areturn
    //   2470: aload_3
    //   2471: ifnonnull +8 -> 2479
    //   2474: aload 4
    //   2476: ifnull +18 -> 2494
    //   2479: aload 16
    //   2481: astore 13
    //   2483: new 828	java/lang/IllegalArgumentException
    //   2486: dup
    //   2487: ldc_w 4040
    //   2490: invokespecial 833	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   2493: athrow
    //   2494: aload 16
    //   2496: astore 13
    //   2498: aload_1
    //   2499: ldc_w 842
    //   2502: invokevirtual 679	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   2505: astore 4
    //   2507: aload 4
    //   2509: ifnull +73 -> 2582
    //   2512: aload 16
    //   2514: astore 13
    //   2516: getstatic 4044	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2519: invokevirtual 4045	java/lang/Boolean:toString	()Ljava/lang/String;
    //   2522: aload 4
    //   2524: invokevirtual 838	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2527: ifeq +55 -> 2582
    //   2530: iconst_1
    //   2531: istore 12
    //   2533: aload 16
    //   2535: astore 13
    //   2537: aload_0
    //   2538: iload 6
    //   2540: aload_1
    //   2541: aload_2
    //   2542: iload 12
    //   2544: invokespecial 4027	com/android/email/provider/EmailProvider:a	(ILandroid/net/Uri;[Ljava/lang/String;Z)Landroid/database/Cursor;
    //   2547: astore 4
    //   2549: aload 4
    //   2551: astore_2
    //   2552: aload 4
    //   2554: ifnonnull -2523 -> 31
    //   2557: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   2560: ldc_w 3950
    //   2563: iconst_2
    //   2564: anewarray 157	java/lang/Object
    //   2567: dup
    //   2568: iconst_0
    //   2569: aload_1
    //   2570: aastore
    //   2571: dup
    //   2572: iconst_1
    //   2573: aload_3
    //   2574: aastore
    //   2575: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2578: pop
    //   2579: aload 4
    //   2581: areturn
    //   2582: iconst_0
    //   2583: istore 12
    //   2585: goto -52 -> 2533
    //   2588: aload 16
    //   2590: astore 13
    //   2592: aload_0
    //   2593: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   2596: astore 4
    //   2598: aload 16
    //   2600: astore 13
    //   2602: aload_0
    //   2603: aload 4
    //   2605: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   2608: astore 17
    //   2610: aload 16
    //   2612: astore 13
    //   2614: aload_1
    //   2615: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   2618: iconst_1
    //   2619: invokeinterface 619 2 0
    //   2624: checkcast 106	java/lang/String
    //   2627: astore 14
    //   2629: aload 16
    //   2631: astore 13
    //   2633: getstatic 927	com/android/email/provider/EmailProvider:C	Landroid/net/Uri;
    //   2636: invokevirtual 523	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   2639: aload 14
    //   2641: invokevirtual 930	android/net/Uri$Builder:appendEncodedPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   2644: invokevirtual 533	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   2647: astore 5
    //   2649: aload 16
    //   2651: astore 13
    //   2653: getstatic 352	com/android/email/provider/EmailProvider:Z	Ljava/lang/String;
    //   2656: aload 14
    //   2658: invokevirtual 838	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2661: ifeq +34 -> 2695
    //   2664: aload 16
    //   2666: astore 13
    //   2668: aload_0
    //   2669: aload 14
    //   2671: aload_2
    //   2672: invokespecial 932	com/android/email/provider/EmailProvider:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   2675: astore_2
    //   2676: aload 16
    //   2678: astore 13
    //   2680: aload_2
    //   2681: aload 4
    //   2683: invokevirtual 500	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   2686: aload 5
    //   2688: invokeinterface 925 3 0
    //   2693: aload_2
    //   2694: areturn
    //   2695: aload 16
    //   2697: astore 13
    //   2699: getstatic 2648	chh:i	[Ljava/lang/String;
    //   2702: astore 18
    //   2704: aload 16
    //   2706: astore 13
    //   2708: invokestatic 1695	com/android/email/provider/EmailProvider:n	()Lany;
    //   2711: aload 18
    //   2713: invokestatic 1684	com/android/email/provider/EmailProvider:a	(Lany;[Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2716: astore 18
    //   2718: aload 16
    //   2720: astore 13
    //   2722: aload 18
    //   2724: ldc_w 4047
    //   2727: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2730: pop
    //   2731: aload 16
    //   2733: astore 13
    //   2735: aload 18
    //   2737: ldc_w 4049
    //   2740: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2743: pop
    //   2744: aload 16
    //   2746: astore 13
    //   2748: aload 18
    //   2750: ldc_w 2746
    //   2753: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2756: pop
    //   2757: aload 16
    //   2759: astore 13
    //   2761: aload_0
    //   2762: aload 17
    //   2764: aload 18
    //   2766: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2769: iconst_1
    //   2770: anewarray 106	java/lang/String
    //   2773: dup
    //   2774: iconst_0
    //   2775: aload 14
    //   2777: aastore
    //   2778: invokevirtual 656	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   2781: aload 14
    //   2783: invokestatic 949	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   2786: invokevirtual 555	java/lang/Long:longValue	()J
    //   2789: aload_2
    //   2790: invokespecial 952	com/android/email/provider/EmailProvider:a	(Landroid/database/Cursor;J[Ljava/lang/String;)Landroid/database/Cursor;
    //   2793: astore 17
    //   2795: aload 16
    //   2797: astore 13
    //   2799: aload 17
    //   2801: aload 4
    //   2803: invokevirtual 500	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   2806: aload 5
    //   2808: invokeinterface 925 3 0
    //   2813: aload 16
    //   2815: astore 13
    //   2817: aload 17
    //   2819: invokeinterface 938 1 0
    //   2824: ifle +2481 -> 5305
    //   2827: aload 16
    //   2829: astore 13
    //   2831: aload_0
    //   2832: aload 14
    //   2834: aload_2
    //   2835: invokespecial 932	com/android/email/provider/EmailProvider:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   2838: astore_2
    //   2839: aload 16
    //   2841: astore 13
    //   2843: aload_2
    //   2844: aload 4
    //   2846: invokevirtual 500	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   2849: aload 5
    //   2851: invokeinterface 925 3 0
    //   2856: aload 16
    //   2858: astore 13
    //   2860: new 940	android/database/MergeCursor
    //   2863: dup
    //   2864: iconst_2
    //   2865: anewarray 415	android/database/Cursor
    //   2868: dup
    //   2869: iconst_0
    //   2870: aload_2
    //   2871: aastore
    //   2872: dup
    //   2873: iconst_1
    //   2874: aload 17
    //   2876: aastore
    //   2877: invokespecial 943	android/database/MergeCursor:<init>	([Landroid/database/Cursor;)V
    //   2880: areturn
    //   2881: aload 16
    //   2883: astore 13
    //   2885: aload_1
    //   2886: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   2889: invokestatic 552	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2892: lstore 8
    //   2894: aload 16
    //   2896: astore 13
    //   2898: aload_0
    //   2899: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   2902: lload 8
    //   2904: invokestatic 1508	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Mailbox;
    //   2907: astore_2
    //   2908: aload_2
    //   2909: ifnull +72 -> 2981
    //   2912: aload 16
    //   2914: astore 13
    //   2916: aload_2
    //   2917: getfield 1375	com/android/emailcommon/provider/Mailbox:h	I
    //   2920: bipush 8
    //   2922: if_icmpne +83 -> 3005
    //   2925: aload 16
    //   2927: astore 13
    //   2929: aload_0
    //   2930: getfield 392	com/android/email/provider/EmailProvider:ac	Lnx;
    //   2933: aload_2
    //   2934: getfield 1302	com/android/emailcommon/provider/Mailbox:D	J
    //   2937: aconst_null
    //   2938: invokevirtual 1691	nx:a	(JLjava/lang/Object;)Ljava/lang/Object;
    //   2941: checkcast 1896	com/android/emailcommon/service/SearchParams
    //   2944: astore 4
    //   2946: aload 16
    //   2948: astore 13
    //   2950: aload 4
    //   2952: aload 4
    //   2954: getfield 4050	com/android/emailcommon/service/SearchParams:g	I
    //   2957: bipush 10
    //   2959: iadd
    //   2960: putfield 4050	com/android/emailcommon/service/SearchParams:g	I
    //   2963: aload 16
    //   2965: astore 13
    //   2967: aload_0
    //   2968: aload_0
    //   2969: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   2972: aload_2
    //   2973: getfield 1267	com/android/emailcommon/provider/Mailbox:g	J
    //   2976: aload 4
    //   2978: invokespecial 4025	com/android/email/provider/EmailProvider:a	(Landroid/content/Context;JLcom/android/emailcommon/service/SearchParams;)V
    //   2981: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   2984: ldc_w 3950
    //   2987: iconst_2
    //   2988: anewarray 157	java/lang/Object
    //   2991: dup
    //   2992: iconst_0
    //   2993: aload_1
    //   2994: aastore
    //   2995: dup
    //   2996: iconst_1
    //   2997: aload_3
    //   2998: aastore
    //   2999: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   3002: pop
    //   3003: aconst_null
    //   3004: areturn
    //   3005: aload 16
    //   3007: astore 13
    //   3009: aload_0
    //   3010: aload_2
    //   3011: bipush 10
    //   3013: invokespecial 2766	com/android/email/provider/EmailProvider:b	(Lcom/android/emailcommon/provider/Mailbox;I)Landroid/database/Cursor;
    //   3016: pop
    //   3017: goto -36 -> 2981
    //   3020: aload 16
    //   3022: astore 13
    //   3024: aload_0
    //   3025: aload_1
    //   3026: invokespecial 4052	com/android/email/provider/EmailProvider:f	(Landroid/net/Uri;)Landroid/database/Cursor;
    //   3029: astore 4
    //   3031: aload 4
    //   3033: astore_2
    //   3034: aload 4
    //   3036: ifnonnull -3005 -> 31
    //   3039: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   3042: ldc_w 3950
    //   3045: iconst_2
    //   3046: anewarray 157	java/lang/Object
    //   3049: dup
    //   3050: iconst_0
    //   3051: aload_1
    //   3052: aastore
    //   3053: dup
    //   3054: iconst_1
    //   3055: aload_3
    //   3056: aastore
    //   3057: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   3060: pop
    //   3061: aload 4
    //   3063: areturn
    //   3064: aload 16
    //   3066: astore 13
    //   3068: aload_0
    //   3069: aload_0
    //   3070: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   3073: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   3076: ldc_w 4054
    //   3079: iconst_1
    //   3080: anewarray 106	java/lang/String
    //   3083: dup
    //   3084: iconst_0
    //   3085: aload_1
    //   3086: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   3089: aastore
    //   3090: invokevirtual 656	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   3093: astore 4
    //   3095: aload 4
    //   3097: astore_2
    //   3098: aload 4
    //   3100: ifnonnull -3069 -> 31
    //   3103: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   3106: ldc_w 3950
    //   3109: iconst_2
    //   3110: anewarray 157	java/lang/Object
    //   3113: dup
    //   3114: iconst_0
    //   3115: aload_1
    //   3116: aastore
    //   3117: dup
    //   3118: iconst_1
    //   3119: aload_3
    //   3120: aastore
    //   3121: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   3124: pop
    //   3125: aload 4
    //   3127: areturn
    //   3128: aload 16
    //   3130: astore 13
    //   3132: aload_0
    //   3133: aload_0
    //   3134: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   3137: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   3140: ldc_w 4056
    //   3143: iconst_1
    //   3144: anewarray 106	java/lang/String
    //   3147: dup
    //   3148: iconst_0
    //   3149: aload_1
    //   3150: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   3153: aastore
    //   3154: invokevirtual 656	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   3157: astore 4
    //   3159: aload 4
    //   3161: astore_2
    //   3162: aload 4
    //   3164: ifnonnull -3133 -> 31
    //   3167: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   3170: ldc_w 3950
    //   3173: iconst_2
    //   3174: anewarray 157	java/lang/Object
    //   3177: dup
    //   3178: iconst_0
    //   3179: aload_1
    //   3180: aastore
    //   3181: dup
    //   3182: iconst_1
    //   3183: aload_3
    //   3184: aastore
    //   3185: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   3188: pop
    //   3189: aload 4
    //   3191: areturn
    //   3192: aload 16
    //   3194: astore 13
    //   3196: aload_0
    //   3197: aload_0
    //   3198: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   3201: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   3204: ldc_w 4058
    //   3207: iconst_1
    //   3208: anewarray 106	java/lang/String
    //   3211: dup
    //   3212: iconst_0
    //   3213: aload_1
    //   3214: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   3217: aastore
    //   3218: invokevirtual 656	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   3221: astore 4
    //   3223: aload 4
    //   3225: astore_2
    //   3226: aload 4
    //   3228: ifnonnull -3197 -> 31
    //   3231: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   3234: ldc_w 3950
    //   3237: iconst_2
    //   3238: anewarray 157	java/lang/Object
    //   3241: dup
    //   3242: iconst_0
    //   3243: aload_1
    //   3244: aastore
    //   3245: dup
    //   3246: iconst_1
    //   3247: aload_3
    //   3248: aastore
    //   3249: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   3252: pop
    //   3253: aload 4
    //   3255: areturn
    //   3256: aload 16
    //   3258: astore 13
    //   3260: aload 17
    //   3262: ldc -48
    //   3264: aload_2
    //   3265: aload_3
    //   3266: aload 4
    //   3268: aconst_null
    //   3269: aconst_null
    //   3270: aload 5
    //   3272: aload 18
    //   3274: invokevirtual 3538	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   3277: astore_2
    //   3278: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   3281: ldc_w 3950
    //   3284: iconst_2
    //   3285: anewarray 157	java/lang/Object
    //   3288: dup
    //   3289: iconst_0
    //   3290: aload_1
    //   3291: aastore
    //   3292: dup
    //   3293: iconst_1
    //   3294: aload_3
    //   3295: aastore
    //   3296: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   3299: pop
    //   3300: aload_2
    //   3301: areturn
    //   3302: aload 16
    //   3304: astore 13
    //   3306: invokestatic 3934	android/os/Binder:getCallingPid	()I
    //   3309: invokestatic 3939	android/os/Process:myPid	()I
    //   3312: if_icmpne +2014 -> 5326
    //   3315: aload 16
    //   3317: astore 13
    //   3319: aload_1
    //   3320: ldc_w 4060
    //   3323: iconst_0
    //   3324: invokevirtual 647	android/net/Uri:getBooleanQueryParameter	(Ljava/lang/String;Z)Z
    //   3327: ifeq +82 -> 3409
    //   3330: goto +1996 -> 5326
    //   3333: aload 16
    //   3335: astore 13
    //   3337: aload 17
    //   3339: ldc -19
    //   3341: aload_2
    //   3342: aload_3
    //   3343: aload 4
    //   3345: aconst_null
    //   3346: aconst_null
    //   3347: aload 5
    //   3349: aload 18
    //   3351: invokevirtual 3538	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   3354: astore_2
    //   3355: iload 6
    //   3357: ifeq +58 -> 3415
    //   3360: aload_2
    //   3361: ifnull +54 -> 3415
    //   3364: aload 16
    //   3366: astore 13
    //   3368: new 4062	azl
    //   3371: dup
    //   3372: aload_2
    //   3373: invokespecial 4063	azl:<init>	(Landroid/database/Cursor;)V
    //   3376: astore_2
    //   3377: aload 16
    //   3379: astore 13
    //   3381: aload_2
    //   3382: invokevirtual 4064	azl:a	()V
    //   3385: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   3388: ldc_w 3950
    //   3391: iconst_2
    //   3392: anewarray 157	java/lang/Object
    //   3395: dup
    //   3396: iconst_0
    //   3397: aload_1
    //   3398: aastore
    //   3399: dup
    //   3400: iconst_1
    //   3401: aload_3
    //   3402: aastore
    //   3403: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   3406: pop
    //   3407: aload_2
    //   3408: areturn
    //   3409: iconst_0
    //   3410: istore 6
    //   3412: goto -79 -> 3333
    //   3415: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   3418: ldc_w 3950
    //   3421: iconst_2
    //   3422: anewarray 157	java/lang/Object
    //   3425: dup
    //   3426: iconst_0
    //   3427: aload_1
    //   3428: aastore
    //   3429: dup
    //   3430: iconst_1
    //   3431: aload_3
    //   3432: aastore
    //   3433: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   3436: pop
    //   3437: aload_2
    //   3438: areturn
    //   3439: aload 16
    //   3441: astore 13
    //   3443: aload 17
    //   3445: aload 19
    //   3447: aload_2
    //   3448: aload_3
    //   3449: aload 4
    //   3451: aconst_null
    //   3452: aconst_null
    //   3453: aload 5
    //   3455: aload 18
    //   3457: invokevirtual 3538	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   3460: astore 4
    //   3462: aload 4
    //   3464: ifnonnull +25 -> 3489
    //   3467: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   3470: ldc_w 3950
    //   3473: iconst_2
    //   3474: anewarray 157	java/lang/Object
    //   3477: dup
    //   3478: iconst_0
    //   3479: aload_1
    //   3480: aastore
    //   3481: dup
    //   3482: iconst_1
    //   3483: aload_3
    //   3484: aastore
    //   3485: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   3488: pop
    //   3489: aload 4
    //   3491: astore_2
    //   3492: aload 4
    //   3494: ifnull -3463 -> 31
    //   3497: aload 4
    //   3499: astore_2
    //   3500: aload_0
    //   3501: invokevirtual 4067	com/android/email/provider/EmailProvider:isTemporary	()Z
    //   3504: ifne -3473 -> 31
    //   3507: aload 4
    //   3509: aload_0
    //   3510: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   3513: invokevirtual 500	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   3516: aload_1
    //   3517: invokeinterface 925 3 0
    //   3522: aload 4
    //   3524: areturn
    //   3525: aload 16
    //   3527: astore 13
    //   3529: aload_0
    //   3530: aload_0
    //   3531: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   3534: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   3537: astore 4
    //   3539: aload 16
    //   3541: astore 13
    //   3543: invokestatic 4069	com/android/email/provider/EmailProvider:o	()Lany;
    //   3546: aload_2
    //   3547: invokestatic 1684	com/android/email/provider/EmailProvider:a	(Lany;[Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3550: astore_2
    //   3551: aload 16
    //   3553: astore 13
    //   3555: aload_2
    //   3556: ldc_w 4071
    //   3559: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3562: pop
    //   3563: aload 16
    //   3565: astore 13
    //   3567: aload 4
    //   3569: aload_2
    //   3570: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3573: iconst_0
    //   3574: anewarray 106	java/lang/String
    //   3577: invokevirtual 656	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   3580: astore 4
    //   3582: goto -120 -> 3462
    //   3585: aload 16
    //   3587: astore 13
    //   3589: new 2405	anz
    //   3592: dup
    //   3593: invokespecial 2406	anz:<init>	()V
    //   3596: aload_2
    //   3597: invokevirtual 4074	anz:a	([Ljava/lang/String;)Lanz;
    //   3600: invokevirtual 2458	anz:a	()Lany;
    //   3603: astore 19
    //   3605: aload 16
    //   3607: astore 13
    //   3609: aload 19
    //   3611: ldc_w 1866
    //   3614: invokevirtual 4075	any:containsKey	(Ljava/lang/Object;)Z
    //   3617: ifne +18 -> 3635
    //   3620: aload 16
    //   3622: astore 13
    //   3624: aload 19
    //   3626: ldc_w 1871
    //   3629: invokevirtual 4075	any:containsKey	(Ljava/lang/Object;)Z
    //   3632: ifeq +18 -> 3650
    //   3635: aload 16
    //   3637: astore 13
    //   3639: new 828	java/lang/IllegalArgumentException
    //   3642: dup
    //   3643: ldc_w 4077
    //   3646: invokespecial 833	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   3649: athrow
    //   3650: aload 16
    //   3652: astore 13
    //   3654: new 163	android/content/ContentValues
    //   3657: dup
    //   3658: iconst_2
    //   3659: invokespecial 501	android/content/ContentValues:<init>	(I)V
    //   3662: astore 20
    //   3664: aload 16
    //   3666: astore 13
    //   3668: ldc_w 1736
    //   3671: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3674: astore 14
    //   3676: aload 16
    //   3678: astore 13
    //   3680: ldc_w 1298
    //   3683: ldc_w 1092
    //   3686: invokestatic 2411	com/android/email/provider/EmailProvider:d	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3689: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3692: astore 21
    //   3694: aload 16
    //   3696: astore 13
    //   3698: aload 21
    //   3700: invokevirtual 193	java/lang/String:length	()I
    //   3703: ifeq +250 -> 3953
    //   3706: aload 16
    //   3708: astore 13
    //   3710: aload 14
    //   3712: aload 21
    //   3714: invokevirtual 1249	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   3717: astore 14
    //   3719: aload 16
    //   3721: astore 13
    //   3723: aload 20
    //   3725: ldc_w 4079
    //   3728: aload 14
    //   3730: invokevirtual 1082	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3733: aload 16
    //   3735: astore 13
    //   3737: ldc_w 1736
    //   3740: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3743: astore 14
    //   3745: aload 16
    //   3747: astore 13
    //   3749: ldc_w 1293
    //   3752: ldc_w 1092
    //   3755: invokestatic 2411	com/android/email/provider/EmailProvider:d	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3758: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3761: astore 21
    //   3763: aload 16
    //   3765: astore 13
    //   3767: aload 21
    //   3769: invokevirtual 193	java/lang/String:length	()I
    //   3772: ifeq +199 -> 3971
    //   3775: aload 16
    //   3777: astore 13
    //   3779: aload 14
    //   3781: aload 21
    //   3783: invokevirtual 1249	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   3786: astore 14
    //   3788: aload 16
    //   3790: astore 13
    //   3792: aload 20
    //   3794: ldc_w 4081
    //   3797: aload 14
    //   3799: invokevirtual 1082	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3802: aload 16
    //   3804: astore 13
    //   3806: aload 19
    //   3808: aload_2
    //   3809: aload 20
    //   3811: invokestatic 984	com/android/email/provider/EmailProvider:a	(Lany;[Ljava/lang/String;Landroid/content/ContentValues;)Ljava/lang/StringBuilder;
    //   3814: astore_2
    //   3815: aload 16
    //   3817: astore 13
    //   3819: aload_2
    //   3820: ldc_w 4083
    //   3823: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3826: pop
    //   3827: iload 6
    //   3829: ldc_w 3731
    //   3832: if_icmpne +157 -> 3989
    //   3835: aload 16
    //   3837: astore 13
    //   3839: aload_1
    //   3840: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   3843: iconst_1
    //   3844: invokeinterface 619 2 0
    //   3849: checkcast 106	java/lang/String
    //   3852: astore 14
    //   3854: aload 16
    //   3856: astore 13
    //   3858: aload_2
    //   3859: ldc_w 1010
    //   3862: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3865: aload 14
    //   3867: aload_3
    //   3868: invokestatic 3355	com/android/email/provider/EmailProvider:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3871: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3874: pop
    //   3875: aload 16
    //   3877: astore 13
    //   3879: aload 5
    //   3881: invokestatic 757	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3884: ifne +20 -> 3904
    //   3887: aload 16
    //   3889: astore 13
    //   3891: aload_2
    //   3892: ldc_w 4049
    //   3895: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3898: aload 5
    //   3900: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3903: pop
    //   3904: aload 16
    //   3906: astore 13
    //   3908: aload 18
    //   3910: invokestatic 757	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3913: ifne +20 -> 3933
    //   3916: aload 16
    //   3918: astore 13
    //   3920: aload_2
    //   3921: ldc_w 4085
    //   3924: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3927: aload 18
    //   3929: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3932: pop
    //   3933: aload 16
    //   3935: astore 13
    //   3937: aload 17
    //   3939: aload_2
    //   3940: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3943: aload 4
    //   3945: invokevirtual 656	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   3948: astore 4
    //   3950: goto -488 -> 3462
    //   3953: aload 16
    //   3955: astore 13
    //   3957: new 106	java/lang/String
    //   3960: dup
    //   3961: aload 14
    //   3963: invokespecial 1734	java/lang/String:<init>	(Ljava/lang/String;)V
    //   3966: astore 14
    //   3968: goto -249 -> 3719
    //   3971: aload 16
    //   3973: astore 13
    //   3975: new 106	java/lang/String
    //   3978: dup
    //   3979: aload 14
    //   3981: invokespecial 1734	java/lang/String:<init>	(Ljava/lang/String;)V
    //   3984: astore 14
    //   3986: goto -198 -> 3788
    //   3989: aload 16
    //   3991: astore 13
    //   3993: aload_3
    //   3994: invokestatic 757	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3997: ifne -122 -> 3875
    //   4000: aload 16
    //   4002: astore 13
    //   4004: aload_2
    //   4005: ldc_w 1010
    //   4008: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4011: aload_3
    //   4012: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4015: pop
    //   4016: goto -141 -> 3875
    //   4019: aload 16
    //   4021: astore 13
    //   4023: aload 17
    //   4025: aload 19
    //   4027: aload_2
    //   4028: aload_1
    //   4029: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   4032: iconst_1
    //   4033: invokeinterface 619 2 0
    //   4038: checkcast 106	java/lang/String
    //   4041: aload_3
    //   4042: invokestatic 3355	com/android/email/provider/EmailProvider:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4045: aload 4
    //   4047: aconst_null
    //   4048: aconst_null
    //   4049: aload 5
    //   4051: aload 18
    //   4053: invokevirtual 3538	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   4056: astore 4
    //   4058: goto -596 -> 3462
    //   4061: aload 16
    //   4063: astore 13
    //   4065: aload_1
    //   4066: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   4069: iconst_1
    //   4070: invokeinterface 619 2 0
    //   4075: checkcast 106	java/lang/String
    //   4078: astore 4
    //   4080: aload 16
    //   4082: astore 13
    //   4084: aload_0
    //   4085: aload_0
    //   4086: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   4089: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   4092: astore 5
    //   4094: aload 16
    //   4096: astore 13
    //   4098: invokestatic 4069	com/android/email/provider/EmailProvider:o	()Lany;
    //   4101: aload_2
    //   4102: invokestatic 1684	com/android/email/provider/EmailProvider:a	(Lany;[Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4105: astore_2
    //   4106: aload 16
    //   4108: astore 13
    //   4110: aload_2
    //   4111: ldc_w 4071
    //   4114: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4117: pop
    //   4118: aload 16
    //   4120: astore 13
    //   4122: aload_2
    //   4123: ldc_w 4087
    //   4126: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4129: pop
    //   4130: aload 16
    //   4132: astore 13
    //   4134: aload 5
    //   4136: aload_2
    //   4137: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4140: iconst_1
    //   4141: anewarray 106	java/lang/String
    //   4144: dup
    //   4145: iconst_0
    //   4146: aload 4
    //   4148: aastore
    //   4149: invokevirtual 656	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   4152: astore 4
    //   4154: goto -692 -> 3462
    //   4157: aload 16
    //   4159: astore 13
    //   4161: aload_1
    //   4162: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   4165: iconst_2
    //   4166: invokeinterface 619 2 0
    //   4171: checkcast 106	java/lang/String
    //   4174: astore 19
    //   4176: aload 16
    //   4178: astore 13
    //   4180: ldc_w 3357
    //   4183: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4186: astore 14
    //   4188: aload 16
    //   4190: astore 13
    //   4192: aload 19
    //   4194: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4197: astore 19
    //   4199: aload 16
    //   4201: astore 13
    //   4203: aload 19
    //   4205: invokevirtual 193	java/lang/String:length	()I
    //   4208: ifeq +47 -> 4255
    //   4211: aload 16
    //   4213: astore 13
    //   4215: aload 14
    //   4217: aload 19
    //   4219: invokevirtual 1249	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4222: astore 14
    //   4224: aload 16
    //   4226: astore 13
    //   4228: aload 17
    //   4230: ldc -126
    //   4232: aload_2
    //   4233: aload 14
    //   4235: aload_3
    //   4236: invokestatic 3359	com/android/email/provider/EmailProvider:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4239: aload 4
    //   4241: aconst_null
    //   4242: aconst_null
    //   4243: aload 5
    //   4245: aload 18
    //   4247: invokevirtual 3538	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   4250: astore 4
    //   4252: goto -790 -> 3462
    //   4255: aload 16
    //   4257: astore 13
    //   4259: new 106	java/lang/String
    //   4262: dup
    //   4263: aload 14
    //   4265: invokespecial 1734	java/lang/String:<init>	(Ljava/lang/String;)V
    //   4268: astore 14
    //   4270: goto -46 -> 4224
    //   4273: aload 16
    //   4275: astore 13
    //   4277: aload_1
    //   4278: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   4281: iconst_2
    //   4282: invokeinterface 619 2 0
    //   4287: checkcast 106	java/lang/String
    //   4290: astore 4
    //   4292: aload 16
    //   4294: astore 13
    //   4296: aload_0
    //   4297: aload_0
    //   4298: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   4301: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   4304: astore 5
    //   4306: aload 16
    //   4308: astore 13
    //   4310: invokestatic 4069	com/android/email/provider/EmailProvider:o	()Lany;
    //   4313: aload_2
    //   4314: invokestatic 1684	com/android/email/provider/EmailProvider:a	(Lany;[Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4317: astore_2
    //   4318: aload 16
    //   4320: astore 13
    //   4322: aload_2
    //   4323: ldc_w 4071
    //   4326: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4329: pop
    //   4330: aload 16
    //   4332: astore 13
    //   4334: aload_2
    //   4335: ldc_w 4089
    //   4338: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4341: pop
    //   4342: aload 16
    //   4344: astore 13
    //   4346: aload 5
    //   4348: aload_2
    //   4349: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4352: iconst_1
    //   4353: anewarray 106	java/lang/String
    //   4356: dup
    //   4357: iconst_0
    //   4358: aload 4
    //   4360: aastore
    //   4361: invokevirtual 656	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   4364: astore 4
    //   4366: goto -904 -> 3462
    //   4369: aload_2
    //   4370: astore 5
    //   4372: aload_2
    //   4373: ifnonnull +40 -> 4413
    //   4376: aload 16
    //   4378: astore 13
    //   4380: iconst_4
    //   4381: anewarray 106	java/lang/String
    //   4384: astore 5
    //   4386: aload 5
    //   4388: iconst_0
    //   4389: ldc 108
    //   4391: aastore
    //   4392: aload 5
    //   4394: iconst_1
    //   4395: ldc_w 4091
    //   4398: aastore
    //   4399: aload 5
    //   4401: iconst_2
    //   4402: ldc_w 3090
    //   4405: aastore
    //   4406: aload 5
    //   4408: iconst_3
    //   4409: ldc_w 3092
    //   4412: aastore
    //   4413: aload 16
    //   4415: astore 13
    //   4417: aload 17
    //   4419: ldc -126
    //   4421: getstatic 178	com/android/email/provider/EmailProvider:r	[Ljava/lang/String;
    //   4424: ldc_w 3535
    //   4427: iconst_1
    //   4428: anewarray 106	java/lang/String
    //   4431: dup
    //   4432: iconst_0
    //   4433: aload_1
    //   4434: invokevirtual 1458	android/net/Uri:toString	()Ljava/lang/String;
    //   4437: aastore
    //   4438: aconst_null
    //   4439: aconst_null
    //   4440: aconst_null
    //   4441: aconst_null
    //   4442: invokevirtual 3538	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   4445: astore 4
    //   4447: aload 4
    //   4449: ifnull +32 -> 4481
    //   4452: aload 4
    //   4454: invokeinterface 938 1 0
    //   4459: iconst_1
    //   4460: if_icmple +21 -> 4481
    //   4463: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   4466: ldc_w 4093
    //   4469: iconst_1
    //   4470: anewarray 157	java/lang/Object
    //   4473: dup
    //   4474: iconst_0
    //   4475: aload_1
    //   4476: aastore
    //   4477: invokestatic 881	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   4480: pop
    //   4481: aload 4
    //   4483: ifnull +298 -> 4781
    //   4486: aload 4
    //   4488: invokeinterface 568 1 0
    //   4493: ifeq +288 -> 4781
    //   4496: new 1114	cvp
    //   4499: dup
    //   4500: aload 5
    //   4502: invokespecial 1115	cvp:<init>	([Ljava/lang/String;)V
    //   4505: astore 13
    //   4507: aload 5
    //   4509: arraylength
    //   4510: anewarray 157	java/lang/Object
    //   4513: astore_2
    //   4514: iconst_0
    //   4515: istore 6
    //   4517: aload 5
    //   4519: arraylength
    //   4520: istore 7
    //   4522: iload 6
    //   4524: iload 7
    //   4526: if_icmpge +201 -> 4727
    //   4529: aload 5
    //   4531: iload 6
    //   4533: aaload
    //   4534: astore 14
    //   4536: ldc 108
    //   4538: aload 14
    //   4540: invokevirtual 838	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4543: ifeq +29 -> 4572
    //   4546: aload_2
    //   4547: iload 6
    //   4549: aload 4
    //   4551: aload 4
    //   4553: ldc 108
    //   4555: invokeinterface 1937 2 0
    //   4560: invokeinterface 668 2 0
    //   4565: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4568: aastore
    //   4569: goto +763 -> 5332
    //   4572: ldc_w 4091
    //   4575: aload 14
    //   4577: invokevirtual 838	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4580: ifeq +54 -> 4634
    //   4583: aload_2
    //   4584: iload 6
    //   4586: aload 4
    //   4588: aload 4
    //   4590: ldc -80
    //   4592: invokeinterface 1937 2 0
    //   4597: invokeinterface 1164 2 0
    //   4602: aastore
    //   4603: goto +729 -> 5332
    //   4606: astore 5
    //   4608: aload 4
    //   4610: ifnull +13 -> 4623
    //   4613: aload 4
    //   4615: astore_2
    //   4616: aload 4
    //   4618: invokeinterface 442 1 0
    //   4623: aload 4
    //   4625: astore_2
    //   4626: aload 5
    //   4628: athrow
    //   4629: astore 5
    //   4631: goto -3979 -> 652
    //   4634: ldc_w 3090
    //   4637: aload 14
    //   4639: invokevirtual 838	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4642: ifeq +26 -> 4668
    //   4645: aload_2
    //   4646: iload 6
    //   4648: aload 4
    //   4650: aload 4
    //   4652: ldc -84
    //   4654: invokeinterface 1937 2 0
    //   4659: invokeinterface 1164 2 0
    //   4664: aastore
    //   4665: goto +667 -> 5332
    //   4668: ldc_w 3092
    //   4671: aload 14
    //   4673: invokevirtual 838	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4676: ifeq +29 -> 4705
    //   4679: aload_2
    //   4680: iload 6
    //   4682: aload 4
    //   4684: aload 4
    //   4686: ldc -82
    //   4688: invokeinterface 1937 2 0
    //   4693: invokeinterface 1157 2 0
    //   4698: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4701: aastore
    //   4702: goto +630 -> 5332
    //   4705: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   4708: ldc_w 4095
    //   4711: iconst_1
    //   4712: anewarray 157	java/lang/Object
    //   4715: dup
    //   4716: iconst_0
    //   4717: aload 14
    //   4719: aastore
    //   4720: invokestatic 881	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   4723: pop
    //   4724: goto +608 -> 5332
    //   4727: aload 13
    //   4729: aload_2
    //   4730: invokevirtual 1137	android/database/MatrixCursor:addRow	([Ljava/lang/Object;)V
    //   4733: aload 4
    //   4735: ifnull +13 -> 4748
    //   4738: aload 4
    //   4740: astore_2
    //   4741: aload 4
    //   4743: invokeinterface 442 1 0
    //   4748: aload 13
    //   4750: astore_2
    //   4751: aload 4
    //   4753: ifnonnull -4722 -> 31
    //   4756: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   4759: ldc_w 3950
    //   4762: iconst_2
    //   4763: anewarray 157	java/lang/Object
    //   4766: dup
    //   4767: iconst_0
    //   4768: aload_1
    //   4769: aastore
    //   4770: dup
    //   4771: iconst_1
    //   4772: aload_3
    //   4773: aastore
    //   4774: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   4777: pop
    //   4778: aload 13
    //   4780: areturn
    //   4781: aload 4
    //   4783: ifnull +13 -> 4796
    //   4786: aload 4
    //   4788: astore_2
    //   4789: aload 4
    //   4791: invokeinterface 442 1 0
    //   4796: aload 4
    //   4798: ifnonnull +25 -> 4823
    //   4801: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   4804: ldc_w 3950
    //   4807: iconst_2
    //   4808: anewarray 157	java/lang/Object
    //   4811: dup
    //   4812: iconst_0
    //   4813: aload_1
    //   4814: aastore
    //   4815: dup
    //   4816: iconst_1
    //   4817: aload_3
    //   4818: aastore
    //   4819: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   4822: pop
    //   4823: aconst_null
    //   4824: areturn
    //   4825: aload 16
    //   4827: astore 13
    //   4829: aload 14
    //   4831: aload 14
    //   4833: aload_1
    //   4834: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   4837: iconst_1
    //   4838: invokeinterface 619 2 0
    //   4843: checkcast 106	java/lang/String
    //   4846: invokestatic 552	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   4849: invokestatic 1270	com/android/emailcommon/provider/Account:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Account;
    //   4852: invokestatic 3498	com/android/email/provider/EmailProvider:b	(Landroid/content/Context;Lcom/android/emailcommon/provider/Account;)Ljava/lang/String;
    //   4855: astore_2
    //   4856: aload 16
    //   4858: astore 13
    //   4860: new 966	android/database/MatrixCursor
    //   4863: dup
    //   4864: iconst_1
    //   4865: anewarray 106	java/lang/String
    //   4868: dup
    //   4869: iconst_0
    //   4870: ldc_w 4097
    //   4873: aastore
    //   4874: invokespecial 969	android/database/MatrixCursor:<init>	([Ljava/lang/String;)V
    //   4877: astore 4
    //   4879: aload 16
    //   4881: astore 13
    //   4883: aload 4
    //   4885: iconst_1
    //   4886: anewarray 157	java/lang/Object
    //   4889: dup
    //   4890: iconst_0
    //   4891: aload_2
    //   4892: aastore
    //   4893: invokevirtual 1137	android/database/MatrixCursor:addRow	([Ljava/lang/Object;)V
    //   4896: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   4899: ldc_w 3950
    //   4902: iconst_2
    //   4903: anewarray 157	java/lang/Object
    //   4906: dup
    //   4907: iconst_0
    //   4908: aload_1
    //   4909: aastore
    //   4910: dup
    //   4911: iconst_1
    //   4912: aload_3
    //   4913: aastore
    //   4914: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   4917: pop
    //   4918: aload 4
    //   4920: areturn
    //   4921: aload 16
    //   4923: astore 13
    //   4925: aload_1
    //   4926: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   4929: iconst_1
    //   4930: invokeinterface 619 2 0
    //   4935: checkcast 106	java/lang/String
    //   4938: astore_2
    //   4939: aload 16
    //   4941: astore 13
    //   4943: aload_2
    //   4944: invokestatic 552	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   4947: lstore 8
    //   4949: aload 16
    //   4951: astore 13
    //   4953: aload 14
    //   4955: lload 8
    //   4957: invokestatic 1270	com/android/emailcommon/provider/Account:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Account;
    //   4960: astore 4
    //   4962: aload 4
    //   4964: ifnonnull +61 -> 5025
    //   4967: aload 16
    //   4969: astore 13
    //   4971: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   4974: ldc_w 4099
    //   4977: iconst_1
    //   4978: anewarray 157	java/lang/Object
    //   4981: dup
    //   4982: iconst_0
    //   4983: aload_2
    //   4984: aastore
    //   4985: invokestatic 881	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   4988: pop
    //   4989: aconst_null
    //   4990: astore 4
    //   4992: goto -1530 -> 3462
    //   4995: astore 4
    //   4997: aload 16
    //   4999: astore 13
    //   5001: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   5004: ldc_w 4101
    //   5007: iconst_1
    //   5008: anewarray 157	java/lang/Object
    //   5011: dup
    //   5012: iconst_0
    //   5013: aload_2
    //   5014: aastore
    //   5015: invokestatic 881	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   5018: pop
    //   5019: aconst_null
    //   5020: astore 4
    //   5022: goto -1560 -> 3462
    //   5025: aload 16
    //   5027: astore 13
    //   5029: aload_0
    //   5030: aload 14
    //   5032: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   5035: aload 4
    //   5037: getfield 1446	com/android/emailcommon/provider/Account:d	Ljava/lang/String;
    //   5040: invokestatic 3210	azk:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Landroid/database/Cursor;
    //   5043: astore_2
    //   5044: aload 16
    //   5046: astore 13
    //   5048: aload 14
    //   5050: lload 8
    //   5052: invokestatic 809	bam:a	(Landroid/content/Context;J)Lber;
    //   5055: lload 8
    //   5057: aconst_null
    //   5058: invokeinterface 3226 4 0
    //   5063: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   5066: ldc_w 3950
    //   5069: iconst_2
    //   5070: anewarray 157	java/lang/Object
    //   5073: dup
    //   5074: iconst_0
    //   5075: aload_1
    //   5076: aastore
    //   5077: dup
    //   5078: iconst_1
    //   5079: aload_3
    //   5080: aastore
    //   5081: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   5084: pop
    //   5085: aload_2
    //   5086: areturn
    //   5087: aload 16
    //   5089: astore 13
    //   5091: aload_0
    //   5092: aload_1
    //   5093: invokestatic 4104	cge:d	(Lcgf;Landroid/net/Uri;)Landroid/database/Cursor;
    //   5096: astore_2
    //   5097: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   5100: ldc_w 3950
    //   5103: iconst_2
    //   5104: anewarray 157	java/lang/Object
    //   5107: dup
    //   5108: iconst_0
    //   5109: aload_1
    //   5110: aastore
    //   5111: dup
    //   5112: iconst_1
    //   5113: aload_3
    //   5114: aastore
    //   5115: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   5118: pop
    //   5119: aload_2
    //   5120: areturn
    //   5121: aload 16
    //   5123: astore 13
    //   5125: aload_0
    //   5126: aload_1
    //   5127: invokestatic 4106	cge:e	(Lcgf;Landroid/net/Uri;)Landroid/database/Cursor;
    //   5130: astore_2
    //   5131: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   5134: ldc_w 3950
    //   5137: iconst_2
    //   5138: anewarray 157	java/lang/Object
    //   5141: dup
    //   5142: iconst_0
    //   5143: aload_1
    //   5144: aastore
    //   5145: dup
    //   5146: iconst_1
    //   5147: aload_3
    //   5148: aastore
    //   5149: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   5152: pop
    //   5153: aload_2
    //   5154: areturn
    //   5155: aload 16
    //   5157: astore 13
    //   5159: aload_0
    //   5160: invokestatic 4109	cge:a	(Lcgf;)Landroid/database/Cursor;
    //   5163: astore_2
    //   5164: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   5167: ldc_w 3950
    //   5170: iconst_2
    //   5171: anewarray 157	java/lang/Object
    //   5174: dup
    //   5175: iconst_0
    //   5176: aload_1
    //   5177: aastore
    //   5178: dup
    //   5179: iconst_1
    //   5180: aload_3
    //   5181: aastore
    //   5182: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   5185: pop
    //   5186: aload_2
    //   5187: areturn
    //   5188: aload 16
    //   5190: astore 13
    //   5192: aload_0
    //   5193: aload_1
    //   5194: invokestatic 4111	cge:f	(Lcgf;Landroid/net/Uri;)Landroid/database/Cursor;
    //   5197: astore_2
    //   5198: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   5201: ldc_w 3950
    //   5204: iconst_2
    //   5205: anewarray 157	java/lang/Object
    //   5208: dup
    //   5209: iconst_0
    //   5210: aload_1
    //   5211: aastore
    //   5212: dup
    //   5213: iconst_1
    //   5214: aload_3
    //   5215: aastore
    //   5216: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   5219: pop
    //   5220: aload_2
    //   5221: areturn
    //   5222: iload 6
    //   5224: ldc_w 3360
    //   5227: if_icmpne +60 -> 5287
    //   5230: aload 16
    //   5232: astore 13
    //   5234: aload_1
    //   5235: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   5238: iconst_1
    //   5239: invokeinterface 619 2 0
    //   5244: checkcast 106	java/lang/String
    //   5247: aload_3
    //   5248: invokestatic 3355	com/android/email/provider/EmailProvider:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5251: astore 14
    //   5253: aload 16
    //   5255: astore 13
    //   5257: aload 17
    //   5259: ldc_w 3362
    //   5262: aload_2
    //   5263: aload_1
    //   5264: aload 14
    //   5266: invokestatic 3367	azz:a	(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;
    //   5269: aload_1
    //   5270: aload 4
    //   5272: invokestatic 3370	azz:a	(Landroid/net/Uri;[Ljava/lang/String;)[Ljava/lang/String;
    //   5275: aconst_null
    //   5276: aconst_null
    //   5277: aload 5
    //   5279: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   5282: astore 4
    //   5284: goto -1822 -> 3462
    //   5287: aload_3
    //   5288: astore 14
    //   5290: goto -37 -> 5253
    //   5293: astore 5
    //   5295: aload 4
    //   5297: astore_2
    //   5298: aload 5
    //   5300: astore 4
    //   5302: goto -4058 -> 1244
    //   5305: aload 17
    //   5307: areturn
    //   5308: goto -3080 -> 2228
    //   5311: goto -3409 -> 1902
    //   5314: iconst_0
    //   5315: istore 6
    //   5317: goto -3928 -> 1389
    //   5320: iconst_0
    //   5321: istore 12
    //   5323: goto -2899 -> 2424
    //   5326: iconst_1
    //   5327: istore 6
    //   5329: goto -1996 -> 3333
    //   5332: iload 6
    //   5334: iconst_1
    //   5335: iadd
    //   5336: istore 6
    //   5338: goto -816 -> 4522
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5341	0	this	EmailProvider
    //   0	5341	1	paramUri	Uri
    //   0	5341	2	paramArrayOfString1	String[]
    //   0	5341	3	paramString1	String
    //   0	5341	4	paramArrayOfString2	String[]
    //   0	5341	5	paramString2	String
    //   47	5290	6	i1	int
    //   1150	3377	7	i2	int
    //   1130	3926	8	l1	long
    //   1140	1000	10	l2	long
    //   2422	2900	12	bool	boolean
    //   598	4658	13	localObject1	Object
    //   53	5236	14	localObject2	Object
    //   37	1205	15	localObject3	Object
    //   34	5220	16	localObject4	Object
    //   61	5245	17	localObject5	Object
    //   70	4176	18	localObject6	Object
    //   86	4132	19	localObject7	Object
    //   3662	148	20	localContentValues	ContentValues
    //   3692	90	21	str	String
    // Exception table:
    //   from	to	target	type
    //   600	605	647	android/database/sqlite/SQLiteException
    //   609	647	647	android/database/sqlite/SQLiteException
    //   852	870	647	android/database/sqlite/SQLiteException
    //   874	879	647	android/database/sqlite/SQLiteException
    //   883	892	647	android/database/sqlite/SQLiteException
    //   936	957	647	android/database/sqlite/SQLiteException
    //   961	975	647	android/database/sqlite/SQLiteException
    //   979	988	647	android/database/sqlite/SQLiteException
    //   1000	1011	647	android/database/sqlite/SQLiteException
    //   1015	1026	647	android/database/sqlite/SQLiteException
    //   1030	1041	647	android/database/sqlite/SQLiteException
    //   1045	1051	647	android/database/sqlite/SQLiteException
    //   1055	1062	647	android/database/sqlite/SQLiteException
    //   1066	1113	647	android/database/sqlite/SQLiteException
    //   1117	1122	647	android/database/sqlite/SQLiteException
    //   1126	1132	647	android/database/sqlite/SQLiteException
    //   1136	1142	647	android/database/sqlite/SQLiteException
    //   1146	1152	647	android/database/sqlite/SQLiteException
    //   1161	1170	647	android/database/sqlite/SQLiteException
    //   1174	1219	647	android/database/sqlite/SQLiteException
    //   1223	1236	647	android/database/sqlite/SQLiteException
    //   1285	1332	647	android/database/sqlite/SQLiteException
    //   1336	1341	647	android/database/sqlite/SQLiteException
    //   1345	1351	647	android/database/sqlite/SQLiteException
    //   1355	1361	647	android/database/sqlite/SQLiteException
    //   1365	1371	647	android/database/sqlite/SQLiteException
    //   1380	1389	647	android/database/sqlite/SQLiteException
    //   1393	1438	647	android/database/sqlite/SQLiteException
    //   1445	1463	647	android/database/sqlite/SQLiteException
    //   1467	1474	647	android/database/sqlite/SQLiteException
    //   1478	1483	647	android/database/sqlite/SQLiteException
    //   1487	1496	647	android/database/sqlite/SQLiteException
    //   1504	1527	647	android/database/sqlite/SQLiteException
    //   1555	1574	647	android/database/sqlite/SQLiteException
    //   1611	1629	647	android/database/sqlite/SQLiteException
    //   1633	1642	647	android/database/sqlite/SQLiteException
    //   1646	1658	647	android/database/sqlite/SQLiteException
    //   1667	1689	647	android/database/sqlite/SQLiteException
    //   1729	1738	647	android/database/sqlite/SQLiteException
    //   1747	1758	647	android/database/sqlite/SQLiteException
    //   1762	1768	647	android/database/sqlite/SQLiteException
    //   1772	1783	647	android/database/sqlite/SQLiteException
    //   1792	1801	647	android/database/sqlite/SQLiteException
    //   1805	1812	647	android/database/sqlite/SQLiteException
    //   1816	1824	647	android/database/sqlite/SQLiteException
    //   1828	1834	647	android/database/sqlite/SQLiteException
    //   1838	1846	647	android/database/sqlite/SQLiteException
    //   1850	1856	647	android/database/sqlite/SQLiteException
    //   1860	1867	647	android/database/sqlite/SQLiteException
    //   1871	1878	647	android/database/sqlite/SQLiteException
    //   1882	1890	647	android/database/sqlite/SQLiteException
    //   1894	1902	647	android/database/sqlite/SQLiteException
    //   1906	1913	647	android/database/sqlite/SQLiteException
    //   1917	1935	647	android/database/sqlite/SQLiteException
    //   1939	1950	647	android/database/sqlite/SQLiteException
    //   1954	1960	647	android/database/sqlite/SQLiteException
    //   1964	1978	647	android/database/sqlite/SQLiteException
    //   1982	1989	647	android/database/sqlite/SQLiteException
    //   1993	2003	647	android/database/sqlite/SQLiteException
    //   2007	2017	647	android/database/sqlite/SQLiteException
    //   2021	2033	647	android/database/sqlite/SQLiteException
    //   2037	2049	647	android/database/sqlite/SQLiteException
    //   2053	2065	647	android/database/sqlite/SQLiteException
    //   2069	2087	647	android/database/sqlite/SQLiteException
    //   2091	2096	647	android/database/sqlite/SQLiteException
    //   2100	2108	647	android/database/sqlite/SQLiteException
    //   2112	2152	647	android/database/sqlite/SQLiteException
    //   2156	2166	647	android/database/sqlite/SQLiteException
    //   2170	2192	647	android/database/sqlite/SQLiteException
    //   2202	2208	647	android/database/sqlite/SQLiteException
    //   2268	2274	647	android/database/sqlite/SQLiteException
    //   2278	2288	647	android/database/sqlite/SQLiteException
    //   2292	2301	647	android/database/sqlite/SQLiteException
    //   2305	2313	647	android/database/sqlite/SQLiteException
    //   2317	2325	647	android/database/sqlite/SQLiteException
    //   2329	2337	647	android/database/sqlite/SQLiteException
    //   2341	2366	647	android/database/sqlite/SQLiteException
    //   2375	2388	647	android/database/sqlite/SQLiteException
    //   2395	2404	647	android/database/sqlite/SQLiteException
    //   2413	2421	647	android/database/sqlite/SQLiteException
    //   2428	2436	647	android/database/sqlite/SQLiteException
    //   2440	2446	647	android/database/sqlite/SQLiteException
    //   2483	2494	647	android/database/sqlite/SQLiteException
    //   2498	2507	647	android/database/sqlite/SQLiteException
    //   2516	2530	647	android/database/sqlite/SQLiteException
    //   2537	2549	647	android/database/sqlite/SQLiteException
    //   2592	2598	647	android/database/sqlite/SQLiteException
    //   2602	2610	647	android/database/sqlite/SQLiteException
    //   2614	2629	647	android/database/sqlite/SQLiteException
    //   2633	2649	647	android/database/sqlite/SQLiteException
    //   2653	2664	647	android/database/sqlite/SQLiteException
    //   2668	2676	647	android/database/sqlite/SQLiteException
    //   2680	2693	647	android/database/sqlite/SQLiteException
    //   2699	2704	647	android/database/sqlite/SQLiteException
    //   2708	2718	647	android/database/sqlite/SQLiteException
    //   2722	2731	647	android/database/sqlite/SQLiteException
    //   2735	2744	647	android/database/sqlite/SQLiteException
    //   2748	2757	647	android/database/sqlite/SQLiteException
    //   2761	2795	647	android/database/sqlite/SQLiteException
    //   2799	2813	647	android/database/sqlite/SQLiteException
    //   2817	2827	647	android/database/sqlite/SQLiteException
    //   2831	2839	647	android/database/sqlite/SQLiteException
    //   2843	2856	647	android/database/sqlite/SQLiteException
    //   2860	2881	647	android/database/sqlite/SQLiteException
    //   2885	2894	647	android/database/sqlite/SQLiteException
    //   2898	2908	647	android/database/sqlite/SQLiteException
    //   2916	2925	647	android/database/sqlite/SQLiteException
    //   2929	2946	647	android/database/sqlite/SQLiteException
    //   2950	2963	647	android/database/sqlite/SQLiteException
    //   2967	2981	647	android/database/sqlite/SQLiteException
    //   3009	3017	647	android/database/sqlite/SQLiteException
    //   3024	3031	647	android/database/sqlite/SQLiteException
    //   3068	3095	647	android/database/sqlite/SQLiteException
    //   3132	3159	647	android/database/sqlite/SQLiteException
    //   3196	3223	647	android/database/sqlite/SQLiteException
    //   3260	3278	647	android/database/sqlite/SQLiteException
    //   3306	3315	647	android/database/sqlite/SQLiteException
    //   3319	3330	647	android/database/sqlite/SQLiteException
    //   3337	3355	647	android/database/sqlite/SQLiteException
    //   3368	3377	647	android/database/sqlite/SQLiteException
    //   3381	3385	647	android/database/sqlite/SQLiteException
    //   3443	3462	647	android/database/sqlite/SQLiteException
    //   3529	3539	647	android/database/sqlite/SQLiteException
    //   3543	3551	647	android/database/sqlite/SQLiteException
    //   3555	3563	647	android/database/sqlite/SQLiteException
    //   3567	3582	647	android/database/sqlite/SQLiteException
    //   3589	3605	647	android/database/sqlite/SQLiteException
    //   3609	3620	647	android/database/sqlite/SQLiteException
    //   3624	3635	647	android/database/sqlite/SQLiteException
    //   3639	3650	647	android/database/sqlite/SQLiteException
    //   3654	3664	647	android/database/sqlite/SQLiteException
    //   3668	3676	647	android/database/sqlite/SQLiteException
    //   3680	3694	647	android/database/sqlite/SQLiteException
    //   3698	3706	647	android/database/sqlite/SQLiteException
    //   3710	3719	647	android/database/sqlite/SQLiteException
    //   3723	3733	647	android/database/sqlite/SQLiteException
    //   3737	3745	647	android/database/sqlite/SQLiteException
    //   3749	3763	647	android/database/sqlite/SQLiteException
    //   3767	3775	647	android/database/sqlite/SQLiteException
    //   3779	3788	647	android/database/sqlite/SQLiteException
    //   3792	3802	647	android/database/sqlite/SQLiteException
    //   3806	3815	647	android/database/sqlite/SQLiteException
    //   3819	3827	647	android/database/sqlite/SQLiteException
    //   3839	3854	647	android/database/sqlite/SQLiteException
    //   3858	3875	647	android/database/sqlite/SQLiteException
    //   3879	3887	647	android/database/sqlite/SQLiteException
    //   3891	3904	647	android/database/sqlite/SQLiteException
    //   3908	3916	647	android/database/sqlite/SQLiteException
    //   3920	3933	647	android/database/sqlite/SQLiteException
    //   3937	3950	647	android/database/sqlite/SQLiteException
    //   3957	3968	647	android/database/sqlite/SQLiteException
    //   3975	3986	647	android/database/sqlite/SQLiteException
    //   3993	4000	647	android/database/sqlite/SQLiteException
    //   4004	4016	647	android/database/sqlite/SQLiteException
    //   4023	4058	647	android/database/sqlite/SQLiteException
    //   4065	4080	647	android/database/sqlite/SQLiteException
    //   4084	4094	647	android/database/sqlite/SQLiteException
    //   4098	4106	647	android/database/sqlite/SQLiteException
    //   4110	4118	647	android/database/sqlite/SQLiteException
    //   4122	4130	647	android/database/sqlite/SQLiteException
    //   4134	4154	647	android/database/sqlite/SQLiteException
    //   4161	4176	647	android/database/sqlite/SQLiteException
    //   4180	4188	647	android/database/sqlite/SQLiteException
    //   4192	4199	647	android/database/sqlite/SQLiteException
    //   4203	4211	647	android/database/sqlite/SQLiteException
    //   4215	4224	647	android/database/sqlite/SQLiteException
    //   4228	4252	647	android/database/sqlite/SQLiteException
    //   4259	4270	647	android/database/sqlite/SQLiteException
    //   4277	4292	647	android/database/sqlite/SQLiteException
    //   4296	4306	647	android/database/sqlite/SQLiteException
    //   4310	4318	647	android/database/sqlite/SQLiteException
    //   4322	4330	647	android/database/sqlite/SQLiteException
    //   4334	4342	647	android/database/sqlite/SQLiteException
    //   4346	4366	647	android/database/sqlite/SQLiteException
    //   4380	4386	647	android/database/sqlite/SQLiteException
    //   4417	4447	647	android/database/sqlite/SQLiteException
    //   4829	4856	647	android/database/sqlite/SQLiteException
    //   4860	4879	647	android/database/sqlite/SQLiteException
    //   4883	4896	647	android/database/sqlite/SQLiteException
    //   4925	4939	647	android/database/sqlite/SQLiteException
    //   4943	4949	647	android/database/sqlite/SQLiteException
    //   4953	4962	647	android/database/sqlite/SQLiteException
    //   4971	4989	647	android/database/sqlite/SQLiteException
    //   5001	5019	647	android/database/sqlite/SQLiteException
    //   5029	5044	647	android/database/sqlite/SQLiteException
    //   5048	5063	647	android/database/sqlite/SQLiteException
    //   5091	5097	647	android/database/sqlite/SQLiteException
    //   5125	5131	647	android/database/sqlite/SQLiteException
    //   5159	5164	647	android/database/sqlite/SQLiteException
    //   5192	5198	647	android/database/sqlite/SQLiteException
    //   5234	5253	647	android/database/sqlite/SQLiteException
    //   5257	5284	647	android/database/sqlite/SQLiteException
    //   655	659	665	finally
    //   662	665	665	finally
    //   4616	4623	665	finally
    //   4626	4629	665	finally
    //   4741	4748	665	finally
    //   4789	4796	665	finally
    //   39	49	702	java/lang/IllegalArgumentException
    //   600	605	1239	java/lang/RuntimeException
    //   609	647	1239	java/lang/RuntimeException
    //   852	870	1239	java/lang/RuntimeException
    //   874	879	1239	java/lang/RuntimeException
    //   883	892	1239	java/lang/RuntimeException
    //   936	957	1239	java/lang/RuntimeException
    //   961	975	1239	java/lang/RuntimeException
    //   979	988	1239	java/lang/RuntimeException
    //   1000	1011	1239	java/lang/RuntimeException
    //   1015	1026	1239	java/lang/RuntimeException
    //   1030	1041	1239	java/lang/RuntimeException
    //   1045	1051	1239	java/lang/RuntimeException
    //   1055	1062	1239	java/lang/RuntimeException
    //   1066	1113	1239	java/lang/RuntimeException
    //   1117	1122	1239	java/lang/RuntimeException
    //   1126	1132	1239	java/lang/RuntimeException
    //   1136	1142	1239	java/lang/RuntimeException
    //   1146	1152	1239	java/lang/RuntimeException
    //   1161	1170	1239	java/lang/RuntimeException
    //   1174	1219	1239	java/lang/RuntimeException
    //   1223	1236	1239	java/lang/RuntimeException
    //   1285	1332	1239	java/lang/RuntimeException
    //   1336	1341	1239	java/lang/RuntimeException
    //   1345	1351	1239	java/lang/RuntimeException
    //   1355	1361	1239	java/lang/RuntimeException
    //   1365	1371	1239	java/lang/RuntimeException
    //   1380	1389	1239	java/lang/RuntimeException
    //   1393	1438	1239	java/lang/RuntimeException
    //   1445	1463	1239	java/lang/RuntimeException
    //   1467	1474	1239	java/lang/RuntimeException
    //   1478	1483	1239	java/lang/RuntimeException
    //   1487	1496	1239	java/lang/RuntimeException
    //   1504	1527	1239	java/lang/RuntimeException
    //   1555	1574	1239	java/lang/RuntimeException
    //   1611	1629	1239	java/lang/RuntimeException
    //   1633	1642	1239	java/lang/RuntimeException
    //   1646	1658	1239	java/lang/RuntimeException
    //   1667	1689	1239	java/lang/RuntimeException
    //   1729	1738	1239	java/lang/RuntimeException
    //   1747	1758	1239	java/lang/RuntimeException
    //   1762	1768	1239	java/lang/RuntimeException
    //   1772	1783	1239	java/lang/RuntimeException
    //   1792	1801	1239	java/lang/RuntimeException
    //   1805	1812	1239	java/lang/RuntimeException
    //   1816	1824	1239	java/lang/RuntimeException
    //   1828	1834	1239	java/lang/RuntimeException
    //   1838	1846	1239	java/lang/RuntimeException
    //   1850	1856	1239	java/lang/RuntimeException
    //   1860	1867	1239	java/lang/RuntimeException
    //   1871	1878	1239	java/lang/RuntimeException
    //   1882	1890	1239	java/lang/RuntimeException
    //   1894	1902	1239	java/lang/RuntimeException
    //   1906	1913	1239	java/lang/RuntimeException
    //   1917	1935	1239	java/lang/RuntimeException
    //   1939	1950	1239	java/lang/RuntimeException
    //   1954	1960	1239	java/lang/RuntimeException
    //   1964	1978	1239	java/lang/RuntimeException
    //   1982	1989	1239	java/lang/RuntimeException
    //   1993	2003	1239	java/lang/RuntimeException
    //   2007	2017	1239	java/lang/RuntimeException
    //   2021	2033	1239	java/lang/RuntimeException
    //   2037	2049	1239	java/lang/RuntimeException
    //   2053	2065	1239	java/lang/RuntimeException
    //   2069	2087	1239	java/lang/RuntimeException
    //   2091	2096	1239	java/lang/RuntimeException
    //   2100	2108	1239	java/lang/RuntimeException
    //   2112	2152	1239	java/lang/RuntimeException
    //   2156	2166	1239	java/lang/RuntimeException
    //   2170	2192	1239	java/lang/RuntimeException
    //   2202	2208	1239	java/lang/RuntimeException
    //   2268	2274	1239	java/lang/RuntimeException
    //   2278	2288	1239	java/lang/RuntimeException
    //   2292	2301	1239	java/lang/RuntimeException
    //   2305	2313	1239	java/lang/RuntimeException
    //   2317	2325	1239	java/lang/RuntimeException
    //   2329	2337	1239	java/lang/RuntimeException
    //   2341	2366	1239	java/lang/RuntimeException
    //   2375	2388	1239	java/lang/RuntimeException
    //   2395	2404	1239	java/lang/RuntimeException
    //   2413	2421	1239	java/lang/RuntimeException
    //   2428	2436	1239	java/lang/RuntimeException
    //   2440	2446	1239	java/lang/RuntimeException
    //   2483	2494	1239	java/lang/RuntimeException
    //   2498	2507	1239	java/lang/RuntimeException
    //   2516	2530	1239	java/lang/RuntimeException
    //   2537	2549	1239	java/lang/RuntimeException
    //   2592	2598	1239	java/lang/RuntimeException
    //   2602	2610	1239	java/lang/RuntimeException
    //   2614	2629	1239	java/lang/RuntimeException
    //   2633	2649	1239	java/lang/RuntimeException
    //   2653	2664	1239	java/lang/RuntimeException
    //   2668	2676	1239	java/lang/RuntimeException
    //   2680	2693	1239	java/lang/RuntimeException
    //   2699	2704	1239	java/lang/RuntimeException
    //   2708	2718	1239	java/lang/RuntimeException
    //   2722	2731	1239	java/lang/RuntimeException
    //   2735	2744	1239	java/lang/RuntimeException
    //   2748	2757	1239	java/lang/RuntimeException
    //   2761	2795	1239	java/lang/RuntimeException
    //   2799	2813	1239	java/lang/RuntimeException
    //   2817	2827	1239	java/lang/RuntimeException
    //   2831	2839	1239	java/lang/RuntimeException
    //   2843	2856	1239	java/lang/RuntimeException
    //   2860	2881	1239	java/lang/RuntimeException
    //   2885	2894	1239	java/lang/RuntimeException
    //   2898	2908	1239	java/lang/RuntimeException
    //   2916	2925	1239	java/lang/RuntimeException
    //   2929	2946	1239	java/lang/RuntimeException
    //   2950	2963	1239	java/lang/RuntimeException
    //   2967	2981	1239	java/lang/RuntimeException
    //   3009	3017	1239	java/lang/RuntimeException
    //   3024	3031	1239	java/lang/RuntimeException
    //   3068	3095	1239	java/lang/RuntimeException
    //   3132	3159	1239	java/lang/RuntimeException
    //   3196	3223	1239	java/lang/RuntimeException
    //   3260	3278	1239	java/lang/RuntimeException
    //   3306	3315	1239	java/lang/RuntimeException
    //   3319	3330	1239	java/lang/RuntimeException
    //   3337	3355	1239	java/lang/RuntimeException
    //   3368	3377	1239	java/lang/RuntimeException
    //   3381	3385	1239	java/lang/RuntimeException
    //   3443	3462	1239	java/lang/RuntimeException
    //   3529	3539	1239	java/lang/RuntimeException
    //   3543	3551	1239	java/lang/RuntimeException
    //   3555	3563	1239	java/lang/RuntimeException
    //   3567	3582	1239	java/lang/RuntimeException
    //   3589	3605	1239	java/lang/RuntimeException
    //   3609	3620	1239	java/lang/RuntimeException
    //   3624	3635	1239	java/lang/RuntimeException
    //   3639	3650	1239	java/lang/RuntimeException
    //   3654	3664	1239	java/lang/RuntimeException
    //   3668	3676	1239	java/lang/RuntimeException
    //   3680	3694	1239	java/lang/RuntimeException
    //   3698	3706	1239	java/lang/RuntimeException
    //   3710	3719	1239	java/lang/RuntimeException
    //   3723	3733	1239	java/lang/RuntimeException
    //   3737	3745	1239	java/lang/RuntimeException
    //   3749	3763	1239	java/lang/RuntimeException
    //   3767	3775	1239	java/lang/RuntimeException
    //   3779	3788	1239	java/lang/RuntimeException
    //   3792	3802	1239	java/lang/RuntimeException
    //   3806	3815	1239	java/lang/RuntimeException
    //   3819	3827	1239	java/lang/RuntimeException
    //   3839	3854	1239	java/lang/RuntimeException
    //   3858	3875	1239	java/lang/RuntimeException
    //   3879	3887	1239	java/lang/RuntimeException
    //   3891	3904	1239	java/lang/RuntimeException
    //   3908	3916	1239	java/lang/RuntimeException
    //   3920	3933	1239	java/lang/RuntimeException
    //   3937	3950	1239	java/lang/RuntimeException
    //   3957	3968	1239	java/lang/RuntimeException
    //   3975	3986	1239	java/lang/RuntimeException
    //   3993	4000	1239	java/lang/RuntimeException
    //   4004	4016	1239	java/lang/RuntimeException
    //   4023	4058	1239	java/lang/RuntimeException
    //   4065	4080	1239	java/lang/RuntimeException
    //   4084	4094	1239	java/lang/RuntimeException
    //   4098	4106	1239	java/lang/RuntimeException
    //   4110	4118	1239	java/lang/RuntimeException
    //   4122	4130	1239	java/lang/RuntimeException
    //   4134	4154	1239	java/lang/RuntimeException
    //   4161	4176	1239	java/lang/RuntimeException
    //   4180	4188	1239	java/lang/RuntimeException
    //   4192	4199	1239	java/lang/RuntimeException
    //   4203	4211	1239	java/lang/RuntimeException
    //   4215	4224	1239	java/lang/RuntimeException
    //   4228	4252	1239	java/lang/RuntimeException
    //   4259	4270	1239	java/lang/RuntimeException
    //   4277	4292	1239	java/lang/RuntimeException
    //   4296	4306	1239	java/lang/RuntimeException
    //   4310	4318	1239	java/lang/RuntimeException
    //   4322	4330	1239	java/lang/RuntimeException
    //   4334	4342	1239	java/lang/RuntimeException
    //   4346	4366	1239	java/lang/RuntimeException
    //   4380	4386	1239	java/lang/RuntimeException
    //   4417	4447	1239	java/lang/RuntimeException
    //   4829	4856	1239	java/lang/RuntimeException
    //   4860	4879	1239	java/lang/RuntimeException
    //   4883	4896	1239	java/lang/RuntimeException
    //   4925	4939	1239	java/lang/RuntimeException
    //   4943	4949	1239	java/lang/RuntimeException
    //   4953	4962	1239	java/lang/RuntimeException
    //   4971	4989	1239	java/lang/RuntimeException
    //   5001	5019	1239	java/lang/RuntimeException
    //   5029	5044	1239	java/lang/RuntimeException
    //   5048	5063	1239	java/lang/RuntimeException
    //   5091	5097	1239	java/lang/RuntimeException
    //   5125	5131	1239	java/lang/RuntimeException
    //   5159	5164	1239	java/lang/RuntimeException
    //   5192	5198	1239	java/lang/RuntimeException
    //   5234	5253	1239	java/lang/RuntimeException
    //   5257	5284	1239	java/lang/RuntimeException
    //   600	605	1265	finally
    //   609	647	1265	finally
    //   852	870	1265	finally
    //   874	879	1265	finally
    //   883	892	1265	finally
    //   936	957	1265	finally
    //   961	975	1265	finally
    //   979	988	1265	finally
    //   1000	1011	1265	finally
    //   1015	1026	1265	finally
    //   1030	1041	1265	finally
    //   1045	1051	1265	finally
    //   1055	1062	1265	finally
    //   1066	1113	1265	finally
    //   1117	1122	1265	finally
    //   1126	1132	1265	finally
    //   1136	1142	1265	finally
    //   1146	1152	1265	finally
    //   1161	1170	1265	finally
    //   1174	1219	1265	finally
    //   1223	1236	1265	finally
    //   1247	1251	1265	finally
    //   1254	1259	1265	finally
    //   1262	1265	1265	finally
    //   1285	1332	1265	finally
    //   1336	1341	1265	finally
    //   1345	1351	1265	finally
    //   1355	1361	1265	finally
    //   1365	1371	1265	finally
    //   1380	1389	1265	finally
    //   1393	1438	1265	finally
    //   1445	1463	1265	finally
    //   1467	1474	1265	finally
    //   1478	1483	1265	finally
    //   1487	1496	1265	finally
    //   1504	1527	1265	finally
    //   1555	1574	1265	finally
    //   1611	1629	1265	finally
    //   1633	1642	1265	finally
    //   1646	1658	1265	finally
    //   1667	1689	1265	finally
    //   1729	1738	1265	finally
    //   1747	1758	1265	finally
    //   1762	1768	1265	finally
    //   1772	1783	1265	finally
    //   1792	1801	1265	finally
    //   1805	1812	1265	finally
    //   1816	1824	1265	finally
    //   1828	1834	1265	finally
    //   1838	1846	1265	finally
    //   1850	1856	1265	finally
    //   1860	1867	1265	finally
    //   1871	1878	1265	finally
    //   1882	1890	1265	finally
    //   1894	1902	1265	finally
    //   1906	1913	1265	finally
    //   1917	1935	1265	finally
    //   1939	1950	1265	finally
    //   1954	1960	1265	finally
    //   1964	1978	1265	finally
    //   1982	1989	1265	finally
    //   1993	2003	1265	finally
    //   2007	2017	1265	finally
    //   2021	2033	1265	finally
    //   2037	2049	1265	finally
    //   2053	2065	1265	finally
    //   2069	2087	1265	finally
    //   2091	2096	1265	finally
    //   2100	2108	1265	finally
    //   2112	2152	1265	finally
    //   2156	2166	1265	finally
    //   2170	2192	1265	finally
    //   2202	2208	1265	finally
    //   2268	2274	1265	finally
    //   2278	2288	1265	finally
    //   2292	2301	1265	finally
    //   2305	2313	1265	finally
    //   2317	2325	1265	finally
    //   2329	2337	1265	finally
    //   2341	2366	1265	finally
    //   2375	2388	1265	finally
    //   2395	2404	1265	finally
    //   2413	2421	1265	finally
    //   2428	2436	1265	finally
    //   2440	2446	1265	finally
    //   2483	2494	1265	finally
    //   2498	2507	1265	finally
    //   2516	2530	1265	finally
    //   2537	2549	1265	finally
    //   2592	2598	1265	finally
    //   2602	2610	1265	finally
    //   2614	2629	1265	finally
    //   2633	2649	1265	finally
    //   2653	2664	1265	finally
    //   2668	2676	1265	finally
    //   2680	2693	1265	finally
    //   2699	2704	1265	finally
    //   2708	2718	1265	finally
    //   2722	2731	1265	finally
    //   2735	2744	1265	finally
    //   2748	2757	1265	finally
    //   2761	2795	1265	finally
    //   2799	2813	1265	finally
    //   2817	2827	1265	finally
    //   2831	2839	1265	finally
    //   2843	2856	1265	finally
    //   2860	2881	1265	finally
    //   2885	2894	1265	finally
    //   2898	2908	1265	finally
    //   2916	2925	1265	finally
    //   2929	2946	1265	finally
    //   2950	2963	1265	finally
    //   2967	2981	1265	finally
    //   3009	3017	1265	finally
    //   3024	3031	1265	finally
    //   3068	3095	1265	finally
    //   3132	3159	1265	finally
    //   3196	3223	1265	finally
    //   3260	3278	1265	finally
    //   3306	3315	1265	finally
    //   3319	3330	1265	finally
    //   3337	3355	1265	finally
    //   3368	3377	1265	finally
    //   3381	3385	1265	finally
    //   3443	3462	1265	finally
    //   3529	3539	1265	finally
    //   3543	3551	1265	finally
    //   3555	3563	1265	finally
    //   3567	3582	1265	finally
    //   3589	3605	1265	finally
    //   3609	3620	1265	finally
    //   3624	3635	1265	finally
    //   3639	3650	1265	finally
    //   3654	3664	1265	finally
    //   3668	3676	1265	finally
    //   3680	3694	1265	finally
    //   3698	3706	1265	finally
    //   3710	3719	1265	finally
    //   3723	3733	1265	finally
    //   3737	3745	1265	finally
    //   3749	3763	1265	finally
    //   3767	3775	1265	finally
    //   3779	3788	1265	finally
    //   3792	3802	1265	finally
    //   3806	3815	1265	finally
    //   3819	3827	1265	finally
    //   3839	3854	1265	finally
    //   3858	3875	1265	finally
    //   3879	3887	1265	finally
    //   3891	3904	1265	finally
    //   3908	3916	1265	finally
    //   3920	3933	1265	finally
    //   3937	3950	1265	finally
    //   3957	3968	1265	finally
    //   3975	3986	1265	finally
    //   3993	4000	1265	finally
    //   4004	4016	1265	finally
    //   4023	4058	1265	finally
    //   4065	4080	1265	finally
    //   4084	4094	1265	finally
    //   4098	4106	1265	finally
    //   4110	4118	1265	finally
    //   4122	4130	1265	finally
    //   4134	4154	1265	finally
    //   4161	4176	1265	finally
    //   4180	4188	1265	finally
    //   4192	4199	1265	finally
    //   4203	4211	1265	finally
    //   4215	4224	1265	finally
    //   4228	4252	1265	finally
    //   4259	4270	1265	finally
    //   4277	4292	1265	finally
    //   4296	4306	1265	finally
    //   4310	4318	1265	finally
    //   4322	4330	1265	finally
    //   4334	4342	1265	finally
    //   4346	4366	1265	finally
    //   4380	4386	1265	finally
    //   4417	4447	1265	finally
    //   4829	4856	1265	finally
    //   4860	4879	1265	finally
    //   4883	4896	1265	finally
    //   4925	4939	1265	finally
    //   4943	4949	1265	finally
    //   4953	4962	1265	finally
    //   4971	4989	1265	finally
    //   5001	5019	1265	finally
    //   5029	5044	1265	finally
    //   5048	5063	1265	finally
    //   5091	5097	1265	finally
    //   5125	5131	1265	finally
    //   5159	5164	1265	finally
    //   5192	5198	1265	finally
    //   5234	5253	1265	finally
    //   5257	5284	1265	finally
    //   4452	4481	4606	finally
    //   4486	4514	4606	finally
    //   4517	4522	4606	finally
    //   4536	4569	4606	finally
    //   4572	4603	4606	finally
    //   4634	4665	4606	finally
    //   4668	4702	4606	finally
    //   4705	4724	4606	finally
    //   4727	4733	4606	finally
    //   4616	4623	4629	android/database/sqlite/SQLiteException
    //   4626	4629	4629	android/database/sqlite/SQLiteException
    //   4741	4748	4629	android/database/sqlite/SQLiteException
    //   4789	4796	4629	android/database/sqlite/SQLiteException
    //   4943	4949	4995	java/lang/NumberFormatException
    //   4953	4962	4995	java/lang/NumberFormatException
    //   4616	4623	5293	java/lang/RuntimeException
    //   4626	4629	5293	java/lang/RuntimeException
    //   4741	4748	5293	java/lang/RuntimeException
    //   4789	4796	5293	java/lang/RuntimeException
  }
  
  public void shutdown()
  {
    if (v != null)
    {
      v.close();
      v = null;
    }
    if (w != null)
    {
      w.close();
      w = null;
    }
  }
  
  /* Error */
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   3: ldc_w 4115
    //   6: iconst_1
    //   7: anewarray 157	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_1
    //   13: aastore
    //   14: invokestatic 1925	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   17: pop
    //   18: getstatic 3619	com/android/email/provider/EmailProvider:c	Landroid/net/Uri;
    //   21: aload_1
    //   22: invokevirtual 2086	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +13 -> 38
    //   28: aload_0
    //   29: invokespecial 2557	com/android/email/provider/EmailProvider:j	()V
    //   32: iconst_0
    //   33: istore 6
    //   35: iload 6
    //   37: ireturn
    //   38: getstatic 3665	com/android/email/provider/EmailProvider:d	Landroid/net/Uri;
    //   41: aload_1
    //   42: invokevirtual 2086	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   45: ifeq +19 -> 64
    //   48: aload_0
    //   49: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   52: aload_0
    //   53: aload_0
    //   54: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   57: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   60: invokestatic 2592	com/android/email/provider/EmailProvider:a	(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase;)I
    //   63: ireturn
    //   64: getstatic 3351	bdv:H	Landroid/net/Uri;
    //   67: astore 19
    //   69: aload_0
    //   70: aload_1
    //   71: ldc_w 4116
    //   74: invokespecial 3314	com/android/email/provider/EmailProvider:b	(Landroid/net/Uri;Ljava/lang/String;)I
    //   77: istore 9
    //   79: aload_0
    //   80: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   83: astore 20
    //   85: aload_0
    //   86: aload 20
    //   88: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   91: astore 21
    //   93: iconst_0
    //   94: istore 6
    //   96: iload 9
    //   98: sipush 4097
    //   101: if_icmpeq +11 -> 112
    //   104: iload 9
    //   106: sipush 4096
    //   109: if_icmpne +17 -> 126
    //   112: aload_2
    //   113: ldc_w 2136
    //   116: invokevirtual 3555	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   119: aload_2
    //   120: ldc_w 3549
    //   123: invokevirtual 3555	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   126: getstatic 150	com/android/email/provider/EmailProvider:k	Landroid/util/SparseArray;
    //   129: iload 9
    //   131: bipush 12
    //   133: ishr
    //   134: invokevirtual 3317	android/util/SparseArray:valueAt	(I)Ljava/lang/Object;
    //   137: checkcast 106	java/lang/String
    //   140: astore 22
    //   142: ldc_w 2350
    //   145: astore 17
    //   147: aload_1
    //   148: ldc_w 643
    //   151: iconst_0
    //   152: invokevirtual 647	android/net/Uri:getBooleanQueryParameter	(Ljava/lang/String;Z)Z
    //   155: istore 10
    //   157: iload 9
    //   159: lookupswitch	default:+337->496, 0:+3134->3293, 1:+1357->1516, 2:+1207->1366, 3:+387->546, 4:+398->557, 4096:+3134->3293, 4097:+1357->1516, 8192:+3130->3289, 8193:+1357->1516, 8194:+1357->1516, 8195:+1283->1442, 8196:+3205->3364, 8197:+3224->3383, 12288:+3134->3293, 12289:+1357->1516, 16384:+3134->3293, 16385:+1357->1516, 24576:+3134->3293, 24577:+1357->1516, 28673:+1357->1516, 32771:+1199->1358, 32774:+485->644, 32778:+914->1073, 32784:+744->903, 32785:+751->910, 32787:+808->967, 32790:+408->567, 32792:+3243->3402, 32796:+3799->3958, 32797:+3812->3971, 32798:+3805->3964, 32800:+3819->3978, 36864:+2694->2853, 36865:+2529->2688, 40960:+3134->3293, 40961:+1357->1516, 49152:+3134->3293, 49153:+1357->1516, 53249:+3692->3851, 57344:+3825->3984, 57345:+3825->3984
    //   496: aload_1
    //   497: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   500: astore_1
    //   501: new 828	java/lang/IllegalArgumentException
    //   504: dup
    //   505: new 189	java/lang/StringBuilder
    //   508: dup
    //   509: aload_1
    //   510: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   513: invokevirtual 193	java/lang/String:length	()I
    //   516: bipush 12
    //   518: iadd
    //   519: invokespecial 194	java/lang/StringBuilder:<init>	(I)V
    //   522: ldc_w 3321
    //   525: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload_1
    //   529: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokespecial 833	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   538: athrow
    //   539: astore_1
    //   540: aload_0
    //   541: invokespecial 2557	com/android/email/provider/EmailProvider:j	()V
    //   544: aload_1
    //   545: athrow
    //   546: aload_0
    //   547: aload_1
    //   548: bipush 6
    //   550: getstatic 4119	arh:cA	I
    //   553: invokespecial 4121	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;II)I
    //   556: ireturn
    //   557: aload_0
    //   558: aload_1
    //   559: iconst_5
    //   560: getstatic 4124	arh:cw	I
    //   563: invokespecial 4121	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;II)I
    //   566: ireturn
    //   567: aload 20
    //   569: invokestatic 901	cfm:a	(Landroid/content/Context;)Lcfm;
    //   572: astore_1
    //   573: aload_2
    //   574: ldc_w 2024
    //   577: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   580: ifeq +17 -> 597
    //   583: aload_1
    //   584: aload_2
    //   585: ldc_w 2024
    //   588: invokevirtual 1764	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   591: invokevirtual 910	java/lang/Integer:intValue	()I
    //   594: invokevirtual 4125	cfm:d	(I)V
    //   597: aload_2
    //   598: ldc_w 2393
    //   601: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   604: ifeq +25 -> 629
    //   607: aload_2
    //   608: ldc_w 2393
    //   611: invokevirtual 1764	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   614: invokevirtual 910	java/lang/Integer:intValue	()I
    //   617: ifne +3509 -> 4126
    //   620: iconst_1
    //   621: istore 10
    //   623: aload_1
    //   624: iload 10
    //   626: invokevirtual 4127	cfm:d	(Z)V
    //   629: aload 20
    //   631: invokevirtual 500	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   634: getstatic 1228	com/android/email/provider/EmailProvider:G	Landroid/net/Uri;
    //   637: aconst_null
    //   638: iconst_0
    //   639: invokevirtual 3143	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V
    //   642: iconst_1
    //   643: ireturn
    //   644: aload_2
    //   645: ldc_w 842
    //   648: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   651: ifeq +114 -> 765
    //   654: aload_2
    //   655: ldc_w 842
    //   658: invokevirtual 1764	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   661: invokevirtual 910	java/lang/Integer:intValue	()I
    //   664: iconst_1
    //   665: if_icmpne +100 -> 765
    //   668: aload_1
    //   669: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   672: astore 18
    //   674: aload_2
    //   675: ldc_w 1832
    //   678: invokevirtual 1731	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   681: astore_3
    //   682: aload_3
    //   683: invokestatic 757	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   686: ifeq +94 -> 780
    //   689: aconst_null
    //   690: astore_3
    //   691: aload_0
    //   692: aload 20
    //   694: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   697: astore 19
    //   699: new 163	android/content/ContentValues
    //   702: dup
    //   703: iconst_1
    //   704: invokespecial 501	android/content/ContentValues:<init>	(I)V
    //   707: astore 20
    //   709: aload 20
    //   711: ldc_w 861
    //   714: iconst_1
    //   715: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   718: invokevirtual 920	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   721: aload_3
    //   722: invokestatic 757	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   725: ifeq +66 -> 791
    //   728: ldc_w 4129
    //   731: astore 4
    //   733: iconst_1
    //   734: anewarray 106	java/lang/String
    //   737: astore_3
    //   738: aload_3
    //   739: iconst_0
    //   740: aload 18
    //   742: aastore
    //   743: aload 19
    //   745: ldc -128
    //   747: aload 20
    //   749: aload 4
    //   751: aload_3
    //   752: invokevirtual 3285	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   755: istore 6
    //   757: aload_2
    //   758: invokevirtual 610	android/content/ContentValues:size	()I
    //   761: iconst_1
    //   762: if_icmpeq -727 -> 35
    //   765: aload_1
    //   766: getstatic 2337	com/android/emailcommon/provider/Mailbox:a	Landroid/net/Uri;
    //   769: iconst_1
    //   770: invokestatic 2162	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Landroid/net/Uri;Z)Landroid/net/Uri;
    //   773: astore_1
    //   774: aload_1
    //   775: ifnonnull +44 -> 819
    //   778: iconst_0
    //   779: ireturn
    //   780: aload_3
    //   781: invokestatic 337	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   784: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   787: astore_3
    //   788: goto -97 -> 691
    //   791: ldc_w 4131
    //   794: astore 4
    //   796: iconst_2
    //   797: anewarray 106	java/lang/String
    //   800: astore 17
    //   802: aload 17
    //   804: iconst_0
    //   805: aload 18
    //   807: aastore
    //   808: aload 17
    //   810: iconst_1
    //   811: aload_3
    //   812: aastore
    //   813: aload 17
    //   815: astore_3
    //   816: goto -73 -> 743
    //   819: new 163	android/content/ContentValues
    //   822: dup
    //   823: invokespecial 164	android/content/ContentValues:<init>	()V
    //   826: astore_3
    //   827: aload_2
    //   828: invokevirtual 623	android/content/ContentValues:keySet	()Ljava/util/Set;
    //   831: invokeinterface 629 1 0
    //   836: astore 4
    //   838: aload 4
    //   840: invokeinterface 634 1 0
    //   845: ifeq +42 -> 887
    //   848: aload 4
    //   850: invokeinterface 638 1 0
    //   855: checkcast 106	java/lang/String
    //   858: astore 17
    //   860: aload 17
    //   862: ldc_w 503
    //   865: invokevirtual 838	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   868: ifeq -30 -> 838
    //   871: aload_3
    //   872: ldc_w 503
    //   875: aload_2
    //   876: aload 17
    //   878: invokevirtual 2169	android/content/ContentValues:getAsLong	(Ljava/lang/String;)Ljava/lang/Long;
    //   881: invokevirtual 509	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   884: goto -46 -> 838
    //   887: aload_3
    //   888: invokevirtual 610	android/content/ContentValues:size	()I
    //   891: ifle +3241 -> 4132
    //   894: aload_0
    //   895: aload_1
    //   896: aload_3
    //   897: aconst_null
    //   898: aconst_null
    //   899: invokevirtual 2225	com/android/email/provider/EmailProvider:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   902: ireturn
    //   903: aload_0
    //   904: aload_1
    //   905: aload_2
    //   906: invokespecial 4133	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Landroid/content/ContentValues;)I
    //   909: ireturn
    //   910: aload_0
    //   911: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   914: astore_2
    //   915: aload_1
    //   916: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   919: astore_1
    //   920: aload_0
    //   921: aload_1
    //   922: invokespecial 4135	com/android/email/provider/EmailProvider:c	(Ljava/lang/String;)[Landroid/net/Uri;
    //   925: astore_3
    //   926: aload_3
    //   927: arraylength
    //   928: ifgt +5 -> 933
    //   931: iconst_0
    //   932: ireturn
    //   933: aload_0
    //   934: aload_2
    //   935: aload_1
    //   936: aload_3
    //   937: invokespecial 640	com/android/email/provider/EmailProvider:a	(Landroid/content/Context;Ljava/lang/String;[Landroid/net/Uri;)I
    //   940: istore 5
    //   942: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   945: ldc_w 4137
    //   948: iconst_1
    //   949: anewarray 157	java/lang/Object
    //   952: dup
    //   953: iconst_0
    //   954: iload 5
    //   956: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   959: aastore
    //   960: invokestatic 439	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   963: pop
    //   964: iload 5
    //   966: ireturn
    //   967: aload_1
    //   968: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   971: iconst_1
    //   972: invokeinterface 619 2 0
    //   977: checkcast 106	java/lang/String
    //   980: astore_1
    //   981: aload_1
    //   982: invokestatic 552	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   985: lstore 11
    //   987: aload 20
    //   989: lload 11
    //   991: invokestatic 809	bam:a	(Landroid/content/Context;J)Lber;
    //   994: astore_3
    //   995: aload_2
    //   996: ldc_w 1141
    //   999: invokevirtual 1731	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1002: astore 4
    //   1004: aload_3
    //   1005: lload 11
    //   1007: aload_2
    //   1008: ldc 108
    //   1010: invokevirtual 2169	android/content/ContentValues:getAsLong	(Ljava/lang/String;)Ljava/lang/Long;
    //   1013: invokevirtual 555	java/lang/Long:longValue	()J
    //   1016: invokeinterface 4139 5 0
    //   1021: aload_0
    //   1022: aload 4
    //   1024: lload 11
    //   1026: invokespecial 1757	com/android/email/provider/EmailProvider:c	(Ljava/lang/String;J)V
    //   1029: aload_0
    //   1030: lload 11
    //   1032: invokespecial 1206	com/android/email/provider/EmailProvider:i	(J)Landroid/accounts/Account;
    //   1035: invokestatic 3597	com/android/email/provider/EmailProvider:a	(Landroid/accounts/Account;)V
    //   1038: iconst_0
    //   1039: istore 5
    //   1041: iload 5
    //   1043: istore 6
    //   1045: iload 5
    //   1047: ifle -1012 -> 35
    //   1050: aload_0
    //   1051: iload 9
    //   1053: invokestatic 3348	com/android/email/provider/EmailProvider:a	(I)Landroid/net/Uri;
    //   1056: ldc_w 4116
    //   1059: aload_1
    //   1060: invokespecial 3350	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V
    //   1063: aload_0
    //   1064: aload 19
    //   1066: aconst_null
    //   1067: invokevirtual 538	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Ljava/lang/String;)V
    //   1070: iload 5
    //   1072: ireturn
    //   1073: iconst_0
    //   1074: istore 5
    //   1076: iconst_0
    //   1077: istore 6
    //   1079: aload_2
    //   1080: ldc_w 3096
    //   1083: invokevirtual 1764	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1086: astore 4
    //   1088: aload 4
    //   1090: ifnull -1055 -> 35
    //   1093: aload_1
    //   1094: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1097: invokestatic 552	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1100: lstore 11
    //   1102: aload_0
    //   1103: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   1106: astore_1
    //   1107: aload_1
    //   1108: lload 11
    //   1110: invokestatic 1416	com/android/emailcommon/provider/Attachment:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Attachment;
    //   1113: astore_3
    //   1114: aload_3
    //   1115: ifnonnull +5 -> 1120
    //   1118: iconst_0
    //   1119: ireturn
    //   1120: aload 4
    //   1122: invokevirtual 910	java/lang/Integer:intValue	()I
    //   1125: istore 7
    //   1127: new 163	android/content/ContentValues
    //   1130: dup
    //   1131: invokespecial 164	android/content/ContentValues:<init>	()V
    //   1134: astore 4
    //   1136: iload 7
    //   1138: ifeq +13 -> 1151
    //   1141: iload 5
    //   1143: istore 6
    //   1145: iload 7
    //   1147: iconst_4
    //   1148: if_icmpne +2986 -> 4134
    //   1151: aload 4
    //   1153: ldc_w 3098
    //   1156: iconst_0
    //   1157: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1160: invokevirtual 920	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1163: aload_3
    //   1164: getfield 1442	com/android/emailcommon/provider/Attachment:s	I
    //   1167: bipush -3
    //   1169: iand
    //   1170: istore 5
    //   1172: aload_3
    //   1173: iload 5
    //   1175: putfield 1442	com/android/emailcommon/provider/Attachment:s	I
    //   1178: aload 4
    //   1180: ldc_w 259
    //   1183: iload 5
    //   1185: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1188: invokevirtual 920	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1191: aload_3
    //   1192: aload_1
    //   1193: aload 4
    //   1195: invokevirtual 4142	com/android/emailcommon/provider/Attachment:a	(Landroid/content/Context;Landroid/content/ContentValues;)I
    //   1198: pop
    //   1199: iconst_1
    //   1200: istore 6
    //   1202: goto +2932 -> 4134
    //   1205: aload 4
    //   1207: ldc_w 3098
    //   1210: iconst_2
    //   1211: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1214: invokevirtual 920	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1217: aload_2
    //   1218: ldc_w 3100
    //   1221: invokevirtual 1764	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1224: astore_2
    //   1225: aload_2
    //   1226: ifnonnull +123 -> 1349
    //   1229: iconst_0
    //   1230: istore 5
    //   1232: aload 4
    //   1234: ldc_w 3102
    //   1237: iload 5
    //   1239: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1242: invokevirtual 920	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1245: aload 4
    //   1247: ldc_w 259
    //   1250: aload_3
    //   1251: getfield 1442	com/android/emailcommon/provider/Attachment:s	I
    //   1254: iconst_2
    //   1255: ior
    //   1256: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1259: invokevirtual 920	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1262: aload 4
    //   1264: ldc_w 3004
    //   1267: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   1270: ifeq +38 -> 1308
    //   1273: aload 4
    //   1275: ldc_w 3004
    //   1278: invokevirtual 1731	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1281: invokestatic 757	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1284: ifeq +24 -> 1308
    //   1287: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   1290: new 3584	java/lang/Throwable
    //   1293: dup
    //   1294: invokespecial 3585	java/lang/Throwable:<init>	()V
    //   1297: ldc_w 3587
    //   1300: iconst_0
    //   1301: anewarray 157	java/lang/Object
    //   1304: invokestatic 2798	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1307: pop
    //   1308: aload_3
    //   1309: aload_1
    //   1310: aload 4
    //   1312: invokevirtual 4142	com/android/emailcommon/provider/Attachment:a	(Landroid/content/Context;Landroid/content/ContentValues;)I
    //   1315: pop
    //   1316: iconst_1
    //   1317: istore 6
    //   1319: iload 7
    //   1321: iconst_3
    //   1322: if_icmpne -1287 -> 35
    //   1325: aload_3
    //   1326: getfield 4143	com/android/emailcommon/provider/Attachment:l	Ljava/lang/String;
    //   1329: invokestatic 757	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1332: ifne +2817 -> 4149
    //   1335: aload_0
    //   1336: getstatic 1064	com/android/email/provider/EmailProvider:H	Landroid/net/Uri;
    //   1339: aload_3
    //   1340: getfield 1437	com/android/emailcommon/provider/Attachment:o	J
    //   1343: invokespecial 2656	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;J)V
    //   1346: goto +2803 -> 4149
    //   1349: aload_2
    //   1350: invokevirtual 910	java/lang/Integer:intValue	()I
    //   1353: istore 5
    //   1355: goto -123 -> 1232
    //   1358: aload_0
    //   1359: aload_1
    //   1360: aload_2
    //   1361: iconst_0
    //   1362: invokespecial 2553	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Landroid/content/ContentValues;Z)I
    //   1365: ireturn
    //   1366: aload_1
    //   1367: invokevirtual 548	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1370: astore_2
    //   1371: aconst_null
    //   1372: astore_1
    //   1373: aload 21
    //   1375: ldc_w 4145
    //   1378: iconst_1
    //   1379: anewarray 106	java/lang/String
    //   1382: dup
    //   1383: iconst_0
    //   1384: aload_2
    //   1385: aastore
    //   1386: invokevirtual 656	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   1389: astore_2
    //   1390: aload_2
    //   1391: astore_1
    //   1392: aload_2
    //   1393: invokeinterface 568 1 0
    //   1398: ifeq +2722 -> 4120
    //   1401: aload_2
    //   1402: astore_1
    //   1403: aload_2
    //   1404: iconst_0
    //   1405: invokeinterface 1157 2 0
    //   1410: istore 5
    //   1412: iload 5
    //   1414: istore 6
    //   1416: aload_2
    //   1417: ifnull -1382 -> 35
    //   1420: aload_2
    //   1421: invokeinterface 442 1 0
    //   1426: iload 5
    //   1428: ireturn
    //   1429: astore_2
    //   1430: aload_1
    //   1431: ifnull +9 -> 1440
    //   1434: aload_1
    //   1435: invokeinterface 442 1 0
    //   1440: aload_2
    //   1441: athrow
    //   1442: aload 21
    //   1444: aload 22
    //   1446: getstatic 3334	beb:k	[Ljava/lang/String;
    //   1449: aload_3
    //   1450: aload 4
    //   1452: aconst_null
    //   1453: aconst_null
    //   1454: aconst_null
    //   1455: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1458: astore_1
    //   1459: aload_1
    //   1460: invokeinterface 568 1 0
    //   1465: ifeq +34 -> 1499
    //   1468: aload_0
    //   1469: getstatic 664	beb:a	Landroid/net/Uri;
    //   1472: aload_1
    //   1473: iconst_0
    //   1474: invokeinterface 668 2 0
    //   1479: invokestatic 674	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   1482: aload_2
    //   1483: aconst_null
    //   1484: aconst_null
    //   1485: invokevirtual 2225	com/android/email/provider/EmailProvider:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1488: istore 5
    //   1490: aload_1
    //   1491: invokeinterface 442 1 0
    //   1496: iload 5
    //   1498: ireturn
    //   1499: aload_1
    //   1500: invokeinterface 442 1 0
    //   1505: iconst_0
    //   1506: ireturn
    //   1507: astore_2
    //   1508: aload_1
    //   1509: invokeinterface 442 1 0
    //   1514: aload_2
    //   1515: athrow
    //   1516: aload_1
    //   1517: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   1520: iconst_1
    //   1521: invokeinterface 619 2 0
    //   1526: checkcast 106	java/lang/String
    //   1529: astore 17
    //   1531: aload 17
    //   1533: invokestatic 552	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1536: lstore 11
    //   1538: lload 11
    //   1540: lconst_0
    //   1541: lcmp
    //   1542: ifgt +50 -> 1592
    //   1545: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   1548: ldc_w 4147
    //   1551: iconst_2
    //   1552: anewarray 157	java/lang/Object
    //   1555: dup
    //   1556: iconst_0
    //   1557: lload 11
    //   1559: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1562: aastore
    //   1563: dup
    //   1564: iconst_1
    //   1565: aload_1
    //   1566: aastore
    //   1567: invokestatic 813	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1570: pop
    //   1571: invokestatic 3266	buo:a	()Lbut;
    //   1574: ldc_w 4149
    //   1577: ldc_w 4151
    //   1580: aload_1
    //   1581: invokevirtual 1458	android/net/Uri:toString	()Ljava/lang/String;
    //   1584: lconst_0
    //   1585: invokeinterface 3275 6 0
    //   1590: iconst_0
    //   1591: ireturn
    //   1592: iload 9
    //   1594: sipush 8194
    //   1597: if_icmpne +634 -> 2231
    //   1600: ldc2_w 1099
    //   1603: lstore 11
    //   1605: ldc2_w 1099
    //   1608: lstore 13
    //   1610: aload 21
    //   1612: ldc_w 4153
    //   1615: iconst_1
    //   1616: anewarray 106	java/lang/String
    //   1619: dup
    //   1620: iconst_0
    //   1621: aload 17
    //   1623: aastore
    //   1624: invokevirtual 656	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   1627: astore 18
    //   1629: aload 18
    //   1631: ifnull +2476 -> 4107
    //   1634: aload 18
    //   1636: invokeinterface 568 1 0
    //   1641: ifeq +23 -> 1664
    //   1644: aload 18
    //   1646: iconst_1
    //   1647: invokeinterface 668 2 0
    //   1652: lstore 11
    //   1654: aload 18
    //   1656: iconst_2
    //   1657: invokeinterface 668 2 0
    //   1662: lstore 13
    //   1664: aload 18
    //   1666: invokeinterface 442 1 0
    //   1671: new 365	java/util/ArrayList
    //   1674: dup
    //   1675: invokespecial 366	java/util/ArrayList:<init>	()V
    //   1678: astore 23
    //   1680: iload 10
    //   1682: ifeq +239 -> 1921
    //   1685: ldc_w 4155
    //   1688: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1691: astore 18
    //   1693: aload 17
    //   1695: aconst_null
    //   1696: invokestatic 3342	com/android/email/provider/EmailProvider:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1699: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1702: astore 24
    //   1704: aload 24
    //   1706: invokevirtual 193	java/lang/String:length	()I
    //   1709: ifeq +79 -> 1788
    //   1712: aload 18
    //   1714: aload 24
    //   1716: invokevirtual 1249	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1719: astore 18
    //   1721: aload 21
    //   1723: aload 18
    //   1725: aconst_null
    //   1726: invokevirtual 656	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   1729: astore 18
    //   1731: aload 18
    //   1733: ifnull +69 -> 1802
    //   1736: aload 18
    //   1738: invokeinterface 419 1 0
    //   1743: ifeq +59 -> 1802
    //   1746: aload 23
    //   1748: aload 18
    //   1750: iconst_0
    //   1751: invokeinterface 1164 2 0
    //   1756: invokevirtual 1444	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1759: pop
    //   1760: goto -29 -> 1731
    //   1763: astore_1
    //   1764: aload 18
    //   1766: ifnull +10 -> 1776
    //   1769: aload 18
    //   1771: invokeinterface 442 1 0
    //   1776: aload_1
    //   1777: athrow
    //   1778: astore_1
    //   1779: aload 18
    //   1781: invokeinterface 442 1 0
    //   1786: aload_1
    //   1787: athrow
    //   1788: new 106	java/lang/String
    //   1791: dup
    //   1792: aload 18
    //   1794: invokespecial 1734	java/lang/String:<init>	(Ljava/lang/String;)V
    //   1797: astore 18
    //   1799: goto -78 -> 1721
    //   1802: aload 18
    //   1804: ifnull +10 -> 1814
    //   1807: aload 18
    //   1809: invokeinterface 442 1 0
    //   1814: aload_2
    //   1815: ldc 110
    //   1817: invokevirtual 2169	android/content/ContentValues:getAsLong	(Ljava/lang/String;)Ljava/lang/Long;
    //   1820: astore 18
    //   1822: aload 18
    //   1824: ifnull +108 -> 1932
    //   1827: aload 23
    //   1829: invokevirtual 2073	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1832: astore 24
    //   1834: aload 24
    //   1836: invokeinterface 634 1 0
    //   1841: ifeq +91 -> 1932
    //   1844: aload 24
    //   1846: invokeinterface 638 1 0
    //   1851: checkcast 106	java/lang/String
    //   1854: astore 25
    //   1856: aload 18
    //   1858: invokevirtual 555	java/lang/Long:longValue	()J
    //   1861: lstore 15
    //   1863: aload 21
    //   1865: getstatic 235	com/android/email/provider/EmailProvider:K	Ljava/lang/String;
    //   1868: bipush 7
    //   1870: anewarray 106	java/lang/String
    //   1873: dup
    //   1874: iconst_0
    //   1875: aload 25
    //   1877: aastore
    //   1878: dup
    //   1879: iconst_1
    //   1880: aload 25
    //   1882: aastore
    //   1883: dup
    //   1884: iconst_2
    //   1885: aload 25
    //   1887: aastore
    //   1888: dup
    //   1889: iconst_3
    //   1890: aload 25
    //   1892: aastore
    //   1893: dup
    //   1894: iconst_4
    //   1895: lload 15
    //   1897: invokestatic 3282	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1900: aastore
    //   1901: dup
    //   1902: iconst_5
    //   1903: aload 25
    //   1905: aastore
    //   1906: dup
    //   1907: bipush 6
    //   1909: lload 15
    //   1911: invokestatic 3282	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1914: aastore
    //   1915: invokevirtual 3340	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1918: goto -84 -> 1834
    //   1921: aload 23
    //   1923: aload 17
    //   1925: invokevirtual 1444	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1928: pop
    //   1929: goto -115 -> 1814
    //   1932: aload_2
    //   1933: ldc -1
    //   1935: invokevirtual 1764	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1938: astore 18
    //   1940: aload_2
    //   1941: ldc_w 257
    //   1944: invokevirtual 1764	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1947: astore 24
    //   1949: aload_2
    //   1950: ldc_w 259
    //   1953: invokevirtual 1764	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1956: astore 25
    //   1958: aload 18
    //   1960: ifnull +2209 -> 4169
    //   1963: aload 18
    //   1965: invokevirtual 910	java/lang/Integer:intValue	()I
    //   1968: istore 7
    //   1970: aload 24
    //   1972: ifnull +2203 -> 4175
    //   1975: aload 24
    //   1977: invokevirtual 910	java/lang/Integer:intValue	()I
    //   1980: istore 8
    //   1982: aload 25
    //   1984: ifnull +2203 -> 4187
    //   1987: aload 25
    //   1989: invokevirtual 910	java/lang/Integer:intValue	()I
    //   1992: invokestatic 4157	beb:b	(I)Z
    //   1995: ifeq +2186 -> 4181
    //   1998: iconst_1
    //   1999: istore 5
    //   2001: aload 25
    //   2003: ifnull +2196 -> 4199
    //   2006: aload 25
    //   2008: invokevirtual 910	java/lang/Integer:intValue	()I
    //   2011: invokestatic 4159	beb:c	(I)Z
    //   2014: ifeq +2179 -> 4193
    //   2017: iconst_1
    //   2018: istore 6
    //   2020: goto +2131 -> 4151
    //   2023: aload 23
    //   2025: invokevirtual 2073	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   2028: astore 18
    //   2030: aload 18
    //   2032: invokeinterface 634 1 0
    //   2037: ifeq +103 -> 2140
    //   2040: aload 18
    //   2042: invokeinterface 638 1 0
    //   2047: checkcast 106	java/lang/String
    //   2050: astore 23
    //   2052: aload 21
    //   2054: getstatic 269	com/android/email/provider/EmailProvider:L	Ljava/lang/String;
    //   2057: bipush 11
    //   2059: anewarray 106	java/lang/String
    //   2062: dup
    //   2063: iconst_0
    //   2064: aload 23
    //   2066: aastore
    //   2067: dup
    //   2068: iconst_1
    //   2069: aload 23
    //   2071: aastore
    //   2072: dup
    //   2073: iconst_2
    //   2074: aload 23
    //   2076: aastore
    //   2077: dup
    //   2078: iconst_3
    //   2079: aload 23
    //   2081: aastore
    //   2082: dup
    //   2083: iconst_4
    //   2084: iload 7
    //   2086: invokestatic 3270	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2089: aastore
    //   2090: dup
    //   2091: iconst_5
    //   2092: aload 23
    //   2094: aastore
    //   2095: dup
    //   2096: bipush 6
    //   2098: iload 8
    //   2100: invokestatic 3270	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2103: aastore
    //   2104: dup
    //   2105: bipush 7
    //   2107: aload 23
    //   2109: aastore
    //   2110: dup
    //   2111: bipush 8
    //   2113: iload 5
    //   2115: invokestatic 3270	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2118: aastore
    //   2119: dup
    //   2120: bipush 9
    //   2122: aload 23
    //   2124: aastore
    //   2125: dup
    //   2126: bipush 10
    //   2128: iload 6
    //   2130: invokestatic 3270	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2133: aastore
    //   2134: invokevirtual 3340	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   2137: goto -107 -> 2030
    //   2140: aload_0
    //   2141: invokespecial 4161	com/android/email/provider/EmailProvider:r	()Landroid/os/Handler;
    //   2144: astore 18
    //   2146: aload_0
    //   2147: lload 13
    //   2149: invokespecial 1206	com/android/email/provider/EmailProvider:i	(J)Landroid/accounts/Account;
    //   2152: astore 23
    //   2154: aload 23
    //   2156: ifnull +245 -> 2401
    //   2159: new 4163	azi
    //   2162: dup
    //   2163: aload_1
    //   2164: invokevirtual 1409	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   2167: aload 23
    //   2169: lload 11
    //   2171: invokespecial 4166	azi:<init>	(Ljava/lang/String;Landroid/accounts/Account;J)V
    //   2174: astore 24
    //   2176: aload_0
    //   2177: getfield 373	com/android/email/provider/EmailProvider:g	Ljava/util/Set;
    //   2180: astore 23
    //   2182: aload 23
    //   2184: monitorenter
    //   2185: aload_0
    //   2186: getfield 373	com/android/email/provider/EmailProvider:g	Ljava/util/Set;
    //   2189: aload 24
    //   2191: invokeinterface 2321 2 0
    //   2196: ifne +32 -> 2228
    //   2199: aload_0
    //   2200: getfield 373	com/android/email/provider/EmailProvider:g	Ljava/util/Set;
    //   2203: aload 24
    //   2205: invokeinterface 2708 2 0
    //   2210: pop
    //   2211: aload 18
    //   2213: aload 18
    //   2215: iconst_0
    //   2216: aload 24
    //   2218: invokevirtual 4170	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   2221: ldc2_w 4171
    //   2224: invokevirtual 2687	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   2227: pop
    //   2228: aload 23
    //   2230: monitorexit
    //   2231: iload 10
    //   2233: ifeq +193 -> 2426
    //   2236: aload 17
    //   2238: aload_3
    //   2239: invokestatic 3342	com/android/email/provider/EmailProvider:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2242: astore_3
    //   2243: aload 21
    //   2245: aload 22
    //   2247: aload_2
    //   2248: aload_3
    //   2249: aload 4
    //   2251: invokevirtual 3285	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2254: istore 5
    //   2256: iload 9
    //   2258: sipush 8193
    //   2261: if_icmpne +1944 -> 4205
    //   2264: aload_0
    //   2265: getfield 2883	com/android/email/provider/EmailProvider:x	Lazt;
    //   2268: aload 20
    //   2270: aload_2
    //   2271: aload 17
    //   2273: invokestatic 552	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2276: aload 21
    //   2278: invokevirtual 3567	azt:a	(Landroid/content/Context;Landroid/content/ContentValues;JLandroid/database/sqlite/SQLiteDatabase;)V
    //   2281: goto +1924 -> 4205
    //   2284: aload_1
    //   2285: ldc_w 1260
    //   2288: iconst_0
    //   2289: invokevirtual 647	android/net/Uri:getBooleanQueryParameter	(Ljava/lang/String;Z)Z
    //   2292: ifne +8 -> 2300
    //   2295: aload_0
    //   2296: aload_1
    //   2297: invokespecial 3319	com/android/email/provider/EmailProvider:e	(Landroid/net/Uri;)V
    //   2300: aload_0
    //   2301: getstatic 1064	com/android/email/provider/EmailProvider:H	Landroid/net/Uri;
    //   2304: aload 17
    //   2306: invokevirtual 538	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Ljava/lang/String;)V
    //   2309: aload_2
    //   2310: ldc -1
    //   2312: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   2315: ifne +12 -> 2327
    //   2318: aload_2
    //   2319: ldc 110
    //   2321: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   2324: ifeq +1900 -> 4224
    //   2327: aload_0
    //   2328: getstatic 664	beb:a	Landroid/net/Uri;
    //   2331: invokevirtual 523	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   2334: aload 17
    //   2336: invokevirtual 930	android/net/Uri$Builder:appendEncodedPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   2339: invokevirtual 533	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   2342: getstatic 356	com/android/email/provider/EmailProvider:aa	[Ljava/lang/String;
    //   2345: aconst_null
    //   2346: aconst_null
    //   2347: aconst_null
    //   2348: invokevirtual 565	com/android/email/provider/EmailProvider:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2351: astore_1
    //   2352: aload_1
    //   2353: ifnull +1871 -> 4224
    //   2356: aload_1
    //   2357: invokeinterface 568 1 0
    //   2362: ifeq +21 -> 2383
    //   2365: aload_0
    //   2366: aload_1
    //   2367: iconst_0
    //   2368: invokeinterface 668 2 0
    //   2373: aload_1
    //   2374: iconst_1
    //   2375: invokeinterface 668 2 0
    //   2380: invokespecial 1499	com/android/email/provider/EmailProvider:a	(JJ)V
    //   2383: aload_1
    //   2384: invokeinterface 442 1 0
    //   2389: aload 17
    //   2391: astore_1
    //   2392: goto -1351 -> 1041
    //   2395: astore_1
    //   2396: aload 23
    //   2398: monitorexit
    //   2399: aload_1
    //   2400: athrow
    //   2401: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   2404: ldc_w 4174
    //   2407: iconst_1
    //   2408: anewarray 157	java/lang/Object
    //   2411: dup
    //   2412: iconst_0
    //   2413: lload 13
    //   2415: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2418: aastore
    //   2419: invokestatic 439	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2422: pop
    //   2423: goto -192 -> 2231
    //   2426: aload 17
    //   2428: aload_3
    //   2429: invokestatic 3355	com/android/email/provider/EmailProvider:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2432: astore_3
    //   2433: goto -190 -> 2243
    //   2436: astore_2
    //   2437: aload_1
    //   2438: invokeinterface 442 1 0
    //   2443: aload_2
    //   2444: athrow
    //   2445: iload 9
    //   2447: sipush 12289
    //   2450: if_icmpne +102 -> 2552
    //   2453: aload 17
    //   2455: invokestatic 552	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2458: lstore 11
    //   2460: aload_2
    //   2461: ldc_w 259
    //   2464: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   2467: ifeq +30 -> 2497
    //   2470: aload_2
    //   2471: ldc_w 259
    //   2474: invokevirtual 1764	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2477: invokevirtual 910	java/lang/Integer:intValue	()I
    //   2480: istore 6
    //   2482: aload_0
    //   2483: getfield 387	com/android/email/provider/EmailProvider:O	Lazh;
    //   2486: aload 20
    //   2488: lload 11
    //   2490: iload 6
    //   2492: invokeinterface 3592 5 0
    //   2497: aload_2
    //   2498: ldc_w 3098
    //   2501: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   2504: ifne +13 -> 2517
    //   2507: aload_2
    //   2508: ldc_w 3106
    //   2511: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   2514: ifeq +1716 -> 4230
    //   2517: aload_0
    //   2518: getstatic 1090	com/android/email/provider/EmailProvider:E	Landroid/net/Uri;
    //   2521: aload 17
    //   2523: invokevirtual 538	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Ljava/lang/String;)V
    //   2526: aload 20
    //   2528: lload 11
    //   2530: invokestatic 1416	com/android/emailcommon/provider/Attachment:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Attachment;
    //   2533: astore_1
    //   2534: aload_1
    //   2535: ifnull +1695 -> 4230
    //   2538: aload_0
    //   2539: getstatic 1078	com/android/email/provider/EmailProvider:F	Landroid/net/Uri;
    //   2542: aload_1
    //   2543: getfield 1437	com/android/emailcommon/provider/Attachment:o	J
    //   2546: invokespecial 2656	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;J)V
    //   2549: goto +1681 -> 4230
    //   2552: iload 9
    //   2554: sipush 4097
    //   2557: if_icmpne +58 -> 2615
    //   2560: aload 20
    //   2562: aload 17
    //   2564: invokestatic 961	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;Ljava/lang/String;)J
    //   2567: lstore 11
    //   2569: aload_0
    //   2570: aload 17
    //   2572: lload 11
    //   2574: invokespecial 1757	com/android/email/provider/EmailProvider:c	(Ljava/lang/String;J)V
    //   2577: lload 11
    //   2579: invokestatic 350	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2582: astore_1
    //   2583: aload_2
    //   2584: ldc_w 4176
    //   2587: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   2590: ifne +13 -> 2603
    //   2593: aload_2
    //   2594: ldc_w 1760
    //   2597: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   2600: ifeq +1636 -> 4236
    //   2603: aload 20
    //   2605: aload 21
    //   2607: aload_1
    //   2608: invokestatic 4178	com/android/email/provider/EmailProvider:a	(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    //   2611: pop
    //   2612: goto +1624 -> 4236
    //   2615: aload 17
    //   2617: astore_1
    //   2618: iload 5
    //   2620: istore 6
    //   2622: iload 9
    //   2624: iconst_1
    //   2625: if_icmpne +1444 -> 4069
    //   2628: aload_0
    //   2629: aload 17
    //   2631: invokestatic 552	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2634: aload_2
    //   2635: invokespecial 3580	com/android/email/provider/EmailProvider:a	(JLandroid/content/ContentValues;)V
    //   2638: aload_0
    //   2639: getstatic 1126	com/android/email/provider/EmailProvider:D	Landroid/net/Uri;
    //   2642: aload 17
    //   2644: invokevirtual 538	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Ljava/lang/String;)V
    //   2647: aload_0
    //   2648: getstatic 1228	com/android/email/provider/EmailProvider:G	Landroid/net/Uri;
    //   2651: aconst_null
    //   2652: invokevirtual 538	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Ljava/lang/String;)V
    //   2655: aload_2
    //   2656: ldc_w 4176
    //   2659: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   2662: ifne +13 -> 2675
    //   2665: aload_2
    //   2666: ldc_w 1760
    //   2669: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   2672: ifeq +1570 -> 4242
    //   2675: aload 20
    //   2677: aload 21
    //   2679: aload 17
    //   2681: invokestatic 4178	com/android/email/provider/EmailProvider:a	(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    //   2684: pop
    //   2685: goto +1557 -> 4242
    //   2688: new 163	android/content/ContentValues
    //   2691: dup
    //   2692: aload_2
    //   2693: invokespecial 3553	android/content/ContentValues:<init>	(Landroid/content/ContentValues;)V
    //   2696: astore_1
    //   2697: aload_1
    //   2698: ldc_w 1866
    //   2701: invokevirtual 3555	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   2704: aload_1
    //   2705: ldc_w 1871
    //   2708: invokevirtual 3555	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   2711: aload 21
    //   2713: aload 22
    //   2715: aload_1
    //   2716: ldc_w 2350
    //   2719: aload_3
    //   2720: invokestatic 3355	com/android/email/provider/EmailProvider:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2723: aload 4
    //   2725: invokevirtual 3285	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2728: istore 6
    //   2730: aload_2
    //   2731: ldc_w 1866
    //   2734: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   2737: ifne +13 -> 2750
    //   2740: aload_2
    //   2741: ldc_w 1871
    //   2744: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   2747: ifeq +1353 -> 4100
    //   2750: aload_2
    //   2751: ldc_w 1092
    //   2754: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   2757: ifeq +33 -> 2790
    //   2760: aload_2
    //   2761: ldc_w 1092
    //   2764: invokevirtual 2169	android/content/ContentValues:getAsLong	(Ljava/lang/String;)Ljava/lang/Long;
    //   2767: invokevirtual 555	java/lang/Long:longValue	()J
    //   2770: lstore 11
    //   2772: aload 20
    //   2774: lload 11
    //   2776: aload_2
    //   2777: invokestatic 1874	com/android/email/provider/EmailProvider:a	(Landroid/content/Context;JLandroid/content/ContentValues;)V
    //   2780: iload 6
    //   2782: istore 5
    //   2784: aload 17
    //   2786: astore_1
    //   2787: goto -1746 -> 1041
    //   2790: ldc_w 2350
    //   2793: invokestatic 552	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2796: lstore 11
    //   2798: ldc_w 4180
    //   2801: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2804: astore_1
    //   2805: lload 11
    //   2807: invokestatic 350	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2810: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2813: astore_3
    //   2814: aload_3
    //   2815: invokevirtual 193	java/lang/String:length	()I
    //   2818: ifeq +23 -> 2841
    //   2821: aload_1
    //   2822: aload_3
    //   2823: invokevirtual 1249	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2826: astore_1
    //   2827: aload 21
    //   2829: aload_1
    //   2830: invokevirtual 4184	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   2833: invokevirtual 4189	android/database/sqlite/SQLiteStatement:simpleQueryForLong	()J
    //   2836: lstore 11
    //   2838: goto -66 -> 2772
    //   2841: new 106	java/lang/String
    //   2844: dup
    //   2845: aload_1
    //   2846: invokespecial 1734	java/lang/String:<init>	(Ljava/lang/String;)V
    //   2849: astore_1
    //   2850: goto -23 -> 2827
    //   2853: new 163	android/content/ContentValues
    //   2856: dup
    //   2857: aload_2
    //   2858: invokespecial 3553	android/content/ContentValues:<init>	(Landroid/content/ContentValues;)V
    //   2861: astore_1
    //   2862: aload_1
    //   2863: ldc_w 1866
    //   2866: invokevirtual 3555	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   2869: aload_1
    //   2870: ldc_w 1871
    //   2873: invokevirtual 3555	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   2876: aload_1
    //   2877: invokevirtual 610	android/content/ContentValues:size	()I
    //   2880: ifeq +80 -> 2960
    //   2883: aload 21
    //   2885: aload 22
    //   2887: aload_1
    //   2888: aload_3
    //   2889: aload 4
    //   2891: invokevirtual 3285	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2894: istore 5
    //   2896: iload 5
    //   2898: ifne +122 -> 3020
    //   2901: aload_3
    //   2902: ldc_w 1543
    //   2905: invokevirtual 838	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2908: ifeq +112 -> 3020
    //   2911: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   2914: ldc_w 4191
    //   2917: iconst_0
    //   2918: anewarray 157	java/lang/Object
    //   2921: invokestatic 1054	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2924: pop
    //   2925: new 163	android/content/ContentValues
    //   2928: dup
    //   2929: aload_2
    //   2930: invokespecial 3553	android/content/ContentValues:<init>	(Landroid/content/ContentValues;)V
    //   2933: astore_1
    //   2934: aload_1
    //   2935: ldc_w 1092
    //   2938: aload 4
    //   2940: iconst_0
    //   2941: aaload
    //   2942: invokevirtual 1082	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2945: aload_0
    //   2946: getstatic 1541	bds:a	Landroid/net/Uri;
    //   2949: aload_1
    //   2950: invokevirtual 3602	com/android/email/provider/EmailProvider:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2953: pop
    //   2954: aload 17
    //   2956: astore_1
    //   2957: goto -1916 -> 1041
    //   2960: aload 21
    //   2962: aload 22
    //   2964: iconst_1
    //   2965: anewarray 106	java/lang/String
    //   2968: dup
    //   2969: iconst_0
    //   2970: ldc 108
    //   2972: aastore
    //   2973: aload_3
    //   2974: aload 4
    //   2976: aconst_null
    //   2977: aconst_null
    //   2978: aconst_null
    //   2979: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2982: astore_1
    //   2983: aload_1
    //   2984: ifnull +1264 -> 4248
    //   2987: aload_1
    //   2988: invokeinterface 938 1 0
    //   2993: istore 5
    //   2995: aload_1
    //   2996: ifnull +1101 -> 4097
    //   2999: aload_1
    //   3000: invokeinterface 442 1 0
    //   3005: goto -109 -> 2896
    //   3008: aload_1
    //   3009: ifnull +9 -> 3018
    //   3012: aload_1
    //   3013: invokeinterface 442 1 0
    //   3018: aload_2
    //   3019: athrow
    //   3020: aload_2
    //   3021: ldc_w 1866
    //   3024: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   3027: ifne +13 -> 3040
    //   3030: aload_2
    //   3031: ldc_w 1871
    //   3034: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   3037: ifeq +1049 -> 4086
    //   3040: aload_2
    //   3041: ldc_w 1092
    //   3044: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   3047: ifeq +59 -> 3106
    //   3050: iconst_1
    //   3051: newarray <illegal type>
    //   3053: dup
    //   3054: iconst_0
    //   3055: aload_2
    //   3056: ldc_w 1092
    //   3059: invokevirtual 2169	android/content/ContentValues:getAsLong	(Ljava/lang/String;)Ljava/lang/Long;
    //   3062: invokevirtual 555	java/lang/Long:longValue	()J
    //   3065: lastore
    //   3066: astore_1
    //   3067: aload_1
    //   3068: arraylength
    //   3069: istore 7
    //   3071: iconst_0
    //   3072: istore 6
    //   3074: iload 6
    //   3076: iload 7
    //   3078: if_icmpge +1182 -> 4260
    //   3081: aload 20
    //   3083: aload_1
    //   3084: iload 6
    //   3086: laload
    //   3087: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3090: invokevirtual 555	java/lang/Long:longValue	()J
    //   3093: aload_2
    //   3094: invokestatic 1874	com/android/email/provider/EmailProvider:a	(Landroid/content/Context;JLandroid/content/ContentValues;)V
    //   3097: iload 6
    //   3099: iconst_1
    //   3100: iadd
    //   3101: istore 6
    //   3103: goto -29 -> 3074
    //   3106: aload_2
    //   3107: ldc 108
    //   3109: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   3112: ifeq +74 -> 3186
    //   3115: aload_2
    //   3116: ldc 108
    //   3118: invokevirtual 2169	android/content/ContentValues:getAsLong	(Ljava/lang/String;)Ljava/lang/Long;
    //   3121: invokevirtual 555	java/lang/Long:longValue	()J
    //   3124: lstore 11
    //   3126: ldc_w 4180
    //   3129: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3132: astore_1
    //   3133: lload 11
    //   3135: invokestatic 350	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3138: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3141: astore_3
    //   3142: aload_3
    //   3143: invokevirtual 193	java/lang/String:length	()I
    //   3146: ifeq +28 -> 3174
    //   3149: aload_1
    //   3150: aload_3
    //   3151: invokevirtual 1249	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   3154: astore_1
    //   3155: iconst_1
    //   3156: newarray <illegal type>
    //   3158: dup
    //   3159: iconst_0
    //   3160: aload 21
    //   3162: aload_1
    //   3163: invokevirtual 4184	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   3166: invokevirtual 4189	android/database/sqlite/SQLiteStatement:simpleQueryForLong	()J
    //   3169: lastore
    //   3170: astore_1
    //   3171: goto -104 -> 3067
    //   3174: new 106	java/lang/String
    //   3177: dup
    //   3178: aload_1
    //   3179: invokespecial 1734	java/lang/String:<init>	(Ljava/lang/String;)V
    //   3182: astore_1
    //   3183: goto -28 -> 3155
    //   3186: aload 21
    //   3188: ldc -116
    //   3190: iconst_1
    //   3191: anewarray 106	java/lang/String
    //   3194: dup
    //   3195: iconst_0
    //   3196: ldc_w 1092
    //   3199: aastore
    //   3200: aload_3
    //   3201: aload 4
    //   3203: aconst_null
    //   3204: aconst_null
    //   3205: aconst_null
    //   3206: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   3209: astore_3
    //   3210: aload_3
    //   3211: invokeinterface 938 1 0
    //   3216: istore 6
    //   3218: iload 6
    //   3220: ifne +23 -> 3243
    //   3223: new 449	java/lang/IllegalStateException
    //   3226: dup
    //   3227: ldc_w 4193
    //   3230: invokespecial 454	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   3233: athrow
    //   3234: astore_1
    //   3235: aload_3
    //   3236: invokeinterface 442 1 0
    //   3241: aload_1
    //   3242: athrow
    //   3243: iload 6
    //   3245: newarray <illegal type>
    //   3247: astore_1
    //   3248: iconst_0
    //   3249: istore 6
    //   3251: aload_3
    //   3252: invokeinterface 419 1 0
    //   3257: ifeq +23 -> 3280
    //   3260: aload_1
    //   3261: iload 6
    //   3263: aload_3
    //   3264: iconst_0
    //   3265: invokeinterface 668 2 0
    //   3270: lastore
    //   3271: iload 6
    //   3273: iconst_1
    //   3274: iadd
    //   3275: istore 6
    //   3277: goto -26 -> 3251
    //   3280: aload_3
    //   3281: invokeinterface 442 1 0
    //   3286: goto -219 -> 3067
    //   3289: aload_2
    //   3290: invokestatic 3564	com/android/email/provider/EmailProvider:b	(Landroid/content/ContentValues;)V
    //   3293: iload 9
    //   3295: sipush 12288
    //   3298: if_icmpne +47 -> 3345
    //   3301: aload_2
    //   3302: ldc_w 3004
    //   3305: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   3308: ifeq +37 -> 3345
    //   3311: aload_2
    //   3312: ldc_w 3004
    //   3315: invokevirtual 1731	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   3318: invokestatic 757	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3321: ifeq +24 -> 3345
    //   3324: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   3327: new 3584	java/lang/Throwable
    //   3330: dup
    //   3331: invokespecial 3585	java/lang/Throwable:<init>	()V
    //   3334: ldc_w 3587
    //   3337: iconst_0
    //   3338: anewarray 157	java/lang/Object
    //   3341: invokestatic 2798	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   3344: pop
    //   3345: aload 21
    //   3347: aload 22
    //   3349: aload_2
    //   3350: aload_3
    //   3351: aload 4
    //   3353: invokevirtual 3285	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   3356: istore 5
    //   3358: aload 17
    //   3360: astore_1
    //   3361: goto -2320 -> 1041
    //   3364: aload 21
    //   3366: ldc -48
    //   3368: aload_2
    //   3369: aload_3
    //   3370: aload 4
    //   3372: invokevirtual 3285	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   3375: istore 5
    //   3377: aload 17
    //   3379: astore_1
    //   3380: goto -2339 -> 1041
    //   3383: aload 21
    //   3385: ldc -19
    //   3387: aload_2
    //   3388: aload_3
    //   3389: aload 4
    //   3391: invokevirtual 3285	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   3394: istore 5
    //   3396: aload 17
    //   3398: astore_1
    //   3399: goto -2358 -> 1041
    //   3402: aload_1
    //   3403: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   3406: iconst_1
    //   3407: invokeinterface 619 2 0
    //   3412: checkcast 106	java/lang/String
    //   3415: astore_1
    //   3416: aload_1
    //   3417: invokestatic 552	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   3420: lstore 11
    //   3422: aload 20
    //   3424: lload 11
    //   3426: invokestatic 1270	com/android/emailcommon/provider/Account:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Account;
    //   3429: astore_3
    //   3430: aload_3
    //   3431: ifnonnull +52 -> 3483
    //   3434: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   3437: ldc_w 4195
    //   3440: iconst_1
    //   3441: anewarray 157	java/lang/Object
    //   3444: dup
    //   3445: iconst_0
    //   3446: aload_1
    //   3447: aastore
    //   3448: invokestatic 881	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   3451: pop
    //   3452: iconst_0
    //   3453: istore 5
    //   3455: goto -2414 -> 1041
    //   3458: astore_2
    //   3459: getstatic 104	com/android/email/provider/EmailProvider:a	Ljava/lang/String;
    //   3462: ldc_w 4101
    //   3465: iconst_1
    //   3466: anewarray 157	java/lang/Object
    //   3469: dup
    //   3470: iconst_0
    //   3471: aload_1
    //   3472: aastore
    //   3473: invokestatic 881	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   3476: pop
    //   3477: iconst_0
    //   3478: istore 5
    //   3480: goto -2439 -> 1041
    //   3483: aload_3
    //   3484: getfield 1446	com/android/emailcommon/provider/Account:d	Ljava/lang/String;
    //   3487: astore 4
    //   3489: aload 20
    //   3491: aload 4
    //   3493: invokestatic 3205	ayg:a	(Landroid/content/Context;Ljava/lang/String;)Layg;
    //   3496: astore_3
    //   3497: aload_2
    //   3498: ldc_w 4197
    //   3501: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   3504: ifeq +250 -> 3754
    //   3507: aload_2
    //   3508: ldc_w 4197
    //   3511: invokevirtual 2186	android/content/ContentValues:getAsBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   3514: invokevirtual 1847	java/lang/Boolean:booleanValue	()Z
    //   3517: istore 10
    //   3519: aload_0
    //   3520: aload 20
    //   3522: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   3525: astore_2
    //   3526: iconst_1
    //   3527: anewarray 106	java/lang/String
    //   3530: astore 17
    //   3532: aload 17
    //   3534: iconst_0
    //   3535: aload 4
    //   3537: aastore
    //   3538: iload 10
    //   3540: ifeq +67 -> 3607
    //   3543: new 163	android/content/ContentValues
    //   3546: dup
    //   3547: iconst_2
    //   3548: invokespecial 501	android/content/ContentValues:<init>	(I)V
    //   3551: astore 4
    //   3553: aload 4
    //   3555: ldc_w 4199
    //   3558: iconst_0
    //   3559: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3562: invokevirtual 920	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3565: aload 4
    //   3567: ldc_w 4201
    //   3570: iconst_0
    //   3571: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3574: invokevirtual 920	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3577: aload_2
    //   3578: ldc_w 4203
    //   3581: aload 4
    //   3583: ldc_w 4205
    //   3586: aload 17
    //   3588: invokevirtual 3285	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   3591: pop
    //   3592: iload 10
    //   3594: ifeq +486 -> 4080
    //   3597: iconst_1
    //   3598: istore 5
    //   3600: aload_3
    //   3601: invokevirtual 4208	ayg:h_	()V
    //   3604: goto +662 -> 4266
    //   3607: aload_2
    //   3608: ldc_w 4203
    //   3611: iconst_2
    //   3612: anewarray 106	java/lang/String
    //   3615: dup
    //   3616: iconst_0
    //   3617: ldc_w 4199
    //   3620: aastore
    //   3621: dup
    //   3622: iconst_1
    //   3623: ldc_w 4201
    //   3626: aastore
    //   3627: ldc_w 4205
    //   3630: aload 17
    //   3632: aconst_null
    //   3633: aconst_null
    //   3634: aconst_null
    //   3635: invokevirtual 413	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   3638: astore 4
    //   3640: aload 4
    //   3642: ifnull -50 -> 3592
    //   3645: aload 4
    //   3647: invokeinterface 568 1 0
    //   3652: ifeq +82 -> 3734
    //   3655: aload 4
    //   3657: aload 4
    //   3659: ldc_w 4199
    //   3662: invokeinterface 660 2 0
    //   3667: invokeinterface 1157 2 0
    //   3672: istore 5
    //   3674: aload 4
    //   3676: aload 4
    //   3678: ldc_w 4201
    //   3681: invokeinterface 660 2 0
    //   3686: invokeinterface 1157 2 0
    //   3691: ifeq +43 -> 3734
    //   3694: new 163	android/content/ContentValues
    //   3697: dup
    //   3698: iconst_1
    //   3699: invokespecial 501	android/content/ContentValues:<init>	(I)V
    //   3702: astore 18
    //   3704: aload 18
    //   3706: ldc_w 4199
    //   3709: iload 5
    //   3711: iconst_1
    //   3712: iadd
    //   3713: invokestatic 917	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3716: invokevirtual 920	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3719: aload_2
    //   3720: ldc_w 4203
    //   3723: aload 18
    //   3725: ldc_w 4205
    //   3728: aload 17
    //   3730: invokevirtual 3285	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   3733: pop
    //   3734: aload 4
    //   3736: invokeinterface 442 1 0
    //   3741: goto -149 -> 3592
    //   3744: astore_1
    //   3745: aload 4
    //   3747: invokeinterface 442 1 0
    //   3752: aload_1
    //   3753: athrow
    //   3754: aload_2
    //   3755: ldc_w 4210
    //   3758: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   3761: ifeq +33 -> 3794
    //   3764: new 3212	com/android/emailcommon/provider/ExchangeOofSettings
    //   3767: dup
    //   3768: aload_2
    //   3769: invokespecial 4211	com/android/emailcommon/provider/ExchangeOofSettings:<init>	(Landroid/content/ContentValues;)V
    //   3772: astore_2
    //   3773: aload_0
    //   3774: aload 20
    //   3776: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   3779: aload 4
    //   3781: aload_2
    //   3782: invokestatic 4214	azk:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lcom/android/emailcommon/provider/ExchangeOofSettings;)I
    //   3785: istore 5
    //   3787: aload_3
    //   3788: invokevirtual 4208	ayg:h_	()V
    //   3791: goto -2750 -> 1041
    //   3794: aload_2
    //   3795: ldc_w 4216
    //   3798: invokevirtual 1728	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   3801: ifeq +268 -> 4069
    //   3804: new 3212	com/android/emailcommon/provider/ExchangeOofSettings
    //   3807: dup
    //   3808: aload_2
    //   3809: invokespecial 4211	com/android/emailcommon/provider/ExchangeOofSettings:<init>	(Landroid/content/ContentValues;)V
    //   3812: astore_2
    //   3813: aload_0
    //   3814: aload 20
    //   3816: invokespecial 650	com/android/email/provider/EmailProvider:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   3819: aload 4
    //   3821: aload_2
    //   3822: invokestatic 4214	azk:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lcom/android/emailcommon/provider/ExchangeOofSettings;)I
    //   3825: pop
    //   3826: aload_2
    //   3827: getfield 3221	com/android/emailcommon/provider/ExchangeOofSettings:d	Z
    //   3830: ifeq +439 -> 4269
    //   3833: aload 20
    //   3835: lload 11
    //   3837: invokestatic 809	bam:a	(Landroid/content/Context;J)Lber;
    //   3840: lload 11
    //   3842: aload_2
    //   3843: invokeinterface 3226 4 0
    //   3848: goto +421 -> 4269
    //   3851: aload_0
    //   3852: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   3855: aload_1
    //   3856: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   3859: iconst_2
    //   3860: invokeinterface 619 2 0
    //   3865: checkcast 106	java/lang/String
    //   3868: aload_1
    //   3869: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   3872: iconst_1
    //   3873: invokeinterface 619 2 0
    //   3878: checkcast 106	java/lang/String
    //   3881: invokestatic 4219	beb:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)J
    //   3884: lstore 11
    //   3886: lload 11
    //   3888: ldc2_w 1099
    //   3891: lcmp
    //   3892: ifeq +383 -> 4275
    //   3895: aload_0
    //   3896: invokevirtual 543	com/android/email/provider/EmailProvider:getContext	()Landroid/content/Context;
    //   3899: lload 11
    //   3901: invokestatic 1581	beb:a	(Landroid/content/Context;J)Lbeb;
    //   3904: astore_1
    //   3905: new 163	android/content/ContentValues
    //   3908: dup
    //   3909: iconst_1
    //   3910: invokespecial 501	android/content/ContentValues:<init>	(I)V
    //   3913: astore_2
    //   3914: aload_2
    //   3915: ldc_w 1092
    //   3918: lload 11
    //   3920: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3923: invokevirtual 509	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3926: aload_2
    //   3927: ldc 110
    //   3929: aload_1
    //   3930: getfield 1304	beb:U	J
    //   3933: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3936: invokevirtual 509	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3939: aload 21
    //   3941: ldc -108
    //   3943: aconst_null
    //   3944: aload_2
    //   3945: invokevirtual 3560	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   3948: pop2
    //   3949: iconst_1
    //   3950: istore 5
    //   3952: aload 17
    //   3954: astore_1
    //   3955: goto -2914 -> 1041
    //   3958: aload_0
    //   3959: aload_2
    //   3960: invokestatic 4222	cge:a	(Lcgf;Landroid/content/ContentValues;)I
    //   3963: ireturn
    //   3964: aload_0
    //   3965: aload_1
    //   3966: aload_2
    //   3967: invokestatic 4225	cge:c	(Lcgf;Landroid/net/Uri;Landroid/content/ContentValues;)I
    //   3970: ireturn
    //   3971: aload_0
    //   3972: aload_1
    //   3973: aload_2
    //   3974: invokestatic 4227	cge:d	(Lcgf;Landroid/net/Uri;Landroid/content/ContentValues;)I
    //   3977: ireturn
    //   3978: aload_0
    //   3979: aload_1
    //   3980: invokestatic 4229	cge:a	(Lcgf;Landroid/net/Uri;)I
    //   3983: ireturn
    //   3984: aload_3
    //   3985: astore 17
    //   3987: iload 9
    //   3989: ldc_w 3360
    //   3992: if_icmpne +22 -> 4014
    //   3995: aload_1
    //   3996: invokevirtual 614	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   3999: iconst_1
    //   4000: invokeinterface 619 2 0
    //   4005: checkcast 106	java/lang/String
    //   4008: aload_3
    //   4009: invokestatic 3355	com/android/email/provider/EmailProvider:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4012: astore 17
    //   4014: aload_1
    //   4015: ldc_w 3610
    //   4018: iconst_0
    //   4019: invokevirtual 647	android/net/Uri:getBooleanQueryParameter	(Ljava/lang/String;Z)Z
    //   4022: aload_2
    //   4023: invokestatic 3613	azz:a	(ZLandroid/content/ContentValues;)V
    //   4026: aload 21
    //   4028: ldc_w 3362
    //   4031: aload_2
    //   4032: aload_1
    //   4033: aload 17
    //   4035: invokestatic 3367	azz:a	(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;
    //   4038: aload_1
    //   4039: aload 4
    //   4041: invokestatic 3370	azz:a	(Landroid/net/Uri;[Ljava/lang/String;)[Ljava/lang/String;
    //   4044: invokevirtual 3285	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   4047: istore 5
    //   4049: iload 5
    //   4051: istore 6
    //   4053: iload 5
    //   4055: ifle -4020 -> 35
    //   4058: aload_0
    //   4059: getstatic 3373	gqa:a	Landroid/net/Uri;
    //   4062: aconst_null
    //   4063: invokevirtual 538	com/android/email/provider/EmailProvider:a	(Landroid/net/Uri;Ljava/lang/String;)V
    //   4066: iload 5
    //   4068: ireturn
    //   4069: iload 6
    //   4071: istore 5
    //   4073: goto -3032 -> 1041
    //   4076: astore_2
    //   4077: goto -1069 -> 3008
    //   4080: iconst_0
    //   4081: istore 5
    //   4083: goto +183 -> 4266
    //   4086: ldc_w 2350
    //   4089: astore_1
    //   4090: iload 5
    //   4092: istore 6
    //   4094: goto -25 -> 4069
    //   4097: goto -1201 -> 2896
    //   4100: ldc_w 2350
    //   4103: astore_1
    //   4104: goto -35 -> 4069
    //   4107: ldc2_w 1099
    //   4110: lstore 13
    //   4112: ldc2_w 1099
    //   4115: lstore 11
    //   4117: goto -2446 -> 1671
    //   4120: iconst_1
    //   4121: istore 5
    //   4123: goto -2711 -> 1412
    //   4126: iconst_0
    //   4127: istore 10
    //   4129: goto -3506 -> 623
    //   4132: iconst_0
    //   4133: ireturn
    //   4134: iload 7
    //   4136: iconst_2
    //   4137: if_icmpeq -2932 -> 1205
    //   4140: iload 7
    //   4142: iconst_4
    //   4143: if_icmpne -2824 -> 1319
    //   4146: goto -2941 -> 1205
    //   4149: iconst_1
    //   4150: ireturn
    //   4151: aload 18
    //   4153: ifnonnull -2130 -> 2023
    //   4156: aload 24
    //   4158: ifnonnull -2135 -> 2023
    //   4161: aload 25
    //   4163: ifnull -2023 -> 2140
    //   4166: goto -2143 -> 2023
    //   4169: iconst_m1
    //   4170: istore 7
    //   4172: goto -2202 -> 1970
    //   4175: iconst_m1
    //   4176: istore 8
    //   4178: goto -2196 -> 1982
    //   4181: iconst_0
    //   4182: istore 5
    //   4184: goto -2183 -> 2001
    //   4187: iconst_m1
    //   4188: istore 5
    //   4190: goto -2189 -> 2001
    //   4193: iconst_0
    //   4194: istore 6
    //   4196: goto -45 -> 4151
    //   4199: iconst_m1
    //   4200: istore 6
    //   4202: goto -51 -> 4151
    //   4205: iload 9
    //   4207: sipush 8193
    //   4210: if_icmpeq -1926 -> 2284
    //   4213: iload 9
    //   4215: sipush 8194
    //   4218: if_icmpne -1773 -> 2445
    //   4221: goto -1937 -> 2284
    //   4224: aload 17
    //   4226: astore_1
    //   4227: goto -3186 -> 1041
    //   4230: aload 17
    //   4232: astore_1
    //   4233: goto -3192 -> 1041
    //   4236: aload 17
    //   4238: astore_1
    //   4239: goto -3198 -> 1041
    //   4242: aload 17
    //   4244: astore_1
    //   4245: goto -3204 -> 1041
    //   4248: iconst_0
    //   4249: istore 5
    //   4251: goto -1256 -> 2995
    //   4254: astore_2
    //   4255: aconst_null
    //   4256: astore_1
    //   4257: goto -1249 -> 3008
    //   4260: aload 17
    //   4262: astore_1
    //   4263: goto -3222 -> 1041
    //   4266: goto -3225 -> 1041
    //   4269: iconst_0
    //   4270: istore 5
    //   4272: goto -3231 -> 1041
    //   4275: iconst_0
    //   4276: istore 5
    //   4278: aload 17
    //   4280: astore_1
    //   4281: goto -3240 -> 1041
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4284	0	this	EmailProvider
    //   0	4284	1	paramUri	Uri
    //   0	4284	2	paramContentValues	ContentValues
    //   0	4284	3	paramString	String
    //   0	4284	4	paramArrayOfString	String[]
    //   940	3337	5	i1	int
    //   33	4168	6	i2	int
    //   1125	3046	7	i3	int
    //   1980	2197	8	i4	int
    //   77	4142	9	i5	int
    //   155	3973	10	bool	boolean
    //   985	3131	11	l1	long
    //   1608	2503	13	l2	long
    //   1861	49	15	l3	long
    //   145	4134	17	localObject1	Object
    //   672	3480	18	localObject2	Object
    //   67	998	19	localObject3	Object
    //   83	3751	20	localObject4	Object
    //   91	3936	21	localSQLiteDatabase	SQLiteDatabase
    //   140	3208	22	str	String
    //   1678	719	23	localObject5	Object
    //   1702	2455	24	localObject6	Object
    //   1854	2308	25	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   496	539	539	android/database/sqlite/SQLiteException
    //   546	557	539	android/database/sqlite/SQLiteException
    //   557	567	539	android/database/sqlite/SQLiteException
    //   567	597	539	android/database/sqlite/SQLiteException
    //   597	620	539	android/database/sqlite/SQLiteException
    //   623	629	539	android/database/sqlite/SQLiteException
    //   629	642	539	android/database/sqlite/SQLiteException
    //   644	689	539	android/database/sqlite/SQLiteException
    //   691	728	539	android/database/sqlite/SQLiteException
    //   733	738	539	android/database/sqlite/SQLiteException
    //   743	757	539	android/database/sqlite/SQLiteException
    //   757	765	539	android/database/sqlite/SQLiteException
    //   765	774	539	android/database/sqlite/SQLiteException
    //   780	788	539	android/database/sqlite/SQLiteException
    //   796	802	539	android/database/sqlite/SQLiteException
    //   819	838	539	android/database/sqlite/SQLiteException
    //   838	884	539	android/database/sqlite/SQLiteException
    //   887	903	539	android/database/sqlite/SQLiteException
    //   903	910	539	android/database/sqlite/SQLiteException
    //   910	931	539	android/database/sqlite/SQLiteException
    //   933	964	539	android/database/sqlite/SQLiteException
    //   967	1038	539	android/database/sqlite/SQLiteException
    //   1079	1088	539	android/database/sqlite/SQLiteException
    //   1093	1114	539	android/database/sqlite/SQLiteException
    //   1120	1136	539	android/database/sqlite/SQLiteException
    //   1151	1199	539	android/database/sqlite/SQLiteException
    //   1205	1225	539	android/database/sqlite/SQLiteException
    //   1232	1308	539	android/database/sqlite/SQLiteException
    //   1308	1316	539	android/database/sqlite/SQLiteException
    //   1325	1346	539	android/database/sqlite/SQLiteException
    //   1349	1355	539	android/database/sqlite/SQLiteException
    //   1358	1366	539	android/database/sqlite/SQLiteException
    //   1366	1371	539	android/database/sqlite/SQLiteException
    //   1420	1426	539	android/database/sqlite/SQLiteException
    //   1434	1440	539	android/database/sqlite/SQLiteException
    //   1440	1442	539	android/database/sqlite/SQLiteException
    //   1442	1459	539	android/database/sqlite/SQLiteException
    //   1490	1496	539	android/database/sqlite/SQLiteException
    //   1499	1505	539	android/database/sqlite/SQLiteException
    //   1508	1516	539	android/database/sqlite/SQLiteException
    //   1516	1538	539	android/database/sqlite/SQLiteException
    //   1545	1590	539	android/database/sqlite/SQLiteException
    //   1610	1629	539	android/database/sqlite/SQLiteException
    //   1664	1671	539	android/database/sqlite/SQLiteException
    //   1671	1680	539	android/database/sqlite/SQLiteException
    //   1685	1721	539	android/database/sqlite/SQLiteException
    //   1721	1731	539	android/database/sqlite/SQLiteException
    //   1769	1776	539	android/database/sqlite/SQLiteException
    //   1776	1778	539	android/database/sqlite/SQLiteException
    //   1779	1788	539	android/database/sqlite/SQLiteException
    //   1788	1799	539	android/database/sqlite/SQLiteException
    //   1807	1814	539	android/database/sqlite/SQLiteException
    //   1814	1822	539	android/database/sqlite/SQLiteException
    //   1827	1834	539	android/database/sqlite/SQLiteException
    //   1834	1918	539	android/database/sqlite/SQLiteException
    //   1921	1929	539	android/database/sqlite/SQLiteException
    //   1932	1958	539	android/database/sqlite/SQLiteException
    //   1963	1970	539	android/database/sqlite/SQLiteException
    //   1975	1982	539	android/database/sqlite/SQLiteException
    //   1987	1998	539	android/database/sqlite/SQLiteException
    //   2006	2017	539	android/database/sqlite/SQLiteException
    //   2023	2030	539	android/database/sqlite/SQLiteException
    //   2030	2137	539	android/database/sqlite/SQLiteException
    //   2140	2154	539	android/database/sqlite/SQLiteException
    //   2159	2185	539	android/database/sqlite/SQLiteException
    //   2236	2243	539	android/database/sqlite/SQLiteException
    //   2243	2256	539	android/database/sqlite/SQLiteException
    //   2264	2281	539	android/database/sqlite/SQLiteException
    //   2284	2300	539	android/database/sqlite/SQLiteException
    //   2300	2327	539	android/database/sqlite/SQLiteException
    //   2327	2352	539	android/database/sqlite/SQLiteException
    //   2383	2389	539	android/database/sqlite/SQLiteException
    //   2399	2401	539	android/database/sqlite/SQLiteException
    //   2401	2423	539	android/database/sqlite/SQLiteException
    //   2426	2433	539	android/database/sqlite/SQLiteException
    //   2437	2445	539	android/database/sqlite/SQLiteException
    //   2453	2497	539	android/database/sqlite/SQLiteException
    //   2497	2517	539	android/database/sqlite/SQLiteException
    //   2517	2534	539	android/database/sqlite/SQLiteException
    //   2538	2549	539	android/database/sqlite/SQLiteException
    //   2560	2603	539	android/database/sqlite/SQLiteException
    //   2603	2612	539	android/database/sqlite/SQLiteException
    //   2628	2675	539	android/database/sqlite/SQLiteException
    //   2675	2685	539	android/database/sqlite/SQLiteException
    //   2688	2750	539	android/database/sqlite/SQLiteException
    //   2750	2772	539	android/database/sqlite/SQLiteException
    //   2772	2780	539	android/database/sqlite/SQLiteException
    //   2790	2827	539	android/database/sqlite/SQLiteException
    //   2827	2838	539	android/database/sqlite/SQLiteException
    //   2841	2850	539	android/database/sqlite/SQLiteException
    //   2853	2896	539	android/database/sqlite/SQLiteException
    //   2901	2954	539	android/database/sqlite/SQLiteException
    //   2999	3005	539	android/database/sqlite/SQLiteException
    //   3012	3018	539	android/database/sqlite/SQLiteException
    //   3018	3020	539	android/database/sqlite/SQLiteException
    //   3020	3040	539	android/database/sqlite/SQLiteException
    //   3040	3067	539	android/database/sqlite/SQLiteException
    //   3067	3071	539	android/database/sqlite/SQLiteException
    //   3081	3097	539	android/database/sqlite/SQLiteException
    //   3106	3155	539	android/database/sqlite/SQLiteException
    //   3155	3171	539	android/database/sqlite/SQLiteException
    //   3174	3183	539	android/database/sqlite/SQLiteException
    //   3186	3210	539	android/database/sqlite/SQLiteException
    //   3235	3243	539	android/database/sqlite/SQLiteException
    //   3280	3286	539	android/database/sqlite/SQLiteException
    //   3289	3293	539	android/database/sqlite/SQLiteException
    //   3301	3345	539	android/database/sqlite/SQLiteException
    //   3345	3358	539	android/database/sqlite/SQLiteException
    //   3364	3377	539	android/database/sqlite/SQLiteException
    //   3383	3396	539	android/database/sqlite/SQLiteException
    //   3402	3416	539	android/database/sqlite/SQLiteException
    //   3416	3430	539	android/database/sqlite/SQLiteException
    //   3434	3452	539	android/database/sqlite/SQLiteException
    //   3459	3477	539	android/database/sqlite/SQLiteException
    //   3483	3532	539	android/database/sqlite/SQLiteException
    //   3543	3592	539	android/database/sqlite/SQLiteException
    //   3600	3604	539	android/database/sqlite/SQLiteException
    //   3607	3640	539	android/database/sqlite/SQLiteException
    //   3734	3741	539	android/database/sqlite/SQLiteException
    //   3745	3754	539	android/database/sqlite/SQLiteException
    //   3754	3791	539	android/database/sqlite/SQLiteException
    //   3794	3848	539	android/database/sqlite/SQLiteException
    //   3851	3886	539	android/database/sqlite/SQLiteException
    //   3895	3949	539	android/database/sqlite/SQLiteException
    //   3958	3964	539	android/database/sqlite/SQLiteException
    //   3964	3971	539	android/database/sqlite/SQLiteException
    //   3971	3978	539	android/database/sqlite/SQLiteException
    //   3978	3984	539	android/database/sqlite/SQLiteException
    //   3995	4014	539	android/database/sqlite/SQLiteException
    //   4014	4049	539	android/database/sqlite/SQLiteException
    //   4058	4066	539	android/database/sqlite/SQLiteException
    //   1373	1390	1429	finally
    //   1392	1401	1429	finally
    //   1403	1412	1429	finally
    //   1459	1490	1507	finally
    //   1736	1760	1763	finally
    //   1634	1664	1778	finally
    //   2185	2228	2395	finally
    //   2228	2231	2395	finally
    //   2396	2399	2395	finally
    //   2356	2383	2436	finally
    //   3210	3218	3234	finally
    //   3223	3234	3234	finally
    //   3243	3248	3234	finally
    //   3251	3271	3234	finally
    //   3416	3430	3458	java/lang/NumberFormatException
    //   3434	3452	3458	java/lang/NumberFormatException
    //   3645	3734	3744	finally
    //   2987	2995	4076	finally
    //   2960	2983	4254	finally
  }
}

/* Location:
 * Qualified Name:     com.android.email.provider.EmailProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */