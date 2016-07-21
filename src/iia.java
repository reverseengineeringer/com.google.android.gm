public final class iia
  implements ihe
{
  private final hfd<String> c;
  
  public iia(Iterable<? extends String> paramIterable)
  {
    c = hfd.a(paramIterable);
  }
  
  static String a(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    boolean bool1 = false;
    String str = paramString;
    boolean bool2;
    if (i < j) {
      switch (paramString.charAt(i))
      {
      default: 
        bool2 = bool1;
      }
    }
    do
    {
      for (;;)
      {
        i += 1;
        bool1 = bool2;
        break;
        bool2 = true;
      }
      str = a(paramString, i, bool1);
      return str;
      bool2 = bool1;
    } while (bool1);
    return a(paramString, i, false);
  }
  
  private static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    int k = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(k + 16);
    int i = 0;
    if (paramInt < k)
    {
      int j = paramString.charAt(paramInt);
      Object localObject2 = null;
      Object localObject1;
      switch (j)
      {
      default: 
        localObject1 = localObject2;
        if (j >= 256)
        {
          localObject1 = localObject2;
          if (!paramBoolean) {
            switch (j)
            {
            default: 
              localObject1 = localObject2;
            }
          }
        }
        break;
      }
      for (;;)
      {
        j = i;
        if (localObject1 != null)
        {
          localStringBuilder.append(paramString, i, paramInt).append((String)localObject1);
          j = paramInt + 1;
        }
        paramInt += 1;
        i = j;
        break;
        localObject1 = "%28";
        continue;
        localObject1 = "%29";
        continue;
        localObject1 = "%7b";
        continue;
        localObject1 = "%7d";
        continue;
        localObject1 = "%d6%89";
        continue;
        localObject1 = "%d7%83";
        continue;
        localObject1 = "%e2%88%b6";
        continue;
        localObject1 = "%ef%bc%9a";
      }
    }
    return localStringBuilder.append(paramString, i, k).toString();
  }
  
  public final String apply(String paramString1, String paramString2, String paramString3)
  {
    int j = 0;
    int k = paramString3.length();
    int i = 0;
    while (i < k) {
      switch (paramString3.charAt(i))
      {
      default: 
        i += 1;
        break;
      case '#': 
      case '/': 
      case '?': 
        if (paramString3.startsWith("//"))
        {
          i = j;
          if (c.contains("http"))
          {
            i = j;
            if (c.contains("https")) {
              i = 1;
            }
          }
          if (i != 0) {}
        }
        break;
      case ':': 
        do
        {
          return null;
          paramString1 = ijj.a(paramString3.substring(0, i));
        } while (!c.contains(paramString1));
      }
    }
    return a(paramString3);
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject != null) && (getClass() == paramObject.getClass()) && (c.equals(c));
  }
  
  public final int hashCode()
  {
    return c.hashCode();
  }
}

/* Location:
 * Qualified Name:     iia
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */