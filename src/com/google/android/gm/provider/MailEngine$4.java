package com.google.android.gm.provider;

import android.content.Context;

class MailEngine$4
  implements Runnable
{
  MailEngine$4(MailEngine paramMailEngine, Context paramContext) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   4: getfield 32	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   7: aload_0
    //   8: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   11: invokestatic 36	com/google/android/gm/provider/MailEngine:access$500	(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;
    //   14: invokevirtual 42	com/google/android/gm/provider/TransactionHelper:beginTransactionWithListenerNonExclusive	(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V
    //   17: aload_0
    //   18: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   21: getfield 46	com/google/android/gm/provider/MailEngine:mMailCore	Lcom/google/android/gm/provider/MailCore;
    //   24: invokevirtual 51	com/google/android/gm/provider/MailCore:onLabelsChanged	()V
    //   27: aload_0
    //   28: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   31: invokestatic 55	com/google/android/gm/provider/MailEngine:access$600	(Lcom/google/android/gm/provider/MailEngine;)V
    //   34: aload_0
    //   35: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   38: getfield 32	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   41: invokevirtual 58	com/google/android/gm/provider/TransactionHelper:setTransactionSuccessful	()V
    //   44: aload_0
    //   45: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   48: getfield 32	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   51: invokevirtual 61	com/google/android/gm/provider/TransactionHelper:endTransaction	()V
    //   54: aload_0
    //   55: getfield 21	com/google/android/gm/provider/MailEngine$4:val$context	Landroid/content/Context;
    //   58: ldc 63
    //   60: invokevirtual 69	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   63: checkcast 71	android/os/PowerManager
    //   66: astore_1
    //   67: aload_1
    //   68: ifnull +28 -> 96
    //   71: aload_0
    //   72: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   75: aload_1
    //   76: iconst_1
    //   77: ldc 73
    //   79: invokevirtual 77	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   82: putfield 81	com/google/android/gm/provider/MailEngine:mProviderChangedBroadcastWakeLock	Landroid/os/PowerManager$WakeLock;
    //   85: aload_0
    //   86: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   89: getfield 81	com/google/android/gm/provider/MailEngine:mProviderChangedBroadcastWakeLock	Landroid/os/PowerManager$WakeLock;
    //   92: iconst_0
    //   93: invokevirtual 87	android/os/PowerManager$WakeLock:setReferenceCounted	(Z)V
    //   96: aload_0
    //   97: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   100: invokestatic 90	com/google/android/gm/provider/MailEngine:access$700	(Lcom/google/android/gm/provider/MailEngine;)V
    //   103: aload_0
    //   104: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   107: invokestatic 94	com/google/android/gm/provider/MailEngine:access$800	(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;
    //   110: getfield 100	android/accounts/Account:name	Ljava/lang/String;
    //   113: aload_0
    //   114: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   117: invokestatic 104	com/google/android/gm/provider/MailEngine:access$900	(Lcom/google/android/gm/provider/MailEngine;)Landroid/database/Cursor;
    //   120: invokestatic 110	com/google/android/gm/utils/LabelColorUtils:instantiateCustomLabelColors	(Ljava/lang/String;Landroid/database/Cursor;)V
    //   123: aload_0
    //   124: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   127: invokestatic 94	com/google/android/gm/provider/MailEngine:access$800	(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;
    //   130: getfield 100	android/accounts/Account:name	Ljava/lang/String;
    //   133: invokestatic 116	com/google/android/gm/provider/UiProvider:getAccountUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   136: astore_1
    //   137: aload_1
    //   138: aload_0
    //   139: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   142: getfield 46	com/google/android/gm/provider/MailEngine:mMailCore	Lcom/google/android/gm/provider/MailCore;
    //   145: invokevirtual 120	com/google/android/gm/provider/MailCore:getCursorForCustomFrom	()Landroid/database/Cursor;
    //   148: invokestatic 126	com/google/android/gm/utils/CustomFromUtils:instantiateCustomFrom	(Landroid/net/Uri;Landroid/database/Cursor;)V
    //   151: aload_1
    //   152: aload_0
    //   153: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   156: invokestatic 129	com/google/android/gm/provider/MailEngine:access$1000	(Lcom/google/android/gm/provider/MailEngine;)Landroid/database/Cursor;
    //   159: invokestatic 132	com/google/android/gm/utils/CustomFromUtils:instantiateReplyFromDefaultAddress	(Landroid/net/Uri;Landroid/database/Cursor;)V
    //   162: aload_0
    //   163: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   166: invokestatic 135	com/google/android/gm/provider/MailEngine:access$1100	(Lcom/google/android/gm/provider/MailEngine;)V
    //   169: ldc -119
    //   171: invokestatic 143	com/google/android/gm/perf/Timer:stopTiming	(Ljava/lang/String;)V
    //   174: return
    //   175: astore_1
    //   176: aload_0
    //   177: getfield 19	com/google/android/gm/provider/MailEngine$4:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   180: getfield 32	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   183: invokevirtual 61	com/google/android/gm/provider/TransactionHelper:endTransaction	()V
    //   186: aload_1
    //   187: athrow
    //   188: astore_1
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	4
    //   66	86	1	localObject1	Object
    //   175	12	1	localObject2	Object
    //   188	2	1	localSQLException	android.database.SQLException
    // Exception table:
    //   from	to	target	type
    //   17	44	175	finally
    //   0	17	188	android/database/SQLException
    //   44	54	188	android/database/SQLException
    //   176	188	188	android/database/SQLException
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */