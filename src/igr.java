import java.io.StringReader;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class igr
{
  public final Date a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  
  private igr(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = Integer.parseInt(paramString);
    switch (paramString.length())
    {
    }
    for (;;)
    {
      b = i;
      i = b;
      paramString = new GregorianCalendar(TimeZone.getTimeZone("GMT+0"));
      paramString.set(i, paramInt1 - 1, paramInt2, paramInt3, paramInt4, paramInt5);
      paramString.set(14, 0);
      if (paramInt6 != Integer.MIN_VALUE) {
        paramString.add(12, (paramInt6 / 100 * 60 + paramInt6 % 100) * -1);
      }
      a = paramString.getTime();
      c = paramInt1;
      d = paramInt2;
      e = paramInt3;
      f = paramInt4;
      g = paramInt5;
      h = paramInt6;
      return;
      if ((i >= 0) && (i < 50))
      {
        i += 2000;
      }
      else
      {
        i += 1900;
        continue;
        i += 1900;
      }
    }
  }
  
  public static igr a(String paramString)
  {
    int j = 3;
    int k = -1;
    int i;
    try
    {
      paramString = new igs(new StringReader(paramString));
      if (e != -1) {
        break label110;
      }
      i = paramString.a();
    }
    catch (iha paramString)
    {
      throw new igx(paramString.getMessage());
    }
    g[1] = f;
    int m = igs.a(paramString.a(46));
    label73:
    label110:
    label134:
    Object localObject1;
    int n;
    label329:
    label357:
    label548:
    Object localObject2;
    int i1;
    if (e == -1)
    {
      i = paramString.a();
      break label903;
      g[3] = f;
      paramString.a(-1);
      throw new igx();
      i = e;
      break label857;
      if (e == -1)
      {
        i = paramString.a();
        break label971;
        g[2] = f;
        paramString.a(-1);
        throw new igx();
      }
      i = e;
      break label971;
      paramString.a(4);
      for (;;)
      {
        localObject1 = c;
        paramString.a(3);
        break;
        paramString.a(5);
        continue;
        paramString.a(6);
        continue;
        paramString.a(7);
        continue;
        paramString.a(8);
        continue;
        paramString.a(9);
        continue;
        paramString.a(10);
      }
    }
    else
    {
      i = e;
      break label903;
      paramString.a(11);
      i = 1;
      localObject1 = new igt(a46f, i, m);
      m = igs.a(paramString.a(46));
      paramString.a(23);
      n = igs.a(paramString.a(46));
      if (e == -1)
      {
        i = paramString.a();
        break label1019;
        g[4] = f;
      }
      for (j = 0;; j = igs.a(paramString.a(46)))
      {
        if (e != -1) {
          break label548;
        }
        i = paramString.a();
        break label1043;
        g[5] = f;
        paramString.a(-1);
        throw new igx();
        paramString.a(12);
        i = 2;
        break;
        paramString.a(13);
        i = j;
        break;
        paramString.a(14);
        i = 4;
        break;
        paramString.a(15);
        i = 5;
        break;
        paramString.a(16);
        i = 6;
        break;
        paramString.a(17);
        i = 7;
        break;
        paramString.a(18);
        i = 8;
        break;
        paramString.a(19);
        i = 9;
        break;
        paramString.a(20);
        i = 10;
        break;
        paramString.a(21);
        i = 11;
        break;
        paramString.a(22);
        i = 12;
        break;
        i = e;
        break label1019;
        paramString.a(23);
      }
      i = e;
      break label1043;
      localObject2 = paramString.a(24);
      i1 = igs.a(paramString.a(46));
      if (!f.equals("-")) {
        break label1119;
      }
      i = k;
      break label1111;
    }
    for (;;)
    {
      localObject2 = new igu(m, n, j, i);
      localObject1 = new igr(a, b, c, a, b, c, d);
      paramString.a(0);
      return (igr)localObject1;
      if (e == -1) {
        i = paramString.a();
      }
      for (;;)
      {
        g[6] = f;
        paramString.a(-1);
        throw new igx();
        i = e;
        break label1124;
        paramString.a(25);
        i = 0;
        break label1187;
        paramString.a(26);
        i = 0;
        break label1187;
        paramString.a(27);
        i = -5;
        break label1187;
        paramString.a(28);
        i = -4;
        break label1187;
        paramString.a(29);
        i = -6;
        break label1187;
        paramString.a(30);
        i = -5;
        break label1187;
        paramString.a(31);
        i = -7;
        break label1187;
        paramString.a(32);
        i = -6;
        break label1187;
        paramString.a(33);
        i = -8;
        break label1187;
        paramString.a(34);
        i = -7;
        break label1187;
        a35f.charAt(0);
        i = 0;
        break label1187;
        label857:
        switch (i)
        {
        }
        break;
        label903:
        switch (i)
        {
        }
        break label73;
        label971:
        switch (i)
        {
        }
        break label134;
        label1019:
        switch (i)
        {
        }
        break label329;
        label1043:
        switch (i)
        {
        }
        break label357;
        for (;;)
        {
          label1111:
          i *= i1;
          break;
          label1119:
          i = 1;
        }
        label1124:
        switch (i)
        {
        }
      }
      label1187:
      i *= 100;
    }
  }
}

/* Location:
 * Qualified Name:     igr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */