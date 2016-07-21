public abstract class djz
  extends dka
  implements dmf
{
  private static final String f = cvl.a;
  
  protected djz(int paramInt, String paramString)
  {
    super(paramInt, paramString);
  }
  
  public final void D_()
  {
    cvm.d(f, "Gmailify: OAuth required", new Object[0]);
  }
  
  public final void E_()
  {
    cvm.c(f, "Gmailify: third-party error for %1$s", new Object[] { cvm.a(h()) });
    a(dge.da, new Object[] { cui.b(h()) });
  }
  
  public final void a(long paramLong, String paramString)
  {
    cvm.a(f, "Gmailify: Gmail 0x%1$X (%2$s) already linked with %3$s", new Object[] { Long.valueOf(paramLong), paramString, h() });
    cvm.c(f, "Gmailify: Gmail already linked", new Object[0]);
    a(dge.cZ, new Object[] { h(), paramString });
  }
  
  public final void a(String paramString)
  {
    cvm.c(f, "Gmailify: email %s already linked", new Object[] { cvm.a(paramString) });
    a(dge.cU, new Object[] { paramString });
  }
  
  public final void c()
  {
    cvm.f(f, "Gmailify: wrong format of email %1$s", new Object[] { cvm.a(h()) });
    a(dge.dc, new Object[] { h() });
  }
  
  public final void d()
  {
    cvm.f(f, "Gmailify: ineligible address %1$s", new Object[] { cvm.a(h()) });
    a(dge.cV, new Object[0]);
  }
  
  public final void e()
  {
    cvm.e(f, "Gmailify: error", new Object[0]);
    a(dge.cS, new Object[0]);
  }
}

/* Location:
 * Qualified Name:     djz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */