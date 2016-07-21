import java.util.HashMap;
import java.util.Map;

public class idt
{
  private static idy d = new idy();
  String a = "text/plain";
  String b = null;
  public String c = "7bit";
  private String e = "us-ascii";
  private Map<String, String> f = new HashMap();
  private boolean g = false;
  private boolean h = false;
  
  public idt()
  {
    this(null);
  }
  
  public idt(idt paramidt)
  {
    if ((paramidt != null) && (a.equals("multipart/digest".toLowerCase())))
    {
      a = "message/rfc822";
      return;
    }
    a = "text/plain";
  }
  
  private static Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Object localObject2;
    Object localObject1;
    int i;
    int i2;
    int i1;
    label75:
    char c1;
    int m;
    Object localObject3;
    int k;
    int n;
    int j;
    if (paramString.indexOf(";") == -1)
    {
      localObject2 = null;
      localObject1 = paramString;
      paramString = (String)localObject2;
      localHashMap.put("", localObject1);
      if (paramString == null) {
        break label811;
      }
      char[] arrayOfChar = paramString.toCharArray();
      paramString = new StringBuffer();
      localObject1 = new StringBuffer();
      i = 0;
      i2 = 0;
      i1 = 0;
      if (i1 >= arrayOfChar.length) {
        break label780;
      }
      c1 = arrayOfChar[i1];
      m = i;
      localObject3 = localObject1;
      localObject2 = paramString;
      k = i;
      n = i;
      switch (i)
      {
      default: 
        localObject2 = paramString;
        localObject3 = localObject1;
        j = i2;
      }
    }
    for (;;)
    {
      label182:
      i1 += 1;
      i2 = j;
      localObject1 = localObject3;
      paramString = (String)localObject2;
      break label75;
      localObject1 = paramString.substring(0, paramString.indexOf(";"));
      paramString = paramString.substring(((String)localObject1).length() + 1);
      break;
      j = i2;
      localObject3 = localObject1;
      localObject2 = paramString;
      if (c1 == ';')
      {
        i = 0;
        j = i2;
        localObject3 = localObject1;
        localObject2 = paramString;
        continue;
        if (c1 == '=')
        {
          idy.b("Expected header param name, got '='");
          i = 99;
          j = i2;
          localObject3 = localObject1;
          localObject2 = paramString;
        }
        else
        {
          localObject2 = new StringBuffer();
          localObject3 = new StringBuffer();
          m = 1;
          if (c1 == '=')
          {
            if (((StringBuffer)localObject2).length() == 0)
            {
              i = 99;
              j = i2;
            }
            else
            {
              i = 2;
              j = i2;
            }
          }
          else
          {
            ((StringBuffer)localObject2).append(c1);
            j = i2;
            i = m;
            continue;
            switch (c1)
            {
            default: 
              m = 1;
              k = 3;
              j = i2;
              i = k;
              localObject3 = localObject1;
              localObject2 = paramString;
              if (m != 0) {
                switch (c1)
                {
                default: 
                  ((StringBuffer)localObject1).append(c1);
                  m = 0;
                }
              }
              break;
            case '\t': 
            case ' ': 
            case '"': 
              for (;;)
              {
                label398:
                j = i2;
                i = k;
                localObject3 = localObject1;
                localObject2 = paramString;
                if (m == 0) {
                  break;
                }
                n = k;
                j = i2;
                i = n;
                localObject3 = localObject1;
                localObject2 = paramString;
                switch (c1)
                {
                case '\t': 
                case ' ': 
                default: 
                  i = 99;
                  j = i2;
                  localObject3 = localObject1;
                  localObject2 = paramString;
                  break label182;
                  m = 0;
                  k = i;
                  break label398;
                  k = 4;
                  m = 0;
                  break label398;
                  localHashMap.put(paramString.toString().trim().toLowerCase(), ((StringBuffer)localObject1).toString().trim());
                  m = 1;
                  k = 5;
                }
              }
              i = 0;
              j = i2;
              localObject3 = localObject1;
              localObject2 = paramString;
              continue;
              switch (c1)
              {
              default: 
                if (i2 != 0) {
                  ((StringBuffer)localObject1).append('\\');
                }
                ((StringBuffer)localObject1).append(c1);
                j = 0;
                localObject3 = localObject1;
                localObject2 = paramString;
                break;
              case '"': 
                if (i2 == 0)
                {
                  localHashMap.put(paramString.toString().trim().toLowerCase(), ((StringBuffer)localObject1).toString());
                  i = 5;
                  j = i2;
                  localObject3 = localObject1;
                  localObject2 = paramString;
                }
                else
                {
                  ((StringBuffer)localObject1).append(c1);
                  j = 0;
                  localObject3 = localObject1;
                  localObject2 = paramString;
                }
                break;
              case '\\': 
                if (i2 != 0) {
                  ((StringBuffer)localObject1).append('\\');
                }
                if (i2 == 0)
                {
                  j = 1;
                  localObject3 = localObject1;
                  localObject2 = paramString;
                }
                else
                {
                  j = 0;
                  localObject3 = localObject1;
                  localObject2 = paramString;
                }
                break;
              }
              break;
            }
          }
        }
      }
    }
    label780:
    if (i == 3) {
      localHashMap.put(paramString.toString().trim().toLowerCase(), ((StringBuffer)localObject1).toString().trim());
    }
    label811:
    return localHashMap;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    int j = 0;
    paramString1 = paramString1.trim().toLowerCase();
    if ((paramString1.equals("content-transfer-encoding")) && (!h))
    {
      h = true;
      paramString1 = paramString2.trim().toLowerCase();
      if (paramString1.length() > 0) {
        c = paramString1;
      }
    }
    while ((!paramString1.equals("content-type")) || (g)) {
      return;
    }
    g = true;
    paramString1 = paramString2.trim();
    paramString2 = new StringBuffer();
    int i = 0;
    while (i < paramString1.length())
    {
      char c1 = paramString1.charAt(i);
      if ((c1 != '\r') && (c1 != '\n')) {
        paramString2.append(c1);
      }
      i += 1;
    }
    Map localMap = a(paramString2.toString());
    paramString2 = (String)localMap.get("");
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString2 = paramString2.toLowerCase().trim();
      int k = paramString2.indexOf('/');
      paramString1 = paramString2;
      i = j;
      if (k != -1)
      {
        String str1 = paramString2.substring(0, k).trim();
        String str2 = paramString2.substring(k + 1).trim();
        paramString1 = paramString2;
        i = j;
        if (str1.length() > 0)
        {
          paramString1 = paramString2;
          i = j;
          if (str2.length() > 0)
          {
            paramString1 = String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + "/" + str2;
            i = 1;
          }
        }
      }
      if (i == 0) {
        paramString1 = null;
      }
    }
    for (;;)
    {
      paramString2 = (String)localMap.get("boundary");
      if ((paramString1 != null) && (((paramString1.startsWith("multipart/")) && (paramString2 != null)) || (!paramString1.startsWith("multipart/")))) {
        a = paramString1;
      }
      if (a()) {
        b = paramString2;
      }
      paramString1 = (String)localMap.get("charset");
      if (paramString1 != null)
      {
        paramString1 = paramString1.trim();
        if (paramString1.length() > 0) {
          e = paramString1.toLowerCase();
        }
      }
      f.putAll(localMap);
      f.remove("");
      f.remove("boundary");
      f.remove("charset");
      return;
    }
  }
  
  public final boolean a()
  {
    return a.startsWith("multipart/");
  }
  
  public String toString()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     idt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */