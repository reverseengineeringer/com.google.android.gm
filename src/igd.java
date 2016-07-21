import java.util.Stack;

final class igd
{
  Stack<ige> a = new Stack();
  private Stack<Integer> b = new Stack();
  private int c = 0;
  private int d = 0;
  private boolean e;
  
  private ige c()
  {
    int i = c - 1;
    c = i;
    if (i < d) {
      d = ((Integer)b.pop()).intValue();
    }
    return (ige)a.pop();
  }
  
  final void a()
  {
    while (c > d) {
      c();
    }
    d = ((Integer)b.pop()).intValue();
  }
  
  final void a(ige paramige)
  {
    int i = c;
    int j = d;
    d = ((Integer)b.pop()).intValue();
    i -= j;
    for (;;)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      ige localige = c();
      localige.a(paramige);
      paramige.a(localige, j);
      i = j;
    }
    a.push(paramige);
    c += 1;
    e = true;
  }
  
  final void b()
  {
    b.push(new Integer(d));
    d = c;
  }
}

/* Location:
 * Qualified Name:     igd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */