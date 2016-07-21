import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public final class hsx
  extends ArrayList
  implements Serializable
{
  private static final long serialVersionUID = -1667481795613729889L;
  private final int a;
  private final int b;
  private final boolean c;
  
  public hsx()
  {
    this(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
  }
  
  public hsx(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramBoolean;
  }
  
  public hsx(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramInt1, paramInt2, paramBoolean);
    paramString = new StringTokenizer(paramString, ",");
    while (paramString.hasMoreTokens())
    {
      Integer localInteger = new Integer(icm.a(paramString.nextToken()));
      paramInt2 = localInteger.intValue();
      paramInt1 = paramInt2;
      if ((paramInt2 >> 31 | -paramInt2 >>> 31) < 0)
      {
        if (!c)
        {
          paramString = String.valueOf(localInteger);
          throw new IllegalArgumentException(String.valueOf(paramString).length() + 28 + "Negative value not allowed: " + paramString);
        }
        paramInt1 = Math.abs(paramInt2);
      }
      if ((paramInt1 < a) || (paramInt1 > b))
      {
        paramInt1 = a;
        paramInt2 = b;
        paramString = String.valueOf(localInteger);
        throw new IllegalArgumentException(String.valueOf(paramString).length() + 47 + "Value not in range [" + paramInt1 + ".." + paramInt2 + "]: " + paramString);
      }
      add(localInteger);
    }
  }
  
  public final boolean add(Object paramObject)
  {
    if (!(paramObject instanceof Integer))
    {
      paramObject = String.valueOf(Integer.class.getName());
      if (((String)paramObject).length() != 0) {}
      for (paramObject = "Argument not a ".concat((String)paramObject);; paramObject = new String("Argument not a ")) {
        throw new IllegalArgumentException((String)paramObject);
      }
    }
    return super.add(paramObject);
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append(localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuffer.append(',');
      }
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hsx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */