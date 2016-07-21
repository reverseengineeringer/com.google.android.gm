import java.io.FilterInputStream;
import java.io.InputStream;

final class ddp
  extends FilterInputStream
{
  public ddp(ddo paramddo, InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  /* Error */
  public final void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 18	java/io/FilterInputStream:close	()V
    //   4: invokestatic 24	android/os/SystemClock:elapsedRealtime	()J
    //   7: lstore_1
    //   8: aload_0
    //   9: getfield 10	ddp:a	Lddo;
    //   12: getfield 30	ddo:f	J
    //   15: lstore_3
    //   16: aload_0
    //   17: getfield 10	ddp:a	Lddo;
    //   20: getfield 34	ddo:b	I
    //   23: invokestatic 40	android/net/TrafficStats:getUidTxBytes	(I)J
    //   26: lstore 5
    //   28: aload_0
    //   29: getfield 10	ddp:a	Lddo;
    //   32: getfield 34	ddo:b	I
    //   35: invokestatic 43	android/net/TrafficStats:getUidRxBytes	(I)J
    //   38: lstore 7
    //   40: ldc 44
    //   42: iconst_5
    //   43: anewarray 46	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_0
    //   49: getfield 10	ddp:a	Lddo;
    //   52: getfield 49	ddo:a	Ljava/lang/String;
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: aload_0
    //   59: getfield 10	ddp:a	Lddo;
    //   62: getfield 52	ddo:e	J
    //   65: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   68: aastore
    //   69: dup
    //   70: iconst_2
    //   71: lload_1
    //   72: lload_3
    //   73: lsub
    //   74: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   77: aastore
    //   78: dup
    //   79: iconst_3
    //   80: lload 5
    //   82: aload_0
    //   83: getfield 10	ddp:a	Lddo;
    //   86: getfield 61	ddo:c	J
    //   89: lsub
    //   90: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   93: aastore
    //   94: dup
    //   95: iconst_4
    //   96: lload 7
    //   98: aload_0
    //   99: getfield 10	ddp:a	Lddo;
    //   102: getfield 64	ddo:d	J
    //   105: lsub
    //   106: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   109: aastore
    //   110: invokestatic 70	android/util/EventLog:writeEvent	(I[Ljava/lang/Object;)I
    //   113: pop
    //   114: return
    //   115: astore 9
    //   117: invokestatic 24	android/os/SystemClock:elapsedRealtime	()J
    //   120: lstore_1
    //   121: aload_0
    //   122: getfield 10	ddp:a	Lddo;
    //   125: getfield 30	ddo:f	J
    //   128: lstore_3
    //   129: aload_0
    //   130: getfield 10	ddp:a	Lddo;
    //   133: getfield 34	ddo:b	I
    //   136: invokestatic 40	android/net/TrafficStats:getUidTxBytes	(I)J
    //   139: lstore 5
    //   141: aload_0
    //   142: getfield 10	ddp:a	Lddo;
    //   145: getfield 34	ddo:b	I
    //   148: invokestatic 43	android/net/TrafficStats:getUidRxBytes	(I)J
    //   151: lstore 7
    //   153: ldc 44
    //   155: iconst_5
    //   156: anewarray 46	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_0
    //   162: getfield 10	ddp:a	Lddo;
    //   165: getfield 49	ddo:a	Ljava/lang/String;
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: aload_0
    //   172: getfield 10	ddp:a	Lddo;
    //   175: getfield 52	ddo:e	J
    //   178: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   181: aastore
    //   182: dup
    //   183: iconst_2
    //   184: lload_1
    //   185: lload_3
    //   186: lsub
    //   187: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   190: aastore
    //   191: dup
    //   192: iconst_3
    //   193: lload 5
    //   195: aload_0
    //   196: getfield 10	ddp:a	Lddo;
    //   199: getfield 61	ddo:c	J
    //   202: lsub
    //   203: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   206: aastore
    //   207: dup
    //   208: iconst_4
    //   209: lload 7
    //   211: aload_0
    //   212: getfield 10	ddp:a	Lddo;
    //   215: getfield 64	ddo:d	J
    //   218: lsub
    //   219: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   222: aastore
    //   223: invokestatic 70	android/util/EventLog:writeEvent	(I[Ljava/lang/Object;)I
    //   226: pop
    //   227: aload 9
    //   229: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	ddp
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

/* Location:
 * Qualified Name:     ddp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */