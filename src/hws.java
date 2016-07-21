public abstract class hws
{
  public static hws a;
  
  static
  {
    try
    {
      a = (hws)Class.forName(icg.a("net.fortuna.ical4j.timezone.registry")).newInstance();
      return;
    }
    catch (Exception localException)
    {
      a = new hss();
    }
  }
  
  public abstract hwr a();
}

/* Location:
 * Qualified Name:     hws
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */