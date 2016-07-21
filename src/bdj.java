import java.util.ArrayList;

public abstract class bdj
  implements bcu
{
  public bdn e;
  public ArrayList<bcv> f = new ArrayList();
  public String g;
  
  public final bcv a(int paramInt)
  {
    return (bcv)f.get(paramInt);
  }
  
  public String a()
  {
    return g;
  }
  
  public final void a(bcv parambcv)
  {
    f.add(parambcv);
  }
}

/* Location:
 * Qualified Name:     bdj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */