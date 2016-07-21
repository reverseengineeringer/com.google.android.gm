import java.util.Iterator;

final class iff
  implements Iterator<ige>
{
  private igh a;
  private int b;
  private int c;
  
  public iff(igh paramigh)
  {
    a = paramigh;
    c = paramigh.a();
    b = 0;
  }
  
  public final ige a()
  {
    igh localigh = a;
    int i = b;
    b = (i + 1);
    return d[i];
  }
  
  public final boolean hasNext()
  {
    return b < c;
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     iff
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */