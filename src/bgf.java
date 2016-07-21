import com.android.emailcommon.provider.ExchangeOofSettings;

final class bgf
  extends bgh
{
  bgf(bfn parambfn, long paramLong, ExchangeOofSettings paramExchangeOofSettings)
  {
    super(parambfn);
  }
  
  public final void a()
  {
    super.a();
    if (d >= 2)
    {
      c.d.a(a, b);
      return;
    }
    cvm.d("EmailServiceProxy", "Exchange version doesn't support OOF settings", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     bgf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */