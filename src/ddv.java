import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ddv
{
  private final Matcher a = Pattern.compile("\\W").matcher("");
  private final Matcher b;
  private final List<ddt> c = new ArrayList();
  
  public ddv(ddt[] paramArrayOfddt)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfddt.length;
    int i = 0;
    while (i < j)
    {
      ddt localddt = paramArrayOfddt[i];
      c.add(localddt);
      a.reset(d);
      localArrayList.add(a.replaceAll("\\\\$0"));
      if (Log.isLoggable("RuleMatcher", 2)) {
        String.format("Added %s rule for prefix %s", new Object[] { c, d });
      }
      i += 1;
    }
    b = Pattern.compile(String.format("(%s)", new Object[] { TextUtils.join(")|(", localArrayList) })).matcher("");
    if (b.groupCount() != c.size()) {
      Log.wtf("RuleMatcher", "Capture group / rule count mismatch");
    }
  }
  
  /* Error */
  public final ddt a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	ddv:b	Ljava/util/regex/Matcher;
    //   6: aload_1
    //   7: invokevirtual 53	java/util/regex/Matcher:reset	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 108	java/util/regex/Matcher:lookingAt	()Z
    //   15: ifeq +53 -> 68
    //   18: iconst_0
    //   19: istore_2
    //   20: iload_2
    //   21: aload_0
    //   22: getfield 36	ddv:c	Ljava/util/List;
    //   25: invokeinterface 96 1 0
    //   30: if_icmpge +38 -> 68
    //   33: aload_1
    //   34: iload_2
    //   35: iconst_1
    //   36: iadd
    //   37: invokevirtual 112	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   40: ifnull +21 -> 61
    //   43: aload_0
    //   44: getfield 36	ddv:c	Ljava/util/List;
    //   47: iload_2
    //   48: invokeinterface 116 2 0
    //   53: checkcast 44	ddt
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: areturn
    //   61: iload_2
    //   62: iconst_1
    //   63: iadd
    //   64: istore_2
    //   65: goto -45 -> 20
    //   68: aconst_null
    //   69: astore_1
    //   70: goto -13 -> 57
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	ddv
    //   0	78	1	paramString	String
    //   19	46	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	18	73	finally
    //   20	57	73	finally
  }
}

/* Location:
 * Qualified Name:     ddv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */