import android.accounts.Account;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.mail.providers.Attachment;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.apache.http.message.BasicNameValuePair;

public final class dpa
{
  public static final String a = cvl.a;
  public static final Map<Long, String> g = new HashMap();
  private static final String[] h = { "filename", "status" };
  private static Random i = new Random(SystemClock.uptimeMillis());
  final Context b;
  public final SQLiteDatabase c;
  final dpe d;
  public final DownloadManager e;
  public final Set<Long> f;
  private final Account j;
  private final dvd k;
  private final drj l;
  private final ContentResolver m;
  private final ddy n;
  private long o;
  private final but p;
  private final nx<Long> q = new nx();
  
  public dpa(Context paramContext, Account paramAccount, SQLiteDatabase paramSQLiteDatabase, dvd paramdvd, dpe paramdpe, drj paramdrj)
  {
    b = paramContext;
    j = paramAccount;
    c = paramSQLiteDatabase;
    k = paramdvd;
    d = paramdpe;
    l = paramdrj;
    m = b.getContentResolver();
    e = ((DownloadManager)b.getSystemService("download"));
    n = new ddy(b);
    o = d(name);
    f = new HashSet();
    d.a(new dpb(this));
    d.h();
    p = buo.a();
  }
  
  private long a(long paramLong1, long paramLong2, GmailAttachment paramGmailAttachment, int paramInt1, long paramLong3, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    int i1 = 190;
    long l1 = paramLong3;
    if (r == 1)
    {
      l1 = paramLong3;
      if (paramLong3 == 0L) {
        l1 = -1L;
      }
      i1 = 200;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("messages_conversation", Long.valueOf(paramLong1));
    localContentValues.put("messages_messageId", Long.valueOf(paramLong2));
    localContentValues.put("desiredRendition", chi.a(paramInt1));
    localContentValues.put("downloadedRendition", chi.a(paramInt1));
    localContentValues.put("downloadId", Long.valueOf(l1));
    if (paramBoolean2)
    {
      paramInt1 = 1;
      localContentValues.put("automatic", Integer.valueOf(paramInt1));
      localContentValues.put("priority", Integer.valueOf(paramInt2));
      if (!paramBoolean1) {
        break label268;
      }
      paramInt1 = 1;
      label146:
      localContentValues.put("saveToSd", Integer.valueOf(paramInt1));
      localContentValues.put("status", Integer.valueOf(i1));
      localContentValues.put("messages_partId", b);
      localContentValues.put("originExtras", paramGmailAttachment.s());
      if (TextUtils.isEmpty(v)) {
        break label274;
      }
    }
    label268:
    label274:
    for (String str = v;; str = c)
    {
      localContentValues.put("filename", str);
      localContentValues.put("mimeType", paramGmailAttachment.l());
      localContentValues.put("size", Integer.valueOf(d));
      return c.insertWithOnConflict("attachments", null, localContentValues, 4);
      paramInt1 = 0;
      break;
      paramInt1 = 0;
      break label146;
    }
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("file://")) {
      str = paramString.substring(7);
    }
    return str;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    int i1 = paramString2.lastIndexOf('.');
    String str = "";
    Object localObject = paramString2;
    if (i1 != -1)
    {
      str = paramString2.substring(i1);
      localObject = paramString2.substring(0, i1);
    }
    paramString2 = (String)localObject;
    if (((String)localObject).indexOf(File.separatorChar) != -1) {
      paramString2 = ((String)localObject).replace(File.separatorChar, '_');
    }
    localObject = new File(paramString1);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    while (((File)localObject).isDirectory())
    {
      localObject = paramString1;
      if (!paramString1.endsWith(File.separator)) {
        localObject = paramString1.concat(File.separator);
      }
      paramString1 = String.valueOf(localObject).length() + 0 + String.valueOf(paramString2).length() + String.valueOf(str).length() + (String)localObject + paramString2 + str;
      if (new File(paramString1).exists()) {
        break;
      }
      return paramString1;
    }
    return null;
    int i2 = paramString2.lastIndexOf("-");
    if (i2 != -1) {}
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt(paramString2.substring(i2 + 1));
        i1 += 1;
        int i3;
        i1 = 1;
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          paramString1 = paramString2.substring(0, i2);
          paramString1 = String.valueOf(paramString1);
          paramString2 = String.valueOf("-");
          if (paramString2.length() != 0)
          {
            paramString1 = paramString1.concat(paramString2);
            i2 = 1;
            if (i2 >= 1000000000) {
              continue;
            }
            i3 = 0;
            if (i3 >= 9) {
              continue;
            }
            paramString2 = String.valueOf(localObject).length() + 11 + String.valueOf(paramString1).length() + String.valueOf(str).length() + (String)localObject + paramString1 + i1 + str;
            if (!new File(paramString2).exists()) {
              return paramString2;
            }
          }
          else
          {
            paramString1 = new String(paramString1);
            continue;
          }
          i1 += i.nextInt(i2) + 1;
          i3 += 1;
          continue;
          i2 *= 10;
          continue;
          return null;
          paramString1 = paramString1;
          i1 = 1;
          paramString1 = paramString2;
          continue;
        }
        catch (NumberFormatException paramString1)
        {
          paramString1 = paramString2;
          continue;
        }
      }
      paramString1 = paramString2;
    }
  }
  
  private final void a(long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      new File(a(paramString)).delete();
    }
    paramString = new ContentValues(2);
    paramString.put("status", Integer.valueOf(paramInt));
    paramString.put("downloadId", Integer.valueOf(-1));
    c.update("attachments", paramString, "_id=?", new String[] { String.valueOf(paramLong2) });
    a(paramLong1);
  }
  
  private final void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, String paramString2)
  {
    a(paramLong3, paramString1, paramInt1, paramInt2, paramString2);
    if (paramInt1 == 1)
    {
      if (paramBoolean) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        GmailProvider.a(j.name, paramLong2, paramLong3, paramString1, paramInt1, paramInt2, paramString2);
        return;
      }
    }
    dri.b(a, "Dropping download finished, as this is an thumbnail attachment. %d/%d/%d/%s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong1), paramString1 });
  }
  
  private void a(long paramLong1, long paramLong2, GmailAttachment paramGmailAttachment, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    dri.c(a, "AttachmentManager.cancelAttachmentDownload attachmentId=%d, oldFileUriOrName=%s, SD=%d, redownload=%b, error=%d", new Object[] { Long.valueOf(paramLong2), paramString, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    if ((Uri.parse(paramString).getAuthority() != null) && (new File(a(paramString)).exists())) {}
    for (int i1 = 1; paramBoolean; i1 = 0)
    {
      if ((paramGmailAttachment != null) && (g == paramInt1)) {
        paramGmailAttachment.a(5);
      }
      a(paramLong1, paramLong2, -1, null);
      return;
    }
    if (i1 != 0)
    {
      if ((paramGmailAttachment != null) && (g == paramInt1)) {
        paramGmailAttachment.a(3);
      }
      a(paramLong1, paramLong2, 200, null);
      return;
    }
    if ((paramGmailAttachment != null) && (g == paramInt1))
    {
      paramGmailAttachment.a(0);
      paramGmailAttachment.g(null);
    }
    a(paramLong1, paramLong2, paramInt2, paramString);
  }
  
  private final void a(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("downloadId", Integer.valueOf(-1));
    if (paramString2 != null) {
      localContentValues.put("filename", paramString2);
    }
    localContentValues.put("status", Integer.valueOf(paramInt2));
    c.update("attachments", localContentValues, "messages_messageId=? AND messages_partId=? AND desiredRendition=?", new String[] { String.valueOf(paramLong), paramString1, chi.a(paramInt1) });
  }
  
  private final void a(List<Long> paramList)
  {
    int i2 = paramList.size();
    if (i2 > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("_id");
      localStringBuilder.append(" IN (");
      int i1 = 0;
      while (i1 < i2)
      {
        if (i1 > 0) {
          localStringBuilder.append(',');
        }
        localStringBuilder.append(paramList.get(i1));
        i1 += 1;
      }
      localStringBuilder.append(')');
      c.delete("attachments", localStringBuilder.toString(), null);
    }
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 190;
  }
  
  private static void b(List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (str != null) {
        new File(a(str)).delete();
      }
    }
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt == 192;
  }
  
  private static boolean b(long paramLong)
  {
    return paramLong != -1L;
  }
  
  public static boolean b(String paramString)
  {
    return new File(a(paramString)).exists();
  }
  
  private static String c(long paramLong1, long paramLong2, String paramString, int paramInt, boolean paramBoolean)
  {
    String str1 = String.valueOf(chi.a(paramInt));
    String str2 = String.valueOf(String.valueOf(paramBoolean));
    return String.valueOf(paramString).length() + 104 + String.valueOf(str1).length() + String.valueOf(str2).length() + "conversationId: " + paramLong1 + ", messageId: " + paramLong2 + ", partId: " + paramString + ", rendition: " + str1 + ", saveToSd: " + str2;
  }
  
  private final String c(String paramString)
  {
    return b.getCacheDir().getAbsolutePath().concat(File.separator).concat(paramString);
  }
  
  public static boolean c(int paramInt)
  {
    return paramInt == 193;
  }
  
  private boolean c(long paramLong)
  {
    boolean bool = true;
    Object localObject1 = new DownloadManager.Query().setFilterById(new long[] { paramLong });
    localObject1 = e.query((DownloadManager.Query)localObject1);
    if (localObject1 == null)
    {
      dri.e(a, "null cursor from DownloadManager", new Object[0]);
      return false;
    }
    try
    {
      int i1 = ((Cursor)localObject1).getColumnIndex("status");
      if (((Cursor)localObject1).moveToNext())
      {
        i1 = ((Cursor)localObject1).getInt(i1);
        if (i1 == 4) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
      return false;
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
  }
  
  private final long d(String paramString)
  {
    long l1 = 0L;
    paramString = new File(c(paramString));
    long l2 = l1;
    if (paramString.listFiles() != null)
    {
      paramString = paramString.listFiles();
      int i2 = paramString.length;
      int i1 = 0;
      for (;;)
      {
        l2 = l1;
        if (i1 >= i2) {
          break;
        }
        l2 = paramString[i1].length();
        i1 += 1;
        l1 = l2 + l1;
      }
    }
    return l2;
  }
  
  public static boolean d(int paramInt)
  {
    return paramInt == 200;
  }
  
  public static boolean e(int paramInt)
  {
    return paramInt > 200;
  }
  
  private static boolean f(int paramInt)
  {
    return paramInt != -1;
  }
  
  public final ParcelFileDescriptor a(long paramLong1, long paramLong2, String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = c(paramLong1, paramLong2, paramString, paramInt, paramBoolean);
    dri.b(a, "AttachmentManager.openAttachment: %s", new Object[] { localObject1 });
    for (;;)
    {
      try
      {
        String[] arrayOfString = h;
        SQLiteDatabase localSQLiteDatabase = c;
        String str = chi.a(paramInt);
        if (!paramBoolean) {
          continue;
        }
        paramInt = 1;
        paramString = localSQLiteDatabase.query("attachments", arrayOfString, "messages_messageId=? AND messages_partId=? AND desiredRendition=? AND saveToSd=?", new String[] { String.valueOf(paramLong2), paramString, str, String.valueOf(paramInt) }, null, null, null);
        try
        {
          if (!paramString.moveToNext()) {
            continue;
          }
          if (d(paramString.getInt(1))) {
            continue;
          }
          throw new FileNotFoundException("Download not complete or not successful.");
        }
        finally
        {
          localObject1 = paramString;
          paramString = (String)localObject4;
        }
      }
      finally
      {
        Object localObject3 = null;
        continue;
      }
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      throw paramString;
      paramInt = 0;
    }
    localObject1 = a(paramString.getString(0));
    paramLong1 = Binder.clearCallingIdentity();
    try
    {
      dri.b(a, "AttachmentManager Opening attachment %s", new Object[] { localObject1 });
      localObject1 = ParcelFileDescriptor.open(new File((String)localObject1), 268435456);
      Binder.restoreCallingIdentity(paramLong1);
      if (paramString != null) {
        paramString.close();
      }
      return (ParcelFileDescriptor)localObject1;
    }
    finally
    {
      Binder.restoreCallingIdentity(paramLong1);
    }
    dri.e(a, "Attachment is not requested %s", new Object[] { localObject2 });
    throw new FileNotFoundException("Attachment not requested.");
  }
  
  final void a(long paramLong)
  {
    b.getContentResolver().notifyChange(dpy.a(j.name, paramLong), null, false);
    Object localObject1 = j.name;
    synchronized (GmailProvider.e)
    {
      localObject1 = (dvj)GmailProvider.e.get(localObject1);
      if (localObject1 == null) {}
    }
    synchronized (a)
    {
      localObject1 = (dvk)a.get(Long.valueOf(paramLong));
      if (localObject1 != null) {
        ((dvk)localObject1).b();
      }
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  /* Error */
  public final void a(long paramLong, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iload_3
    //   1: lookupswitch	default:+27->28, 8:+603->604, 16:+30->31
    //   28: iconst_0
    //   29: istore 4
    //   31: getstatic 579	dpd:a	[Ljava/lang/String;
    //   34: getstatic 579	dpd:a	[Ljava/lang/String;
    //   37: arraylength
    //   38: iconst_1
    //   39: iadd
    //   40: invokestatic 585	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   43: checkcast 586	[Ljava/lang/String;
    //   46: astore 18
    //   48: aload 18
    //   50: aload 18
    //   52: arraylength
    //   53: iconst_1
    //   54: isub
    //   55: ldc_w 588
    //   58: aastore
    //   59: aload_0
    //   60: getfield 90	dpa:c	Landroid/database/sqlite/SQLiteDatabase;
    //   63: ldc_w 590
    //   66: aload 18
    //   68: ldc_w 592
    //   71: iconst_1
    //   72: anewarray 50	java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: lload_1
    //   78: invokestatic 352	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   81: aastore
    //   82: aconst_null
    //   83: aconst_null
    //   84: ldc_w 594
    //   87: invokevirtual 517	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   90: astore 17
    //   92: aload 17
    //   94: invokeinterface 597 1 0
    //   99: ifne +46 -> 145
    //   102: getstatic 48	dpa:a	Ljava/lang/String;
    //   105: ldc_w 599
    //   108: iconst_1
    //   109: anewarray 4	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: lload_1
    //   115: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   118: aastore
    //   119: invokestatic 483	dri:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   122: pop
    //   123: aload_0
    //   124: getfield 114	dpa:e	Landroid/app/DownloadManager;
    //   127: ifnull +18 -> 145
    //   130: aload_0
    //   131: getfield 114	dpa:e	Landroid/app/DownloadManager;
    //   134: iconst_1
    //   135: newarray <illegal type>
    //   137: dup
    //   138: iconst_0
    //   139: lload_1
    //   140: lastore
    //   141: invokevirtual 603	android/app/DownloadManager:remove	([J)I
    //   144: pop
    //   145: aload 17
    //   147: invokeinterface 491 1 0
    //   152: ifeq +656 -> 808
    //   155: aload 17
    //   157: iconst_0
    //   158: invokeinterface 607 2 0
    //   163: lstore 9
    //   165: aload 17
    //   167: iconst_1
    //   168: invokeinterface 607 2 0
    //   173: lstore 7
    //   175: aload 17
    //   177: iconst_2
    //   178: invokeinterface 607 2 0
    //   183: lstore 11
    //   185: aload 17
    //   187: iconst_3
    //   188: invokeinterface 527 2 0
    //   193: astore 19
    //   195: aload 17
    //   197: iconst_4
    //   198: invokeinterface 527 2 0
    //   203: invokestatic 609	chi:a	(Ljava/lang/String;)I
    //   206: istore_3
    //   207: aload 17
    //   209: bipush 10
    //   211: invokeinterface 494 2 0
    //   216: ifeq +396 -> 612
    //   219: iconst_1
    //   220: istore 13
    //   222: lload 7
    //   224: lload 11
    //   226: aload 19
    //   228: iload_3
    //   229: iload 13
    //   231: invokestatic 508	dpa:c	(JJLjava/lang/String;IZ)Ljava/lang/String;
    //   234: astore 16
    //   236: aload_0
    //   237: getfield 96	dpa:l	Ldrj;
    //   240: invokestatic 614	dms:a	(Ldrj;)Z
    //   243: istore 15
    //   245: getstatic 48	dpa:a	Ljava/lang/String;
    //   248: ldc_w 616
    //   251: iconst_4
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: iload 4
    //   259: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   262: aastore
    //   263: dup
    //   264: iconst_1
    //   265: lload_1
    //   266: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: aastore
    //   270: dup
    //   271: iconst_2
    //   272: iload 15
    //   274: invokestatic 382	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   277: aastore
    //   278: dup
    //   279: iconst_3
    //   280: aload 16
    //   282: aastore
    //   283: invokestatic 374	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   286: pop
    //   287: aload_0
    //   288: getfield 155	dpa:p	Lbut;
    //   291: astore 16
    //   293: new 304	java/lang/StringBuilder
    //   296: dup
    //   297: bipush 18
    //   299: invokespecial 314	java/lang/StringBuilder:<init>	(I)V
    //   302: ldc_w 618
    //   305: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: iload 4
    //   310: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: astore 20
    //   318: iload 15
    //   320: invokestatic 620	dms:a	(Z)Ljava/lang/String;
    //   323: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   326: astore 21
    //   328: aload 16
    //   330: ldc_w 622
    //   333: ldc_w 624
    //   336: new 304	java/lang/StringBuilder
    //   339: dup
    //   340: aload 20
    //   342: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   345: invokevirtual 311	java/lang/String:length	()I
    //   348: iconst_1
    //   349: iadd
    //   350: aload 21
    //   352: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   355: invokevirtual 311	java/lang/String:length	()I
    //   358: iadd
    //   359: invokespecial 314	java/lang/StringBuilder:<init>	(I)V
    //   362: aload 20
    //   364: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc_w 626
    //   370: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 21
    //   375: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: lconst_0
    //   382: invokeinterface 631 6 0
    //   387: aload 17
    //   389: invokeinterface 634 1 0
    //   394: ifeq +399 -> 793
    //   397: aload 17
    //   399: bipush 9
    //   401: invokeinterface 527 2 0
    //   406: invokestatic 390	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   409: invokevirtual 637	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   412: astore 16
    //   414: aload 16
    //   416: ifnull +202 -> 618
    //   419: aload 17
    //   421: bipush 11
    //   423: invokeinterface 527 2 0
    //   428: astore 20
    //   430: aload 17
    //   432: bipush 12
    //   434: invokeinterface 494 2 0
    //   439: istore 5
    //   441: aload 17
    //   443: bipush 13
    //   445: invokeinterface 494 2 0
    //   450: istore 6
    //   452: aload 17
    //   454: aload 18
    //   456: arraylength
    //   457: iconst_1
    //   458: isub
    //   459: invokeinterface 527 2 0
    //   464: astore 21
    //   466: iload 4
    //   468: invokestatic 519	dpa:d	(I)Z
    //   471: ifeq +169 -> 640
    //   474: iload 5
    //   476: ifeq +150 -> 626
    //   479: iconst_1
    //   480: istore 14
    //   482: aload_0
    //   483: lload 9
    //   485: lload 7
    //   487: lload 11
    //   489: aload 19
    //   491: iload_3
    //   492: iload 13
    //   494: aload 16
    //   496: lload_1
    //   497: aconst_null
    //   498: aload 20
    //   500: aload 21
    //   502: iload 14
    //   504: iload 6
    //   506: invokevirtual 640	dpa:a	(JJJLjava/lang/String;IZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   509: aload_0
    //   510: getfield 84	dpa:q	Lnx;
    //   513: astore 16
    //   515: aload 16
    //   517: monitorenter
    //   518: aload_0
    //   519: getfield 84	dpa:q	Lnx;
    //   522: lload_1
    //   523: invokevirtual 643	nx:b	(J)I
    //   526: istore_3
    //   527: iload_3
    //   528: iflt +52 -> 580
    //   531: aload_0
    //   532: getfield 84	dpa:q	Lnx;
    //   535: iload_3
    //   536: invokevirtual 645	nx:c	(I)Ljava/lang/Object;
    //   539: checkcast 171	java/lang/Long
    //   542: invokevirtual 648	java/lang/Long:longValue	()J
    //   545: invokestatic 653	cwh:a	(J)J
    //   548: lstore 9
    //   550: aload_0
    //   551: getfield 155	dpa:p	Lbut;
    //   554: ldc_w 622
    //   557: lload 9
    //   559: ldc_w 624
    //   562: iload 15
    //   564: invokestatic 620	dms:a	(Z)Ljava/lang/String;
    //   567: invokeinterface 656 6 0
    //   572: aload_0
    //   573: getfield 84	dpa:q	Lnx;
    //   576: iload_3
    //   577: invokevirtual 657	nx:a	(I)V
    //   580: aload 16
    //   582: monitorexit
    //   583: aload_0
    //   584: lload 7
    //   586: invokevirtual 358	dpa:a	(J)V
    //   589: goto -444 -> 145
    //   592: astore 16
    //   594: aload 17
    //   596: invokeinterface 497 1 0
    //   601: aload 16
    //   603: athrow
    //   604: sipush 200
    //   607: istore 4
    //   609: goto -578 -> 31
    //   612: iconst_0
    //   613: istore 13
    //   615: goto -393 -> 222
    //   618: ldc_w 267
    //   621: astore 16
    //   623: goto -204 -> 419
    //   626: iconst_0
    //   627: istore 14
    //   629: goto -147 -> 482
    //   632: astore 18
    //   634: aload 16
    //   636: monitorexit
    //   637: aload 18
    //   639: athrow
    //   640: getstatic 48	dpa:a	Ljava/lang/String;
    //   643: ldc_w 659
    //   646: iconst_2
    //   647: anewarray 4	java/lang/Object
    //   650: dup
    //   651: iconst_0
    //   652: lload_1
    //   653: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   656: aastore
    //   657: dup
    //   658: iconst_1
    //   659: iload 4
    //   661: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   664: aastore
    //   665: invokestatic 483	dri:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   668: pop
    //   669: iload 15
    //   671: ifeq +101 -> 772
    //   674: sipush 401
    //   677: iload 4
    //   679: if_icmpeq +11 -> 690
    //   682: sipush 403
    //   685: iload 4
    //   687: if_icmpne +85 -> 772
    //   690: getstatic 48	dpa:a	Ljava/lang/String;
    //   693: ldc_w 661
    //   696: iconst_1
    //   697: anewarray 4	java/lang/Object
    //   700: dup
    //   701: iconst_0
    //   702: iload 4
    //   704: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   707: aastore
    //   708: invokestatic 384	dri:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   711: pop
    //   712: aload_0
    //   713: getfield 121	dpa:n	Lddy;
    //   716: aload_0
    //   717: getfield 88	dpa:j	Landroid/accounts/Account;
    //   720: aload_0
    //   721: getfield 86	dpa:b	Landroid/content/Context;
    //   724: invokestatic 664	dms:b	(Landroid/content/Context;)Ljava/lang/String;
    //   727: ldc_w 666
    //   730: invokevirtual 669	ddy:b	(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
    //   733: aload_0
    //   734: getfield 155	dpa:p	Lbut;
    //   737: ldc_w 622
    //   740: ldc_w 671
    //   743: new 304	java/lang/StringBuilder
    //   746: dup
    //   747: bipush 18
    //   749: invokespecial 314	java/lang/StringBuilder:<init>	(I)V
    //   752: ldc_w 618
    //   755: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: iload 4
    //   760: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   763: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: lconst_0
    //   767: invokeinterface 631 6 0
    //   772: aload_0
    //   773: lload 9
    //   775: lload 7
    //   777: lload 11
    //   779: aload 19
    //   781: iload_3
    //   782: iload 13
    //   784: iload 4
    //   786: aconst_null
    //   787: invokespecial 673	dpa:a	(JJJLjava/lang/String;IZILjava/lang/String;)V
    //   790: goto -207 -> 583
    //   793: aload_0
    //   794: lload 11
    //   796: aload 19
    //   798: iload_3
    //   799: iload 4
    //   801: aconst_null
    //   802: invokespecial 362	dpa:a	(JLjava/lang/String;IILjava/lang/String;)V
    //   805: goto -660 -> 145
    //   808: aload 17
    //   810: invokeinterface 497 1 0
    //   815: aload_0
    //   816: getfield 94	dpa:d	Ldpe;
    //   819: invokeinterface 148 1 0
    //   824: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	825	0	this	dpa
    //   0	825	1	paramLong	long
    //   0	825	3	paramInt1	int
    //   0	825	4	paramInt2	int
    //   439	36	5	i1	int
    //   450	55	6	i2	int
    //   173	603	7	l1	long
    //   163	611	9	l2	long
    //   183	612	11	l3	long
    //   220	563	13	bool1	boolean
    //   480	148	14	bool2	boolean
    //   243	427	15	bool3	boolean
    //   592	10	16	localObject2	Object
    //   621	14	16	str1	String
    //   90	719	17	localCursor	Cursor
    //   46	409	18	arrayOfString	String[]
    //   632	6	18	localObject3	Object
    //   193	604	19	str2	String
    //   316	183	20	str3	String
    //   326	175	21	str4	String
    // Exception table:
    //   from	to	target	type
    //   92	145	592	finally
    //   145	219	592	finally
    //   222	414	592	finally
    //   419	474	592	finally
    //   482	518	592	finally
    //   583	589	592	finally
    //   637	640	592	finally
    //   640	669	592	finally
    //   690	772	592	finally
    //   772	790	592	finally
    //   793	805	592	finally
    //   518	527	632	finally
    //   531	580	632	finally
    //   580	583	632	finally
    //   634	637	632	finally
  }
  
  /* Error */
  final void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt1, boolean paramBoolean1, String paramString2, long paramLong4, String paramString3, String paramString4, String paramString5, boolean paramBoolean2, int paramInt2)
  {
    // Byte code:
    //   0: iload 9
    //   2: ifeq +244 -> 246
    //   5: getstatic 684	android/os/Environment:DIRECTORY_DOWNLOADS	Ljava/lang/String;
    //   8: invokestatic 688	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   11: invokevirtual 468	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   14: astore 24
    //   16: aload 24
    //   18: aload 10
    //   20: invokestatic 690	dpa:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 27
    //   25: aconst_null
    //   26: astore 25
    //   28: aconst_null
    //   29: astore 24
    //   31: lload 11
    //   33: invokestatic 692	dpa:b	(J)Z
    //   36: ifeq +226 -> 262
    //   39: new 694	android/os/ParcelFileDescriptor$AutoCloseInputStream
    //   42: dup
    //   43: aload_0
    //   44: getfield 114	dpa:e	Landroid/app/DownloadManager;
    //   47: lload 11
    //   49: invokevirtual 698	android/app/DownloadManager:openDownloadedFile	(J)Landroid/os/ParcelFileDescriptor;
    //   52: invokespecial 701	android/os/ParcelFileDescriptor$AutoCloseInputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   55: astore 26
    //   57: aload 26
    //   59: astore 24
    //   61: new 703	java/io/FileOutputStream
    //   64: dup
    //   65: aload 27
    //   67: invokespecial 704	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   70: astore 26
    //   72: invokestatic 707	android/os/SystemClock:elapsedRealtime	()J
    //   75: lstore 20
    //   77: sipush 4096
    //   80: newarray <illegal type>
    //   82: astore 25
    //   84: iconst_0
    //   85: istore 18
    //   87: aload 24
    //   89: aload 25
    //   91: invokevirtual 713	java/io/InputStream:read	([B)I
    //   94: istore 19
    //   96: iload 19
    //   98: iconst_m1
    //   99: if_icmpeq +327 -> 426
    //   102: aload 26
    //   104: aload 25
    //   106: iconst_0
    //   107: iload 19
    //   109: invokevirtual 719	java/io/OutputStream:write	([BII)V
    //   112: iload 9
    //   114: ifne +19 -> 133
    //   117: aload_0
    //   118: getfield 131	dpa:o	J
    //   121: lstore 22
    //   123: aload_0
    //   124: iload 19
    //   126: i2l
    //   127: lload 22
    //   129: ladd
    //   130: putfield 131	dpa:o	J
    //   133: invokestatic 707	android/os/SystemClock:elapsedRealtime	()J
    //   136: lload 20
    //   138: lsub
    //   139: ldc2_w 720
    //   142: lcmp
    //   143: ifle +273 -> 416
    //   146: new 677	java/io/IOException
    //   149: dup
    //   150: ldc_w 723
    //   153: invokespecial 724	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   156: athrow
    //   157: astore 10
    //   159: getstatic 48	dpa:a	Ljava/lang/String;
    //   162: aload 10
    //   164: ldc_w 726
    //   167: iconst_1
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload 27
    //   175: aastore
    //   176: invokestatic 729	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   179: pop
    //   180: new 272	java/io/File
    //   183: dup
    //   184: aload 27
    //   186: invokespecial 286	java/io/File:<init>	(Ljava/lang/String;)V
    //   189: invokevirtual 346	java/io/File:delete	()Z
    //   192: pop
    //   193: aload_0
    //   194: lload_1
    //   195: lload_3
    //   196: lload 5
    //   198: aload 7
    //   200: iload 8
    //   202: iload 9
    //   204: sipush 1000
    //   207: aconst_null
    //   208: invokespecial 673	dpa:a	(JJJLjava/lang/String;IZILjava/lang/String;)V
    //   211: lload 11
    //   213: invokestatic 692	dpa:b	(J)Z
    //   216: ifeq +19 -> 235
    //   219: aload_0
    //   220: getfield 114	dpa:e	Landroid/app/DownloadManager;
    //   223: iconst_1
    //   224: newarray <illegal type>
    //   226: dup
    //   227: iconst_0
    //   228: lload 11
    //   230: lastore
    //   231: invokevirtual 603	android/app/DownloadManager:remove	([J)I
    //   234: pop
    //   235: aload 24
    //   237: invokevirtual 730	java/io/InputStream:close	()V
    //   240: aload 26
    //   242: invokevirtual 731	java/io/OutputStream:close	()V
    //   245: return
    //   246: aload_0
    //   247: aload_0
    //   248: getfield 88	dpa:j	Landroid/accounts/Account;
    //   251: getfield 126	android/accounts/Account:name	Ljava/lang/String;
    //   254: invokespecial 499	dpa:c	(Ljava/lang/String;)Ljava/lang/String;
    //   257: astore 24
    //   259: goto -243 -> 16
    //   262: new 733	java/io/FileInputStream
    //   265: dup
    //   266: aload 13
    //   268: invokestatic 343	dpa:a	(Ljava/lang/String;)Ljava/lang/String;
    //   271: invokespecial 734	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   274: astore 26
    //   276: aload 26
    //   278: astore 24
    //   280: goto -219 -> 61
    //   283: astore 10
    //   285: aload 24
    //   287: astore 14
    //   289: aload 14
    //   291: astore 10
    //   293: getstatic 48	dpa:a	Ljava/lang/String;
    //   296: ldc_w 736
    //   299: iconst_2
    //   300: anewarray 4	java/lang/Object
    //   303: dup
    //   304: iconst_0
    //   305: lload 11
    //   307: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   310: aastore
    //   311: dup
    //   312: iconst_1
    //   313: aload 13
    //   315: aastore
    //   316: invokestatic 483	dri:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   319: pop
    //   320: aload 14
    //   322: astore 10
    //   324: aload_0
    //   325: lload_1
    //   326: lload_3
    //   327: lload 5
    //   329: aload 7
    //   331: iload 8
    //   333: iload 9
    //   335: sipush 404
    //   338: aconst_null
    //   339: invokespecial 673	dpa:a	(JJJLjava/lang/String;IZILjava/lang/String;)V
    //   342: aload 14
    //   344: ifnull -99 -> 245
    //   347: aload 14
    //   349: invokevirtual 730	java/io/InputStream:close	()V
    //   352: return
    //   353: astore 7
    //   355: return
    //   356: astore 10
    //   358: aload 25
    //   360: astore 13
    //   362: aload 13
    //   364: astore 10
    //   366: getstatic 48	dpa:a	Ljava/lang/String;
    //   369: ldc_w 738
    //   372: iconst_0
    //   373: anewarray 4	java/lang/Object
    //   376: invokestatic 483	dri:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   379: pop
    //   380: aload 13
    //   382: astore 10
    //   384: aload_0
    //   385: lload_1
    //   386: lload_3
    //   387: lload 5
    //   389: aload 7
    //   391: iload 8
    //   393: iload 9
    //   395: sipush 200
    //   398: aconst_null
    //   399: invokespecial 673	dpa:a	(JJJLjava/lang/String;IZILjava/lang/String;)V
    //   402: aload 13
    //   404: ifnull -159 -> 245
    //   407: aload 13
    //   409: invokevirtual 730	java/io/InputStream:close	()V
    //   412: return
    //   413: astore 7
    //   415: return
    //   416: iload 18
    //   418: iload 19
    //   420: iadd
    //   421: istore 18
    //   423: goto -336 -> 87
    //   426: iload 18
    //   428: ifeq +21 -> 449
    //   431: iload 8
    //   433: iconst_1
    //   434: if_icmpne +283 -> 717
    //   437: iload 17
    //   439: ifeq +278 -> 717
    //   442: iload 18
    //   444: iload 17
    //   446: if_icmpeq +271 -> 717
    //   449: getstatic 48	dpa:a	Ljava/lang/String;
    //   452: ldc_w 740
    //   455: bipush 6
    //   457: anewarray 4	java/lang/Object
    //   460: dup
    //   461: iconst_0
    //   462: iload 18
    //   464: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   467: aastore
    //   468: dup
    //   469: iconst_1
    //   470: iload 17
    //   472: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   475: aastore
    //   476: dup
    //   477: iconst_2
    //   478: lload_1
    //   479: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   482: aastore
    //   483: dup
    //   484: iconst_3
    //   485: lload 11
    //   487: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   490: aastore
    //   491: dup
    //   492: iconst_4
    //   493: aload 13
    //   495: aastore
    //   496: dup
    //   497: iconst_5
    //   498: aload 27
    //   500: aastore
    //   501: invokestatic 374	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   504: pop
    //   505: aload_0
    //   506: lload_1
    //   507: lload_3
    //   508: lload 5
    //   510: aload 7
    //   512: iload 8
    //   514: iload 9
    //   516: sipush 404
    //   519: aconst_null
    //   520: invokespecial 673	dpa:a	(JJJLjava/lang/String;IZILjava/lang/String;)V
    //   523: aload_0
    //   524: getfield 88	dpa:j	Landroid/accounts/Account;
    //   527: getfield 126	android/accounts/Account:name	Ljava/lang/String;
    //   530: lload_3
    //   531: lload 5
    //   533: aload 7
    //   535: invokestatic 743	com/google/android/gm/provider/GmailProvider:a	(Ljava/lang/String;JJLjava/lang/String;)Lcom/google/android/gm/provider/uiprovider/GmailAttachment;
    //   538: astore 10
    //   540: iload 9
    //   542: ifeq +123 -> 665
    //   545: iconst_1
    //   546: istore 17
    //   548: aload_0
    //   549: lload_3
    //   550: lload_1
    //   551: aload 10
    //   553: aload 27
    //   555: iload 17
    //   557: iconst_0
    //   558: sipush 404
    //   561: invokespecial 745	dpa:a	(JJLcom/google/android/gm/provider/uiprovider/GmailAttachment;Ljava/lang/String;IZI)V
    //   564: iload 16
    //   566: ifeq +105 -> 671
    //   569: getstatic 48	dpa:a	Ljava/lang/String;
    //   572: ldc_w 747
    //   575: iconst_0
    //   576: anewarray 4	java/lang/Object
    //   579: invokestatic 374	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   582: pop
    //   583: new 166	android/content/ContentValues
    //   586: dup
    //   587: iconst_2
    //   588: invokespecial 347	android/content/ContentValues:<init>	(I)V
    //   591: astore 13
    //   593: aload 13
    //   595: ldc 52
    //   597: aload 10
    //   599: getfield 248	com/android/mail/providers/Attachment:c	Ljava/lang/String;
    //   602: invokevirtual 191	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   605: aload 13
    //   607: ldc -59
    //   609: iconst_0
    //   610: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   613: invokevirtual 205	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   616: aload_0
    //   617: getfield 90	dpa:c	Landroid/database/sqlite/SQLiteDatabase;
    //   620: ldc -18
    //   622: aload 13
    //   624: ldc_w 349
    //   627: iconst_1
    //   628: anewarray 50	java/lang/String
    //   631: dup
    //   632: iconst_0
    //   633: lload_1
    //   634: invokestatic 352	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   637: aastore
    //   638: invokevirtual 356	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   641: pop
    //   642: aload_0
    //   643: lload_1
    //   644: ldc2_w 163
    //   647: iconst_0
    //   648: invokevirtual 750	dpa:a	(JJZ)V
    //   651: aload 24
    //   653: invokevirtual 730	java/io/InputStream:close	()V
    //   656: aload 26
    //   658: invokevirtual 731	java/io/OutputStream:close	()V
    //   661: return
    //   662: astore 7
    //   664: return
    //   665: iconst_0
    //   666: istore 17
    //   668: goto -120 -> 548
    //   671: getstatic 48	dpa:a	Ljava/lang/String;
    //   674: ldc_w 752
    //   677: iconst_0
    //   678: anewarray 4	java/lang/Object
    //   681: invokestatic 374	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   684: pop
    //   685: goto -34 -> 651
    //   688: astore 7
    //   690: aload 26
    //   692: astore 10
    //   694: aload 24
    //   696: ifnull +8 -> 704
    //   699: aload 24
    //   701: invokevirtual 730	java/io/InputStream:close	()V
    //   704: aload 10
    //   706: ifnull +8 -> 714
    //   709: aload 10
    //   711: invokevirtual 731	java/io/OutputStream:close	()V
    //   714: aload 7
    //   716: athrow
    //   717: aload 27
    //   719: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   722: astore 13
    //   724: aload 13
    //   726: invokevirtual 311	java/lang/String:length	()I
    //   729: ifeq +143 -> 872
    //   732: ldc -5
    //   734: aload 13
    //   736: invokevirtual 302	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   739: astore 25
    //   741: aload_0
    //   742: lload_1
    //   743: lload_3
    //   744: lload 5
    //   746: aload 7
    //   748: iload 8
    //   750: iload 9
    //   752: sipush 200
    //   755: aload 25
    //   757: invokespecial 673	dpa:a	(JJJLjava/lang/String;IZILjava/lang/String;)V
    //   760: iload 9
    //   762: ifeq -551 -> 211
    //   765: aload_0
    //   766: getfield 86	dpa:b	Landroid/content/Context;
    //   769: getstatic 757	dge:by	I
    //   772: invokevirtual 758	android/content/Context:getString	(I)Ljava/lang/String;
    //   775: astore 13
    //   777: aload_0
    //   778: getfield 86	dpa:b	Landroid/content/Context;
    //   781: getstatic 761	dge:bz	I
    //   784: invokevirtual 758	android/content/Context:getString	(I)Ljava/lang/String;
    //   787: astore 28
    //   789: aload 15
    //   791: ifnonnull +95 -> 886
    //   794: aload 13
    //   796: astore 15
    //   798: aload 13
    //   800: ifnonnull +7 -> 807
    //   803: aload 10
    //   805: astore 15
    //   807: aload 10
    //   809: invokestatic 228	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   812: ifne +93 -> 905
    //   815: aload_0
    //   816: getfield 114	dpa:e	Landroid/app/DownloadManager;
    //   819: aload 10
    //   821: aload 15
    //   823: iconst_1
    //   824: aload 14
    //   826: aload 27
    //   828: iload 18
    //   830: i2l
    //   831: iload 9
    //   833: invokevirtual 765	android/app/DownloadManager:addCompletedDownload	(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JZ)J
    //   836: pop2
    //   837: new 767	android/content/Intent
    //   840: dup
    //   841: ldc_w 769
    //   844: invokespecial 770	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   847: astore 10
    //   849: aload 10
    //   851: aload 25
    //   853: invokestatic 390	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   856: invokevirtual 774	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   859: pop
    //   860: aload_0
    //   861: getfield 86	dpa:b	Landroid/content/Context;
    //   864: aload 10
    //   866: invokevirtual 778	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   869: goto -658 -> 211
    //   872: new 50	java/lang/String
    //   875: dup
    //   876: ldc -5
    //   878: invokespecial 337	java/lang/String:<init>	(Ljava/lang/String;)V
    //   881: astore 25
    //   883: goto -142 -> 741
    //   886: aload 28
    //   888: iconst_1
    //   889: anewarray 4	java/lang/Object
    //   892: dup
    //   893: iconst_0
    //   894: aload 15
    //   896: aastore
    //   897: invokestatic 782	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   900: astore 13
    //   902: goto -108 -> 794
    //   905: aload 27
    //   907: invokestatic 390	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   910: invokevirtual 637	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   913: astore 10
    //   915: goto -100 -> 815
    //   918: astore 10
    //   920: getstatic 48	dpa:a	Ljava/lang/String;
    //   923: aload 10
    //   925: ldc_w 784
    //   928: iconst_0
    //   929: anewarray 4	java/lang/Object
    //   932: invokestatic 729	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   935: pop
    //   936: goto -99 -> 837
    //   939: astore 7
    //   941: getstatic 48	dpa:a	Ljava/lang/String;
    //   944: ldc_w 738
    //   947: iconst_0
    //   948: anewarray 4	java/lang/Object
    //   951: invokestatic 483	dri:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   954: pop
    //   955: goto -720 -> 235
    //   958: astore 7
    //   960: goto -304 -> 656
    //   963: astore 7
    //   965: goto -725 -> 240
    //   968: astore 7
    //   970: return
    //   971: astore 13
    //   973: goto -269 -> 704
    //   976: astore 10
    //   978: goto -264 -> 714
    //   981: astore 7
    //   983: aconst_null
    //   984: astore 24
    //   986: aconst_null
    //   987: astore 10
    //   989: goto -295 -> 694
    //   992: astore 7
    //   994: aconst_null
    //   995: astore 10
    //   997: goto -303 -> 694
    //   1000: astore 7
    //   1002: aload 10
    //   1004: astore 24
    //   1006: aconst_null
    //   1007: astore 10
    //   1009: goto -315 -> 694
    //   1012: astore 10
    //   1014: aload 24
    //   1016: astore 13
    //   1018: goto -656 -> 362
    //   1021: astore 10
    //   1023: aload 24
    //   1025: astore 14
    //   1027: goto -738 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1030	0	this	dpa
    //   0	1030	1	paramLong1	long
    //   0	1030	3	paramLong2	long
    //   0	1030	5	paramLong3	long
    //   0	1030	7	paramString1	String
    //   0	1030	8	paramInt1	int
    //   0	1030	9	paramBoolean1	boolean
    //   0	1030	10	paramString2	String
    //   0	1030	11	paramLong4	long
    //   0	1030	13	paramString3	String
    //   0	1030	14	paramString4	String
    //   0	1030	15	paramString5	String
    //   0	1030	16	paramBoolean2	boolean
    //   0	1030	17	paramInt2	int
    //   85	744	18	i1	int
    //   94	327	19	i2	int
    //   75	62	20	l1	long
    //   121	7	22	l2	long
    //   14	1010	24	localObject1	Object
    //   26	856	25	localObject2	Object
    //   55	636	26	localObject3	Object
    //   23	883	27	str1	String
    //   787	100	28	str2	String
    // Exception table:
    //   from	to	target	type
    //   72	84	157	java/io/IOException
    //   87	96	157	java/io/IOException
    //   102	112	157	java/io/IOException
    //   117	133	157	java/io/IOException
    //   133	157	157	java/io/IOException
    //   449	540	157	java/io/IOException
    //   548	564	157	java/io/IOException
    //   569	651	157	java/io/IOException
    //   671	685	157	java/io/IOException
    //   717	741	157	java/io/IOException
    //   741	760	157	java/io/IOException
    //   765	789	157	java/io/IOException
    //   807	815	157	java/io/IOException
    //   815	837	157	java/io/IOException
    //   837	869	157	java/io/IOException
    //   872	883	157	java/io/IOException
    //   886	902	157	java/io/IOException
    //   905	915	157	java/io/IOException
    //   920	936	157	java/io/IOException
    //   31	57	283	java/io/FileNotFoundException
    //   262	276	283	java/io/FileNotFoundException
    //   347	352	353	java/io/IOException
    //   31	57	356	java/lang/NullPointerException
    //   262	276	356	java/lang/NullPointerException
    //   407	412	413	java/io/IOException
    //   656	661	662	java/io/IOException
    //   72	84	688	finally
    //   87	96	688	finally
    //   102	112	688	finally
    //   117	133	688	finally
    //   133	157	688	finally
    //   159	211	688	finally
    //   211	235	688	finally
    //   449	540	688	finally
    //   548	564	688	finally
    //   569	651	688	finally
    //   671	685	688	finally
    //   717	741	688	finally
    //   741	760	688	finally
    //   765	789	688	finally
    //   807	815	688	finally
    //   815	837	688	finally
    //   837	869	688	finally
    //   872	883	688	finally
    //   886	902	688	finally
    //   905	915	688	finally
    //   920	936	688	finally
    //   941	955	688	finally
    //   807	815	918	java/lang/IllegalArgumentException
    //   815	837	918	java/lang/IllegalArgumentException
    //   905	915	918	java/lang/IllegalArgumentException
    //   211	235	939	java/lang/NullPointerException
    //   651	656	958	java/io/IOException
    //   235	240	963	java/io/IOException
    //   240	245	968	java/io/IOException
    //   699	704	971	java/io/IOException
    //   709	714	976	java/io/IOException
    //   31	57	981	finally
    //   262	276	981	finally
    //   61	72	992	finally
    //   293	320	1000	finally
    //   324	342	1000	finally
    //   366	380	1000	finally
    //   384	402	1000	finally
    //   61	72	1012	java/lang/NullPointerException
    //   61	72	1021	java/io/FileNotFoundException
  }
  
  public final void a(long paramLong1, long paramLong2, GmailAttachment paramGmailAttachment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (dri.a(a, 3))
    {
      localObject1 = c(paramLong1, paramLong2, b, paramInt1, paramBoolean);
      dri.b(a, "queryAndStartDownloadingAttachment for %s", new Object[] { localObject1 });
    }
    Object localObject2 = c.query("attachments", dpd.a, "messages_messageId=? AND messages_partId=? AND desiredRendition=? ", new String[] { String.valueOf(paramLong2), b, chi.a(paramInt1) }, null, null, null);
    Object localObject1 = new Long[2];
    localObject1[0] = Long.valueOf(-1L);
    localObject1[1] = Long.valueOf(-1L);
    long[] arrayOfLong = new long[2];
    long[] tmp125_123 = arrayOfLong;
    tmp125_123[0] = -1L;
    long[] tmp131_125 = tmp125_123;
    tmp131_125[1] = -1L;
    tmp131_125;
    int[] arrayOfInt = new int[2];
    int[] tmp145_143 = arrayOfInt;
    tmp145_143[0] = -1;
    int[] tmp149_145 = tmp145_143;
    tmp149_145[1] = -1;
    tmp149_145;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = null;
    arrayOfString[1] = null;
    int i1;
    try
    {
      while (((Cursor)localObject2).moveToNext())
      {
        i1 = ((Cursor)localObject2).getInt(10);
        localObject1[i1] = Long.valueOf(((Cursor)localObject2).getLong(0));
        arrayOfLong[i1] = ((Cursor)localObject2).getLong(7);
        arrayOfInt[i1] = ((Cursor)localObject2).getInt(8);
        arrayOfString[i1] = ((Cursor)localObject2).getString(9);
      }
      i1 = 0;
    }
    finally
    {
      ((Cursor)localObject2).close();
    }
    while (i1 < 2)
    {
      if ((!d(arrayOfInt[i1])) || (!b(arrayOfString[i1]))) {
        arrayOfString[i1] = null;
      }
      i1 += 1;
    }
    int i2;
    if (paramBoolean)
    {
      i1 = 1;
      i2 = 0;
      label328:
      if (i2 > i1) {
        break label405;
      }
      if (localObject1[i2].longValue() == -1L) {
        if (i2 == 0) {
          break label399;
        }
      }
    }
    label399:
    for (boolean bool = true;; bool = false)
    {
      localObject1[i2] = Long.valueOf(a(paramLong1, paramLong2, paramGmailAttachment, paramInt1, -1L, bool, false, paramInt2));
      i2 += 1;
      break label328;
      i1 = 0;
      break;
    }
    label405:
    if ((!f(arrayOfInt[0])) && (!f(arrayOfInt[1]))) {
      dri.b(a, "AttachmentManager.queryAndStartDownloadingAttachment() starting new download", new Object[0]);
    }
    for (;;)
    {
      a(localObject1[0].longValue(), localObject1[1].longValue(), false);
      do
      {
        a(paramLong1);
        do
        {
          return;
          if ((arrayOfString[0] == null) && (arrayOfString[1] == null)) {
            break;
          }
          dri.b(a, "AttachmentManager.queryAndStartDownloadingAttachment() file exists either on cache or sd card, will copy if needed", new Object[0]);
        } while (arrayOfString[i1] != null);
        d.a(new dpc(this, (Long[])localObject1, i1, paramLong1, paramLong2, paramGmailAttachment, paramInt1, paramBoolean, arrayOfString));
        return;
        if (!b(arrayOfInt[i1])) {
          break;
        }
        dri.b(a, "AttachmentManager.queryAndStartDownloadingAttachment() download already running", new Object[0]);
      } while (!c(arrayOfLong[i1]));
      dri.b(a, "AttachmentManager.queryAndStartDownloadingAttachment() download was paused. Forcing it to start.", new Object[0]);
      e.remove(new long[] { arrayOfLong[i1] });
      paramLong2 = localObject1[i1].longValue();
      localObject2 = c;
      if (paramBoolean) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        a(paramLong1, paramLong2, paramGmailAttachment, (String)localObject2, paramInt1, false, -1);
        a(localObject1[0].longValue(), localObject1[1].longValue(), false);
        break;
      }
      dri.b(a, "AttachmentManager.queryAndStartDownloadingAttachment() refetch attachment", new Object[0]);
      paramInt1 = 0;
      while (paramInt1 <= i1)
      {
        localObject2 = new ContentValues();
        ((ContentValues)localObject2).put("filename", c);
        ((ContentValues)localObject2).put("automatic", Integer.valueOf(0));
        c.update("attachments", (ContentValues)localObject2, "_id=?", new String[] { String.valueOf(localObject1[paramInt1]) });
        paramInt1 += 1;
      }
    }
  }
  
  public final void a(long paramLong1, long paramLong2, GmailAttachment paramGmailAttachment, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    long l1 = a(paramLong1, paramLong2, paramGmailAttachment, paramInt1, 0L, paramBoolean1, paramBoolean2, paramInt2);
    if (dri.a(a, 3))
    {
      paramGmailAttachment = c(paramLong1, paramLong2, b, paramInt1, paramBoolean1);
      dri.b(a, "enqueueAttachment attachmentId: %d: %s", new Object[] { Long.valueOf(l1), paramGmailAttachment });
    }
    for (;;)
    {
      a(paramLong1);
      return;
      dri.c(a, "enqueueAttachment attachmentId: %d", new Object[] { Long.valueOf(l1) });
    }
  }
  
  final void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (c.isDbLockedByCurrentThread()) {
      dri.f(a, "SQLiteDatabase lock held before calling startAttachmentDownloadInDownloadManager", new Object[0]);
    }
    Cursor localCursor = c.query("attachments", dpd.a, "_id=?", new String[] { String.valueOf(paramLong1) }, null, null, null);
    for (;;)
    {
      long l1;
      String str4;
      int i1;
      String str2;
      Object localObject6;
      String str5;
      int i2;
      Object localObject7;
      try
      {
        if (!localCursor.moveToNext())
        {
          dri.e(a, "Cannot find attachment %d", new Object[] { Long.valueOf(paramLong1) });
          return;
        }
        Object localObject1 = new GmailAttachment();
        p = localCursor.getLong(1);
        q = localCursor.getLong(2);
        b = localCursor.getString(3);
        ((GmailAttachment)localObject1).f(localCursor.getString(5));
        long l2 = p;
        l1 = q;
        str4 = b;
        i1 = chi.a(localCursor.getString(6));
        int i3 = localCursor.getInt(10);
        str2 = localCursor.getString(9);
        localObject6 = Uri.parse(str2).getLastPathSegment();
        localObject1 = localCursor.getString(11);
        int i4;
        int i5;
        if (i3 == 1)
        {
          bool = true;
          str5 = c(l2, l1, str4, i1, bool);
          if (i1 != 0)
          {
            i1 = 1;
            if ((i1 != 0) || (!GmailAttachment.a(m, (String)localObject1))) {
              continue;
            }
            i2 = 1;
            i4 = ghz.a(m, "gmail_max_attachment_thumbnail_width", 640);
            i5 = ghz.a(m, "gmail_max_attachment_thumbnail_height", 256);
            if (i2 == 0) {
              continue;
            }
            localObject1 = k;
            i1 = d.g();
            localObject7 = new LinkedList();
            dvd.a(i1, (List)localObject7);
            ((List)localObject7).add(new BasicNameValuePair("view", "snatt"));
            ((List)localObject7).add(new BasicNameValuePair("disp", "thd"));
            ((List)localObject7).add(new BasicNameValuePair("th", Long.toHexString(l1)));
            ((List)localObject7).add(new BasicNameValuePair("attid", str4));
            ((List)localObject7).add(new BasicNameValuePair("stw", Integer.toString(i4)));
            ((List)localObject7).add(new BasicNameValuePair("sth", Integer.toString(i5)));
            localObject1 = ((dvd)localObject1).a((List)localObject7);
            localObject7 = ((URI)localObject1).toString();
            localObject8 = m;
            localObject7 = ddx.a.a((ContentResolver)localObject8).a((String)localObject7).apply((String)localObject7);
            if (localObject7 != null) {
              continue;
            }
            dri.d(a, "Abandon download of %s because it is blocked by rules.", new Object[] { localObject1 });
            localObject1 = new ContentValues();
            ((ContentValues)localObject1).put("status", Integer.valueOf(1000));
            c.update("attachments", (ContentValues)localObject1, "_id=? OR _id=?", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) });
            a(l2);
          }
        }
        else
        {
          bool = false;
          continue;
        }
        i1 = 0;
        continue;
        i2 = 0;
        continue;
        localObject7 = k;
        int i6 = d.g();
        Object localObject8 = new LinkedList();
        dvd.a(i6, (List)localObject8);
        ((List)localObject8).add(new BasicNameValuePair("view", "att"));
        ((List)localObject8).add(new BasicNameValuePair("messageId", String.valueOf(l1)));
        ((List)localObject8).add(new BasicNameValuePair("partId", str4));
        ((List)localObject8).add(new BasicNameValuePair("maxWidth", Integer.toString(i4)));
        ((List)localObject8).add(new BasicNameValuePair("maxHeight", Integer.toString(i5)));
        if (i1 == 0) {
          break label1593;
        }
        localObject1 = "1";
        ((List)localObject8).add(new BasicNameValuePair("showOriginal", (String)localObject1));
        localObject1 = ((dvd)localObject7).a((List)localObject8);
        continue;
        if (!ctr.a(b, null))
        {
          dri.d(a, "Abandon download of %s because there is no network connection.", new Object[] { localObject1 });
          localObject1 = GmailProvider.a(j.name, l2, l1, str4);
          if (paramLong2 != -1L) {
            a(l2, paramLong2, (GmailAttachment)localObject1, str2, i3, false, 1000);
          }
          a(l2, paramLong1, (GmailAttachment)localObject1, str2, i3, false, 1000);
          Toast.makeText(b, dge.bx, 0).show();
          continue;
        }
        localObject6 = new DownloadManager.Request(Uri.parse((String)localObject7)).setTitle((CharSequence)localObject6).setVisibleInDownloadsUi(false);
      }
      finally
      {
        localCursor.close();
      }
      ??? = null;
      boolean bool = dms.a(l);
      if (bool) {}
      for (;;)
      {
        try
        {
          str4 = n.a(j, dms.b(b), "AttachmentManager");
          ??? = str4;
          ((DownloadManager.Request)localObject6).addRequestHeader("Authorization", cwh.a(str4));
          ??? = str4;
          localObject7 = ddy.a(d.i());
          str2 = str4;
          ??? = str4;
          if (!((String)localObject7).isEmpty())
          {
            ??? = str4;
            ((DownloadManager.Request)localObject6).addRequestHeader("Cookie", (String)localObject7);
            str2 = str4;
          }
        }
        catch (Exception localException2)
        {
          dri.d(a, localException2, "Exception while getting authToken(%b)", new Object[] { Boolean.valueOf(bool) });
          Object localObject4 = ???;
          continue;
          if (paramLong2 != -1L) {
            continue;
          }
          ((DownloadManager.Request)localObject6).setNotificationVisibility(2);
          if (!paramBoolean) {
            break label1315;
          }
          ((DownloadManager.Request)localObject6).setAllowedNetworkTypes(2);
        }
        if (str2 != null) {
          continue;
        }
        dri.e(a, "Authentication(%b) failed for attachment %d, %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong1), str5 });
        localCursor.close();
        return;
        str4 = n.a(j, "mail", "AttachmentManager");
        ??? = str4;
        ((DownloadManager.Request)localObject6).addRequestHeader("Cookie", ddy.a(str4));
        str2 = str4;
        if (i2 != 0) {
          try
          {
            ((DownloadManager.Request)localObject6).addRequestHeader("Authorization", cwh.a(n.a(j, ghz.a(m, "gmail_senna_dev_code", "oauth2:https://www.googleapis.com/auth/gmail.readonly"), "AttachmentManagerSenna")));
            str2 = str4;
          }
          catch (Exception localException1)
          {
            ??? = str4;
            dri.e(a, localException1, "OAuth failed for senna attachment %d, %s", new Object[] { Long.valueOf(paramLong1), str5 });
            String str3 = str4;
          }
        }
      }
      try
      {
        label1315:
        l1 = e.enqueue((DownloadManager.Request)localObject6);
        i1 = 1;
        if (i1 == 0) {
          continue;
        }
        g.put(Long.valueOf(l1), j.name);
        synchronized (q)
        {
          q.b(l1, Long.valueOf(chq.b()));
          ??? = new ContentValues();
          ((ContentValues)???).put("downloadId", Long.valueOf(l1));
          ((ContentValues)???).put("status", Integer.valueOf(192));
          c.update("attachments", (ContentValues)???, "_id=? OR _id=?", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) });
          dri.c(a, "AttachmentManager: start downloading attachment %d dlid=%d, %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(l1), str5 });
          continue;
          dri.e(a, (Throwable)???, "Attachment: DownloadManager error downloading attachment %d, %s", new Object[] { Long.valueOf(paramLong1), str5 });
          ??? = new ContentValues();
          ((ContentValues)???).put("status", Integer.valueOf(404));
          c.update("attachments", (ContentValues)???, "_id=? OR _id=?", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) });
          i1 = 0;
          l1 = -1L;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;) {}
        String str1 = "0";
      }
      catch (NullPointerException localNullPointerException)
      {
        label1593:
        for (;;) {}
      }
    }
  }
  
  final boolean a()
  {
    File localFile = b.getCacheDir();
    if (localFile == null) {}
    for (;;)
    {
      return true;
      long l1 = localFile.getTotalSpace();
      long l2 = localFile.getUsableSpace();
      try
      {
        int i1 = ctl.c(b);
        long l3 = ((float)l1 * 0.25F / i1);
        if (o >= l3)
        {
          o = 0L;
          o = d(j.name);
        }
        if (((float)l2 >= (float)l1 * 0.25F) || (o < l3)) {
          return false;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        dri.e(a, "This maybe called from tests where we don't have Account Manager.", new Object[0]);
      }
    }
    return false;
  }
  
  /* Error */
  public final int b(long paramLong1, long paramLong2, String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 88	dpa:j	Landroid/accounts/Account;
    //   4: getfield 126	android/accounts/Account:name	Ljava/lang/String;
    //   7: lload_1
    //   8: lload_3
    //   9: aload 5
    //   11: invokestatic 743	com/google/android/gm/provider/GmailProvider:a	(Ljava/lang/String;JJLjava/lang/String;)Lcom/google/android/gm/provider/uiprovider/GmailAttachment;
    //   14: astore 11
    //   16: getstatic 48	dpa:a	Ljava/lang/String;
    //   19: astore 12
    //   21: aload 11
    //   23: ifnull +222 -> 245
    //   26: aload 11
    //   28: getfield 395	com/google/android/gm/provider/uiprovider/GmailAttachment:g	I
    //   31: iconst_1
    //   32: if_icmpne +213 -> 245
    //   35: iconst_1
    //   36: istore 10
    //   38: aload 12
    //   40: ldc_w 1051
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: lload_1
    //   50: lload_3
    //   51: aload 5
    //   53: iload 6
    //   55: iload 10
    //   57: invokestatic 508	dpa:c	(JJLjava/lang/String;IZ)Ljava/lang/String;
    //   60: aastore
    //   61: invokestatic 384	dri:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   64: pop
    //   65: aload_0
    //   66: getfield 90	dpa:c	Landroid/database/sqlite/SQLiteDatabase;
    //   69: astore 12
    //   71: iload 6
    //   73: invokestatic 188	chi:a	(I)Ljava/lang/String;
    //   76: astore 13
    //   78: aload 12
    //   80: ldc -18
    //   82: iconst_4
    //   83: anewarray 50	java/lang/String
    //   86: dup
    //   87: iconst_0
    //   88: ldc_w 411
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: ldc -61
    //   96: aastore
    //   97: dup
    //   98: iconst_2
    //   99: ldc 52
    //   101: aastore
    //   102: dup
    //   103: iconst_3
    //   104: ldc -47
    //   106: aastore
    //   107: ldc_w 403
    //   110: iconst_3
    //   111: anewarray 50	java/lang/String
    //   114: dup
    //   115: iconst_0
    //   116: lload_3
    //   117: invokestatic 352	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: aload 5
    //   125: aastore
    //   126: dup
    //   127: iconst_2
    //   128: aload 13
    //   130: aastore
    //   131: aconst_null
    //   132: aconst_null
    //   133: ldc_w 594
    //   136: invokevirtual 517	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   139: astore 5
    //   141: iconst_0
    //   142: istore 6
    //   144: aload 5
    //   146: invokeinterface 491 1 0
    //   151: ifeq +100 -> 251
    //   154: aload 5
    //   156: iconst_0
    //   157: invokeinterface 607 2 0
    //   162: lstore_3
    //   163: aload 5
    //   165: iconst_1
    //   166: invokeinterface 607 2 0
    //   171: lstore 8
    //   173: aload 5
    //   175: iconst_2
    //   176: invokeinterface 527 2 0
    //   181: astore 12
    //   183: aload 5
    //   185: iconst_3
    //   186: invokeinterface 494 2 0
    //   191: istore 6
    //   193: aload_0
    //   194: getfield 114	dpa:e	Landroid/app/DownloadManager;
    //   197: ifnull +27 -> 224
    //   200: lload 8
    //   202: invokestatic 692	dpa:b	(J)Z
    //   205: ifeq +19 -> 224
    //   208: aload_0
    //   209: getfield 114	dpa:e	Landroid/app/DownloadManager;
    //   212: iconst_1
    //   213: newarray <illegal type>
    //   215: dup
    //   216: iconst_0
    //   217: lload 8
    //   219: lastore
    //   220: invokevirtual 603	android/app/DownloadManager:remove	([J)I
    //   223: pop
    //   224: aload_0
    //   225: lload_1
    //   226: lload_3
    //   227: aload 11
    //   229: aload 12
    //   231: iload 6
    //   233: iload 7
    //   235: iconst_m1
    //   236: invokespecial 745	dpa:a	(JJLcom/google/android/gm/provider/uiprovider/GmailAttachment;Ljava/lang/String;IZI)V
    //   239: iconst_1
    //   240: istore 6
    //   242: goto -98 -> 144
    //   245: iconst_0
    //   246: istore 10
    //   248: goto -210 -> 38
    //   251: iload 6
    //   253: ifeq +16 -> 269
    //   256: iconst_1
    //   257: istore 6
    //   259: aload 5
    //   261: invokeinterface 497 1 0
    //   266: iload 6
    //   268: ireturn
    //   269: iconst_0
    //   270: istore 6
    //   272: goto -13 -> 259
    //   275: astore 11
    //   277: aload 5
    //   279: invokeinterface 497 1 0
    //   284: aload 11
    //   286: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	dpa
    //   0	287	1	paramLong1	long
    //   0	287	3	paramLong2	long
    //   0	287	5	paramString	String
    //   0	287	6	paramInt	int
    //   0	287	7	paramBoolean	boolean
    //   171	47	8	l1	long
    //   36	211	10	bool	boolean
    //   14	214	11	localGmailAttachment	GmailAttachment
    //   275	10	11	localObject1	Object
    //   19	211	12	localObject2	Object
    //   76	53	13	str	String
    // Exception table:
    //   from	to	target	type
    //   144	224	275	finally
    //   224	239	275	finally
  }
  
  final void b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Cursor localCursor = c.query("attachments", dpd.a, "status NOT IN (?, ?, ?, ?)", new String[] { "190", "192", "193", "200" }, null, null, null);
    for (;;)
    {
      try
      {
        if (!localCursor.moveToNext()) {
          break;
        }
        long l1 = localCursor.getLong(0);
        String str = localCursor.getString(9);
        int i1;
        if (localCursor.getInt(10) != 0)
        {
          i1 = 1;
          localArrayList1.add(Long.valueOf(l1));
          if (i1 != 0) {
            str = null;
          }
          localArrayList2.add(str);
        }
        else
        {
          i1 = 0;
        }
      }
      finally
      {
        localCursor.close();
      }
    }
    localCursor.close();
    b(localArrayList2);
    a(localArrayList1);
  }
  
  /* Error */
  final void c()
  {
    // Byte code:
    //   0: new 1053	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 1054	java/util/ArrayList:<init>	()V
    //   7: astore 8
    //   9: new 1053	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 1054	java/util/ArrayList:<init>	()V
    //   16: astore 9
    //   18: aload_0
    //   19: getfield 90	dpa:c	Landroid/database/sqlite/SQLiteDatabase;
    //   22: ldc -18
    //   24: getstatic 579	dpd:a	[Ljava/lang/String;
    //   27: ldc_w 1071
    //   30: iconst_1
    //   31: anewarray 50	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc_w 1060
    //   39: aastore
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 517	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore 7
    //   48: aload 7
    //   50: invokeinterface 491 1 0
    //   55: ifeq +200 -> 255
    //   58: aload 7
    //   60: iconst_0
    //   61: invokeinterface 607 2 0
    //   66: lstore_2
    //   67: aload 7
    //   69: bipush 7
    //   71: invokeinterface 607 2 0
    //   76: lstore 4
    //   78: new 470	android/app/DownloadManager$Query
    //   81: dup
    //   82: invokespecial 471	android/app/DownloadManager$Query:<init>	()V
    //   85: iconst_1
    //   86: newarray <illegal type>
    //   88: dup
    //   89: iconst_0
    //   90: lload 4
    //   92: lastore
    //   93: invokevirtual 475	android/app/DownloadManager$Query:setFilterById	([J)Landroid/app/DownloadManager$Query;
    //   96: astore 6
    //   98: aload_0
    //   99: getfield 114	dpa:e	Landroid/app/DownloadManager;
    //   102: aload 6
    //   104: invokevirtual 479	android/app/DownloadManager:query	(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;
    //   107: astore 6
    //   109: aload 6
    //   111: ifnull -63 -> 48
    //   114: aload 6
    //   116: invokeinterface 491 1 0
    //   121: ifeq +57 -> 178
    //   124: aload 6
    //   126: aload 6
    //   128: ldc 54
    //   130: invokeinterface 488 2 0
    //   135: invokeinterface 494 2 0
    //   140: istore_1
    //   141: iload_1
    //   142: iconst_1
    //   143: if_icmpeq +13 -> 156
    //   146: iload_1
    //   147: iconst_2
    //   148: if_icmpeq +8 -> 156
    //   151: iload_1
    //   152: iconst_4
    //   153: if_icmpne +25 -> 178
    //   156: aload 6
    //   158: invokeinterface 497 1 0
    //   163: goto -115 -> 48
    //   166: astore 6
    //   168: aload 7
    //   170: invokeinterface 497 1 0
    //   175: aload 6
    //   177: athrow
    //   178: aload 6
    //   180: invokeinterface 497 1 0
    //   185: aload 7
    //   187: bipush 9
    //   189: invokeinterface 527 2 0
    //   194: astore 6
    //   196: aload 7
    //   198: bipush 10
    //   200: invokeinterface 494 2 0
    //   205: ifeq +45 -> 250
    //   208: iconst_1
    //   209: istore_1
    //   210: aload 8
    //   212: lload_2
    //   213: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   216: invokevirtual 1065	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   219: pop
    //   220: iload_1
    //   221: ifeq +6 -> 227
    //   224: aconst_null
    //   225: astore 6
    //   227: aload 9
    //   229: aload 6
    //   231: invokevirtual 1065	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   234: pop
    //   235: goto -187 -> 48
    //   238: astore 8
    //   240: aload 6
    //   242: invokeinterface 497 1 0
    //   247: aload 8
    //   249: athrow
    //   250: iconst_0
    //   251: istore_1
    //   252: goto -42 -> 210
    //   255: aload 7
    //   257: invokeinterface 497 1 0
    //   262: aload 9
    //   264: invokestatic 1067	dpa:b	(Ljava/util/List;)V
    //   267: aload_0
    //   268: aload 8
    //   270: invokespecial 1069	dpa:a	(Ljava/util/List;)V
    //   273: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	dpa
    //   140	112	1	i1	int
    //   66	147	2	l1	long
    //   76	15	4	l2	long
    //   96	61	6	localObject1	Object
    //   166	13	6	localObject2	Object
    //   194	47	6	str	String
    //   46	210	7	localCursor	Cursor
    //   7	204	8	localArrayList1	ArrayList
    //   238	31	8	localList	List
    //   16	247	9	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   48	109	166	finally
    //   156	163	166	finally
    //   178	208	166	finally
    //   210	220	166	finally
    //   227	235	166	finally
    //   240	250	166	finally
    //   114	141	238	finally
  }
}

/* Location:
 * Qualified Name:     dpa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */