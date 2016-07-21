import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class gr
  implements ka<Object>, kb<Object>
{
  final int a;
  final Bundle b;
  gp<Object> c;
  jy<Object> d;
  boolean e;
  boolean f;
  Object g;
  boolean h;
  boolean i;
  boolean j;
  boolean k;
  boolean l;
  boolean m;
  gr n;
  
  public gr(int paramInt, Bundle paramBundle, gp<Object> paramgp)
  {
    a = paramBundle;
    b = paramgp;
    gp localgp;
    c = localgp;
  }
  
  final void a()
  {
    if ((i) && (j)) {
      h = true;
    }
    do
    {
      do
      {
        return;
      } while (h);
      h = true;
      if (gq.a) {
        new StringBuilder("  Starting: ").append(this);
      }
      if ((d == null) && (c != null)) {
        d = c.a(a, b);
      }
    } while (d == null);
    if ((d.getClass().isMemberClass()) && (!Modifier.isStatic(d.getClass().getModifiers()))) {
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + d);
    }
    if (!m)
    {
      localjy = d;
      int i1 = a;
      if (o != null) {
        throw new IllegalStateException("There is already a listener registered");
      }
      o = this;
      n = i1;
      localjy = d;
      if (p != null) {
        throw new IllegalStateException("There is already a listener registered");
      }
      p = this;
      m = true;
    }
    jy localjy = d;
    r = true;
    t = false;
    s = false;
    localjy.g();
  }
  
  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = paramString;
    paramString = this;
    for (;;)
    {
      paramPrintWriter.print(str);
      paramPrintWriter.print("mId=");
      paramPrintWriter.print(a);
      paramPrintWriter.print(" mArgs=");
      paramPrintWriter.println(b);
      paramPrintWriter.print(str);
      paramPrintWriter.print("mCallbacks=");
      paramPrintWriter.println(c);
      paramPrintWriter.print(str);
      paramPrintWriter.print("mLoader=");
      paramPrintWriter.println(d);
      if (d != null) {
        d.a(str + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
      if ((e) || (f))
      {
        paramPrintWriter.print(str);
        paramPrintWriter.print("mHaveData=");
        paramPrintWriter.print(e);
        paramPrintWriter.print("  mDeliveredData=");
        paramPrintWriter.println(f);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(g);
      }
      paramPrintWriter.print(str);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(h);
      paramPrintWriter.print(" mReportNextStart=");
      paramPrintWriter.print(k);
      paramPrintWriter.print(" mDestroyed=");
      paramPrintWriter.println(l);
      paramPrintWriter.print(str);
      paramPrintWriter.print("mRetaining=");
      paramPrintWriter.print(i);
      paramPrintWriter.print(" mRetainingStarted=");
      paramPrintWriter.print(j);
      paramPrintWriter.print(" mListenerRegistered=");
      paramPrintWriter.println(m);
      if (n == null) {
        break;
      }
      paramPrintWriter.print(str);
      paramPrintWriter.println("Pending Loader ");
      paramPrintWriter.print(n);
      paramPrintWriter.println(":");
      paramString = n;
      str = str + "  ";
    }
  }
  
  public final void a(jy<Object> paramjy, Object paramObject)
  {
    Object localObject2 = null;
    if (gq.a) {
      new StringBuilder("onLoadComplete: ").append(this);
    }
    if (l) {}
    for (;;)
    {
      return;
      Object localObject1 = o.b;
      i1 = a;
      i1 = nu.a(b, d, i1);
      if ((i1 < 0) || (c[i1] == oj.a)) {}
      for (localObject1 = null; localObject1 == this; localObject1 = c[i1])
      {
        localObject1 = n;
        if (localObject1 == null) {
          break label164;
        }
        if (gq.a) {
          new StringBuilder("  Switching to pending loader: ").append(localObject1);
        }
        n = null;
        o.b.a(a, null);
        c();
        o.a((gr)localObject1);
        return;
      }
    }
    label164:
    if ((g != paramObject) || (!e))
    {
      g = paramObject;
      e = true;
      if (h) {
        b(paramjy, paramObject);
      }
    }
    paramObject = o.c;
    int i1 = a;
    i1 = nu.a(b, d, i1);
    paramjy = (jy<Object>)localObject2;
    if (i1 >= 0) {
      if (c[i1] != oj.a) {
        break label321;
      }
    }
    label321:
    for (paramjy = (jy<Object>)localObject2;; paramjy = c[i1])
    {
      paramjy = (gr)paramjy;
      if ((paramjy != null) && (paramjy != this))
      {
        f = false;
        paramjy.c();
        o.c.c(a);
      }
      if ((o.h == null) || (o.a())) {
        break;
      }
      o.h.f.f();
      return;
    }
  }
  
  final void b()
  {
    if (gq.a) {
      new StringBuilder("  Stopping: ").append(this);
    }
    h = false;
    if ((!i) && (d != null) && (m))
    {
      m = false;
      d.a(this);
      d.a(this);
      jy localjy = d;
      r = false;
      localjy.h();
    }
  }
  
  final void b(jy<Object> paramjy, Object paramObject)
  {
    String str;
    if (c != null)
    {
      if (o.h == null) {
        break label180;
      }
      str = o.h.f.v;
      o.h.f.v = "onLoadFinished";
    }
    for (;;)
    {
      try
      {
        if (gq.a)
        {
          StringBuilder localStringBuilder1 = new StringBuilder("  onLoadFinished in ").append(paramjy).append(": ");
          StringBuilder localStringBuilder2 = new StringBuilder(64);
          nv.a(paramObject, localStringBuilder2);
          localStringBuilder2.append("}");
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        c.a(paramjy, paramObject);
        if (o.h != null) {
          o.h.f.v = str;
        }
        f = true;
        return;
      }
      finally
      {
        if (o.h != null) {
          o.h.f.v = str;
        }
      }
      label180:
      str = null;
    }
  }
  
  /* Error */
  final void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: astore_2
    //   2: getstatic 60	gq:a	Z
    //   5: ifeq +18 -> 23
    //   8: new 62	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 295
    //   15: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_2
    //   19: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_2
    //   24: iconst_1
    //   25: putfield 192	gr:l	Z
    //   28: aload_2
    //   29: getfield 169	gr:f	Z
    //   32: istore_1
    //   33: aload_2
    //   34: iconst_0
    //   35: putfield 169	gr:f	Z
    //   38: aload_2
    //   39: getfield 47	gr:c	Lgp;
    //   42: ifnull +115 -> 157
    //   45: aload_2
    //   46: getfield 73	gr:d	Ljy;
    //   49: ifnull +108 -> 157
    //   52: aload_2
    //   53: getfield 167	gr:e	Z
    //   56: ifeq +101 -> 157
    //   59: iload_1
    //   60: ifeq +97 -> 157
    //   63: getstatic 60	gq:a	Z
    //   66: ifeq +18 -> 84
    //   69: new 62	java/lang/StringBuilder
    //   72: dup
    //   73: ldc_w 297
    //   76: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   79: aload_2
    //   80: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_2
    //   85: getfield 38	gr:o	Lgq;
    //   88: getfield 250	gq:h	Lfp;
    //   91: ifnull +195 -> 286
    //   94: aload_2
    //   95: getfield 38	gr:o	Lgq;
    //   98: getfield 250	gq:h	Lfp;
    //   101: getfield 257	fp:f	Lfr;
    //   104: getfield 276	fr:v	Ljava/lang/String;
    //   107: astore_3
    //   108: aload_2
    //   109: getfield 38	gr:o	Lgq;
    //   112: getfield 250	gq:h	Lfp;
    //   115: getfield 257	fp:f	Lfr;
    //   118: ldc_w 299
    //   121: putfield 276	fr:v	Ljava/lang/String;
    //   124: aload_2
    //   125: getfield 47	gr:c	Lgp;
    //   128: invokeinterface 301 1 0
    //   133: aload_2
    //   134: getfield 38	gr:o	Lgq;
    //   137: getfield 250	gq:h	Lfp;
    //   140: ifnull +17 -> 157
    //   143: aload_2
    //   144: getfield 38	gr:o	Lgq;
    //   147: getfield 250	gq:h	Lfp;
    //   150: getfield 257	fp:f	Lfr;
    //   153: aload_3
    //   154: putfield 276	fr:v	Ljava/lang/String;
    //   157: aload_2
    //   158: aconst_null
    //   159: putfield 47	gr:c	Lgp;
    //   162: aload_2
    //   163: aconst_null
    //   164: putfield 182	gr:g	Ljava/lang/Object;
    //   167: aload_2
    //   168: iconst_0
    //   169: putfield 167	gr:e	Z
    //   172: aload_2
    //   173: getfield 73	gr:d	Ljy;
    //   176: ifnull +65 -> 241
    //   179: aload_2
    //   180: getfield 109	gr:m	Z
    //   183: ifeq +24 -> 207
    //   186: aload_2
    //   187: iconst_0
    //   188: putfield 109	gr:m	Z
    //   191: aload_2
    //   192: getfield 73	gr:d	Ljy;
    //   195: aload_2
    //   196: invokevirtual 267	jy:a	(Lkb;)V
    //   199: aload_2
    //   200: getfield 73	gr:d	Ljy;
    //   203: aload_2
    //   204: invokevirtual 270	jy:a	(Lka;)V
    //   207: aload_2
    //   208: getfield 73	gr:d	Ljy;
    //   211: astore_3
    //   212: aload_3
    //   213: invokevirtual 303	jy:i	()V
    //   216: aload_3
    //   217: iconst_1
    //   218: putfield 131	jy:t	Z
    //   221: aload_3
    //   222: iconst_0
    //   223: putfield 128	jy:r	Z
    //   226: aload_3
    //   227: iconst_0
    //   228: putfield 134	jy:s	Z
    //   231: aload_3
    //   232: iconst_0
    //   233: putfield 306	jy:u	Z
    //   236: aload_3
    //   237: iconst_0
    //   238: putfield 308	jy:v	Z
    //   241: aload_2
    //   242: getfield 200	gr:n	Lgr;
    //   245: ifnull +40 -> 285
    //   248: aload_2
    //   249: getfield 200	gr:n	Lgr;
    //   252: astore_2
    //   253: goto -251 -> 2
    //   256: astore 4
    //   258: aload_2
    //   259: getfield 38	gr:o	Lgq;
    //   262: getfield 250	gq:h	Lfp;
    //   265: ifnull +17 -> 282
    //   268: aload_2
    //   269: getfield 38	gr:o	Lgq;
    //   272: getfield 250	gq:h	Lfp;
    //   275: getfield 257	fp:f	Lfr;
    //   278: aload_3
    //   279: putfield 276	fr:v	Ljava/lang/String;
    //   282: aload 4
    //   284: athrow
    //   285: return
    //   286: aconst_null
    //   287: astore_3
    //   288: goto -164 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	gr
    //   32	28	1	bool	boolean
    //   1	268	2	localgr	gr
    //   107	181	3	localObject1	Object
    //   256	27	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   124	133	256	finally
  }
  
  public final void d()
  {
    if (gq.a) {
      new StringBuilder("onLoadCanceled: ").append(this);
    }
    if (l) {}
    label148:
    for (;;)
    {
      return;
      Object localObject = o.b;
      int i1 = a;
      i1 = nu.a(b, d, i1);
      if ((i1 < 0) || (c[i1] == oj.a)) {}
      for (localObject = null;; localObject = c[i1])
      {
        if (localObject != this) {
          break label148;
        }
        localObject = n;
        if (localObject == null) {
          break;
        }
        if (gq.a) {
          new StringBuilder("  Switching to pending loader: ").append(localObject);
        }
        n = null;
        o.b.a(a, null);
        c();
        o.a((gr)localObject);
        return;
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("LoaderInfo{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" #");
    localStringBuilder.append(a);
    localStringBuilder.append(" : ");
    nv.a(d, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     gr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */