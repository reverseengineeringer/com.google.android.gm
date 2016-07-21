import android.util.Log;
import com.android.exchange.adapter.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class bpj
  extends Parser
{
  public bpj(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private final void a()
  {
    while (b(1174) != 3)
    {
      if (l == 1160) {
        while (b(1160) != 3) {
          if (l == 1158) {
            cvm.b("Exchange", "Set status = %d", new Object[] { Integer.valueOf(h()) });
          } else {
            i();
          }
        }
      }
      i();
    }
  }
  
  public final boolean d()
  {
    if (b(0) != 1157) {
      throw new IOException();
    }
    for (;;)
    {
      boolean bool;
      if (b(0) != 1)
      {
        if (l == 1158)
        {
          int i = h();
          cvm.b("Exchange", "Settings status = %d", new Object[] { Integer.valueOf(i) });
          if (i == 1)
          {
            bool = true;
          }
          else
          {
            Log.w("Exchange", 49 + "Returned non-success Settings status: " + i);
            bool = false;
          }
        }
        else if (l == 1174)
        {
          a();
        }
        else
        {
          i();
        }
      }
      else
      {
        return bool;
        bool = false;
      }
    }
  }
}

/* Location:
 * Qualified Name:     bpj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */