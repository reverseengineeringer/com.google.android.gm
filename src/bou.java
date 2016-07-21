import com.android.exchange.adapter.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class bou
  extends Parser
{
  public bou(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private final void a()
  {
    while (b(522) != 3) {
      if (l == 523)
      {
        int i = h();
        if (i != 1) {
          cvm.d("Exchange", "Error in meeting response: %d", new Object[] { Integer.valueOf(i) });
        }
      }
      else if (l == 517)
      {
        cvm.b("Exchange", "Meeting response calender id: %s", new Object[] { g() });
      }
      else
      {
        i();
      }
    }
  }
  
  public final boolean d()
  {
    if (b(0) != 519) {
      throw new IOException();
    }
    while (b(0) != 1) {
      if (l == 522) {
        a();
      } else {
        i();
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     bou
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */