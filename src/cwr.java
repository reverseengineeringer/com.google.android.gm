public final class cwr
{
  private static boolean a = false;
  private static cws b = null;
  
  public static void a(cws paramcws)
  {
    b = paramcws;
    if (a) {
      b.a();
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (a == paramBoolean) {}
    do
    {
      return;
      a = paramBoolean;
    } while (b == null);
    if (paramBoolean)
    {
      b.a();
      return;
    }
    b.b();
  }
}

/* Location:
 * Qualified Name:     cwr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */