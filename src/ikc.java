import java.io.PrintStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class ikc
{
  private ikd a;
  private int b = -1;
  private int c = -1;
  private int d;
  
  public ikc()
  {
    this(1);
  }
  
  public ikc(int paramInt)
  {
    d = paramInt;
    a = new ikd();
  }
  
  private static int a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1) {
      if (!paramBoolean) {}
    }
    do
    {
      return 4;
      return 3;
      if (paramInt != 2) {
        break;
      }
    } while (paramBoolean);
    return 3;
    if (paramInt == 3) {
      return 1;
    }
    throw new IllegalArgumentException("getCred: invalid section");
  }
  
  static int a(long paramLong1, long paramLong2)
  {
    long l = paramLong1;
    if (paramLong2 >= 0L)
    {
      l = paramLong1;
      if (paramLong2 < paramLong1) {
        l = paramLong2;
      }
    }
    paramLong1 = System.currentTimeMillis() / 1000L + l;
    if ((paramLong1 < 0L) || (paramLong1 > 2147483647L)) {
      return Integer.MAX_VALUE;
    }
    return (int)paramLong1;
  }
  
  /* Error */
  private final ikf a(imj paramimj, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 53	ikc:a	(Limj;)Ljava/lang/Object;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnonnull +9 -> 18
    //   12: aconst_null
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: aload_1
    //   20: aload_3
    //   21: iload_2
    //   22: iconst_0
    //   23: invokespecial 56	ikc:a	(Limj;Ljava/lang/Object;II)Likf;
    //   26: astore_1
    //   27: goto -13 -> 14
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	ikc
    //   0	35	1	paramimj	imj
    //   0	35	2	paramInt	int
    //   7	14	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	30	finally
    //   18	27	30	finally
  }
  
  private final ikf a(imj paramimj, Object paramObject, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 255) {
      try
      {
        throw new IllegalArgumentException("oneElement(ANY)");
      }
      finally {}
    }
    int i;
    if ((paramObject instanceof List))
    {
      List localList = (List)paramObject;
      i = 0;
      if (i < localList.size())
      {
        paramObject = (ikf)localList.get(i);
        int j = ((ikf)paramObject).b();
        if (j != paramInt1) {}
      }
    }
    for (;;)
    {
      label79:
      if (paramObject == null) {
        paramObject = null;
      }
      for (;;)
      {
        return (ikf)paramObject;
        i += 1;
        break;
        paramObject = null;
        break label79;
        paramObject = (ikf)paramObject;
        if (((ikf)paramObject).b() != paramInt1) {
          break label159;
        }
        break label79;
        if (((ikf)paramObject).a())
        {
          b(paramimj, paramInt1);
          paramObject = null;
        }
        else
        {
          paramInt1 = ((ikf)paramObject).a(paramInt2);
          if (paramInt1 < 0) {
            paramObject = null;
          }
        }
      }
      label159:
      paramObject = null;
    }
  }
  
  private final Object a(imj paramimj)
  {
    try
    {
      paramimj = a.get(paramimj);
      return paramimj;
    }
    finally
    {
      paramimj = finally;
      throw paramimj;
    }
  }
  
  private final void a(imj paramimj, int paramInt1, ine paramine, int paramInt2)
  {
    if (paramine != null) {}
    for (;;)
    {
      try
      {
        long l = j;
        ikf localikf2 = a(paramimj, paramInt1);
        if (l == 0L)
        {
          if ((localikf2 != null) && (localikf2.a(paramInt2) <= 0)) {
            b(paramimj, paramInt1);
          }
          return;
        }
        ikf localikf1 = localikf2;
        if (localikf2 != null)
        {
          localikf1 = localikf2;
          if (localikf2.a(paramInt2) <= 0) {
            localikf1 = null;
          }
        }
        if (localikf1 == null)
        {
          a(paramimj, new ikg(paramimj, paramInt1, paramine, paramInt2, b));
          continue;
          l = 0L;
        }
      }
      finally {}
    }
  }
  
  private final void a(imj paramimj, ikf paramikf)
  {
    for (;;)
    {
      int j;
      try
      {
        localObject = a.get(paramimj);
        if (localObject == null)
        {
          a.put(paramimj, paramikf);
          return;
        }
        j = paramikf.b();
        if (!(localObject instanceof List)) {
          break label119;
        }
        paramimj = (List)localObject;
        int i = 0;
        if (i >= paramimj.size()) {
          break label108;
        }
        if (((ikf)paramimj.get(i)).b() == j)
        {
          paramimj.set(i, paramikf);
          continue;
        }
        i += 1;
      }
      finally {}
      continue;
      label108:
      paramimj.add(paramikf);
      continue;
      label119:
      Object localObject = (ikf)localObject;
      if (((ikf)localObject).b() == j)
      {
        a.put(paramimj, paramikf);
      }
      else
      {
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(localObject);
        localLinkedList.add(paramikf);
        a.put(paramimj, localLinkedList);
      }
    }
  }
  
  private final void a(imt paramimt, int paramInt)
  {
    for (;;)
    {
      try
      {
        long l = paramimt.d();
        imj localimj = eg;
        int i = paramimt.e().e();
        ikf localikf2 = a(localimj, i);
        if (l == 0L)
        {
          if ((localikf2 != null) && (localikf2.a(paramInt) <= 0)) {
            b(localimj, i);
          }
          return;
        }
        ikf localikf1 = localikf2;
        if (localikf2 != null)
        {
          localikf1 = localikf2;
          if (localikf2.a(paramInt) <= 0) {
            localikf1 = null;
          }
        }
        if (localikf1 == null) {
          if ((paramimt instanceof ike))
          {
            paramimt = (ike)paramimt;
            a(localimj, paramimt);
          }
          else
          {
            paramimt = new ike(paramimt, paramInt, c);
          }
        }
      }
      finally {}
    }
  }
  
  private static void a(imt paramimt, Set paramSet)
  {
    if (paramimt.e().c() == null) {}
    for (;;)
    {
      return;
      paramimt = paramimt.c();
      while (paramimt.hasNext())
      {
        imj localimj = ((imw)paramimt.next()).c();
        if (localimj != null) {
          paramSet.add(localimj);
        }
      }
    }
  }
  
  /* Error */
  private final ikf[] a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: instanceof 60
    //   6: ifeq +31 -> 37
    //   9: aload_1
    //   10: checkcast 60	java/util/List
    //   13: astore_1
    //   14: aload_1
    //   15: aload_1
    //   16: invokeinterface 64 1 0
    //   21: anewarray 70	ikf
    //   24: invokeinterface 161 2 0
    //   29: checkcast 163	[Likf;
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: aload_1
    //   38: checkcast 70	ikf
    //   41: astore_2
    //   42: iconst_1
    //   43: anewarray 70	ikf
    //   46: astore_1
    //   47: aload_1
    //   48: iconst_0
    //   49: aload_2
    //   50: aastore
    //   51: goto -18 -> 33
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	ikc
    //   0	59	1	paramObject	Object
    //   41	9	2	localikf	ikf
    // Exception table:
    //   from	to	target	type
    //   2	33	54	finally
    //   37	47	54	finally
  }
  
  private final void b(imj paramimj, int paramInt)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = a.get(paramimj);
        if (localObject == null) {
          return;
        }
        if (!(localObject instanceof List)) {
          break label111;
        }
        localObject = (List)localObject;
        int i = 0;
        if (i >= ((List)localObject).size()) {
          continue;
        }
        if (((ikf)((List)localObject).get(i)).b() == paramInt)
        {
          ((List)localObject).remove(i);
          if (((List)localObject).size() != 0) {
            continue;
          }
          a.remove(paramimj);
          continue;
        }
        i += 1;
      }
      finally {}
      continue;
      label111:
      if (((ikf)localObject).b() == paramInt) {
        a.remove(paramimj);
      }
    }
  }
  
  public final inj a(ilx paramilx)
  {
    boolean bool1 = a.b(5);
    Object localObject1 = paramilx.a();
    int m = a.a & 0xF;
    int i = 0;
    boolean bool2 = imn.a("verbosecache");
    if (((m != 0) && (m != 3)) || (localObject1 == null))
    {
      paramilx = null;
      return paramilx;
    }
    Object localObject5 = g;
    int k = h;
    int n = i;
    HashSet localHashSet = new HashSet();
    Object localObject6 = paramilx.b(1);
    int j = 0;
    Object localObject2 = localObject5;
    localObject1 = null;
    label251:
    label317:
    label391:
    Object localObject4;
    if (j < localObject6.length) {
      if (ei == n)
      {
        int i1 = localObject6[j].e().e();
        Object localObject3 = eg;
        int i2 = a(1, bool1);
        if (((i1 == k) || (k == 255)) && (((imj)localObject3).equals(localObject2)))
        {
          a(localObject6[j], i2);
          i = 1;
          localObject3 = localObject1;
          if (localObject2 == localObject5)
          {
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = new inj(6);
            }
            ((inj)localObject3).a(localObject6[j]);
          }
          a(localObject6[j], localHashSet);
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
        for (;;)
        {
          j += 1;
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          break;
          if ((i1 == 5) && (((imj)localObject3).equals(localObject2)))
          {
            a(localObject6[j], i2);
            if (localObject2 == localObject5)
            {
              localObject1 = new inj(4, localObject6[j]);
              localObject3 = ea;
              localObject2 = localObject1;
              localObject1 = localObject3;
            }
          }
          else if ((i1 == 39) && (((imj)localObject2).a((imj)localObject3)))
          {
            a(localObject6[j], i2);
            if (localObject2 == localObject5)
            {
              localObject1 = new inj(5, localObject6[j]);
              localObject3 = (ikq)localObject6[j].e();
              try
              {
                localObject3 = ((imj)localObject2).a((ikq)localObject3);
                localObject2 = localObject1;
                localObject1 = localObject3;
              }
              catch (imk localimk)
              {
                localObject4 = localObject1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      imt[] arrayOfimt = paramilx.b(2);
      localObject5 = null;
      localObject1 = null;
      j = 0;
      if (j < arrayOfimt.length)
      {
        Object localObject7;
        if ((arrayOfimt[j].e().e() == 6) && (((imj)localObject2).a(eg)))
        {
          localObject7 = arrayOfimt[j];
          localObject6 = localObject5;
        }
        for (;;)
        {
          j += 1;
          localObject5 = localObject6;
          localObject1 = localObject7;
          break;
          localObject6 = localObject5;
          localObject7 = localObject1;
          if (arrayOfimt[j].e().e() == 2)
          {
            localObject6 = localObject5;
            localObject7 = localObject1;
            if (((imj)localObject2).a(eg))
            {
              localObject6 = arrayOfimt[j];
              localObject7 = localObject1;
            }
          }
        }
      }
      if (i == 0) {
        if (m == 3)
        {
          i = 0;
          if ((m != 3) && (localObject1 == null) && (localObject5 != null)) {
            break label747;
          }
          j = a(2, bool1);
          localObject5 = null;
          if (localObject1 != null) {
            localObject5 = (ine)((imt)localObject1).e();
          }
          a((imj)localObject2, i, (ine)localObject5, j);
          localObject1 = localObject4;
          if (localObject4 == null)
          {
            if (m != 3) {
              break label742;
            }
            i = 1;
            label650:
            localObject1 = inj.a(i);
          }
        }
      }
      for (;;)
      {
        paramilx = paramilx.b(3);
        i = 0;
        while (i < paramilx.length)
        {
          j = paramilx[i].e().e();
          if (((j == 1) || (j == 28) || (j == 38)) && (localHashSet.contains(eg)))
          {
            j = a(3, bool1);
            a(paramilx[i], j);
          }
          i += 1;
        }
        i = k;
        break;
        label742:
        i = 2;
        break label650;
        label747:
        a((imt)localObject5, a(2, bool1));
        a((imt)localObject5, localHashSet);
        localObject1 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = new inj(3, (imt)localObject5);
          continue;
          localObject1 = localObject4;
          if (m == 0)
          {
            localObject1 = localObject4;
            if (localObject5 != null)
            {
              a((imt)localObject5, a(2, bool1));
              a((imt)localObject5, localHashSet);
              localObject1 = localObject4;
            }
          }
        }
      }
      paramilx = (ilx)localObject1;
      if (!bool2) {
        break;
      }
      paramilx = System.out;
      localObject2 = String.valueOf(localObject1);
      paramilx.println(String.valueOf(localObject2).length() + 12 + "addMessage: " + (String)localObject2);
      return (inj)localObject1;
      break label391;
      localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject4;
      break label251;
      break label317;
      localObject4 = localObject1;
    }
  }
  
  protected final inj a(imj paramimj, int paramInt1, int paramInt2)
  {
    int n;
    int j;
    int i;
    imj localimj;
    label25:
    int k;
    int m;
    label78:
    label119:
    label175:
    label183:
    label187:
    try
    {
      n = paramimj.a();
      j = n;
    }
    finally {}
    if (i != 0)
    {
      Object localObject2;
      Object localObject1;
      ikf localikf;
      for (localimj = imj.a;; localimj = new imj(paramimj, n - j))
      {
        localObject2 = a.get(localimj);
        if (localObject2 == null) {
          break label484;
        }
        if ((k == 0) || (paramInt1 != 255)) {
          break label187;
        }
        localObject1 = new inj(6);
        ikf[] arrayOfikf = a(localObject2);
        i = 0;
        m = 0;
        if (m >= arrayOfikf.length) {
          break label175;
        }
        localikf = arrayOfikf[m];
        if (!localikf.a()) {
          break;
        }
        b(localimj, localikf.b());
        break label452;
      }
      if (((localikf instanceof ike)) && (localikf.a(paramInt2) >= 0))
      {
        ((inj)localObject1).a((ike)localikf);
        i += 1;
        break label452;
        if (i > 0) {
          paramimj = (imj)localObject1;
        }
        for (;;)
        {
          return paramimj;
          if (k != 0)
          {
            localObject1 = a(localimj, localObject2, paramInt1, paramInt2);
            if ((localObject1 != null) && ((localObject1 instanceof ike)))
            {
              paramimj = new inj(6);
              paramimj.a((ike)localObject1);
              continue;
            }
            if (localObject1 != null)
            {
              paramimj = new inj(2);
              continue;
            }
            localObject1 = a(localimj, localObject2, 5, paramInt2);
            if ((localObject1 != null) && ((localObject1 instanceof ike))) {
              paramimj = new inj(4, (ike)localObject1);
            }
          }
          else
          {
            localObject1 = a(localimj, localObject2, 39, paramInt2);
            if ((localObject1 != null) && ((localObject1 instanceof ike)))
            {
              paramimj = new inj(5, (ike)localObject1);
              continue;
            }
          }
          localObject1 = a(localimj, localObject2, 2, paramInt2);
          if ((localObject1 != null) && ((localObject1 instanceof ike)))
          {
            paramimj = new inj(3, (ike)localObject1);
          }
          else
          {
            if ((k == 0) || (a(localimj, localObject2, 0, paramInt2) == null)) {
              break;
            }
            paramimj = inj.a(1);
          }
        }
      }
    }
    label452:
    label467:
    label484:
    label491:
    for (;;)
    {
      paramimj = inj.a(0);
      break label183;
      for (;;)
      {
        if (j <= 0) {
          break label491;
        }
        if (j == 1) {}
        for (i = 1;; i = 0)
        {
          if (j != n) {
            break label467;
          }
          k = 1;
          break;
          m += 1;
          break label78;
        }
        k = 0;
        break;
        if (k == 0) {
          break label119;
        }
        localimj = paramimj;
        break label25;
        j -= 1;
      }
    }
  }
  
  public final void a()
  {
    try
    {
      a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      Iterator localIterator = a.values().iterator();
      while (localIterator.hasNext())
      {
        ikf[] arrayOfikf = a(localIterator.next());
        int i = 0;
        while (i < arrayOfikf.length)
        {
          localStringBuffer.append(arrayOfikf[i]);
          localStringBuffer.append("\n");
          i += 1;
        }
      }
      return localStringBuffer.toString();
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     ikc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */