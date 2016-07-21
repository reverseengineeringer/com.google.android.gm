import android.util.Base64OutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class bct
  implements bcu
{
  private final InputStream a;
  private boolean b;
  
  public bct(InputStream paramInputStream)
  {
    a = paramInputStream;
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    if (b) {
      throw new IllegalStateException("Base64Body can only be written once");
    }
    b = true;
    try
    {
      paramOutputStream = new Base64OutputStream(paramOutputStream, 0);
      idc.b(a, paramOutputStream);
      return;
    }
    finally
    {
      a.close();
    }
  }
  
  public final InputStream g_()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     bct
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */