import java.io.Reader;
import java.util.Enumeration;
import java.util.Vector;

public final class ifw
  implements ifz, igb
{
  private static int[] n = { 2, -2147467200, 8, -2147467200, 80, -2147467200, -2147467200, -2147467200, 8, -2147467200, 256, 264, 8, -2147467264, -2147467264, -2147467264, -2147466752, 512, -2147467264, 16896, 512, 278528 };
  private static int[] o = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  public igd a = new igd();
  public iga b;
  igg c;
  public igi d;
  public igi e;
  public boolean f = false;
  private int h;
  private igi i;
  private igi j;
  private int k;
  private int l;
  private final int[] m = new int[22];
  private final ifx[] p = new ifx[2];
  private boolean q = false;
  private int r = 0;
  private final ify s = new ify();
  private Vector<int[]> t = new Vector();
  private int[] u;
  private int v = -1;
  private int[] w = new int[100];
  private int x;
  
  public ifw(Reader paramReader)
  {
    c = new igg(paramReader);
    b = new iga(c);
    d = new igi();
    h = -1;
    l = 0;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= 22) {
        break;
      }
      m[i1] = -1;
      i1 += 1;
    }
    while (i2 < p.length)
    {
      p[i2] = new ifx();
      i2 += 1;
    }
  }
  
  private final igi a(int paramInt)
  {
    int i1 = 0;
    Object localObject1 = d;
    Object localObject2;
    if (g != null)
    {
      d = d.g;
      h = -1;
      if (d.a != paramInt) {
        break label163;
      }
      l += 1;
      paramInt = r + 1;
      r = paramInt;
      if (paramInt > 100)
      {
        r = 0;
        paramInt = i1;
      }
    }
    else
    {
      for (;;)
      {
        if (paramInt >= p.length) {
          break label158;
        }
        localObject1 = p[paramInt];
        for (;;)
        {
          if (localObject1 != null)
          {
            if (a < l) {
              b = null;
            }
            localObject1 = d;
            continue;
            localObject2 = d;
            igi localigi = b.a();
            g = localigi;
            d = localigi;
            break;
          }
        }
        paramInt += 1;
      }
    }
    label158:
    return d;
    label163:
    d = ((igi)localObject1);
    v = paramInt;
    t.removeAllElements();
    localObject1 = new boolean[34];
    paramInt = 0;
    while (paramInt < 34)
    {
      localObject1[paramInt] = 0;
      paramInt += 1;
    }
    if (v >= 0)
    {
      localObject1[v] = 1;
      v = -1;
    }
    paramInt = 0;
    while (paramInt < 22)
    {
      if (m[paramInt] == l)
      {
        i1 = 0;
        while (i1 < 32)
        {
          if ((n[paramInt] & 1 << i1) != 0) {
            localObject1[i1] = 1;
          }
          if ((o[paramInt] & 1 << i1) != 0) {
            localObject1[(i1 + 32)] = 1;
          }
          i1 += 1;
        }
      }
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < 34)
    {
      if (localObject1[paramInt] != 0)
      {
        u = new int[1];
        u[0] = paramInt;
        t.addElement(u);
      }
      paramInt += 1;
    }
    x = 0;
    q = true;
    paramInt = 0;
    for (;;)
    {
      if (paramInt < 2) {}
      try
      {
        localObject1 = p[paramInt];
        if (a > l)
        {
          k = c;
          localObject2 = b;
          i = ((igi)localObject2);
          j = ((igi)localObject2);
          switch (paramInt)
          {
          }
        }
        for (;;)
        {
          localObject2 = d;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          break label540;
          k();
          continue;
          l();
          continue;
          q = false;
          a(0, 0);
          localObject1 = new int[t.size()][];
          paramInt = 0;
          while (paramInt < t.size())
          {
            localObject1[paramInt] = ((int[])t.elementAt(paramInt));
            paramInt += 1;
          }
          throw new igf(d, (int[][])localObject1, a_);
        }
      }
      catch (ify localify)
      {
        label540:
        for (;;) {}
      }
      paramInt += 1;
    }
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 100) {}
    do
    {
      return;
      if (paramInt2 == x + 1)
      {
        localObject = w;
        paramInt2 = x;
        x = (paramInt2 + 1);
        localObject[paramInt2] = paramInt1;
        return;
      }
    } while (x == 0);
    u = new int[x];
    int i1 = 0;
    while (i1 < x)
    {
      u[i1] = w[i1];
      i1 += 1;
    }
    Object localObject = t.elements();
    i1 = 0;
    label98:
    label133:
    label157:
    int i2;
    if (((Enumeration)localObject).hasMoreElements())
    {
      int[] arrayOfInt = (int[])((Enumeration)localObject).nextElement();
      if (arrayOfInt.length != u.length) {
        break label221;
      }
      i1 = 0;
      if (i1 >= u.length) {
        break label216;
      }
      if (arrayOfInt[i1] != u[i1])
      {
        i1 = 0;
        i2 = i1;
        if (i1 != 0) {
          break label177;
        }
      }
    }
    label177:
    label216:
    label221:
    for (;;)
    {
      break label98;
      i1 += 1;
      break label133;
      i2 = i1;
      if (i2 == 0) {
        t.addElement(u);
      }
      if (paramInt2 == 0) {
        break;
      }
      localObject = w;
      x = paramInt2;
      localObject[(paramInt2 - 1)] = paramInt1;
      return;
      i1 = 1;
      break label157;
    }
  }
  
  private final void a(ige paramige)
  {
    a = c(1);
  }
  
  private final void b()
  {
    int i2 = 1;
    ifm localifm = new ifm();
    a.b();
    a(localifm);
    try
    {
      if (h())
      {
        f();
        a.a(localifm);
        b(localifm);
        return;
      }
      if (h == -1)
      {
        i1 = m();
        break label467;
        label67:
        m[5] = l;
        a(-1);
        throw new igf();
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        a.a();
        try
        {
          if (!(localThrowable1 instanceof RuntimeException)) {
            break;
          }
          throw ((RuntimeException)localThrowable1);
        }
        finally
        {
          i1 = 0;
        }
        label114:
        if (i1 != 0)
        {
          a.a(localifm);
          b(localifm);
        }
        throw ((Throwable)localObject1);
        i1 = h;
        break label467;
        d();
      }
      e();
      if (h == -1)
      {
        i1 = m();
        break label513;
        label170:
        m[4] = l;
        a(-1);
        throw new igf();
      }
      else
      {
        i1 = h;
        break label513;
        localifq = new ifq();
        a.b();
        a(localifq);
      }
    }
    finally
    {
      try
      {
        a(4);
        if (h == -1)
        {
          i1 = m();
          break label543;
          label246:
          m[7] = l;
        }
        else
        {
          for (;;)
          {
            label257:
            if (h != -1) {
              break label367;
            }
            i1 = m();
            break label583;
            label273:
            m[8] = l;
            a(5);
            a.a(localifq);
            b(localifq);
            break;
            i1 = h;
            break label543;
            c();
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        ifq localifq;
        a.a();
        try
        {
          if (!(localThrowable2 instanceof RuntimeException)) {
            break label426;
          }
          throw ((RuntimeException)localThrowable2);
        }
        finally
        {
          i1 = 0;
        }
        if (i1 != 0)
        {
          a.a(localifq);
          b(localifq);
        }
        throw ((Throwable)localObject2);
        label367:
        i1 = h;
        break label583;
        a(3);
        if (h == -1) {
          i1 = m();
        }
        for (;;)
        {
          m[9] = l;
          break label257;
          i1 = h;
          break label607;
          c();
          break label257;
          label426:
          if ((localObject2 instanceof igf)) {
            throw ((igf)localObject2);
          }
          throw ((Error)localObject2);
          d();
          break;
          if ((localObject2 instanceof igf)) {
            throw ((igf)localObject2);
          }
          throw ((Error)localObject2);
          label467:
          switch (i1)
          {
          }
          break label67;
          localObject3 = finally;
          i1 = i2;
          break label114;
          label513:
          switch (i1)
          {
          }
          break label170;
          label543:
          switch (i1)
          {
          }
          break label246;
          label583:
          switch (i1)
          {
          }
          break label273;
          label607:
          switch (i1)
          {
          }
        }
      }
      finally
      {
        for (;;)
        {
          int i1 = 1;
        }
      }
    }
  }
  
  private final void b(int paramInt1, int paramInt2)
  {
    for (ifx localifx1 = p[paramInt1];; localifx1 = d)
    {
      ifx localifx2 = localifx1;
      if (a > l)
      {
        if (d == null)
        {
          localifx2 = new ifx();
          d = localifx2;
        }
      }
      else
      {
        a = (l + Integer.MAX_VALUE - k);
        b = d;
        c = Integer.MAX_VALUE;
        return;
      }
    }
  }
  
  private final void b(ige paramige)
  {
    b = c(0);
  }
  
  private final boolean b(int paramInt)
  {
    boolean bool2 = false;
    igi localigi1;
    if (i == j)
    {
      k -= 1;
      if (i.g == null)
      {
        localigi1 = i;
        igi localigi2 = b.a();
        g = localigi2;
        i = localigi2;
        j = localigi2;
      }
    }
    while (q)
    {
      localigi1 = d;
      int i1 = 0;
      for (;;)
      {
        if ((localigi1 != null) && (localigi1 != i))
        {
          i1 += 1;
          localigi1 = g;
          continue;
          localigi1 = i.g;
          i = localigi1;
          j = localigi1;
          break;
          i = i.g;
          break;
        }
      }
      if (localigi1 != null) {
        a(paramInt, i1);
      }
    }
    boolean bool1;
    if (i.a != paramInt) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (k != 0);
      bool1 = bool2;
    } while (i != j);
    throw s;
  }
  
  private final igi c(int paramInt)
  {
    int i1;
    if (f)
    {
      localObject = i;
      i1 = 0;
      label14:
      if (i1 >= paramInt) {
        return localObject;
      }
      if (g == null) {
        break label46;
      }
    }
    label46:
    igi localigi;
    for (Object localObject = g;; localObject = localigi)
    {
      i1 += 1;
      break label14;
      localObject = d;
      break;
      localigi = b.a();
      g = localigi;
    }
    return (igi)localObject;
  }
  
  /* Error */
  private final void c()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: new 232	ifs
    //   5: dup
    //   6: invokespecial 233	ifs:<init>	()V
    //   9: astore 4
    //   11: aload_0
    //   12: getfield 62	ifw:a	Ligd;
    //   15: invokevirtual 198	igd:b	()V
    //   18: aload_0
    //   19: aload 4
    //   21: invokespecial 200	ifw:a	(Lige;)V
    //   24: aload_0
    //   25: invokespecial 235	ifw:i	()Z
    //   28: ifeq +23 -> 51
    //   31: aload_0
    //   32: invokespecial 204	ifw:f	()V
    //   35: aload_0
    //   36: getfield 62	ifw:a	Ligd;
    //   39: aload 4
    //   41: invokevirtual 205	igd:a	(Lige;)V
    //   44: aload_0
    //   45: aload 4
    //   47: invokespecial 207	ifw:b	(Lige;)V
    //   50: return
    //   51: aload_0
    //   52: getfield 108	ifw:h	I
    //   55: iconst_m1
    //   56: if_icmpne +80 -> 136
    //   59: aload_0
    //   60: invokespecial 209	ifw:m	()I
    //   63: istore_1
    //   64: goto +219 -> 283
    //   67: aload_0
    //   68: getfield 66	ifw:m	[I
    //   71: bipush 6
    //   73: aload_0
    //   74: getfield 110	ifw:l	I
    //   77: iastore
    //   78: aload_0
    //   79: iconst_m1
    //   80: invokespecial 211	ifw:a	(I)Ligi;
    //   83: pop
    //   84: new 164	igf
    //   87: dup
    //   88: invokespecial 212	igf:<init>	()V
    //   91: athrow
    //   92: astore_3
    //   93: aload_0
    //   94: getfield 62	ifw:a	Ligd;
    //   97: invokevirtual 214	igd:a	()V
    //   100: aload_3
    //   101: instanceof 216
    //   104: ifeq +156 -> 260
    //   107: aload_3
    //   108: checkcast 216	java/lang/RuntimeException
    //   111: athrow
    //   112: astore_3
    //   113: iconst_0
    //   114: istore_1
    //   115: iload_1
    //   116: ifeq +18 -> 134
    //   119: aload_0
    //   120: getfield 62	ifw:a	Ligd;
    //   123: aload 4
    //   125: invokevirtual 205	igd:a	(Lige;)V
    //   128: aload_0
    //   129: aload 4
    //   131: invokespecial 207	ifw:b	(Lige;)V
    //   134: aload_3
    //   135: athrow
    //   136: aload_0
    //   137: getfield 108	ifw:h	I
    //   140: istore_1
    //   141: goto +142 -> 283
    //   144: aload_0
    //   145: invokespecial 218	ifw:d	()V
    //   148: goto -113 -> 35
    //   151: new 237	ift
    //   154: dup
    //   155: invokespecial 238	ift:<init>	()V
    //   158: astore 5
    //   160: aload_0
    //   161: getfield 62	ifw:a	Ligd;
    //   164: invokevirtual 198	igd:b	()V
    //   167: aload_0
    //   168: aload 5
    //   170: invokespecial 200	ifw:a	(Lige;)V
    //   173: aload_0
    //   174: invokespecial 220	ifw:e	()V
    //   177: aload_0
    //   178: invokespecial 218	ifw:d	()V
    //   181: aload_0
    //   182: getfield 62	ifw:a	Ligd;
    //   185: aload 5
    //   187: invokevirtual 205	igd:a	(Lige;)V
    //   190: aload_0
    //   191: aload 5
    //   193: invokespecial 207	ifw:b	(Lige;)V
    //   196: goto -161 -> 35
    //   199: astore_3
    //   200: aload_0
    //   201: getfield 62	ifw:a	Ligd;
    //   204: invokevirtual 214	igd:a	()V
    //   207: aload_3
    //   208: instanceof 216
    //   211: ifeq +32 -> 243
    //   214: aload_3
    //   215: checkcast 216	java/lang/RuntimeException
    //   218: athrow
    //   219: astore_3
    //   220: iconst_0
    //   221: istore_1
    //   222: iload_1
    //   223: ifeq +18 -> 241
    //   226: aload_0
    //   227: getfield 62	ifw:a	Ligd;
    //   230: aload 5
    //   232: invokevirtual 205	igd:a	(Lige;)V
    //   235: aload_0
    //   236: aload 5
    //   238: invokespecial 207	ifw:b	(Lige;)V
    //   241: aload_3
    //   242: athrow
    //   243: aload_3
    //   244: instanceof 164
    //   247: ifeq +8 -> 255
    //   250: aload_3
    //   251: checkcast 164	igf
    //   254: athrow
    //   255: aload_3
    //   256: checkcast 227	java/lang/Error
    //   259: athrow
    //   260: aload_3
    //   261: instanceof 164
    //   264: ifeq +8 -> 272
    //   267: aload_3
    //   268: checkcast 164	igf
    //   271: athrow
    //   272: aload_3
    //   273: checkcast 227	java/lang/Error
    //   276: athrow
    //   277: astore_3
    //   278: iconst_1
    //   279: istore_1
    //   280: goto -58 -> 222
    //   283: iload_1
    //   284: lookupswitch	default:+36->320, 6:+-140->144, 14:+-133->151, 31:+-133->151
    //   320: goto -253 -> 67
    //   323: astore_3
    //   324: iload_2
    //   325: istore_1
    //   326: goto -211 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	ifw
    //   63	263	1	i1	int
    //   1	324	2	i2	int
    //   92	16	3	localThrowable1	Throwable
    //   112	23	3	localObject1	Object
    //   199	16	3	localThrowable2	Throwable
    //   219	54	3	localObject2	Object
    //   277	1	3	localObject3	Object
    //   323	1	3	localObject4	Object
    //   9	121	4	localifs	ifs
    //   158	79	5	localift	ift
    // Exception table:
    //   from	to	target	type
    //   24	35	92	java/lang/Throwable
    //   51	64	92	java/lang/Throwable
    //   67	92	92	java/lang/Throwable
    //   136	141	92	java/lang/Throwable
    //   144	148	92	java/lang/Throwable
    //   151	173	92	java/lang/Throwable
    //   181	196	92	java/lang/Throwable
    //   226	241	92	java/lang/Throwable
    //   241	243	92	java/lang/Throwable
    //   100	112	112	finally
    //   260	272	112	finally
    //   272	277	112	finally
    //   173	181	199	java/lang/Throwable
    //   207	219	219	finally
    //   243	255	219	finally
    //   255	260	219	finally
    //   173	181	277	finally
    //   200	207	277	finally
    //   24	35	323	finally
    //   51	64	323	finally
    //   67	92	323	finally
    //   93	100	323	finally
    //   136	141	323	finally
    //   144	148	323	finally
    //   151	173	323	finally
    //   181	196	323	finally
    //   226	241	323	finally
    //   241	243	323	finally
  }
  
  private final void d()
  {
    i2 = 1;
    localifo = new ifo();
    a.b();
    a(localifo);
    try
    {
      a(6);
      if (h != -1) {
        break label85;
      }
      i1 = m();
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        a.a();
        try
        {
          if (!(localThrowable1 instanceof RuntimeException)) {
            break label351;
          }
          throw ((RuntimeException)localThrowable1);
        }
        finally
        {
          i1 = 0;
        }
        if (i1 != 0)
        {
          a.a(localifo);
          b(localifo);
        }
        throw ((Throwable)localObject1);
        i1 = h;
        break label395;
        a(3);
        if (h != -1) {
          break;
        }
        i1 = m();
        break label427;
        m[12] = l;
        a(8);
        g();
      }
    }
    finally
    {
      for (;;)
      {
        int i1;
        ifv localifv;
        switch (i1)
        {
        }
        continue;
        switch (i1)
        {
        }
        continue;
        switch (i1)
        {
        }
      }
    }
    m[10] = l;
    for (;;)
    {
      f();
      a(7);
      a.a(localifo);
      b(localifo);
      return;
      label85:
      i1 = h;
      break label374;
      localifv = new ifv();
      a.b();
      a(localifv);
      try
      {
        a(8);
        g();
        if (h != -1) {
          break label221;
        }
        i1 = m();
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          a.a();
          try
          {
            if (!(localThrowable2 instanceof RuntimeException)) {
              break;
            }
            throw ((RuntimeException)localThrowable2);
          }
          finally
          {
            i1 = 0;
          }
          if (i1 != 0)
          {
            a.a(localifv);
            b(localifv);
          }
          throw ((Throwable)localObject2);
          localObject3 = finally;
          i1 = i2;
        }
        i1 = h;
        break label427;
        if (!(localObject3 instanceof igf)) {
          break label346;
        }
        throw ((igf)localObject3);
        throw ((Error)localObject3);
        if (!(localObject3 instanceof igf)) {
          break label363;
        }
        throw ((igf)localObject3);
        throw ((Error)localObject3);
      }
      finally
      {
        for (;;)
        {
          i1 = 1;
        }
      }
      m[11] = l;
      a(4);
      a.a(localifv);
      b(localifv);
    }
  }
  
  private final void e()
  {
    ifu localifu = new ifu();
    a.b();
    a(localifu);
    try
    {
      if (h != -1) {
        break label77;
      }
      i1 = m();
    }
    finally
    {
      a.a(localifu);
      b(localifu);
    }
    m[13] = l;
    a(-1);
    throw new igf();
    label77:
    int i1 = h;
    break label151;
    a(14);
    label92:
    if (h == -1) {
      i1 = m();
    }
    for (;;)
    {
      m[14] = l;
      a.a(localifu);
      b(localifu);
      return;
      a(31);
      break label92;
      i1 = h;
      break label183;
      label151:
      switch (i1)
      {
      }
      break;
      label183:
      switch (i1)
      {
      }
    }
  }
  
  private final void f()
  {
    ifl localifl = new ifl();
    int i2 = 1;
    a.b();
    a(localifl);
    int i1 = i2;
    ifr localifr;
    try
    {
      localifr = new ifr();
      i1 = i2;
      a.b();
      i1 = i2;
      a(localifr);
      try
      {
        if (h != -1) {
          break label167;
        }
        i1 = m();
      }
      finally
      {
        i1 = i2;
        a.a(localifr);
        i1 = i2;
        b(localifr);
        i1 = i2;
      }
      m[15] = l;
      a(-1);
      throw new igf();
    }
    catch (Throwable localThrowable)
    {
      i1 = i2;
      a.a();
      i2 = 0;
      i1 = i2;
      if (!(localThrowable instanceof RuntimeException)) {
        break label432;
      }
      i1 = i2;
      throw ((RuntimeException)localThrowable);
    }
    finally
    {
      if (i1 != 0)
      {
        a.a(localifl);
        b(localifl);
      }
    }
    label167:
    i1 = h;
    break label455;
    for (igi localigi = a(14); h == -1; localigi = a(31))
    {
      label182:
      i1 = m();
      break label487;
      label198:
      m[16] = l;
      i1 = i2;
      a.a(localifr);
      i1 = i2;
      b(localifr);
      i1 = i2;
      a(8);
      i1 = i2;
      g();
      a.a(localifl);
      b(localifl);
      return;
    }
    i1 = h;
    break label487;
    if (h == -1)
    {
      i1 = m();
      break label527;
      label293:
      m[17] = l;
    }
    else
    {
      while ((f.charAt(f.length() - 1) != '.') || (a == 31))
      {
        throw new igf("Words in local part must be separated by '.'");
        i1 = h;
        break label527;
        localigi = a(9);
      }
      if (h == -1)
      {
        i1 = m();
        break label551;
      }
    }
    for (;;)
    {
      m[18] = l;
      a(-1);
      throw new igf();
      i1 = h;
      break label551;
      localigi = a(14);
      break label182;
      localigi = a(31);
      break label182;
      label432:
      i1 = i2;
      if ((localigi instanceof igf))
      {
        i1 = i2;
        throw ((igf)localigi);
      }
      i1 = i2;
      throw ((Error)localigi);
      label455:
      switch (i1)
      {
      }
      break;
      label487:
      switch (i1)
      {
      }
      break label198;
      label527:
      switch (i1)
      {
      }
      break label293;
      label551:
      switch (i1)
      {
      }
    }
  }
  
  private final void g()
  {
    ifp localifp = new ifp();
    a.b();
    a(localifp);
    try
    {
      if (h != -1) {
        break label77;
      }
      i1 = m();
    }
    finally
    {
      a.a(localifp);
      b(localifp);
    }
    m[21] = l;
    a(-1);
    throw new igf();
    label77:
    int i1 = h;
    break label238;
    igi localigi = a(14);
    label92:
    if (h == -1)
    {
      i1 = m();
      break label267;
      label108:
      m[19] = l;
      label119:
      a.a(localifp);
      b(localifp);
    }
    else
    {
      i1 = h;
      break label267;
      if (h == -1)
      {
        i1 = m();
        break label299;
      }
    }
    for (;;)
    {
      m[20] = l;
      while (f.charAt(f.length() - 1) != '.')
      {
        throw new igf("Atoms in domain names must be separated by '.'");
        i1 = h;
        break label299;
        localigi = a(9);
      }
      localigi = a(14);
      break label92;
      a(18);
      break label119;
      label238:
      switch (i1)
      {
      }
      break;
      label267:
      switch (i1)
      {
      }
      break label108;
      label299:
      switch (i1)
      {
      }
    }
  }
  
  /* Error */
  private final boolean h()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: ldc -28
    //   5: putfield 141	ifw:k	I
    //   8: aload_0
    //   9: getfield 106	ifw:d	Ligi;
    //   12: astore_3
    //   13: aload_0
    //   14: aload_3
    //   15: putfield 143	ifw:i	Ligi;
    //   18: aload_0
    //   19: aload_3
    //   20: putfield 145	ifw:j	Ligi;
    //   23: aload_0
    //   24: invokespecial 148	ifw:k	()Z
    //   27: istore_2
    //   28: iload_2
    //   29: ifne +12 -> 41
    //   32: aload_0
    //   33: iconst_0
    //   34: ldc -28
    //   36: invokespecial 279	ifw:b	(II)V
    //   39: iload_1
    //   40: ireturn
    //   41: iconst_0
    //   42: istore_1
    //   43: goto -11 -> 32
    //   46: astore_3
    //   47: aload_0
    //   48: iconst_0
    //   49: ldc -28
    //   51: invokespecial 279	ifw:b	(II)V
    //   54: iconst_1
    //   55: ireturn
    //   56: astore_3
    //   57: aload_0
    //   58: iconst_0
    //   59: ldc -28
    //   61: invokespecial 279	ifw:b	(II)V
    //   64: aload_3
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	ifw
    //   1	42	1	bool1	boolean
    //   27	2	2	bool2	boolean
    //   12	8	3	localigi	igi
    //   46	1	3	localify	ify
    //   56	9	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	28	46	ify
    //   23	28	56	finally
  }
  
  /* Error */
  private final boolean i()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc -28
    //   3: putfield 141	ifw:k	I
    //   6: aload_0
    //   7: getfield 106	ifw:d	Ligi;
    //   10: astore_2
    //   11: aload_0
    //   12: aload_2
    //   13: putfield 143	ifw:i	Ligi;
    //   16: aload_0
    //   17: aload_2
    //   18: putfield 145	ifw:j	Ligi;
    //   21: aload_0
    //   22: invokespecial 150	ifw:l	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifne +14 -> 41
    //   30: iconst_1
    //   31: istore_1
    //   32: aload_0
    //   33: iconst_1
    //   34: ldc -28
    //   36: invokespecial 279	ifw:b	(II)V
    //   39: iload_1
    //   40: ireturn
    //   41: iconst_0
    //   42: istore_1
    //   43: goto -11 -> 32
    //   46: astore_2
    //   47: aload_0
    //   48: iconst_1
    //   49: ldc -28
    //   51: invokespecial 279	ifw:b	(II)V
    //   54: iconst_1
    //   55: ireturn
    //   56: astore_2
    //   57: aload_0
    //   58: iconst_1
    //   59: ldc -28
    //   61: invokespecial 279	ifw:b	(II)V
    //   64: aload_2
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	ifw
    //   25	18	1	bool	boolean
    //   10	8	2	localigi	igi
    //   46	1	2	localify	ify
    //   56	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	26	46	ify
    //   21	26	56	finally
  }
  
  private final boolean j()
  {
    igi localigi1 = i;
    int i1;
    if (b(14))
    {
      i = localigi1;
      if (b(31))
      {
        i1 = 1;
        if (i1 == 0) {
          break label109;
        }
      }
    }
    label107:
    label109:
    label214:
    label216:
    label219:
    for (;;)
    {
      return true;
      igi localigi2;
      for (;;)
      {
        localigi1 = i;
        localigi2 = i;
        if (b(9)) {
          i = localigi2;
        }
        localigi2 = i;
        if (b(14))
        {
          i = localigi2;
          if (!b(31)) {}
        }
        for (i1 = 1;; i1 = 0)
        {
          if (i1 == 0) {
            break label107;
          }
          i = localigi1;
          i1 = 0;
          break;
        }
      }
      if (!b(8))
      {
        localigi1 = i;
        if (b(14))
        {
          i1 = 1;
          if (i1 == 0) {
            break label216;
          }
          i = localigi1;
          if (!b(18)) {
            break label216;
          }
        }
        for (i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {
            break label219;
          }
          return false;
          for (;;)
          {
            localigi2 = i;
            igi localigi3 = i;
            if (b(9)) {
              i = localigi3;
            }
            if (b(14)) {}
            for (i1 = 1;; i1 = 0)
            {
              if (i1 == 0) {
                break label214;
              }
              i = localigi2;
              i1 = 0;
              break;
            }
          }
        }
      }
    }
  }
  
  private final boolean k()
  {
    return j();
  }
  
  private final boolean l()
  {
    return j();
  }
  
  private final int m()
  {
    igi localigi1 = d.g;
    e = localigi1;
    if (localigi1 == null)
    {
      localigi1 = d;
      igi localigi2 = b.a();
      g = localigi2;
      i1 = a;
      h = i1;
      return i1;
    }
    int i1 = e.a;
    h = i1;
    return i1;
  }
  
  /* Error */
  public final ifn a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: new 290	ifn
    //   5: dup
    //   6: invokespecial 291	ifn:<init>	()V
    //   9: astore 4
    //   11: aload_0
    //   12: getfield 62	ifw:a	Ligd;
    //   15: invokevirtual 198	igd:b	()V
    //   18: aload_0
    //   19: aload 4
    //   21: invokespecial 200	ifw:a	(Lige;)V
    //   24: aload_0
    //   25: getfield 108	ifw:h	I
    //   28: iconst_m1
    //   29: if_icmpne +88 -> 117
    //   32: aload_0
    //   33: invokespecial 209	ifw:m	()I
    //   36: istore_1
    //   37: goto +227 -> 264
    //   40: aload_0
    //   41: getfield 66	ifw:m	[I
    //   44: iconst_1
    //   45: aload_0
    //   46: getfield 110	ifw:l	I
    //   49: iastore
    //   50: aload_0
    //   51: getfield 108	ifw:h	I
    //   54: iconst_m1
    //   55: if_icmpne +134 -> 189
    //   58: aload_0
    //   59: invokespecial 209	ifw:m	()I
    //   62: istore_1
    //   63: goto +240 -> 303
    //   66: aload_0
    //   67: getfield 66	ifw:m	[I
    //   70: iconst_2
    //   71: aload_0
    //   72: getfield 110	ifw:l	I
    //   75: iastore
    //   76: aload_0
    //   77: getfield 62	ifw:a	Ligd;
    //   80: aload 4
    //   82: invokevirtual 205	igd:a	(Lige;)V
    //   85: aload_0
    //   86: aload 4
    //   88: invokespecial 207	ifw:b	(Lige;)V
    //   91: aload_0
    //   92: iconst_0
    //   93: invokespecial 211	ifw:a	(I)Ligi;
    //   96: pop
    //   97: aload_0
    //   98: getfield 62	ifw:a	Ligd;
    //   101: getfield 294	igd:a	Ljava/util/Stack;
    //   104: iconst_0
    //   105: invokevirtual 297	java/util/Stack:elementAt	(I)Ljava/lang/Object;
    //   108: checkcast 299	ige
    //   111: checkcast 290	ifn
    //   114: astore_3
    //   115: aload_3
    //   116: areturn
    //   117: aload_0
    //   118: getfield 108	ifw:h	I
    //   121: istore_1
    //   122: goto +142 -> 264
    //   125: aload_0
    //   126: invokespecial 300	ifw:b	()V
    //   129: goto -79 -> 50
    //   132: astore_3
    //   133: aload_0
    //   134: getfield 62	ifw:a	Ligd;
    //   137: invokevirtual 214	igd:a	()V
    //   140: aload_3
    //   141: instanceof 216
    //   144: ifeq +103 -> 247
    //   147: aload_3
    //   148: checkcast 216	java/lang/RuntimeException
    //   151: athrow
    //   152: astore_3
    //   153: iconst_0
    //   154: istore_1
    //   155: iload_1
    //   156: ifeq +18 -> 174
    //   159: aload_0
    //   160: getfield 62	ifw:a	Ligd;
    //   163: aload 4
    //   165: invokevirtual 205	igd:a	(Lige;)V
    //   168: aload_0
    //   169: aload 4
    //   171: invokespecial 207	ifw:b	(Lige;)V
    //   174: aload_3
    //   175: athrow
    //   176: astore_3
    //   177: new 164	igf
    //   180: dup
    //   181: aload_3
    //   182: invokevirtual 304	igj:getMessage	()Ljava/lang/String;
    //   185: invokespecial 272	igf:<init>	(Ljava/lang/String;)V
    //   188: athrow
    //   189: aload_0
    //   190: getfield 108	ifw:h	I
    //   193: istore_1
    //   194: goto +109 -> 303
    //   197: aload_0
    //   198: iconst_3
    //   199: invokespecial 211	ifw:a	(I)Ligi;
    //   202: pop
    //   203: aload_0
    //   204: getfield 108	ifw:h	I
    //   207: iconst_m1
    //   208: if_icmpne +24 -> 232
    //   211: aload_0
    //   212: invokespecial 209	ifw:m	()I
    //   215: istore_1
    //   216: goto +111 -> 327
    //   219: aload_0
    //   220: getfield 66	ifw:m	[I
    //   223: iconst_3
    //   224: aload_0
    //   225: getfield 110	ifw:l	I
    //   228: iastore
    //   229: goto -179 -> 50
    //   232: aload_0
    //   233: getfield 108	ifw:h	I
    //   236: istore_1
    //   237: goto +90 -> 327
    //   240: aload_0
    //   241: invokespecial 300	ifw:b	()V
    //   244: goto -194 -> 50
    //   247: aload_3
    //   248: instanceof 164
    //   251: ifeq +8 -> 259
    //   254: aload_3
    //   255: checkcast 164	igf
    //   258: athrow
    //   259: aload_3
    //   260: checkcast 227	java/lang/Error
    //   263: athrow
    //   264: iload_1
    //   265: lookupswitch	default:+35->300, 6:+-140->125, 14:+-140->125, 31:+-140->125
    //   300: goto -260 -> 40
    //   303: iload_1
    //   304: tableswitch	default:+20->324, 3:+-107->197
    //   324: goto -258 -> 66
    //   327: iload_1
    //   328: lookupswitch	default:+36->364, 6:+-88->240, 14:+-88->240, 31:+-88->240
    //   364: goto -145 -> 219
    //   367: astore_3
    //   368: iload_2
    //   369: istore_1
    //   370: goto -215 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	this	ifw
    //   36	334	1	i1	int
    //   1	368	2	i2	int
    //   114	2	3	localifn1	ifn
    //   132	16	3	localThrowable	Throwable
    //   152	23	3	localObject1	Object
    //   176	84	3	localigj	igj
    //   367	1	3	localObject2	Object
    //   9	161	4	localifn2	ifn
    // Exception table:
    //   from	to	target	type
    //   24	37	132	java/lang/Throwable
    //   40	50	132	java/lang/Throwable
    //   50	63	132	java/lang/Throwable
    //   66	76	132	java/lang/Throwable
    //   117	122	132	java/lang/Throwable
    //   125	129	132	java/lang/Throwable
    //   189	194	132	java/lang/Throwable
    //   197	216	132	java/lang/Throwable
    //   219	229	132	java/lang/Throwable
    //   232	237	132	java/lang/Throwable
    //   240	244	132	java/lang/Throwable
    //   140	152	152	finally
    //   247	259	152	finally
    //   259	264	152	finally
    //   2	24	176	igj
    //   76	115	176	igj
    //   159	174	176	igj
    //   174	176	176	igj
    //   24	37	367	finally
    //   40	50	367	finally
    //   50	63	367	finally
    //   66	76	367	finally
    //   117	122	367	finally
    //   125	129	367	finally
    //   133	140	367	finally
    //   189	194	367	finally
    //   197	216	367	finally
    //   219	229	367	finally
    //   232	237	367	finally
    //   240	244	367	finally
  }
}

/* Location:
 * Qualified Name:     ifw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */