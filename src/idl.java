public final class idl
{
  private static final ThreadLocal b = new ThreadLocal();
  public int a = 0;
  private final int c = 37;
  
  public final idl a(int paramInt)
  {
    a = (a * c + paramInt);
    return this;
  }
  
  public final idl a(long paramLong)
  {
    a = (a * c + (int)(paramLong >> 32 ^ paramLong));
    return this;
  }
  
  public final idl a(Object paramObject)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i = 0;
    if (paramObject == null) {
      a *= c;
    }
    for (;;)
    {
      return this;
      if (!paramObject.getClass().isArray()) {
        break;
      }
      if ((paramObject instanceof long[]))
      {
        paramObject = (long[])paramObject;
        if (paramObject == null)
        {
          a *= c;
          return this;
        }
        while (i < paramObject.length)
        {
          a(paramObject[i]);
          i += 1;
        }
      }
      else if ((paramObject instanceof int[]))
      {
        paramObject = (int[])paramObject;
        i = j;
        if (paramObject == null)
        {
          a *= c;
          return this;
        }
        while (i < paramObject.length)
        {
          a(paramObject[i]);
          i += 1;
        }
      }
      else if ((paramObject instanceof short[]))
      {
        paramObject = (short[])paramObject;
        i = k;
        if (paramObject == null)
        {
          a *= c;
          return this;
        }
        while (i < paramObject.length)
        {
          a = (paramObject[i] + a * c);
          i += 1;
        }
      }
      else if ((paramObject instanceof char[]))
      {
        paramObject = (char[])paramObject;
        i = m;
        if (paramObject == null)
        {
          a *= c;
          return this;
        }
        while (i < paramObject.length)
        {
          a = (paramObject[i] + a * c);
          i += 1;
        }
      }
      else if ((paramObject instanceof byte[]))
      {
        paramObject = (byte[])paramObject;
        i = n;
        if (paramObject == null)
        {
          a *= c;
          return this;
        }
        while (i < paramObject.length)
        {
          a = (paramObject[i] + a * c);
          i += 1;
        }
      }
      else if ((paramObject instanceof double[]))
      {
        paramObject = (double[])paramObject;
        i = i1;
        if (paramObject == null)
        {
          a *= c;
          return this;
        }
        while (i < paramObject.length)
        {
          a(Double.doubleToLongBits(paramObject[i]));
          i += 1;
        }
      }
      else if ((paramObject instanceof float[]))
      {
        paramObject = (float[])paramObject;
        i = i2;
        if (paramObject == null)
        {
          a *= c;
          return this;
        }
        while (i < paramObject.length)
        {
          float f = paramObject[i];
          j = a;
          k = c;
          a = (Float.floatToIntBits(f) + j * k);
          i += 1;
        }
      }
      else if ((paramObject instanceof boolean[]))
      {
        paramObject = (boolean[])paramObject;
        i = i3;
        if (paramObject == null)
        {
          a *= c;
          return this;
        }
        while (i < paramObject.length)
        {
          a(paramObject[i]);
          i += 1;
        }
      }
      else
      {
        paramObject = (Object[])paramObject;
        i = i4;
        if (paramObject == null)
        {
          a *= c;
          return this;
        }
        while (i < paramObject.length)
        {
          a(paramObject[i]);
          i += 1;
        }
      }
    }
    a = (a * c + paramObject.hashCode());
    return this;
  }
  
  public final idl a(boolean paramBoolean)
  {
    int j = a;
    int k = c;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      a = (i + k * j);
      return this;
    }
  }
  
  public final int hashCode()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     idl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */