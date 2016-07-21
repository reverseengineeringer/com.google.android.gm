import java.util.ArrayList;

public final class ayb
{
  public static String[] a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString != null)
    {
      paramString = paramString.split(",");
      int k = paramString.length;
      int i = 0;
      if (i < k)
      {
        String str = paramString[i];
        if (str.indexOf(':') == -1) {}
        for (;;)
        {
          try
          {
            Integer.parseInt(str);
            localArrayList.add(str);
            i += 1;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            cvm.b(bbw.a, "Invalid UID value", new Object[] { localNumberFormatException });
            continue;
          }
          String[] arrayOfString = b(localNumberFormatException);
          int m = arrayOfString.length;
          int j = 0;
          while (j < m)
          {
            localArrayList.add(arrayOfString[j]);
            j += 1;
          }
        }
      }
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  private static String[] b(String paramString)
  {
    localArrayList = new ArrayList();
    if (paramString != null) {
      try
      {
        int j = paramString.indexOf(':');
        if (j > 0)
        {
          int i = Integer.parseInt(paramString.substring(0, j));
          int k = Integer.parseInt(paramString.substring(j + 1));
          j = i;
          if (i < k) {
            while (i <= k)
            {
              localArrayList.add(Integer.toString(i));
              i += 1;
            }
          }
          while (j >= k)
          {
            localArrayList.add(Integer.toString(j));
            j -= 1;
          }
        }
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
      catch (NumberFormatException paramString)
      {
        cvm.b(bbw.a, "Invalid range value", new Object[] { paramString });
      }
    }
  }
}

/* Location:
 * Qualified Name:     ayb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */