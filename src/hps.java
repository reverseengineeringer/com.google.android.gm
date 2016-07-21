import java.io.Serializable;

final class hps
  extends hqg
  implements Serializable
{
  @Deprecated
  private static final long serialVersionUID = 2249069246763182397L;
  @Deprecated
  volatile transient int a;
  @Deprecated
  transient int b;
  @Deprecated
  transient int c;
  @Deprecated
  volatile transient hpo[] d;
  @Deprecated
  final float e = 0.75F;
  
  hps(int paramInt, float paramFloat)
  {
    a(new hpo[1]);
  }
  
  final hpo a(int paramInt)
  {
    hpo[] arrayOfhpo = d;
    return arrayOfhpo[(arrayOfhpo.length - 1 & paramInt)];
  }
  
  final Object a(hpo paramhpo)
  {
    f.a();
    try
    {
      paramhpo = c;
      return paramhpo;
    }
    finally
    {
      f.b();
    }
  }
  
  final Object a(Object paramObject1, int paramInt, Object paramObject2)
  {
    f.a();
    for (;;)
    {
      int i;
      hpo[] arrayOfhpo2;
      int j;
      Object localObject3;
      try
      {
        int m = a;
        if (m > c)
        {
          hpo[] arrayOfhpo1 = d;
          int n = arrayOfhpo1.length;
          if (n < 1073741824)
          {
            i = n << 1;
            arrayOfhpo2 = new hpo[i];
            c = ((int)(i * e));
            int i1 = i - 1;
            j = 0;
            if (j < n)
            {
              localObject3 = arrayOfhpo1[j];
              if (localObject3 == null) {
                break label380;
              }
              localObject1 = d;
              i = b & i1;
              if (localObject1 != null) {
                break label389;
              }
              arrayOfhpo2[i] = localObject3;
              break label380;
              if (localObject1 == null) {
                break label396;
              }
              int k = b & i1;
              if (k == i) {
                break label377;
              }
              localObject2 = localObject1;
              i = k;
              localObject1 = d;
              continue;
              if (localObject3 == localObject2) {
                break label380;
              }
              i = b & i1;
              localObject1 = arrayOfhpo2[i];
              arrayOfhpo2[i] = new hpo(a, b, (hpo)localObject1, c);
              localObject3 = d;
              continue;
            }
            d = arrayOfhpo2;
          }
        }
        localObject3 = d;
        i = paramInt & localObject3.length - 1;
        localObject2 = localObject3[i];
        Object localObject1 = localObject2;
        if ((localObject1 != null) && ((b != paramInt) || (!paramObject1.equals(a))))
        {
          localObject1 = d;
          continue;
        }
        if (localObject1 != null)
        {
          paramObject1 = c;
          c = paramObject2;
          return paramObject1;
        }
        localObject1 = null;
        b += 1;
        localObject3[i] = new hpo(paramObject1, paramInt, (hpo)localObject2, paramObject2);
        a = (m + 1);
        paramObject1 = localObject1;
        continue;
        continue;
      }
      finally
      {
        f.b();
      }
      label377:
      label380:
      j += 1;
      continue;
      label389:
      Object localObject2 = localObject3;
      continue;
      label396:
      arrayOfhpo2[i] = localObject2;
    }
  }
  
  final void a(hpo[] paramArrayOfhpo)
  {
    c = ((int)(paramArrayOfhpo.length * e));
    d = paramArrayOfhpo;
  }
  
  final boolean a(Object paramObject)
  {
    if (a != 0)
    {
      hpo[] arrayOfhpo = d;
      int j = arrayOfhpo.length;
      int i = 0;
      while (i < j)
      {
        for (hpo localhpo = arrayOfhpo[i]; localhpo != null; localhpo = d)
        {
          Object localObject2 = c;
          Object localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = a(localhpo);
          }
          if (paramObject.equals(localObject1)) {
            return true;
          }
        }
        i += 1;
      }
    }
    return false;
  }
  
  final Object b(Object paramObject1, int paramInt, Object paramObject2)
  {
    f.a();
    try
    {
      int i = a;
      hpo[] arrayOfhpo = d;
      int j = paramInt & arrayOfhpo.length - 1;
      hpo localhpo2 = arrayOfhpo[j];
      for (hpo localhpo1 = localhpo2; (localhpo1 != null) && ((b != paramInt) || (!paramObject1.equals(a))); localhpo1 = d) {}
      Object localObject2 = null;
      paramObject1 = localObject2;
      if (localhpo1 != null)
      {
        Object localObject1 = c;
        if (paramObject2 != null)
        {
          paramObject1 = localObject2;
          if (!paramObject2.equals(localObject1)) {}
        }
        else
        {
          b += 1;
          paramObject2 = d;
          for (paramObject1 = localhpo2; paramObject1 != localhpo1; paramObject1 = d) {
            paramObject2 = new hpo(a, b, (hpo)paramObject2, c);
          }
          arrayOfhpo[j] = paramObject2;
          a = (i - 1);
          paramObject1 = localObject1;
        }
      }
      return paramObject1;
    }
    finally
    {
      f.b();
    }
  }
}

/* Location:
 * Qualified Name:     hps
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */