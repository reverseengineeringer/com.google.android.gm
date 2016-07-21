import java.util.ArrayList;
import java.util.List;

final class iok
  implements iom
{
  List a;
  List b;
  
  private iok() {}
  
  iok(byte paramByte)
  {
    this();
  }
  
  public final void a()
  {
    a = new ArrayList();
  }
  
  public final void a(imw paramimw)
  {
    iol localiol = new iol((byte)0);
    d.add(paramimw);
    a = a;
    b.add(localiol);
  }
  
  public final void b()
  {
    b = new ArrayList();
  }
  
  public final void b(imw paramimw)
  {
    iol localiol = (iol)b.get(b.size() - 1);
    c.add(paramimw);
    b = a;
  }
  
  public final void c(imw paramimw)
  {
    Object localObject;
    if (b != null)
    {
      localObject = (iol)b.get(b.size() - 1);
      if (c.size() > 0) {
        localObject = c;
      }
    }
    for (;;)
    {
      ((List)localObject).add(paramimw);
      return;
      localObject = d;
      continue;
      localObject = a;
    }
  }
}

/* Location:
 * Qualified Name:     iok
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */