import java.io.File;

public final class bce
{
  public static File a = null;
  
  public static File a()
  {
    if (a == null) {
      throw new RuntimeException("TempDirectory not set.  If in a unit test, call Email.setTempDirectory(context) in setUp().");
    }
    return a;
  }
}

/* Location:
 * Qualified Name:     bce
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */