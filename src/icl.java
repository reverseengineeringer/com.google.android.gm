public abstract class icl
{
  public static icl a;
  
  static
  {
    try
    {
      a = (icl)Class.forName(icg.a("net.fortuna.ical4j.factory.encoder")).newInstance();
      return;
    }
    catch (Exception localException)
    {
      a = new ick();
    }
  }
  
  public abstract ics a(hyw paramhyw);
}

/* Location:
 * Qualified Name:     icl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */