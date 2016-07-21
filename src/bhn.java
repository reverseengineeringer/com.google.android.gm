import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.os.StrictMode.VmPolicy;
import android.os.StrictMode.VmPolicy.Builder;
import android.text.TextUtils;
import android.widget.TextView;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Attachment;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class bhn
{
  public static final Charset a = Charset.forName("UTF-8");
  public static final Charset b = Charset.forName("US-ASCII");
  public static final String[] c = new String[0];
  public static final bhw d = new bhw("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
  private static final bhw e = new bhw("yyyyMMdd'T'HHmmss'Z'");
  private static final bhw f = new bhw("yyyyMMdd");
  private static final bhw g = new bhw("yyyy-MM-dd");
  private static final bhw h = new bhw("yyyy-MM-dd'T'HH:mm:ss'Z'");
  private static final bht<Long> i = new bhp();
  private static final bht<Integer> j = new bhq();
  private static final bht<String> k = new bhr();
  private static final bht<byte[]> l = new bhs();
  
  public static long a(String paramString)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
    if (paramString.length() <= 8) {
      localGregorianCalendar.setTime(f.a(paramString));
    }
    for (;;)
    {
      return localGregorianCalendar.getTimeInMillis();
      localGregorianCalendar.setTime(e.a(paramString));
    }
  }
  
  public static File a(File paramFile, String paramString)
  {
    bhu localbhu = bhu.a;
    Object localObject1 = new File(paramFile, paramString);
    if (localbhu.a((File)localObject1)) {
      return (File)localObject1;
    }
    int m = paramString.lastIndexOf('.');
    Object localObject2;
    if (m != -1)
    {
      localObject2 = paramString.substring(0, m);
      localObject1 = paramString.substring(m);
      paramString = (String)localObject2;
      m = 2;
    }
    for (;;)
    {
      if (m >= Integer.MAX_VALUE) {
        break label166;
      }
      localObject2 = String.valueOf(Integer.toString(m));
      localObject2 = new File(paramFile, String.valueOf(paramString).length() + 1 + String.valueOf(localObject2).length() + String.valueOf(localObject1).length() + paramString + "-" + (String)localObject2 + (String)localObject1);
      if (localbhu.a((File)localObject2))
      {
        return (File)localObject2;
        localObject1 = "";
        break;
      }
      m += 1;
    }
    label166:
    return null;
  }
  
  public static Integer a(Context paramContext, Uri paramUri, String[] paramArrayOfString, int paramInt, Integer paramInteger)
  {
    return (Integer)a(paramContext, paramUri, paramArrayOfString, null, null, null, paramInt, paramInteger, j);
  }
  
  public static Long a(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    return (Long)a(paramContext, paramUri, paramArrayOfString1, paramString, paramArrayOfString2, null, 0, null, i);
  }
  
  public static Long a(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, Long paramLong)
  {
    return (Long)a(paramContext, paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, 0, paramLong, i);
  }
  
  private static <T> T a(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, int paramInt, T paramT, bht<T> parambht)
  {
    if (("content".equals(paramUri.getScheme())) && (bdv.F.equals(paramUri.getAuthority()))) {
      paramUri = bdv.a(paramUri, 1);
    }
    for (;;)
    {
      paramUri = paramContext.getContentResolver().query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      paramContext = paramT;
      if (paramUri != null) {}
      try
      {
        if (paramUri.moveToFirst())
        {
          paramContext = parambht.a(paramUri, paramInt);
          return paramContext;
          continue;
        }
        return paramT;
      }
      finally
      {
        paramUri.close();
      }
    }
  }
  
  public static String a(int paramInt)
  {
    return a(new StringBuilder(), paramInt).toString();
  }
  
  public static String a(Charset paramCharset, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramCharset = paramCharset.decode(ByteBuffer.wrap(paramArrayOfByte));
    return new String(paramCharset.array(), 0, paramCharset.length());
  }
  
  public static String a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int m = 0;
    while (m < paramArrayOfObject.length)
    {
      localStringBuilder.append(paramArrayOfObject[m].toString());
      if (m < paramArrayOfObject.length - 1) {
        localStringBuilder.append(' ');
      }
      m += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, int paramInt)
  {
    paramInt &= 0xFF;
    paramStringBuilder.append("0123456789ABCDEF".charAt(paramInt >> 4));
    paramStringBuilder.append("0123456789ABCDEF".charAt(paramInt & 0xF));
    return paramStringBuilder;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    String str = paramContext.getResources().getString(paramInt);
    new Handler(Looper.getMainLooper()).post(new bho(paramContext, str));
  }
  
  public static void a(AsyncTask<?, ?, ?> paramAsyncTask)
  {
    if ((paramAsyncTask != null) && (paramAsyncTask.getStatus() != AsyncTask.Status.FINISHED)) {
      paramAsyncTask.cancel(true);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = new StrictMode.ThreadPolicy.Builder().detectAll().build();
      StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)localObject);
      if (!paramBoolean) {
        break label52;
      }
    }
    label52:
    for (Object localObject = new StrictMode.VmPolicy.Builder().detectAll().build();; localObject = StrictMode.VmPolicy.LAX)
    {
      StrictMode.setVmPolicy((StrictMode.VmPolicy)localObject);
      return;
      localObject = StrictMode.ThreadPolicy.LAX;
      break;
    }
  }
  
  public static boolean a()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static boolean a(byte paramByte)
  {
    return (paramByte & 0xC0) != 128;
  }
  
  public static boolean a(Context paramContext, long paramLong)
  {
    Object localObject = beb.a(paramContext, paramLong);
    if (localObject == null) {}
    for (;;)
    {
      return false;
      Attachment[] arrayOfAttachment = Attachment.b(paramContext, paramLong);
      int n = arrayOfAttachment.length;
      int m = 0;
      while (m < n)
      {
        Attachment localAttachment = arrayOfAttachment[m];
        if (!a(paramContext, localAttachment)) {
          if ((s & 0x6) == 0)
          {
            cvm.b(cvm.a, "Unloaded attachment isn't marked for download: %s, #%d", new Object[] { i, Long.valueOf(D) });
            Account localAccount = Account.a(paramContext, V);
            if (localAccount == null) {
              return true;
            }
            if (((u & 0x2) == 0) || ((j & 0x80) == 0)) {
              Attachment.a(paramContext, Attachment.a, D);
            }
          }
          else
          {
            for (;;)
            {
              return true;
              if (localAttachment.d() != null)
              {
                localObject = new ContentValues();
                ((ContentValues)localObject).putNull("contentUri");
                Attachment.a(paramContext, Attachment.a, D, (ContentValues)localObject);
              }
            }
          }
        }
        m += 1;
      }
    }
  }
  
  /* Error */
  public static boolean a(Context paramContext, Attachment paramAttachment)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_1
    //   7: getfield 443	com/android/emailcommon/provider/Attachment:t	[B
    //   10: ifnull +5 -> 15
    //   13: iconst_1
    //   14: ireturn
    //   15: aload_1
    //   16: getfield 446	com/android/emailcommon/provider/Attachment:n	Ljava/lang/String;
    //   19: astore_2
    //   20: aload_2
    //   21: invokestatic 452	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +39 -> 63
    //   27: aload_2
    //   28: invokestatic 456	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: astore_2
    //   32: aload_0
    //   33: invokevirtual 209	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   36: aload_2
    //   37: invokevirtual 460	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   40: astore_2
    //   41: aload_2
    //   42: invokevirtual 463	java/io/InputStream:close	()V
    //   45: iconst_1
    //   46: ireturn
    //   47: astore_2
    //   48: getstatic 387	cvm:a	Ljava/lang/String;
    //   51: aload_2
    //   52: ldc_w 465
    //   55: iconst_0
    //   56: anewarray 4	java/lang/Object
    //   59: invokestatic 468	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   62: pop
    //   63: aload_1
    //   64: invokevirtual 422	com/android/emailcommon/provider/Attachment:d	()Ljava/lang/String;
    //   67: astore_1
    //   68: aload_1
    //   69: invokestatic 452	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: ifne -68 -> 4
    //   75: aload_1
    //   76: invokestatic 456	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   79: astore_1
    //   80: aload_0
    //   81: invokevirtual 209	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   84: aload_1
    //   85: invokevirtual 460	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 463	java/io/InputStream:close	()V
    //   93: iconst_1
    //   94: ireturn
    //   95: astore_0
    //   96: getstatic 387	cvm:a	Ljava/lang/String;
    //   99: aload_0
    //   100: ldc_w 470
    //   103: iconst_0
    //   104: anewarray 4	java/lang/Object
    //   107: invokestatic 472	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   110: pop
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_0
    //   114: goto -69 -> 45
    //   117: astore_0
    //   118: goto -25 -> 93
    //   121: astore_0
    //   122: iconst_0
    //   123: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramContext	Context
    //   0	124	1	paramAttachment	Attachment
    //   19	23	2	localObject	Object
    //   47	5	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   32	41	47	java/io/FileNotFoundException
    //   41	45	47	java/io/FileNotFoundException
    //   75	80	95	java/lang/RuntimeException
    //   80	89	95	java/lang/RuntimeException
    //   89	93	95	java/lang/RuntimeException
    //   41	45	113	java/io/IOException
    //   89	93	117	java/io/IOException
    //   80	89	121	java/io/FileNotFoundException
    //   89	93	121	java/io/FileNotFoundException
  }
  
  public static boolean a(TextView paramTextView)
  {
    paramTextView = paramTextView.getText();
    if (TextUtils.isEmpty(paramTextView)) {}
    for (;;)
    {
      return false;
      try
      {
        paramTextView = Integer.valueOf(Integer.parseInt(paramTextView.toString()));
        if ((paramTextView.intValue() > 0) && (paramTextView.intValue() < 65536)) {
          return true;
        }
      }
      catch (NumberFormatException paramTextView) {}
    }
    return false;
  }
  
  public static boolean a(Object[] paramArrayOfObject, Object paramObject)
  {
    boolean bool = false;
    int n = paramArrayOfObject.length;
    int m = 0;
    if (m < n) {
      if (!paramArrayOfObject[m].equals(paramObject)) {}
    }
    for (;;)
    {
      if (m >= 0) {
        bool = true;
      }
      return bool;
      m += 1;
      break;
      m = -1;
    }
  }
  
  public static byte[] a(Charset paramCharset, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramCharset = paramCharset.encode(CharBuffer.wrap(paramString));
    paramString = new byte[paramCharset.limit()];
    paramCharset.get(paramString);
    return paramString;
  }
  
  public static long[] a(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramContext = paramContext.getContentResolver().query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, null);
    if (paramContext == null)
    {
      paramContext = String.valueOf(paramUri);
      throw new IllegalArgumentException(String.valueOf(paramContext).length() + 25 + "Null cursor returned for " + paramContext);
    }
    try
    {
      paramUri = new long[paramContext.getCount()];
      int n = paramContext.getColumnIndex(paramString2);
      int m = 0;
      while (paramContext.moveToNext())
      {
        paramUri[m] = paramContext.getLong(n);
        m += 1;
      }
      return paramUri;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public static String[] a(Context paramContext, Uri paramUri, long paramLong, String... paramVarArgs)
  {
    return a(paramContext, ContentUris.withAppendedId(paramUri, paramLong), paramVarArgs);
  }
  
  private static String[] a(Context paramContext, Uri paramUri, String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[paramArrayOfString.length];
    paramContext = paramContext.getContentResolver().query(paramUri, paramArrayOfString, null, null, null);
    try
    {
      if (paramContext.moveToFirst())
      {
        int m = 0;
        while (m < paramArrayOfString.length)
        {
          arrayOfString[m] = paramContext.getString(m);
          m += 1;
        }
      }
      return null;
      return arrayOfString;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public static long b(String paramString)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
    if (paramString.length() <= 10) {
      localGregorianCalendar.setTime(g.a(paramString));
    }
    for (;;)
    {
      return localGregorianCalendar.getTimeInMillis();
      if (paramString.length() <= 20) {
        localGregorianCalendar.setTime(h.a(paramString));
      } else {
        localGregorianCalendar.setTime(d.a(paramString));
      }
    }
  }
  
  public static String b(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    return (String)a(paramContext, paramUri, paramArrayOfString1, paramString, paramArrayOfString2, null, 0, null, k);
  }
  
  public static boolean b(TextView paramTextView)
  {
    return f(paramTextView.getText().toString());
  }
  
  public static String c(String paramString)
  {
    return paramString.replace("\r", "").replace("\n", "\r\n");
  }
  
  public static String d(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(a(a, paramString));
      paramString = localMessageDigest.digest();
      int m = paramString[19] & 0xF;
      int n = paramString[m];
      int i1 = paramString[(m + 1)];
      int i2 = paramString[(m + 2)];
      return Integer.toString(paramString[(m + 3)] & 0xFF | (n & 0x7F) << 24 | (i1 & 0xFF) << 16 | (i2 & 0xFF) << 8);
    }
    catch (NoSuchAlgorithmException paramString) {}
    return null;
  }
  
  public static ByteArrayInputStream e(String paramString)
  {
    return new ByteArrayInputStream(a(b, paramString));
  }
  
  private static boolean f(String paramString)
  {
    paramString = paramString.trim();
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      new URI("http", null, paramString, -1, null, null, null);
      return true;
    }
    catch (URISyntaxException paramString) {}
    return false;
  }
}

/* Location:
 * Qualified Name:     bhn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */