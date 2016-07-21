import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.android.emailcommon.provider.Mailbox;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public final class bqk
{
  private static final String[] a;
  private static final String[] b;
  private static final Integer c;
  private static final String[] d;
  private static final String[] e;
  private static final TimeZone f;
  private static final TimeZone g;
  private static final boolean h;
  private static final ContentValues i;
  
  static
  {
    boolean bool2 = false;
    a = new String[] { "_id", "_sync_id" };
    b = new String[] { "_id", "_sync_id", "calendar_id", "dirty", "eventTimezone", "dtstart", "dtend", "allDay", "originalInstanceTime", "originalAllDay", "original_id", "original_sync_id", "lastDate", "rrule", "rdate" };
    c = Integer.valueOf(1);
    d = new String[] { "_id" };
    e = new String[] { String.valueOf(c) };
    f = TimeZone.getTimeZone("America/Cayman");
    g = TimeZone.getTimeZone("GMT");
    boolean bool1 = bool2;
    if (!f.hasSameRules(g))
    {
      bool1 = bool2;
      if (!f.useDaylightTime()) {
        bool1 = true;
      }
    }
    h = bool1;
    ContentValues localContentValues = new ContentValues(1);
    i = localContentValues;
    localContentValues.put("syncKey", "0");
  }
  
  private static String a(int paramInt)
  {
    return TextUtils.join(",", Collections.nCopies(paramInt, "?"));
  }
  
  /* Error */
  private static Map<String, ContentValues> a(Context paramContext, android.net.Uri paramUri, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: new 132	java/util/HashMap
    //   3: dup
    //   4: invokespecial 134	java/util/HashMap:<init>	()V
    //   7: astore 6
    //   9: aload_0
    //   10: invokevirtual 140	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: aload_1
    //   14: aload_2
    //   15: aload_3
    //   16: aload 4
    //   18: aconst_null
    //   19: invokevirtual 146	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore_0
    //   23: aload_0
    //   24: ifnull +103 -> 127
    //   27: aload_0
    //   28: invokeinterface 151 1 0
    //   33: ifeq +94 -> 127
    //   36: aload 5
    //   38: aload_0
    //   39: iconst_2
    //   40: invokeinterface 154 2 0
    //   45: invokeinterface 160 2 0
    //   50: checkcast 22	java/lang/String
    //   53: astore_1
    //   54: aload_0
    //   55: iconst_1
    //   56: invokeinterface 154 2 0
    //   61: astore_2
    //   62: aload_1
    //   63: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: ifne -43 -> 23
    //   69: new 97	android/content/ContentValues
    //   72: dup
    //   73: getstatic 56	bqk:b	[Ljava/lang/String;
    //   76: arraylength
    //   77: invokespecial 101	android/content/ContentValues:<init>	(I)V
    //   80: astore_3
    //   81: aload_0
    //   82: aload_3
    //   83: invokestatic 170	android/database/DatabaseUtils:cursorRowToContentValues	(Landroid/database/Cursor;Landroid/content/ContentValues;)V
    //   86: aload_3
    //   87: ldc -84
    //   89: aload_1
    //   90: invokevirtual 111	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload 6
    //   95: aload_1
    //   96: aload_2
    //   97: invokestatic 177	bsx:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   100: aload_3
    //   101: invokeinterface 180 3 0
    //   106: pop
    //   107: goto -84 -> 23
    //   110: astore_2
    //   111: aload_0
    //   112: astore_1
    //   113: aload_2
    //   114: astore_0
    //   115: aload_1
    //   116: ifnull +9 -> 125
    //   119: aload_1
    //   120: invokeinterface 183 1 0
    //   125: aload_0
    //   126: athrow
    //   127: aload_0
    //   128: ifnull +9 -> 137
    //   131: aload_0
    //   132: invokeinterface 183 1 0
    //   137: aload 6
    //   139: areturn
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_1
    //   143: goto -28 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramContext	Context
    //   0	146	1	paramUri	android.net.Uri
    //   0	146	2	paramArrayOfString1	String[]
    //   0	146	3	paramString	String
    //   0	146	4	paramArrayOfString2	String[]
    //   0	146	5	paramMap	Map<String, String>
    //   7	131	6	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   27	107	110	finally
    //   9	23	140	finally
  }
  
  public static void a(Context paramContext, com.android.emailcommon.provider.Account paramAccount)
  {
    int j = 0;
    bra localbra = new bra(paramContext, D);
    if (!localbra.b()) {}
    label194:
    label262:
    label320:
    for (;;)
    {
      return;
      if (h)
      {
        Map localMap;
        if (bnq.a(l).doubleValue() >= 12.0D)
        {
          localMap = b(paramContext, paramAccount);
          if (localMap.isEmpty())
          {
            localMap = null;
            if ((localMap != null) && (localMap.size() > 0)) {
              break label194;
            }
            j = 1;
          }
        }
        for (;;)
        {
          if (j == 0) {
            break label320;
          }
          localbra.c();
          return;
          String str = String.format("calendar_id IN (%s) AND eventTimezone IN (%s) AND (rrule IS NOT NULL AND rrule <> '' OR rdate IS NOT NULL AND rdate <> '' OR original_id IS NOT NULL AND original_id <> '' OR original_sync_id IS NOT NULL AND original_sync_id <> '') AND _sync_id IS NOT NULL AND _sync_id <> ''", new Object[] { a(localMap.size()), a(1) });
          Object localObject = new ArrayList();
          ((List)localObject).addAll(localMap.keySet());
          ((List)localObject).add("America/Cayman");
          localObject = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
          localMap = a(paramContext, CalendarContract.Events.CONTENT_URI, b, str, (String[])localObject, localMap);
          break;
          if (!a(localMap))
          {
            if (bnq.a(l).doubleValue() < 12.0D) {
              cvm.f(cvm.a, "ItemOperations command only supported on EAS v12.0+", new Object[0]);
            }
            for (j = 65335;; j = new bqz(paramContext, paramAccount, localMap).p_())
            {
              if (j < 0) {
                break label262;
              }
              j = 1;
              break;
            }
            j = 0;
            continue;
            if (!a(paramContext))
            {
              bqu.a(paramContext, d);
              paramContext.getContentResolver().update(Mailbox.a, i, "accountKey=? AND type=65", new String[] { String.valueOf(D) });
              j = 1;
            }
          }
          a(paramAccount);
        }
      }
    }
  }
  
  private static void a(com.android.emailcommon.provider.Account paramAccount)
  {
    ContentResolver.requestSync(new android.accounts.Account(d, bnq.c), "com.android.calendar", null);
  }
  
  /* Error */
  private static boolean a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 140	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 264	android/provider/CalendarContract$Events:CONTENT_URI	Landroid/net/Uri;
    //   7: getstatic 66	bqk:d	[Ljava/lang/String;
    //   10: ldc_w 326
    //   13: getstatic 71	bqk:e	[Ljava/lang/String;
    //   16: aconst_null
    //   17: invokevirtual 146	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull +52 -> 74
    //   25: aload_0
    //   26: invokeinterface 329 1 0
    //   31: istore_1
    //   32: iload_1
    //   33: ifle +17 -> 50
    //   36: iconst_1
    //   37: istore_2
    //   38: aload_0
    //   39: ifnull +9 -> 48
    //   42: aload_0
    //   43: invokeinterface 183 1 0
    //   48: iload_2
    //   49: ireturn
    //   50: iconst_0
    //   51: istore_2
    //   52: goto -14 -> 38
    //   55: astore_3
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: ifnull +9 -> 68
    //   62: aload_0
    //   63: invokeinterface 183 1 0
    //   68: aload_3
    //   69: athrow
    //   70: astore_3
    //   71: goto -13 -> 58
    //   74: iconst_1
    //   75: istore_2
    //   76: goto -38 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	paramContext	Context
    //   31	2	1	j	int
    //   37	39	2	bool	boolean
    //   55	14	3	localObject1	Object
    //   70	1	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	21	55	finally
    //   25	32	70	finally
  }
  
  private static boolean a(Map<String, ContentValues> paramMap)
  {
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      ContentValues localContentValues = (ContentValues)paramMap.next();
      if (c.equals(localContentValues.getAsInteger("dirty"))) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private static Map<String, String> b(Context paramContext, com.android.emailcommon.provider.Account paramAccount)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 291	com/android/emailcommon/provider/Account:d	Ljava/lang/String;
    //   4: astore_2
    //   5: getstatic 316	bnq:c	Ljava/lang/String;
    //   8: astore_3
    //   9: new 132	java/util/HashMap
    //   12: dup
    //   13: invokespecial 134	java/util/HashMap:<init>	()V
    //   16: astore_1
    //   17: aload_0
    //   18: invokevirtual 140	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   21: getstatic 359	android/provider/CalendarContract$Calendars:CONTENT_URI	Landroid/net/Uri;
    //   24: getstatic 28	bqk:a	[Ljava/lang/String;
    //   27: ldc_w 361
    //   30: iconst_2
    //   31: anewarray 22	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: aload_2
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: aload_3
    //   41: aastore
    //   42: aconst_null
    //   43: invokevirtual 146	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnull +55 -> 103
    //   51: aload_0
    //   52: invokeinterface 151 1 0
    //   57: ifeq +46 -> 103
    //   60: aload_0
    //   61: iconst_1
    //   62: invokeinterface 154 2 0
    //   67: astore_2
    //   68: aload_1
    //   69: aload_0
    //   70: iconst_0
    //   71: invokeinterface 154 2 0
    //   76: aload_2
    //   77: invokeinterface 180 3 0
    //   82: pop
    //   83: goto -36 -> 47
    //   86: astore_2
    //   87: aload_0
    //   88: astore_1
    //   89: aload_2
    //   90: astore_0
    //   91: aload_1
    //   92: ifnull +9 -> 101
    //   95: aload_1
    //   96: invokeinterface 183 1 0
    //   101: aload_0
    //   102: athrow
    //   103: aload_0
    //   104: ifnull +9 -> 113
    //   107: aload_0
    //   108: invokeinterface 183 1 0
    //   113: aload_1
    //   114: areturn
    //   115: astore_0
    //   116: aconst_null
    //   117: astore_1
    //   118: goto -27 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramContext	Context
    //   0	121	1	paramAccount	com.android.emailcommon.provider.Account
    //   4	73	2	str1	String
    //   86	4	2	localObject	Object
    //   8	33	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   51	83	86	finally
    //   17	47	115	finally
  }
}

/* Location:
 * Qualified Name:     bqk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */