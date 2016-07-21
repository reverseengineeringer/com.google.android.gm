import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class iiq
{
  public final List<String> a;
  public ihe b = ihe.a;
  
  iiq(List<? extends String> paramList)
  {
    Collection localCollection;
    a = hef.a(localCollection);
  }
  
  public final iip a(String... paramVarArgs)
  {
    Object localObject1 = hef.d();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      ((heh)localObject1).c(iim.a(paramVarArgs[i]));
      i += 1;
    }
    iip localiip = c;
    ihe localihe = b;
    List localList = a;
    paramVarArgs = ((heh)localObject1).a();
    f = null;
    localObject1 = paramVarArgs.iterator();
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      paramVarArgs = (Map)b.get(localObject2);
      if (paramVarArgs != null) {
        break label204;
      }
      paramVarArgs = hhk.d();
      b.put(localObject2, paramVarArgs);
    }
    label204:
    for (;;)
    {
      localObject2 = localList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        paramVarArgs.put(str, ihh.a(new ihe[] { (ihe)paramVarArgs.get(str), localihe }));
      }
      break;
      return localiip;
    }
  }
  
  public final iiq a(ihe paramihe)
  {
    b = ihh.a(new ihe[] { b, paramihe });
    return this;
  }
  
  public final iiq a(Pattern paramPattern)
  {
    return a(new iir(this, paramPattern));
  }
}

/* Location:
 * Qualified Name:     iiq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */