import javax.crypto.spec.IvParameterSpec;

public final class dpx
{
  public static byte[] a = null;
  public static IvParameterSpec b;
  private static final String c = cvl.a;
  
  /* Error */
  public static byte[] a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	dpx:a	[B
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +56 -> 64
    //   11: invokestatic 29	gnj:apply	()V
    //   14: ldc 31
    //   16: invokestatic 37	javax/crypto/KeyGenerator:getInstance	(Ljava/lang/String;)Ljavax/crypto/KeyGenerator;
    //   19: astore_0
    //   20: new 39	java/security/SecureRandom
    //   23: dup
    //   24: invokespecial 42	java/security/SecureRandom:<init>	()V
    //   27: astore_1
    //   28: aload_0
    //   29: sipush 128
    //   32: aload_1
    //   33: invokevirtual 46	javax/crypto/KeyGenerator:init	(ILjava/security/SecureRandom;)V
    //   36: aload_0
    //   37: invokevirtual 50	javax/crypto/KeyGenerator:generateKey	()Ljavax/crypto/SecretKey;
    //   40: invokeinterface 55 1 0
    //   45: putstatic 20	dpx:a	[B
    //   48: new 57	javax/crypto/spec/IvParameterSpec
    //   51: dup
    //   52: aload_1
    //   53: bipush 16
    //   55: invokevirtual 61	java/security/SecureRandom:generateSeed	(I)[B
    //   58: invokespecial 64	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   61: putstatic 66	dpx:b	Ljavax/crypto/spec/IvParameterSpec;
    //   64: getstatic 20	dpx:a	[B
    //   67: astore_0
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_0
    //   72: areturn
    //   73: astore_0
    //   74: getstatic 18	dpx:c	Ljava/lang/String;
    //   77: aload_0
    //   78: ldc 68
    //   80: iconst_0
    //   81: anewarray 4	java/lang/Object
    //   84: invokestatic 74	dri:f	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   87: pop
    //   88: goto -74 -> 14
    //   91: astore_0
    //   92: ldc 2
    //   94: monitorexit
    //   95: aload_0
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	66	0	localObject1	Object
    //   73	5	0	localSecurityException	SecurityException
    //   91	5	0	localObject2	Object
    //   27	26	1	localSecureRandom	java.security.SecureRandom
    // Exception table:
    //   from	to	target	type
    //   11	14	73	java/lang/SecurityException
    //   3	7	91	finally
    //   11	14	91	finally
    //   14	64	91	finally
    //   64	68	91	finally
    //   74	88	91	finally
  }
}

/* Location:
 * Qualified Name:     dpx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */