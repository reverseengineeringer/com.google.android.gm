import com.android.exchange.adapter.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class bov
  extends Parser
{
  public int a = 0;
  public String b;
  public String c;
  
  public bov(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private final void a()
  {
    while (b(330) != 3)
    {
      if (l == 331)
      {
        int i = h();
        switch (i)
        {
        case 5: 
        default: 
          a = 2;
        }
        while (i != 3)
        {
          cvm.d("Exchange", "Error in MoveItems: %d", new Object[] { Integer.valueOf(i) });
          break;
          a = 1;
          continue;
          a = 3;
        }
      }
      if (l == 332)
      {
        b = g();
        cvm.b("Exchange", "Moved message id is now: %s", new Object[] { b });
      }
      else if (l == 327)
      {
        c = g();
        cvm.b("Exchange", "Source message id is: %s", new Object[] { b });
      }
      else
      {
        i();
      }
    }
  }
  
  public final boolean d()
  {
    if (b(0) != 325) {
      throw new IOException();
    }
    while (b(0) != 1) {
      if (l == 330) {
        a();
      } else {
        i();
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     bov
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */