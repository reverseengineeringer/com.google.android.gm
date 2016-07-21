import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class dgi
  implements cfi, Serializable
{
  static final long serialVersionUID = 1L;
  public final String a;
  public final String b;
  public final Object c;
  
  public dgi(String paramString1, String paramString2, Object paramObject)
  {
    a = paramString1;
    b = paramString2;
    c = paramObject;
  }
  
  public static dgi a(JSONObject paramJSONObject)
  {
    Object localObject2 = paramJSONObject.get("value");
    Object localObject1 = localObject2;
    if ((localObject2 instanceof JSONArray))
    {
      localObject1 = new HashSet();
      localObject2 = (JSONArray)localObject2;
      int i = 0;
      int j = ((JSONArray)localObject2).length();
      while (i < j)
      {
        ((Set)localObject1).add(((JSONArray)localObject2).get(i));
        i += 1;
      }
    }
    if (paramJSONObject.has("account")) {}
    for (localObject2 = paramJSONObject.getString("account");; localObject2 = null) {
      return new dgi(paramJSONObject.getString("key"), (String)localObject2, localObject1);
    }
  }
  
  public final String a()
  {
    return a;
  }
  
  public final Object b()
  {
    return c;
  }
  
  public final JSONObject c()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("account", b);
    localJSONObject.put("key", a);
    if ((c instanceof Set))
    {
      Object localObject = (Set)c;
      JSONArray localJSONArray = new JSONArray();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localJSONArray.put(((Iterator)localObject).next());
      }
      localJSONObject.put("value", localJSONArray);
      return localJSONObject;
    }
    localJSONObject.put("value", c);
    return localJSONObject;
  }
  
  public final String toString()
  {
    String str1 = b;
    String str2 = a;
    String str3 = String.valueOf(c);
    return String.valueOf(str1).length() + 47 + String.valueOf(str2).length() + String.valueOf(str3).length() + "BackupPreference{mAccount='" + str1 + "', mKey='" + str2 + "', mValue=" + str3 + "}";
  }
}

/* Location:
 * Qualified Name:     dgi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */