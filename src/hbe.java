public final class hbe
{
  public static int a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2))
    {
      if (paramInt1 < 0) {}
      for (String str = a("%s (%s) must not be negative", new Object[] { "index", Integer.valueOf(paramInt1) });; str = a("%s (%s) must be less than size (%s)", new Object[] { "index", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }))
      {
        throw new IndexOutOfBoundsException(str);
        if (paramInt2 < 0) {
          throw new IllegalArgumentException(26 + "negative size: " + paramInt2);
        }
      }
    }
    return paramInt1;
  }
  
  public static <T> T a(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static <T> T a(T paramT, Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramObject));
    }
    return paramT;
  }
  
  static String a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 < 0) {
      return a("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException(26 + "negative size: " + paramInt2);
    }
    return a("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static String a(String paramString, Object... paramVarArgs)
  {
    int i = 0;
    paramString = String.valueOf(paramString);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + paramVarArgs.length * 16);
    int j = 0;
    while (i < paramVarArgs.length)
    {
      int k = paramString.indexOf("%s", j);
      if (k == -1) {
        break;
      }
      localStringBuilder.append(paramString, j, k);
      localStringBuilder.append(paramVarArgs[i]);
      j = k + 2;
      i += 1;
    }
    localStringBuilder.append(paramString, j, paramString.length());
    if (i < paramVarArgs.length)
    {
      localStringBuilder.append(" [");
      localStringBuilder.append(paramVarArgs[i]);
      i += 1;
      while (i < paramVarArgs.length)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(paramVarArgs[i]);
        i += 1;
      }
      localStringBuilder.append(']');
    }
    return localStringBuilder.toString();
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt2 < paramInt1) || (paramInt2 > paramInt3))
    {
      String str;
      if ((paramInt1 < 0) || (paramInt1 > paramInt3)) {
        str = a(paramInt1, paramInt3, "start index");
      }
      for (;;)
      {
        throw new IndexOutOfBoundsException(str);
        if ((paramInt2 < 0) || (paramInt2 > paramInt3)) {
          str = a(paramInt2, paramInt3, "end index");
        } else {
          str = a("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException();
    }
  }
  
  public static void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.valueOf(paramObject));
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(a(paramString, new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(a(paramString, new Object[] { paramObject }));
    }
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramInt2)) {
      throw new IndexOutOfBoundsException(a(paramInt1, paramInt2, "index"));
    }
    return paramInt1;
  }
  
  public static void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException();
    }
  }
  
  public static void b(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(String.valueOf(paramObject));
    }
  }
  
  public static void b(boolean paramBoolean, String paramString, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(a(paramString, new Object[] { paramObject }));
    }
  }
}

/* Location:
 * Qualified Name:     hbe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */