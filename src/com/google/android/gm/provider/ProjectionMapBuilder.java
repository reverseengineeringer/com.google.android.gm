package com.google.android.gm.provider;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ProjectionMapBuilder
{
  private Map<String, String> mMap = new HashMap();
  
  public ProjectionMapBuilder add(String paramString)
  {
    mMap.put(paramString, paramString);
    return this;
  }
  
  public ProjectionMapBuilder add(String paramString1, String paramString2)
  {
    mMap.put(paramString1, paramString2 + " AS " + paramString1);
    return this;
  }
  
  public ProjectionMapBuilder addIdentities(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      add(paramArrayOfString[i]);
      i += 1;
    }
    return this;
  }
  
  public ProjectionMapBuilder addTransformations(String[][] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String[] arrayOfString = paramArrayOfString[i];
      switch (arrayOfString.length)
      {
      default: 
        LogUtils.i("Gmail", "unrecognized projection map entry: %s", new Object[] { Arrays.toString(arrayOfString) });
      }
      for (;;)
      {
        i += 1;
        break;
        add(arrayOfString[0], arrayOfString[1]);
        continue;
        add(arrayOfString[0]);
      }
    }
    return this;
  }
  
  public Map<String, String> getMap()
  {
    return mMap;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.ProjectionMapBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */