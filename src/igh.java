public class igh
  extends igc
  implements ige
{
  public ige c;
  public ige[] d;
  public int e;
  
  public igh(int paramInt)
  {
    e = paramInt;
  }
  
  public final int a()
  {
    if (d == null) {
      return 0;
    }
    return d.length;
  }
  
  public final void a(ige paramige)
  {
    c = paramige;
  }
  
  public final void a(ige paramige, int paramInt)
  {
    if (d == null) {
      d = new ige[paramInt + 1];
    }
    for (;;)
    {
      d[paramInt] = paramige;
      return;
      if (paramInt >= d.length)
      {
        ige[] arrayOfige = new ige[paramInt + 1];
        System.arraycopy(d, 0, arrayOfige, 0, d.length);
        d = arrayOfige;
      }
    }
  }
  
  public String toString()
  {
    return igb.g[e];
  }
}

/* Location:
 * Qualified Name:     igh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */