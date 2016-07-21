import java.io.Serializable;

public class hww
  implements Serializable
{
  public static final hww a = new hww("SU", (byte)0);
  public static final hww b = new hww("MO", (byte)0);
  public static final hww c = new hww("TU", (byte)0);
  public static final hww d = new hww("WE", (byte)0);
  public static final hww e = new hww("TH", (byte)0);
  public static final hww f = new hww("FR", (byte)0);
  public static final hww g = new hww("SA", (byte)0);
  private static final long serialVersionUID = -4412000990022011469L;
  int h;
  private String i;
  
  public hww(hww paramhww)
  {
    i = i;
    h = 0;
  }
  
  public hww(String paramString)
  {
    if (paramString.length() > 2)
    {
      h = icm.a(paramString.substring(0, paramString.length() - 2));
      i = paramString.substring(paramString.length() - 2).toUpperCase();
      if ((ai.equals(i)) || (bi.equals(i)) || (ci.equals(i)) || (di.equals(i)) || (ei.equals(i)) || (fi.equals(i)) || (gi.equals(i))) {
        return;
      }
      paramString = String.valueOf(i);
      if (paramString.length() == 0) {
        break label198;
      }
    }
    label198:
    for (paramString = "Invalid day: ".concat(paramString);; paramString = new String("Invalid day: "))
    {
      throw new IllegalArgumentException(paramString);
      h = 0;
      break;
    }
  }
  
  private hww(String paramString, byte paramByte)
  {
    i = paramString;
    h = 0;
  }
  
  public static int a(hww paramhww)
  {
    int j = -1;
    if (ai.equals(i)) {
      j = 1;
    }
    do
    {
      return j;
      if (bi.equals(i)) {
        return 2;
      }
      if (ci.equals(i)) {
        return 3;
      }
      if (di.equals(i)) {
        return 4;
      }
      if (ei.equals(i)) {
        return 5;
      }
      if (fi.equals(i)) {
        return 6;
      }
    } while (!gi.equals(i));
    return 7;
  }
  
  public static hww a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return a;
    case 2: 
      return b;
    case 3: 
      return c;
    case 4: 
      return d;
    case 5: 
      return e;
    case 6: 
      return f;
    }
    return g;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof hww));
      paramObject = (hww)paramObject;
    } while ((!idh.a(i, i)) || (h != h));
    return true;
  }
  
  public final int hashCode()
  {
    return idlai).a(h).a;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (h != 0) {
      localStringBuffer.append(h);
    }
    localStringBuffer.append(i);
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hww
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */