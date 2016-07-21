import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class grh
  extends BufferedOutputStream
{
  grh(grg paramgrg, OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public final void close()
  {
    try
    {
      flush();
      return;
    }
    catch (IOException localIOException) {}
  }
}

/* Location:
 * Qualified Name:     grh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */