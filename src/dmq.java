import java.util.ArrayList;
import java.util.List;

public final class dmq
{
  private static final String e = cvl.a;
  public final List<Integer> a = new ArrayList();
  public final hkd b = new hkd();
  public gwb c;
  public final int d;
  
  public dmq()
  {
    this(-1);
  }
  
  public dmq(int paramInt)
  {
    cvm.a(e, "VisualElementEvent: Created for UserAction=%d", new Object[] { Integer.valueOf(paramInt) });
    d = paramInt;
  }
  
  public final void a(gnr paramgnr)
  {
    a.add(Integer.valueOf(a.a));
    cvm.a(e, "VisualElementEvent.addVE: %s", new Object[] { paramgnr });
    Object localObject;
    if ((paramgnr instanceof cew))
    {
      localObject = (cew)paramgnr;
      if (c == null) {
        c = new gwb();
      }
      ((cew)localObject).a(c);
    }
    if ((paramgnr instanceof ceu)) {
      if ((b.a & 0x2) == 0) {
        break label131;
      }
    }
    label131:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = b;
        c = ((ceu)paramgnr).a();
        a |= 0x2;
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     dmq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */