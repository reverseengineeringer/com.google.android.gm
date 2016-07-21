import java.util.List;

final class bre
{
  Object[] a;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  
  private bre(String[] paramArrayOfString)
  {
    a = new Object[paramArrayOfString.length];
    int m = 0;
    if (m < paramArrayOfString.length)
    {
      String str = paramArrayOfString[m];
      if (("display_name".equals(str)) || ("display_name".equals(str))) {
        d = m;
      }
      for (;;)
      {
        m += 1;
        break;
        if ("display_name_alt".equals(str))
        {
          f = m;
        }
        else if ("display_name_source".equals(str))
        {
          e = m;
        }
        else if ("has_phone_number".equals(str))
        {
          k = m;
        }
        else if ("_id".equals(str))
        {
          b = m;
        }
        else if ("contact_id".equals(str))
        {
          c = m;
        }
        else if ("lookup".equals(str))
        {
          l = m;
        }
        else
        {
          if ("data1".equals(str)) {
            i = m;
          }
          if ("data2".equals(str)) {
            j = m;
          }
          if ("data1".equals(str)) {
            g = m;
          }
          if ("data2".equals(str)) {
            h = m;
          }
        }
      }
    }
  }
  
  static bre a(brb parambrb, String[] paramArrayOfString)
  {
    paramArrayOfString = new bre(paramArrayOfString);
    Object localObject = c;
    if (d != -1) {
      a[d] = localObject;
    }
    localObject = b;
    if (e != -1) {
      a[e] = localObject;
    }
    localObject = d;
    if (f != -1) {
      a[f] = localObject;
    }
    if (h.size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (k != -1) {
        a[k] = Boolean.valueOf(bool);
      }
      parambrb = i;
      if (l != -1) {
        a[l] = parambrb;
      }
      return paramArrayOfString;
    }
  }
  
  final void a()
  {
    if (h != -1) {
      a[h] = Integer.valueOf(2);
    }
  }
  
  final void a(int paramInt)
  {
    if (j != -1) {
      a[j] = Integer.valueOf(paramInt);
    }
  }
  
  final void a(long paramLong)
  {
    if (b != -1) {
      a[b] = Long.valueOf(paramLong);
    }
  }
  
  final void a(String paramString)
  {
    if (g != -1) {
      a[g] = paramString;
    }
  }
  
  final void b(long paramLong)
  {
    if (c != -1) {
      a[c] = Long.valueOf(paramLong);
    }
  }
  
  final void b(String paramString)
  {
    if (i != -1) {
      a[i] = paramString;
    }
  }
}

/* Location:
 * Qualified Name:     bre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */