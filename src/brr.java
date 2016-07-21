import android.content.Context;
import com.android.exchange.service.CalendarSyncAdapterService;

public final class brr
  extends brq
{
  public brr(CalendarSyncAdapterService paramCalendarSyncAdapterService, Context paramContext)
  {
    super(paramCalendarSyncAdapterService, paramContext);
  }
  
  protected final String a()
  {
    return "calendar";
  }
  
  /* Error */
  protected final boolean a(android.accounts.Account paramAccount)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	brr:b	Lcom/android/exchange/service/CalendarSyncAdapterService;
    //   4: invokevirtual 25	com/android/exchange/service/CalendarSyncAdapterService:getContentResolver	()Landroid/content/ContentResolver;
    //   7: astore 4
    //   9: getstatic 31	android/provider/CalendarContract$Events:CONTENT_URI	Landroid/net/Uri;
    //   12: astore 5
    //   14: aload_1
    //   15: getfield 37	android/accounts/Account:name	Ljava/lang/String;
    //   18: astore_1
    //   19: aload 4
    //   21: aload 5
    //   23: iconst_1
    //   24: anewarray 39	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: ldc 41
    //   31: aastore
    //   32: ldc 43
    //   34: iconst_1
    //   35: anewarray 39	java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: aload_1
    //   41: aastore
    //   42: aconst_null
    //   43: invokevirtual 49	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +28 -> 76
    //   51: aload_1
    //   52: invokeinterface 55 1 0
    //   57: istore_2
    //   58: iload_2
    //   59: ifle +17 -> 76
    //   62: iconst_1
    //   63: istore_3
    //   64: aload_1
    //   65: ifnull +9 -> 74
    //   68: aload_1
    //   69: invokeinterface 59 1 0
    //   74: iload_3
    //   75: ireturn
    //   76: iconst_0
    //   77: istore_3
    //   78: goto -14 -> 64
    //   81: astore 4
    //   83: aconst_null
    //   84: astore_1
    //   85: aload_1
    //   86: ifnull +9 -> 95
    //   89: aload_1
    //   90: invokeinterface 59 1 0
    //   95: aload 4
    //   97: athrow
    //   98: astore 4
    //   100: goto -15 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	brr
    //   0	103	1	paramAccount	android.accounts.Account
    //   57	2	2	i	int
    //   63	15	3	bool	boolean
    //   7	13	4	localContentResolver	android.content.ContentResolver
    //   81	15	4	localObject1	Object
    //   98	1	4	localObject2	Object
    //   12	10	5	localUri	android.net.Uri
    // Exception table:
    //   from	to	target	type
    //   0	47	81	finally
    //   51	58	98	finally
  }
}

/* Location:
 * Qualified Name:     brr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */