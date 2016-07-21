final class aqo
  implements Runnable
{
  aqo(aql paramaql) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	aqo:a	Laql;
    //   4: getfield 23	aql:d	Landroid/content/Context;
    //   7: invokevirtual 29	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: getstatic 34	com/android/emailcommon/provider/Account:a	Landroid/net/Uri;
    //   13: getstatic 38	com/android/emailcommon/provider/Account:B	[Ljava/lang/String;
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual 44	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore_3
    //   23: aload_3
    //   24: invokeinterface 50 1 0
    //   29: ifeq +43 -> 72
    //   32: aload_3
    //   33: iconst_0
    //   34: invokeinterface 54 2 0
    //   39: lstore_1
    //   40: aload_0
    //   41: getfield 12	aqo:a	Laql;
    //   44: getfield 58	aql:e	Landroid/app/NotificationManager;
    //   47: ldc 60
    //   49: lload_1
    //   50: ldc2_w 61
    //   53: ladd
    //   54: l2i
    //   55: invokevirtual 68	android/app/NotificationManager:cancel	(Ljava/lang/String;I)V
    //   58: goto -35 -> 23
    //   61: astore 4
    //   63: aload_3
    //   64: invokeinterface 71 1 0
    //   69: aload 4
    //   71: athrow
    //   72: aload_3
    //   73: invokeinterface 71 1 0
    //   78: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	aqo
    //   39	11	1	l	long
    //   22	51	3	localCursor	android.database.Cursor
    //   61	9	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	58	61	finally
  }
}

/* Location:
 * Qualified Name:     aqo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */