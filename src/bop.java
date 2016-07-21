import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Mailbox;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class bop
  extends bnx
{
  private static final SparseIntArray i;
  private static final String[] n;
  private static final String[] o;
  private static final String[] p;
  private static final String q;
  private static final ContentValues y;
  private static final String[] z = { "serverId", "syncInterval", "syncLookback", "uiSyncStatus" };
  long f = b.D;
  String g = Long.toString(f);
  final HashMap<String, boq> h = new HashMap();
  private final String[] r = new String[2];
  private final ArrayList<ContentProviderOperation> s = new ArrayList();
  private boolean t;
  private final Set<String> u = new LinkedHashSet();
  private boolean v = false;
  private final boolean w;
  private final SparseBooleanArray x = new SparseBooleanArray(Mailbox.T.length);
  
  static
  {
    Object localObject = new SparseIntArray(11);
    i = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(1, 1);
    i.put(2, 0);
    i.put(3, 3);
    i.put(4, 6);
    i.put(5, 5);
    i.put(6, 4);
    i.put(8, 65);
    i.put(9, 66);
    i.put(12, 1);
    i.put(13, 65);
    i.put(14, 66);
    n = new String[] { "_id", "serverId", "parentServerId" };
    o = new String[] { "_id", "flags" };
    p = new String[] { "_id" };
    q = Long.toString(-1L);
    localObject = new ContentValues();
    y = (ContentValues)localObject;
    ((ContentValues)localObject).put("parentKey", Long.valueOf(0L));
  }
  
  public bop(Context paramContext, ContentResolver paramContentResolver, InputStream paramInputStream, Account paramAccount, boolean paramBoolean)
  {
    super(paramContext, paramContentResolver, paramInputStream, null, paramAccount);
    w = paramBoolean;
  }
  
  /* Error */
  private final void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +154 -> 155
    //   4: aload_2
    //   5: ifnonnull +7 -> 12
    //   8: aload_3
    //   9: ifnull +146 -> 155
    //   12: aload_0
    //   13: aload_1
    //   14: invokespecial 152	bop:b	(Ljava/lang/String;)Landroid/database/Cursor;
    //   17: astore 4
    //   19: aload 4
    //   21: invokeinterface 158 1 0
    //   26: ifeq +122 -> 148
    //   29: ldc -96
    //   31: ldc -94
    //   33: iconst_1
    //   34: anewarray 164	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: invokestatic 169	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   44: pop
    //   45: new 76	android/content/ContentValues
    //   48: dup
    //   49: invokespecial 78	android/content/ContentValues:<init>	()V
    //   52: astore_1
    //   53: aload_1
    //   54: ldc 56
    //   56: aload_3
    //   57: invokevirtual 172	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_3
    //   61: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +92 -> 156
    //   67: aload_0
    //   68: getfield 114	bop:u	Ljava/util/Set;
    //   71: aload_3
    //   72: invokeinterface 184 2 0
    //   77: pop
    //   78: aload 4
    //   80: iconst_2
    //   81: invokeinterface 188 2 0
    //   86: astore_3
    //   87: aload_3
    //   88: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifne +14 -> 105
    //   94: aload_0
    //   95: getfield 114	bop:u	Ljava/util/Set;
    //   98: aload_3
    //   99: invokeinterface 184 2 0
    //   104: pop
    //   105: aload_2
    //   106: ifnull +10 -> 116
    //   109: aload_1
    //   110: ldc -66
    //   112: aload_2
    //   113: invokevirtual 172	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield 109	bop:s	Ljava/util/ArrayList;
    //   120: getstatic 193	com/android/emailcommon/provider/Mailbox:a	Landroid/net/Uri;
    //   123: aload 4
    //   125: iconst_0
    //   126: invokeinterface 197 2 0
    //   131: invokestatic 203	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   134: invokestatic 209	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   137: aload_1
    //   138: invokevirtual 215	android/content/ContentProviderOperation$Builder:withValues	(Landroid/content/ContentValues;)Landroid/content/ContentProviderOperation$Builder;
    //   141: invokevirtual 219	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   144: invokevirtual 220	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   147: pop
    //   148: aload 4
    //   150: invokeinterface 223 1 0
    //   155: return
    //   156: aload_1
    //   157: ldc 82
    //   159: ldc2_w 65
    //   162: invokestatic 86	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   165: invokevirtual 89	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   168: goto -90 -> 78
    //   171: astore_1
    //   172: aload 4
    //   174: invokeinterface 223 1 0
    //   179: aload_1
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	bop
    //   0	181	1	paramString1	String
    //   0	181	2	paramString2	String
    //   0	181	3	paramString3	String
    //   17	156	4	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   19	78	171	finally
    //   78	105	171	finally
    //   109	116	171	finally
    //   116	148	171	finally
    //   156	168	171	finally
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    boolean bool1 = false;
    int k;
    if (paramString2 != null)
    {
      localObject = b(paramString2);
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          boolean bool2 = ((Cursor)localObject).moveToFirst();
          if (!bool2) {
            continue;
          }
          j = 1;
          k = j;
          if (localObject != null)
          {
            ((Cursor)localObject).close();
            k = j;
          }
        }
        finally
        {
          if (localObject == null) {
            continue;
          }
          ((Cursor)localObject).close();
        }
        if (k == 0) {
          break label96;
        }
        a(paramString2, paramString1, paramString3);
        return;
        j = 0;
      }
    }
    label96:
    Object localObject = new ContentValues(10);
    ((ContentValues)localObject).put("displayName", paramString1);
    if (paramBoolean)
    {
      ((ContentValues)localObject).put("serverId", paramString2);
      if (paramString3.equals("0"))
      {
        paramString3 = q;
        ((ContentValues)localObject).put("parentKey", Long.valueOf(-1L));
        ((ContentValues)localObject).put("parentServerId", paramString3);
        label162:
        ((ContentValues)localObject).put("accountKey", Long.valueOf(f));
        ((ContentValues)localObject).put("type", Integer.valueOf(paramInt));
        if ((!paramBoolean) || (!Mailbox.S.get(paramInt))) {
          break label424;
        }
        j = 1;
        label207:
        if (j == 0) {
          break label430;
        }
        k = 1;
        label215:
        ((ContentValues)localObject).put("syncInterval", Integer.valueOf(k));
        if (j == 0) {
          break label436;
        }
        ((ContentValues)localObject).put("uiSyncStatus", Integer.valueOf(8));
        label244:
        if (paramInt > 64) {
          break label450;
        }
      }
    }
    label424:
    label430:
    label436:
    label450:
    for (int j = 72;; j = 0)
    {
      if ((paramInt != 1) && (paramInt != 6) && (paramInt != 7))
      {
        k = j;
        if (paramInt != 0) {}
      }
      else
      {
        k = j | 0x10;
      }
      ((ContentValues)localObject).put("flags", Integer.valueOf(k));
      paramBoolean = bool1;
      if (paramInt < 64) {
        paramBoolean = true;
      }
      ((ContentValues)localObject).put("flagVisible", Boolean.valueOf(paramBoolean));
      s.add(ContentProviderOperation.newInsert(Mailbox.a).withValues((ContentValues)localObject).build());
      x.put(paramInt, true);
      return;
      u.add(paramString3);
      break;
      ((ContentValues)localObject).put("serverId", "");
      ((ContentValues)localObject).put("parentKey", Long.valueOf(-1L));
      ((ContentValues)localObject).put("parentServerId", q);
      ((ContentValues)localObject).put("totalCount", Integer.valueOf(-1));
      break label162;
      j = 0;
      break label207;
      k = 0;
      break label215;
      ((ContentValues)localObject).put("uiSyncStatus", Integer.valueOf(0));
      break label244;
    }
  }
  
  private final Cursor b(String paramString)
  {
    r[0] = paramString;
    r[1] = g;
    return d.query(Mailbox.a, n, "serverId=? and accountKey=?", r, null);
  }
  
  private final void k()
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      r[1] = g;
      Iterator localIterator = h.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        boq localboq = (boq)h.get(str);
        localContentValues.put("syncInterval", Integer.valueOf(a));
        localContentValues.put("syncLookback", Integer.valueOf(b));
        r[0] = str;
        d.update(Mailbox.a, localContentValues, "serverId=? and accountKey=?", r);
      }
    }
    finally
    {
      h.clear();
    }
  }
  
  /* Error */
  private final void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: sipush 462
    //   4: invokevirtual 322	bop:b	(I)I
    //   7: iconst_3
    //   8: if_icmpeq +512 -> 520
    //   11: aload_0
    //   12: getfield 324	bop:l	I
    //   15: sipush 463
    //   18: if_icmpne +182 -> 200
    //   21: iconst_0
    //   22: istore_1
    //   23: aconst_null
    //   24: astore 6
    //   26: aconst_null
    //   27: astore 7
    //   29: aconst_null
    //   30: astore 5
    //   32: aload_0
    //   33: sipush 463
    //   36: invokevirtual 322	bop:b	(I)I
    //   39: iconst_3
    //   40: if_icmpeq +78 -> 118
    //   43: aload_0
    //   44: getfield 324	bop:l	I
    //   47: tableswitch	default:+29->76, 455:+36->83, 456:+62->109, 457:+53->100, 458:+45->92
    //   76: aload_0
    //   77: invokevirtual 326	bop:i	()V
    //   80: goto -48 -> 32
    //   83: aload_0
    //   84: invokevirtual 329	bop:g	()Ljava/lang/String;
    //   87: astore 5
    //   89: goto -57 -> 32
    //   92: aload_0
    //   93: invokevirtual 332	bop:h	()I
    //   96: istore_1
    //   97: goto -65 -> 32
    //   100: aload_0
    //   101: invokevirtual 329	bop:g	()Ljava/lang/String;
    //   104: astore 6
    //   106: goto -74 -> 32
    //   109: aload_0
    //   110: invokevirtual 329	bop:g	()Ljava/lang/String;
    //   113: astore 7
    //   115: goto -83 -> 32
    //   118: aload 5
    //   120: ifnull -120 -> 0
    //   123: aload 7
    //   125: ifnull -125 -> 0
    //   128: aload 6
    //   130: ifnull -130 -> 0
    //   133: getstatic 44	bop:i	Landroid/util/SparseIntArray;
    //   136: iload_1
    //   137: iconst_m1
    //   138: invokevirtual 335	android/util/SparseIntArray:get	(II)I
    //   141: istore_2
    //   142: iload_2
    //   143: iconst_m1
    //   144: if_icmpeq -144 -> 0
    //   147: aload 5
    //   149: astore 8
    //   151: iload_1
    //   152: bipush 8
    //   154: if_icmpne +31 -> 185
    //   157: aload 5
    //   159: astore 8
    //   161: aload 5
    //   163: aload_0
    //   164: getfield 136	bop:b	Lcom/android/emailcommon/provider/Account;
    //   167: getfield 337	com/android/emailcommon/provider/Account:d	Ljava/lang/String;
    //   170: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   173: ifne +12 -> 185
    //   176: aload_0
    //   177: getfield 136	bop:b	Lcom/android/emailcommon/provider/Account;
    //   180: getfield 337	com/android/emailcommon/provider/Account:d	Ljava/lang/String;
    //   183: astore 8
    //   185: aload_0
    //   186: aload 8
    //   188: aload 7
    //   190: aload 6
    //   192: iload_2
    //   193: iconst_1
    //   194: invokespecial 342	bop:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V
    //   197: goto -197 -> 0
    //   200: aload_0
    //   201: getfield 324	bop:l	I
    //   204: sipush 464
    //   207: if_icmpne +180 -> 387
    //   210: aload_0
    //   211: sipush 464
    //   214: invokevirtual 322	bop:b	(I)I
    //   217: iconst_3
    //   218: if_icmpeq -218 -> 0
    //   221: aload_0
    //   222: getfield 324	bop:l	I
    //   225: tableswitch	default:+19->244, 456:+26->251
    //   244: aload_0
    //   245: invokevirtual 326	bop:i	()V
    //   248: goto -38 -> 210
    //   251: aload_0
    //   252: invokevirtual 329	bop:g	()Ljava/lang/String;
    //   255: astore 6
    //   257: aload_0
    //   258: aload 6
    //   260: invokespecial 152	bop:b	(Ljava/lang/String;)Landroid/database/Cursor;
    //   263: astore 5
    //   265: aload 5
    //   267: invokeinterface 158 1 0
    //   272: ifeq +93 -> 365
    //   275: ldc -96
    //   277: ldc_w 344
    //   280: iconst_1
    //   281: anewarray 164	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: aload 6
    //   288: aastore
    //   289: invokestatic 169	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   292: pop
    //   293: aload 5
    //   295: iconst_0
    //   296: invokeinterface 197 2 0
    //   301: lstore_3
    //   302: aload_0
    //   303: getfield 109	bop:s	Ljava/util/ArrayList;
    //   306: getstatic 193	com/android/emailcommon/provider/Mailbox:a	Landroid/net/Uri;
    //   309: lload_3
    //   310: invokestatic 203	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   313: invokestatic 347	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   316: invokevirtual 219	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   319: invokevirtual 220	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   322: pop
    //   323: aload_0
    //   324: getfield 351	bop:c	Landroid/content/Context;
    //   327: aload_0
    //   328: getfield 143	bop:f	J
    //   331: lload_3
    //   332: invokestatic 356	bgt:c	(Landroid/content/Context;JJ)V
    //   335: aload 5
    //   337: iconst_2
    //   338: invokeinterface 188 2 0
    //   343: astore 6
    //   345: aload 6
    //   347: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   350: ifne +15 -> 365
    //   353: aload_0
    //   354: getfield 114	bop:u	Ljava/util/Set;
    //   357: aload 6
    //   359: invokeinterface 184 2 0
    //   364: pop
    //   365: aload 5
    //   367: invokeinterface 223 1 0
    //   372: goto -162 -> 210
    //   375: astore 6
    //   377: aload 5
    //   379: invokeinterface 223 1 0
    //   384: aload 6
    //   386: athrow
    //   387: aload_0
    //   388: getfield 324	bop:l	I
    //   391: sipush 465
    //   394: if_icmpne +101 -> 495
    //   397: aconst_null
    //   398: astore 7
    //   400: aconst_null
    //   401: astore 6
    //   403: aconst_null
    //   404: astore 5
    //   406: aload_0
    //   407: sipush 465
    //   410: invokevirtual 322	bop:b	(I)I
    //   413: iconst_3
    //   414: if_icmpeq +68 -> 482
    //   417: aload_0
    //   418: getfield 324	bop:l	I
    //   421: tableswitch	default:+27->448, 455:+43->464, 456:+34->455, 457:+52->473
    //   448: aload_0
    //   449: invokevirtual 326	bop:i	()V
    //   452: goto -46 -> 406
    //   455: aload_0
    //   456: invokevirtual 329	bop:g	()Ljava/lang/String;
    //   459: astore 5
    //   461: goto -55 -> 406
    //   464: aload_0
    //   465: invokevirtual 329	bop:g	()Ljava/lang/String;
    //   468: astore 6
    //   470: goto -64 -> 406
    //   473: aload_0
    //   474: invokevirtual 329	bop:g	()Ljava/lang/String;
    //   477: astore 7
    //   479: goto -73 -> 406
    //   482: aload_0
    //   483: aload 5
    //   485: aload 6
    //   487: aload 7
    //   489: invokespecial 226	bop:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   492: goto -492 -> 0
    //   495: aload_0
    //   496: getfield 324	bop:l	I
    //   499: sipush 471
    //   502: if_icmpne +11 -> 513
    //   505: aload_0
    //   506: invokevirtual 332	bop:h	()I
    //   509: pop
    //   510: goto -510 -> 0
    //   513: aload_0
    //   514: invokevirtual 326	bop:i	()V
    //   517: goto -517 -> 0
    //   520: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	this	bop
    //   22	133	1	j	int
    //   141	52	2	k	int
    //   301	31	3	l	long
    //   30	454	5	localObject1	Object
    //   24	334	6	str1	String
    //   375	10	6	localObject2	Object
    //   401	85	6	str2	String
    //   27	461	7	str3	String
    //   149	38	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   265	365	375	finally
  }
  
  private final void m()
  {
    if (s.isEmpty()) {
      return;
    }
    int j = s.size();
    ArrayList localArrayList = new ArrayList(j);
    while (!s.isEmpty())
    {
      localArrayList.clear();
      int k = j;
      if (j > s.size()) {
        k = s.size();
      }
      localArrayList.addAll(s.subList(0, k));
      try
      {
        d.applyBatch(bdv.F, localArrayList);
        s.removeAll(localArrayList);
        j = k;
      }
      catch (TransactionTooLargeException localTransactionTooLargeException)
      {
        if (k == 1)
        {
          cvm.e("FolderSyncParser", "Single operation transaction too large", new Object[0]);
          throw new IOException("Single operation transaction too large");
        }
        cvm.b("FolderSyncParser", "Transaction operation count %d too large, halving...", new Object[] { Integer.valueOf(k) });
        k /= 2;
        j = k;
        if (k <= 0) {
          j = 1;
        }
      }
      catch (RemoteException localRemoteException)
      {
        cvm.e("FolderSyncParser", "RemoteException in commit", new Object[0]);
        throw new IOException("RemoteException in commit");
      }
      catch (OperationApplicationException localOperationApplicationException)
      {
        cvm.e("FolderSyncParser", "OperationApplicationException in commit", new Object[0]);
        throw new IOException("OperationApplicationException in commit");
      }
    }
    s.clear();
  }
  
  private final void n()
  {
    if (u.isEmpty()) {}
    String[] arrayOfString;
    ContentValues localContentValues;
    Cursor localCursor;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        arrayOfString = new String[2];
        arrayOfString[1] = g;
        localContentValues = new ContentValues(1);
        localIterator = u.iterator();
      }
      arrayOfString[0] = ((String)localIterator.next());
      localCursor = d.query(Mailbox.a, o, "serverId=? and accountKey=?", arrayOfString, null);
    } while (localCursor == null);
    try
    {
      if (localCursor.moveToFirst())
      {
        l1 = localCursor.getLong(0);
        k = localCursor.getInt(1);
        localCursor.close();
        localCursor = d.query(Mailbox.a, p, "parentServerId=? and accountKey=?", arrayOfString, null);
        if (localCursor == null) {
          break label340;
        }
      }
    }
    finally
    {
      for (;;)
      {
        int k;
        try
        {
          long l1;
          localContentValues.clear();
          localContentValues.put("parentKey", Long.valueOf(l1));
          j = 0;
          if (localCursor.moveToNext())
          {
            long l2 = localCursor.getLong(0);
            s.add(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(Mailbox.a, l2)).withValues(localContentValues).build());
            j = 1;
            continue;
            localCursor.close();
            break;
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          localCursor.close();
          if (j != 0)
          {
            j = k | 0x3;
            if (j != k)
            {
              localContentValues.clear();
              localContentValues.put("flags", Integer.valueOf(j));
              s.add(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(Mailbox.a, l1)).withValues(localContentValues).build());
            }
            m();
            break;
          }
        }
        finally
        {
          localCursor.close();
        }
        int j = k & 0xFFFFFFFC;
        continue;
        label340:
        j = 0;
      }
    }
  }
  
  public final void a() {}
  
  public final void b() {}
  
  public final void c()
  {
    Object localObject1;
    if (v)
    {
      localObject1 = new ContentValues(1);
      ((ContentValues)localObject1).put("syncKey", b.e);
      s.add(ContentProviderOperation.newUpdate(b.g()).withValues((ContentValues)localObject1).build());
    }
    if (t)
    {
      localObject1 = Mailbox.T;
      int k = localObject1.length;
      int j = 0;
      while (j < k)
      {
        int m = localObject1[j];
        if (!x.get(m)) {
          a(Mailbox.a(m), null, null, m, false);
        }
        j += 1;
      }
    }
    m();
    n();
    r[0] = "Sync Issues";
    r[1] = g;
    Cursor localCursor = d.query(Mailbox.a, n, "displayName=? and accountKey=?", r, null);
    long l = 0L;
    for (;;)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          l = localCursor.getLong(0);
          localObject1 = localCursor.getString(1);
          localCursor.close();
          if (localObject1 != null)
          {
            d.delete(ContentUris.withAppendedId(Mailbox.a, l), null, null);
            r[0] = localObject1;
            d.delete(Mailbox.a, "parentServerId=? and accountKey=?", r);
          }
          if (t) {
            k();
          }
          return;
        }
      }
      finally
      {
        localCursor.close();
      }
      Object localObject3 = null;
    }
  }
  
  public final boolean d()
  {
    if ((b.e == null) || ("0".equals(b.e))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      t = bool1;
      if (t)
      {
        cvm.c("FolderSyncParser", "Initial sync, wiping data", new Object[0]);
        e();
      }
      if (b(0) == 470) {
        break;
      }
      throw new boy(this);
    }
    int k;
    int j;
    if ((k == 9) || (bnp.b(k)))
    {
      cvm.d("FolderSyncParser", "Invalid sync key, wiping data", new Object[0]);
      e();
      j = 1;
      bool1 = true;
    }
    for (;;)
    {
      label119:
      int m;
      if (b(0) != 1) {
        if (l == 460)
        {
          m = h();
          if (f <= 0L) {
            break label489;
          }
        }
      }
      label360:
      label421:
      label489:
      for (k = d.update(ContentUris.withAppendedId(bdv.N, f), y, null, null);; k = 0)
      {
        if (k > 0) {
          cvm.d("FolderSyncParser", "Duplicate mailboxes found for account %d: %d", new Object[] { Long.valueOf(f), Integer.valueOf(k) });
        }
        for (k = 9;; k = m)
        {
          buo.a().a("folder_sync", "folder_sync_status", String.valueOf(k), 0L);
          if (k == 1) {
            break label119;
          }
          if ((!bnp.c(k)) && (!bnp.a(k)) && (b.D != -1L)) {
            break;
          }
          cvm.e("FolderSyncParser", 39 + "FolderSync: Unknown status: " + k, new Object[0]);
          throw new bno(k);
          throw new boy(this, "Folder status error");
          if (l == 466)
          {
            String str = g();
            if ((str == null) || (j != 0)) {
              break label119;
            }
            boolean bool2;
            if (!str.equals(b.e))
            {
              bool2 = true;
              v = bool2;
              b.e = str;
              str = String.valueOf(str);
              if (str.length() == 0) {
                break label421;
              }
            }
            for (str = "New FolderSyncKey: ".concat(str);; str = new String("New FolderSyncKey: "))
            {
              cvm.b("FolderSyncParser", str, new Object[0]);
              break;
              bool2 = false;
              break label360;
            }
          }
          if (l == 462) {
            if (!w) {}
          }
          do
          {
            return bool1;
            l();
            break;
            i();
            break;
          } while (w);
          c();
          return bool1;
        }
      }
      j = 0;
      bool1 = false;
    }
  }
  
  protected final void e()
  {
    if (f == -1L) {
      return;
    }
    buo.a().a("exchange_sync", "wipe", "folder", 0L);
    bqu.a(c, b.d);
    bqw.a(c, b.d);
    h.clear();
    Object localObject1 = d.query(Mailbox.a, z, "accountKey=? AND (syncInterval!=? OR syncLookback!=?)", new String[] { g, Integer.toString(-1), Integer.toString(0) }, null);
    if (localObject1 != null) {
      try
      {
        while (((Cursor)localObject1).moveToNext())
        {
          int k = ((Cursor)localObject1).getInt(3);
          int j = k;
          if (k != 8) {
            j = 0;
          }
          h.put(((Cursor)localObject1).getString(0), new boq(((Cursor)localObject1).getInt(1), ((Cursor)localObject1).getInt(2), j));
        }
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
    }
    d.delete(Mailbox.a, "accountKey=?", new String[] { g });
    b.e = "0";
    localObject1 = new ContentValues();
    ((ContentValues)localObject1).put("syncKey", b.e);
    d.update(ContentUris.withAppendedId(Account.a, b.D), (ContentValues)localObject1, null, null);
  }
}

/* Location:
 * Qualified Name:     bop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */