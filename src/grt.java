public final class grt
{
  private final gsa a;
  private final gru b;
  
  grt(gsa paramgsa, gru paramgru)
  {
    a = paramgsa;
    b = paramgru;
  }
  
  public final grs a(String paramString, gri paramgri, grj paramgrj)
  {
    grs localgrs = new grs(a);
    if (b != null) {
      b.a(localgrs);
    }
    localgrs.a(paramString);
    if (paramgri != null) {
      localgrs.a(paramgri);
    }
    if (paramgrj != null) {
      g = paramgrj;
    }
    return localgrs;
  }
}

/* Location:
 * Qualified Name:     grt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */