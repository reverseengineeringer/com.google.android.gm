import java.util.ArrayList;

public final class ifh
  extends ifc
{
  private String a;
  private ifj b;
  
  public ifh(String paramString, ifj paramifj)
  {
    a = paramString;
    b = paramifj;
  }
  
  protected final void a(ArrayList<ifc> paramArrayList)
  {
    int i = 0;
    while (i < b.a.size())
    {
      paramArrayList.add(b.a(i));
      i += 1;
    }
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    localStringBuffer.append(":");
    int i = 0;
    while (i < b.a.size())
    {
      localStringBuffer.append(b.a(i).toString());
      if (i + 1 < b.a.size()) {
        localStringBuffer.append(",");
      }
      i += 1;
    }
    localStringBuffer.append(";");
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ifh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */