import java.util.ArrayList;
import java.util.List;

public final class iky
  implements imz
{
  List a = new ArrayList();
  boolean b = false;
  int c = 0;
  int d = 3;
  
  public iky()
  {
    String[] arrayOfString = aa;
    if (arrayOfString != null) {
      while (i < arrayOfString.length)
      {
        ink localink = new ink(arrayOfString[i]);
        localink.a();
        a.add(localink);
        i += 1;
      }
    }
    a.add(new ink());
  }
  
  public final ilx a(ilx paramilx)
  {
    return new ikz(this, paramilx).a();
  }
  
  public final Object a(ilx paramilx, inb paraminb)
  {
    paramilx = new ikz(this, paramilx);
    j = paraminb;
    paramilx.a(0);
    return paramilx;
  }
  
  public final void a()
  {
    a(5, 0);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < a.size())
    {
      ((imz)a.get(i)).a(paramInt1, paramInt2);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     iky
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */