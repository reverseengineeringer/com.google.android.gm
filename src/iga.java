import java.io.IOException;
import java.io.PrintStream;

public final class iga
  implements ifz
{
  static int a;
  static final long[] c = { 0L, 0L, -1L, -1L };
  static final int[] d = new int[0];
  public static final String[] e = { "", "\r", "\n", ",", ":", ";", "<", ">", "@", ".", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null };
  public static final String[] f = { "DEFAULT", "INDOMAINLITERAL", "INCOMMENT", "NESTED_COMMENT", "INQUOTEDSTRING" };
  public static final int[] h = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, 0, 2, 0, -1, 3, -1, -1, -1, -1, -1, 4, -1, -1, 0, -1, -1 };
  static final long[] i = { 2147763199L };
  static final long[] j = { 1049600L };
  static final long[] k = { 1024L };
  static final long[] l = { 2146140160L };
  public PrintStream b = System.out;
  public igg m;
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
  
  public iga(igg paramigg)
  {
    m = paramigg;
  }
  
  private final int a(int paramInt)
  {
    w = paramInt;
    v = 0;
    return 1;
  }
  
  private final void b()
  {
    u = -2147483647;
    int i2;
    for (int i1 = 3;; i1 = i2)
    {
      i2 = i1 - 1;
      if (i1 <= 0) {
        break;
      }
      x[i2] = Integer.MIN_VALUE;
    }
  }
  
  private final void b(int paramInt)
  {
    if (x[paramInt] != u)
    {
      int[] arrayOfInt = y;
      int i1 = t;
      t = (i1 + 1);
      arrayOfInt[i1] = paramInt;
      x[paramInt] = u;
    }
  }
  
  private final int c(int paramInt)
  {
    t = 3;
    y[0] = 1;
    int i1 = 1;
    int i3 = 0;
    int i2 = Integer.MAX_VALUE;
    int i4 = paramInt;
    paramInt = i2;
    for (;;)
    {
      i2 = u + 1;
      u = i2;
      if (i2 == Integer.MAX_VALUE) {
        b();
      }
      long l1;
      if (q < '@')
      {
        l1 = 1L << q;
        i2 = i1;
        i1 = paramInt;
        do
        {
          arrayOfInt = y;
          i5 = i2 - 1;
          switch (arrayOfInt[i5])
          {
          default: 
            paramInt = i1;
            i1 = paramInt;
            i2 = i5;
          }
        } while (i5 != i3);
        i2 = paramInt;
      }
      do
      {
        paramInt = i2;
        if (i2 != Integer.MAX_VALUE)
        {
          w = i2;
          v = i4;
          paramInt = Integer.MAX_VALUE;
        }
        i4 += 1;
        i1 = t;
        t = i3;
        i3 = 3 - i3;
        if (i1 != i3) {
          break label410;
        }
        return i4;
        if ((0xA3FFACFA00000000 & l1) != 0L)
        {
          paramInt = i1;
          if (i1 > 14) {
            paramInt = 14;
          }
          b(2);
          break;
        }
        paramInt = i1;
        if ((0x100000200 & l1) == 0L) {
          break;
        }
        paramInt = i1;
        if (i1 > 10) {
          paramInt = 10;
        }
        b(0);
        break;
        paramInt = i1;
        if ((0x100000200 & l1) == 0L) {
          break;
        }
        paramInt = 10;
        b(0);
        break;
        paramInt = i1;
        if ((0xA3FFECFA00000000 & l1) == 0L) {
          break;
        }
        paramInt = i1;
        if (i1 > 14) {
          paramInt = 14;
        }
        b(2);
        break;
        i2 = paramInt;
      } while (q >= '');
      int i6 = q;
      label318:
      int[] arrayOfInt = y;
      int i5 = i1 - 1;
      switch (arrayOfInt[i5])
      {
      default: 
        i2 = paramInt;
      }
      for (;;)
      {
        paramInt = i2;
        i1 = i5;
        if (i5 != i3) {
          break label318;
        }
        break;
        i2 = paramInt;
        if ((0x7FFFFFFFC7FFFFFE & 1L << (i6 & 0x3F)) != 0L)
        {
          i2 = paramInt;
          if (paramInt > 14) {
            i2 = 14;
          }
          b(2);
        }
      }
      try
      {
        label410:
        q = m.a();
      }
      catch (IOException localIOException) {}
    }
    return i4;
  }
  
  private final igi c()
  {
    igi localigi = new igi();
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
    return localigi;
  }
  
  private final int d(int paramInt)
  {
    t = 3;
    y[0] = 0;
    int i1 = 1;
    int i3 = 0;
    int i2 = Integer.MAX_VALUE;
    int i4 = paramInt;
    paramInt = i2;
    for (;;)
    {
      i2 = u + 1;
      u = i2;
      if (i2 == Integer.MAX_VALUE) {
        b();
      }
      if (q < '@')
      {
        i2 = paramInt;
        arrayOfInt = y;
        i5 = i1 - 1;
        switch (arrayOfInt[i5])
        {
        default: 
          paramInt = i2;
        }
        for (;;)
        {
          i2 = paramInt;
          i1 = i5;
          if (i5 != i3) {
            break;
          }
          i1 = paramInt;
          if (paramInt != Integer.MAX_VALUE)
          {
            w = paramInt;
            v = i4;
            i1 = Integer.MAX_VALUE;
          }
          i4 += 1;
          i2 = t;
          t = i3;
          i3 = 3 - i3;
          if (i2 != i3) {
            break label485;
          }
          return i4;
          paramInt = i2;
          if (i2 > 23)
          {
            paramInt = 23;
            continue;
            paramInt = i2;
            if (i2 > 21) {
              paramInt = 21;
            }
          }
        }
      }
      if (q < '')
      {
        i2 = i1;
        i1 = paramInt;
        label206:
        arrayOfInt = y;
        i5 = i2 - 1;
        switch (arrayOfInt[i5])
        {
        default: 
          paramInt = i1;
        }
        for (;;)
        {
          i1 = paramInt;
          i2 = i5;
          if (i5 != i3) {
            break label206;
          }
          break;
          i2 = i1;
          if (i1 > 23) {
            i2 = 23;
          }
          paramInt = i2;
          if (q == '\\')
          {
            arrayOfInt = y;
            paramInt = t;
            t = (paramInt + 1);
            arrayOfInt[paramInt] = 1;
            paramInt = i2;
            continue;
            paramInt = i1;
            if (i1 > 21)
            {
              paramInt = 21;
              continue;
              paramInt = i1;
              if (i1 > 23) {
                paramInt = 23;
              }
            }
          }
        }
      }
      int i6 = (q & 0xFF) >> '\006';
      long l1 = 1L << (q & 0x3F);
      i2 = paramInt;
      label369:
      int[] arrayOfInt = y;
      int i5 = i1 - 1;
      switch (arrayOfInt[i5])
      {
      default: 
        paramInt = i2;
      }
      for (;;)
      {
        i2 = paramInt;
        i1 = i5;
        if (i5 != i3) {
          break label369;
        }
        break;
        paramInt = i2;
        if ((c[i6] & l1) != 0L)
        {
          paramInt = i2;
          if (i2 > 23)
          {
            paramInt = 23;
            continue;
            paramInt = i2;
            if ((c[i6] & l1) != 0L)
            {
              paramInt = i2;
              if (i2 > 21) {
                paramInt = 21;
              }
            }
          }
        }
      }
      try
      {
        label485:
        q = m.a();
        paramInt = i1;
        i1 = i2;
      }
      catch (IOException localIOException) {}
    }
    return i4;
  }
  
  private final int e(int paramInt)
  {
    int i2 = 0;
    t = 3;
    int i1 = 1;
    y[0] = 0;
    int i4 = Integer.MAX_VALUE;
    int i3 = paramInt;
    paramInt = i4;
    for (;;)
    {
      i4 = u + 1;
      u = i4;
      if (i4 == Integer.MAX_VALUE) {
        b();
      }
      if (q < '@')
      {
        i6 = q;
        i4 = i1;
        i1 = paramInt;
        arrayOfInt = y;
        i5 = i4 - 1;
        switch (arrayOfInt[i5])
        {
        default: 
          paramInt = i1;
        }
        for (;;)
        {
          i1 = paramInt;
          i4 = i5;
          if (i5 != i2) {
            break;
          }
          i1 = paramInt;
          if (paramInt != Integer.MAX_VALUE)
          {
            w = paramInt;
            v = i3;
            i1 = Integer.MAX_VALUE;
          }
          i3 += 1;
          i4 = t;
          t = i2;
          i2 = 3 - i2;
          if (i4 != i2) {
            break label586;
          }
          return i3;
          paramInt = i1;
          if ((0xFFFFFFFBFFFFFFFF & 1L << i6) != 0L)
          {
            paramInt = i1;
            if (i1 > 30) {
              paramInt = 30;
            }
            b(2);
            continue;
            paramInt = i1;
            if (i1 > 29) {
              paramInt = 29;
            }
          }
        }
      }
      if (q < '')
      {
        l1 = 1L << (q & 0x3F);
        i4 = i1;
        i1 = paramInt;
        label256:
        arrayOfInt = y;
        i5 = i4 - 1;
        switch (arrayOfInt[i5])
        {
        default: 
          paramInt = i1;
        }
        for (;;)
        {
          i1 = paramInt;
          i4 = i5;
          if (i5 != i2) {
            break label256;
          }
          break;
          if ((0xFFFFFFFFEFFFFFFF & l1) != 0L)
          {
            paramInt = i1;
            if (i1 > 30) {
              paramInt = 30;
            }
            b(2);
          }
          else
          {
            paramInt = i1;
            if (q == '\\')
            {
              arrayOfInt = y;
              paramInt = t;
              t = (paramInt + 1);
              arrayOfInt[paramInt] = 1;
              paramInt = i1;
              continue;
              paramInt = i1;
              if (i1 > 29)
              {
                paramInt = 29;
                continue;
                paramInt = i1;
                if ((0xFFFFFFFFEFFFFFFF & l1) != 0L)
                {
                  paramInt = i1;
                  if (i1 > 30) {
                    paramInt = 30;
                  }
                  b(2);
                }
              }
            }
          }
        }
      }
      int i6 = (q & 0xFF) >> '\006';
      long l1 = 1L << (q & 0x3F);
      i4 = i1;
      i1 = paramInt;
      label461:
      int[] arrayOfInt = y;
      int i5 = i4 - 1;
      switch (arrayOfInt[i5])
      {
      default: 
        paramInt = i1;
      }
      for (;;)
      {
        i1 = paramInt;
        i4 = i5;
        if (i5 != i2) {
          break label461;
        }
        break;
        paramInt = i1;
        if ((c[i6] & l1) != 0L)
        {
          paramInt = i1;
          if (i1 > 30) {
            paramInt = 30;
          }
          b(2);
          continue;
          paramInt = i1;
          if ((c[i6] & l1) != 0L)
          {
            paramInt = i1;
            if (i1 > 29) {
              paramInt = 29;
            }
          }
        }
      }
      try
      {
        label586:
        q = m.a();
        paramInt = i1;
        i1 = i4;
      }
      catch (IOException localIOException) {}
    }
    return i3;
  }
  
  private final int f(int paramInt)
  {
    t = 3;
    y[0] = 0;
    int i1 = 1;
    int i3 = 0;
    int i2 = Integer.MAX_VALUE;
    int i4 = paramInt;
    paramInt = i2;
    for (;;)
    {
      i2 = u + 1;
      u = i2;
      if (i2 == Integer.MAX_VALUE) {
        b();
      }
      if (q < '@')
      {
        i2 = paramInt;
        arrayOfInt = y;
        i5 = i1 - 1;
        switch (arrayOfInt[i5])
        {
        default: 
          paramInt = i2;
        }
        for (;;)
        {
          i2 = paramInt;
          i1 = i5;
          if (i5 != i3) {
            break;
          }
          i1 = paramInt;
          if (paramInt != Integer.MAX_VALUE)
          {
            w = paramInt;
            v = i4;
            i1 = Integer.MAX_VALUE;
          }
          i4 += 1;
          i2 = t;
          t = i3;
          i3 = 3 - i3;
          if (i2 != i3) {
            break label485;
          }
          return i4;
          paramInt = i2;
          if (i2 > 27)
          {
            paramInt = 27;
            continue;
            paramInt = i2;
            if (i2 > 24) {
              paramInt = 24;
            }
          }
        }
      }
      if (q < '')
      {
        i2 = i1;
        i1 = paramInt;
        label206:
        arrayOfInt = y;
        i5 = i2 - 1;
        switch (arrayOfInt[i5])
        {
        default: 
          paramInt = i1;
        }
        for (;;)
        {
          i1 = paramInt;
          i2 = i5;
          if (i5 != i3) {
            break label206;
          }
          break;
          i2 = i1;
          if (i1 > 27) {
            i2 = 27;
          }
          paramInt = i2;
          if (q == '\\')
          {
            arrayOfInt = y;
            paramInt = t;
            t = (paramInt + 1);
            arrayOfInt[paramInt] = 1;
            paramInt = i2;
            continue;
            paramInt = i1;
            if (i1 > 24)
            {
              paramInt = 24;
              continue;
              paramInt = i1;
              if (i1 > 27) {
                paramInt = 27;
              }
            }
          }
        }
      }
      int i6 = (q & 0xFF) >> '\006';
      long l1 = 1L << (q & 0x3F);
      i2 = paramInt;
      label369:
      int[] arrayOfInt = y;
      int i5 = i1 - 1;
      switch (arrayOfInt[i5])
      {
      default: 
        paramInt = i2;
      }
      for (;;)
      {
        i2 = paramInt;
        i1 = i5;
        if (i5 != i3) {
          break label369;
        }
        break;
        paramInt = i2;
        if ((c[i6] & l1) != 0L)
        {
          paramInt = i2;
          if (i2 > 27)
          {
            paramInt = 27;
            continue;
            paramInt = i2;
            if ((c[i6] & l1) != 0L)
            {
              paramInt = i2;
              if (i2 > 24) {
                paramInt = 24;
              }
            }
          }
        }
      }
      try
      {
        label485:
        q = m.a();
        paramInt = i1;
        i1 = i2;
      }
      catch (IOException localIOException) {}
    }
    return i4;
  }
  
  private final int g(int paramInt)
  {
    t = 3;
    y[0] = 0;
    int i2 = 0;
    int i1 = 1;
    int i4 = Integer.MAX_VALUE;
    int i3 = paramInt;
    paramInt = i4;
    for (;;)
    {
      i4 = u + 1;
      u = i4;
      if (i4 == Integer.MAX_VALUE) {
        b();
      }
      if (q < '@')
      {
        i4 = paramInt;
        arrayOfInt = y;
        i5 = i1 - 1;
        switch (arrayOfInt[i5])
        {
        default: 
          paramInt = i4;
        }
        for (;;)
        {
          i4 = paramInt;
          i1 = i5;
          if (i5 != i2) {
            break;
          }
          i1 = paramInt;
          if (paramInt != Integer.MAX_VALUE)
          {
            w = paramInt;
            v = i3;
            i1 = Integer.MAX_VALUE;
          }
          i3 += 1;
          i4 = t;
          t = i2;
          i2 = 3 - i2;
          if (i4 != i2) {
            break label540;
          }
          return i3;
          paramInt = i4;
          if (i4 > 17)
          {
            paramInt = 17;
            continue;
            paramInt = i4;
            if (i4 > 16) {
              paramInt = 16;
            }
          }
        }
      }
      if (q < '')
      {
        l1 = 1L << (q & 0x3F);
        i4 = i1;
        i1 = paramInt;
        label225:
        arrayOfInt = y;
        i5 = i4 - 1;
        switch (arrayOfInt[i5])
        {
        default: 
          paramInt = i1;
        }
        for (;;)
        {
          i1 = paramInt;
          i4 = i5;
          if (i5 != i2) {
            break label225;
          }
          break;
          if ((0xFFFFFFFFC7FFFFFF & l1) != 0L)
          {
            paramInt = i1;
            if (i1 > 17) {
              paramInt = 17;
            }
          }
          else
          {
            paramInt = i1;
            if (q == '\\')
            {
              arrayOfInt = y;
              paramInt = t;
              t = (paramInt + 1);
              arrayOfInt[paramInt] = 1;
              paramInt = i1;
              continue;
              paramInt = i1;
              if (i1 > 16)
              {
                paramInt = 16;
                continue;
                paramInt = i1;
                if ((0xFFFFFFFFC7FFFFFF & l1) != 0L)
                {
                  paramInt = i1;
                  if (i1 > 17) {
                    paramInt = 17;
                  }
                }
              }
            }
          }
        }
      }
      int i6 = (q & 0xFF) >> '\006';
      long l1 = 1L << (q & 0x3F);
      i4 = paramInt;
      label417:
      int[] arrayOfInt = y;
      int i5 = i1 - 1;
      switch (arrayOfInt[i5])
      {
      default: 
        paramInt = i4;
      }
      for (;;)
      {
        i4 = paramInt;
        i1 = i5;
        if (i5 != i2) {
          break label417;
        }
        break;
        paramInt = i4;
        if ((c[i6] & l1) != 0L)
        {
          paramInt = i4;
          if (i4 > 17)
          {
            paramInt = 17;
            continue;
            paramInt = i4;
            if ((c[i6] & l1) != 0L)
            {
              paramInt = i4;
              if (i4 > 16) {
                paramInt = 16;
              }
            }
          }
        }
      }
      try
      {
        label540:
        q = m.a();
        paramInt = i1;
        i1 = i4;
      }
      catch (IOException localIOException) {}
    }
    return i3;
  }
  
  public final igi a()
  {
    igi localigi1 = null;
    int i2 = 0;
    int i1 = 0;
    Object localObject1 = null;
    label893:
    label1771:
    label1797:
    label1803:
    for (;;)
    {
      igi localigi2;
      try
      {
        localObject3 = m;
        c = -1;
        char c1 = ((igg)localObject3).a();
        c = d;
        q = c1;
        n = null;
        o = 0;
        switch (r)
        {
        default: 
          if (w == Integer.MAX_VALUE) {
            break label1797;
          }
          if (v + 1 < i1) {
            m.a(i1 - v - 1);
          }
          if ((i[(w >> 6)] & 1L << (w & 0x3F)) == 0L) {
            break label893;
          }
          localigi1 = c();
          h = ((igi)localObject1);
          switch (w)
          {
          default: 
            if (h[w] != -1) {
              r = h[w];
            }
            return localigi1;
          }
          break;
        }
      }
      catch (IOException localIOException3)
      {
        w = 0;
        localigi2 = c();
        h = ((igi)localObject1);
        return localigi2;
      }
      w = Integer.MAX_VALUE;
      v = 0;
      switch (q)
      {
      default: 
        i1 = c(0);
      }
      for (;;)
      {
        break;
        i1 = a(2);
        continue;
        i1 = a(1);
        continue;
        i1 = a(28);
        continue;
        i1 = a(19);
        continue;
        i1 = a(3);
        continue;
        i1 = a(9);
        continue;
        i1 = a(4);
        continue;
        i1 = a(5);
        continue;
        i1 = a(6);
        continue;
        i1 = a(7);
        continue;
        i1 = a(8);
        continue;
        i1 = a(15);
      }
      w = Integer.MAX_VALUE;
      v = 0;
      switch (q)
      {
      }
      for (i1 = g(0);; i1 = a(18)) {
        break;
      }
      w = Integer.MAX_VALUE;
      v = 0;
      switch (q)
      {
      default: 
        i1 = d(0);
      }
      for (;;)
      {
        break;
        i1 = a(22);
        continue;
        i1 = a(20);
      }
      w = Integer.MAX_VALUE;
      v = 0;
      switch (q)
      {
      default: 
        i1 = f(0);
      }
      for (;;)
      {
        break;
        i1 = a(25);
        continue;
        i1 = a(26);
      }
      w = Integer.MAX_VALUE;
      v = 0;
      switch (q)
      {
      }
      for (i1 = e(0);; i1 = a(31)) {
        break;
      }
      if (n == null) {
        n = new StringBuffer();
      }
      localObject1 = n;
      Object localObject3 = m;
      i1 = o;
      i2 = v + 1;
      p = i2;
      ((StringBuffer)localObject1).append(((igg)localObject3).b(i1 + i2));
      f = n.toString();
      continue;
      if (n == null) {
        n = new StringBuffer();
      }
      localObject1 = n;
      localObject3 = m;
      i1 = o;
      i2 = v + 1;
      p = i2;
      ((StringBuffer)localObject1).append(((igg)localObject3).b(i1 + i2));
      f = n.substring(0, n.length() - 1);
      continue;
      int i3;
      if ((j[(w >> 6)] & 1L << (w & 0x3F)) != 0L)
      {
        if ((k[(w >> 6)] & 1L << (w & 0x3F)) != 0L)
        {
          localObject3 = c();
          if (localObject1 == null) {}
          for (localObject1 = localObject3;; localObject1 = localObject3)
          {
            if (h[w] == -1) {
              break label1803;
            }
            r = h[w];
            break;
            h = ((igi)localObject1);
            g = ((igi)localObject3);
          }
        }
      }
      else
      {
        i1 = o;
        i3 = v + 1;
        p = i3;
        o = (i1 + i3);
        switch (w)
        {
        }
        for (;;)
        {
          if (h[w] != -1) {
            r = h[w];
          }
          w = Integer.MAX_VALUE;
          try
          {
            q = m.a();
            i1 = 0;
          }
          catch (IOException localIOException1)
          {
            i3 = 0;
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
            r = 2;
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
        i1 = m.c();
        int i4 = m.b();
        try
        {
          m.a();
          m.a(1);
          bool = false;
          i2 = i4;
          localObject2 = localigi2;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            Object localObject2;
            if (i3 <= 1) {}
            for (String str = "";; str = m.d())
            {
              if ((q != '\n') && (q != '\r')) {
                break label1771;
              }
              i1 += 1;
              bool = true;
              break;
            }
            i2 = i4 + 1;
            boolean bool = true;
            continue;
            str = m.d();
          }
        }
        if (!bool)
        {
          m.a(1);
          if (i3 <= 1) {
            localObject2 = "";
          }
        }
        else
        {
          throw new igj(bool, i1, i2, (String)localObject2, q);
        }
        break;
        i3 = i1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     iga
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */