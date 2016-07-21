import java.io.InputStream;

final class axl
  extends InputStream
{
  private final InputStream b;
  private boolean c = true;
  private boolean d;
  
  public axl(axg paramaxg, InputStream paramInputStream)
  {
    b = paramInputStream;
  }
  
  public final int read()
  {
    boolean bool = true;
    if (d) {
      return -1;
    }
    int j = b.read();
    int i = j;
    if (c)
    {
      i = j;
      if (j == 46)
      {
        j = b.read();
        i = j;
        if (j == 13)
        {
          d = true;
          b.read();
          return -1;
        }
      }
    }
    if (i == 10) {}
    for (;;)
    {
      c = bool;
      return i;
      bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     axl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */