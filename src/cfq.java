import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cfq
  implements cfi
{
  private final String a;
  private Object b;
  
  public cfq(String paramString, Object paramObject)
  {
    a = paramString;
    b = paramObject;
  }
  
  public static cfi a(JSONObject paramJSONObject)
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
    return new cfq(paramJSONObject.getString("key"), localObject1);
  }
  
  public final String a()
  {
    return a;
  }
  
  public final Object b()
  {
    return b;
  }
  
  public final JSONObject c()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("key", a);
    if ((b instanceof Set))
    {
      Object localObject = (Set)b;
      JSONArray localJSONArray = new JSONArray();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localJSONArray.put(((Iterator)localObject).next());
      }
      localJSONObject.put("value", localJSONArray);
      return localJSONObject;
    }
    localJSONObject.put("value", b);
    return localJSONObject;
  }
  
  public final String toString()
  {
    String str1 = a;
    String str2 = String.valueOf(b);
    return String.valueOf(str1).length() + 40 + String.valueOf(str2).length() + "BackupSharedPreference{mKey='" + str1 + "', mValue=" + str2 + "}";
  }
}

/* Location:
 * Qualified Name:     cfq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */