import org.apache.http.HttpEntity;

public final class bqr
  extends bqc
{
  public bqr(bqc parambqc)
  {
    super(parambqc);
  }
  
  protected final int a(bns parambns)
  {
    if (new bpj(parambns.d()).d()) {
      return 0;
    }
    return -99;
  }
  
  protected final String b()
  {
    return "Settings";
  }
  
  protected final HttpEntity c()
  {
    bpi localbpi = new bpi();
    localbpi.a(1157);
    String str = h.c();
    bqc.a(localbpi, f, str);
    localbpi.b().a();
    return a(localbpi);
  }
}

/* Location:
 * Qualified Name:     bqr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */