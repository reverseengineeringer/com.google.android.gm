import java.io.IOException;
import java.util.Iterator;

public class haw
{
  final String a;
  
  haw(haw paramhaw)
  {
    a = a;
  }
  
  private haw(String paramString)
  {
    a = ((String)hbe.a(paramString));
  }
  
  public static haw a(char paramChar)
  {
    return new haw(String.valueOf(paramChar));
  }
  
  public static haw a(String paramString)
  {
    return new haw(paramString);
  }
  
  CharSequence a(Object paramObject)
  {
    hbe.a(paramObject);
    if ((paramObject instanceof CharSequence)) {
      return (CharSequence)paramObject;
    }
    return paramObject.toString();
  }
  
  public final String a(Iterable<?> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    return a(new StringBuilder(), paramIterable).toString();
  }
  
  public final StringBuilder a(StringBuilder paramStringBuilder, Iterator<?> paramIterator)
  {
    try
    {
      hbe.a(paramStringBuilder);
      if (paramIterator.hasNext())
      {
        paramStringBuilder.append(a(paramIterator.next()));
        while (paramIterator.hasNext())
        {
          paramStringBuilder.append(a);
          paramStringBuilder.append(a(paramIterator.next()));
        }
      }
      return paramStringBuilder;
    }
    catch (IOException paramStringBuilder)
    {
      throw new AssertionError(paramStringBuilder);
    }
  }
  
  public haw b(String paramString)
  {
    hbe.a(paramString);
    return new hax(this, this, paramString);
  }
}

/* Location:
 * Qualified Name:     haw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */