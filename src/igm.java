import java.io.IOException;
import java.io.PrintStream;

public final class igm
  implements igl
{
  static int a;
  static final long[] c = { 0L, 0L, -1L, -1L };
  static final int[] d = new int[0];
  public static final String[] e = { "", "\r", "\n", "/", ";", "=", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null };
  public static final String[] f = { "DEFAULT", "INCOMMENT", "NESTED_COMMENT", "INQUOTEDSTRING" };
  public static final int[] g = { -1, -1, -1, -1, -1, -1, -1, 1, 0, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, 0, -1, -1, -1, -1 };
  static final long[] h = { 3670079L };
  static final long[] j = { 320L };
  static final long[] k = { 64L };
  static final long[] l = { 523904L };
  public PrintStream b = System.out;
  public igo m;
  StringBuffer n;
  int o;
  int p;
  public char q;
  int r = 0;
  int s = 0;
  int t;
  int u;
  int v;
  int w;
  private final int[] x = new int[3];
  private final int[] y = new int[6];
  
  public igm(igo paramigo)
  {
    m = paramigo;
  }
  
  private final int a(int paramInt)
  {
    w = paramInt;
    v = 0;
    return 1;
  }
  
  private final int a(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    t = 3;
    int i = 1;
    y[0] = paramInt1;
    paramInt1 = Integer.MAX_VALUE;
    int i2 = paramInt2;
    paramInt2 = i;
    for (;;)
    {
      i = u + 1;
      u = i;
      if (i == Integer.MAX_VALUE) {
        b();
      }
      if (q < '@')
      {
        long l1 = 1L << q;
        i = paramInt2;
        arrayOfInt = y;
        i3 = i - 1;
        switch (arrayOfInt[i3])
        {
        default: 
          paramInt2 = paramInt1;
        }
        for (;;)
        {
          paramInt1 = paramInt2;
          i = i3;
          if (i3 != i1) {
            break;
          }
          paramInt1 = paramInt2;
          if (paramInt2 != Integer.MAX_VALUE)
          {
            w = paramInt2;
            v = i2;
            paramInt1 = Integer.MAX_VALUE;
          }
          i2 += 1;
          paramInt2 = t;
          t = i1;
          i1 = 3 - i1;
          if (paramInt2 != i1) {
            break label580;
          }
          return i2;
          if ((0x3FF6CFAFFFFFDFF & l1) != 0L)
          {
            i = paramInt1;
            if (paramInt1 > 21) {
              i = 21;
            }
            c(2);
          }
          for (;;)
          {
            paramInt2 = i;
            if ((0x3FF000000000000 & l1) == 0L) {
              break;
            }
            paramInt2 = i;
            if (i > 20) {
              paramInt2 = 20;
            }
            c(1);
            break;
            i = paramInt1;
            if ((0x100000200 & l1) != 0L)
            {
              i = paramInt1;
              if (paramInt1 > 6) {
                i = 6;
              }
              c(0);
            }
          }
          paramInt2 = paramInt1;
          if ((0x100000200 & l1) != 0L)
          {
            paramInt2 = 6;
            c(0);
            continue;
            paramInt2 = paramInt1;
            if ((0x3FF000000000000 & l1) != 0L)
            {
              paramInt2 = paramInt1;
              if (paramInt1 > 20) {
                paramInt2 = 20;
              }
              c(1);
              continue;
              paramInt2 = paramInt1;
              if ((0x3FF6CFAFFFFFDFF & l1) != 0L)
              {
                paramInt2 = paramInt1;
                if (paramInt1 > 21) {
                  paramInt2 = 21;
                }
                c(2);
              }
            }
          }
        }
      }
      if (q < '')
      {
        i4 = q;
        i = paramInt2;
        label377:
        arrayOfInt = y;
        i3 = i - 1;
        switch (arrayOfInt[i3])
        {
        default: 
          paramInt2 = paramInt1;
        }
        for (;;)
        {
          paramInt1 = paramInt2;
          i = i3;
          if (i3 != i1) {
            break label377;
          }
          break;
          paramInt2 = paramInt1;
          if ((0xFFFFFFFFC7FFFFFE & 1L << (i4 & 0x3F)) != 0L)
          {
            paramInt2 = 21;
            c(2);
          }
        }
      }
      int i4 = q;
      int i5 = q;
      i = paramInt2;
      label476:
      int[] arrayOfInt = y;
      int i3 = i - 1;
      switch (arrayOfInt[i3])
      {
      default: 
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        paramInt1 = paramInt2;
        i = i3;
        if (i3 != i1) {
          break label476;
        }
        break;
        paramInt2 = paramInt1;
        if ((c[((i4 & 0xFF) >> 6)] & 1L << (i5 & 0x3F)) != 0L)
        {
          paramInt2 = paramInt1;
          if (paramInt1 > 21) {
            paramInt2 = 21;
          }
          c(2);
        }
      }
      try
      {
        label580:
        q = m.a();
      }
      catch (IOException localIOException) {}
    }
    return i2;
  }
  
  private final int b(int paramInt)
  {
    w = paramInt;
    v = 0;
    try
    {
      q = m.a();
      return a(2, 1);
    }
    catch (IOException localIOException) {}
    return 1;
  }
  
  private final void b()
  {
    u = -2147483647;
    int i1;
    for (int i = 3;; i = i1)
    {
      i1 = i - 1;
      if (i <= 0) {
        break;
      }
      x[i1] = Integer.MIN_VALUE;
    }
  }
  
  private final igp c()
  {
    igp localigp = new igp();
    a = w;
    String str = e[w];
    Object localObject = str;
    if (str == null) {
      localObject = m.d();
    }
    f = ((String)localObject);
    localObject = m;
    b = e[c];
    localObject = m;
    c = f[c];
    d = m.c();
    e = m.b();
    return localigp;
  }
  
  private final void c(int paramInt)
  {
    if (x[paramInt] != u)
    {
      int[] arrayOfInt = y;
      int i = t;
      t = (i + 1);
      arrayOfInt[i] = paramInt;
      x[paramInt] = u;
    }
  }
  
  private final int d(int paramInt)
  {
    t = 3;
    y[0] = 0;
    int i = 1;
    int i2 = 0;
    int i1 = Integer.MAX_VALUE;
    int i3 = paramInt;
    paramInt = i1;
    for (;;)
    {
      i1 = u + 1;
      u = i1;
      if (i1 == Integer.MAX_VALUE) {
        b();
      }
      if (q < '@')
      {
        i1 = paramInt;
        arrayOfInt = y;
        i4 = i - 1;
        switch (arrayOfInt[i4])
        {
        default: 
          paramInt = i1;
        }
        for (;;)
        {
          i1 = paramInt;
          i = i4;
          if (i4 != i2) {
            break;
          }
          i = paramInt;
          if (paramInt != Integer.MAX_VALUE)
          {
            w = paramInt;
            v = i3;
            i = Integer.MAX_VALUE;
          }
          i3 += 1;
          i1 = t;
          t = i2;
          i2 = 3 - i2;
          if (i1 != i2) {
            break label485;
          }
          return i3;
          paramInt = i1;
          if (i1 > 11)
          {
            paramInt = 11;
            continue;
            paramInt = i1;
            if (i1 > 9) {
              paramInt = 9;
            }
          }
        }
      }
      if (q < '')
      {
        i1 = i;
        i = paramInt;
        label206:
        arrayOfInt = y;
        i4 = i1 - 1;
        switch (arrayOfInt[i4])
        {
        default: 
          paramInt = i;
        }
        for (;;)
        {
          i = paramInt;
          i1 = i4;
          if (i4 != i2) {
            break label206;
          }
          break;
          i1 = i;
          if (i > 11) {
            i1 = 11;
          }
          paramInt = i1;
          if (q == '\\')
          {
            arrayOfInt = y;
            paramInt = t;
            t = (paramInt + 1);
            arrayOfInt[paramInt] = 1;
            paramInt = i1;
            continue;
            paramInt = i;
            if (i > 9)
            {
              paramInt = 9;
              continue;
              paramInt = i;
              if (i > 11) {
                paramInt = 11;
              }
            }
          }
        }
      }
      int i5 = (q & 0xFF) >> '\006';
      long l1 = 1L << (q & 0x3F);
      i1 = paramInt;
      label369:
      int[] arrayOfInt = y;
      int i4 = i - 1;
      switch (arrayOfInt[i4])
      {
      default: 
        paramInt = i1;
      }
      for (;;)
      {
        i1 = paramInt;
        i = i4;
        if (i4 != i2) {
          break label369;
        }
        break;
        paramInt = i1;
        if ((c[i5] & l1) != 0L)
        {
          paramInt = i1;
          if (i1 > 11)
          {
            paramInt = 11;
            continue;
            paramInt = i1;
            if ((c[i5] & l1) != 0L)
            {
              paramInt = i1;
              if (i1 > 9) {
                paramInt = 9;
              }
            }
          }
        }
      }
      try
      {
        label485:
        q = m.a();
        paramInt = i;
        i = i1;
      }
      catch (IOException localIOException) {}
    }
    return i3;
  }
  
  private final int e(int paramInt)
  {
    int i1 = 0;
    t = 3;
    int i = 1;
    y[0] = 0;
    int i3 = Integer.MAX_VALUE;
    int i2 = paramInt;
    paramInt = i3;
    for (;;)
    {
      i3 = u + 1;
      u = i3;
      if (i3 == Integer.MAX_VALUE) {
        b();
      }
      if (q < '@')
      {
        i5 = q;
        i3 = i;
        i = paramInt;
        arrayOfInt = y;
        i4 = i3 - 1;
        switch (arrayOfInt[i4])
        {
        default: 
          paramInt = i;
        }
        for (;;)
        {
          i = paramInt;
          i3 = i4;
          if (i4 != i1) {
            break;
          }
          i = paramInt;
          if (paramInt != Integer.MAX_VALUE)
          {
            w = paramInt;
            v = i2;
            i = Integer.MAX_VALUE;
          }
          i2 += 1;
          i3 = t;
          t = i1;
          i1 = 3 - i1;
          if (i3 != i1) {
            break label586;
          }
          return i2;
          paramInt = i;
          if ((0xFFFFFFFBFFFFFFFF & 1L << i5) != 0L)
          {
            paramInt = i;
            if (i > 18) {
              paramInt = 18;
            }
            c(2);
            continue;
            paramInt = i;
            if (i > 17) {
              paramInt = 17;
            }
          }
        }
      }
      if (q < '')
      {
        l1 = 1L << (q & 0x3F);
        i3 = i;
        i = paramInt;
        label256:
        arrayOfInt = y;
        i4 = i3 - 1;
        switch (arrayOfInt[i4])
        {
        default: 
          paramInt = i;
        }
        for (;;)
        {
          i = paramInt;
          i3 = i4;
          if (i4 != i1) {
            break label256;
          }
          break;
          if ((0xFFFFFFFFEFFFFFFF & l1) != 0L)
          {
            paramInt = i;
            if (i > 18) {
              paramInt = 18;
            }
            c(2);
          }
          else
          {
            paramInt = i;
            if (q == '\\')
            {
              arrayOfInt = y;
              paramInt = t;
              t = (paramInt + 1);
              arrayOfInt[paramInt] = 1;
              paramInt = i;
              continue;
              paramInt = i;
              if (i > 17)
              {
                paramInt = 17;
                continue;
                paramInt = i;
                if ((0xFFFFFFFFEFFFFFFF & l1) != 0L)
                {
                  paramInt = i;
                  if (i > 18) {
                    paramInt = 18;
                  }
                  c(2);
                }
              }
            }
          }
        }
      }
      int i5 = (q & 0xFF) >> '\006';
      long l1 = 1L << (q & 0x3F);
      i3 = i;
      i = paramInt;
      label461:
      int[] arrayOfInt = y;
      int i4 = i3 - 1;
      switch (arrayOfInt[i4])
      {
      default: 
        paramInt = i;
      }
      for (;;)
      {
        i = paramInt;
        i3 = i4;
        if (i4 != i1) {
          break label461;
        }
        break;
        paramInt = i;
        if ((c[i5] & l1) != 0L)
        {
          paramInt = i;
          if (i > 18) {
            paramInt = 18;
          }
          c(2);
          continue;
          paramInt = i;
          if ((c[i5] & l1) != 0L)
          {
            paramInt = i;
            if (i > 17) {
              paramInt = 17;
            }
          }
        }
      }
      try
      {
        label586:
        q = m.a();
        paramInt = i;
        i = i3;
      }
      catch (IOException localIOException) {}
    }
    return i2;
  }
  
  private final int f(int paramInt)
  {
    t = 3;
    y[0] = 0;
    int i = 1;
    int i2 = 0;
    int i1 = Integer.MAX_VALUE;
    int i3 = paramInt;
    paramInt = i1;
    for (;;)
    {
      i1 = u + 1;
      u = i1;
      if (i1 == Integer.MAX_VALUE) {
        b();
      }
      if (q < '@')
      {
        i1 = paramInt;
        arrayOfInt = y;
        i4 = i - 1;
        switch (arrayOfInt[i4])
        {
        default: 
          paramInt = i1;
        }
        for (;;)
        {
          i1 = paramInt;
          i = i4;
          if (i4 != i2) {
            break;
          }
          i = paramInt;
          if (paramInt != Integer.MAX_VALUE)
          {
            w = paramInt;
            v = i3;
            i = Integer.MAX_VALUE;
          }
          i3 += 1;
          i1 = t;
          t = i2;
          i2 = 3 - i2;
          if (i1 != i2) {
            break label485;
          }
          return i3;
          paramInt = i1;
          if (i1 > 15)
          {
            paramInt = 15;
            continue;
            paramInt = i1;
            if (i1 > 12) {
              paramInt = 12;
            }
          }
        }
      }
      if (q < '')
      {
        i1 = i;
        i = paramInt;
        label206:
        arrayOfInt = y;
        i4 = i1 - 1;
        switch (arrayOfInt[i4])
        {
        default: 
          paramInt = i;
        }
        for (;;)
        {
          i = paramInt;
          i1 = i4;
          if (i4 != i2) {
            break label206;
          }
          break;
          i1 = i;
          if (i > 15) {
            i1 = 15;
          }
          paramInt = i1;
          if (q == '\\')
          {
            arrayOfInt = y;
            paramInt = t;
            t = (paramInt + 1);
            arrayOfInt[paramInt] = 1;
            paramInt = i1;
            continue;
            paramInt = i;
            if (i > 12)
            {
              paramInt = 12;
              continue;
              paramInt = i;
              if (i > 15) {
                paramInt = 15;
              }
            }
          }
        }
      }
      int i5 = (q & 0xFF) >> '\006';
      long l1 = 1L << (q & 0x3F);
      i1 = paramInt;
      label369:
      int[] arrayOfInt = y;
      int i4 = i - 1;
      switch (arrayOfInt[i4])
      {
      default: 
        paramInt = i1;
      }
      for (;;)
      {
        i1 = paramInt;
        i = i4;
        if (i4 != i2) {
          break label369;
        }
        break;
        paramInt = i1;
        if ((c[i5] & l1) != 0L)
        {
          paramInt = i1;
          if (i1 > 15)
          {
            paramInt = 15;
            continue;
            paramInt = i1;
            if ((c[i5] & l1) != 0L)
            {
              paramInt = i1;
              if (i1 > 12) {
                paramInt = 12;
              }
            }
          }
        }
      }
      try
      {
        label485:
        q = m.a();
        paramInt = i;
        i = i1;
      }
      catch (IOException localIOException) {}
    }
    return i3;
  }
  
  public final igp a()
  {
    igp localigp1 = null;
    int i1 = 0;
    int i = 0;
    Object localObject1 = null;
    label665:
    label1461:
    label1487:
    label1493:
    for (;;)
    {
      igp localigp2;
      try
      {
        localObject3 = m;
        c = -1;
        char c1 = ((igo)localObject3).a();
        c = d;
        q = c1;
        n = null;
        o = 0;
        switch (r)
        {
        default: 
          if (w == Integer.MAX_VALUE) {
            break label1487;
          }
          if (v + 1 < i) {
            m.a(i - v - 1);
          }
          if ((h[(w >> 6)] & 1L << (w & 0x3F)) == 0L) {
            break label665;
          }
          localigp1 = c();
          h = ((igp)localObject1);
          switch (w)
          {
          default: 
            if (g[w] != -1) {
              r = g[w];
            }
            return localigp1;
          }
          break;
        }
      }
      catch (IOException localIOException3)
      {
        w = 0;
        localigp2 = c();
        h = ((igp)localObject1);
        return localigp2;
      }
      w = Integer.MAX_VALUE;
      v = 0;
      switch (q)
      {
      default: 
        i = a(3, 0);
      }
      for (;;)
      {
        break;
        i = b(2);
        continue;
        i = b(1);
        continue;
        i = a(16);
        continue;
        i = a(7);
        continue;
        i = a(3);
        continue;
        i = a(4);
        continue;
        i = a(5);
      }
      w = Integer.MAX_VALUE;
      v = 0;
      switch (q)
      {
      default: 
        i = d(0);
      }
      for (;;)
      {
        break;
        i = a(10);
        continue;
        i = a(8);
      }
      w = Integer.MAX_VALUE;
      v = 0;
      switch (q)
      {
      default: 
        i = f(0);
      }
      for (;;)
      {
        break;
        i = a(13);
        continue;
        i = a(14);
      }
      w = Integer.MAX_VALUE;
      v = 0;
      switch (q)
      {
      }
      for (i = e(0);; i = a(19)) {
        break;
      }
      if (n == null) {
        n = new StringBuffer();
      }
      localObject1 = n;
      Object localObject3 = m;
      i = o;
      i1 = v + 1;
      p = i1;
      ((StringBuffer)localObject1).append(((igo)localObject3).b(i + i1));
      f = n.substring(0, n.length() - 1);
      continue;
      int i2;
      if ((j[(w >> 6)] & 1L << (w & 0x3F)) != 0L)
      {
        if ((k[(w >> 6)] & 1L << (w & 0x3F)) != 0L)
        {
          localObject3 = c();
          if (localObject1 == null) {}
          for (localObject1 = localObject3;; localObject1 = localObject3)
          {
            if (g[w] == -1) {
              break label1493;
            }
            r = g[w];
            break;
            h = ((igp)localObject1);
            g = ((igp)localObject3);
          }
        }
      }
      else
      {
        i = o;
        i2 = v + 1;
        p = i2;
        o = (i + i2);
        switch (w)
        {
        }
        for (;;)
        {
          if (g[w] != -1) {
            r = g[w];
          }
          w = Integer.MAX_VALUE;
          try
          {
            q = m.a();
            i = 0;
          }
          catch (IOException localIOException1)
          {
            i2 = 0;
          }
          if (n == null) {
            n = new StringBuffer();
          }
          n.append(m.b(o));
          o = 0;
          n.deleteCharAt(n.length() - 2);
          continue;
          if (n == null) {
            n = new StringBuffer();
          }
          n.append(m.b(o));
          o = 0;
          a = 1;
          continue;
          if (n == null) {
            n = new StringBuffer();
          }
          n.append(m.b(o));
          o = 0;
          n.deleteCharAt(n.length() - 2);
          continue;
          if (n == null) {
            n = new StringBuffer();
          }
          n.append(m.b(o));
          o = 0;
          a += 1;
          continue;
          if (n == null) {
            n = new StringBuffer();
          }
          n.append(m.b(o));
          o = 0;
          a -= 1;
          if (a == 0)
          {
            r = 1;
            continue;
            if (n == null) {
              n = new StringBuffer();
            }
            n.append(m.b(o));
            o = 0;
            n.deleteCharAt(n.length() - 1);
            continue;
            if (n == null) {
              n = new StringBuffer();
            }
            n.append(m.b(o));
            o = 0;
            n.deleteCharAt(n.length() - 2);
          }
        }
      }
      for (;;)
      {
        i = m.c();
        int i3 = m.b();
        try
        {
          m.a();
          m.a(1);
          bool = false;
          i1 = i3;
          localObject2 = localigp2;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            Object localObject2;
            if (i2 <= 1) {}
            for (String str = "";; str = m.d())
            {
              if ((q != '\n') && (q != '\r')) {
                break label1461;
              }
              i += 1;
              bool = true;
              break;
            }
            i1 = i3 + 1;
            boolean bool = true;
            continue;
            str = m.d();
          }
        }
        if (!bool)
        {
          m.a(1);
          if (i2 <= 1) {
            localObject2 = "";
          }
        }
        else
        {
          throw new igq(bool, i, i1, (String)localObject2, q);
        }
        break;
        i2 = i;
      }
    }
  }
}

/* Location:
 * Qualified Name:     igm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */