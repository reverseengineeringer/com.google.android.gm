import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.WeakHashMap;

public final class gtr
{
  private static final Map<Class<?>, gtr> e = new WeakHashMap();
  private static final Map<Class<?>, gtr> f = new WeakHashMap();
  final Class<?> a;
  final boolean b;
  public final IdentityHashMap<String, gtz> c = new IdentityHashMap();
  final List<String> d;
  
  private gtr(Class<?> paramClass, boolean paramBoolean)
  {
    a = paramClass;
    b = paramBoolean;
    boolean bool;
    Object localObject1;
    TreeSet localTreeSet;
    int i;
    label111:
    Field localField;
    gtz localgtz;
    if ((!paramBoolean) || (!paramClass.isEnum()))
    {
      bool = true;
      localObject1 = String.valueOf(paramClass);
      hbe.a(bool, String.valueOf(localObject1).length() + 31 + "cannot ignore case on an enum: " + (String)localObject1);
      localTreeSet = new TreeSet(new gts(this));
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int k = arrayOfField.length;
      i = 0;
      if (i >= k) {
        break label292;
      }
      localField = arrayOfField[i];
      localgtz = gtz.a(localField);
      if (localgtz == null) {
        break label285;
      }
      localObject1 = c;
      if (!paramBoolean) {
        break label431;
      }
      localObject1 = ((String)localObject1).toLowerCase().intern();
    }
    label178:
    label186:
    label248:
    label255:
    label265:
    label285:
    label292:
    label431:
    for (;;)
    {
      Object localObject2 = (gtz)c.get(localObject1);
      int j;
      String str;
      if (localObject2 == null)
      {
        j = 1;
        if (!paramBoolean) {
          break label248;
        }
        str = "case-insensitive ";
        if (localObject2 != null) {
          break label255;
        }
      }
      for (localObject2 = null;; localObject2 = b)
      {
        if (j != 0) {
          break label265;
        }
        throw new IllegalArgumentException(hbe.a("two fields have the same %sname <%s>: %s and %s", new Object[] { str, localObject1, localField, localObject2 }));
        bool = false;
        break;
        j = 0;
        break label178;
        str = "";
        break label186;
      }
      c.put(localObject1, localgtz);
      localTreeSet.add(localObject1);
      i += 1;
      break label111;
      paramClass = paramClass.getSuperclass();
      if (paramClass != null)
      {
        paramClass = a(paramClass, paramBoolean);
        localTreeSet.addAll(d);
        paramClass = c.entrySet().iterator();
        while (paramClass.hasNext())
        {
          localObject1 = (Map.Entry)paramClass.next();
          str = (String)((Map.Entry)localObject1).getKey();
          if (!c.containsKey(str)) {
            c.put(str, (gtz)((Map.Entry)localObject1).getValue());
          }
        }
      }
      if (localTreeSet.isEmpty()) {}
      for (paramClass = Collections.emptyList();; paramClass = Collections.unmodifiableList(new ArrayList(localTreeSet)))
      {
        d = paramClass;
        return;
      }
    }
  }
  
  public static gtr a(Class<?> paramClass)
  {
    return a(paramClass, false);
  }
  
  public static gtr a(Class<?> paramClass, boolean paramBoolean)
  {
    if (paramClass == null) {
      return null;
    }
    if (paramBoolean) {}
    for (;;)
    {
      synchronized (f)
      {
        gtr localgtr2 = (gtr)???.get(paramClass);
        gtr localgtr1 = localgtr2;
        if (localgtr2 == null)
        {
          localgtr1 = new gtr(paramClass, paramBoolean);
          ???.put(paramClass, localgtr1);
        }
        return localgtr1;
      }
      ??? = e;
    }
  }
  
  public final gtz a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (b) {
        str = paramString.toLowerCase();
      }
      str = str.intern();
    }
    return (gtz)c.get(str);
  }
}

/* Location:
 * Qualified Name:     gtr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */