import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class gsk
  implements gum
{
  public static final String a;
  
  static
  {
    grr localgrr = new grr("application/x-www-form-urlencoded");
    Object localObject = gtq.a;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Charset)localObject).name())
    {
      localgrr.a("charset", (String)localObject);
      a = localgrr.a();
      return;
    }
  }
  
  private static Object a(Type paramType, List<Type> paramList, String paramString)
  {
    return gtt.a(gtt.a(paramList, paramType), paramString);
  }
  
  private static void a(Reader paramReader, Object paramObject)
  {
    Object localObject1 = paramObject.getClass();
    gtr localgtr = gtr.a((Class)localObject1);
    List localList = Arrays.asList(new Type[] { localObject1 });
    gua localgua;
    gti localgti;
    Object localObject2;
    Object localObject3;
    int i;
    Object localObject4;
    if (gua.class.isAssignableFrom((Class)localObject1))
    {
      localgua = (gua)paramObject;
      if (!Map.class.isAssignableFrom((Class)localObject1)) {
        break label155;
      }
      localObject1 = (Map)paramObject;
      localgti = new gti(paramObject);
      localObject2 = new StringWriter();
      localObject3 = new StringWriter();
      i = 1;
      localObject4 = localObject2;
      localObject2 = localObject3;
    }
    for (;;)
    {
      int j = paramReader.read();
      switch (j)
      {
      default: 
        if (i != 0)
        {
          ((StringWriter)localObject4).write(j);
          continue;
          localgua = null;
          break;
          localObject1 = null;
        }
        break;
      case -1: 
      case 38: 
        Object localObject5 = guw.a(((StringWriter)localObject4).toString());
        gtz localgtz;
        if (((String)localObject5).length() != 0)
        {
          localObject4 = guw.a(((StringWriter)localObject2).toString());
          localgtz = localgtr.a((String)localObject5);
          if (localgtz == null) {
            break label399;
          }
          localObject5 = gtt.a(localList, b.getGenericType());
          if (!gus.a((Type)localObject5)) {
            break label288;
          }
          localObject2 = gus.a(localList, gus.b((Type)localObject5));
          localgti.a(b, (Class)localObject2, a((Type)localObject2, localList, (String)localObject4));
        }
        while (localObject1 == null) {
          for (;;)
          {
            localObject4 = new StringWriter();
            localObject2 = new StringWriter();
            if (j != -1) {
              break;
            }
            localgti.a();
            return;
            if (gus.a(gus.a(localList, (Type)localObject5), Iterable.class))
            {
              localObject3 = (Collection)localgtz.a(paramObject);
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                localObject2 = gtt.b((Type)localObject5);
                localgtz.a(paramObject, localObject2);
              }
              if (localObject5 == Object.class) {}
              for (localObject3 = null;; localObject3 = gus.a((Type)localObject5, Iterable.class, 0))
              {
                ((Collection)localObject2).add(a((Type)localObject3, localList, (String)localObject4));
                break;
              }
            }
            localgtz.a(paramObject, a((Type)localObject5, localList, (String)localObject4));
          }
        }
        localObject3 = (ArrayList)((Map)localObject1).get(localObject5);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = new ArrayList();
          if (localgua == null) {
            break label462;
          }
          localgua.b((String)localObject5, localObject2);
        }
        for (;;)
        {
          ((ArrayList)localObject2).add(localObject4);
          break;
          ((Map)localObject1).put(localObject5, localObject2);
        }
      case 61: 
        label155:
        label288:
        label399:
        label462:
        i = 0;
        continue;
        ((StringWriter)localObject2).write(j);
        continue;
        i = 1;
      }
    }
  }
  
  public static void a(String paramString, Object paramObject)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      a(new StringReader(paramString), paramObject);
      return;
    }
    catch (IOException paramString)
    {
      throw hbx.a(paramString);
    }
  }
  
  public final <T> T a(InputStream paramInputStream, Charset paramCharset, Class<T> paramClass)
  {
    paramInputStream = new InputStreamReader(paramInputStream, paramCharset);
    hbe.a(paramClass instanceof Class, "dataType has to be of type Class<?>");
    paramCharset = gus.a((Class)paramClass);
    a(new BufferedReader(paramInputStream), paramCharset);
    return paramCharset;
  }
}

/* Location:
 * Qualified Name:     gsk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */