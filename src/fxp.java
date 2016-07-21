import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.google.android.gms.common.data.DataHolder;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public final class fxp
{
  public static final Map<String, Integer> a = new fxq();
  public static Iterable<?> b = new fws();
  public static final Handler c = new Handler(Looper.getMainLooper());
  public static final String[] d = new String[0];
  public static final Pattern e = Pattern.compile("\\,");
  public static final Pattern f = Pattern.compile("[     ᠎             　\t\013\f\034\035\036\037\n\r]+");
  public static final Pattern g = Pattern.compile(Pattern.quote("\001"));
  public static final Pattern h = Pattern.compile(Pattern.quote("\002"));
  public static final String i = "\001";
  public static final String j = "\002";
  public static final SecureRandom k = new SecureRandom();
  private static final ThreadLocal<StringBuilder> l = new fxr();
  private static final ThreadLocal<String[]> m = new fxs();
  private static final ThreadLocal<String[]> n = new fxt();
  private static final ThreadLocal<String[]> o = new fxu();
  private static final ThreadLocal<String[]> p = new fxv();
  private static final ThreadLocal<String[]> q = new fxw();
  
  public static String a(Bundle paramBundle)
  {
    return a(paramBundle, "", new StringBuilder()).toString();
  }
  
  public static String a(String paramString)
  {
    enz.a(paramString);
    return "g:" + paramString;
  }
  
  private static StringBuilder a(Object paramObject, String paramString, StringBuilder paramStringBuilder)
  {
    if (paramObject == null)
    {
      paramStringBuilder.append("[null]\n");
      return paramStringBuilder;
    }
    String str1 = paramString + "  ";
    paramStringBuilder.append("(").append(paramObject.getClass().getSimpleName()).append(") ");
    if ((paramObject instanceof Bundle))
    {
      paramObject = (Bundle)paramObject;
      if (((Bundle)paramObject).isEmpty())
      {
        paramStringBuilder.append("{ }\n");
        return paramStringBuilder;
      }
      paramStringBuilder.append("{\n");
      Iterator localIterator = ((Bundle)paramObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        paramStringBuilder.append(str1).append(str2).append(" : ");
        a(((Bundle)paramObject).get(str2), str1, paramStringBuilder);
      }
      paramStringBuilder.append(paramString).append("}\n");
      return paramStringBuilder;
    }
    if ((paramObject instanceof DataHolder))
    {
      paramString = (DataHolder)paramObject;
      paramStringBuilder.append(" [");
      if (paramString.b()) {
        paramStringBuilder.append("CLOSED");
      }
      for (;;)
      {
        paramStringBuilder.append("] ").append(paramObject).append("\n");
        return paramStringBuilder;
        paramStringBuilder.append(h);
      }
    }
    int i1;
    if ((paramObject instanceof ArrayList))
    {
      paramObject = (ArrayList)paramObject;
      if (((ArrayList)paramObject).isEmpty())
      {
        paramStringBuilder.append("[ ]\n");
        return paramStringBuilder;
      }
      paramStringBuilder.append("[\n");
      i1 = 0;
      while (i1 < ((ArrayList)paramObject).size())
      {
        paramStringBuilder.append(str1).append(i1).append(" : ");
        a(((ArrayList)paramObject).get(i1), str1, paramStringBuilder);
        i1 += 1;
      }
      paramStringBuilder.append(paramString).append("]\n");
      return paramStringBuilder;
    }
    if ((paramObject instanceof byte[]))
    {
      i1 = ((byte[])paramObject).length;
      paramStringBuilder.append(" [").append(i1).append("] ");
      paramString = new byte[Math.min(i1, 56)];
      System.arraycopy(paramObject, 0, paramString, 0, paramString.length);
      paramStringBuilder.append(Base64.encodeToString(paramString, 0));
      return paramStringBuilder;
    }
    if ((paramObject instanceof char[]))
    {
      paramStringBuilder.append("\"").append(new String((char[])paramObject)).append("\"\n");
      return paramStringBuilder;
    }
    if (paramObject.getClass().isArray())
    {
      if (Array.getLength(paramObject) == 0)
      {
        paramStringBuilder.append("[ ]\n");
        return paramStringBuilder;
      }
      paramStringBuilder.append("[ ");
      paramStringBuilder.append(Array.get(paramObject, 0));
      i1 = 1;
      while (i1 < Array.getLength(paramObject))
      {
        paramStringBuilder.append(", ").append(Array.get(paramObject, i1));
        i1 += 1;
      }
      paramStringBuilder.append(" ]\n");
      return paramStringBuilder;
    }
    if ((paramObject instanceof String))
    {
      paramStringBuilder.append("\"").append(paramObject).append("\"\n");
      return paramStringBuilder;
    }
    paramStringBuilder.append(paramObject).append("\n");
    return paramStringBuilder;
  }
  
  public static String[] a(String paramString1, String paramString2)
  {
    String[] arrayOfString = (String[])n.get();
    arrayOfString[0] = paramString1;
    arrayOfString[1] = paramString2;
    return arrayOfString;
  }
  
  public static String b(String paramString)
  {
    int i1 = 0;
    while ((i1 < paramString.length()) && (paramString.charAt(i1) == '0')) {
      i1 += 1;
    }
    return paramString.substring(i1);
  }
}

/* Location:
 * Qualified Name:     fxp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */