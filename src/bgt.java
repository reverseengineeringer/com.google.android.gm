import android.app.DownloadManager;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.android.emailcommon.provider.Attachment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class bgt
{
  public static final String[] a = { "*/*" };
  public static final String[] b = new String[0];
  public static final String[] c = { "ade", "adp", "bat", "chm", "cmd", "com", "cpl", "dll", "exe", "hta", "ins", "isp", "jse", "lib", "mde", "msc", "msp", "mst", "pif", "scr", "sct", "shb", "sys", "vb", "vbe", "vbs", "vxd", "wsc", "wsf", "wsh", "zip", "gz", "z", "tar", "tgz", "bz2" };
  public static final String[] d = { "apk" };
  private static final String[] e = { "cachedFile" };
  private static Uri f;
  
  private static long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = idc.a(paramInputStream, paramOutputStream);
    paramInputStream.close();
    paramOutputStream.flush();
    paramOutputStream.close();
    return l;
  }
  
  public static Uri a(long paramLong1, long paramLong2)
  {
    if (f == null) {
      f = Uri.parse(Attachment.d);
    }
    return f.buildUpon().appendPath(Long.toString(paramLong1)).appendPath(Long.toString(paramLong2)).appendPath("RAW").build();
  }
  
  public static Uri a(ContentResolver paramContentResolver, Uri paramUri)
  {
    Cursor localCursor = paramContentResolver.query(paramUri, new String[] { "_data" }, null, null, null);
    paramContentResolver = paramUri;
    if (localCursor != null) {}
    try
    {
      if (localCursor.moveToFirst())
      {
        paramContentResolver = localCursor.getString(0);
        if (paramContentResolver != null)
        {
          paramContentResolver = Uri.parse(paramContentResolver);
          return paramContentResolver;
        }
      }
      return paramUri;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public static File a(Context paramContext, long paramLong)
  {
    return paramContext.getDatabasePath(27 + paramLong + ".db_att");
  }
  
  public static File a(Context paramContext, long paramLong1, long paramLong2)
  {
    return new File(a(paramContext, paramLong1), Long.toString(paramLong2));
  }
  
  public static String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf('.');
      localObject1 = localObject2;
      if (i > 0)
      {
        localObject1 = localObject2;
        if (i < paramString.length() - 1) {
          localObject1 = paramString.substring(i + 1).toLowerCase();
        }
      }
    }
    return (String)localObject1;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = a(paramString1);
    boolean bool = "text/plain".equalsIgnoreCase(paramString2);
    if ("eml".equals(str)) {
      paramString1 = "message/rfc822";
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString1)) {
        if (bool) {
          paramString1 = "text/plain";
        }
      }
      for (;;)
      {
        return paramString1.toLowerCase();
        if ((bool) || ("application/octet-stream".equalsIgnoreCase(paramString2))) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            paramString1 = paramString2;
            if (!TextUtils.isEmpty(paramString2)) {
              break;
            }
          }
          if (TextUtils.isEmpty(str)) {
            break label158;
          }
          paramString1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
          if (!TextUtils.isEmpty(paramString1)) {
            break label155;
          }
          paramString1 = paramString2;
          if (bool) {
            break;
          }
          paramString1 = String.valueOf(str);
          if (paramString1.length() == 0) {
            break label132;
          }
          paramString1 = "application/".concat(paramString1);
          break;
        }
        label132:
        paramString1 = new String("application/");
        break;
        paramString1 = "application/octet-stream";
      }
      label155:
      continue;
      label158:
      paramString1 = null;
    }
  }
  
  public static void a(Context paramContext, InputStream paramInputStream, Attachment paramAttachment)
  {
    Uri localUri = ContentUris.withAppendedId(Attachment.a, D);
    localContentValues = new ContentValues();
    l1 = D;
    long l2 = u;
    localObject1 = p;
    try
    {
      localObject2 = paramContext.getContentResolver();
      if (w != 0) {
        break label134;
      }
      paramAttachment = a(l2, l1);
      l1 = a(paramInputStream, ((ContentResolver)localObject2).openOutputStream(paramAttachment));
      paramInputStream = paramAttachment.toString();
      paramAttachment = (Attachment)localObject1;
    }
    catch (IOException paramInputStream)
    {
      Object localObject2;
      for (;;)
      {
        localContentValues.put("uiState", Integer.valueOf(1));
      }
      localObject1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
      ((File)localObject1).mkdirs();
      localObject1 = bhn.a((File)localObject1, i);
      l1 = a(paramInputStream, new FileOutputStream((File)localObject1));
      localObject1 = ((File)localObject1).getAbsolutePath();
      MediaScannerConnection.scanFile(paramContext, new String[] { localObject1 }, null, null);
      if (!TextUtils.isEmpty(j)) {
        break label318;
      }
      for (paramInputStream = "application/octet-stream";; paramInputStream = j) {
        try
        {
          localObject2 = (DownloadManager)paramContext.getSystemService("download");
          paramInputStream = ((DownloadManager)localObject2).getUriForDownloadedFile(((DownloadManager)localObject2).addCompletedDownload(i, i, false, paramInputStream, (String)localObject1, l1, true)).toString();
          paramAttachment = (Attachment)localObject1;
        }
        catch (IllegalArgumentException paramInputStream)
        {
          cvm.b(cvm.a, paramInputStream, "IAE from DownloadManager while saving attachment", new Object[0]);
          throw new IOException(paramInputStream);
        }
      }
      cvm.d(bbw.a, "Trying to save an attachment without external storage?", new Object[0]);
      throw new IOException();
    }
    localContentValues.put("size", Long.valueOf(l1));
    localContentValues.put("contentUri", paramInputStream);
    localContentValues.put("location", paramAttachment);
    localContentValues.put("uiState", Integer.valueOf(3));
    paramContext.getContentResolver().update(localUri, localContentValues, null, null);
    return;
    label134:
    if (bhn.a()) {
      if (TextUtils.isEmpty(i))
      {
        cvm.d(bbw.a, "Trying to save an attachment with no name: %d", new Object[] { Long.valueOf(l1) });
        throw new IOException("Can't save an attachment with no name");
      }
    }
  }
  
  /* Error */
  public static void b(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: getstatic 429	com/android/emailcommon/provider/Attachment:c	Landroid/net/Uri;
    //   3: lload_1
    //   4: invokestatic 289	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 303	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_3
    //   13: getstatic 20	bgt:e	[Ljava/lang/String;
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual 167	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore_0
    //   23: aload_0
    //   24: ifnonnull +4 -> 28
    //   27: return
    //   28: aload_0
    //   29: invokeinterface 432 1 0
    //   34: ifeq +42 -> 76
    //   37: aload_0
    //   38: iconst_0
    //   39: invokeinterface 177 2 0
    //   44: astore_3
    //   45: aload_3
    //   46: invokestatic 218	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifne -21 -> 28
    //   52: new 206	java/io/File
    //   55: dup
    //   56: aload_3
    //   57: invokespecial 433	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: invokevirtual 436	java/io/File:delete	()Z
    //   63: pop
    //   64: goto -36 -> 28
    //   67: astore_3
    //   68: aload_0
    //   69: invokeinterface 178 1 0
    //   74: aload_3
    //   75: athrow
    //   76: aload_0
    //   77: invokeinterface 178 1 0
    //   82: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramContext	Context
    //   0	83	1	paramLong	long
    //   7	50	3	localObject1	Object
    //   67	8	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	64	67	finally
  }
  
  public static void b(Context paramContext, long paramLong1, long paramLong2)
  {
    Object localObject = ContentUris.withAppendedId(Attachment.c, paramLong2);
    localObject = paramContext.getContentResolver().query((Uri)localObject, Attachment.B, null, null, null);
    if (localObject == null)
    {
      cvm.b(bbw.a, "Failed to find attachments to delete, %d", new Object[] { Long.valueOf(paramLong2) });
      return;
    }
    try
    {
      if (((Cursor)localObject).moveToNext()) {
        a(paramContext, paramLong1, ((Cursor)localObject).getLong(0)).delete();
      }
      return;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  public static void c(Context paramContext, long paramLong)
  {
    File[] arrayOfFile = a(paramContext, paramLong).listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    label23:
    String str;
    if (i < j)
    {
      paramContext = arrayOfFile[i];
      if (!paramContext.delete())
      {
        str = bbw.a;
        paramContext = String.valueOf(paramContext.getName());
        if (paramContext.length() == 0) {
          break label87;
        }
      }
    }
    label87:
    for (paramContext = "Failed to delete attachment file ".concat(paramContext);; paramContext = new String("Failed to delete attachment file "))
    {
      cvm.e(str, paramContext, new Object[0]);
      i += 1;
      break label23;
      break;
    }
  }
  
  public static void c(Context paramContext, long paramLong1, long paramLong2)
  {
    Cursor localCursor = paramContext.getContentResolver().query(beb.a, beb.k, "mailboxKey=?", new String[] { Long.toString(paramLong2) }, null);
    try
    {
      if (localCursor.moveToNext()) {
        b(paramContext, paramLong1, localCursor.getLong(0));
      }
      return;
    }
    finally
    {
      localCursor.close();
    }
  }
}

/* Location:
 * Qualified Name:     bgt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */