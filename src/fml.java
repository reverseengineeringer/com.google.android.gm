public class fml<M extends fml<M>>
  extends fmq
{
  public fmn f;
  
  private final M e()
  {
    fml localfml = (fml)super.c();
    fmp.a(this, localfml);
    return localfml;
  }
  
  public int a()
  {
    int j = 0;
    if (f != null)
    {
      int i = 0;
      for (;;)
      {
        k = i;
        if (j >= f.a()) {
          break;
        }
        i += f.a(j).a();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public void a(fmj paramfmj)
  {
    if (f == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < f.a())
      {
        f.a(i).a(paramfmj);
        i += 1;
      }
    }
  }
  
  public final boolean a(M paramM)
  {
    if ((f == null) || (f.b())) {
      return (f == null) || (f.b());
    }
    return f.equals(f);
  }
  
  public final int b()
  {
    if ((f == null) || (f.b())) {
      return 0;
    }
    return f.hashCode();
  }
}

/* Location:
 * Qualified Name:     fml
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */