import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class ihh
{
  public static final ihe a(ihe... paramVarArgs)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      ihe localihe = paramVarArgs[i];
      if ((localihe instanceof ijf)) {
        localLinkedHashSet.addAll(c);
      }
      for (;;)
      {
        i += 1;
        break;
        if (localihe != null) {
          localLinkedHashSet.add(localihe);
        }
      }
    }
    if (localLinkedHashSet.contains(ihe.b)) {
      return ihe.b;
    }
    localLinkedHashSet.remove(ihe.a);
    switch (localLinkedHashSet.size())
    {
    default: 
      return new ijf(localLinkedHashSet);
    case 0: 
      return ihe.a;
    }
    return (ihe)localLinkedHashSet.iterator().next();
  }
}

/* Location:
 * Qualified Name:     ihh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */