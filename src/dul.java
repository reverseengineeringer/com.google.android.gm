import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

final class dul
{
  Map<String, String> a = new HashMap();
  
  private final dul a(String paramString)
  {
    a.put(paramString, paramString);
    return this;
  }
  
  public final dul a(String paramString1, String paramString2)
  {
    a.put(paramString1, String.valueOf(paramString2).length() + 4 + String.valueOf(paramString1).length() + paramString2 + " AS " + paramString1);
    return this;
  }
  
  public final dul a(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      a(paramArrayOfString[i]);
      i += 1;
    }
    return this;
  }
  
  public final dul a(String[][] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String[] arrayOfString = paramArrayOfString[i];
      switch (arrayOfString.length)
      {
      default: 
        dri.c(drp.b, "unrecognized projection map entry: %s", new Object[] { Arrays.toString(arrayOfString) });
      }
      for (;;)
      {
        i += 1;
        break;
        a(arrayOfString[0], arrayOfString[1]);
        continue;
        a(arrayOfString[0]);
      }
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     dul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */