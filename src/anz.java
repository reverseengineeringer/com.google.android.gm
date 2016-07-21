import java.util.Arrays;
import java.util.Set;

public final class anz
{
  private any a = new any();
  
  public final any a()
  {
    String[] arrayOfString = new String[a.size()];
    a.keySet().toArray(arrayOfString);
    Arrays.sort(arrayOfString);
    a.a = arrayOfString;
    return a;
  }
  
  public final anz a(String paramString1, String paramString2)
  {
    a.a(paramString1, String.valueOf(paramString2).length() + 4 + String.valueOf(paramString1).length() + paramString2 + " AS " + paramString1);
    return this;
  }
  
  public final anz a(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      a.a(str, str);
      i += 1;
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     anz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */