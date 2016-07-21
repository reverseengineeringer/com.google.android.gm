package com.android.emailcommon.provider;

import android.accounts.Account;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.provider.BaseColumns;
import android.util.SparseBooleanArray;
import bbw;
import bdv;
import bdz;
import bhn;
import cvm;
import hbc;
import java.util.ArrayList;
import oi;
import oj;

public class Mailbox
  extends bdv
  implements Parcelable, BaseColumns
{
  public static final Parcelable.Creator<Mailbox> CREATOR = new bdz();
  public static final String[] P;
  public static final String[] Q;
  public static final String[] R;
  public static final SparseBooleanArray S;
  public static final int[] T;
  public static final oj<String> U;
  public static final oi<String, Integer> V;
  public static final oi<String, Integer> W;
  private static final String[] X;
  public static Uri a;
  public static Uri b;
  public static final String[] z = { "_id", "displayName", "serverId", "parentServerId", "accountKey", "type", "delimiter", "syncKey", "syncLookback", "syncInterval", "syncTime", "flagVisible", "flags", "syncStatus", "parentKey", "lastTouchedTime", "uiSyncStatus", "uiLastSyncResult", "totalCount", "hierarchicalName", "lastFullSyncTime", "localOnly", "previousName", "isDeleted" };
  public String c;
  public String d;
  public String e;
  public long f;
  public long g;
  public int h;
  public int i;
  public String j;
  public int k;
  public int l;
  public long m;
  public boolean n = true;
  public int o;
  public String p;
  public long q;
  public int r;
  public int s;
  public int t;
  public String u;
  public long v;
  public boolean w;
  public String x;
  public boolean y;
  
  static
  {
    P = new String[] { "type" };
    Q = new String[] { "displayName" };
    R = new String[] { "flags" };
    X = new String[] { "accountKey" };
    Object localObject = new SparseBooleanArray(11);
    S = (SparseBooleanArray)localObject;
    ((SparseBooleanArray)localObject).put(0, true);
    S.put(1, false);
    S.put(5, true);
    S.put(6, false);
    S.put(65, true);
    S.put(66, true);
    T = new int[] { 0, 3, 4, 5, 6 };
    U = new oj(8);
    V = new oi(10);
    U.a(0, "Inbox");
    U.a(4, "Outbox");
    U.a(3, "Drafts");
    U.a(6, "Trash");
    U.a(5, "Sent");
    U.a(7, "Junk");
    U.a(9, "Starred");
    U.a(10, "Unread");
    U.a(11, "Flagged");
    V.put("Inbox", Integer.valueOf(0));
    V.put("Outbox", Integer.valueOf(4));
    V.put("Drafts", Integer.valueOf(3));
    V.put("Trash", Integer.valueOf(6));
    V.put("Sent", Integer.valueOf(5));
    V.put("Junk", Integer.valueOf(7));
    V.put("Starred", Integer.valueOf(9));
    V.put("Unread", Integer.valueOf(10));
    V.put("Flagged", Integer.valueOf(11));
    localObject = new oi(4);
    W = (oi)localObject;
    ((oi)localObject).put("\\Drafts", Integer.valueOf(3));
    W.put("\\Junk", Integer.valueOf(7));
    W.put("\\Sent", Integer.valueOf(5));
    W.put("\\Trash", Integer.valueOf(6));
  }
  
  public Mailbox()
  {
    C = a;
  }
  
  public Mailbox(Parcel paramParcel)
  {
    C = ((Uri)paramParcel.readParcelable(null));
    D = paramParcel.readLong();
    c = paramParcel.readString();
    d = paramParcel.readString();
    e = paramParcel.readString();
    f = paramParcel.readLong();
    g = paramParcel.readLong();
    h = f(paramParcel.readInt());
    i = paramParcel.readInt();
    j = paramParcel.readString();
    k = paramParcel.readInt();
    l = paramParcel.readInt();
    m = paramParcel.readLong();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      n = bool1;
      o = paramParcel.readInt();
      p = paramParcel.readString();
      q = paramParcel.readLong();
      r = paramParcel.readInt();
      s = paramParcel.readInt();
      t = paramParcel.readInt();
      u = paramParcel.readString();
      v = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label245;
      }
      bool1 = true;
      label211:
      w = bool1;
      x = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label250;
      }
    }
    label245:
    label250:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      y = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label211;
    }
  }
  
  public static long a(Context paramContext, long paramLong, int paramInt)
  {
    return bhn.a(paramContext, a, B, "type=? and accountKey=?", new String[] { String.valueOf(paramInt), String.valueOf(paramLong) }, null, Long.valueOf(-1L)).longValue();
  }
  
  public static long a(Context paramContext, String paramString)
  {
    return bhn.a(paramContext, a.buildUpon().appendEncodedPath(paramString).build(), X, null, null, null, Long.valueOf(-1L)).longValue();
  }
  
  public static Cursor a(ContentResolver paramContentResolver, long paramLong)
  {
    return paramContentResolver.query(a, z, "syncKey is not null and syncKey!='' and syncKey!='0' and syncInterval=1 and accountKey=?", new String[] { String.valueOf(paramLong) }, null);
  }
  
  public static Bundle a(long paramLong)
  {
    Bundle localBundle = new Bundle(2);
    localBundle.putInt("__mailboxCount__", 1);
    localBundle.putLong(e(0), paramLong);
    return localBundle;
  }
  
  public static Bundle a(ArrayList<Long> paramArrayList)
  {
    Bundle localBundle = new Bundle(paramArrayList.size() + 3);
    localBundle.putInt("__mailboxCount__", paramArrayList.size());
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      localBundle.putLong(e(i1), ((Long)paramArrayList.get(i1)).longValue());
      i1 += 1;
    }
    return localBundle;
  }
  
  public static Mailbox a(long paramLong, int paramInt)
  {
    int i3 = 8;
    int i4 = 0;
    int i1 = i3;
    int i2 = i4;
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      throw new IllegalArgumentException(50 + "Bad mailbox type for newSystemMailbox: " + paramInt);
    case 0: 
      i1 = 24;
      i2 = i4;
    }
    for (;;)
    {
      Mailbox localMailbox = new Mailbox();
      g = paramLong;
      h = paramInt;
      l = i2;
      n = true;
      String str = a(paramInt);
      c = str;
      d = str;
      f = -1L;
      o = i1;
      return localMailbox;
      i2 = -1;
      i1 = i3;
    }
  }
  
  public static Mailbox a(Context paramContext, long paramLong)
  {
    return (Mailbox)bdv.a(paramContext, Mailbox.class, a, z, paramLong);
  }
  
  public static Mailbox a(Context paramContext, long paramLong, String paramString)
  {
    paramString = b(paramContext, paramLong, paramString);
    paramContext = paramString;
    if (paramString == null) {
      paramContext = new Mailbox();
    }
    return paramContext;
  }
  
  public static String a(int paramInt)
  {
    String str = (String)U.a(paramInt);
    if (str != null) {
      return str;
    }
    throw new IllegalArgumentException(32 + "Illegal mailbox type " + paramInt);
  }
  
  public static void a()
  {
    String str = String.valueOf(bdv.H);
    a = Uri.parse(String.valueOf(str).length() + 8 + str + "/mailbox");
    str = String.valueOf(bdv.H);
    b = Uri.parse(String.valueOf(str).length() + 13 + str + "/mailboxCount");
  }
  
  /* Error */
  public static void a(ContentResolver paramContentResolver, Account paramAccount, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 196	com/android/emailcommon/provider/Mailbox:a	Landroid/net/Uri;
    //   4: iconst_2
    //   5: anewarray 62	java/lang/String
    //   8: dup
    //   9: iconst_0
    //   10: ldc 74
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: ldc 68
    //   17: aastore
    //   18: ldc_w 410
    //   21: iconst_1
    //   22: anewarray 62	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: lload_2
    //   28: invokestatic 282	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   31: aastore
    //   32: aconst_null
    //   33: invokevirtual 321	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore 5
    //   38: aload 5
    //   40: ifnull +13 -> 53
    //   43: aload 5
    //   45: invokeinterface 415 1 0
    //   50: ifne +25 -> 75
    //   53: getstatic 419	bbw:a	Ljava/lang/String;
    //   56: ldc_w 421
    //   59: iconst_1
    //   60: anewarray 423	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: lload_2
    //   66: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   69: aastore
    //   70: invokestatic 428	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   73: pop
    //   74: return
    //   75: aload 5
    //   77: invokeinterface 432 1 0
    //   82: pop
    //   83: aload 5
    //   85: aload 5
    //   87: ldc 74
    //   89: invokeinterface 436 2 0
    //   94: invokeinterface 439 2 0
    //   99: istore 4
    //   101: iload 4
    //   103: bipush 64
    //   105: if_icmplt +73 -> 178
    //   108: iload 4
    //   110: bipush 65
    //   112: if_icmpeq +66 -> 178
    //   115: iload 4
    //   117: bipush 66
    //   119: if_icmpeq +59 -> 178
    //   122: new 352	java/lang/IllegalArgumentException
    //   125: dup
    //   126: ldc_w 441
    //   129: iconst_1
    //   130: anewarray 423	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: lload_2
    //   136: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   139: aastore
    //   140: invokestatic 445	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   143: invokespecial 370	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   146: athrow
    //   147: astore_0
    //   148: getstatic 419	bbw:a	Ljava/lang/String;
    //   151: aload_0
    //   152: ldc_w 447
    //   155: iconst_1
    //   156: anewarray 423	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: lload_2
    //   162: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   165: aastore
    //   166: invokestatic 450	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   169: pop
    //   170: aload 5
    //   172: invokeinterface 453 1 0
    //   177: return
    //   178: aload 5
    //   180: aload 5
    //   182: ldc 68
    //   184: invokeinterface 436 2 0
    //   189: invokeinterface 456 2 0
    //   194: invokestatic 462	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: ifeq +28 -> 225
    //   200: new 352	java/lang/IllegalArgumentException
    //   203: dup
    //   204: ldc_w 464
    //   207: iconst_1
    //   208: anewarray 423	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: lload_2
    //   214: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   217: aastore
    //   218: invokestatic 445	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   221: invokespecial 370	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   224: athrow
    //   225: new 340	java/util/ArrayList
    //   228: dup
    //   229: invokespecial 465	java/util/ArrayList:<init>	()V
    //   232: astore 6
    //   234: iload 4
    //   236: bipush 64
    //   238: if_icmpge +35 -> 273
    //   241: aload 6
    //   243: getstatic 468	beb:a	Landroid/net/Uri;
    //   246: invokestatic 474	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   249: ldc_w 476
    //   252: iconst_1
    //   253: anewarray 62	java/lang/String
    //   256: dup
    //   257: iconst_0
    //   258: lload_2
    //   259: invokestatic 282	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   262: aastore
    //   263: invokevirtual 482	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   266: invokevirtual 485	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   269: invokevirtual 489	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   272: pop
    //   273: aload 6
    //   275: getstatic 196	com/android/emailcommon/provider/Mailbox:a	Landroid/net/Uri;
    //   278: lload_2
    //   279: invokestatic 495	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   282: invokestatic 498	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   285: ldc 78
    //   287: ldc_w 500
    //   290: invokevirtual 504	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   293: invokevirtual 485	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   296: invokevirtual 489	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   299: pop
    //   300: aload_0
    //   301: getstatic 507	com/android/emailcommon/provider/Mailbox:F	Ljava/lang/String;
    //   304: aload 6
    //   306: invokevirtual 511	android/content/ContentResolver:applyBatch	(Ljava/lang/String;Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;
    //   309: pop
    //   310: lload_2
    //   311: invokestatic 513	com/android/emailcommon/provider/Mailbox:a	(J)Landroid/os/Bundle;
    //   314: astore_0
    //   315: aload_0
    //   316: ldc_w 515
    //   319: iconst_1
    //   320: invokevirtual 519	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   323: aload_0
    //   324: ldc_w 521
    //   327: iconst_1
    //   328: invokevirtual 519	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   331: aload_1
    //   332: getstatic 507	com/android/emailcommon/provider/Mailbox:F	Ljava/lang/String;
    //   335: aload_0
    //   336: invokestatic 525	android/content/ContentResolver:requestSync	(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)V
    //   339: getstatic 419	bbw:a	Ljava/lang/String;
    //   342: ldc_w 527
    //   345: iconst_2
    //   346: anewarray 423	java/lang/Object
    //   349: dup
    //   350: iconst_0
    //   351: aload_1
    //   352: aastore
    //   353: dup
    //   354: iconst_1
    //   355: aload_0
    //   356: aastore
    //   357: invokestatic 529	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   360: pop
    //   361: aload 5
    //   363: invokeinterface 453 1 0
    //   368: return
    //   369: astore_0
    //   370: aload 5
    //   372: invokeinterface 453 1 0
    //   377: aload_0
    //   378: athrow
    //   379: astore_0
    //   380: goto -232 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramContentResolver	ContentResolver
    //   0	383	1	paramAccount	Account
    //   0	383	2	paramLong	long
    //   99	140	4	i1	int
    //   36	335	5	localCursor	Cursor
    //   232	73	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   75	101	147	android/os/RemoteException
    //   122	147	147	android/os/RemoteException
    //   178	225	147	android/os/RemoteException
    //   225	234	147	android/os/RemoteException
    //   241	273	147	android/os/RemoteException
    //   273	361	147	android/os/RemoteException
    //   75	101	369	finally
    //   122	147	369	finally
    //   148	170	369	finally
    //   178	225	369	finally
    //   225	234	369	finally
    //   241	273	369	finally
    //   273	361	369	finally
    //   75	101	379	android/content/OperationApplicationException
    //   122	147	379	android/content/OperationApplicationException
    //   178	225	379	android/content/OperationApplicationException
    //   225	234	379	android/content/OperationApplicationException
    //   241	273	379	android/content/OperationApplicationException
    //   273	361	379	android/content/OperationApplicationException
  }
  
  public static void a(Context paramContext, Account paramAccount)
  {
    Mailbox[] arrayOfMailbox = a(paramContext);
    ArrayList localArrayList;
    if (arrayOfMailbox.length > 0)
    {
      localArrayList = new ArrayList();
      int i2 = arrayOfMailbox.length;
      int i1 = 0;
      while (i1 < i2)
      {
        Mailbox localMailbox = arrayOfMailbox[i1];
        localArrayList.add(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(a, D)).withValue("syncKey", "0").build());
        i1 += 1;
      }
      paramContext = paramContext.getContentResolver();
    }
    try
    {
      paramContext.applyBatch(F, localArrayList);
      paramContext = new Bundle(2);
      paramContext.putBoolean("ignore_settings", true);
      paramContext.putBoolean("wiped", true);
      ContentResolver.requestSync(paramAccount, F, paramContext);
      cvm.c(bbw.a, "requestSync wipeResyncContactsMailbox %s, %s", new Object[] { paramAccount, paramContext });
      return;
    }
    catch (RemoteException paramContext)
    {
      cvm.d(bbw.a, paramContext, "Failed to wipe Contacts mailboxes", new Object[0]);
      return;
    }
    catch (OperationApplicationException paramContext)
    {
      for (;;) {}
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      S.put(3, true);
      return;
    }
    S.delete(3);
  }
  
  public static long[] a(Bundle paramBundle)
  {
    int i1 = 0;
    int i2 = paramBundle.getInt("__mailboxCount__", 0);
    if (i2 > 0)
    {
      if (paramBundle.getBoolean("__push_only__", false)) {
        cvm.d(bbw.a, "Mailboxes specified in a push only sync", new Object[0]);
      }
      if (paramBundle.getBoolean("__account_only__", false)) {
        cvm.d(bbw.a, "Mailboxes specified in an account only sync", new Object[0]);
      }
      long[] arrayOfLong2 = new long[i2];
      for (;;)
      {
        arrayOfLong1 = arrayOfLong2;
        if (i1 >= i2) {
          break;
        }
        arrayOfLong2[i1] = paramBundle.getLong(e(i1), 0L);
        i1 += 1;
      }
    }
    long[] arrayOfLong1 = null;
    return arrayOfLong1;
  }
  
  private static Mailbox[] a(Context paramContext)
  {
    Cursor localCursor = paramContext.getContentResolver().query(a, z, "type=?", new String[] { "66" }, null);
    ArrayList localArrayList = new ArrayList();
    if ((localCursor != null) && (localCursor.moveToFirst())) {}
    try
    {
      boolean bool;
      do
      {
        localArrayList.add((Mailbox)a(paramContext, localCursor, Mailbox.class));
        bool = localCursor.moveToNext();
      } while (bool);
      return (Mailbox[])localArrayList.toArray(new Mailbox[localArrayList.size()]);
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public static Cursor b(ContentResolver paramContentResolver, long paramLong)
  {
    return paramContentResolver.query(a, B, "(type=4 or syncInterval=1) and accountKey=?", new String[] { String.valueOf(paramLong) }, "type ASC");
  }
  
  public static Mailbox b(Context paramContext, long paramLong, int paramInt)
  {
    paramLong = a(paramContext, paramLong, paramInt);
    if (paramLong != -1L) {
      return a(paramContext, paramLong);
    }
    return null;
  }
  
  /* Error */
  private static Mailbox b(Context paramContext, long paramLong, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 539	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 196	com/android/emailcommon/provider/Mailbox:a	Landroid/net/Uri;
    //   7: getstatic 112	com/android/emailcommon/provider/Mailbox:z	[Ljava/lang/String;
    //   10: ldc_w 594
    //   13: iconst_2
    //   14: anewarray 62	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: aload_3
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: lload_1
    //   24: invokestatic 282	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   27: aastore
    //   28: aconst_null
    //   29: invokevirtual 321	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 5
    //   34: aload 5
    //   36: ifnonnull +11 -> 47
    //   39: new 596	bej
    //   42: dup
    //   43: invokespecial 597	bej:<init>	()V
    //   46: athrow
    //   47: aload 5
    //   49: invokeinterface 432 1 0
    //   54: ifeq +59 -> 113
    //   57: aload_0
    //   58: aload 5
    //   60: ldc 2
    //   62: invokestatic 574	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;Landroid/database/Cursor;Ljava/lang/Class;)Lbdv;
    //   65: checkcast 2	com/android/emailcommon/provider/Mailbox
    //   68: astore 4
    //   70: aload 4
    //   72: astore_0
    //   73: aload 5
    //   75: invokeinterface 577 1 0
    //   80: ifeq +24 -> 104
    //   83: getstatic 419	bbw:a	Ljava/lang/String;
    //   86: ldc_w 599
    //   89: iconst_1
    //   90: anewarray 423	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_3
    //   96: aastore
    //   97: invokestatic 428	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   100: pop
    //   101: aload 4
    //   103: astore_0
    //   104: aload 5
    //   106: invokeinterface 453 1 0
    //   111: aload_0
    //   112: areturn
    //   113: getstatic 419	bbw:a	Ljava/lang/String;
    //   116: ldc_w 601
    //   119: iconst_1
    //   120: anewarray 423	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_3
    //   126: aastore
    //   127: invokestatic 529	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   130: pop
    //   131: aconst_null
    //   132: astore_0
    //   133: goto -29 -> 104
    //   136: astore_0
    //   137: aload 5
    //   139: invokeinterface 453 1 0
    //   144: aload_0
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramContext	Context
    //   0	146	1	paramLong	long
    //   0	146	3	paramString	String
    //   68	34	4	localMailbox	Mailbox
    //   32	106	5	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   47	70	136	finally
    //   73	101	136	finally
    //   113	131	136	finally
  }
  
  public static boolean b(int paramInt)
  {
    return S.indexOfKey(paramInt) >= 0;
  }
  
  public static boolean b(Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("__account_only__", false);
    if ((bool) && (paramBundle.getInt("__mailboxCount__", 0) != 0)) {
      cvm.d(bbw.a, "Mailboxes specified in an account only sync", new Object[0]);
    }
    return bool;
  }
  
  public static Mailbox[] b(Context paramContext, int paramInt)
  {
    Cursor localCursor = paramContext.getContentResolver().query(a, z, 16 + "TYPE=" + paramInt, null, null);
    if (localCursor == null) {
      return null;
    }
    Mailbox[] arrayOfMailbox = new Mailbox[localCursor.getCount()];
    paramInt = -1;
    try
    {
      while (localCursor.moveToNext())
      {
        paramInt += 1;
        arrayOfMailbox[paramInt] = ((Mailbox)a(paramContext, localCursor, Mailbox.class));
      }
      return arrayOfMailbox;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Unknown";
    case 0: 
      return "Inbox";
    case 1: 
      return "Folder";
    case 2: 
      return "Parent";
    case 3: 
      return "Drafts";
    case 4: 
      return "Outbox";
    case 5: 
      return "Sent";
    case 6: 
      return "Trash";
    case 7: 
      return "Spam";
    case 8: 
      return "Search";
    case 9: 
      return "Starred";
    case 11: 
      return "Flagged";
    case 10: 
      return "Unread";
    case 64: 
    case 65: 
    case 66: 
    case 257: 
      return "Other";
    case 67: 
    case 69: 
      return "Unknown";
    }
    return "Unknown";
  }
  
  public static boolean c(Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("__push_only__", false);
    if ((bool) && (paramBundle.getInt("__mailboxCount__", 0) != 0)) {
      cvm.d(bbw.a, "Mailboxes specified in a push only sync", new Object[0]);
    }
    return bool;
  }
  
  public static String d(int paramInt)
  {
    switch (paramInt)
    {
    case 68: 
    default: 
      return bdv.F;
    case 65: 
      return "com.android.calendar";
    case 66: 
      return "com.android.contacts";
    case 67: 
    case 69: 
      return bdv.F;
    }
    return bdv.F;
  }
  
  private static String e(int paramInt)
  {
    return String.format("__mailboxId%d__", new Object[] { Integer.valueOf(paramInt) });
  }
  
  private static int f(int paramInt)
  {
    int i1 = paramInt;
    switch (paramInt)
    {
    default: 
      i1 = -1;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 64: 
    case 65: 
    case 66: 
    case 68: 
    case 257: 
      return i1;
    case 67: 
    case 69: 
      return -1;
    }
    return -1;
  }
  
  public final void a(Context paramContext, int paramInt)
  {
    if (paramInt != t)
    {
      ContentValues localContentValues = new ContentValues(1);
      localContentValues.put("totalCount", Integer.valueOf(paramInt));
      a(paramContext, localContentValues);
      t = paramInt;
    }
  }
  
  public final void a(Cursor paramCursor)
  {
    boolean bool2 = true;
    C = a;
    D = paramCursor.getLong(0);
    c = paramCursor.getString(1);
    d = paramCursor.getString(2);
    e = paramCursor.getString(3);
    f = paramCursor.getLong(14);
    g = paramCursor.getLong(4);
    h = f(paramCursor.getInt(5));
    i = paramCursor.getInt(6);
    j = paramCursor.getString(7);
    k = paramCursor.getInt(8);
    l = paramCursor.getInt(9);
    m = paramCursor.getLong(10);
    if (paramCursor.getInt(11) == 1)
    {
      bool1 = true;
      n = bool1;
      o = paramCursor.getInt(12);
      p = paramCursor.getString(13);
      q = paramCursor.getLong(15);
      r = paramCursor.getInt(16);
      s = paramCursor.getInt(17);
      t = paramCursor.getInt(18);
      u = paramCursor.getString(19);
      v = paramCursor.getInt(20);
      if (paramCursor.getInt(21) != 1) {
        break label322;
      }
      bool1 = true;
      label280:
      w = bool1;
      x = paramCursor.getString(22);
      if (paramCursor.getInt(23) != 1) {
        break label327;
      }
    }
    label322:
    label327:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      y = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label280;
    }
  }
  
  public final Object[] d()
  {
    Object[] arrayOfObject = new Object[z.length];
    arrayOfObject[0] = Long.valueOf(D);
    arrayOfObject[1] = c;
    arrayOfObject[2] = d;
    arrayOfObject[3] = e;
    arrayOfObject[4] = Long.valueOf(g);
    arrayOfObject[5] = Integer.valueOf(h);
    arrayOfObject[6] = Integer.valueOf(i);
    arrayOfObject[7] = j;
    arrayOfObject[8] = Integer.valueOf(k);
    arrayOfObject[9] = Integer.valueOf(l);
    arrayOfObject[10] = Long.valueOf(m);
    arrayOfObject[11] = Boolean.valueOf(n);
    arrayOfObject[12] = Integer.valueOf(o);
    arrayOfObject[13] = p;
    arrayOfObject[14] = Long.valueOf(f);
    arrayOfObject[15] = Long.valueOf(q);
    arrayOfObject[16] = Integer.valueOf(r);
    arrayOfObject[17] = Integer.valueOf(s);
    arrayOfObject[18] = Integer.valueOf(t);
    arrayOfObject[19] = u;
    return arrayOfObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final ContentValues e()
  {
    ContentValues localContentValues = new ContentValues(21);
    localContentValues.put("displayName", c);
    localContentValues.put("serverId", d);
    localContentValues.put("parentServerId", e);
    localContentValues.put("parentKey", Long.valueOf(f));
    localContentValues.put("accountKey", Long.valueOf(g));
    localContentValues.put("type", Integer.valueOf(h));
    localContentValues.put("delimiter", Integer.valueOf(i));
    localContentValues.put("syncKey", j);
    localContentValues.put("syncLookback", Integer.valueOf(k));
    localContentValues.put("syncInterval", Integer.valueOf(l));
    localContentValues.put("syncTime", Long.valueOf(m));
    localContentValues.put("flagVisible", Boolean.valueOf(n));
    localContentValues.put("flags", Integer.valueOf(o));
    localContentValues.put("syncStatus", p);
    localContentValues.put("lastTouchedTime", Long.valueOf(q));
    localContentValues.put("uiSyncStatus", Integer.valueOf(r));
    localContentValues.put("uiLastSyncResult", Integer.valueOf(s));
    localContentValues.put("totalCount", Integer.valueOf(t));
    localContentValues.put("hierarchicalName", u);
    localContentValues.put("lastFullSyncTime", Long.valueOf(v));
    localContentValues.put("localOnly", Boolean.valueOf(w));
    localContentValues.put("previousName", x);
    localContentValues.put("isDeleted", Boolean.valueOf(y));
    return localContentValues;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Mailbox)) {}
    do
    {
      return false;
      paramObject = (Mailbox)paramObject;
    } while ((D != D) || (f != f) || (h != h) || (i != i) || (k != k) || (l != l) || (m != m) || (n != n) || (o != o) || (q != q) || (r != r) || (s != s) || (t != t) || (v != v) || (w != w) || (y != y) || (!hbc.a(c, c)) || (!hbc.a(d, d)) || (!hbc.a(e, e)) || (!hbc.a(j, j)) || (!hbc.a(p, p)) || (!hbc.a(u, u)) || (!hbc.a(x, x)));
    return true;
  }
  
  public int hashCode()
  {
    return (int)D;
  }
  
  public String toString()
  {
    long l1 = D;
    String str1 = String.valueOf(c(h));
    String str2 = c;
    return String.valueOf(str1).length() + 33 + String.valueOf(str2).length() + "[Mailbox " + l1 + " " + str1 + ": " + str2 + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeParcelable(C, paramInt);
    paramParcel.writeLong(D);
    paramParcel.writeString(c);
    paramParcel.writeString(d);
    paramParcel.writeString(e);
    paramParcel.writeLong(f);
    paramParcel.writeLong(g);
    paramParcel.writeInt(h);
    paramParcel.writeInt(i);
    paramParcel.writeString(j);
    paramParcel.writeInt(k);
    paramParcel.writeInt(l);
    paramParcel.writeLong(m);
    if (n)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(o);
      paramParcel.writeString(p);
      paramParcel.writeLong(q);
      paramParcel.writeInt(r);
      paramParcel.writeInt(s);
      paramParcel.writeInt(t);
      paramParcel.writeString(u);
      paramParcel.writeLong(v);
      if (!w) {
        break label227;
      }
      paramInt = 1;
      label194:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(x);
      if (!y) {
        break label232;
      }
    }
    label227:
    label232:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label194;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.emailcommon.provider.Mailbox
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */