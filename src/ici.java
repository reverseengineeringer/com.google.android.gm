public abstract class ici
{
  public static ici a;
  
  static
  {
    try
    {
      a = (ici)Class.forName(icg.a("net.fortuna.ical4j.factory.decoder")).newInstance();
      return;
    }
    catch (Exception localException)
    {
      a = new icj();
    }
  }
  
  public abstract icr a(hyw paramhyw);
}

/* Location:
 * Qualified Name:     ici
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */