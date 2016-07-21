import android.content.ContentResolver;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ddx
{
  public static final ddx a = new ddx();
  public List<ddt> b = new ArrayList();
  private ddw c = new ddw(new ddt[0]);
  private Object d;
  
  public final ddw a(ContentResolver paramContentResolver)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = ghz.a(paramContentResolver);
        if (localObject1 == d)
        {
          if (Log.isLoggable("UrlRules", 2))
          {
            paramContentResolver = String.valueOf(localObject1);
            new StringBuilder(String.valueOf(paramContentResolver).length() + 34).append("Using cached rules, versionToken: ").append(paramContentResolver);
          }
          paramContentResolver = c;
          return paramContentResolver;
        }
        Object localObject2 = ghz.a(paramContentResolver, new String[] { "url:" });
        paramContentResolver = new ArrayList();
        paramContentResolver.addAll(b);
        localObject2 = ((Map)localObject2).entrySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
          try
          {
            String str = ((String)((Map.Entry)localObject3).getKey()).substring(4);
            localObject3 = (String)((Map.Entry)localObject3).getValue();
            if ((localObject3 == null) || (((String)localObject3).length() == 0)) {
              continue;
            }
            if (Log.isLoggable("UrlRules", 2)) {
              new StringBuilder(String.valueOf(str).length() + 9 + String.valueOf(localObject3).length()).append("  Rule ").append(str).append(": ").append((String)localObject3);
            }
            paramContentResolver.add(ddt.a(str, (String)localObject3));
          }
          catch (ddu localddu)
          {
            Log.e("UrlRules", "Invalid rule from Gservices", localddu);
          }
          continue;
        }
        c = new ddw((ddt[])paramContentResolver.toArray(new ddt[paramContentResolver.size()]));
      }
      finally {}
      d = localObject1;
      if (Log.isLoggable("UrlRules", 2))
      {
        paramContentResolver = String.valueOf(localObject1);
        new StringBuilder(String.valueOf(paramContentResolver).length() + 32).append("New rules stored, versionToken: ").append(paramContentResolver);
      }
      paramContentResolver = c;
    }
  }
}

/* Location:
 * Qualified Name:     ddx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */