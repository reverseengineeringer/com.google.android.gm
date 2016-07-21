import java.util.NoSuchElementException;

class hpp
{
  @Deprecated
  int a;
  @Deprecated
  int b;
  @Deprecated
  hpo[] c;
  @Deprecated
  hpo d;
  @Deprecated
  hpo e;
  
  hpp(hpl paramhpl)
  {
    a = (d.length - 1);
    b = -1;
    b();
  }
  
  private final void b()
  {
    Object localObject;
    if (d != null)
    {
      localObject = d.d;
      d = ((hpo)localObject);
      if (localObject != null)
      {
        return;
        break label63;
      }
    }
    label24:
    int i;
    while (b >= 0)
    {
      localObject = c;
      i = b;
      b = (i - 1);
      localObject = localObject[i];
      d = ((hpo)localObject);
      if (localObject != null) {
        return;
      }
    }
    for (;;)
    {
      label63:
      if (a < 0) {
        break label24;
      }
      localObject = f.d;
      i = a;
      a = (i - 1);
      localObject = localObject[i];
      if (a == 0) {
        break;
      }
      c = d;
      i = c.length - 1;
      while (i >= 0)
      {
        localObject = c[i];
        d = ((hpo)localObject);
        if (localObject != null)
        {
          b = (i - 1);
          return;
        }
        i -= 1;
      }
    }
  }
  
  final hpo a()
  {
    if (d == null) {
      throw new NoSuchElementException();
    }
    e = d;
    b();
    return e;
  }
  
  public boolean hasMoreElements()
  {
    return hasNext();
  }
  
  public boolean hasNext()
  {
    return d != null;
  }
  
  public void remove()
  {
    if (e == null) {
      throw new IllegalStateException();
    }
    f.remove(e.a);
    e = null;
  }
}

/* Location:
 * Qualified Name:     hpp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */