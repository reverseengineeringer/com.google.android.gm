import java.util.ArrayList;
import java.util.Iterator;

public class axr
  extends axp
{
  public static final axr c = new axs();
  public ArrayList<axp> d = new ArrayList();
  
  public final axp a(int paramInt)
  {
    if (paramInt >= d.size()) {
      return axp.a;
    }
    return (axp)d.get(paramInt);
  }
  
  public final axp a(String paramString, boolean paramBoolean)
  {
    int i = 1;
    while (i < d.size())
    {
      if (a(i - 1, paramString, paramBoolean)) {
        return (axp)d.get(i);
      }
      i += 2;
    }
    return null;
  }
  
  public final StringBuilder a(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append('[');
    int i = 0;
    if (i < d.size())
    {
      if (i > 0) {
        paramStringBuilder.append(',');
      }
      axp localaxp = a(i);
      if (localaxp.a()) {
        b(i).a(paramStringBuilder);
      }
      for (;;)
      {
        i += 1;
        break;
        if (localaxp.b()) {
          paramStringBuilder.append(c(i).e());
        }
      }
    }
    paramStringBuilder.append(']');
    return paramStringBuilder;
  }
  
  void a(axp paramaxp)
  {
    if (paramaxp == null) {
      throw new RuntimeException("Can't add null");
    }
    d.add(paramaxp);
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final boolean a(int paramInt, String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    if (!paramBoolean) {
      paramBoolean = c(paramInt).a(paramString);
    }
    Object localObject;
    do
    {
      do
      {
        return paramBoolean;
        localObject = c(paramInt);
        paramBoolean = bool;
      } while (paramString == null);
      localObject = ((axy)localObject).e();
      paramBoolean = bool;
    } while (((String)localObject).length() < paramString.length());
    return ((String)localObject).substring(0, paramString.length()).equalsIgnoreCase(paramString);
  }
  
  public final boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < d.size())
      {
        if (c(i).a(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final axr b(int paramInt)
  {
    axp localaxp = a(paramInt);
    if (localaxp.a()) {
      return (axr)localaxp;
    }
    return c;
  }
  
  public final axy b(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString, paramBoolean);
    if (paramString != null) {
      return (axy)paramString;
    }
    return axy.d;
  }
  
  public final boolean b()
  {
    return false;
  }
  
  public final axy c(int paramInt)
  {
    axp localaxp = a(paramInt);
    if (localaxp.b()) {
      return (axy)localaxp;
    }
    return axy.d;
  }
  
  public void c()
  {
    if (d != null)
    {
      Iterator localIterator = d.iterator();
      while (localIterator.hasNext()) {
        ((axp)localIterator.next()).c();
      }
      d = null;
    }
    super.c();
  }
  
  public final boolean e()
  {
    return d.size() == 0;
  }
  
  public String toString()
  {
    return d.toString();
  }
}

/* Location:
 * Qualified Name:     axr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */