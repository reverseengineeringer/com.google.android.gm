import android.os.Debug.MemoryInfo;
import android.util.Log;
import java.lang.reflect.Method;

public final class gmu
{
  private static boolean a;
  private static Method b;
  
  public static int a(Debug.MemoryInfo paramMemoryInfo)
  {
    Method localMethod = a();
    if (localMethod != null) {}
    try
    {
      int i = ((Integer)localMethod.invoke(paramMemoryInfo, new Object[] { Integer.valueOf(14) })).intValue();
      return i;
    }
    catch (Exception paramMemoryInfo)
    {
      b = null;
      Log.e("PrimesMemoryCapture", "MemoryInfo.getOtherPss(which) invocation failure", paramMemoryInfo);
      return -1;
    }
    catch (Error paramMemoryInfo)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  private static Method a()
  {
    // Byte code:
    //   0: getstatic 53	gmu:a	Z
    //   3: ifne +41 -> 44
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 53	gmu:a	Z
    //   12: istore_0
    //   13: iload_0
    //   14: ifne +27 -> 41
    //   17: ldc 55
    //   19: ldc 57
    //   21: iconst_1
    //   22: anewarray 59	java/lang/Class
    //   25: dup
    //   26: iconst_0
    //   27: getstatic 63	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   30: aastore
    //   31: invokevirtual 67	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   34: putstatic 39	gmu:b	Ljava/lang/reflect/Method;
    //   37: iconst_1
    //   38: putstatic 53	gmu:a	Z
    //   41: ldc 2
    //   43: monitorexit
    //   44: getstatic 39	gmu:b	Ljava/lang/reflect/Method;
    //   47: areturn
    //   48: astore_1
    //   49: ldc 41
    //   51: ldc 69
    //   53: aload_1
    //   54: invokestatic 49	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   57: pop
    //   58: goto -21 -> 37
    //   61: astore_1
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: goto -19 -> 49
    //   71: astore_1
    //   72: goto -35 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	2	0	bool	boolean
    //   48	6	1	localException	Exception
    //   61	5	1	localObject	Object
    //   67	1	1	localError	Error
    //   71	1	1	localNoSuchMethodException	NoSuchMethodException
    // Exception table:
    //   from	to	target	type
    //   17	37	48	java/lang/Exception
    //   9	13	61	finally
    //   17	37	61	finally
    //   37	41	61	finally
    //   41	44	61	finally
    //   49	58	61	finally
    //   62	65	61	finally
    //   17	37	67	java/lang/Error
    //   17	37	71	java/lang/NoSuchMethodException
  }
}

/* Location:
 * Qualified Name:     gmu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */