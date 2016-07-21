import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class bed
  extends bec
{
  public static Uri g;
  public static final String h;
  public final long i;
  public long j;
  public final String k;
  public String l;
  
  static
  {
    String str1 = String.valueOf("messageKey=? and status!=");
    String str2 = String.valueOf(c);
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      h = str1;
      return;
    }
  }
  
  private bed(long paramLong1, String paramString1, long paramLong2, long paramLong3, long paramLong4, String paramString2, String paramString3)
  {
    super(paramLong1, paramString1, paramLong2);
    i = paramLong3;
    j = paramLong4;
    k = paramString2;
    l = paramString3;
  }
  
  /* Error */
  public static long a(ContentResolver paramContentResolver, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 57	bed:g	Landroid/net/Uri;
    //   4: getstatic 62	bee:a	[Ljava/lang/String;
    //   7: getstatic 36	bed:h	Ljava/lang/String;
    //   10: iconst_1
    //   11: anewarray 19	java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: lload_1
    //   17: invokestatic 65	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   20: aastore
    //   21: ldc 67
    //   23: invokevirtual 73	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull +34 -> 62
    //   31: aload_3
    //   32: invokeinterface 79 1 0
    //   37: ifeq +19 -> 56
    //   40: aload_3
    //   41: iconst_1
    //   42: invokeinterface 83 2 0
    //   47: lstore_1
    //   48: aload_3
    //   49: invokeinterface 86 1 0
    //   54: lload_1
    //   55: lreturn
    //   56: aload_3
    //   57: invokeinterface 86 1 0
    //   62: aload_0
    //   63: getstatic 90	beb:a	Landroid/net/Uri;
    //   66: lload_1
    //   67: invokestatic 96	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   70: getstatic 98	beb:l	[Ljava/lang/String;
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: invokevirtual 73	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore_0
    //   80: aload_0
    //   81: ifnull +43 -> 124
    //   84: aload_0
    //   85: invokeinterface 79 1 0
    //   90: ifeq +28 -> 118
    //   93: aload_0
    //   94: iconst_0
    //   95: invokeinterface 83 2 0
    //   100: lstore_1
    //   101: aload_0
    //   102: invokeinterface 86 1 0
    //   107: lload_1
    //   108: lreturn
    //   109: astore_0
    //   110: aload_3
    //   111: invokeinterface 86 1 0
    //   116: aload_0
    //   117: athrow
    //   118: aload_0
    //   119: invokeinterface 86 1 0
    //   124: ldc2_w 99
    //   127: lreturn
    //   128: astore_3
    //   129: aload_0
    //   130: invokeinterface 86 1 0
    //   135: aload_3
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramContentResolver	ContentResolver
    //   0	137	1	paramLong	long
    //   26	85	3	localCursor	Cursor
    //   128	8	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   31	48	109	finally
    //   84	101	128	finally
  }
  
  public static List<bed> a(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getContentResolver();
    Object localObject1 = a(paramContext, g, bef.a, paramLong);
    if (localObject1 == null) {
      return null;
    }
    nx localnx = new nx();
    Object localObject3;
    for (;;)
    {
      try
      {
        if (!((Cursor)localObject1).moveToNext()) {
          break;
        }
        paramLong = ((Cursor)localObject1).getLong(0);
        long l1 = ((Cursor)localObject1).getLong(1);
        localObject2 = ((Cursor)localObject1).getString(2);
        long l2 = ((Cursor)localObject1).getLong(3);
        long l3 = ((Cursor)localObject1).getLong(4);
        localObject3 = ((Cursor)localObject1).getString(5);
        String str = ((Cursor)localObject1).getString(6);
        bed localbed = (bed)localnx.a(l1, null);
        if (localbed != null)
        {
          if (f >= paramLong) {
            cvm.d("MessageMove", "Moves were not in ascending id order", new Object[0]);
          }
          if ((!l.equals(localObject3)) || (j != l2)) {
            cvm.d("MessageMove", "existing move's dst not same as this move's src", new Object[0]);
          }
          j = l3;
          l = str;
          f = paramLong;
        }
        else
        {
          localnx.b(l1, new bed(l1, (String)localObject2, paramLong, l2, l3, (String)localObject3, str));
        }
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
    }
    ((Cursor)localObject1).close();
    int m = localnx.a();
    localObject1 = new long[m];
    Object localObject2 = new ArrayList(m);
    int n = 0;
    m = 0;
    if (m < localnx.a())
    {
      localObject3 = (bed)localnx.c(m);
      if ((e == null) || (e.length() == 0) || (i == j))
      {
        localObject1[n] = d;
        n += 1;
      }
      for (;;)
      {
        m += 1;
        break;
        ((ArrayList)localObject2).add(localObject3);
      }
    }
    if (n != 0) {
      a(paramContext, g, (long[])localObject1, n);
    }
    if (((ArrayList)localObject2).isEmpty()) {
      return null;
    }
    return (List<bed>)localObject2;
  }
  
  public static void a()
  {
    g = bdv.H.buildUpon().appendEncodedPath("messageMove").build();
  }
  
  public static void a(ContentResolver paramContentResolver, long[] paramArrayOfLong, int paramInt)
  {
    a(paramContentResolver, g, paramArrayOfLong, paramInt);
  }
  
  public static Set<Long> b(ContentResolver paramContentResolver, long paramLong)
  {
    paramContentResolver = paramContentResolver.query(g, bef.a, "accountKey=?", new String[] { Long.toString(paramLong) }, null);
    HashSet localHashSet = new HashSet();
    for (;;)
    {
      if (paramContentResolver != null) {}
      try
      {
        if (paramContentResolver.moveToNext())
        {
          localHashSet.add(Long.valueOf(paramContentResolver.getLong(3)));
          localHashSet.add(Long.valueOf(paramContentResolver.getLong(4)));
        }
      }
      finally
      {
        if (paramContentResolver != null) {
          paramContentResolver.close();
        }
      }
    }
    return localSet;
  }
  
  public static void b(ContentResolver paramContentResolver, long[] paramArrayOfLong, int paramInt)
  {
    b(paramContentResolver, g, paramArrayOfLong, paramInt);
  }
  
  public static void c(ContentResolver paramContentResolver, long[] paramArrayOfLong, int paramInt)
  {
    bec.a(paramContentResolver, g, paramArrayOfLong, paramInt, 2);
  }
}

/* Location:
 * Qualified Name:     bed
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */