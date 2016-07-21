import java.text.Collator;
import java.util.Comparator;

public final class brd
  implements Comparator<brb>
{
  private final Collator a;
  private final int b;
  
  public brd(String paramString)
  {
    this(Collator.getInstance(), paramString);
  }
  
  private brd(Collator paramCollator, String paramString)
  {
    a = paramCollator;
    a.setStrength(1);
    if ("sort_key".equals(paramString))
    {
      b = 1;
      return;
    }
    if ("sort_key_alt".equals(paramString))
    {
      b = 2;
      return;
    }
    b = 0;
  }
  
  private final String a(brb parambrb)
  {
    switch (b)
    {
    default: 
      return null;
    case 1: 
      return c;
    }
    return d;
  }
}

/* Location:
 * Qualified Name:     brd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */