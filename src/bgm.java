import android.os.AsyncTask;

final class bgm
  extends AsyncTask<Void, Void, Void>
{
  bgm(bgl parambgl) {}
  
  /* Error */
  private final Void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 11	bgm:a	Lbgl;
    //   4: getfield 25	bgl:a	Lbgj;
    //   7: getfield 31	bgj:h	Lbgn;
    //   10: invokeinterface 35 1 0
    //   15: aload_0
    //   16: getfield 11	bgm:a	Lbgl;
    //   19: getfield 25	bgl:a	Lbgj;
    //   22: getfield 39	bgj:f	Landroid/content/Context;
    //   25: aload_0
    //   26: getfield 11	bgm:a	Lbgl;
    //   29: getfield 25	bgl:a	Lbgj;
    //   32: getfield 43	bgj:i	Landroid/content/ServiceConnection;
    //   35: invokevirtual 49	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   38: aload_0
    //   39: getfield 11	bgm:a	Lbgl;
    //   42: getfield 25	bgl:a	Lbgj;
    //   45: getfield 43	bgj:i	Landroid/content/ServiceConnection;
    //   48: astore_1
    //   49: aload_1
    //   50: monitorenter
    //   51: aload_0
    //   52: getfield 11	bgm:a	Lbgl;
    //   55: getfield 25	bgl:a	Lbgj;
    //   58: iconst_1
    //   59: putfield 53	bgj:k	Z
    //   62: aload_0
    //   63: getfield 11	bgm:a	Lbgl;
    //   66: getfield 25	bgl:a	Lbgj;
    //   69: getfield 43	bgj:i	Landroid/content/ServiceConnection;
    //   72: invokevirtual 58	java/lang/Object:notify	()V
    //   75: aload_1
    //   76: monitorexit
    //   77: aconst_null
    //   78: areturn
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 11	bgm:a	Lbgl;
    //   84: getfield 25	bgl:a	Lbgj;
    //   87: getfield 62	bgj:e	Ljava/lang/String;
    //   90: aload_1
    //   91: ldc 64
    //   93: iconst_0
    //   94: anewarray 55	java/lang/Object
    //   97: invokestatic 69	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   100: pop
    //   101: goto -63 -> 38
    //   104: astore_1
    //   105: aload_0
    //   106: getfield 11	bgm:a	Lbgl;
    //   109: getfield 25	bgl:a	Lbgj;
    //   112: getfield 62	bgj:e	Ljava/lang/String;
    //   115: aload_1
    //   116: ldc 71
    //   118: iconst_0
    //   119: anewarray 55	java/lang/Object
    //   122: invokestatic 69	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   125: pop
    //   126: aload_0
    //   127: getfield 11	bgm:a	Lbgl;
    //   130: getfield 25	bgl:a	Lbgj;
    //   133: getfield 39	bgj:f	Landroid/content/Context;
    //   136: aload_0
    //   137: getfield 11	bgm:a	Lbgl;
    //   140: getfield 25	bgl:a	Lbgj;
    //   143: getfield 43	bgj:i	Landroid/content/ServiceConnection;
    //   146: invokevirtual 49	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   149: goto -111 -> 38
    //   152: astore_1
    //   153: aload_0
    //   154: getfield 11	bgm:a	Lbgl;
    //   157: getfield 25	bgl:a	Lbgj;
    //   160: getfield 62	bgj:e	Ljava/lang/String;
    //   163: aload_1
    //   164: ldc 64
    //   166: iconst_0
    //   167: anewarray 55	java/lang/Object
    //   170: invokestatic 69	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   173: pop
    //   174: goto -136 -> 38
    //   177: astore_1
    //   178: aload_0
    //   179: getfield 11	bgm:a	Lbgl;
    //   182: getfield 25	bgl:a	Lbgj;
    //   185: getfield 39	bgj:f	Landroid/content/Context;
    //   188: aload_0
    //   189: getfield 11	bgm:a	Lbgl;
    //   192: getfield 25	bgl:a	Lbgj;
    //   195: getfield 43	bgj:i	Landroid/content/ServiceConnection;
    //   198: invokevirtual 49	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   201: aload_1
    //   202: athrow
    //   203: astore_2
    //   204: aload_0
    //   205: getfield 11	bgm:a	Lbgl;
    //   208: getfield 25	bgl:a	Lbgj;
    //   211: getfield 62	bgj:e	Ljava/lang/String;
    //   214: aload_2
    //   215: ldc 64
    //   217: iconst_0
    //   218: anewarray 55	java/lang/Object
    //   221: invokestatic 69	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   224: pop
    //   225: goto -24 -> 201
    //   228: astore_2
    //   229: aload_1
    //   230: monitorexit
    //   231: aload_2
    //   232: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	bgm
    //   79	12	1	localRuntimeException1	RuntimeException
    //   104	12	1	localRemoteException	android.os.RemoteException
    //   152	12	1	localRuntimeException2	RuntimeException
    //   177	53	1	localObject1	Object
    //   203	12	2	localRuntimeException3	RuntimeException
    //   228	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	38	79	java/lang/RuntimeException
    //   0	15	104	android/os/RemoteException
    //   126	149	152	java/lang/RuntimeException
    //   0	15	177	finally
    //   105	126	177	finally
    //   178	201	203	java/lang/RuntimeException
    //   51	77	228	finally
    //   229	231	228	finally
  }
}

/* Location:
 * Qualified Name:     bgm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */