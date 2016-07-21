package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import emj;
import ftu;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class DefaultPersonImpl$Names
  extends FastJsonResponse
  implements SafeParcelable
{
  public static final ftu CREATOR = new ftu();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> o;
  final Set<Integer> a;
  final int b;
  String c;
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
  
  static
  {
    HashMap localHashMap = new HashMap();
    o = localHashMap;
    localHashMap.put("displayName", FastJsonResponse.Field.d("displayName", 2));
    o.put("familyName", FastJsonResponse.Field.d("familyName", 3));
    o.put("formatted", FastJsonResponse.Field.d("formatted", 4));
    o.put("givenName", FastJsonResponse.Field.d("givenName", 5));
    o.put("honorificPrefix", FastJsonResponse.Field.d("honorificPrefix", 6));
    o.put("honorificSuffix", FastJsonResponse.Field.d("honorificSuffix", 7));
    o.put("metadata", FastJsonResponse.Field.a("metadata", 8, DefaultMetadataImpl.class));
    o.put("middleName", FastJsonResponse.Field.d("middleName", 9));
    o.put("phoneticFamilyName", FastJsonResponse.Field.d("phoneticFamilyName", 10));
    o.put("phoneticGivenName", FastJsonResponse.Field.d("phoneticGivenName", 11));
    o.put("phoneticHonorificPrefix", FastJsonResponse.Field.d("phoneticHonorificPrefix", 12));
    o.put("phoneticHonorificSuffix", FastJsonResponse.Field.d("phoneticHonorificSuffix", 13));
  }
  
  public DefaultPersonImpl$Names()
  {
    b = 1;
    a = new HashSet();
  }
  
  public DefaultPersonImpl$Names(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, DefaultMetadataImpl paramDefaultMetadataImpl, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    a = paramSet;
    b = paramInt;
    c = paramString1;
    d = paramString2;
    e = paramString3;
    f = paramString4;
    g = paramString5;
    h = paramString6;
    i = paramDefaultMetadataImpl;
    j = paramString7;
    k = paramString8;
    l = paramString9;
    m = paramString10;
    n = paramString11;
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
      return c;
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
    }
    return n;
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
    if (!(paramObject instanceof Names)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (Names)paramObject;
    Iterator localIterator = o.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (((Names)paramObject).a(localField))
        {
          if (!b(localField).equals(((Names)paramObject).b(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((Names)paramObject).a(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = o.values().iterator();
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
      emj.a(paramParcel, 2, c, true);
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
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Names
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */