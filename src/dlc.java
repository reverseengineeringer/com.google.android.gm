import android.content.Context;

abstract class dlc<R extends hlt>
  extends cot<dle<R>>
{
  private final dkq a;
  
  public dlc(Context paramContext, dkq paramdkq)
  {
    super(paramContext);
    a = paramdkq;
  }
  
  private final dle<R> a()
  {
    try
    {
      cvm.b(dlb.a, "Executing GmailifyLoader.", new Object[0]);
      dle localdle = new dle(a(dkq.a(getContext())));
      return localdle;
    }
    catch (Exception localException)
    {
      cvm.d(dlb.a, localException, "Exception while executing GmailifyLoader.", new Object[0]);
      return new dle(localException);
    }
  }
  
  protected abstract R a(dkp paramdkp);
}

/* Location:
 * Qualified Name:     dlc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */