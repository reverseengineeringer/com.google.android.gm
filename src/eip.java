public final class eip<O extends eir>
{
  final eiw<?, O> a;
  final eix<?> b;
  final String c;
  private final eiq<?, O> d;
  private final eiu<?> e;
  
  public <C extends eit> eip(String paramString, eiq<C, O> parameiq, eiu<C> parameiu)
  {
    enz.a(parameiq, "Cannot construct an Api with a null ClientBuilder");
    enz.a(parameiu, "Cannot construct an Api with a null ClientKey");
    c = paramString;
    d = parameiq;
    a = null;
    e = parameiu;
    b = null;
  }
  
  public final eiq<?, O> a()
  {
    if (d != null) {}
    for (boolean bool = true;; bool = false)
    {
      enz.a(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      return d;
    }
  }
  
  public final eiu<?> b()
  {
    if (e != null) {}
    for (boolean bool = true;; bool = false)
    {
      enz.a(bool, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
      return e;
    }
  }
}

/* Location:
 * Qualified Name:     eip
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */