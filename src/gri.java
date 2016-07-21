import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class gri
  extends gua
{
  private static final gux d = new guy("=&-_.!~*'()@:$,;/?:", false);
  List<String> a;
  private String e;
  private String f;
  private String g;
  private int h = -1;
  private String i;
  
  public gri() {}
  
  public gri(String paramString)
  {
    this(d(paramString));
  }
  
  private gri(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    e = paramString1.toLowerCase();
    f = paramString2;
    h = paramInt;
    a = c(paramString3);
    if (paramString4 != null) {}
    for (paramString1 = guw.a(paramString4);; paramString1 = null)
    {
      i = paramString1;
      if (paramString5 != null) {
        gsk.a(paramString5, this);
      }
      paramString1 = (String)localObject;
      if (paramString6 != null) {
        paramString1 = guw.a(paramString6);
      }
      g = paramString1;
      return;
    }
  }
  
  public gri(URL paramURL)
  {
    this(paramURL.getProtocol(), paramURL.getHost(), paramURL.getPort(), paramURL.getPath(), paramURL.getRef(), paramURL.getQuery(), paramURL.getUserInfo());
  }
  
  private final void a(StringBuilder paramStringBuilder)
  {
    int k = a.size();
    int j = 0;
    while (j < k)
    {
      String str = (String)a.get(j);
      if (j != 0) {
        paramStringBuilder.append('/');
      }
      if (str.length() != 0) {
        paramStringBuilder.append(guw.b.a(str));
      }
      j += 1;
    }
  }
  
  static void a(Set<Map.Entry<String, Object>> paramSet, StringBuilder paramStringBuilder)
  {
    paramSet = paramSet.iterator();
    boolean bool = true;
    while (paramSet.hasNext())
    {
      Object localObject2 = (Map.Entry)paramSet.next();
      Object localObject1 = ((Map.Entry)localObject2).getValue();
      if (localObject1 == null) {
        break label122;
      }
      localObject2 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = guw.e.a((String)localObject2);
      if ((localObject1 instanceof Collection))
      {
        localObject1 = ((Collection)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          bool = a(bool, paramStringBuilder, (String)localObject2, ((Iterator)localObject1).next());
        }
      }
      else
      {
        bool = a(bool, paramStringBuilder, (String)localObject2, localObject1);
      }
    }
    label122:
    for (;;)
    {
      break;
      return;
    }
  }
  
  private static boolean a(boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Object paramObject)
  {
    if (paramBoolean)
    {
      paramBoolean = false;
      paramStringBuilder.append('?');
    }
    for (;;)
    {
      paramStringBuilder.append(paramString);
      paramString = paramObject.toString();
      paramString = guw.e.a(paramString);
      if (paramString.length() != 0) {
        paramStringBuilder.append('=').append(paramString);
      }
      return paramBoolean;
      paramStringBuilder.append('&');
    }
  }
  
  public static List<String> c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    int k = 0;
    if (j != 0)
    {
      int m = paramString.indexOf('/', k);
      if (m != -1)
      {
        j = 1;
        label45:
        if (j == 0) {
          break label82;
        }
      }
      label82:
      for (String str = paramString.substring(k, m);; str = paramString.substring(k))
      {
        localArrayList.add(guw.a(str));
        k = m + 1;
        break;
        j = 0;
        break label45;
      }
    }
    return localArrayList;
  }
  
  private static URL d(String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public final gri a()
  {
    gri localgri = (gri)super.b();
    if (a != null) {
      a = new ArrayList(a);
    }
    return localgri;
  }
  
  public final URL a(String paramString)
  {
    try
    {
      paramString = new URL(d(c()), paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public final Object b(String paramString)
  {
    Object localObject = get(paramString);
    paramString = (String)localObject;
    if ((localObject instanceof Collection))
    {
      paramString = ((Collection)localObject).iterator();
      if (paramString.hasNext()) {
        paramString = paramString.next();
      }
    }
    else
    {
      return paramString;
    }
    return null;
  }
  
  public final String c()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)hbe.a(e));
    ((StringBuilder)localObject1).append("://");
    if (g != null)
    {
      localObject2 = g;
      ((StringBuilder)localObject1).append(guw.d.a((String)localObject2)).append('@');
    }
    ((StringBuilder)localObject1).append((String)hbe.a(f));
    int j = h;
    if (j != -1) {
      ((StringBuilder)localObject1).append(':').append(j);
    }
    localObject1 = String.valueOf(((StringBuilder)localObject1).toString());
    Object localObject2 = new StringBuilder();
    if (a != null) {
      a((StringBuilder)localObject2);
    }
    a(entrySet(), (StringBuilder)localObject2);
    String str = i;
    if (str != null) {
      ((StringBuilder)localObject2).append('#').append(d.a(str));
    }
    localObject2 = String.valueOf(((StringBuilder)localObject2).toString());
    if (((String)localObject2).length() != 0) {
      return ((String)localObject1).concat((String)localObject2);
    }
    return new String((String)localObject1);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((!super.equals(paramObject)) || (!(paramObject instanceof gri))) {
      return false;
    }
    paramObject = (gri)paramObject;
    return c().equals(((gri)paramObject).toString());
  }
  
  public final int hashCode()
  {
    return c().hashCode();
  }
  
  public final String toString()
  {
    return c();
  }
}

/* Location:
 * Qualified Name:     gri
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */