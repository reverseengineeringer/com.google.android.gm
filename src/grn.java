import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class grn
  extends gua
{
  @gug(a="Accept")
  private List<String> accept;
  @gug(a="Accept-Encoding")
  List<String> acceptEncoding = new ArrayList(Collections.singleton("gzip"));
  @gug(a="Age")
  private List<Long> age;
  @gug(a="WWW-Authenticate")
  private List<String> authenticate;
  @gug(a="Authorization")
  private List<String> authorization;
  @gug(a="Cache-Control")
  private List<String> cacheControl;
  @gug(a="Content-Encoding")
  private List<String> contentEncoding;
  @gug(a="Content-Length")
  private List<Long> contentLength;
  @gug(a="Content-MD5")
  private List<String> contentMD5;
  @gug(a="Content-Range")
  private List<String> contentRange;
  @gug(a="Content-Type")
  List<String> contentType;
  @gug(a="Cookie")
  private List<String> cookie;
  @gug(a="Date")
  private List<String> date;
  @gug(a="ETag")
  private List<String> etag;
  @gug(a="Expires")
  private List<String> expires;
  @gug(a="If-Match")
  private List<String> ifMatch;
  @gug(a="If-Modified-Since")
  List<String> ifModifiedSince;
  @gug(a="If-None-Match")
  List<String> ifNoneMatch;
  @gug(a="If-Range")
  List<String> ifRange;
  @gug(a="If-Unmodified-Since")
  List<String> ifUnmodifiedSince;
  @gug(a="Last-Modified")
  private List<String> lastModified;
  @gug(a="Location")
  private List<String> location;
  @gug(a="MIME-Version")
  private List<String> mimeVersion;
  @gug(a="Range")
  public List<String> range;
  @gug(a="Retry-After")
  private List<String> retryAfter;
  @gug(a="User-Agent")
  List<String> userAgent;
  
  public grn()
  {
    super(EnumSet.of(gud.a));
  }
  
  private static Object a(Type paramType, List<Type> paramList, String paramString)
  {
    return gtt.a(gtt.a(paramList, paramType), paramString);
  }
  
  public static <T> T a(List<T> paramList)
  {
    if (paramList == null) {
      return null;
    }
    return (T)paramList.get(0);
  }
  
  static <T> List<T> a(T paramT)
  {
    if (paramT == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramT);
    return localArrayList;
  }
  
  public static void a(grn paramgrn, Writer paramWriter)
  {
    a(paramgrn, null, null, null, null, paramWriter);
  }
  
  static void a(grn paramgrn, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, Logger paramLogger, gsd paramgsd)
  {
    a(paramgrn, paramStringBuilder1, paramStringBuilder2, paramLogger, paramgsd, null);
  }
  
  private static void a(grn paramgrn, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, Logger paramLogger, gsd paramgsd, Writer paramWriter)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramgrn.entrySet().iterator();
    Object localObject1;
    String str;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      str = (String)((Map.Entry)localObject1).getKey();
      if (!localHashSet.add(str)) {
        throw new IllegalArgumentException(hbe.a("multiple headers of the same name (headers are case insensitive): %s", new Object[] { str }));
      }
      localObject1 = ((Map.Entry)localObject1).getValue();
      if (localObject1 != null)
      {
        localObject2 = c.a(str);
        if (localObject2 == null) {
          break label218;
        }
        str = c;
      }
    }
    label218:
    for (;;)
    {
      localObject2 = localObject1.getClass();
      if (((localObject1 instanceof Iterable)) || (((Class)localObject2).isArray()))
      {
        localObject1 = gus.a(localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          a(paramLogger, paramStringBuilder1, paramStringBuilder2, paramgsd, str, ((Iterator)localObject1).next(), paramWriter);
        }
        break;
      }
      a(paramLogger, paramStringBuilder1, paramStringBuilder2, paramgsd, str, localObject1, paramWriter);
      break;
      if (paramWriter != null) {
        paramWriter.flush();
      }
      return;
    }
  }
  
  private static void a(Logger paramLogger, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, gsd paramgsd, String paramString, Object paramObject, Writer paramWriter)
  {
    if ((paramObject == null) || (gtt.a(paramObject))) {
      return;
    }
    if ((paramObject instanceof Enum))
    {
      paramObject = ac;
      label35:
      if (((!"Authorization".equalsIgnoreCase(paramString)) && (!"Cookie".equalsIgnoreCase(paramString))) || ((paramLogger != null) && (paramLogger.isLoggable(Level.ALL)))) {
        break label189;
      }
    }
    label189:
    for (paramLogger = "<Not Logged>";; paramLogger = (Logger)paramObject)
    {
      if (paramStringBuilder1 != null)
      {
        paramStringBuilder1.append(paramString).append(": ");
        paramStringBuilder1.append(paramLogger);
        paramStringBuilder1.append(gur.a);
      }
      if (paramStringBuilder2 != null) {
        paramStringBuilder2.append(" -H '").append(paramString).append(": ").append(paramLogger).append("'");
      }
      if (paramgsd != null) {
        paramgsd.a(paramString, (String)paramObject);
      }
      if (paramWriter == null) {
        break;
      }
      paramWriter.write(paramString);
      paramWriter.write(": ");
      paramWriter.write((String)paramObject);
      paramWriter.write("\r\n");
      return;
      paramObject = paramObject.toString();
      break label35;
    }
  }
  
  public final grn a(Long paramLong)
  {
    contentLength = a(paramLong);
    return this;
  }
  
  public final grn a(String paramString)
  {
    authorization = a(paramString);
    return this;
  }
  
  public final grn a(String paramString, Object paramObject)
  {
    return (grn)super.b(paramString, paramObject);
  }
  
  public final String a()
  {
    return (String)a(location);
  }
  
  public final void a(grn paramgrn)
  {
    try
    {
      grp localgrp = new grp(this, null);
      a(paramgrn, null, null, null, new gro(this, localgrp));
      a.a();
      return;
    }
    catch (IOException paramgrn)
    {
      throw hbx.a(paramgrn);
    }
  }
  
  public final void a(gse paramgse, StringBuilder paramStringBuilder)
  {
    clear();
    paramStringBuilder = new grp(this, paramStringBuilder);
    int j = paramgse.g();
    int i = 0;
    while (i < j)
    {
      a(paramgse.a(i), paramgse.b(i), paramStringBuilder);
      i += 1;
    }
    a.a();
  }
  
  final void a(String paramString1, String paramString2, grp paramgrp)
  {
    Object localObject1 = d;
    Object localObject2 = c;
    gti localgti = a;
    paramgrp = b;
    if (paramgrp != null) {
      paramgrp.append(String.valueOf(paramString1).length() + 2 + String.valueOf(paramString2).length() + paramString1 + ": " + paramString2).append(gur.a);
    }
    localObject2 = ((gtr)localObject2).a(paramString1);
    if (localObject2 != null)
    {
      Type localType = gtt.a((List)localObject1, b.getGenericType());
      if (gus.a(localType))
      {
        paramString1 = gus.a((List)localObject1, gus.b(localType));
        localgti.a(b, paramString1, a(paramString1, (List)localObject1, paramString2));
        return;
      }
      if (gus.a(gus.a((List)localObject1, localType), Iterable.class))
      {
        paramgrp = (Collection)((gtz)localObject2).a(this);
        paramString1 = paramgrp;
        if (paramgrp == null)
        {
          paramString1 = gtt.b(localType);
          ((gtz)localObject2).a(this, paramString1);
        }
        if (localType == Object.class) {}
        for (paramgrp = null;; paramgrp = gus.a(localType, Iterable.class, 0))
        {
          paramString1.add(a(paramgrp, (List)localObject1, paramString2));
          return;
        }
      }
      ((gtz)localObject2).a(this, a(localType, (List)localObject1, paramString2));
      return;
    }
    localObject1 = (ArrayList)get(paramString1);
    paramgrp = (grp)localObject1;
    if (localObject1 == null)
    {
      paramgrp = new ArrayList();
      a(paramString1, paramgrp);
    }
    paramgrp.add(paramString2);
  }
  
  public final grn b(String paramString)
  {
    contentEncoding = a(paramString);
    return this;
  }
  
  public final grn c(String paramString)
  {
    contentRange = a(paramString);
    return this;
  }
  
  public final grn d(String paramString)
  {
    contentType = a(paramString);
    return this;
  }
  
  public final grn e(String paramString)
  {
    ifMatch = a(paramString);
    return this;
  }
  
  public final grn f(String paramString)
  {
    userAgent = a(paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     grn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */