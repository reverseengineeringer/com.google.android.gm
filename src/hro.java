public abstract class hro
{
  static hro a;
  
  static
  {
    try
    {
      a = (hro)Class.forName(icg.a("net.fortuna.ical4j.parser")).newInstance();
      return;
    }
    catch (Exception localException)
    {
      a = new hrx();
    }
  }
  
  public abstract hrn a();
}

/* Location:
 * Qualified Name:     hro
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */