import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;

public final class bds
  extends bdv
{
  public static Uri a;
  public static final String[] b = { "_id", "messageKey", "htmlContentUri", "textContentUri", "sourceMessageKey", "quotedTextStartPos" };
  public long c;
  public String d;
  public String e;
  public int f;
  public long g;
  
  public bds()
  {
    C = a;
  }
  
  public static Uri a(long paramLong)
  {
    return bdv.H.buildUpon().appendPath("bodyText").appendPath(Long.toString(paramLong)).build();
  }
  
  public static bds a(Context paramContext, long paramLong)
  {
    Cursor localCursor = paramContext.getContentResolver().query(a, b, "messageKey=?", new String[] { Long.toString(paramLong) }, null);
    if (localCursor == null) {
      throw new bej();
    }
    return b(paramContext, localCursor);
  }
  
  /* Error */
  private static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: invokestatic 100	cwv:a	()Z
    //   3: pop
    //   4: aload_0
    //   5: invokevirtual 78	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   8: aload_1
    //   9: invokestatic 104	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   12: invokevirtual 108	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   15: astore_2
    //   16: aload_2
    //   17: invokestatic 113	idc:c	(Ljava/io/InputStream;)Ljava/lang/String;
    //   20: astore_0
    //   21: aload_2
    //   22: invokevirtual 118	java/io/InputStream:close	()V
    //   25: aload_0
    //   26: areturn
    //   27: astore_0
    //   28: aload_2
    //   29: invokevirtual 118	java/io/InputStream:close	()V
    //   32: aload_0
    //   33: athrow
    //   34: astore_2
    //   35: aconst_null
    //   36: astore_0
    //   37: getstatic 122	cvm:a	Ljava/lang/String;
    //   40: aload_2
    //   41: ldc 124
    //   43: iconst_1
    //   44: anewarray 126	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_1
    //   50: aastore
    //   51: invokestatic 129	cvm:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   54: pop
    //   55: aload_0
    //   56: areturn
    //   57: astore_2
    //   58: goto -21 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramContext	Context
    //   0	61	1	paramString	String
    //   15	14	2	localInputStream	java.io.InputStream
    //   34	7	2	localIOException1	java.io.IOException
    //   57	1	2	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   16	21	27	finally
    //   0	16	34	java/io/IOException
    //   28	34	34	java/io/IOException
    //   21	25	57	java/io/IOException
  }
  
  public static void a()
  {
    String str = String.valueOf(bdv.H);
    a = Uri.parse(String.valueOf(str).length() + 5 + str + "/body");
  }
  
  public static void a(Context paramContext, long paramLong, ContentValues paramContentValues)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    long l = bhn.a(paramContext, a, B, "messageKey=?", new String[] { Long.toString(paramLong) }, null, Long.valueOf(-1L)).longValue();
    paramContentValues.put("messageKey", Long.valueOf(paramLong));
    if (l == -1L)
    {
      localContentResolver.insert(a, paramContentValues);
      return;
    }
    localContentResolver.update(ContentUris.withAppendedId(a, l), paramContentValues, null, null);
  }
  
  public static long b(Context paramContext, long paramLong)
  {
    Uri localUri = a;
    String str = Long.toString(paramLong);
    return bhn.a(paramContext, localUri, new String[] { "sourceMessageKey" }, "messageKey=?", new String[] { str }, null, Long.valueOf(0L)).longValue();
  }
  
  public static Uri b(long paramLong)
  {
    return bdv.H.buildUpon().appendPath("bodyHtml").appendPath(Long.toString(paramLong)).build();
  }
  
  private static bds b(Context paramContext, Cursor paramCursor)
  {
    try
    {
      if (paramCursor.moveToFirst())
      {
        paramContext = (bds)a(paramContext, paramCursor, bds.class);
        return paramContext;
      }
      return null;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  public static String c(Context paramContext, long paramLong)
  {
    return a(paramContext, a(paramLong).toString());
  }
  
  public static String d(Context paramContext, long paramLong)
  {
    return a(paramContext, b(paramLong).toString());
  }
  
  public final void a(Context paramContext, Cursor paramCursor)
  {
    C = a;
    c = paramCursor.getLong(1);
    d = a(paramContext, paramCursor.getString(2));
    e = a(paramContext, paramCursor.getString(3));
    g = paramCursor.getLong(4);
    f = paramCursor.getInt(5);
  }
  
  public final void a(Cursor paramCursor)
  {
    throw new UnsupportedOperationException("Must have context to restore Body object");
  }
  
  public final ContentValues e()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("messageKey", Long.valueOf(c));
    localContentValues.put("htmlContent", d);
    localContentValues.put("textContent", e);
    localContentValues.put("sourceMessageKey", Long.valueOf(g));
    return localContentValues;
  }
}

/* Location:
 * Qualified Name:     bds
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */