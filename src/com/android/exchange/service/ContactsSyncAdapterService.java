package com.android.exchange.service;

import android.content.AbstractThreadedSyncAdapter;
import bro;
import brs;

public class ContactsSyncAdapterService
  extends bro
{
  private static final Object c = new Object();
  private static AbstractThreadedSyncAdapter d = null;
  
  /* Error */
  public static boolean a(android.content.ContentResolver paramContentResolver, android.net.Uri paramUri, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: getstatic 29	bdv:B	[Ljava/lang/String;
    //   5: aload_2
    //   6: invokestatic 35	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9: ldc 37
    //   11: invokevirtual 41	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 47	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_0
    //   20: aload_0
    //   21: ifnonnull +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: invokeinterface 53 1 0
    //   32: istore_3
    //   33: iload_3
    //   34: ifle +15 -> 49
    //   37: iconst_1
    //   38: istore 4
    //   40: aload_0
    //   41: invokeinterface 56 1 0
    //   46: iload 4
    //   48: ireturn
    //   49: iconst_0
    //   50: istore 4
    //   52: goto -12 -> 40
    //   55: astore_1
    //   56: aload_0
    //   57: invokeinterface 56 1 0
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramContentResolver	android.content.ContentResolver
    //   0	64	1	paramUri	android.net.Uri
    //   0	64	2	paramString	String
    //   32	2	3	i	int
    //   38	13	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   26	33	55	finally
  }
  
  protected final AbstractThreadedSyncAdapter a()
  {
    synchronized (c)
    {
      if (d == null) {
        d = new brs(this, this);
      }
      AbstractThreadedSyncAdapter localAbstractThreadedSyncAdapter = d;
      return localAbstractThreadedSyncAdapter;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.exchange.service.ContactsSyncAdapterService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */