package com.google.android.gm.provider;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class MailEngine$MessageCursorLogic
  extends MailEngine.NetworkCursorLogic
{
  boolean mConfigured = false;
  final long mConversationId;
  
  MailEngine$MessageCursorLogic(MailEngine paramMailEngine, long paramLong)
  {
    super(paramMailEngine);
    mConversationId = paramLong;
  }
  
  public void configure(long paramLong, MailEngine.NetworkCursor paramNetworkCursor, boolean paramBoolean)
  {
    ??? = Long.toString(mQueryId);
    mConfigured = true;
    if (DatabaseUtils.longForQuery(this$0.mDb, "SELECT COUNT(*) FROM conversations WHERE _id = ?", new String[] { Long.toString(paramLong) }) <= 0L) {
      LogUtils.e("Gmail", "Didn't find conversation entry for this conversation", new Object[0]);
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while (DatabaseUtils.longForQuery(this$0.mDb, "SELECT COUNT(*) FROM messages WHERE conversation = ? AND queryId = ?", new String[] { Long.toString(paramLong), ??? }) > 0L);
    } while (DatabaseUtils.longForQuery(this$0.mDb, "SELECT COUNT(*) FROM messages WHERE conversation = ? AND queryId = 0", new String[] { Long.toString(paramLong) }) != 0L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("queryId NOT IN (0");
    synchronized (MailEngine.access$4500(this$0))
    {
      Iterator localIterator = MailEngine.access$4600(this$0).keySet().iterator();
      if (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        localStringBuilder.append(", ");
        localStringBuilder.append(access$4600this$0).get(localLong)).mQueryId);
      }
    }
    localStringBuilder.append(")");
    if (this$0.mDb.delete("messages", localStringBuilder.toString(), null) != 0) {
      paramNetworkCursor.requery();
    }
    startThread();
  }
  
  public Bundle respond(Bundle arg1)
  {
    for (;;)
    {
      try
      {
        String str = ???.getString("command");
        Bundle localBundle = new Bundle();
        if ("setVisible".equals(str))
        {
          if (!???.getBoolean("visible")) {}
          synchronized (MailEngine.access$4500(this$0))
          {
            MailEngine.access$4600(this$0).remove(Long.valueOf(mConversationId));
            localBundle.putString("commandResponse", "ok");
            ??? = localBundle;
            return (Bundle)???;
          }
        }
        ??? = super.respond(???);
      }
      finally {}
    }
  }
  
  /* Error */
  public void runInternal()
    throws java.io.IOException, MailEngine.AuthenticationException, MailSync.ResponseParseException
  {
    // Byte code:
    //   0: new 186	com/google/android/gm/provider/MailSync$ConversationInfo
    //   3: dup
    //   4: aload_0
    //   5: getfield 24	com/google/android/gm/provider/MailEngine$MessageCursorLogic:mConversationId	J
    //   8: lconst_0
    //   9: invokespecial 189	com/google/android/gm/provider/MailSync$ConversationInfo:<init>	(JJ)V
    //   12: astore_1
    //   13: ldc 52
    //   15: ldc -65
    //   17: iconst_1
    //   18: anewarray 56	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: aload_0
    //   24: getfield 24	com/google/android/gm/provider/MailEngine$MessageCursorLogic:mConversationId	J
    //   27: invokestatic 164	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   30: aastore
    //   31: invokestatic 194	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   34: pop
    //   35: invokestatic 199	com/google/android/gm/provider/Gmail:isRunningICSOrLater	()Z
    //   38: ifeq +22 -> 60
    //   41: aload_0
    //   42: getfield 17	com/google/android/gm/provider/MailEngine$MessageCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   45: invokestatic 203	com/google/android/gm/provider/MailEngine:access$800	(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;
    //   48: getfield 209	android/accounts/Account:name	Ljava/lang/String;
    //   51: invokestatic 215	com/google/android/common/GoogleTrafficStats:getDomainType	(Ljava/lang/String;)I
    //   54: ldc -40
    //   56: ior
    //   57: invokestatic 222	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   60: aload_0
    //   61: getfield 17	com/google/android/gm/provider/MailEngine$MessageCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   64: getfield 226	com/google/android/gm/provider/MailEngine:mMailSync	Lcom/google/android/gm/provider/MailSync;
    //   67: aload_1
    //   68: invokevirtual 232	com/google/android/gm/provider/MailSync:newFetchConversationRequest	(Lcom/google/android/gm/provider/MailSync$ConversationInfo;)Lorg/apache/http/client/methods/HttpUriRequest;
    //   71: astore_1
    //   72: aload_0
    //   73: getfield 17	com/google/android/gm/provider/MailEngine$MessageCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   76: aload_1
    //   77: invokestatic 236	com/google/android/gm/provider/MailEngine:access$4200	(Lcom/google/android/gm/provider/MailEngine;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   80: astore_2
    //   81: aload_0
    //   82: getfield 17	com/google/android/gm/provider/MailEngine$MessageCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   85: getfield 226	com/google/android/gm/provider/MailEngine:mMailSync	Lcom/google/android/gm/provider/MailSync;
    //   88: aload_2
    //   89: aload_0
    //   90: getfield 30	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mQueryId	J
    //   93: invokevirtual 240	com/google/android/gm/provider/MailSync:handleFetchConversationResponse	(Lorg/apache/http/HttpResponse;J)V
    //   96: aload_2
    //   97: invokeinterface 246 1 0
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull +9 -> 113
    //   107: aload_1
    //   108: invokeinterface 251 1 0
    //   113: ldc 52
    //   115: ldc -3
    //   117: iconst_0
    //   118: anewarray 56	java/lang/Object
    //   121: invokestatic 194	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   124: pop
    //   125: aload_0
    //   126: getfield 17	com/google/android/gm/provider/MailEngine$MessageCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   129: iconst_0
    //   130: invokestatic 257	com/google/android/gm/provider/MailEngine:access$3500	(Lcom/google/android/gm/provider/MailEngine;Z)V
    //   133: invokestatic 199	com/google/android/gm/provider/Gmail:isRunningICSOrLater	()Z
    //   136: ifeq +12 -> 148
    //   139: ldc -40
    //   141: iconst_1
    //   142: invokestatic 261	android/net/TrafficStats:incrementOperationCount	(II)V
    //   145: invokestatic 264	android/net/TrafficStats:clearThreadStatsTag	()V
    //   148: return
    //   149: astore_1
    //   150: aload_2
    //   151: invokeinterface 246 1 0
    //   156: astore_2
    //   157: aload_2
    //   158: ifnull +9 -> 167
    //   161: aload_2
    //   162: invokeinterface 251 1 0
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: invokestatic 199	com/google/android/gm/provider/Gmail:isRunningICSOrLater	()Z
    //   173: ifeq +12 -> 185
    //   176: ldc -40
    //   178: iconst_1
    //   179: invokestatic 261	android/net/TrafficStats:incrementOperationCount	(II)V
    //   182: invokestatic 264	android/net/TrafficStats:clearThreadStatsTag	()V
    //   185: aload_1
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	MessageCursorLogic
    //   12	96	1	localObject1	Object
    //   149	19	1	localObject2	Object
    //   169	17	1	localObject3	Object
    //   80	82	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   81	96	149	finally
    //   60	81	169	finally
    //   96	103	169	finally
    //   107	113	169	finally
    //   113	133	169	finally
    //   150	157	169	finally
    //   161	167	169	finally
    //   167	169	169	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.MessageCursorLogic
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */