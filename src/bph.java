import com.android.exchange.adapter.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class bph
  extends Parser
{
  public int a;
  private final int b;
  
  public bph(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream);
    b = paramInt;
  }
  
  public final boolean d()
  {
    if (b(0) != b) {
      throw new IOException();
    }
    while (b(0) != 1) {
      if (l == 1362) {
        a = h();
      } else {
        i();
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     bph
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */