import java.net.HttpURLConnection;

final class gsn
  extends gsd
{
  private final HttpURLConnection e;
  
  gsn(HttpURLConnection paramHttpURLConnection)
  {
    e = paramHttpURLConnection;
    paramHttpURLConnection.setInstanceFollowRedirects(false);
  }
  
  /* Error */
  public final gse a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	gsn:e	Ljava/net/HttpURLConnection;
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 26	gsd:d	Lguq;
    //   10: ifnull +139 -> 149
    //   13: aload_0
    //   14: getfield 30	gsd:c	Ljava/lang/String;
    //   17: astore 5
    //   19: aload 5
    //   21: ifnull +11 -> 32
    //   24: aload_0
    //   25: ldc 32
    //   27: aload 5
    //   29: invokevirtual 35	gsn:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 38	gsd:b	Ljava/lang/String;
    //   36: astore 5
    //   38: aload 5
    //   40: ifnull +11 -> 51
    //   43: aload_0
    //   44: ldc 40
    //   46: aload 5
    //   48: invokevirtual 35	gsn:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_0
    //   52: getfield 43	gsd:a	J
    //   55: lstore_2
    //   56: lload_2
    //   57: lconst_0
    //   58: lcmp
    //   59: iflt +13 -> 72
    //   62: aload_0
    //   63: ldc 45
    //   65: lload_2
    //   66: invokestatic 51	java/lang/Long:toString	(J)Ljava/lang/String;
    //   69: invokevirtual 35	gsn:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload 4
    //   74: invokevirtual 55	java/net/HttpURLConnection:getRequestMethod	()Ljava/lang/String;
    //   77: astore 5
    //   79: ldc 57
    //   81: aload 5
    //   83: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifne +13 -> 99
    //   89: ldc 65
    //   91: aload 5
    //   93: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   96: ifeq +91 -> 187
    //   99: aload 4
    //   101: iconst_1
    //   102: invokevirtual 68	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   105: lload_2
    //   106: lconst_0
    //   107: lcmp
    //   108: iflt +60 -> 168
    //   111: lload_2
    //   112: ldc2_w 69
    //   115: lcmp
    //   116: ifgt +52 -> 168
    //   119: aload 4
    //   121: lload_2
    //   122: l2i
    //   123: invokevirtual 74	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   126: aload 4
    //   128: invokevirtual 78	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   131: astore 5
    //   133: aload_0
    //   134: getfield 26	gsd:d	Lguq;
    //   137: aload 5
    //   139: invokeinterface 83 2 0
    //   144: aload 5
    //   146: invokevirtual 88	java/io/OutputStream:close	()V
    //   149: aload 4
    //   151: invokevirtual 91	java/net/HttpURLConnection:connect	()V
    //   154: new 93	gso
    //   157: dup
    //   158: aload 4
    //   160: invokespecial 95	gso:<init>	(Ljava/net/HttpURLConnection;)V
    //   163: astore 5
    //   165: aload 5
    //   167: areturn
    //   168: aload 4
    //   170: iconst_0
    //   171: invokevirtual 98	java/net/HttpURLConnection:setChunkedStreamingMode	(I)V
    //   174: goto -48 -> 126
    //   177: astore 4
    //   179: aload 5
    //   181: invokevirtual 88	java/io/OutputStream:close	()V
    //   184: aload 4
    //   186: athrow
    //   187: lload_2
    //   188: lconst_0
    //   189: lcmp
    //   190: ifne +31 -> 221
    //   193: iconst_1
    //   194: istore_1
    //   195: iload_1
    //   196: ifne -47 -> 149
    //   199: new 100	java/lang/IllegalArgumentException
    //   202: dup
    //   203: ldc 102
    //   205: iconst_1
    //   206: anewarray 104	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: aload 5
    //   213: aastore
    //   214: invokestatic 109	hbe:a	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   217: invokespecial 112	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   220: athrow
    //   221: iconst_0
    //   222: istore_1
    //   223: goto -28 -> 195
    //   226: astore 5
    //   228: aload 4
    //   230: invokevirtual 115	java/net/HttpURLConnection:disconnect	()V
    //   233: aload 5
    //   235: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	gsn
    //   194	29	1	i	int
    //   55	133	2	l	long
    //   4	165	4	localHttpURLConnection	HttpURLConnection
    //   177	52	4	localObject1	Object
    //   17	195	5	localObject2	Object
    //   226	8	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   133	144	177	finally
    //   149	165	226	finally
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    e.setReadTimeout(paramInt2);
    e.setConnectTimeout(paramInt1);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    e.addRequestProperty(paramString1, paramString2);
  }
}

/* Location:
 * Qualified Name:     gsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */