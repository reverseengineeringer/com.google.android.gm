import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public final class hst
  implements Serializable, Comparable
{
  private static final long serialVersionUID = 5013232281547134583L;
  private boolean a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public hst(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > 0)) {
      throw new IllegalArgumentException("Invalid duration representation");
    }
    b = 0;
    c = Math.abs(paramInt);
    d = Math.abs(0);
    e = Math.abs(0);
    f = Math.abs(0);
    if (paramInt < 0) {
      bool = true;
    }
    a = bool;
  }
  
  public hst(String paramString)
  {
    a = false;
    b = 0;
    c = 0;
    d = 0;
    e = 0;
    f = 0;
    String str = null;
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "+-PWDTHMS", true);
    paramString = str;
    for (;;)
    {
      if (localStringTokenizer.hasMoreTokens())
      {
        str = localStringTokenizer.nextToken();
        if ("+".equals(str))
        {
          a = false;
          paramString = str;
          continue;
        }
        if ("-".equals(str))
        {
          a = true;
          paramString = str;
          continue;
        }
        if (!"P".equals(str))
        {
          if ("W".equals(str))
          {
            b = Integer.parseInt(paramString);
            paramString = str;
            continue;
          }
          if ("D".equals(str))
          {
            c = Integer.parseInt(paramString);
            paramString = str;
            continue;
          }
          if (!"T".equals(str))
          {
            if ("H".equals(str))
            {
              d = Integer.parseInt(paramString);
              paramString = str;
              continue;
            }
            if ("M".equals(str))
            {
              e = Integer.parseInt(paramString);
              paramString = str;
              continue;
            }
            if ("S".equals(str))
            {
              f = Integer.parseInt(paramString);
              paramString = str;
            }
          }
        }
      }
      else
      {
        return;
      }
      paramString = str;
    }
  }
  
  public hst(Date paramDate1, Date paramDate2)
  {
    boolean bool;
    if (paramDate1.compareTo(paramDate2) > 0)
    {
      bool = true;
      a = bool;
      if (!a) {
        break label129;
      }
      label28:
      if (!(paramDate2 instanceof hsn)) {
        break label140;
      }
    }
    label129:
    label140:
    for (Object localObject = ich.a((hsn)paramDate2);; localObject = Calendar.getInstance())
    {
      ((Calendar)localObject).setTime(paramDate2);
      paramDate2 = Calendar.getInstance(((Calendar)localObject).getTimeZone());
      paramDate2.setTime(paramDate1);
      j = paramDate2.get(1) - ((Calendar)localObject).get(1);
      i = 0;
      while (j > 0)
      {
        ((Calendar)localObject).add(5, j * 365);
        i += j * 365;
        j = paramDate2.get(1) - ((Calendar)localObject).get(1);
      }
      bool = false;
      break;
      localObject = paramDate2;
      paramDate2 = paramDate1;
      paramDate1 = (Date)localObject;
      break label28;
    }
    int j = paramDate2.get(6);
    int k = ((Calendar)localObject).get(6);
    int m = paramDate2.get(11);
    int n = ((Calendar)localObject).get(11);
    int i1 = paramDate2.get(12);
    int i2 = ((Calendar)localObject).get(12);
    int i = paramDate2.get(13) - ((Calendar)localObject).get(13) + (((j - k + i) * 24 + (m - n)) * 60 + (i1 - i2)) * 60;
    f = (i % 60);
    i /= 60;
    e = (i % 60);
    i /= 60;
    d = (i % 24);
    c = (i / 24);
    b = 0;
    if ((f == 0) && (e == 0) && (d == 0) && (c % 7 == 0))
    {
      b = (c / 7);
      c = 0;
    }
  }
  
  private final void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
  }
  
  public final int a(hst paramhst)
  {
    int j;
    if (a != a)
    {
      if (a)
      {
        j = Integer.MIN_VALUE;
        return j;
      }
      return Integer.MAX_VALUE;
    }
    int i;
    if (b != b) {
      i = b - b;
    }
    for (;;)
    {
      j = i;
      if (!a) {
        break;
      }
      return -i;
      if (c != c) {
        i = c - c;
      } else if (d != d) {
        i = d - d;
      } else if (e != e) {
        i = e - e;
      } else {
        i = f - f;
      }
    }
  }
  
  public final Date a(Date paramDate)
  {
    Calendar localCalendar;
    if ((paramDate instanceof hsn))
    {
      localCalendar = ich.a((hsn)paramDate);
      localCalendar.setTime(paramDate);
      if (!a) {
        break label93;
      }
      localCalendar.add(3, -b);
      localCalendar.add(7, -c);
      localCalendar.add(11, -d);
      localCalendar.add(12, -e);
      localCalendar.add(13, -f);
    }
    for (;;)
    {
      return localCalendar.getTime();
      localCalendar = Calendar.getInstance();
      break;
      label93:
      localCalendar.add(3, b);
      localCalendar.add(7, c);
      localCalendar.add(11, d);
      localCalendar.add(12, e);
      localCalendar.add(13, f);
    }
  }
  
  public final int compareTo(Object paramObject)
  {
    return a((hst)paramObject);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof hst)) {
      return ((hst)paramObject).a(this) == 0;
    }
    return super.equals(paramObject);
  }
  
  public final int hashCode()
  {
    return idlab).a(c).a(d).a(e).a(f).a(a).a;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (a) {
      localStringBuffer.append('-');
    }
    localStringBuffer.append('P');
    if (b > 0)
    {
      localStringBuffer.append(b);
      localStringBuffer.append('W');
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if (c > 0)
      {
        localStringBuffer.append(c);
        localStringBuffer.append('D');
      }
      if ((d > 0) || (e > 0) || (f > 0))
      {
        localStringBuffer.append('T');
        if (d > 0)
        {
          localStringBuffer.append(d);
          localStringBuffer.append('H');
        }
        if (e > 0)
        {
          localStringBuffer.append(e);
          localStringBuffer.append('M');
        }
        if (f > 0)
        {
          localStringBuffer.append(f);
          localStringBuffer.append('S');
        }
      }
      if (d + e + f + c + b == 0) {
        localStringBuffer.append("T0S");
      }
    }
  }
}

/* Location:
 * Qualified Name:     hst
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */