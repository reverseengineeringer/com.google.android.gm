package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import emj;
import ftx;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class DefaultPersonImpl$Organizations
  extends FastJsonResponse
  implements SafeParcelable
{
  public static final ftx CREATOR = new ftx();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> p;
  final Set<Integer> a;
  final int b;
  boolean c;
  String d;
  String e;
  String f;
  String g;
  String h;
  DefaultMetadataImpl i;
  String j;
  String k;
  String l;
  String m;
  String n;
  String o;
  
  static
  {
    HashMap localHashMap = new HashMap();
    p = localHashMap;
    localHashMap.put("current", FastJsonResponse.Field.c("current", 2));
    p.put("department", FastJsonResponse.Field.d("department", 3));
    p.put("description", FastJsonResponse.Field.d("description", 4));
    p.put("domain", FastJsonResponse.Field.d("domain", 5));
    p.put("endDate", FastJsonResponse.Field.d("endDate", 6));
    p.put("location", FastJsonResponse.Field.d("location", 7));
    p.put("metadata", FastJsonResponse.Field.a("metadata", 8, DefaultMetadataImpl.class));
    p.put("name", FastJsonResponse.Field.d("name", 9));
    p.put("phoneticName", FastJsonResponse.Field.d("phoneticName", 10));
    p.put("startDate", FastJsonResponse.Field.d("startDate", 11));
    p.put("symbol", FastJsonResponse.Field.d("symbol", 12));
    p.put("title", FastJsonResponse.Field.d("title", 13));
    p.put("type", FastJsonResponse.Field.d("type", 14));
  }
  
  public DefaultPersonImpl$Organizations()
  {
    b = 1;
    a = new HashSet();
  }
  
  public DefaultPersonImpl$Organizations(Set<Integer> paramSet, int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DefaultMetadataImpl paramDefaultMetadataImpl, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    a = paramSet;
    b = paramInt;
    c = paramBoolean;
    d = paramString1;
    e = paramString2;
    f = paramString3;
    g = paramString4;
    h = paramString5;
    i = paramDefaultMetadataImpl;
    j = paramString6;
    k = paramString7;
    l = paramString8;
    m = paramString9;
    n = paramString10;
    o = paramString11;
  }
  
  protected final boolean a(FastJsonResponse.Field paramField)
  {
    return a.contains(Integer.valueOf(g));
  }
  
  protected final Object b()
  {
    return null;
  }
  
  protected final Object b(FastJsonResponse.Field paramField)
  {
    switch (g)
    {
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + g);
    case 2: 
      return Boolean.valueOf(c);
    case 3: 
      return d;
    case 4: 
      return e;
    case 5: 
      return f;
    case 6: 
      return g;
    case 7: 
      return h;
    case 8: 
      return i;
    case 9: 
      return j;
    case 10: 
      return k;
    case 11: 
      return l;
    case 12: 
      return m;
    case 13: 
      return n;
    }
    return o;
  }
  
  protected final boolean c()
  {
    return false;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Organizations)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (Organizations)paramObject;
    Iterator localIterator = p.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (((Organizations)paramObject).a(localField))
        {
          if (!b(localField).equals(((Organizations)paramObject).b(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((Organizations)paramObject).a(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = p.values().iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (!a(localField)) {
        break label68;
      }
      int i2 = g;
      i1 = b(localField).hashCode() + (i1 + i2);
    }
    label68:
    for (;;)
    {
      break;
      return i1;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = emj.a(paramParcel, 20293);
    Set localSet = a;
    if (localSet.contains(Integer.valueOf(1))) {
      emj.b(paramParcel, 1, b);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      emj.a(paramParcel, 2, c);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, 3, d, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      emj.a(paramParcel, 4, e, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      emj.a(paramParcel, 5, f, true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      emj.a(paramParcel, 6, g, true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      emj.a(paramParcel, 7, h, true);
    }
    if (localSet.contains(Integer.valueOf(8))) {
      emj.a(paramParcel, 8, i, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(9))) {
      emj.a(paramParcel, 9, j, true);
    }
    if (localSet.contains(Integer.valueOf(10))) {
      emj.a(paramParcel, 10, k, true);
    }
    if (localSet.contains(Integer.valueOf(11))) {
      emj.a(paramParcel, 11, l, true);
    }
    if (localSet.contains(Integer.valueOf(12))) {
      emj.a(paramParcel, 12, m, true);
    }
    if (localSet.contains(Integer.valueOf(13))) {
      emj.a(paramParcel, 13, n, true);
    }
    if (localSet.contains(Integer.valueOf(14))) {
      emj.a(paramParcel, 14, o, true);
    }
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Organizations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */