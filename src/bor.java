import com.android.exchange.adapter.Parser;
import com.android.exchange.provider.GalResult;
import java.io.IOException;
import java.io.InputStream;

public final class bor
  extends Parser
{
  public GalResult a = new GalResult();
  
  public bor(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private final void a(GalResult paramGalResult)
  {
    while (b(973) != 3)
    {
      if (l == 967) {
        while (b(967) != 3) {
          if (l == 974) {
            while (b(974) != 3) {
              if (l == 975)
              {
                brk localbrk = new brk();
                while (b(975) != 3)
                {
                  String str;
                  switch (l)
                  {
                  default: 
                    i();
                    break;
                  case 1029: 
                    str = g();
                    localbrk.a("displayName", str);
                    c = str;
                    break;
                  case 1039: 
                    str = g();
                    localbrk.a("emailAddress", str);
                    d = str;
                    break;
                  case 1030: 
                    localbrk.a("workPhone", g());
                    break;
                  case 1031: 
                    localbrk.a("office", g());
                    break;
                  case 1032: 
                    localbrk.a("title", g());
                    break;
                  case 1033: 
                    localbrk.a("company", g());
                    break;
                  case 1034: 
                    localbrk.a("alias", g());
                    break;
                  case 1035: 
                    localbrk.a("firstName", g());
                    break;
                  case 1036: 
                    localbrk.a("lastName", g());
                    break;
                  case 1037: 
                    localbrk.a("homePhone", g());
                    break;
                  case 1038: 
                    localbrk.a("mobilePhone", g());
                  }
                }
                paramGalResult.addGalData(localbrk);
              }
              else
              {
                i();
              }
            }
          } else if (l == 971) {
            g();
          } else if (l == 976) {
            a = h();
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
    if (b(0) != 965) {
      throw new IOException();
    }
    while (b(0) != 1) {
      if (l == 973) {
        a(a);
      } else {
        i();
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     bor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */