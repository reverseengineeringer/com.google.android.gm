import android.content.ContentResolver;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class dmg
{
  private static final String d = cvm.a;
  public final ContentResolver a;
  public final String b;
  public final String c;
  private final dnr e;
  private final gjg f;
  private final String g;
  
  public dmg(ContentResolver paramContentResolver, dnr paramdnr, gjg paramgjg, String paramString1, String paramString2, String paramString3)
  {
    a = paramContentResolver;
    e = paramdnr;
    f = paramgjg;
    g = paramString1;
    b = paramString2;
    c = paramString3;
  }
  
  public static void a(List<String> paramList)
  {
    LinkedHashMap localLinkedHashMap1 = new LinkedHashMap();
    LinkedHashMap localLinkedHashMap2 = new LinkedHashMap();
    Iterator localIterator = paramList.iterator();
    String str1;
    Object localObject;
    while (localIterator.hasNext())
    {
      str1 = (String)localIterator.next();
      int i = str1.indexOf('=');
      if (i >= 0)
      {
        String str2 = str1.substring(0, i);
        str1 = str1.substring(i + 1);
        if (str2.startsWith("r.o-"))
        {
          localObject = str2.substring(4);
          if (localLinkedHashMap1.containsKey(localObject)) {
            break label174;
          }
          localLinkedHashMap1.put(localObject, TextUtils.split(str1, "\\."));
        }
        for (;;)
        {
          if (!str2.startsWith("r.i-")) {
            break label193;
          }
          str2 = str2.substring(4);
          if (localLinkedHashMap2.containsKey(str2)) {
            break label238;
          }
          if (!str1.equals("null")) {
            break label195;
          }
          localLinkedHashMap2.put(str2, null);
          break;
          label174:
          cvm.d(d, "Ordering for question %s already exist", new Object[] { localObject });
        }
        label193:
        continue;
        try
        {
          label195:
          localLinkedHashMap2.put(str2, Integer.valueOf(Integer.parseInt(str1)));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          cvm.d(d, "Unexpected response index: %s", new Object[] { str1 });
        }
        continue;
        label238:
        cvm.d(d, "Response index for question %s already exist", new Object[] { localNumberFormatException });
      }
    }
    localIterator = localLinkedHashMap2.keySet().iterator();
    while (localIterator.hasNext())
    {
      str1 = (String)localIterator.next();
      if (localLinkedHashMap1.containsKey(str1))
      {
        Integer localInteger = (Integer)localLinkedHashMap2.get(str1);
        if (localInteger == null)
        {
          paramList.add(String.format(Locale.ENGLISH, "%s%s=null", new Object[] { "r.r-", str1 }));
        }
        else
        {
          localObject = (String[])localLinkedHashMap1.get(str1);
          if ((localInteger.intValue() < 0) || (localInteger.intValue() >= localObject.length)) {
            cvm.d(d, "Invalid response index %s for ordering %s", new Object[] { localInteger, Arrays.toString((Object[])localObject) });
          } else {
            paramList.add(String.format(Locale.ENGLISH, "%s%s=%s", new Object[] { "r.r-", str1, localObject[localInteger.intValue()] }));
          }
        }
      }
      else
      {
        cvm.d(d, "Question with index %s has response index but not ordering", new Object[] { str1 });
      }
    }
  }
  
  public final void a(String paramString)
  {
    a(paramString, Collections.emptyList());
  }
  
  public final void a(String paramString, List<String> paramList)
  {
    Object localObject = String.valueOf("site=");
    String str1 = String.valueOf(g);
    label69:
    String str3;
    if (str1.length() != 0)
    {
      localObject = ((String)localObject).concat(str1);
      str1 = String.valueOf("survey=");
      str2 = String.valueOf(f.b.d);
      if (str2.length() == 0) {
        break label172;
      }
      str1 = str1.concat(str2);
      str2 = String.valueOf("series=");
      str3 = String.valueOf(f.b.e);
      if (str3.length() == 0) {
        break label186;
      }
    }
    label172:
    label186:
    for (String str2 = str2.concat(str3);; str2 = new String(str2))
    {
      localObject = hgd.a(new String[] { localObject, str1, str2 });
      ((List)localObject).addAll(paramList);
      e.a(new dns(paramString, TextUtils.join("&", (Iterable)localObject)));
      return;
      localObject = new String((String)localObject);
      break;
      str1 = new String(str1);
      break label69;
    }
  }
}

/* Location:
 * Qualified Name:     dmg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */