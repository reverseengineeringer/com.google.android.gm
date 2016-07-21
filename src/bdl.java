import java.util.HashMap;

public final class bdl
{
  private static final HashMap<String, String> c = new HashMap();
  private String a;
  private HashMap<String, String> b;
  
  public bdl(String paramString)
  {
    a = paramString;
    b = null;
  }
  
  static HashMap<String, String> b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return c;
    }
    HashMap localHashMap = new HashMap();
    int m = paramString.length();
    int j = paramString.indexOf(2);
    int i = 0;
    int k;
    if (i < m)
    {
      k = paramString.indexOf(1, i);
      if (k != -1) {
        break label137;
      }
      k = m;
    }
    label137:
    for (;;)
    {
      String str1;
      String str2;
      if ((j == -1) || (k <= j))
      {
        str1 = paramString.substring(i, k);
        str2 = Integer.toString(localHashMap.size());
      }
      for (;;)
      {
        localHashMap.put(str2, str1);
        i = k + 1;
        break;
        str1 = paramString.substring(i, j);
        str2 = paramString.substring(j + 1, k);
        j = paramString.indexOf(2, k + 1);
      }
      return localHashMap;
    }
  }
  
  public final String a(String paramString)
  {
    if (b == null) {
      b = b(a);
    }
    return (String)b.get(paramString);
  }
}

/* Location:
 * Qualified Name:     bdl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */