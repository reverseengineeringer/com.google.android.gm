import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.SocketException;
import java.util.List;

final class ikz
  implements inb
{
  imz[] a;
  int[] b;
  Object[] c;
  int d;
  int e;
  boolean f;
  ilx g;
  ilx h;
  Throwable i;
  inb j;
  
  public ikz(iky paramiky, ilx paramilx)
  {
    Object localObject = a;
    a = ((imz[])((List)localObject).toArray(new imz[((List)localObject).size()]));
    if (b)
    {
      int m = a.length;
      int k = c;
      c = (k + 1);
      int n = k % m;
      if (c > m) {
        c %= m;
      }
      if (n > 0)
      {
        localObject = new imz[m];
        k = 0;
        while (k < m)
        {
          localObject[k] = a[((k + n) % m)];
          k += 1;
        }
        a = ((imz[])localObject);
      }
    }
    b = new int[a.length];
    c = new Object[a.length];
    d = d;
    g = paramilx;
  }
  
  public final ilx a()
  {
    try
    {
      Object localObject1 = b;
      localObject1[0] += 1;
      e += 1;
      c[0] = new Object();
      localObject1 = a[0].a(g);
      return (ilx)localObject1;
    }
    catch (Exception localException)
    {
      a(c[0], localException);
      try
      {
        for (;;)
        {
          boolean bool = f;
          if (bool) {
            break;
          }
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException) {}
        }
        if (h != null) {
          return h;
        }
      }
      finally {}
      if ((i instanceof IOException)) {
        throw ((IOException)i);
      }
      if ((i instanceof RuntimeException)) {
        throw ((RuntimeException)i);
      }
      if ((i instanceof Error)) {
        throw ((Error)i);
      }
      throw new IllegalStateException("ExtendedResolver failure");
    }
  }
  
  public final void a(int paramInt)
  {
    int[] arrayOfInt = b;
    arrayOfInt[paramInt] += 1;
    e += 1;
    try
    {
      c[paramInt] = a[paramInt].a(g, this);
      return;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        i = localThrowable;
        f = true;
        if (j == null)
        {
          notifyAll();
          return;
        }
      }
      finally {}
    }
  }
  
  public final void a(ilx paramilx)
  {
    if (imn.a("verbose")) {
      System.err.println("ExtendedResolver: received message");
    }
    try
    {
      if (f) {
        return;
      }
      h = paramilx;
      f = true;
      if (j == null)
      {
        notifyAll();
        return;
      }
    }
    finally {}
    j.a(h);
  }
  
  public final void a(Object paramObject, Exception paramException)
  {
    int m = 1;
    if (imn.a("verbose"))
    {
      PrintStream localPrintStream = System.err;
      String str = String.valueOf(paramException);
      localPrintStream.println(String.valueOf(str).length() + 22 + "ExtendedResolver: got " + str);
    }
    for (;;)
    {
      int k;
      try
      {
        e -= 1;
        if (!f) {
          break label335;
        }
        return;
      }
      finally {}
      if ((k < c.length) && (c[k] != paramObject))
      {
        k += 1;
      }
      else
      {
        if (k == c.length) {
          return;
        }
        if ((b[k] == 1) && (k < a.length - 1)) {}
        for (;;)
        {
          if ((paramException instanceof InterruptedIOException))
          {
            if (b[k] < d) {
              a(k);
            }
            if (i != null) {}
          }
          for (i = paramException;; i = paramException) {
            do
            {
              if (!f) {
                break label223;
              }
              return;
              if (!(paramException instanceof SocketException)) {
                break;
              }
            } while ((i != null) && (!(i instanceof InterruptedIOException)));
          }
          label223:
          if (m != 0) {
            a(k + 1);
          }
          if (f) {
            return;
          }
          if (e == 0)
          {
            f = true;
            if (j == null)
            {
              notifyAll();
              return;
            }
          }
          if (!f) {
            return;
          }
          if (!(i instanceof Exception)) {
            i = new RuntimeException(i.getMessage());
          }
          j.a(this, (Exception)i);
          return;
          m = 0;
        }
        label335:
        k = 0;
      }
    }
  }
}

/* Location:
 * Qualified Name:     ikz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */