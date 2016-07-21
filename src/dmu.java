import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class dmu
{
  public final Map<String, dqg> a;
  public final List<dgi> b;
  public final List<cfi> c;
  public final Map<String, List<cfi>> d;
  public final Map<String, Map<String, List<cfi>>> e;
  
  public dmu(Map<String, dqg> paramMap, List<dgi> paramList, List<cfi> paramList1, Map<String, List<cfi>> paramMap1, Map<String, Map<String, List<cfi>>> paramMap2)
  {
    a = paramMap;
    b = paramList;
    c = paramList1;
    d = paramMap1;
    e = paramMap2;
  }
  
  public static dmu a(JSONObject paramJSONObject)
  {
    HashMap localHashMap1 = null;
    HashMap localHashMap2 = new HashMap();
    Object localObject1 = paramJSONObject.getJSONObject("sync_settings");
    Object localObject2 = ((JSONObject)localObject1).keys();
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = ((JSONObject)localObject1).getJSONObject((String)localObject3);
      localObject5 = new dqg();
      a = ((JSONObject)localObject4).getLong("conversation_age_days");
      b = ((JSONObject)localObject4).getLong("max_attachment_size_mb");
      c = new HashSet();
      dqg.a((JSONObject)localObject4, "labels_included", c);
      d = new HashSet();
      dqg.a((JSONObject)localObject4, "labels_partial", d);
      localHashMap2.put(localObject3, localObject5);
    }
    Object localObject3 = a(paramJSONObject.getJSONArray("shared_preferences"));
    if (paramJSONObject.has("mail_prefs")) {}
    int i;
    for (localObject1 = paramJSONObject.getJSONArray("mail_prefs");; localObject1 = null)
    {
      localObject4 = b((JSONArray)localObject1);
      if (!paramJSONObject.has("account_prefs")) {
        break;
      }
      localObject5 = paramJSONObject.getJSONArray("account_prefs");
      localObject2 = new HashMap(((JSONArray)localObject5).length());
      i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= ((JSONArray)localObject5).length()) {
          break;
        }
        localObject1 = ((JSONArray)localObject5).getJSONObject(i);
        ((Map)localObject2).put(((JSONObject)localObject1).getString("account_name"), b(((JSONObject)localObject1).getJSONArray("preferences")));
        i += 1;
      }
    }
    localObject1 = null;
    if (paramJSONObject.has("folder_prefs"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("folder_prefs");
      localHashMap1 = new HashMap(paramJSONObject.length());
      i = 0;
      while (i < paramJSONObject.length())
      {
        localObject5 = paramJSONObject.getJSONObject(i);
        localObject2 = ((JSONObject)localObject5).getString("account_name");
        localObject5 = ((JSONObject)localObject5).getJSONArray("folders");
        HashMap localHashMap3 = new HashMap(((JSONArray)localObject5).length());
        int j = 0;
        while (j < ((JSONArray)localObject5).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject5).getJSONObject(j);
          localHashMap3.put(localJSONObject.getString("folder_backup_key"), b(localJSONObject.getJSONArray("preferences")));
          j += 1;
        }
        localHashMap1.put(localObject2, localHashMap3);
        i += 1;
      }
    }
    return new dmu(localHashMap2, (List)localObject3, (List)localObject4, (Map)localObject1, localHashMap1);
  }
  
  private static List<dgi> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      int j = paramJSONArray.length();
      while (i < j)
      {
        localArrayList.add(dgi.a(paramJSONArray.getJSONObject(i)));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static JSONArray a(List<? extends cfi> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put(((cfi)paramList.next()).c());
    }
    return localJSONArray;
  }
  
  private static List<cfi> b(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      int j = paramJSONArray.length();
      while (i < j)
      {
        localArrayList.add(cfq.a(paramJSONArray.getJSONObject(i)));
        i += 1;
      }
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     dmu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */