import android.os.Build.VERSION;

final class czt
{
  public static int a()
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      dav.b("Invalid version number: " + Build.VERSION.SDK);
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     czt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */