import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class hpl
  extends hpf
  implements Serializable, Map
{
  @Deprecated
  private static final long serialVersionUID = 7249069246763182397L;
  @Deprecated
  final int b = 15;
  @Deprecated
  final int c = 28;
  @Deprecated
  final hps[] d = new hps[16];
  @Deprecated
  transient Set e;
  @Deprecated
  transient Set f;
  @Deprecated
  transient Collection g;
  
  private hpl()
  {
    int i = 0;
    while (i < d.length)
    {
      d[i] = new hps(1, 0.75F);
      i += 1;
    }
  }
  
  public hpl(byte paramByte)
  {
    this();
  }
  
  static int a(int paramInt)
  {
    paramInt = paramInt >>> 20 ^ paramInt >>> 12 ^ paramInt;
    return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
  }
  
  private final void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    int i = 0;
    while (i < d.length)
    {
      d[i].a(new hpo[1]);
      i += 1;
    }
    for (;;)
    {
      Object localObject1 = paramObjectInputStream.readObject();
      Object localObject2 = paramObjectInputStream.readObject();
      if (localObject1 == null) {
        break;
      }
      put(localObject1, localObject2);
    }
  }
  
  private final void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.defaultWriteObject();
    int i = 0;
    while (i < d.length)
    {
      hps localhps = d[i];
      f.a();
      try
      {
        hpo[] arrayOfhpo = d;
        int j = 0;
        while (j < arrayOfhpo.length)
        {
          for (hpo localhpo = arrayOfhpo[j]; localhpo != null; localhpo = d)
          {
            paramObjectOutputStream.writeObject(a);
            paramObjectOutputStream.writeObject(c);
          }
          j += 1;
        }
        f.b();
        i += 1;
      }
      finally
      {
        f.b();
      }
    }
    paramObjectOutputStream.writeObject(null);
    paramObjectOutputStream.writeObject(null);
  }
  
  final hps b(int paramInt)
  {
    return d[(paramInt >>> c & b)];
  }
  
  public final void clear()
  {
    int i = 0;
    while (i < d.length)
    {
      hps localhps = d[i];
      if (a != 0) {
        f.a();
      }
      try
      {
        hpo[] arrayOfhpo = d;
        int j = 0;
        while (j < arrayOfhpo.length)
        {
          arrayOfhpo[j] = null;
          j += 1;
        }
        b += 1;
        a = 0;
        f.b();
        i += 1;
      }
      finally
      {
        f.b();
      }
    }
  }
  
  public final boolean containsKey(Object paramObject)
  {
    int i = a(paramObject.hashCode());
    Object localObject = b(i);
    if (a != 0) {
      for (localObject = ((hps)localObject).a(i); localObject != null; localObject = d) {
        if ((b == i) && (paramObject.equals(a))) {
          return true;
        }
      }
    }
    return false;
  }
  
  /* Error */
  public final boolean containsValue(Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 9
    //   9: aload_1
    //   10: ifnonnull +11 -> 21
    //   13: new 122	java/lang/NullPointerException
    //   16: dup
    //   17: invokespecial 123	java/lang/NullPointerException:<init>	()V
    //   20: athrow
    //   21: aload_0
    //   22: getfield 35	hpl:d	[Lhps;
    //   25: astore 10
    //   27: aload 10
    //   29: arraylength
    //   30: newarray <illegal type>
    //   32: astore 11
    //   34: iconst_0
    //   35: istore_2
    //   36: iload_2
    //   37: iconst_2
    //   38: if_icmpge +131 -> 169
    //   41: iconst_0
    //   42: istore_3
    //   43: iconst_0
    //   44: istore 4
    //   46: iload_3
    //   47: aload 10
    //   49: arraylength
    //   50: if_icmpge +58 -> 108
    //   53: aload 10
    //   55: iload_3
    //   56: aaload
    //   57: getfield 99	hps:a	I
    //   60: istore 7
    //   62: aload 10
    //   64: iload_3
    //   65: aaload
    //   66: getfield 100	hps:b	I
    //   69: istore 7
    //   71: aload 11
    //   73: iload_3
    //   74: iload 7
    //   76: iastore
    //   77: iload 4
    //   79: iload 7
    //   81: iadd
    //   82: istore 4
    //   84: aload 10
    //   86: iload_3
    //   87: aaload
    //   88: aload_1
    //   89: invokevirtual 125	hps:a	(Ljava/lang/Object;)Z
    //   92: ifeq +9 -> 101
    //   95: iconst_1
    //   96: istore 8
    //   98: iload 8
    //   100: ireturn
    //   101: iload_3
    //   102: iconst_1
    //   103: iadd
    //   104: istore_3
    //   105: goto -59 -> 46
    //   108: iload 4
    //   110: ifeq +191 -> 301
    //   113: iconst_0
    //   114: istore_3
    //   115: iload_3
    //   116: aload 10
    //   118: arraylength
    //   119: if_icmpge +182 -> 301
    //   122: aload 10
    //   124: iload_3
    //   125: aaload
    //   126: getfield 99	hps:a	I
    //   129: istore 4
    //   131: aload 11
    //   133: iload_3
    //   134: iaload
    //   135: aload 10
    //   137: iload_3
    //   138: aaload
    //   139: getfield 100	hps:b	I
    //   142: if_icmpeq +20 -> 162
    //   145: iconst_0
    //   146: istore_3
    //   147: iload 9
    //   149: istore 8
    //   151: iload_3
    //   152: ifne -54 -> 98
    //   155: iload_2
    //   156: iconst_1
    //   157: iadd
    //   158: istore_2
    //   159: goto -123 -> 36
    //   162: iload_3
    //   163: iconst_1
    //   164: iadd
    //   165: istore_3
    //   166: goto -51 -> 115
    //   169: iconst_0
    //   170: istore_2
    //   171: iload_2
    //   172: aload 10
    //   174: arraylength
    //   175: if_icmpge +20 -> 195
    //   178: aload 10
    //   180: iload_2
    //   181: aaload
    //   182: getfield 75	hqg:f	Lhqi;
    //   185: invokevirtual 79	hqi:a	()V
    //   188: iload_2
    //   189: iconst_1
    //   190: iadd
    //   191: istore_2
    //   192: goto -21 -> 171
    //   195: iconst_0
    //   196: istore_2
    //   197: iload_2
    //   198: aload 10
    //   200: arraylength
    //   201: if_icmpge +91 -> 292
    //   204: aload 10
    //   206: iload_2
    //   207: aaload
    //   208: aload_1
    //   209: invokevirtual 125	hps:a	(Ljava/lang/Object;)Z
    //   212: istore 8
    //   214: iload 8
    //   216: ifeq +33 -> 249
    //   219: iconst_1
    //   220: istore 8
    //   222: iload 5
    //   224: istore_2
    //   225: iload_2
    //   226: aload 10
    //   228: arraylength
    //   229: if_icmpge +29 -> 258
    //   232: aload 10
    //   234: iload_2
    //   235: aaload
    //   236: getfield 75	hqg:f	Lhqi;
    //   239: invokevirtual 95	hqi:b	()V
    //   242: iload_2
    //   243: iconst_1
    //   244: iadd
    //   245: istore_2
    //   246: goto -21 -> 225
    //   249: iload_2
    //   250: iconst_1
    //   251: iadd
    //   252: istore_2
    //   253: goto -56 -> 197
    //   256: aload_1
    //   257: athrow
    //   258: iload 8
    //   260: ireturn
    //   261: iload_2
    //   262: aload 10
    //   264: arraylength
    //   265: if_icmpge -9 -> 256
    //   268: aload 10
    //   270: iload_2
    //   271: aaload
    //   272: getfield 75	hqg:f	Lhqi;
    //   275: invokevirtual 95	hqi:b	()V
    //   278: iload_2
    //   279: iconst_1
    //   280: iadd
    //   281: istore_2
    //   282: goto -21 -> 261
    //   285: astore_1
    //   286: iload 6
    //   288: istore_2
    //   289: goto -28 -> 261
    //   292: iconst_0
    //   293: istore 8
    //   295: iload 5
    //   297: istore_2
    //   298: goto -73 -> 225
    //   301: iconst_1
    //   302: istore_3
    //   303: goto -156 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	hpl
    //   0	306	1	paramObject	Object
    //   35	263	2	i	int
    //   42	261	3	j	int
    //   44	86	4	k	int
    //   1	295	5	m	int
    //   4	283	6	n	int
    //   60	22	7	i1	int
    //   96	198	8	bool1	boolean
    //   7	141	9	bool2	boolean
    //   25	244	10	arrayOfhps	hps[]
    //   32	100	11	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   197	214	285	finally
  }
  
  public final Set entrySet()
  {
    Object localObject = f;
    if (localObject != null) {
      return (Set)localObject;
    }
    localObject = new hpn(this);
    f = ((Set)localObject);
    return (Set)localObject;
  }
  
  public final Object get(Object paramObject)
  {
    int i = a(paramObject.hashCode());
    hps localhps = b(i);
    if (a != 0) {
      for (hpo localhpo = localhps.a(i); localhpo != null; localhpo = d) {
        if ((b == i) && (paramObject.equals(a)))
        {
          paramObject = c;
          if (paramObject != null) {
            return paramObject;
          }
          return localhps.a(localhpo);
        }
      }
    }
    return null;
  }
  
  public final boolean isEmpty()
  {
    hps[] arrayOfhps = d;
    int[] arrayOfInt = new int[arrayOfhps.length];
    int i = 0;
    int j = 0;
    while (i < arrayOfhps.length)
    {
      if (a != 0) {
        return false;
      }
      int k = b;
      arrayOfInt[i] = k;
      j += k;
      i += 1;
    }
    if (j != 0)
    {
      i = 0;
      for (;;)
      {
        if (i >= arrayOfhps.length) {
          break label104;
        }
        if ((a != 0) || (arrayOfInt[i] != b)) {
          break;
        }
        i += 1;
      }
    }
    label104:
    return true;
  }
  
  public final Set keySet()
  {
    Object localObject = e;
    if (localObject != null) {
      return (Set)localObject;
    }
    localObject = new hpr(this);
    e = ((Set)localObject);
    return (Set)localObject;
  }
  
  public final Object put(Object paramObject1, Object paramObject2)
  {
    if (paramObject2 == null) {
      throw new NullPointerException();
    }
    int i = a(paramObject1.hashCode());
    return b(i).a(paramObject1, i, paramObject2);
  }
  
  public final void putAll(Map paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public final Object remove(Object paramObject)
  {
    int i = a(paramObject.hashCode());
    return b(i).b(paramObject, i, null);
  }
  
  public final int size()
  {
    hps[] arrayOfhps = d;
    int[] arrayOfInt = new int[arrayOfhps.length];
    int i = 0;
    long l2 = 0L;
    long l1 = 0L;
    long l4 = l2;
    long l3 = l1;
    int j;
    if (i < 2)
    {
      l3 = 0L;
      l1 = 0L;
      int k = 0;
      j = 0;
      while (j < arrayOfhps.length)
      {
        l1 += a;
        int m = b;
        arrayOfInt[j] = m;
        k += m;
        j += 1;
      }
      l2 = l3;
      if (k == 0) {
        break label290;
      }
      j = 0;
      label101:
      l2 = l3;
      if (j >= arrayOfhps.length) {
        break label290;
      }
      l3 += a;
      if (arrayOfInt[j] != b) {
        l2 = -1L;
      }
    }
    label290:
    for (;;)
    {
      l4 = l2;
      l3 = l1;
      if (l2 != l1)
      {
        i += 1;
        break;
        j += 1;
        break label101;
      }
      l2 = l3;
      if (l4 != l3)
      {
        l1 = 0L;
        i = 0;
        while (i < arrayOfhps.length)
        {
          f.a();
          i += 1;
        }
        i = 0;
        while (i < arrayOfhps.length)
        {
          l1 += a;
          i += 1;
        }
        i = 0;
        for (;;)
        {
          l2 = l1;
          if (i >= arrayOfhps.length) {
            break;
          }
          f.b();
          i += 1;
        }
      }
      if (l2 > 2147483647L) {
        return Integer.MAX_VALUE;
      }
      return (int)l2;
    }
  }
  
  public final Collection values()
  {
    Object localObject = g;
    if (localObject != null) {
      return (Collection)localObject;
    }
    localObject = new hpu(this);
    g = ((Collection)localObject);
    return (Collection)localObject;
  }
}

/* Location:
 * Qualified Name:     hpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */