public final class ijh
  implements hav<iix, iiw>
{
  private final hel<String, ihs> a;
  private final hel<String, ihe> b;
  private final hfd<String> c;
  
  public ijh(hel<String, ihs> paramhel, hfd<String> paramhfd, hel<String, ihe> paramhel1)
  {
    a = paramhel;
    c = paramhfd;
    b = paramhel1;
  }
  
  public final iiw apply(iix paramiix)
  {
    return new iht(paramiix, a, c);
  }
  
  public final <CTX> iiw apply(iix paramiix, iie<CTX> paramiie, CTX paramCTX)
  {
    if (paramiie == null) {
      return apply(paramiix);
    }
    paramiix = new iif(paramiix, paramiie, paramCTX);
    paramiie = apply(a);
    b.a = paramiie;
    return b;
  }
}

/* Location:
 * Qualified Name:     ijh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */