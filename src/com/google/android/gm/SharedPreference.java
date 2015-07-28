package com.google.android.gm;

import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SharedPreference
  implements Serializable
{
  static final long serialVersionUID = 1L;
  private String mAccount;
  private String mKey;
  private Object mValue;
  
  public SharedPreference(String paramString1, String paramString2, Object paramObject)
  {
    mKey = paramString1;
    mAccount = paramString2;
    mValue = paramObject;
  }
  
  public static SharedPreference fromJson(JSONObject paramJSONObject)
    throws JSONException
  {
    Object localObject2 = paramJSONObject.get("value");
    Object localObject1 = localObject2;
    if ((localObject2 instanceof JSONArray))
    {
      localObject1 = Sets.newHashSet();
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
      return new SharedPreference(paramJSONObject.getString("key"), (String)localObject2, localObject1);
    }
  }
  
  public String getAccount()
  {
    return mAccount;
  }
  
  public String getKey()
  {
    return mKey;
  }
  
  public Object getValue()
  {
    return mValue;
  }
  
  public JSONObject toJson()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("account", mAccount);
    localJSONObject.put("key", mKey);
    if ((mValue instanceof Set))
    {
      Object localObject = (Set)mValue;
      JSONArray localJSONArray = new JSONArray();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localJSONArray.put(((Iterator)localObject).next());
      }
      localJSONObject.put("value", localJSONArray);
      return localJSONObject;
    }
    localJSONObject.put("value", mValue);
    return localJSONObject;
  }
  
  public String toString()
  {
    return "BackupPreference{mAccount='" + mAccount + '\'' + ", mKey='" + mKey + '\'' + ", mValue=" + mValue + '}';
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.SharedPreference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */