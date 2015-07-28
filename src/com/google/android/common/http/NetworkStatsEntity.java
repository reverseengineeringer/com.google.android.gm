package com.google.android.common.http;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public class NetworkStatsEntity
  extends HttpEntityWrapper
{
  private final long mProcessingStartTime;
  private final long mResponseLatency;
  private final long mStartRx;
  private final long mStartTx;
  private final String mUa;
  private final int mUid;
  
  public NetworkStatsEntity(HttpEntity paramHttpEntity, String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    super(paramHttpEntity);
    mUa = paramString;
    mUid = paramInt;
    mStartTx = paramLong1;
    mStartRx = paramLong2;
    mResponseLatency = paramLong3;
    mProcessingStartTime = paramLong4;
  }
  
  public InputStream getContent()
    throws IOException
  {
    return new NetworkStatsInputStream(super.getContent());
  }
  
  private class NetworkStatsInputStream
    extends FilterInputStream
  {
    public NetworkStatsInputStream(InputStream paramInputStream)
    {
      super();
    }
    
    /* Error */
    public void close()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 23	java/io/FilterInputStream:close	()V
      //   4: invokestatic 29	android/os/SystemClock:elapsedRealtime	()J
      //   7: lstore_1
      //   8: aload_0
      //   9: getfield 13	com/google/android/common/http/NetworkStatsEntity$NetworkStatsInputStream:this$0	Lcom/google/android/common/http/NetworkStatsEntity;
      //   12: invokestatic 33	com/google/android/common/http/NetworkStatsEntity:access$000	(Lcom/google/android/common/http/NetworkStatsEntity;)J
      //   15: lstore_3
      //   16: aload_0
      //   17: getfield 13	com/google/android/common/http/NetworkStatsEntity$NetworkStatsInputStream:this$0	Lcom/google/android/common/http/NetworkStatsEntity;
      //   20: invokestatic 37	com/google/android/common/http/NetworkStatsEntity:access$100	(Lcom/google/android/common/http/NetworkStatsEntity;)I
      //   23: invokestatic 43	android/net/TrafficStats:getUidTxBytes	(I)J
      //   26: lstore 5
      //   28: aload_0
      //   29: getfield 13	com/google/android/common/http/NetworkStatsEntity$NetworkStatsInputStream:this$0	Lcom/google/android/common/http/NetworkStatsEntity;
      //   32: invokestatic 37	com/google/android/common/http/NetworkStatsEntity:access$100	(Lcom/google/android/common/http/NetworkStatsEntity;)I
      //   35: invokestatic 46	android/net/TrafficStats:getUidRxBytes	(I)J
      //   38: lstore 7
      //   40: ldc 47
      //   42: iconst_5
      //   43: anewarray 49	java/lang/Object
      //   46: dup
      //   47: iconst_0
      //   48: aload_0
      //   49: getfield 13	com/google/android/common/http/NetworkStatsEntity$NetworkStatsInputStream:this$0	Lcom/google/android/common/http/NetworkStatsEntity;
      //   52: invokestatic 53	com/google/android/common/http/NetworkStatsEntity:access$200	(Lcom/google/android/common/http/NetworkStatsEntity;)Ljava/lang/String;
      //   55: aastore
      //   56: dup
      //   57: iconst_1
      //   58: aload_0
      //   59: getfield 13	com/google/android/common/http/NetworkStatsEntity$NetworkStatsInputStream:this$0	Lcom/google/android/common/http/NetworkStatsEntity;
      //   62: invokestatic 56	com/google/android/common/http/NetworkStatsEntity:access$300	(Lcom/google/android/common/http/NetworkStatsEntity;)J
      //   65: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   68: aastore
      //   69: dup
      //   70: iconst_2
      //   71: lload_1
      //   72: lload_3
      //   73: lsub
      //   74: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   77: aastore
      //   78: dup
      //   79: iconst_3
      //   80: lload 5
      //   82: aload_0
      //   83: getfield 13	com/google/android/common/http/NetworkStatsEntity$NetworkStatsInputStream:this$0	Lcom/google/android/common/http/NetworkStatsEntity;
      //   86: invokestatic 65	com/google/android/common/http/NetworkStatsEntity:access$400	(Lcom/google/android/common/http/NetworkStatsEntity;)J
      //   89: lsub
      //   90: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   93: aastore
      //   94: dup
      //   95: iconst_4
      //   96: lload 7
      //   98: aload_0
      //   99: getfield 13	com/google/android/common/http/NetworkStatsEntity$NetworkStatsInputStream:this$0	Lcom/google/android/common/http/NetworkStatsEntity;
      //   102: invokestatic 68	com/google/android/common/http/NetworkStatsEntity:access$500	(Lcom/google/android/common/http/NetworkStatsEntity;)J
      //   105: lsub
      //   106: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   109: aastore
      //   110: invokestatic 74	android/util/EventLog:writeEvent	(I[Ljava/lang/Object;)I
      //   113: pop
      //   114: return
      //   115: astore 9
      //   117: invokestatic 29	android/os/SystemClock:elapsedRealtime	()J
      //   120: lstore_1
      //   121: aload_0
      //   122: getfield 13	com/google/android/common/http/NetworkStatsEntity$NetworkStatsInputStream:this$0	Lcom/google/android/common/http/NetworkStatsEntity;
      //   125: invokestatic 33	com/google/android/common/http/NetworkStatsEntity:access$000	(Lcom/google/android/common/http/NetworkStatsEntity;)J
      //   128: lstore_3
      //   129: aload_0
      //   130: getfield 13	com/google/android/common/http/NetworkStatsEntity$NetworkStatsInputStream:this$0	Lcom/google/android/common/http/NetworkStatsEntity;
      //   133: invokestatic 37	com/google/android/common/http/NetworkStatsEntity:access$100	(Lcom/google/android/common/http/NetworkStatsEntity;)I
      //   136: invokestatic 43	android/net/TrafficStats:getUidTxBytes	(I)J
      //   139: lstore 5
      //   141: aload_0
      //   142: getfield 13	com/google/android/common/http/NetworkStatsEntity$NetworkStatsInputStream:this$0	Lcom/google/android/common/http/NetworkStatsEntity;
      //   145: invokestatic 37	com/google/android/common/http/NetworkStatsEntity:access$100	(Lcom/google/android/common/http/NetworkStatsEntity;)I
      //   148: invokestatic 46	android/net/TrafficStats:getUidRxBytes	(I)J
      //   151: lstore 7
      //   153: ldc 47
      //   155: iconst_5
      //   156: anewarray 49	java/lang/Object
      //   159: dup
      //   160: iconst_0
      //   161: aload_0
      //   162: getfield 13	com/google/android/common/http/NetworkStatsEntity$NetworkStatsInputStream:this$0	Lcom/google/android/common/http/NetworkStatsEntity;
      //   165: invokestatic 53	com/google/android/common/http/NetworkStatsEntity:access$200	(Lcom/google/android/common/http/NetworkStatsEntity;)Ljava/lang/String;
      //   168: aastore
      //   169: dup
      //   170: iconst_1
      //   171: aload_0
      //   172: getfield 13	com/google/android/common/http/NetworkStatsEntity$NetworkStatsInputStream:this$0	Lcom/google/android/common/http/NetworkStatsEntity;
      //   175: invokestatic 56	com/google/android/common/http/NetworkStatsEntity:access$300	(Lcom/google/android/common/http/NetworkStatsEntity;)J
      //   178: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   181: aastore
      //   182: dup
      //   183: iconst_2
      //   184: lload_1
      //   185: lload_3
      //   186: lsub
      //   187: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   190: aastore
      //   191: dup
      //   192: iconst_3
      //   193: lload 5
      //   195: aload_0
      //   196: getfield 13	com/google/android/common/http/NetworkStatsEntity$NetworkStatsInputStream:this$0	Lcom/google/android/common/http/NetworkStatsEntity;
      //   199: invokestatic 65	com/google/android/common/http/NetworkStatsEntity:access$400	(Lcom/google/android/common/http/NetworkStatsEntity;)J
      //   202: lsub
      //   203: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   206: aastore
      //   207: dup
      //   208: iconst_4
      //   209: lload 7
      //   211: aload_0
      //   212: getfield 13	com/google/android/common/http/NetworkStatsEntity$NetworkStatsInputStream:this$0	Lcom/google/android/common/http/NetworkStatsEntity;
      //   215: invokestatic 68	com/google/android/common/http/NetworkStatsEntity:access$500	(Lcom/google/android/common/http/NetworkStatsEntity;)J
      //   218: lsub
      //   219: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   222: aastore
      //   223: invokestatic 74	android/util/EventLog:writeEvent	(I[Ljava/lang/Object;)I
      //   226: pop
      //   227: aload 9
      //   229: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	230	0	this	NetworkStatsInputStream
      //   7	178	1	l1	long
      //   15	171	3	l2	long
      //   26	168	5	l3	long
      //   38	172	7	l4	long
      //   115	113	9	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   0	4	115	finally
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.http.NetworkStatsEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */