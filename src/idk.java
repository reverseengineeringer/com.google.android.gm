public final class idk
{
  public boolean a = true;
  
  private final idk a(int paramInt1, int paramInt2)
  {
    if (!a) {
      return this;
    }
    if (paramInt1 == paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return this;
    }
  }
  
  private final idk a(long paramLong1, long paramLong2)
  {
    if (!a) {
      return this;
    }
    if (paramLong1 == paramLong2) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return this;
    }
  }
  
  public final idk a(Object paramObject1, Object paramObject2)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i = 0;
    if (!a) {}
    for (;;)
    {
      return this;
      if (paramObject1 != paramObject2)
      {
        if ((paramObject1 == null) || (paramObject2 == null))
        {
          a = false;
          return this;
        }
        if (!paramObject1.getClass().isArray())
        {
          a = paramObject1.equals(paramObject2);
          return this;
        }
        if (paramObject1.getClass() != paramObject2.getClass())
        {
          a = false;
          return this;
        }
        if ((paramObject1 instanceof long[]))
        {
          paramObject1 = (long[])paramObject1;
          paramObject2 = (long[])paramObject2;
          if ((a) && (paramObject1 != paramObject2))
          {
            if ((paramObject1 == null) || (paramObject2 == null))
            {
              a = false;
              return this;
            }
            if (paramObject1.length != paramObject2.length)
            {
              a = false;
              return this;
            }
            while ((i < paramObject1.length) && (a))
            {
              a(paramObject1[i], paramObject2[i]);
              i += 1;
            }
          }
        }
        else if ((paramObject1 instanceof int[]))
        {
          paramObject1 = (int[])paramObject1;
          paramObject2 = (int[])paramObject2;
          if ((a) && (paramObject1 != paramObject2))
          {
            if ((paramObject1 == null) || (paramObject2 == null))
            {
              a = false;
              return this;
            }
            i = j;
            if (paramObject1.length != paramObject2.length)
            {
              a = false;
              return this;
            }
            while ((i < paramObject1.length) && (a))
            {
              a(paramObject1[i], paramObject2[i]);
              i += 1;
            }
          }
        }
        else
        {
          label339:
          boolean bool;
          if ((paramObject1 instanceof short[]))
          {
            paramObject1 = (short[])paramObject1;
            paramObject2 = (short[])paramObject2;
            if ((a) && (paramObject1 != paramObject2))
            {
              if ((paramObject1 == null) || (paramObject2 == null))
              {
                a = false;
                return this;
              }
              if (paramObject1.length != paramObject2.length)
              {
                a = false;
                return this;
              }
              i = 0;
              if ((i < paramObject1.length) && (a))
              {
                j = paramObject1[i];
                k = paramObject2[i];
                if (a) {
                  if (j != k) {
                    break label397;
                  }
                }
              }
              label397:
              for (bool = true;; bool = false)
              {
                a = bool;
                i += 1;
                break label339;
                break;
              }
            }
          }
          else if ((paramObject1 instanceof char[]))
          {
            paramObject1 = (char[])paramObject1;
            paramObject2 = (char[])paramObject2;
            if ((a) && (paramObject1 != paramObject2))
            {
              if ((paramObject1 == null) || (paramObject2 == null))
              {
                a = false;
                return this;
              }
              if (paramObject1.length != paramObject2.length)
              {
                a = false;
                return this;
              }
              i = 0;
              label464:
              if ((i < paramObject1.length) && (a))
              {
                j = paramObject1[i];
                k = paramObject2[i];
                if (a) {
                  if (j != k) {
                    break label522;
                  }
                }
              }
              label522:
              for (bool = true;; bool = false)
              {
                a = bool;
                i += 1;
                break label464;
                break;
              }
            }
          }
          else if ((paramObject1 instanceof byte[]))
          {
            paramObject1 = (byte[])paramObject1;
            paramObject2 = (byte[])paramObject2;
            if ((a) && (paramObject1 != paramObject2))
            {
              if ((paramObject1 == null) || (paramObject2 == null))
              {
                a = false;
                return this;
              }
              if (paramObject1.length != paramObject2.length)
              {
                a = false;
                return this;
              }
              i = 0;
              label589:
              if ((i < paramObject1.length) && (a))
              {
                j = paramObject1[i];
                k = paramObject2[i];
                if (a) {
                  if (j != k) {
                    break label647;
                  }
                }
              }
              label647:
              for (bool = true;; bool = false)
              {
                a = bool;
                i += 1;
                break label589;
                break;
              }
            }
          }
          else if ((paramObject1 instanceof double[]))
          {
            paramObject1 = (double[])paramObject1;
            paramObject2 = (double[])paramObject2;
            if ((a) && (paramObject1 != paramObject2))
            {
              if ((paramObject1 == null) || (paramObject2 == null))
              {
                a = false;
                return this;
              }
              i = k;
              if (paramObject1.length != paramObject2.length)
              {
                a = false;
                return this;
              }
              while ((i < paramObject1.length) && (a))
              {
                double d1 = paramObject1[i];
                double d2 = paramObject2[i];
                if (a) {
                  a(Double.doubleToLongBits(d1), Double.doubleToLongBits(d2));
                }
                i += 1;
              }
            }
          }
          else if ((paramObject1 instanceof float[]))
          {
            paramObject1 = (float[])paramObject1;
            paramObject2 = (float[])paramObject2;
            if ((a) && (paramObject1 != paramObject2))
            {
              if ((paramObject1 == null) || (paramObject2 == null))
              {
                a = false;
                return this;
              }
              i = m;
              if (paramObject1.length != paramObject2.length)
              {
                a = false;
                return this;
              }
              while ((i < paramObject1.length) && (a))
              {
                float f1 = paramObject1[i];
                float f2 = paramObject2[i];
                if (a) {
                  a(Float.floatToIntBits(f1), Float.floatToIntBits(f2));
                }
                i += 1;
              }
            }
          }
          else if ((paramObject1 instanceof boolean[]))
          {
            paramObject1 = (boolean[])paramObject1;
            paramObject2 = (boolean[])paramObject2;
            if ((a) && (paramObject1 != paramObject2))
            {
              if ((paramObject1 == null) || (paramObject2 == null))
              {
                a = false;
                return this;
              }
              i = n;
              if (paramObject1.length != paramObject2.length)
              {
                a = false;
                return this;
              }
              while ((i < paramObject1.length) && (a))
              {
                a(paramObject1[i], paramObject2[i]);
                i += 1;
              }
            }
          }
          else
          {
            paramObject1 = (Object[])paramObject1;
            paramObject2 = (Object[])paramObject2;
            if ((a) && (paramObject1 != paramObject2))
            {
              if ((paramObject1 == null) || (paramObject2 == null))
              {
                a = false;
                return this;
              }
              i = i1;
              if (paramObject1.length != paramObject2.length)
              {
                a = false;
                return this;
              }
              while ((i < paramObject1.length) && (a))
              {
                a(paramObject1[i], paramObject2[i]);
                i += 1;
              }
            }
          }
        }
      }
    }
  }
  
  public final idk a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!a) {
      return this;
    }
    if (paramBoolean1 == paramBoolean2) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      a = paramBoolean1;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     idk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */