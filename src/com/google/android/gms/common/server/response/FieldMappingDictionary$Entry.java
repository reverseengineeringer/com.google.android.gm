package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import eol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FieldMappingDictionary$Entry
  implements SafeParcelable
{
  public static final eol CREATOR = new eol();
  final int a;
  final String b;
  final ArrayList<FieldMappingDictionary.FieldMapPair> c;
  
  public FieldMappingDictionary$Entry(int paramInt, String paramString, ArrayList<FieldMappingDictionary.FieldMapPair> paramArrayList)
  {
    a = paramInt;
    b = paramString;
    c = paramArrayList;
  }
  
  FieldMappingDictionary$Entry(String paramString, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
  {
    a = 1;
    b = paramString;
    c = a(paramMap);
  }
  
  private static ArrayList<FieldMappingDictionary.FieldMapPair> a(Map<String, FastJsonResponse.Field<?, ?>> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new FieldMappingDictionary.FieldMapPair(str, (FastJsonResponse.Field)paramMap.get(str)));
    }
    return localArrayList;
  }
  
  final HashMap<String, FastJsonResponse.Field<?, ?>> a()
  {
    HashMap localHashMap = new HashMap();
    int j = c.size();
    int i = 0;
    while (i < j)
    {
      FieldMappingDictionary.FieldMapPair localFieldMapPair = (FieldMappingDictionary.FieldMapPair)c.get(i);
      localHashMap.put(b, c);
      i += 1;
    }
    return localHashMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.b(paramParcel, 3, c, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.response.FieldMappingDictionary.Entry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */