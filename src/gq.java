import android.os.Bundle;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class gq
  extends go
{
  public static boolean a = false;
  final oj<gr> b = new oj();
  final oj<gr> c = new oj();
  final String d;
  boolean e;
  boolean f;
  boolean g;
  fp h;
  
  gq(String paramString, fp paramfp, boolean paramBoolean)
  {
    d = paramString;
    h = paramfp;
    e = paramBoolean;
  }
  
  private final gr b(int paramInt, Bundle paramBundle, gp<Object> paramgp)
  {
    gr localgr = new gr(this, paramInt, paramBundle, paramgp);
    d = paramgp.a(paramInt, paramBundle);
    return localgr;
  }
  
  private final gr c(int paramInt, Bundle paramBundle, gp<Object> paramgp)
  {
    try
    {
      g = true;
      paramBundle = b(paramInt, paramBundle, paramgp);
      a(paramBundle);
      return paramBundle;
    }
    finally
    {
      g = false;
    }
  }
  
  public final <D> jy<D> a(int paramInt, Bundle paramBundle, gp<D> paramgp)
  {
    if (g) {
      throw new IllegalStateException("Called while creating a loader");
    }
    Object localObject = b;
    int i = nu.a(b, d, paramInt);
    if ((i < 0) || (c[i] == oj.a))
    {
      localObject = null;
      localObject = (gr)localObject;
      if (a) {
        new StringBuilder("initLoader in ").append(this).append(": args=").append(paramBundle);
      }
      if (localObject != null) {
        break label178;
      }
      paramgp = c(paramInt, paramBundle, paramgp);
      paramBundle = paramgp;
      if (a) {
        new StringBuilder("  Created new loader ").append(paramgp);
      }
    }
    for (paramBundle = paramgp;; paramBundle = (Bundle)localObject)
    {
      if ((e) && (e)) {
        paramBundle.b(d, g);
      }
      return d;
      localObject = c[i];
      break;
      label178:
      if (a) {
        new StringBuilder("  Re-using existing loader ").append(localObject);
      }
      c = paramgp;
    }
  }
  
  public final <D> jy<D> a(gp<D> paramgp)
  {
    if (g) {
      throw new IllegalStateException("Called while creating a loader");
    }
    Object localObject = b;
    int i = nu.a(b, d, paramgp);
    gr localgr;
    if ((i < 0) || (c[i] == oj.a))
    {
      localObject = null;
      localgr = (gr)localObject;
      if (a) {
        new StringBuilder("restartLoader in ").append(this).append(": args=").append(null);
      }
      if (localgr != null)
      {
        localObject = c;
        i = nu.a(b, d, paramgp);
        if ((i >= 0) && (c[i] != oj.a)) {
          break label234;
        }
        localObject = null;
        label140:
        localObject = (gr)localObject;
        if (localObject == null) {
          break label399;
        }
        if (!e) {
          break label246;
        }
        if (a) {
          new StringBuilder("  Removing last inactive loader: ").append(localgr);
        }
        f = false;
        ((gr)localObject).c();
        d.s = true;
        c.a(paramgp, localgr);
      }
    }
    for (;;)
    {
      gp localgp;
      return cd;
      localObject = c[i];
      break;
      label234:
      localObject = c[i];
      break label140;
      label246:
      if (!h)
      {
        b.a(paramgp, null);
        localgr.c();
      }
      else
      {
        if (a) {
          new StringBuilder("  Canceling: ").append(localgr);
        }
        if ((h) && (d != null) && (m) && (!d.b())) {
          localgr.d();
        }
        if (n != null)
        {
          if (a) {
            new StringBuilder("  Removing pending loader: ").append(n);
          }
          n.c();
          n = null;
        }
        n = b(paramgp, null, localgp);
        return n.d;
        label399:
        if (a) {
          new StringBuilder("  Making last loader inactive: ").append(localgr);
        }
        d.s = true;
        c.a(paramgp, localgr);
      }
    }
  }
  
  public final void a(int paramInt)
  {
    if (g) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (a) {
      new StringBuilder("destroyLoader in ").append(this).append(" of ").append(paramInt);
    }
    int i = b.g(paramInt);
    gr localgr;
    if (i >= 0)
    {
      localgr = (gr)b.f(i);
      b.d(i);
      localgr.c();
    }
    paramInt = c.g(paramInt);
    if (paramInt >= 0)
    {
      localgr = (gr)c.f(paramInt);
      c.d(paramInt);
      localgr.c();
    }
    if ((h != null) && (!a())) {
      h.f.f();
    }
  }
  
  final void a(gr paramgr)
  {
    b.a(a, paramgr);
    if (e) {
      paramgr.a();
    }
  }
  
  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str;
    int i;
    gr localgr;
    if (b.a() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      str = paramString + "    ";
      i = 0;
      while (i < b.a())
      {
        localgr = (gr)b.f(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(b.e(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localgr.toString());
        localgr.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
    if (c.a() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      str = paramString + "    ";
      i = j;
      while (i < c.a())
      {
        localgr = (gr)c.f(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(c.e(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localgr.toString());
        localgr.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
  }
  
  public final boolean a()
  {
    int j = b.a();
    int i = 0;
    boolean bool2 = false;
    if (i < j)
    {
      gr localgr = (gr)b.f(i);
      if ((h) && (!f)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 |= bool1;
        i += 1;
        break;
      }
    }
    return bool2;
  }
  
  public final <D> jy<D> b(int paramInt)
  {
    Object localObject2 = null;
    if (g) {
      throw new IllegalStateException("Called while creating a loader");
    }
    Object localObject1 = b;
    paramInt = nu.a(b, d, paramInt);
    if ((paramInt < 0) || (c[paramInt] == oj.a)) {}
    gr localgr;
    for (localObject1 = null;; localObject1 = c[paramInt])
    {
      localgr = (gr)localObject1;
      localObject1 = localObject2;
      if (localgr != null)
      {
        if (n == null) {
          break;
        }
        localObject1 = n.d;
      }
      return (jy<D>)localObject1;
    }
    return d;
  }
  
  public final void b()
  {
    if (a) {
      new StringBuilder("Starting in ").append(this);
    }
    if (e)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStart when already started: " + this, localRuntimeException);
    }
    for (;;)
    {
      return;
      e = true;
      int i = b.a() - 1;
      while (i >= 0)
      {
        ((gr)b.f(i)).a();
        i -= 1;
      }
    }
  }
  
  public final void c()
  {
    if (a) {
      new StringBuilder("Stopping in ").append(this);
    }
    if (!e)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStop when not started: " + this, localRuntimeException);
      return;
    }
    int i = b.a() - 1;
    while (i >= 0)
    {
      ((gr)b.f(i)).b();
      i -= 1;
    }
    e = false;
  }
  
  public final void d()
  {
    if (a) {
      new StringBuilder("Retaining in ").append(this);
    }
    Object localObject;
    if (!e)
    {
      localObject = new RuntimeException("here");
      ((RuntimeException)localObject).fillInStackTrace();
      Log.w("LoaderManager", "Called doRetain when not started: " + this, (Throwable)localObject);
    }
    for (;;)
    {
      return;
      f = true;
      e = false;
      int i = b.a() - 1;
      while (i >= 0)
      {
        localObject = (gr)b.f(i);
        if (a) {
          new StringBuilder("  Retaining: ").append(localObject);
        }
        i = true;
        j = h;
        h = false;
        c = null;
        i -= 1;
      }
    }
  }
  
  final void e()
  {
    int i = b.a() - 1;
    while (i >= 0)
    {
      b.f(i)).k = true;
      i -= 1;
    }
  }
  
  final void f()
  {
    int i = b.a() - 1;
    while (i >= 0)
    {
      gr localgr = (gr)b.f(i);
      if ((h) && (k))
      {
        k = false;
        if (e) {
          localgr.b(d, g);
        }
      }
      i -= 1;
    }
  }
  
  public final void g()
  {
    if (!f)
    {
      if (a) {
        new StringBuilder("Destroying Active in ").append(this);
      }
      i = b.a() - 1;
      while (i >= 0)
      {
        ((gr)b.f(i)).c();
        i -= 1;
      }
      b.b();
    }
    if (a) {
      new StringBuilder("Destroying Inactive in ").append(this);
    }
    int i = c.a() - 1;
    while (i >= 0)
    {
      ((gr)c.f(i)).c();
      i -= 1;
    }
    c.b();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    nv.a(h, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     gq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */