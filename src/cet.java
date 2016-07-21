import java.util.Locale;

public final class cet
  extends gnr
  implements ceu, cew
{
  private long b;
  private int c;
  
  public cet(gnt paramgnt, long paramLong, int paramInt)
  {
    super(paramgnt);
    b = paramLong;
    c = paramInt;
  }
  
  public final int a()
  {
    return c;
  }
  
  public final void a(gwb paramgwb)
  {
    gwd localgwd = new gwd();
    String str = Long.toString(b);
    if (str == null) {
      throw new NullPointerException();
    }
    b = str;
    a |= 0x1;
    a = localgwd;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (super.equals(paramObject))
    {
      paramObject = (cet)paramObject;
      bool1 = bool2;
      if (b == b) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return Long.valueOf(b).hashCode() + super.hashCode() * 31;
  }
  
  public final String toString()
  {
    return String.format(Locale.US, "ConversationVisualElement {tag: %s, index: %s}", new Object[] { a, Integer.valueOf(c) });
  }
}

/* Location:
 * Qualified Name:     cet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */