import android.os.ParcelFileDescriptor;
import java.util.concurrent.Callable;

final class ggv
  implements Callable<Boolean>
{
  ggv(ggu paramggu, ParcelFileDescriptor paramParcelFileDescriptor, byte[] paramArrayOfByte) {}
  
  /* Error */
  private final Boolean a()
  {
    // Byte code:
    //   0: ldc 30
    //   2: iconst_3
    //   3: invokestatic 36	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   6: ifeq +20 -> 26
    //   9: new 38	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 40
    //   15: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 19	ggv:a	Landroid/os/ParcelFileDescriptor;
    //   22: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: new 49	android/os/ParcelFileDescriptor$AutoCloseOutputStream
    //   29: dup
    //   30: aload_0
    //   31: getfield 19	ggv:a	Landroid/os/ParcelFileDescriptor;
    //   34: invokespecial 52	android/os/ParcelFileDescriptor$AutoCloseOutputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   37: astore_1
    //   38: aload_1
    //   39: aload_0
    //   40: getfield 21	ggv:b	[B
    //   43: invokevirtual 56	android/os/ParcelFileDescriptor$AutoCloseOutputStream:write	([B)V
    //   46: aload_1
    //   47: invokevirtual 59	android/os/ParcelFileDescriptor$AutoCloseOutputStream:flush	()V
    //   50: ldc 30
    //   52: iconst_3
    //   53: invokestatic 36	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   56: ifeq +20 -> 76
    //   59: new 38	java/lang/StringBuilder
    //   62: dup
    //   63: ldc 61
    //   65: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 19	ggv:a	Landroid/os/ParcelFileDescriptor;
    //   72: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: iconst_1
    //   77: invokestatic 67	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: astore_2
    //   81: ldc 30
    //   83: iconst_3
    //   84: invokestatic 36	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   87: ifeq +20 -> 107
    //   90: new 38	java/lang/StringBuilder
    //   93: dup
    //   94: ldc 69
    //   96: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 19	ggv:a	Landroid/os/ParcelFileDescriptor;
    //   103: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_1
    //   108: invokevirtual 72	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
    //   111: aload_2
    //   112: areturn
    //   113: astore_2
    //   114: ldc 30
    //   116: new 38	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 74
    //   122: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload_0
    //   126: getfield 19	ggv:a	Landroid/os/ParcelFileDescriptor;
    //   129: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 82	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   138: pop
    //   139: ldc 30
    //   141: iconst_3
    //   142: invokestatic 36	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   145: ifeq +20 -> 165
    //   148: new 38	java/lang/StringBuilder
    //   151: dup
    //   152: ldc 69
    //   154: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload_0
    //   158: getfield 19	ggv:a	Landroid/os/ParcelFileDescriptor;
    //   161: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_1
    //   166: invokevirtual 72	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
    //   169: iconst_0
    //   170: invokestatic 67	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   173: areturn
    //   174: astore_2
    //   175: ldc 30
    //   177: iconst_3
    //   178: invokestatic 36	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   181: ifeq +20 -> 201
    //   184: new 38	java/lang/StringBuilder
    //   187: dup
    //   188: ldc 69
    //   190: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: aload_0
    //   194: getfield 19	ggv:a	Landroid/os/ParcelFileDescriptor;
    //   197: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_1
    //   202: invokevirtual 72	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
    //   205: aload_2
    //   206: athrow
    //   207: astore_1
    //   208: goto -3 -> 205
    //   211: astore_1
    //   212: goto -43 -> 169
    //   215: astore_1
    //   216: aload_2
    //   217: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	ggv
    //   37	165	1	localAutoCloseOutputStream	android.os.ParcelFileDescriptor.AutoCloseOutputStream
    //   207	1	1	localIOException1	java.io.IOException
    //   211	1	1	localIOException2	java.io.IOException
    //   215	1	1	localIOException3	java.io.IOException
    //   80	32	2	localBoolean1	Boolean
    //   113	1	2	localIOException4	java.io.IOException
    //   174	43	2	localBoolean2	Boolean
    // Exception table:
    //   from	to	target	type
    //   38	76	113	java/io/IOException
    //   76	81	113	java/io/IOException
    //   38	76	174	finally
    //   76	81	174	finally
    //   114	139	174	finally
    //   175	201	207	java/io/IOException
    //   201	205	207	java/io/IOException
    //   139	165	211	java/io/IOException
    //   165	169	211	java/io/IOException
    //   81	107	215	java/io/IOException
    //   107	111	215	java/io/IOException
  }
}

/* Location:
 * Qualified Name:     ggv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */