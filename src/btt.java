import android.util.Pair;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class btt
{
  final Queue<Pair<Long, String>> a = new LinkedList();
  int b = 0;
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	btt:b	I
    //   6: bipush 50
    //   8: if_icmpne +40 -> 48
    //   11: aload_0
    //   12: getfield 18	btt:a	Ljava/util/Queue;
    //   15: invokeinterface 28 1 0
    //   20: pop
    //   21: aload_0
    //   22: getfield 18	btt:a	Ljava/util/Queue;
    //   25: new 30	android/util/Pair
    //   28: dup
    //   29: invokestatic 36	java/lang/System:currentTimeMillis	()J
    //   32: invokestatic 42	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   35: aload_1
    //   36: invokespecial 45	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   39: invokeinterface 49 2 0
    //   44: pop
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: aload_0
    //   50: getfield 20	btt:b	I
    //   53: iconst_1
    //   54: iadd
    //   55: putfield 20	btt:b	I
    //   58: goto -37 -> 21
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	btt
    //   0	66	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	21	61	finally
    //   21	45	61	finally
    //   48	58	61	finally
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      Date localDate = new Date(((Long)first).longValue());
      localStringBuilder.append(String.format("%d-%d %d:%d:%d: ", new Object[] { Integer.valueOf(localDate.getDay()), Integer.valueOf(localDate.getMonth()), Integer.valueOf(localDate.getHours()), Integer.valueOf(localDate.getMinutes()), Integer.valueOf(localDate.getSeconds()) }));
      localStringBuilder.append((String)second);
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     btt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */