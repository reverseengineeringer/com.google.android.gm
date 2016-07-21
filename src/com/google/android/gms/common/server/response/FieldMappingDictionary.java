package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enz;
import eok;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FieldMappingDictionary
  implements SafeParcelable
{
  public static final eok CREATOR = new eok();
  final int a;
  final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> b;
  final String c;
  private final ArrayList<FieldMappingDictionary.Entry> d;
  
  public FieldMappingDictionary(int paramInt, ArrayList<FieldMappingDictionary.Entry> paramArrayList, String paramString)
  {
    a = paramInt;
    d = null;
    b = a(paramArrayList);
    c = ((String)enz.a(paramString));
    a();
  }
  
  private static HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> a(ArrayList<FieldMappingDictionary.Entry> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      FieldMappingDictionary.Entry localEntry = (FieldMappingDictionary.Entry)paramArrayList.get(i);
      localHashMap.put(b, localEntry.a());
      i += 1;
    }
    return localHashMap;
  }
  
  private final void a()
  {
    Iterator localIterator1 = b.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (Map)b.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        getnextj = this;
      }
    }
  }
  
  public final Map<String, FastJsonResponse.Field<?, ?>> a(String paramString)
  {
    return (Map)b.get(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = b.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject).append(":\n");
      localObject = (Map)b.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        localStringBuilder.append("  ").append(str).append(": ");
        localStringBuilder.append(((Map)localObject).get(str));
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new FieldMappingDictionary.Entry(str, (Map)b.get(str)));
    }
    emj.b(paramParcel, 2, localArrayList, false);
    emj.a(paramParcel, 3, c, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.response.FieldMappingDictionary
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */