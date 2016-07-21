import java.util.List;
import java.util.Set;

final class iig<T>
  implements iiw
{
  private static final String[] e = new String[0];
  iix a;
  final iih b;
  final T c;
  final iie<? super T> d;
  
  iig(iih paramiih, iie<? super T> paramiie, T paramT)
  {
    b = paramiih;
    c = paramT;
    d = paramiie;
  }
  
  public final void a()
  {
    a.a();
  }
  
  public final void a(String paramString)
  {
    a.a(paramString);
  }
  
  public final void a(String paramString, List<String> paramList)
  {
    b.a = paramString;
    b.b.clear();
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      b.b.add(paramList.get(i));
      i += 2;
    }
    a.a(paramString, paramList);
    paramString = b.a;
    b.a = null;
    i = b.b.size();
    if ((i != 0) && (paramString == null)) {
      b.b.toArray(new String[i]);
    }
    b.b.clear();
  }
  
  public final void b()
  {
    a.b();
  }
  
  public final void b(String paramString)
  {
    a.b(paramString);
  }
}

/* Location:
 * Qualified Name:     iig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */