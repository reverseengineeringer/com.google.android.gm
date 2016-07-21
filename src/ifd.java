import java.io.StringReader;
import java.util.ArrayList;

public final class ifd
{
  private ArrayList<ifc> a;
  
  public ifd()
  {
    ArrayList localArrayList;
    a = localArrayList;
  }
  
  private final ifc a(int paramInt)
  {
    if ((paramInt < 0) || (a.size() <= paramInt)) {
      throw new IndexOutOfBoundsException();
    }
    return (ifc)a.get(paramInt);
  }
  
  public static ifd a(String paramString)
  {
    paramString = new ifw(new StringReader(paramString));
    return ife.a.a(paramString.a());
  }
  
  public final ifj a()
  {
    int i = 0;
    if (i < a.size()) {
      if ((a(i) instanceof ifi)) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        return new ifj(a, true);
        i += 1;
        break;
      }
      ArrayList localArrayList = new ArrayList();
      i = 0;
      while (i < a.size())
      {
        a(i).a(localArrayList);
        i += 1;
      }
      return new ifj(localArrayList, false);
    }
  }
}

/* Location:
 * Qualified Name:     ifd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */