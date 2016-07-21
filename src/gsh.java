import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class gsh
{
  static final Map<Character, gsi> a = new HashMap();
  
  static
  {
    gsi.values();
  }
  
  private static String a(String paramString, Object paramObject, boolean paramBoolean)
  {
    Map localMap = a(paramObject);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int n = paramString.length();
    for (;;)
    {
      int j;
      if (i < n)
      {
        j = paramString.indexOf('{', i);
        if (j == -1) {
          localStringBuilder.append(paramString.substring(i));
        }
      }
      else
      {
        gri.a(localMap.entrySet(), localStringBuilder);
        return localStringBuilder.toString();
      }
      localStringBuilder.append(paramString.substring(i, j));
      int i1 = paramString.indexOf('}', j + 2);
      paramObject = paramString.substring(j + 1, i1);
      gsi localgsi = (gsi)a.get(Character.valueOf(((String)paramObject).charAt(0)));
      label161:
      label211:
      String str;
      Object localObject;
      if (localgsi == null)
      {
        localgsi = gsi.h;
        ListIterator localListIterator = hbo.a(gzx.a(',')).b((CharSequence)paramObject).listIterator();
        i = 1;
        do
        {
          if (!localListIterator.hasNext()) {
            break label541;
          }
          paramObject = (String)localListIterator.next();
          paramBoolean = ((String)paramObject).endsWith("*");
          if ((localListIterator.nextIndex() != 1) || (i == null)) {
            break;
          }
          j = 1;
          int m = ((String)paramObject).length();
          int k = m;
          if (paramBoolean) {
            k = m - 1;
          }
          str = ((String)paramObject).substring(j, k);
          localObject = localMap.remove(str);
        } while (localObject == null);
        if (i != 0) {
          break label313;
        }
        localStringBuilder.append(k);
        label272:
        if (!(localObject instanceof Iterator)) {
          break label329;
        }
        paramObject = a(str, (Iterator)localObject, paramBoolean, localgsi);
      }
      for (;;)
      {
        localStringBuilder.append(paramObject);
        break label161;
        break;
        j = 0;
        break label211;
        label313:
        localStringBuilder.append(j);
        i = 0;
        break label272;
        label329:
        if (((localObject instanceof Iterable)) || (localObject.getClass().isArray()))
        {
          paramObject = a(str, gus.a(localObject).iterator(), paramBoolean, localgsi);
        }
        else if (localObject.getClass().isEnum())
        {
          paramObject = localObject;
          if (ac != null)
          {
            paramObject = localObject;
            if (l) {
              paramObject = String.format("%s=%s", new Object[] { str, localObject });
            }
            paramObject = paramObject.toString();
            paramObject = guw.b.a((String)paramObject);
          }
        }
        else if (!gtt.d(localObject))
        {
          paramObject = a(str, a(localObject), paramBoolean, localgsi);
        }
        else
        {
          paramObject = localObject;
          if (l) {
            paramObject = String.format("%s=%s", new Object[] { str, localObject });
          }
          if (m)
          {
            paramObject = paramObject.toString();
            paramObject = guw.c.a((String)paramObject);
          }
          else
          {
            paramObject = paramObject.toString();
            paramObject = guw.b.a((String)paramObject);
          }
        }
      }
      label541:
      i = i1 + 1;
    }
  }
  
  public static String a(String paramString1, String paramString2, Object paramObject)
  {
    if (paramString2.startsWith("/"))
    {
      paramString1 = new gri(paramString1);
      a = gri.c(null);
      paramString1 = String.valueOf(paramString1.c());
      paramString2 = String.valueOf(paramString2);
      if (paramString2.length() != 0) {}
      for (paramString1 = paramString1.concat(paramString2);; paramString1 = new String(paramString1)) {
        return a(paramString1, paramObject, true);
      }
    }
    String str = paramString2;
    if (!paramString2.startsWith("http://"))
    {
      if (!paramString2.startsWith("https://")) {
        break label98;
      }
      str = paramString2;
    }
    for (;;)
    {
      paramString1 = str;
      break;
      label98:
      paramString1 = String.valueOf(paramString1);
      paramString2 = String.valueOf(paramString2);
      if (paramString2.length() != 0) {
        str = paramString1.concat(paramString2);
      } else {
        str = new String(paramString1);
      }
    }
  }
  
  private static String a(String paramString, Iterator<?> paramIterator, boolean paramBoolean, gsi paramgsi)
  {
    if (!paramIterator.hasNext()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (paramBoolean) {
      localObject = k;
    }
    while (paramIterator.hasNext())
    {
      if ((paramBoolean) && (l))
      {
        localStringBuilder.append(guw.b.a(paramString));
        localStringBuilder.append("=");
      }
      localStringBuilder.append(paramgsi.a(paramIterator.next().toString()));
      if (paramIterator.hasNext())
      {
        localStringBuilder.append((String)localObject);
        continue;
        String str = ",";
        localObject = str;
        if (l)
        {
          localStringBuilder.append(guw.b.a(paramString));
          localStringBuilder.append("=");
          localObject = str;
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString, Map<String, Object> paramMap, boolean paramBoolean, gsi paramgsi)
  {
    if (paramMap.isEmpty()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str1;
    if (paramBoolean)
    {
      str1 = k;
      paramString = "=";
    }
    for (;;)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        String str2 = paramgsi.a((String)((Map.Entry)localObject).getKey());
        localObject = paramgsi.a(((Map.Entry)localObject).getValue().toString());
        localStringBuilder.append(str2);
        localStringBuilder.append(paramString);
        localStringBuilder.append((String)localObject);
        if (paramMap.hasNext()) {
          localStringBuilder.append(str1);
        }
      }
      if (l)
      {
        localStringBuilder.append(guw.b.a(paramString));
        localStringBuilder.append("=");
      }
      paramString = ",";
      str1 = ",";
    }
    return localStringBuilder.toString();
  }
  
  private static Map<String, Object> a(Object paramObject)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramObject = gtt.b(paramObject).entrySet().iterator();
    while (((Iterator)paramObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)paramObject).next();
      Object localObject = localEntry.getValue();
      if ((localObject != null) && (!gtt.a(localObject))) {
        localLinkedHashMap.put((String)localEntry.getKey(), localObject);
      }
    }
    return localLinkedHashMap;
  }
}

/* Location:
 * Qualified Name:     gsh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */