final class imy
  extends Thread
{
  private ilx a;
  private Object b;
  private inb c;
  private imz d;
  
  public imy(imz paramimz, ilx paramilx, Object paramObject, inb paraminb)
  {
    d = paramimz;
    a = paramilx;
    b = paramObject;
    c = paraminb;
  }
  
  public final void run()
  {
    try
    {
      ilx localilx = d.a(a);
      c.a(localilx);
      return;
    }
    catch (Exception localException)
    {
      c.a(b, localException);
    }
  }
}

/* Location:
 * Qualified Name:     imy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */