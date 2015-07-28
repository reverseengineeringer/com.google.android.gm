package com.google.android.gm.persistence;

import com.google.android.gm.SharedPreference;
import com.google.android.gm.provider.Gmail.Settings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GmailBackupData
{
  private final List<SharedPreference> sharedPreferences;
  private final Map<String, Gmail.Settings> syncSettings;
  
  public GmailBackupData(Map<String, Gmail.Settings> paramMap, List<SharedPreference> paramList)
  {
    syncSettings = paramMap;
    sharedPreferences = paramList;
  }
  
  public static GmailBackupData fromJson(JSONObject paramJSONObject)
    throws JSONException
  {
    HashMap localHashMap = Maps.newHashMap();
    Object localObject = paramJSONObject.getJSONObject("sync_settings");
    Iterator localIterator = ((JSONObject)localObject).keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, Gmail.Settings.fromJson(((JSONObject)localObject).getJSONObject(str)));
    }
    localObject = Lists.newArrayList();
    paramJSONObject = paramJSONObject.getJSONArray("shared_preferences");
    int i = 0;
    int j = paramJSONObject.length();
    while (i < j)
    {
      ((List)localObject).add(SharedPreference.fromJson(paramJSONObject.getJSONObject(i)));
      i += 1;
    }
    return new GmailBackupData(localHashMap, (List)localObject);
  }
  
  public List<SharedPreference> getSharedPreferences()
  {
    return sharedPreferences;
  }
  
  public Map<String, Gmail.Settings> getSyncSettings()
  {
    return syncSettings;
  }
  
  public JSONObject toJson()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = new JSONObject();
    localJSONObject.put("sync_settings", localObject);
    Iterator localIterator = syncSettings.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((JSONObject)localObject).put((String)localEntry.getKey(), ((Gmail.Settings)localEntry.getValue()).toJson());
    }
    localObject = new JSONArray();
    localJSONObject.put("shared_preferences", localObject);
    localIterator = sharedPreferences.iterator();
    while (localIterator.hasNext()) {
      ((JSONArray)localObject).put(((SharedPreference)localIterator.next()).toJson());
    }
    return localJSONObject;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.persistence.GmailBackupData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */