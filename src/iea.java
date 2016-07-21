import java.io.InputStream;
import java.util.BitSet;
import java.util.LinkedList;

public class iea
{
  private static final idy d = new idy();
  private static BitSet e = null;
  public ieb a = null;
  public idv b = null;
  public boolean c = false;
  private LinkedList<idt> f = new LinkedList();
  private boolean g = false;
  
  static
  {
    e = new BitSet();
    int i = 33;
    while (i <= 57)
    {
      e.set(i);
      i += 1;
    }
    i = 59;
    while (i <= 126)
    {
      e.set(i);
      i += 1;
    }
  }
  
  private final void b(InputStream paramInputStream)
  {
    Object localObject1;
    idt localidt;
    int k;
    label53:
    int j;
    int n;
    if (f.isEmpty())
    {
      localObject1 = null;
      localidt = new idt((idt)localObject1);
      b.c();
      k = a.a;
      localObject1 = new StringBuffer();
      i = 0;
      j = paramInputStream.read();
      if (j != -1)
      {
        if ((j != 10) || ((i != 10) && (i != 0))) {
          break label158;
        }
        ((StringBuffer)localObject1).deleteCharAt(((StringBuffer)localObject1).length() - 1);
      }
      j = k;
      n = 0;
      i = 0;
    }
    int m;
    label158:
    int i1;
    Object localObject2;
    String str;
    for (;;)
    {
      if (i < ((StringBuffer)localObject1).length())
      {
        m = i;
        for (;;)
        {
          if ((m < ((StringBuffer)localObject1).length()) && (((StringBuffer)localObject1).charAt(m) != '\r'))
          {
            m += 1;
            continue;
            localObject1 = (idt)f.getFirst();
            break;
            ((StringBuffer)localObject1).append((char)j);
            if (j == 13) {
              break label53;
            }
            i = j;
            break label53;
          }
        }
        if ((m < ((StringBuffer)localObject1).length() - 1) && (((StringBuffer)localObject1).charAt(m + 1) != '\n'))
        {
          i = m + 1;
        }
        else if (m < ((StringBuffer)localObject1).length() - 2)
        {
          i = k;
          i1 = n;
          if (!e.get(((StringBuffer)localObject1).charAt(m + 2))) {}
        }
        else
        {
          localObject2 = ((StringBuffer)localObject1).substring(n, m);
          i1 = ((String)localObject2).indexOf(':');
          i = 0;
          n = i;
          if (i1 != -1)
          {
            n = i;
            if (e.get(((String)localObject2).charAt(0)))
            {
              str = ((String)localObject2).substring(0, i1).trim();
              i = 0;
              label312:
              if (i >= str.length()) {
                break label839;
              }
              if (e.get(str.charAt(i))) {
                break label474;
              }
            }
          }
        }
      }
    }
    label474:
    label672:
    label839:
    for (int i = 0;; i = 1)
    {
      n = i;
      if (i != 0)
      {
        b.a((String)localObject2);
        localidt.a(str, ((String)localObject2).substring(i1 + 1));
        n = i;
      }
      if (n == 0)
      {
        idy.b();
        localObject2 = String.valueOf(((String)localObject2).trim());
        idy.a(String.valueOf(localObject2).length() + 44 + "Line " + k + ": Ignoring invalid field: '" + (String)localObject2 + "'");
      }
      i = j;
      i1 = m + 2;
      m += 2;
      j += 1;
      k = i;
      i = m;
      n = i1;
      break;
      i += 1;
      break label312;
      b.d();
      if (localidt.a())
      {
        f.addFirst(localidt);
        b.e();
        localObject1 = new idz(paramInputStream, b);
        b.b(new idu((InputStream)localObject1));
        ((idz)localObject1).a();
        while (b)
        {
          localObject2 = new idz(paramInputStream, b);
          if (!g) {
            break label672;
          }
          localObject1 = b;
          new idu((InputStream)localObject2);
          ((idv)localObject1).i();
          ((idz)localObject2).a();
          localObject1 = localObject2;
          if (a) {
            c = true;
          }
        }
        b.a(new idu(paramInputStream));
        b.f();
        f.removeFirst();
      }
      for (;;)
      {
        if (paramInputStream.read() == -1)
        {
          return;
          b.g();
          b((InputStream)localObject2);
          b.h();
          break;
          if (a.equals("message/rfc822"))
          {
            if ("base64".equals(c))
            {
              idy.a("base64 encoded message/rfc822 detected");
              localObject1 = new idw(new ief(paramInputStream));
            }
            for (;;)
            {
              f.addFirst(localidt);
              a((InputStream)localObject1);
              f.removeFirst();
              paramInputStream = (InputStream)localObject1;
              break;
              localObject1 = paramInputStream;
              if ("quoted-printable".equals(c))
              {
                idy.a("quoted-printable encoded message/rfc822 detected");
                localObject1 = new idw(new iei(paramInputStream));
              }
            }
          }
          b.a(localidt, new idu(paramInputStream));
        }
      }
    }
  }
  
  public final void a(InputStream paramInputStream)
  {
    if (g)
    {
      idv localidv = b;
      new idu(paramInputStream);
      localidv.i();
      return;
    }
    b.a();
    b(paramInputStream);
    b.b();
  }
}

/* Location:
 * Qualified Name:     iea
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */