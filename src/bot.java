import android.content.Context;
import com.android.exchange.adapter.Parser;
import java.io.InputStream;

public final class bot
  extends Parser
{
  public String a = null;
  final Context b;
  
  public bot(InputStream paramInputStream, Context paramContext)
  {
    super(paramInputStream);
    b = paramContext;
  }
  
  public final boolean d()
  {
    if (b(0) != 1285)
    {
      throw new boy(this);
      i();
    }
    for (;;)
    {
      if (b(0) == 1) {
        break label261;
      }
      if (l == 1293)
      {
        if (h() != 1) {
          return false;
        }
      }
      else
      {
        if (l != 1294) {
          break;
        }
        while (b(1294) != 3) {
          if (l == 1286) {
            for (;;)
            {
              if (b(1286) == 3) {
                break label252;
              }
              if (l == 1293)
              {
                if (h() != 1) {
                  break;
                }
                continue;
              }
              if (l == 1291) {
                while (b(1291) != 3) {
                  switch (l)
                  {
                  default: 
                    i();
                    break;
                  case 1098: 
                    String str = "1";
                    while (b(1098) != 3) {
                      switch (l)
                      {
                      default: 
                        i();
                        break;
                      case 1094: 
                        str = g();
                        break;
                      case 1099: 
                        if ("4".equals(str)) {
                          a = g();
                        }
                        break;
                      }
                    }
                  }
                }
              } else {
                i();
              }
            }
          } else {
            label252:
            i();
          }
        }
      }
    }
    label261:
    return true;
  }
}

/* Location:
 * Qualified Name:     bot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */