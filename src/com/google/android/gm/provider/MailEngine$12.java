package com.google.android.gm.provider;

class MailEngine$12
  implements Runnable
{
  MailEngine$12(MailEngine paramMailEngine) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 25
    //   2: ldc 27
    //   4: iconst_0
    //   5: anewarray 4	java/lang/Object
    //   8: invokestatic 33	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   11: pop
    //   12: aload_0
    //   13: getfield 17	com/google/android/gm/provider/MailEngine$12:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   16: getfield 37	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   19: aload_0
    //   20: getfield 17	com/google/android/gm/provider/MailEngine$12:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   23: invokestatic 41	com/google/android/gm/provider/MailEngine:access$500	(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;
    //   26: invokevirtual 47	com/google/android/gm/provider/TransactionHelper:beginTransactionWithListenerNonExclusive	(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V
    //   29: iconst_0
    //   30: istore_1
    //   31: aload_0
    //   32: getfield 17	com/google/android/gm/provider/MailEngine$12:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   35: getfield 51	com/google/android/gm/provider/MailEngine:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   38: ldc 53
    //   40: aconst_null
    //   41: invokestatic 59	android/database/DatabaseUtils:longForQuery	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J
    //   44: lstore_2
    //   45: lload_2
    //   46: lconst_0
    //   47: lcmp
    //   48: ifne +52 -> 100
    //   51: aload_0
    //   52: getfield 17	com/google/android/gm/provider/MailEngine$12:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   55: getfield 37	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   58: invokevirtual 62	com/google/android/gm/provider/TransactionHelper:setTransactionSuccessful	()V
    //   61: aload_0
    //   62: getfield 17	com/google/android/gm/provider/MailEngine$12:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   65: getfield 37	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   68: invokevirtual 65	com/google/android/gm/provider/TransactionHelper:endTransaction	()V
    //   71: iload_1
    //   72: ifeq +10 -> 82
    //   75: aload_0
    //   76: getfield 17	com/google/android/gm/provider/MailEngine$12:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   79: invokestatic 68	com/google/android/gm/provider/MailEngine:access$4800	(Lcom/google/android/gm/provider/MailEngine;)V
    //   82: return
    //   83: astore 5
    //   85: ldc 25
    //   87: aload 5
    //   89: ldc 70
    //   91: iconst_0
    //   92: anewarray 4	java/lang/Object
    //   95: invokestatic 74	com/google/android/gm/provider/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   98: pop
    //   99: return
    //   100: aload_0
    //   101: getfield 17	com/google/android/gm/provider/MailEngine$12:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   104: lload_2
    //   105: getstatic 80	com/google/android/gm/provider/MailSync$SyncRationale:UNKNOWN	Lcom/google/android/gm/provider/MailSync$SyncRationale;
    //   108: iconst_1
    //   109: iconst_0
    //   110: invokestatic 84	com/google/android/gm/provider/MailEngine:access$2000	(Lcom/google/android/gm/provider/MailEngine;JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V
    //   113: aload_0
    //   114: getfield 17	com/google/android/gm/provider/MailEngine$12:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   117: getfield 51	com/google/android/gm/provider/MailEngine:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   120: invokevirtual 90	android/database/sqlite/SQLiteDatabase:yieldIfContendedSafely	()Z
    //   123: pop
    //   124: aload_0
    //   125: getfield 17	com/google/android/gm/provider/MailEngine$12:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   128: invokestatic 94	com/google/android/gm/provider/MailEngine:access$4700	(Lcom/google/android/gm/provider/MailEngine;)Z
    //   131: istore 4
    //   133: iload 4
    //   135: ifne +7 -> 142
    //   138: iload_1
    //   139: ifeq +8 -> 147
    //   142: iconst_1
    //   143: istore_1
    //   144: goto -113 -> 31
    //   147: iconst_0
    //   148: istore_1
    //   149: goto -5 -> 144
    //   152: astore 5
    //   154: aload_0
    //   155: getfield 17	com/google/android/gm/provider/MailEngine$12:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   158: getfield 37	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   161: invokevirtual 65	com/google/android/gm/provider/TransactionHelper:endTransaction	()V
    //   164: aload 5
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	12
    //   30	119	1	i	int
    //   44	61	2	l	long
    //   131	3	4	bool	boolean
    //   83	5	5	localNullPointerException	NullPointerException
    //   152	13	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	29	83	java/lang/NullPointerException
    //   31	45	152	finally
    //   51	61	152	finally
    //   100	133	152	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */