import com.android.exchange.adapter.Parser;

public final class bpc
{
  public final boolean a;
  private final int c;
  private final int d;
  private final String e;
  
  public bpc(Parser paramParser, int paramInt1, int paramInt2)
  {
    c = paramInt1;
    d = (paramInt2 & 0x3F);
    if ((paramInt2 & 0x40) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      if (!bpk.b(d)) {
        break;
      }
      e = "unsupported-WBXML";
      return;
    }
    if (!bpk.a(c, d))
    {
      e = "unknown";
      return;
    }
    e = bpk.b(c, d);
  }
  
  public final int a()
  {
    if (bpk.b(d)) {
      return d;
    }
    return c << 6 | d;
  }
  
  public final String toString()
  {
    return e;
  }
}

/* Location:
 * Qualified Name:     bpc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */